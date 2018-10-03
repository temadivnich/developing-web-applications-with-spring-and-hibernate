package net.safedata.spring.training.d02.s02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapAutoConfiguration;

/**
 * A demo on loading properties files, using the {@link org.springframework.context.annotation.PropertySource} annotation
 *
 * @author bogdan.solga
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, EmbeddedLdapAutoConfiguration.class})
public class PropertiesLoadingDemo {

    public static void main(String[] args) {
        new SpringApplication(PropertiesLoadingDemo.class).run(args);
    }
}
