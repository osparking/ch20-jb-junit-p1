package space.bum.junit.tdd.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

class AirportTest {

  @DisplayName("일반 항공편이 하나 있다")
  @Nested
  class EconomyFlightTest {
    private Flight economyFlight;
    
    @BeforeEach
    void setUp() {
      economyFlight = new Flight("1", "Economy");
    }
  }

}
