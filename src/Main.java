public class Main {

    public static void main(String[] args) {
        System.out.println("Sistema de invernadero inteligente");
        System.out.println();

        SensorTemperatura temperatura = new SensorTemperatura("T-01", "zona norte");
        SensorHumedad humedad = new SensorHumedad("H-01", "zona central");
        SensorHumedadSuelo suelo = new SensorHumedadSuelo("S-01", "zona sur");

        System.out.println("--- Mismo valor (32) en los tres sensores ---");
        temperatura.registrarMedicion(32);
        humedad.registrarMedicion(32);
        suelo.registrarMedicion(32);
        System.out.println(temperatura.mostrarInformacion());
        System.out.println(humedad.mostrarInformacion());
        System.out.println(suelo.mostrarInformacion());
        System.out.println();

        System.out.println("--- Temperatura: baja, adecuada y alta ---");
        double[] valoresTemperatura = {15, 25, 34};
        for (double valor : valoresTemperatura) {
            temperatura.registrarMedicion(valor);
            System.out.println(valor + " " + temperatura.getUnidad() + " -> " + temperatura.evaluarMedicion());
        }
        System.out.println();

        System.out.println("--- Humedad ambiental: baja, adecuada y alta ---");
        double[] valoresHumedad = {32, 55, 82};
        for (double valor : valoresHumedad) {
            humedad.registrarMedicion(valor);
            System.out.println(valor + " " + humedad.getUnidad() + " -> " + humedad.evaluarMedicion());
        }
        System.out.println();

        System.out.println("--- Humedad del suelo: baja, adecuada y alta ---");
        double[] valoresSuelo = {18, 48, 83};
        for (double valor : valoresSuelo) {
            suelo.registrarMedicion(valor);
            System.out.println(valor + " " + suelo.getUnidad() + " -> " + suelo.evaluarMedicion()
                    + " | ¿Necesita riego? " + suelo.necesitaRiego());
        }
        System.out.println();

        System.out.println("--- Comportamiento propio del sensor de temperatura ---");
        temperatura.registrarMedicion(25);
        System.out.println(temperatura.getUltimaMedicion() + " °C = " + temperatura.convertirAFahrenheit() + " °F");


        System.out.println();
        System.out.println("--- Colección de sensores con referencias de tipo Sensor ---");


        Sensor sensor1 = new SensorTemperatura("T-02", "zona norte");
        Sensor sensor2 = new SensorHumedad("H-02", "zona central");
        Sensor sensor3 = new SensorHumedadSuelo("S-02", "zona sur");

        Sensor[] sensores = {sensor1, sensor2, sensor3};


        sensor1.registrarMedicion(32);
        sensor2.registrarMedicion(55);
        sensor3.registrarMedicion(22);


        for (Sensor sensor : sensores) {
            System.out.println(sensor.getId() + " | " + sensor.getUltimaMedicion() + " " + sensor.getUnidad()
                    + " -> " + sensor.evaluarMedicion());
        }

        System.out.println();
        System.out.println("--- Enlace dinámico: tipo de referencia vs tipo real ---");
        for (Sensor sensor : sensores) {
            System.out.println("Referencia: Sensor | Objeto real: " + sensor.getClass().getSimpleName()
                    + " | Se ejecuta: " + sensor.evaluarMedicion());
        }

        System.out.println();
        System.out.println("--- Segundo escenario con la misma colección ---");
        double[] escenario2 = {24, 62, 51};
        for (int i = 0; i < sensores.length; i++) {
            sensores[i].registrarMedicion(escenario2[i]);
        }
        for (Sensor sensor : sensores) {
            System.out.println(sensor.mostrarInformacion());
        }

    }

}