package org.liyanxu.tryout.validation;

import io.dropwizard.Application;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.liyanxu.tryout.validation.api.PersonalInfoApi;
import org.liyanxu.tryout.validation.resources.TryoutValidationResourceV1;
import org.liyanxu.tryout.validation.service.PersonalInfoApiImpl;

import javax.inject.Singleton;
import javax.validation.Validator;

public class TryoutValidationApplication extends Application<TryoutValidationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new TryoutValidationApplication().run(args);
    }

    @Override
    public String getName() {
        return "TryoutValidation";
    }

    @Override
    public void initialize(final Bootstrap<TryoutValidationConfiguration> bootstrap) {
        // Add Swagger Bundle
        bootstrap.addBundle(new SwaggerBundle<TryoutValidationConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(TryoutValidationConfiguration config) {
                return config.getSwaggerBundleConfiguration();
            }
        });
    }

    @Override
    public void run(final TryoutValidationConfiguration config,
                    final Environment env) {
        JerseyEnvironment jersey = env.jersey();

        jersey.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(env.getValidator()).to(Validator.class);
                bind(PersonalInfoApiImpl.class).to(PersonalInfoApi.class).in(Singleton.class);
            }
        });

        jersey.register(TryoutValidationResourceV1.class);
    }

}
