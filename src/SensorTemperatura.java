public class SensorTemperatura extends Sensor {

    private static final double TEMPERATURA_MINIMA = 18;
    private static final double TEMPERATURA_MAXIMA = 30;

    public SensorTemperatura(String id, String ubicacion) {
        super(id, ubicacion, "°C");
    }

    public double convertirAFahrenheit() {
        return getUltimaMedicion() * 9.0 / 5.0 + 32;
    }

    @Override
    public String evaluarMedicion() {
        double medicion = getUltimaMedicion();
        if (medicion < TEMPERATURA_MINIMA) {
            return "Temperatura baja";
        } else if (medicion > TEMPERATURA_MAXIMA) {
            return "Temperatura alta";
        } else {
            return "Temperatura adecuada";
        }
    }
}