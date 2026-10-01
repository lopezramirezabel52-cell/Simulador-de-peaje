import java.util.Random;

public class CabinaPeaje implements Runnable {

    // Variable global compartida (sin synchronized, volatile ni atomic)
    public static int totalRecaudadoGlobal = 0;

    private String nombre;
    private int vehiculosAtendidos;
    private int vehiculosAsignados;
    private Random random = new Random();

    public CabinaPeaje(String nombre, int vehiculosAsignados) {
        this.nombre = nombre;
        this.vehiculosAsignados = vehiculosAsignados;
        this.vehiculosAtendidos = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVehiculosAtendidos() {
        return vehiculosAtendidos;
    }

    @Override
    public void run() {
        for (int i = 0; i < vehiculosAsignados; i++) {
            try {
                // Tiempo aleatorio entre 500 y 1500 ms
                int tiempo = 500 + random.nextInt(1001);
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            totalRecaudadoGlobal += 50;
            vehiculosAtendidos++;
            System.out.println(nombre + " cobró al vehículo #" + vehiculosAtendidos);
        }
    }
}