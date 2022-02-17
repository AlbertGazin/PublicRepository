package main.repository;

import main.model.entities.Post;
import main.model.entities.PostVote;
import main.model.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostVoteRepository extends CrudRepository<PostVote, Integer> {
    @Query(value = "FROM PostVote" +
            "      WHERE post = ?1" +
            "        AND user = ?2")
    PostVote findByPostAndUser(Post post, User currentUser);
}
