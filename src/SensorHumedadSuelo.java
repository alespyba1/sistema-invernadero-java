public class SensorHumedadSuelo extends Sensor {

    private static final double HUMEDAD_MINIMA = 30;
    private static final double HUMEDAD_MAXIMA = 70;

    public SensorHumedadSuelo(String id, String ubicacion) {
        super(id, ubicacion, "%");
    }


    public boolean necesitaRiego() {
        return getUltimaMedicion() < HUMEDAD_MINIMA;
    }

    @Override
    public String evaluarMedicion() {
        double medicion = getUltimaMedicion();
        if (medicion < HUMEDAD_MINIMA) {
            return "Humedad del suelo baja";
        } else if (medicion > HUMEDAD_MAXIMA) {
            return "Humedad del suelo alta";
        } else {
            return "Humedad del suelo adecuada";
        }
    }
}