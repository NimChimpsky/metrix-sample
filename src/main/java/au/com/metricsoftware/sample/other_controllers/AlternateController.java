package au.com.metricsoftware.sample.other_controllers;

import au.com.metricsoftware.metrix.annotations.Controller;
import au.com.metricsoftware.metrix.annotations.Get;
import com.google.gson.Gson;

import java.util.Map;

@Controller
public class AlternateController {
    private final Gson gson;
    private final SampleService sampleService;

    public AlternateController(final Gson gson, final SampleService sampleService) {
        this.gson = gson;
        this.sampleService = sampleService;
    }

    @Get("/something")
    public String something(Map<String, String> parameters) {
        return sampleService.sampleDo();
    }
}
