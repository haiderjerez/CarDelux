package View;

import java.util.Scanner;

public class VehiculoView {
    private Scanner scanner;

    public VehiculoView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU DE GESTIÓN DE VEHÍCULOS *****");
            System.out.println("1. Registrar Vehículo");
            System.out.println("2. Listar Vehículos");
            System.out.println("3. Modificar Vehículo");
            System.out.println("4. Eliminar Vehículo");
            System.out.println("5. Volver al Menú Principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    listarVehiculos();
                    break;
                case 3:
                    modificarVehiculo();
                    break;
                case 4:
                    eliminarVehiculo();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarVehiculo() {
        System.out.println("Registro de un nuevo vehículo");
        // Lógica para registrar vehículo (ingreso de datos)
    }

    private void listarVehiculos() {
        System.out.println("Listando vehículos...");
        // Lógica para listar vehículos registrados
    }

    private void modificarVehiculo() {
        System.out.println("Modificando vehículo");
        // Lógica para modificar datos de un vehículo
    }

    private void eliminarVehiculo() {
        System.out.println("Eliminando vehículo");
        // Lógica para eliminar vehículo
    }
}
