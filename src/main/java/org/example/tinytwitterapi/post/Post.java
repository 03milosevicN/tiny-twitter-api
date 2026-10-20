package org.example.tinytwitterapi.post;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.Data;
import org.example.tinytwitterapi.like.Like;
import org.example.tinytwitterapi.tags.Tag;

@Data 
@Entity
@Table(name = "posts")
public class Post {
    
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String content;

    @Column(name = "created_at")
    private Instant createdAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Like> likes = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "posts_tags",
            joinColumns = @JoinColumn(name = "postId"),
            inverseJoinColumns = @JoinColumn(name = "tagId")
    )
    private List<Tag> tags = new ArrayList<>();

}
