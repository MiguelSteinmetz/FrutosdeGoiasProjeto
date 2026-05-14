package config;

import org.flywaydb.core.Flyway;

public class FlyWayconfig {
    public static void migrate() {

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/Frutosdegoias",
                        "postgres",
                        "postgres")
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();
    }
}
