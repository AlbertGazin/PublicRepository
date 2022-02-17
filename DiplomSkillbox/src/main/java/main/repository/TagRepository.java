package main.repository;

import main.model.entities.Post;
import main.model.entities.Tag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {
    @Query(value = "FROM Tag t" +
            "      WHERE t.name like ?1%")
    List<Tag> findTagsByPartOfName(String tagName);

    @Query(value = "FROM Tag t" +
            "      WHERE t.name = ?1")
    Tag findTagByName(String tagName);

    @Query(value = "SELECT *" +
            "         FROM tags" +
            "        WHERE id = (" +
            "                    SELECT id" +
            "                      FROM (" +
            "                            SELECT f.id, count(*) as cc" +
            "                              FROM tags_to_post t " +
            "                                                   INNER JOIN tags f ON f.id = t.tag_id" +
            "                                                   INNER JOIN posts p ON p.id = t.post_id" +
            "                             WHERE p.is_active = 1" +
            "                               AND p.moderation_status = 'ACCEPTED'" +
            "                          GROUP BY f.id" +
            "                          ORDER BY 2 desc" +
            "                          ) m" +
            "                    LIMIT 1" +
            "                  )", nativeQuery = true)
    Tag findMostPopularTagNative();

    @Query(value = "SELECT t.posts" +
            "         FROM Tag t" +
            "        WHERE t.id = ?1")
    List<Post> findPostsByTagId(int tagId);
}
