package api.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import api.endpoint.PostEnpoint;
import api.exception.NoDataFoundException;
import api.model.Post;
import api.service.PostService;

@Controller
public class PostController implements PostEnpoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);

	@Autowired
	private PostService postService;

	public ResponseEntity<List<Post>> getPosts() {
		try {
			return new ResponseEntity<List<Post>>(postService.getPosts(), HttpStatus.OK);
		} catch (NoDataFoundException e) {
			LOGGER.info("Posts ---> " + e.getMessage());
		}
		return new ResponseEntity<List<Post>>(new ArrayList<>(), HttpStatus.NOT_FOUND);
	}

}
