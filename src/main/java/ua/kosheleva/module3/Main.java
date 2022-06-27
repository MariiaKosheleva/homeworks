package ua.kosheleva.module3;

import org.flywaydb.core.Flyway;
import ua.kosheleva.module3.activityManagementSystem.ActivityManagementSystem;
import ua.kosheleva.module3.config.HibernateFactoryUtil;

public class Main {
    private static final ActivityManagementSystem activityManagementSystem = new ActivityManagementSystem();

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/module3", "postgres", "mama1101")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
        flyway.migrate();
        HibernateFactoryUtil.init();
        activityManagementSystem.greeter();
        activityManagementSystem.launchActivityManagementSystem();
    }
}
