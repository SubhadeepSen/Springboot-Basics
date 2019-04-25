package api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.builder.PostBuilder;
import api.exception.NoDataFoundException;
import api.model.Post;

@Service
public class PostService {

	@Autowired
	private PostBuilder postBuilder;

	public List<Post> getPosts() throws NoDataFoundException {
		List<Post> posts = postBuilder.buildPosts();
		if(!posts.isEmpty())
			return posts;
		throw new NoDataFoundException("No data found!");
	}
}
