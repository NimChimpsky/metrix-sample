package au.com.metricsoftware.sample.other_controllers;

import au.com.metricsoftware.metrix.annotations.Controller;
import au.com.metricsoftware.metrix.annotations.Get;
import com.google.gson.Gson;

@Controller
public class AlternateController {
    private final Gson gson;

    public AlternateController(Gson gson) {
        this.gson = gson;
    }

    @Get("something")
    public String something() {
        return "some data";
    }
}
