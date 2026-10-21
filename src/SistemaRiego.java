public class SistemaRiego {

    private boolean activo;
    private SensorHumedadSuelo sensorSuelo;

    public SistemaRiego(SensorHumedadSuelo sensorSuelo) {
        this.sensorSuelo = sensorSuelo;
        this.activo = false;
    }

    public void activar() {
        activo = true;
    }

    public void desactivar() {
        activo = false;
    }

    public boolean isActivo() {
        return activo;
    }

    public String getEstado() {
        if (activo) {
            return "ACTIVO";
        } else {
            return "INACTIVO";
        }
    }

    // El riego no interpreta la medición: le pregunta al sensor si hace falta regar
    public void revisarHumedadSuelo() {
        if (sensorSuelo.necesitaRiego()) {
            activar();
        } else {
            desactivar();
        }
    }

}