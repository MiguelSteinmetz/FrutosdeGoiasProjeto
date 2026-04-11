package config;

import org.flywaydb.core.Flyway;

public class FlyWayconfig {
    public static void migrate() {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/postgres",
                        "postgres",
                        "1234")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();
    }
}
