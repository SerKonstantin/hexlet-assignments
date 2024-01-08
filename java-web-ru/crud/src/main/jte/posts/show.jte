@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
    content = @`
        <a href="${NamedRoutes.postsPath()}">Return to posts</a>

        <div class="mx-auto p-4 py-md-5">
            <h2>${page.getPost().getName()}</h2>
            <p>${page.getPost().getBody()}</p>
        </div>
    `
)
