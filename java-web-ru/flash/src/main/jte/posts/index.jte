@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
    @if(page != null && page.getPosts() != null)
        <ul>
            @for(var post : page.getPosts())
                <li>
                    <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                </li>
            @endfor
        </ul>
    @else
        <p>Posts list is empty</p>
    @endif
    `
)
