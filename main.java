public class Main {
    public static void main(String[] args) {
        int totalVehiculos = 30;
        int numCabinas = 3;
        int porCabina = totalVehiculos / numCabinas; // 10 c/u

        CabinaPeaje[] cabinas = new CabinaPeaje[numCabinas];
        Thread[] hilos = new Thread[numCabinas];

        // La primera cabina lleva tu primer apellido
        cabinas[0] = new CabinaPeaje("Cabina Apellido", porCabina);
        cabinas[1] = new CabinaPeaje("Cabina 2", porCabina);
        cabinas[2] = new CabinaPeaje("Cabina 3", porCabina);

        for (int i = 0; i < numCabinas; i++) {
            hilos[i] = new Thread(cabinas[i]);
            hilos[i].start();
        }

        // Esperar a que todas terminen
        for (int i = 0; i < numCabinas; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n===== REPORTE FINAL =====");
        for (CabinaPeaje c : cabinas) {
            System.out.println(c.getNombre() + ": " + c.getVehiculosAtendidos() + " vehículos");
        }
        System.out.println("Total recaudado global: $" + CabinaPeaje.totalRecaudadoGlobal);
    }
}