@template.layout.page(
    content = @`
        <form class="text-center" action="/users" method="post">
            <div>
                <label class="form-group m-2 w-25 text-start">
                    First name
                    <input type="text" class="form-control rounded" required name="firstName">
                </label>
            </div>
            <div>
                <label class="form-group m-2 w-25 text-start">
                    Last name
                    <input type="text" class="form-control rounded" required name="lastName">
                </label>
            </div>
            <div>
                <label class="form-group m-2 w-25 text-start">
                    Email
                    <input type="email" class="form-control rounded" required name="email">
                </label>
            </div>
            <div>
                <label class="form-group m-2 w-25 text-start">
                    Password
                    <input type="password" class="form-control rounded" required name="password">
                </label>
            </div>
            <div>
                <input type="submit" class="btn btn-outline-primary m-4" value="Register">
            </div>
        </form>
    `
)