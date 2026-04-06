package config;

import org.flywaydb.core.Flyway;

public class FlyWayconfig {
    public static void migrate(){
        Flyway flyway = Flyway.configure()
                .dataSource(
                        "jbdc:postgresql://localhost:5433/postgres",
                        "postgres",
                        "postgres"
                )
                .baselineOnMigrate(true)
                .load();

        flyway.migrate();
    }
}