

package main;

import config.FlyWayconfig;


public class Main {
    public static void main(String[] args) {
        FlyWayconfig.migrate();
        Sistema sistema = new Sistema();
        sistema.iniciar();

    }
}
