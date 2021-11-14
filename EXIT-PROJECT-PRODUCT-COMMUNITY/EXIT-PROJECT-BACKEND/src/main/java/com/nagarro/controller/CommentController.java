package com.nagarro.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.model.Comment;
import com.nagarro.service.CommentService;

@RestController
public class CommentController {
	
	@Autowired
	private CommentService service;
	
	@GetMapping("/comments/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public Optional<Comment> getComments(@PathVariable("id") int id) {
		return this.service.getCommentByID(id);
	}
	
	@PostMapping("/comments")
	@CrossOrigin(origins = "http://localhost:4200")
	public Comment saveComment(@RequestBody Comment comment) {
		return this.service.saveComment(comment);
	}
}
