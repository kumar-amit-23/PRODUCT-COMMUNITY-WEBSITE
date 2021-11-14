package com.nagarro.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.model.Comment;
import com.nagarro.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repo;
	
	public Optional<Comment> getCommentByID(int id) {
		return repo.findById(id);
	}
	
	public Comment saveComment(Comment comment) {
		return repo.save(comment);
	}

}
