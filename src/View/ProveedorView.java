package View;

import Controller.ProveedorController;

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
            scanner.nextLine();

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
        System.out.print("Ingrese el nombre del proveedor: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el contacto del proveedor: ");
        String contacto = scanner.nextLine();
        
        System.out.print("Ingrese el teléfono del proveedor: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese la dirección del proveedor: ");
        String direccion = scanner.nextLine();

        boolean registrado = ProveedorController.agregarProveedor(nombre, contacto, telefono, direccion);

        if (registrado) {
            System.out.println("Proveedor registrado exitosamente.");
        } else {
            System.out.println("Error al registrar el proveedor. Verifique los datos e intente nuevamente.");
        }
    }

    private void listarProveedores() {
        System.out.println("Listando proveedores...");
        ProveedorController.listarProveedores().forEach(proveedor -> {
            System.out.println("ID: " + proveedor.getIdProveedor());
            System.out.println("Nombre: " + proveedor.getNombre());
            System.out.println("Contacto: " + proveedor.getContacto());
            System.out.println("Teléfono: " + proveedor.getTelefono());
            System.out.println("Dirección: " + proveedor.getDireccion());
            System.out.println("------------------------------------");
        });
    }

    private void modificarProveedor() {
        System.out.println("Modificando proveedor");
        System.out.print("Ingrese el ID del proveedor a modificar: ");
        int idProveedor = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nuevo nombre del proveedor (deje en blanco para no modificar): ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo contacto del proveedor (deje en blanco para no modificar): ");
        String nuevoContacto = scanner.nextLine();

        System.out.print("Ingrese el nuevo teléfono del proveedor (deje en blanco para no modificar): ");
        String nuevoTelefono = scanner.nextLine();

        System.out.print("Ingrese la nueva dirección del proveedor (deje en blanco para no modificar): ");
        String nuevaDireccion = scanner.nextLine();

        boolean actualizado = ProveedorController.actualizarProveedor(idProveedor, nuevoNombre, nuevoContacto, nuevoTelefono, nuevaDireccion);

        if (actualizado) {
            System.out.println("Proveedor modificado exitosamente.");
        } else {
            System.out.println("No se encontró un proveedor con el ID proporcionado o no se pudo modificar.");
        }
    }

    private void eliminarProveedor() {
        System.out.println("Eliminando proveedor");
        System.out.print("Ingrese el ID del proveedor a eliminar: ");
        int idProveedor = scanner.nextInt();
        scanner.nextLine();

        boolean eliminado = ProveedorController.eliminarProveedor(idProveedor);

        if (eliminado) {
            System.out.println("Proveedor eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un proveedor con el ID proporcionado o no se pudo eliminar.");
        }
    }
}
