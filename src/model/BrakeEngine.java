package model;

import enums.EngineType;

public class BrakeEngine {
    private EngineType engineType;

    public BrakeEngine(EngineType engineType) {
        this.engineType = engineType;
    }

    public void activate() {
        System.out.println("Тормозной двигатель активирован.");
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }
}
