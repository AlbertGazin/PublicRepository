package main.controller;

import main.api.request.*;
import main.api.response.*;
import main.service.PostService;
import main.service.SettingsService;
import main.service.UserRegistrationService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ApiPostController {

    private final PostService postService;

    private final UserRegistrationService userService;

    public ApiPostController(PostService postService, UserRegistrationService userService, SettingsService settingsService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping("/post")
    @PreAuthorize("hasAuthority('user:write')")
    public PostRegistrationResponse addPost(@RequestBody PostRequest post) {
        return postService.addNewPost(post);
    }

    @PostMapping("/comment")
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity<CommentResponse> addPostComment(@RequestBody CommentRequest commentRequest) {
        return postService.addCommentToPost(commentRequest);
    }

    @PostMapping("/moderation")
    @PreAuthorize("hasAuthority('user:moderate')")
    public ModerationResponse moderatePost(@RequestBody ModerationRequest request) {
        return postService.moderatePost(request);
    }

    @PostMapping("/post/like")
    @PreAuthorize("hasAuthority('user:write')")
    public PostLikeResponse likePost(@RequestBody PostLikesRequest request) {
        return postService.votePost(request, "like");
    }

    @PostMapping("/post/dislike")
    @PreAuthorize("hasAuthority('user:write')")
    public PostLikeResponse dislikePost(@RequestBody PostLikesRequest request) {
        return postService.votePost(request, "dislike");
    }

    @PostMapping(value = "/profile/my", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('user:write')")
    public EditProfileResponse editProfile(@RequestBody EditProfileRequest request) {
        return userService.editProfile(request);
    }

    @PostMapping(value = "/profile/my", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAuthority('user:write')")
    public EditProfileResponse editProfile(
            @RequestPart(name = "photo") MultipartFile photo,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String password) {
        return userService.editProfile(photo, name, email, password);
    }

    @PostMapping(value = "/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @PreAuthorize("hasAuthority('user:write')")
    public ResponseEntity uploadImage(@RequestParam("image") MultipartFile photo) {
        return postService.uploadImage(photo);
    }

    @PutMapping("/post/{id}")
    @PreAuthorize("hasAuthority('user:write')")
    public PostRegistrationResponse putPost(@PathVariable int id, @RequestBody PostRequest request) {
        return postService.updatePost(id, request);
    }
}