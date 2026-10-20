package org.example.tinytwitterapi.tags;

import jakarta.persistence.*;
import lombok.Data;
import org.example.tinytwitterapi.post.Post;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @Column(name = "tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(name = "hashtag")
    private String hashtag;

    @ManyToMany(mappedBy = "tags")
    private List<Post> posts = new ArrayList<>();

}
