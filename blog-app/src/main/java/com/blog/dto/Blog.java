package com.blog.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Blog {
	private Long id;
	private String title;
	private String content;
	
	private List<Comment> listComments;
}

