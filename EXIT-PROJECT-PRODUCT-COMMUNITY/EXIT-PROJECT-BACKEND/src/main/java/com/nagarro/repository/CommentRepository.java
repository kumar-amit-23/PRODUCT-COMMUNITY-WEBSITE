package com.nagarro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
