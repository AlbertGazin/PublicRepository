package main.service;

import main.api.request.CommentRequest;
import main.api.request.ModerationRequest;
import main.api.request.PostLikesRequest;
import main.api.request.PostRequest;
import main.api.response.*;
import main.api.response.responsedto.*;
import main.model.entities.Post;
import main.model.entities.PostComment;
import main.model.entities.PostVote;
import main.model.entities.Tag;
import main.model.enumerated.ModerationStatus;
import main.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class PostService {
    @Value("${post.tooShortTextError}")
    private String tooShortTextError;

    @Value("${post.tooShortTitleError}")
    private String tooShortTitleError;

    @Value("${post.emptyTextError}")
    private String emptyTextError;

    @Value("${post.emptyTitleError}")
    private String emptyTitleError;

    @Value("${post.minimalLengthOfPostsText}")
    private int minimalLengthOfPostsText;

    @Value("${post.minimalLengthOfPostsTitle}")
    private int minimalLengthOfPostsTitle;

    @Value("${post.minimalLengthOfComment}")
    private int minimalLengthOfComment;

    @Value("${post.activePost}")
    private short activePost;

    @Value("${post.inactivePost}")
    private short inactivePost;

    private final ModerationStatus MODERATED_POST = ModerationStatus.ACCEPTED;
    private final ModerationStatus NEW_POST = ModerationStatus.NEW;
    private final ModerationStatus DECLINED_POST = ModerationStatus.DECLINED;

    @Value("${settings.statisticsIsPublic}")
    private String statisticsIsPublic;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository postCommentRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostVoteRepository postVoteRepository;

    @Autowired
    private GlobalSettingsRepository settingsRepository;

    @Autowired
    private ImageService imageService;

    public PostResponse getPosts(String mode, int offset, int limit) {
        int pageNumber = offset / limit;

        Pageable pageable = PageRequest.of(pageNumber, limit);

        return getPostResponseByPostList(getPage(mode, pageable).getContent(), (int) getPage(mode, pageable).getTotalElements());
    }

    public Page<Post> getPage(String mode, Pageable pageable) {
        switch (mode) {
            case "popular":
                return postRepository.findMostPopularPosts(activePost, MODERATED_POST, pageable);
            case "best":
                return postRepository.findBestPosts(activePost, MODERATED_POST, pageable);
            case "recent":
                return postRepository.findRecentPosts(activePost, MODERATED_POST, pageable);
            case "early":
                return postRepository.findEarlyPosts(pageable);
            default:
                throw new IllegalArgumentException("Mode not found");
        }
    }

    public PostResponse findPostByText(int offset, int limit, String text) {
        List<Post> posts;
        int pageNumber = offset / limit;

        Pageable pageable = PageRequest.of(pageNumber, limit);
        int count = 0;

        if (text.isEmpty() || text.replaceAll(" ", "").length() == 0) {
            posts = postRepository.findRecentPosts(activePost, MODERATED_POST, pageable).getContent();
            count = (int) postRepository.findRecentPosts(activePost, MODERATED_POST, pageable).getTotalElements();
        } else {
            posts = postRepository.findPostByText(activePost, MODERATED_POST, text, pageable).getContent();
            count = (int) postRepository.findPostByText(activePost, MODERATED_POST, text, pageable).getTotalElements();
        }

        return getPostResponseByPostList(posts, count);
    }

    public PostResponse getPostResponseByPostList(List<Post> postsPaging, int count) {
        PostResponse postResponse = new PostResponse();
        List<PostResponseDTO> postResponseDTOList = new ArrayList<>();

        if (postsPaging.size() == 0) {
            postResponse.setCount(0);
            postResponse.setPosts(postResponseDTOList);
            return postResponse;
        }

        for (Post post : postsPaging) {
            PostResponseDTO postResponseDTO = new PostResponseDTO(post);
            postResponseDTOList.add(postResponseDTO);
        }
        postResponse.setPosts(postResponseDTOList);
        postResponse.setCount(count);

        return postResponse;
    }

    public PostByYearResponse getPostCalendarInfo(int year) {
        PostByYearResponse post = new PostByYearResponse();
        Map<String, Long> postMap = new HashMap<>();
        List<PostCountByDateDTO> postCountByDate = postRepository.findPostCountByDate(
                activePost
                , MODERATED_POST
                , year);

        for (PostCountByDateDTO postCountByDateDTO : postCountByDate) {
            postMap.put(postCountByDateDTO.getDate(), postCountByDateDTO.getCount());
        }

        post.setPosts(postMap);
        post.setYears(postRepository.findYearsOfPosts());

        return post;
    }

    public PostResponse findPostByDate(int offset, int limit, String date) {
        List<Post> posts;
        int pageNumber = offset / limit;

        Pageable pageable = PageRequest.of(pageNumber, limit);
        posts = postRepository.findPostByDate(activePost, MODERATED_POST, date, pageable).getContent();
        int count = (int) postRepository.findPostByDate(activePost, MODERATED_POST, date, pageable).getTotalElements();

        return getPostResponseByPostList(posts, count);
    }

    public PostResponse findPostByTag(int offset, int limit, String tag) {
        List<Post> posts;
        int pageNumber = offset / limit;

        Pageable pageable = PageRequest.of(pageNumber, limit);
        posts = postRepository.findPostByTag(activePost, MODERATED_POST.toString(), tag, pageable).getContent();
        int count = (int) postRepository.findPostByTag(activePost, MODERATED_POST.toString(), tag, pageable)
                .getTotalElements();

        return getPostResponseByPostList(posts, count);
    }

    public ResponseEntity getPostById(int id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        main.model.entities.User currentUser = new main.model.entities.User();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            User user = (User) authentication.getPrincipal();
            currentUser = userRepository.findByEmail(user.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));
        }

        Post post;
        Post postById = postRepository.findPostById(id);

        long seconds;

        try {
            seconds = postById.getTime().getTime() / 1000;
        } catch (NullPointerException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        if (authentication instanceof AnonymousAuthenticationToken) {
            post = postRepository.findPostByIdAndStatus(activePost, MODERATED_POST, id);
            try {
                seconds = post.getTime().getTime() / 1000;
            } catch (NullPointerException e) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
        } else {
            if (postById.getUser().getId() == currentUser.getId()
                    || postById.getModerator().getId() == currentUser.getId()) {
                post = postById;
            } else {
                post = postRepository.findPostByIdAndStatus(activePost, MODERATED_POST, id);
                try {
                    seconds = post.getTime().getTime() / 1000;
                } catch (NullPointerException e) {
                    return new ResponseEntity(HttpStatus.NOT_FOUND);
                }
            }
        }

        List<PostComment> postComments = post.getComments();
        List<PostCommentDTO> commentDTOList = new ArrayList<>();
        List<String> postTagList = new ArrayList<>();

        for (PostComment postComment : postComments) {
            PostCommentDTO postCommentDTO = new PostCommentDTO(postComment);
            commentDTOList.add(postCommentDTO);
        }

        List<Tag> tags = post.getTags();
        for (Tag tag : tags) {
            postTagList.add(tag.getName());
        }

        PostByIdResponse postByIdResponse = new PostByIdResponse(
                post.getId(),
                seconds,
                post.getIsActive() == 1,
                new PostUserResponseDTO(post.getUser().getId(), post.getUser().getName()),
                post.getTitle(),
                post.getText(),
                (int) post.getVotes().stream().filter(v -> v.getValue() == 1).count(),
                (int) post.getVotes().stream().filter(v -> v.getValue() == -1).count(),
                post.getViewCount(),
                commentDTOList,
                postTagList
        );

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            if (!(post.getUser().getId() == currentUser.getId()) && !(post.getModerator().getId() == currentUser.getId())) {
                post.setViewCount(post.getViewCount() + 1);
            }
        }
        postRepository.save(post);

        return new ResponseEntity(postByIdResponse, HttpStatus.OK);
    }

    public PostResponse getPostsForModeration(int offset, int limit, String status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return new PostResponse();
        }

        User user = (User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        List<Post> allPostsOfUser = new ArrayList<>();
        int pageNumber = offset / limit;

        Pageable pageable = PageRequest.of(pageNumber, limit);
        int count = 0;

        switch (status) {
            case "new":
                allPostsOfUser = postRepository.findAllPostsByModStatusAndActivityStatus(
                        activePost
                        , NEW_POST
                        , pageable).getContent();
                count = (int) postRepository.findAllPostsByModStatusAndActivityStatus(
                        activePost
                        , NEW_POST
                        , pageable).getTotalElements();
                break;
            case "declined":
                allPostsOfUser = postRepository.findPostsByModeratorAndStatus(
                        DECLINED_POST
                        , activePost
                        , currentUser
                        , pageable).getContent();
                count = (int) postRepository.findPostsByModeratorAndStatus(
                        DECLINED_POST
                        , activePost
                        , currentUser
                        , pageable).getTotalElements();
                break;
            case "accepted":
                allPostsOfUser = postRepository.findPostsByModeratorAndStatus(
                        MODERATED_POST
                        , activePost
                        , currentUser
                        , pageable).getContent();
                count = (int) postRepository.findPostsByModeratorAndStatus(
                        MODERATED_POST
                        , activePost
                        , currentUser
                        , pageable).getTotalElements();
                break;
        }

        if (allPostsOfUser.size() == 0) {
            List<PostResponseDTO> mockList = new ArrayList<>();
            PostResponse response = new PostResponse();
            response.setPosts(mockList);
            return response;
        }

        return getPostResponseByPostList(allPostsOfUser, count);
    }

    public PostResponse findPostsByUserId(int offset, int limit, String status) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return new PostResponse();
        }

        User user = (User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        int pageNumber = offset / limit;

        Pageable pageable = PageRequest.of(pageNumber, limit);
        int count = 0;

        List<Post> posts = new ArrayList<>();
        switch (status) {
            case "inactive":
                posts = postRepository.findPostsByUserAndActivity(inactivePost, currentUser, pageable).getContent();
                count = (int) postRepository.findPostsByUserAndActivity(inactivePost, currentUser, pageable)
                        .getTotalElements();
                break;
            case "pending":
                posts = postRepository.findPostsByUserAndStatus(
                        NEW_POST, activePost, currentUser, pageable).getContent();
                count = (int) postRepository.findPostsByUserAndStatus(
                        NEW_POST, activePost, currentUser, pageable).getTotalElements();
                break;
            case "declined":
                posts = postRepository.findPostsByUserAndStatus(
                        DECLINED_POST, activePost, currentUser, pageable).getContent();
                count = (int) postRepository.findPostsByUserAndStatus(
                        DECLINED_POST, activePost, currentUser, pageable).getTotalElements();
                break;
            case "published":
                posts = postRepository.findPostsByUserAndStatus(
                        MODERATED_POST, activePost, currentUser, pageable).getContent();
                count = (int) postRepository.findPostsByUserAndStatus(
                        MODERATED_POST, activePost, currentUser, pageable).getTotalElements();
                break;
        }

        return getPostResponseByPostList(posts, count);
    }

    private boolean isTextTooShort(String text, String type) {
        if (type.equals("Text")) {
            return text.length() < minimalLengthOfPostsText;
        } else if (type.equals("Comment")) {
            return text.length() < minimalLengthOfComment;
        } else {
            return text.length() < minimalLengthOfPostsTitle;
        }
    }

    private boolean isTextLengthIsZero(String text) {
        return text.length() == 0;
    }

    public PostRegistrationResponse addNewPost(PostRequest post) {
        PostRegistrationResponse response = new PostRegistrationResponse();
        PostRegistrationErrorsDTO errors = new PostRegistrationErrorsDTO();
        Post newPost = new Post();

        if (isTextLengthIsZero(post.getText())) {
            errors.setText(emptyTextError);
            response.setErrors(errors);
            response.setResult(false);
            return response;
        }

        if (isTextLengthIsZero(post.getTitle())) {
            errors.setTitle(emptyTitleError);
            response.setErrors(errors);
            response.setResult(false);
            return response;
        }

        if (isTextTooShort(post.getText(), "Text")) {
            errors.setText(tooShortTextError);
            response.setErrors(errors);
            response.setResult(false);
            return response;
        }

        if (isTextTooShort(post.getTitle(), "Title")) {
            errors.setText(tooShortTitleError);
            response.setErrors(errors);
            response.setResult(false);
            return response;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return new PostRegistrationResponse();
        }

        User user = (User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        Date newPostDate = new Date(post.getTimestamp());

        if (newPostDate.before(new Date())) {
            newPostDate = new Date();
        }

        List<Tag> tags = new ArrayList<>();

        for (String userTag : post.getTags()) {
            Tag tag = tagRepository.findTagByName(userTag);
            try {
                String name = tag.getName();
            } catch (Exception e) {
                tag = new Tag(userTag);
                tagRepository.save(tag);
            }
            tags.add(tag);
        }

        newPost.setIsActive(post.getActive());
        if (currentUser.getIsModerator() == 0) {
            newPost.setModerationStatus(ModerationStatus.NEW);
        } else {
            newPost.setModerationStatus(ModerationStatus.ACCEPTED);
        }
        newPost.setUser(currentUser);
        newPost.setTime(newPostDate);

        newPost.setTitle(post.getTitle());
        newPost.setText(post.getText());
        newPost.setTags(tags);

        postRepository.save(newPost);
        response.setResult(true);
        return response;
    }

    public PostRegistrationResponse updatePost(int id, PostRequest request) {
        PostRegistrationResponse response = new PostRegistrationResponse();
        PostRegistrationErrorsDTO errors = new PostRegistrationErrorsDTO();
        Post postToUpdate = postRepository.findPostById(id);

        if (isTextLengthIsZero(request.getText())) {
            errors.setText(emptyTextError);
            response.setErrors(errors);
            response.setResult(false);
            return response;
        }

        if (isTextLengthIsZero(request.getTitle())) {
            errors.setTitle(emptyTitleError);
            response.setErrors(errors);
            response.setResult(false);
            return response;
        }

        if (isTextTooShort(request.getText(), "Text")) {
            errors.setText(tooShortTextError);
            response.setErrors(errors);
            response.setResult(false);
            return response;
        }

        if (isTextTooShort(request.getTitle(), "Title")) {
            errors.setText(tooShortTitleError);
            response.setErrors(errors);
            response.setResult(false);
            return response;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return response;
        }

        User user = (User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        Date postsNewDate = new Date(request.getTimestamp());

        if (postsNewDate.before(new Date())) {
            postsNewDate = new Date();
        }

        List<Tag> tags = new ArrayList<>();

        for (String userTag : request.getTags()) {
            Tag tag = tagRepository.findTagByName(userTag);
            tags.add(tag);
        }

        try {
            postToUpdate.getTitle();
        } catch (NullPointerException e) {
            return response;
        }

        postToUpdate.setIsActive(request.getActive());
        if (postToUpdate.getUser().getId() == currentUser.getId() && currentUser.getIsModerator() == 0) {
            postToUpdate.setModerationStatus(ModerationStatus.NEW);
        }
        postToUpdate.setUser(currentUser);
        postToUpdate.setTime(new Date());

        postToUpdate.setTitle(request.getTitle());
        postToUpdate.setText(request.getText());
        postToUpdate.setTags(tags);

        postRepository.save(postToUpdate);
        response.setResult(true);
        return response;
    }

    public ResponseEntity<CommentResponse> addCommentToPost(CommentRequest commentRequest) {
        CommentResponse response = new CommentResponse();
        CommentRegistrationErrorsDTO errors = new CommentRegistrationErrorsDTO();
        try {
            String title = postRepository.findPostById(commentRequest.getPostId()).getTitle();
        } catch (NullPointerException e) {
            response.setResult(false);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        if (commentRequest.getParentId() != 0) {
            if (postCommentRepository.findById(commentRequest.getParentId()).isEmpty()) {
                response.setResult(false);
                return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
            }
        }
        if (isTextTooShort(commentRequest.getText(), "Comment") || commentRequest.getText().length() == 0) {
            errors.setText(tooShortTextError);
            response.setErrors(errors);
            response.setResult(false);
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }

        User user = (User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        PostComment comment = new PostComment();
        comment.setText(commentRequest.getText());
        comment.setPost(postRepository.findPostById(commentRequest.getPostId()));
        comment.setTime(new Date());
        comment.setUser(currentUser);
        if (!String.valueOf(commentRequest.getParentId()).isEmpty()) {
            comment.setParentId(commentRequest.getParentId());
        }
        int id = postCommentRepository.save(comment).getId();

        response.setId(id);
        response.setResult(true);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    public ModerationResponse moderatePost(ModerationRequest request) {
        ModerationResponse response = new ModerationResponse();
        response.setResult(true);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return new ModerationResponse();
        }

        User user = (User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        Post post = postRepository.findPostById(request.getPostId());

        try {
            post.getTitle();
        } catch (NullPointerException e) {
            return new ModerationResponse();
        }

        ModerationStatus status = ModerationStatus.NEW;
        if (request.getDecision().equals("accept")) {
            status = ModerationStatus.ACCEPTED;
        }
        if (request.getDecision().equals("decline")) {
            status = ModerationStatus.DECLINED;
        }
        if (status.toString().equals("NEW")) {
            return new ModerationResponse();
        }

        Date postsNewDate = post.getTime();

        if (postsNewDate.before(new Date())) {
            postsNewDate = new Date();
        }
        post.setTime(postsNewDate);
        post.setModerator(currentUser);
        post.setModerationStatus(status);
        postRepository.save(post);

        return response;
    }

    public PostStatisticsResponse getMyStatistics() {
        PostStatisticsResponse response = new PostStatisticsResponse();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return new PostStatisticsResponse();
        }

        User user = (User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        List<Post> posts = postRepository.findAllPostsByUser(currentUser);

        int postsCount = posts.size();
        int likesCount = 0;
        int dislikesCount = 0;
        int viewCount = 0;
        long firstPublication = new Date().getTime() / 1000;

        for (Post post : posts) {
            likesCount += post.getVotes().stream().filter(v -> v.getValue() == 1).count();
            dislikesCount += post.getVotes().stream().filter(v -> v.getValue() == -1).count();
            viewCount += post.getViewCount();
            firstPublication = Math.min(firstPublication, post.getTime().getTime() / 1000);
        }

        response.setPostsCount(postsCount);
        response.setLikesCount(likesCount);
        response.setDislikesCount(dislikesCount);
        response.setViewsCount(viewCount);
        response.setFirstPublication(firstPublication);
        return response;
    }

    public ResponseEntity<PostStatisticsResponse> getAllStatistics() {
        PostStatisticsResponse response = new PostStatisticsResponse();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return new ResponseEntity(response, HttpStatus.FORBIDDEN);
        }

        User user = (User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        if (currentUser.getIsModerator() != 1
                || (settingsRepository.findByCode(statisticsIsPublic))
                .orElseThrow(() -> new UsernameNotFoundException(statisticsIsPublic))
                .getValue().equals("NO")) {
            return new ResponseEntity(response, HttpStatus.UNAUTHORIZED);
        }

        Iterable<Post> posts = postRepository.findAll();

        int postsCount = 0;
        int likesCount = 0;
        int dislikesCount = 0;
        int viewCount = 0;
        long firstPublication = new Date().getTime() / 1000;

        for (Post post : posts) {
            postsCount++;
            likesCount += post.getVotes().stream().filter(v -> v.getValue() == 1).count();
            dislikesCount += post.getVotes().stream().filter(v -> v.getValue() == -1).count();
            viewCount += post.getViewCount();
            firstPublication = Math.min(firstPublication, post.getTime().getTime() / 1000);
        }

        response.setPostsCount(postsCount);
        response.setLikesCount(likesCount);
        response.setDislikesCount(dislikesCount);
        response.setViewsCount(viewCount);
        response.setFirstPublication(firstPublication);

        return new ResponseEntity(response, HttpStatus.OK);
    }

    public PostLikeResponse votePost(PostLikesRequest request, String voteType) {
        PostLikeResponse response = new PostLikeResponse();
        PostVote postVote = new PostVote();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return response;
        }

        User user = (User) authentication.getPrincipal();
        main.model.entities.User currentUser = userRepository.findByEmail(user.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(user.getUsername()));

        Post post = postRepository.findPostById(request.getPostId());
        List<PostVote> postVotes = post.getVotes();


        for (PostVote vote : postVotes) {
            if ((voteType.equals("like") && vote.getUser() == currentUser && vote.getValue() == 1)
                    || (voteType.equals("dislike") && vote.getUser() == currentUser && vote.getValue() == -1)) {
                return response;
            }

            if ((voteType.equals("dislike") && vote.getUser() == currentUser && vote.getValue() == 1)
                    || (voteType.equals("like") && vote.getUser() == currentUser && vote.getValue() == -1)) {
                postVote = postVoteRepository.findByPostAndUser(post, currentUser);
            }
        }

        postVote.setPost(post);
        postVote.setTime(new Date());
        postVote.setUser(currentUser);
        postVote.setValue(voteType.equals("like") ? (short) 1 : (short) -1);
        postVoteRepository.save(postVote);

        response.setResult(true);
        return response;
    }

    public ResponseEntity uploadImage(MultipartFile photo) {
        return imageService.uploadImage(photo, false);
    }
}