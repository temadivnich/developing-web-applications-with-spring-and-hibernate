package net.safedata.spring.training.complete.project.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * A simple {@link javax.sql.DataSource} configuration, which:
 * <ul>
 *     <li>configures the JPA repositories, using the {@link EnableJpaRepositories} annotation</li>
 *     <li>enables the transaction management support</li>
 * </ul>
 *
 * @author bogdan.solga
 */
@Configuration
@EnableJpaRepositories(basePackages = "net.safedata.spring.training.complete.project.repository")
@EnableTransactionManagement
@EntityScan("net.safedata.spring.training.jpa.model")
public class DataSourceConfig {
}
