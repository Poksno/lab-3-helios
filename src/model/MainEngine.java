package model;

import enums.EngineType;

public class MainEngine {
    private EngineType engineType;

    public MainEngine(EngineType engineType) {
        this.engineType = engineType;
    }

    public void start() {
        System.out.println("Основной двигатель запущен для взлета.");
    }

}
