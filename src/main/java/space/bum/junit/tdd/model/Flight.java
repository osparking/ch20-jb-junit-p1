package space.bum.junit.tdd.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

@Getter
public class Flight {
  private String id;
  private List<Passenger> passengers = new ArrayList<Passenger>();
  private String type;

  public Flight(String id, String type) {
    super();
    this.id = id;
    this.type = type;
  }

  public List<Passenger>getPassengerList() {
    return Collections.unmodifiableList(passengers);
  }

  public boolean addPassenger(Passenger passenger) {
    switch (type) {
    case "Economy":
      return passengers.add(passenger);
    case "Business":
      if (passenger.isVip()) {
        return passengers.add(passenger);
      } else {
        return false;
      }
    default:
      throw new RuntimeException("이상한 항공편 형태: " + type);
    }
  }

  public boolean removePassenger(Passenger passenger) {
    switch (type) {
    case "Economy":
      if (passenger.isVip()) {
        return false;
      } else {
        return passengers.remove(passenger);
      }
    case "Business":
      return false;
    default:
      throw new RuntimeException("이상한 항공편 형태: " + type);
    }
  }
}
