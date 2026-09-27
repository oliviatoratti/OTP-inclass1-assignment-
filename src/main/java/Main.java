public class Main {
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();

        System.out.println("0°C = "
                + converter.celsiusToFahrenheit(0)
                + "°F");

        System.out.println("212°F = "
                + converter.fahrenheitToCelsius(212)
                + "°C");
    }
}