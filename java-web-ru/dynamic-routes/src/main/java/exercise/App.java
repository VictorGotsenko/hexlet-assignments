package exercise;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });

        // BEGIN
//        При GET-запросе на адрес /companies/{id} приложение должно отдавать представление компании в формате json.
        app.get("/companies/{id}", ctx -> {
            String id = ctx.pathParam("id");
            Map<String, String> companyFind = new HashMap<>();
            for (Map<String, String> company : COMPANIES) {
                if (id.equals(company.get("id"))) {
                    companyFind.put("id", company.get("id"));
                    companyFind.put("name", company.get("name"));
                    companyFind.put("phone", company.get("phone"));
                }
            }

            if (companyFind.isEmpty()) {
               throw new NotFoundResponse("Company not found");
            } else {
                ctx.json(companyFind);
            }
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
