package config;

import org.flywaydb.core.Flyway;

public class FlyWayconfig {
    public static void migrate() {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5433/postgres",
                        "postgres",
                        "admin")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();
    }
}
