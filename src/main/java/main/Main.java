package main;

import config.FlyWayconfig;

public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.iniciar();
        FlyWayconfig.migrate();

    }
}