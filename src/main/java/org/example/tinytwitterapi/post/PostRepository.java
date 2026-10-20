package org.example.tinytwitterapi.post;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post,Long> {

    @Query("SELECT p FROM Post p WHERE p.postId = :id")
    @NonNull Optional<Post> findById(@NonNull @Param("id") Long id);

    @Modifying 
    @Query("SELECT COUNT(l) FROM Like l WHERE l.post.postId = :id")
    Integer likePost(@Param("id") Long id);

}
