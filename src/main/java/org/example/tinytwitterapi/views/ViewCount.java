package org.example.tinytwitterapi.views;

import jakarta.persistence.*;
import lombok.Data;
import org.example.tinytwitterapi.post.Post;

import java.time.Instant;

@Data
@Entity
@Table(name = "view_count")
public class ViewCount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "view_count_id")
    private Long viewCountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "postId")
    private Post post;

    @Column(name = "viewed_at")
    private Instant viewedAt;

}
