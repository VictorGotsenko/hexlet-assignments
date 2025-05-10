package exercise.controller;

import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;

import static io.javalin.rendering.template.TemplateUtil.model;

import exercise.repository.UserRepository;
import exercise.dto.users.UserPage;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;

public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        String firstName = ctx.formParam("firstName").trim();
        String lastName = ctx.formParam("lastName").trim();
        String email = ctx.formParam("email").trim().toLowerCase();
        String password = ctx.formParam("password");
        String encriptedPassword = Security.encrypt(password);
        String token = Security.generateToken();
        User user = new User(firstName, lastName, email, encriptedPassword, token);
        UserRepository.save(user);
        ctx.cookie("usertoken", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        String usertoken = ctx.cookie("usertoken");
        User user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
        if (!usertoken.equals(user.getToken())) {
            ctx.render("users/build.jte");
        } else {
            UserPage page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        }
    }

    // END
}
