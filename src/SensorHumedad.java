public class SensorHumedad extends Sensor {

    private static final double HUMEDAD_MINIMA = 40;
    private static final double HUMEDAD_MAXIMA = 70;

    public SensorHumedad(String id, String ubicacion) {
        super(id, ubicacion, "%");
    }

    @Override
    public String evaluarMedicion() {
        double medicion = getUltimaMedicion();
        if (medicion < HUMEDAD_MINIMA) {
            return "Humedad ambiental baja";
        } else if (medicion > HUMEDAD_MAXIMA) {
            return "Humedad ambiental alta";
        } else {
            return "Humedad ambiental adecuada";
        }
    }
}