package com.albertgazin.spring.springbootapp.repositories;

import com.albertgazin.spring.springbootapp.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
