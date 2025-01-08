package it.epicode.blogApi.controller;

import it.epicode.blogApi.entity.BlogPost;
import it.epicode.blogApi.services.BlogPostSvc;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class BlogPostController {

    @Autowired
    private BlogPostSvc blogPostSvc;

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAll() {
        return ResponseEntity.ok(blogPostSvc.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(blogPostSvc.findById(id));
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping
    public ResponseEntity<?> savePost(@RequestBody BlogPost blogPost) {
        return new ResponseEntity<>(blogPostSvc.savePost(blogPost), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    private ResponseEntity<?> editPost(@PathVariable Long id, @RequestBody BlogPost blogPost) {
        return ResponseEntity.ok(blogPostSvc.editPost(id, blogPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        blogPostSvc.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
