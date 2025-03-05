package exercise;

import io.javalin.Javalin;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        Javalin app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("GET /phones", ctx -> ctx.json(Data.getPhones()));
        app.get("GET /domains", ctx -> ctx.json(Data.getDomains()));

        return app;
                // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
