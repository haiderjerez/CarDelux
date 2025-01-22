package View;

import java.util.Scanner;

public class ClienteView {
    private Scanner scanner;

    public ClienteView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU DE GESTIÓN DE CLIENTES *****");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Modificar Cliente");
            System.out.println("4. Eliminar Cliente");
            System.out.println("5. Volver al Menú Principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    modificarCliente();
                    break;
                case 4:
                    eliminarCliente();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarCliente() {
        System.out.println("Registro de un nuevo cliente");
        // Lógica para registrar cliente (ingreso de datos)
    }

    private void listarClientes() {
        System.out.println("Listando clientes...");
        // Lógica para listar clientes registrados
    }

    private void modificarCliente() {
        System.out.println("Modificando cliente");
        // Lógica para modificar datos de un cliente
    }

    private void eliminarCliente() {
        System.out.println("Eliminando cliente");
        // Lógica para eliminar cliente
    }
}
