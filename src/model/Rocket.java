package model;

import interfaces.Motorized;
import abstracts.Vehicle;
import interfaces.LightingControl;
import enums.RocketStatus;

import java.util.Arrays;
import java.util.Objects;

public class Rocket extends Vehicle implements Motorized, LightingControl {
    private MainEngine mainEngine;
    private Cabin[] cabins;

    private BrakeEngine brakeEngine;
    private Salon salon;
    private RocketStatus status;
    private boolean lightsOn;

    public Rocket(MainEngine mainEngine, BrakeEngine brakeEngine, Cabin[] cabins, Salon salon) {
        this.mainEngine = mainEngine;
        this.brakeEngine = brakeEngine;
        this.cabins = cabins;
        this.salon = salon;
        this.status = RocketStatus.ON_GROUND;
        this.lightsOn = false;
    }

    public void start() {
        if (status == RocketStatus.ON_GROUND) {
            mainEngine.start();
            status = RocketStatus.TAKING_OFF;
            System.out.println("Ракета готовится к взлету.");
            status = RocketStatus.IN_FLIGHT;
            System.out.println("Ракета в полете.");
        } else {
            System.out.println("Невозможно начать взлет: неправильный статус ракеты.");
        }
    }

    public void land() {
        if (status == RocketStatus.IN_FLIGHT) {
            brakeEngine.activate();
            status = RocketStatus.LANDING;
            System.out.println("Ракета начинает посадку.");
            status = RocketStatus.ON_GROUND;
            System.out.println("Ракета приземлилась.");
        } else {
            System.out.println("Невозможно приземлиться: ракета не в полете.");
        }
    }

    public RocketStatus getStatus() {
        return status;
    }

    public int getCapacity() {
        return cabins.length * 4;
    }

    @Override
    public void turnOnLights() {
        if (!lightsOn) {
            lightsOn = true;
            System.out.println("Свет в ракете включен.");
        } else {
            System.out.println("Свет в ракете уже включен.");
        }
    }

    @Override
    public void turnOffLights() {
        if (lightsOn) {
            lightsOn = false;
            System.out.println("Свет в ракете выключен.");
        } else {
            System.out.println("Свет в ракете уже выключен.");
        }
    }

    @Override
    public void startEngine() {
        if (status == RocketStatus.ON_GROUND || status == RocketStatus.LANDING) {
            System.out.println("Запуск двигателя ракеты.");
            mainEngine.start();
            brakeEngine.activate();
        } else {
            System.out.println("Невозможно запустить двигатель: неправильный статус ракеты.");
        }
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Rocket rocket = (Rocket) obj;
        return Objects.equals(mainEngine, rocket.mainEngine) &&
                Objects.equals(brakeEngine, rocket.brakeEngine) &&
                Arrays.equals(cabins, rocket.cabins) &&
                Objects.equals(salon, rocket.salon);
    }


    @Override
    public int hashCode() {
        return Objects.hash(mainEngine, brakeEngine, cabins, salon);
    }

    @Override
    public String toString() {
        return "Rocket{" +
                "mainEngine=" + mainEngine +
                ", brakeEngine=" + brakeEngine +
                ", cabins=" + Arrays.toString(cabins) +
                ", salon=" + salon +
                '}';
    }

}