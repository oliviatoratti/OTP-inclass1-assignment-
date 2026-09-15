import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {
    TemperatureConverter converter = new TemperatureConverter();

    @Test
    void fahrenheitToCelsiusTest() {
        assertEquals(0, converter.fahrenheitToCelsius(32));
        assertEquals(100, converter.fahrenheitToCelsius(212));
    }
    @Test
    void celsiusToFahrenheitTest() {
        assertEquals(32, converter.celsiusToFahrenheit(0));
        assertEquals(212, converter.celsiusToFahrenheit(100));
    }
    @Test
    void extremeTemperatureTest() {
        assertTrue(converter.isExtremeTemperature(-41));
        assertTrue(converter.isExtremeTemperature(51));

        assertFalse(converter.isExtremeTemperature(-40));
        assertFalse(converter.isExtremeTemperature(50));
        assertFalse(converter.isExtremeTemperature(20));
    }
    @Test
    void kelvinToCelsiusTest() {
        assertEquals(26.85, converter.kelvinToCelsius(300), 0.001);
        assertEquals(0, converter.kelvinToCelsius(273.15), 0.001);
    }
}