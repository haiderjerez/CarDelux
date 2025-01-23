package View;

import Controller.ClienteController;

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
                    ClienteController.listarClientes();
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
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = scanner.nextLine();

        System.out.println("Cliente registrado exitosamente:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Teléfono: " + telefono);
    }

    private void modificarCliente() {
        System.out.println("Modificando cliente");
        System.out.print("Ingrese el ID del cliente a modificar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nuevo nombre del cliente (deje en blanco para no modificar): ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo apellido del cliente (deje en blanco para no modificar): ");
        String nuevoApellido = scanner.nextLine();

        System.out.print("Ingrese el nuevo correo electrónico del cliente (deje en blanco para no modificar): ");
        String nuevoCorreo = scanner.nextLine();

        System.out.print("Ingrese el nuevo teléfono del cliente (deje en blanco para no modificar): ");
        String nuevoTelefono = scanner.nextLine();

        boolean actualizado = ClienteController.actualizarCliente(idCliente, nuevoNombre, nuevoApellido, nuevoTelefono);

        if (actualizado) {
            System.out.println("Cliente modificado exitosamente.");
        } else {
            System.out.println("No se encontró un cliente con el ID proporcionado o no se pudo modificar.");
        }
    }

    private void eliminarCliente() {
        System.out.println("Eliminando cliente");
        System.out.print("Ingrese el ID del cliente a eliminar: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean eliminado = ClienteController.eliminarCliente(idCliente);

        if (eliminado) {
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un cliente con el ID proporcionado o no se pudo eliminar.");
        }
    }
}
