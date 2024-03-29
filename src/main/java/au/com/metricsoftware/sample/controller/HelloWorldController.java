package au.com.metricsoftware.sample.controller;

import au.com.metricsoftware.metrix.annotations.*;
import au.com.metricsoftware.sample.domain.Person;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

// must have controller annotation, to be detected by scanner
@Controller
public class HelloWorldController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final Gson gson;

    // only one constructor allowed, any injected dependencies must be available in dependency provider implementation
    public HelloWorldController(final Gson gson) {
        this.gson = gson;
    }


    // method signature must not change for request types
    // get request take a map of string string, extracted from url  query string
    @Get("/HelloWorld")
    public String get(Map<String, String> parameters) {
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            logger.info("key {}, val {}", entry.getKey(), entry.getValue());
        }
        Person person = new Person(parameters.get("name"), Integer.parseInt(parameters.get("age")));
        return gson.toJson(person);
    }

    // method name irrelevant
    @Post("/HelloWorld")
    public String postalicious(Map<String, String> parameters, String jsonBody) {
        for (Map.Entry<String, String> entry : parameters.entrySet()) {
            logger.info("key {}, val {}", entry.getKey(), entry.getValue());
        }
        logger.info("jsonBody {} ", jsonBody);

        Person person = new Person("test-name", 50);
        return gson.toJson(person);
    }

    @Put("/HelloWorld")
    public String put(Map<String, String> parameters, String jsonBody) {
        return "put hello world";
    }

    @Delete("/HelloWorld")
    public String delete(Map<String, String> parameters) {
        return "deleted hello world";
    }

    // Multiple annotations per method, not valid
//    @Post(url = "/HelloWorld")
//    @Delete(url = "/HelloWorld")
//    public String delete(String s) {
//        return "hello world";
//    }


}
