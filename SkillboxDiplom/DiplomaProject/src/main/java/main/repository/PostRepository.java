package main.repository;

import main.api.response.responsedto.PostCountByDateDTO;
import main.model.entities.Post;
import main.model.entities.User;
import main.model.enumerated.ModerationStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>, PagingAndSortingRepository<Post, Integer> {

    @Query(value = "FROM Post t" +
            "      WHERE t.isActive = ?1" +
            "        AND t.moderationStatus = ?2" +
            "        AND t.time <= current_time()" +
            "   ORDER BY t.comments.size DESC")
    Page<Post> findMostPopularPosts(
            short isActive
            , ModerationStatus moderationStatus
            , Pageable pageable);

    @Query(value = "FROM Post t" +
            "      WHERE t.isActive = ?1" +
            "        AND t.moderationStatus = ?2" +
            "        AND t.time <= current_time()" +
            "   ORDER BY t.votes.size DESC")
    Page<Post> findBestPosts(
            short isActive
            , ModerationStatus moderationStatus
            , Pageable pageable);

    @Query(value = "FROM Post p" +
            "      WHERE p.isActive = ?1" +
            "        AND p.moderationStatus = ?2" +
            "        AND p.time <= current_time()" +
            "   ORDER BY p.time DESC")
    Page<Post> findRecentPosts(
            short isActive
            , ModerationStatus moderationStatus
            , Pageable pageable);

    @Query(value = "FROM Post p" +
            "      WHERE p.isActive = 1" +
            "        AND p.moderationStatus = 'ACCEPTED'" +
            "   ORDER BY p.time ASC")
    Page<Post> findEarlyPosts(Pageable pageable);

    @Query(value = "FROM Post p" +
            "      WHERE p.isActive = ?1" +
            "        AND p.moderationStatus = ?2")
    Page<Post> findAllPostsByModStatusAndActivityStatus(short isActive, ModerationStatus modStatus, Pageable pageable);

    @Query(value = "FROM Post p" +
            "      WHERE p.isActive = ?1" +
            "        AND p.moderationStatus = ?2")
    List<Post> findAllPostsByModStatusAndActivityStatus(short isActive, ModerationStatus modStatus);

    @Query(value = "FROM Post p" +
            "      WHERE p.isActive = ?1" +
            "        AND p.moderationStatus = ?2" +
            "        AND p.text like %?3%" +
            "        AND p.time <= current_time()"
    )
    Page<Post> findPostByText(short isActive
            , ModerationStatus moderationStatus
            , String text
            , Pageable pageable);

    @Query(value = "SELECT distinct function('YEAR', p.time)" +
            "         FROM Post p" +
            "        WHERE p.isActive = 1" +
            "          AND p.moderationStatus = 'ACCEPTED'")
    List<String> findYearsOfPosts();

    @Query(value = "SELECT new main.api.response.responsedto.PostCountByDateDTO(DATE_FORMAT(p.time, '%Y-%m-%d'), count(*))" +
            "         FROM Post p" +
            "        WHERE p.isActive = ?1" +
            "          AND p.moderationStatus = ?2" +
            "          AND function('YEAR', p.time) = ?3" +
            "          AND p.time <= current_time()" +
            "     GROUP BY p.time")
    List<PostCountByDateDTO> findPostCountByDate(
            short isActive
            , ModerationStatus moderationStatus
            , int year);

    @Query(value = "FROM Post p" +
            "      WHERE p.isActive = ?1" +
            "        AND p.moderationStatus = ?2" +
            "        AND DATE_FORMAT(p.time, '%Y-%m-%d') = ?3" +
            "        AND p.time <= current_time()")
    Page<Post> findPostByDate(
            short isActive
            , ModerationStatus moderationStatus
            , String date
            , Pageable pageable);

    @Query(value = "SELECT p.*" +
            "         FROM posts p" +
            "                     INNER JOIN tags_to_post t ON t.post_id = p.id" +
            "                     INNER JOIN tags r ON r.id = t.tag_id" +
            "        WHERE p.is_active = ?1" +
            "          AND p.moderation_status = ?2" +
            "          AND r.name = ?3" +
            "          AND p.time <= current_time()", nativeQuery = true)
    Page<Post> findPostByTag(
            short isActive
            , String moderationStatus
            , String tag
            , Pageable pageable);

    @Query(value = "FROM Post p" +
            "      WHERE p.isActive = ?1" +
            "        AND p.moderationStatus = ?2" +
            "        AND p.id = ?3" +
            "        AND p.time <= current_time()")
    Post findPostByIdAndStatus(
            short isActive
            , ModerationStatus moderationStatus
            , int id);

    @Query(value = "FROM Post p" +
            "      WHERE p.id = ?1")
    Post findPostById(int id);

    @Query(value = "FROM Post p" +
            "      WHERE p.isActive = ?1" +
            "        AND p.user = ?2")
    Page<Post> findPostsByUserAndActivity(short isActive, User user, Pageable pageable);

    @Query(value = "FROM Post p" +
            "      WHERE p.moderationStatus = ?1" +
            "        AND p.isActive = ?2" +
            "        AND p.user = ?3")
    Page<Post> findPostsByUserAndStatus(ModerationStatus modStatus, short isActive, User user, Pageable pageable);

    @Query(value = "FROM Post p" +
            "      WHERE p.moderationStatus = ?1" +
            "        AND p.isActive = ?2" +
            "        AND p.moderator = ?3")
    Page<Post> findPostsByModeratorAndStatus(ModerationStatus modStatus, short isActive, User user, Pageable pageable);

    @Query(value = "FROM Post p" +
            "      WHERE p.user = ?1")
    List<Post> findAllPostsByUser(User user);
}
