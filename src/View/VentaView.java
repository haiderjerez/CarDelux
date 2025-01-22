package View;

import java.util.Scanner;

public class VentaView {
    private Scanner scanner;

    public VentaView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU DE GESTIÓN DE VENTAS *****");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Listar Ventas");
            System.out.println("3. Modificar Venta");
            System.out.println("4. Eliminar Venta");
            System.out.println("5. Volver al Menú Principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarVenta();
                    break;
                case 2:
                    listarVentas();
                    break;
                case 3:
                    modificarVenta();
                    break;
                case 4:
                    eliminarVenta();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarVenta() {
        System.out.println("Registro de una nueva venta");
        // Lógica para registrar venta (ingreso de datos)
    }

    private void listarVentas() {
        System.out.println("Listando ventas...");
        // Lógica para listar ventas registradas
    }

    private void modificarVenta() {
        System.out.println("Modificando venta");
        // Lógica para modificar datos de una venta
    }

    private void eliminarVenta() {
        System.out.println("Eliminando venta");
        // Lógica para eliminar venta
    }
}
