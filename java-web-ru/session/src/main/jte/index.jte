@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
    content = @`
    <div class="m-5">
        @if(page.getName() != null)
            <h2>${page.getName().toString()}</h2>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <input type="submit" value="Выйти">
            </form>
        @else
            <a href="${NamedRoutes.buildSessionPath()}">Войти</a>
        @endif
    </div>
    `
)
