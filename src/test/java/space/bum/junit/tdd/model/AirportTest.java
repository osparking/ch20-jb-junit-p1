package space.bum.junit.tdd.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class AirportTest {
  
  @DisplayName("비즈니스 항공편이 하나 있다")
  @Nested
  class BusinessFlightTest {
    private Flight businessFlight;
    
    @BeforeEach
    void setUp() {
      businessFlight = new Flight("2", "Business");
    }
    
    @Test
    public void testBusinessRegular() {
      Passenger kim = new Passenger("김", false);
      assertEquals(false, businessFlight.addPassenger(kim));
      assertEquals(0, businessFlight.getPassengerList().size());
      assertEquals(false, businessFlight.removePassenger(kim));
      assertEquals(0, businessFlight.getPassengerList().size());
    }
    
    @Test
    public void testBusinessVip() {
      Passenger lee = new Passenger("이", true);
      assertEquals("2", businessFlight.getId());
      assertEquals(true, businessFlight.addPassenger(lee));
      assertEquals(1, businessFlight.getPassengerList().size());
      assertEquals("이", businessFlight.getPassengerList().get(0).getName());
      assertEquals(false, businessFlight.removePassenger(lee));
      assertEquals(1, businessFlight.getPassengerList().size());
    }
  }

  @DisplayName("일반 항공편이 하나 있다")
  @Nested
  class EconomyFlightTest {
    private Flight economyFlight;

    @BeforeEach
    void setUp() {
      economyFlight = new Flight("1", "Economy");
    }

    @Test
    public void testEconomyRegular() {
      Passenger kim = new Passenger("김", false);
      assertEquals("1", economyFlight.getId());
      assertEquals(true, economyFlight.addPassenger(kim));
      assertEquals(1, economyFlight.getPassengerList().size());
      assertEquals("김", economyFlight.getPassengerList().get(0).getName());
      assertEquals(true, economyFlight.removePassenger(kim));
      assertEquals(0, economyFlight.getPassengerList().size());
    }
    
    @Test
    public void testEconomyVip() {
      Passenger lee = new Passenger("이", true);
      assertEquals("1", economyFlight.getId());
      assertEquals(true, economyFlight.addPassenger(lee));
      assertEquals(1, economyFlight.getPassengerList().size());
      assertEquals("이", economyFlight.getPassengerList().get(0).getName());
      assertEquals(false, economyFlight.removePassenger(lee));
      assertEquals(1, economyFlight.getPassengerList().size());
    }
  }

}
