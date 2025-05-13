package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage("", null);
        ctx.render("build.jte", model("page", page));
    }

    public static void login(Context ctx) {
        String name = ctx.formParam("name").trim().toLowerCase();
        String password = Security.encrypt(ctx.formParam("password"));

        if (UsersRepository.existsByName(name)
                && UsersRepository.findByName(name).get().getPassword().equals(password)) {
            ctx.sessionAttribute("currentUser", name);
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            var page = new LoginPage(name, "Wrong username or password.");
            ctx.render("build.jte", model("page", page));
        }

    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
