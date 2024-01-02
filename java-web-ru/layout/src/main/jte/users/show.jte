@import exercise.dto.users.UserPage

@param UserPage page

@template.layout.page(
    content = @`
        <p>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</p>
        <p>${page.getUser().getEmail()}</p>
    `
)
