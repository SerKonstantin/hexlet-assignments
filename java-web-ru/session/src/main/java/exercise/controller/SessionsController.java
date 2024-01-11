package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var name = ctx.sessionAttribute("username");
        var page = new MainPage(name);

        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build(Context ctx) {
        ctx.render("build.jte");
    }

    public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(UsersRepository::existsByName, "Wrong username or password")
                    .get();

            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> UsersRepository.findByName(name).getPassword().equals(Security.encrypt(value)), "Wrong username or password")
                    .get();

//            var encryptedPassword = Security.encrypt(password);

            ctx.sessionAttribute("username", name);
            ctx.redirect(NamedRoutes.rootPath());
        } catch (ValidationException e) {
            var name = ctx.formParam("name");
            var errorText = "Wrong username or password";

            var page = new LoginPage(name, errorText);
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void delete(Context ctx) {
        ctx.sessionAttribute("username", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
