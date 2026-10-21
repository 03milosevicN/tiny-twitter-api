package org.example.tinytwitterapi.views;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ViewCountRepository extends JpaRepository<ViewCount, Long> {

    @Modifying
    @Query("SELECT COUNT(vl) From ViewCount vl where vl.post.postId = :id")
    Long getPostViewCount(@Param("id") Long id);

}
