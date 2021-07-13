package com.blog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.dto.Blog;
import com.blog.dto.Comment;

@RestController
public class BlogController {

	List<Blog> list = new ArrayList<>();
	// Map<Blog, List<Comment>> blogCommnents = new HashMap();

	static long count = 1;

	@PostMapping(value = "/blog", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> createNewBlog(@RequestBody Blog blog) {

		ResponseEntity<Blog> responseEntity = null;
		try {
			String title = blog.getTitle();
			String content = blog.getContent();
			if (title != null && !title.equals("") || content != null && !content.equals("")) {
				blog.setId(count);
				list.add(blog);
				count = ++count;
				responseEntity = new ResponseEntity<Blog>(blog, HttpStatus.CREATED);
			} else {
				responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@GetMapping(value = "/blog/{blogId}")
	public ResponseEntity<Blog> getBlogById(@PathVariable(value = "blogId") Long blogid) {
		ResponseEntity<Blog> responseEntity = null;
		Blog tempBlog = null;
		try {

			for (int i = 0; i < list.size(); i++) {
				if (blogid == list.get(i).getId()) {
					tempBlog = list.get(i);
					responseEntity = new ResponseEntity<Blog>(tempBlog, HttpStatus.CREATED);
				}
			}
			if (tempBlog == null)
				responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return responseEntity;

	}

	@PutMapping(value = "/blog/{blogId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Blog> updateBlog(@PathVariable(value = "blogId") Long blogId, @RequestBody Blog updatedBlog) {

		ResponseEntity<Blog> responseEntity = null;
		try {
			boolean isUpdated = false;
			for (int i = 0; i < list.size(); i++) {
				if (blogId == list.get(i).getId()) {
					updatedBlog.setId(blogId);
					list.set(i, updatedBlog);
					isUpdated = true;
					responseEntity = new ResponseEntity<Blog>(updatedBlog, HttpStatus.CREATED);
				}
			}

			if (!isUpdated)
				responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@DeleteMapping(value = "/blog/{blogId}")
	public ResponseEntity<Boolean> deleteBlogById(@PathVariable(value = "blogId") Long blogId) {
		ResponseEntity<Boolean> responseEntity = null;
		boolean isDeleted = false;
		try {
			for (int i = 0; i < list.size(); i++) {
				if (blogId == list.get(i).getId()) {
					list.remove(i);
					isDeleted = true;
					responseEntity = new ResponseEntity<>(isDeleted, HttpStatus.CREATED);
					isDeleted = true;
				}
			}
			if (!isDeleted)
				responseEntity = new ResponseEntity<>(isDeleted, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@PostMapping(value = "/blog/{blogId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comment> postNewCommentOnBlog(@PathVariable(value = "blogId") Long blogId,
			@RequestBody Comment comment) {
		ResponseEntity<Comment> responseEntity = null;
		boolean isValidBlog = false;
		try {
			for (int i = 0; i < list.size(); i++) {
				Blog blogFromList = list.get(i);
				if (blogId == blogFromList.getId()) {

					List<Comment> commentlist = blogFromList.getListComments();
					if (commentlist == null) {
						commentlist = new ArrayList();
						comment.setId(1l);
					} else {
						Comment lastCommentFromCollection = commentlist.get(commentlist.size() - 1);
						long increment = lastCommentFromCollection.getId() + 1;
						comment.setId(increment);

					}
					comment.setBlogId(blogId);
					commentlist.add(comment);

					blogFromList.setListComments(commentlist);
					list.set(i, blogFromList);

					isValidBlog = true;
					responseEntity = new ResponseEntity<>(comment, HttpStatus.CREATED);
				}
			}
			if (!isValidBlog)
				responseEntity = new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		} catch (Exception e) {
			responseEntity = new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

 
	@GetMapping(value = "/check")
	public ResponseEntity<Blog> check() {
		ResponseEntity<Blog> responseEntity = null;
		Blog tempBlog = new Blog();
		responseEntity = new ResponseEntity<>(tempBlog, HttpStatus.OK);

		return responseEntity;

	}

	@GetMapping(value = "/blogs")
	public ResponseEntity<List<Blog>> allBlogs() {
		ResponseEntity<List<Blog>> responseEntity = null;
		responseEntity = new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

}
