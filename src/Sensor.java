public class Sensor {

    private String id;
    private String ubicacion;
    private String unidad;
    private boolean activo;
    private double ultimaMedicion;

    public Sensor(String id, String ubicacion, String unidad) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.unidad = unidad;
        this.activo = true;
        this.ultimaMedicion = 0;
    }

    public String getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getUnidad() {
        return unidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public double getUltimaMedicion() {
        return ultimaMedicion;
    }

    public void activar() {
        activo = true;
    }

    public void desactivar() {
        activo = false;
    }

    // La medición solo cambia con este método, y solo si el sensor está activo
    public void registrarMedicion(double valor) {
        if (activo) {
            ultimaMedicion = valor;
        } else {
            System.out.println("El sensor " + id + " está inactivo, no se registró la medición.");
        }
    }

    public String evaluarMedicion() {
        return "Sin criterio de interpretación";
    }

    public String mostrarInformacion() {
        String estado;
        if (activo) {
            estado = "activo";
        } else {
            estado = "inactivo";
        }
        return id + " | " + ubicacion + " | " + estado + " | "
                + ultimaMedicion + " " + unidad + " | " + evaluarMedicion();
    }

}