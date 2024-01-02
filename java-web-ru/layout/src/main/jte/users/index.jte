@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        @if (page.getUsers().isEmpty())
            <p>Users not found</p>
        @else
            <table class="table">
                <thead>
                <td>ID</td>
                <td>Full name</td>
                <td>Email</td>
                </thead>
                @for(var user : page.getUsers())
                    <tr>
                        <td>${user.getId()}</td>
                        <td>
                            <a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a>
                        </td>
                        <td>${user.getEmail()}</td>
                    </tr>
                @endfor
            </table>
        @endif
    `
)
