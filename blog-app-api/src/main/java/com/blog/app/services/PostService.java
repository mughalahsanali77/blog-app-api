package com.blog.app.services;

import java.util.List;
import com.blog.app.payloads.PostDto;
import com.blog.app.payloads.PostResponse;

public interface PostService {
	PostDto createPost(PostDto postDto,Long userId,Long categoryId);
	PostDto updatePost(PostDto postDto ,Long postId);
	void deletePost(Long postId);
	PostResponse getAll(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	PostDto getPostById(Long postId);
	PostResponse getPostByCategory(Long categoryId,Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	PostResponse getPostByUser(Long id,Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	List<PostDto> searchPost(String keyword);

}
