import model.*;
import enums.*;

public class Main {
    public static void main(String[] args) {
        Traveler traveler1 = new Traveler("Иван", 30, "Россия");
        Traveler traveler2 = new Traveler("Анна", 25, "Украина");
        Traveler traveler3 = new Traveler("John", 35, "USA");

        Cabin cabin = new Cabin(new Traveler[]{traveler1, traveler2, traveler3});
        String[] amenities = {"Wi-Fi", "Кофемашина"};
        Salon salon = new Salon(3, true, amenities, 3);

        BrakeEngine brakeEngine = new BrakeEngine(EngineType.BRAKE_ENGINE);
        MainEngine mainEngine = new MainEngine(EngineType.MAIN_ENGINE);
        Rocket rocket = new Rocket(mainEngine, brakeEngine, new Cabin[]{cabin}, salon);

        rocket.turnOnLights();
        rocket.turnOffLights();

        System.out.println("Статус ракеты перед запуском: " + rocket.getStatus());
        rocket.start();
        System.out.println("Статус ракеты после запуска: " + rocket.getStatus());

        rocket.land();
        System.out.println("Статус ракеты после приземления: " + rocket.getStatus());

        if (salon.isMeetingAreaAvailable()) {
            salon.conductMeeting();
        } else {
            System.out.println("Невозможно провести встречу, зона для встреч не доступна.");
        }
        salon.displayParticipants();
        salon.displayAmenities();

        System.out.println("Вместимость ракеты: " + rocket.getCapacity() + " путешественников");
        for (Traveler t : cabin.getTravelers()) {
            t.displayInfo();
        }

        System.out.println(traveler1.getName() + " совершеннолетний? " + traveler1.isAdult());
        traveler1.setName("Петя");
        System.out.println("Новое имя путешественника: " + traveler1.getName());
    }
}
