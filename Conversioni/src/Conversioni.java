public class Conversioni {
    public static double fahrenheitToCelsius(double temp) {
        return (temp - 32) * 5 / 9;
    } 

    public static double celsiusToFahrenheit(double temp) {
        return (temp * 9 / 5) + 32;
    }

    public static double celsiusToKevin(double temp) {
        return temp + 273.15;
    }

    public static double kevinToCelsius(double temp) {
        return temp - 273.15;
    }

    public static String getCelsiusFormula() {
        return "(temp - 32) * 5 / 9";
    }

    public static String getFahrenheitFormula() {
        return "(temp * 9 / 5) + 32";
    }

    public static String getKevinToCelsiusFormula() {
        return "temp - 273.15";
    }

    public static String getCelsiusToKevinFormula() {
        return "temp + 273.15";
    }
}
