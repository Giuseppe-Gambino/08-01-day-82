package it.epicode.blogApi.services;

import it.epicode.blogApi.entity.BlogPost;
import it.epicode.blogApi.repo.BlogPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogPostSvc {
    private final BlogPostRepository blogPostRepo;


    public List<BlogPost> getAllPosts() {
        return blogPostRepo.findAll();
    }

    public Optional<BlogPost> findById(Long id) {
        return blogPostRepo.findById(id);
    }

    public BlogPost savePost(BlogPost blogPost) {
        return blogPostRepo.save(blogPost);
    }

    public BlogPost editPost(Long id, BlogPost blogPost) {

        BlogPost existingPost = blogPostRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("BlogPost with ID " + id + " not found"));

        BeanUtils.copyProperties(blogPost, existingPost, "id");


        return blogPostRepo.save(existingPost);
    }


    public void deletePost(Long id) {
        blogPostRepo.deleteById(id);
    }

}
