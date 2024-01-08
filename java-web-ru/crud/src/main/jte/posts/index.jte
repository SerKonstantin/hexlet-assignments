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
                    <a class="page-link"href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() < 2 ? 1 : page.getCurrentPage() - 1}">Previous</a>
                </li>

<%--                First variant that showed all page numbers   --%>
<%--                @for(var i = 1; i <= page.getTotalPages(); i++)--%>
<%--                    <li class="page-item @if(page.getCurrentPage() == i) active @endif">--%>
<%--                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${i}">${i}</a>--%>
<%--                    </li>--%>
<%--                @endfor--%>

                @if(page.getTotalPages() <= 5)
                    @for(var i = 1; i <= page.getTotalPages(); i++)
                        <li class="page-item @if(page.getCurrentPage() == i) active @endif">
                            <a class="page-link" href="${NamedRoutes.postsPath()}?page=${i}">${i}</a>
                        </li>
                    @endfor
                @else
                    @if(page.getCurrentPage() > 2)
                        <li class="page-item">
                            <a class="page-link" href="${NamedRoutes.postsPath()}?page=1">1</a>
                        </li>
                        @if(page.getCurrentPage() > 3)
                            <li class="page-item disabled">
                                <a class="page-link" href="#">...</a>
                            </li>
                        @endif
                    @endif

                    @for(var i = page.getCurrentPage() - 2; i <= page.getCurrentPage() + 2; i++)
                        @if(i > 0 && i <= page.getTotalPages())
                            <li class="page-item @if(page.getCurrentPage() == i) active @endif">
                                <a class="page-link" href="${NamedRoutes.postsPath()}?page=${i}">${i}</a>
                            </li>
                        @endif
                    @endfor

                    @if(page.getCurrentPage() < page.getTotalPages() - 2)
                        @if(page.getCurrentPage() < page.getTotalPages() - 3)
                            <li class="page-item disabled">
                                <a class="page-link" href="#">...</a>
                            </li>
                        @endif
                        <li class="page-item">
                            <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getTotalPages()}">${page.getTotalPages()}</a>
                        </li>
                    @endif
                @endif

                <li class="page-item">
                    <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() >= page.getTotalPages() ? page.getTotalPages() : page.getCurrentPage() + 1}">Next</a>
                </li>
            </ul>
        </nav>
    </div>
`
)