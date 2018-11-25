package com.mgmtp.blog.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mgmtp.blog.model.User;
import com.mgmtp.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mgmtp.blog.model.Post;
import com.mgmtp.blog.service.PostService;

@Controller
public class SearchController {
	
	@Autowired
	//PostService postService;
	UserService userService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String showSearchResult(Model model, HttpServletRequest request, HttpServletResponse response) {
		String query = request.getParameter("query");
		
		//redirect to index with empty query
		if(query.length() == 0) return "redirect:/";
		
		//List<Post> posts;
		List<User> users;

		//posts = (List<Post>) postService.findByTitle(query);


		query = "%" + query + "%";
		users = (List<User>) userService.findByUsername(query);
	    model.addAttribute("searchquery", query);
		//model.addAttribute("posts", posts);
		model.addAttribute("users", users);
	    return "search";
	}
}
