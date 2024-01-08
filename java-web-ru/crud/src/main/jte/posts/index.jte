@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <ul>
            @for(var post : page.getPosts())
                <li><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></li>
            @endfor
        </ul>

        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link"href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() - 1}">Previous</a>
                </li>

                @for(var i = 1; i <= page.getTotalPages(); i++)
                    <li class="page-item @if(page.getCurrentPage() == i) active @endif">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${i}">${i}</a>
                    </li>
                @endfor

                <li class="page-item">
                    <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() + 1}">Next</a>
                </li>
            </ul>
        </nav>
    </div>
`
)