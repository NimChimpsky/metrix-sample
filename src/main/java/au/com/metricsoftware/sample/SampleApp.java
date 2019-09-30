package au.com.metricsoftware.sample;

import au.com.metricsoftware.metrix.MetrixServer;
import au.com.metricsoftware.sample.other_controllers.SampleService;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class SampleApp {
    private static final String[] controllerPackages
            = {"au.com.metricsoftware.sample.controller", "au.com.metricsoftware.sample.other_controllers"};

    public static void main(String[] quartet) throws Exception {

        MetrixServer metrixServer = new MetrixServer.Builder().withPort(8080)
                                                              .withApiUrlPrefix("/sample-api")
                                                              .withControllerPackages(controllerPackages)
                                                              .withDependencies(createObjectGraph())
                                                              .build();
        metrixServer.start();
    }

    private static Map<Class<?>, Object> createObjectGraph() {
        Map<Class<?>, Object> map = new HashMap<>(2);
        map.put(Gson.class, new Gson());
        map.put(SampleService.class, new SampleService());
        return map;
    }
}
