package org.example.tinytwitterapi.post;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.example.tinytwitterapi.like.Like;
import org.example.tinytwitterapi.tags.Tag;
import org.example.tinytwitterapi.views.ViewCount;

@Data 
@Entity
@Table(name = "posts")
public class Post {
    
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(name = "content")
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

    @JsonIgnore
    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ViewCount> viewCount = new HashSet<>();

}
