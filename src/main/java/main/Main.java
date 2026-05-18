

package main;

import config.FlyWayconfig;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        FlyWayconfig.migrate();
        Sistema sistema = new Sistema();
        sistema.iniciar();

    }
}
