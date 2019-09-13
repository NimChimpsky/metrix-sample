package au.com.metricsoftware.sample;

import au.com.metricsoftware.metrix.MetrixServer;

public class SampleApp {

    public static void main(String[] quartet) throws Exception {
        MetrixServer metrixServer = new MetrixServer.Builder().build();
        metrixServer.start();
    }
}
