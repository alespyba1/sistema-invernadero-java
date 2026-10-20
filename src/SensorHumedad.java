public class SensorHumedad extends Sensor {

    private static final double HUMEDAD_MINIMA = 40;
    private static final double HUMEDAD_MAXIMA = 70;

    public SensorHumedad(String id, String ubicacion) {
        super(id, ubicacion, "%");
    }

}