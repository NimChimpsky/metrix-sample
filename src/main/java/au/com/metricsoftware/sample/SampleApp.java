package au.com.metricsoftware.sample;

import au.com.metricsoftware.metrix.MetrixServer;

public class SampleApp {
    private static final String[] controllerPackages
            = {"au.com.metricsoftware.sample.controller", "au.com.metricsoftware.sample.other_controllers"};

    public static void main(String[] quartet) throws Exception {
        MetrixServer metrixServer = new MetrixServer.Builder().withPort(8080)
                                                              .withApiContext("/sample-api")
                                                              .withControllerPackages(controllerPackages)
                                                              .build();
        metrixServer.start();
    }
}
