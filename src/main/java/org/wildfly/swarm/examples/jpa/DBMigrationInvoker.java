package org.wildfly.swarm.examples.jpa;

import org.flywaydb.core.Flyway;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * @author Yoshimasa Tanabe
 */
@WebListener
public class DBMigrationInvoker implements ServletContextListener {

    @Resource(mappedName = "java:jboss/datasources/ExampleDS")
    private DataSource ds;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Flyway flyway = new Flyway();
        flyway.setDataSource(ds);
        flyway.migrate();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}
