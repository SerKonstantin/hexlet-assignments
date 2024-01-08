package exercise.controller;

import java.util.Collections;
//import java.util.List;
//import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
//import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        try {
            var id = ctx.pathParamAsClass("{id}", Long.class).get();

            var post = PostRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("Page not found"));

            var page = new PostPage(post);
            ctx.render("posts/show.jte", Collections.singletonMap("page", page));
        } catch (ValidationException e) {
            throw new NotFoundResponse("Page not found");
        }
    }

    public static void index(Context ctx) {
        var postsPerPage = 5;
        var currentPage = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var allPosts = PostRepository.getEntities();
        var totalPages = (int) Math.ceil((double) allPosts.size() / postsPerPage);

        var startIndex = (currentPage - 1) * postsPerPage;
        var endIndex = Math.min(startIndex + postsPerPage, allPosts.size());
        var posts = allPosts.subList(startIndex, endIndex);

        var page = new PostsPage(posts, totalPages, currentPage);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }
    // END
}
