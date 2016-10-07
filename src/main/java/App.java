import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
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
      model.put("rangers", Ranger.all());
      model.put("sightings", Sighting.all());
      model.put("species", Animal.allSpecies());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/sighting/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/sighting.vtl");
      model.put("rangers", Ranger.all());
      model.put("health", Animal.allHealth());
      model.put("age", Animal.allAge());
      model.put("gender", Animal.allGender());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/sighting/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("ranger");
      String species = request.queryParams("species");
      int health = request.queryParams("health");
      Boolean endangered = request.queryParams("endangered");
      int age = request.queryParams("age");
      int gender = request.queryParams("gender");
      String location_name = request.queryParams("location_name");
      String mgrs = request.queryParams("mgrs");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

}
