package exercise;

import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        List<String> users = List.of("John", "Mark", "Ann");
        app.get("/users", ctx -> ctx.json(users));
        app.get("/phones", ctx -> ctx.json(Data.getPhones()));
        app.get("/domains", ctx -> ctx.json(Data.getDomains()));
        return app;
                // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
