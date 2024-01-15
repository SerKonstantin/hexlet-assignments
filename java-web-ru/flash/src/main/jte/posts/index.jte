@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
    @if(page.getPosts().isEmpty())
        <p>Posts list is empty</p>
    @else
        <h1>Все посты</h1>

        <div class="mb-3">
            <a href="${NamedRoutes.buildPostPath()}">Создать новый пост</a>
        </div>

        <ul>
            @for(var post : page.getPosts())
                <li>
                    <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                </li>
            @endfor
        </ul>
    @endif
    `
)
