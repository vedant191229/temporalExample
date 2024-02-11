package com.temporal;

import com.temporal.resources.homePage;
import com.temporal.resources.userProfile;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class temporalDemoApplication extends Application<temporalDemoConfiguration> {

    public static void main(final String[] args) throws Exception {
        new temporalDemoApplication().run(args);
    }

    @Override
    public String getName() {
        return "temporalDemo";
    }

    @Override
    public void initialize(final Bootstrap<temporalDemoConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final temporalDemoConfiguration configuration,
                    final Environment environment) {
        environment.jersey().register(new homePage());
        environment.jersey().register(new userProfile());
    }

}
