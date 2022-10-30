package com.example.prkt5upseva.Repository;
import com.example.prkt5upseva.Models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    Post findByNameContaining (String name);
}