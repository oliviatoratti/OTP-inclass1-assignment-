import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TemperatureUnitTest {

    @Test
    void gettersAndSettersWork() {

        TemperatureUnit unit =
                new TemperatureUnit();

        unit.setUnitId(1);
        unit.setUnitName("Celsius");

        assertEquals(
                1,
                unit.getUnitId());

        assertEquals(
                "Celsius",
                unit.getUnitName());
    }
}