package com.myblog.blogapp.controller;


import com.myblog.blogapp.payload.PostDto;
import com.myblog.blogapp.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;



    public PostController(PostService postService) {
        this.postService = postService;
    }


    public ResponseEntity<PostDto>createPost(@RequestBody PostDto postDto){
     return new ResponseEntity<> (postService.createPost(postDto), HttpStatus.CREATED);


    }
@GetMapping
public List<PostDto> getAllPosts(){

  List<PostDto>  postDtos   = postService.getAllPosts();
    return postDtos;
}


//Interview question: Sir when converting entity to dto i used stream api map in map i used functional interface functional interface

//get by id is here
    @GetMapping("{id}")
    public ResponseEntity<PostDto>getPostById(@PathVariable("id") long id){

       PostDto dto = postService.getPostBYId(id);

        return ResponseEntity.ok(postService.getPostBYId(id));
    }



    //update features module
    //http://localhost:8080/api/posts/1
    @PutMapping("/{id}")
    public  ResponseEntity<PostDto>updatePost(@RequestBody PostDto postDto ,@PathVariable("id") long id){


          PostDto dto= postService.updatePost(postDto,id);

        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
