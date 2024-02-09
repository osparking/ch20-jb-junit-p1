package space.bum.junit.tdd.model;

public class Airport {
  public static void main(String[] args) {
    Flight economyFlight = new Flight("1", "Economy");
    Flight businessFlight = new Flight("1", "Business");

    Passenger kim = new Passenger("김", true);
    Passenger lee = new Passenger("이", false);

    businessFlight.addPassenger(kim);
    businessFlight.removePassenger(kim);
    businessFlight.addPassenger(lee);
    economyFlight.addPassenger(lee);

    System.out.println("비즈니스 항공편 승객 목록:");
    businessFlight.getPassengerList()
        .forEach(p -> System.out.println(p.getName()));

    System.out.println("일반 항공편 승객 목록:");
    economyFlight.getPassengerList()
        .forEach(p -> System.out.println(p.getName()));
  }
}
