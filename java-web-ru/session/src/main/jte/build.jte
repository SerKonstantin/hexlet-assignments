@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
    content = @`
    <div class="m-5">
        @if(page != null && page.getError() != null)
            <p>${page.getError()}</p>
        @endif

        <form action="${NamedRoutes.loginPath()}" method="post">
            <label>
                Имя
                <input type="text" required placeholder="Name" name="name">
            </label>
            <label>
                Пароль
                <input type="password" required placeholder="Password" name="password">
            </label>
            <input type="submit" value="Войти">
        </form>
    </div>
    `
)
