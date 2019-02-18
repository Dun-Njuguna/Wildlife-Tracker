import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
// endageredAnimal
        get("/endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/endangered_form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/endageredCiting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String rangerName = request.queryParams("ranger");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String health = request.queryParams("health");
            EndangeredAnimal newEndangeredAnimal = new EndangeredAnimal(name,rangerName,age,location,health);
            newEndangeredAnimal.save(); 
            model.put("template", "templates/endangered_form.vtl");
            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

        get("/endageredAnimal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("endangered", EndangeredAnimal.all());
            model.put("template", "templates/all_endageredAnimal.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
  
//notendageredAnimal
        get("/other", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/notendangered_form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/notendageredAnimal", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String rangerName = request.queryParams("ranger");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String health = request.queryParams("health");
            NotEndangeredAnimal newAnimal = new NotEndangeredAnimal(name,rangerName,age,location,health);
            newAnimal.save(); 
            model.put("template", "templates/notendangered_form.vtl");
            return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());

        get("/allAnimals", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/all_animal.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());
        

    }
}
    