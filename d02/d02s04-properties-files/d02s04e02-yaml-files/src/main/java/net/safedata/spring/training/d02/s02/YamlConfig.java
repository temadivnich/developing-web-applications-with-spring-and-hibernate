package net.safedata.spring.training.d02.s02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * A simple Spring {@link Configuration} which demos the usage of configuration files
 *
 * @author bogdan.solga
 */
@Configuration
public class YamlConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(YamlConfig.class);

    private final ApplicationContext applicationContext;

    @Value("${connection.timeout:50000}")
    private int connectionTimeout;

    @Autowired
    public YamlConfig(final ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        LOGGER.info("\tThe configured application name is '{}'", applicationContext.getId());
        LOGGER.info("\tThe value of the 'connection.timeout' config property is '{}'", connectionTimeout);
    }
}
