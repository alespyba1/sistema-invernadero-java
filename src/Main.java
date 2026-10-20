public class Main {

    public static void main(String[] args) {
        System.out.println("Sistema de invernadero inteligente");
        System.out.println();

        // Creación de objetos con sus constructores (cada uno llama a super)
        SensorTemperatura temperatura = new SensorTemperatura("T-01", "zona norte");
        SensorHumedad humedad = new SensorHumedad("H-01", "zona central");
        SensorHumedadSuelo suelo = new SensorHumedadSuelo("S-01", "zona sur");

        // registrarMedicion y mostrarInformacion se heredan de Sensor
        temperatura.registrarMedicion(32);
        humedad.registrarMedicion(55);
        suelo.registrarMedicion(22);

        System.out.println(temperatura.mostrarInformacion());
        System.out.println(humedad.mostrarInformacion());
        System.out.println(suelo.mostrarInformacion());
        System.out.println();

        // Métodos propios de cada subclase
        System.out.println("Temperatura en °F: " + temperatura.convertirAFahrenheit());
        System.out.println("¿El suelo necesita riego? " + suelo.necesitaRiego());
    }

}