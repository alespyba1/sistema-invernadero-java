public class SensorHumedadSuelo extends Sensor {

    private static final double HUMEDAD_MINIMA = 30;
    private static final double HUMEDAD_MAXIMA = 70;

    public SensorHumedadSuelo(String id, String ubicacion) {
        super(id, ubicacion, "%");
    }

    // Comportamiento que solo tiene sentido para el suelo: avisar si hace falta regar
    public boolean necesitaRiego() {
        return getUltimaMedicion() < HUMEDAD_MINIMA;
    }

}