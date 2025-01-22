package View;

import java.util.Scanner;

public class ProveedorView {
    private Scanner scanner;

    public ProveedorView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU DE GESTIÓN DE PROVEEDORES *****");
            System.out.println("1. Registrar Proveedor");
            System.out.println("2. Listar Proveedores");
            System.out.println("3. Modificar Proveedor");
            System.out.println("4. Eliminar Proveedor");
            System.out.println("5. Volver al Menú Principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarProveedor();
                    break;
                case 2:
                    listarProveedores();
                    break;
                case 3:
                    modificarProveedor();
                    break;
                case 4:
                    eliminarProveedor();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarProveedor() {
        System.out.println("Registro de un nuevo proveedor");
        // Lógica para registrar proveedor (ingreso de datos)
    }

    private void listarProveedores() {
        System.out.println("Listando proveedores...");
        // Lógica para listar proveedores registrados
    }

    private void modificarProveedor() {
        System.out.println("Modificando proveedor");
        // Lógica para modificar datos de un proveedor
    }

    private void eliminarProveedor() {
        System.out.println("Eliminando proveedor");
        // Lógica para eliminar proveedor
    }
}
