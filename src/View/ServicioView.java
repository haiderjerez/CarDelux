package View;

import java.util.Scanner;

public class ServicioView {
    private Scanner scanner;

    public ServicioView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU DE GESTIÓN DE SERVICIOS *****");
            System.out.println("1. Registrar Servicio");
            System.out.println("2. Listar Servicios");
            System.out.println("3. Modificar Servicio");
            System.out.println("4. Eliminar Servicio");
            System.out.println("5. Volver al Menú Principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarServicio();
                    break;
                case 2:
                    listarServicios();
                    break;
                case 3:
                    modificarServicio();
                    break;
                case 4:
                    eliminarServicio();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarServicio() {
        System.out.println("Registro de un nuevo servicio");
        // Lógica para registrar servicio (ingreso de datos)
    }

    private void listarServicios() {
        System.out.println("Listando servicios...");
        // Lógica para listar servicios registrados
    }

    private void modificarServicio() {
        System.out.println("Modificando servicio");
        // Lógica para modificar datos de un servicio
    }

    private void eliminarServicio() {
        System.out.println("Eliminando servicio");
        // Lógica para eliminar servicio
    }
}
