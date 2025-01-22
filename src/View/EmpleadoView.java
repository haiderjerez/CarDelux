package View;

import java.util.Scanner;

public class EmpleadoView {
    private Scanner scanner;

    public EmpleadoView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU DE GESTIÓN DE EMPLEADOS *****");
            System.out.println("1. Registrar Empleado");
            System.out.println("2. Listar Empleados");
            System.out.println("3. Modificar Empleado");
            System.out.println("4. Eliminar Empleado");
            System.out.println("5. Volver al Menú Principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarEmpleado();
                    break;
                case 2:
                    listarEmpleados();
                    break;
                case 3:
                    modificarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarEmpleado() {
        System.out.println("Registro de un nuevo empleado");
        // Lógica para registrar empleado (ingreso de datos)
    }

    private void listarEmpleados() {
        System.out.println("Listando empleados...");
        // Lógica para listar empleados registrados
    }

    private void modificarEmpleado() {
        System.out.println("Modificando empleado");
        // Lógica para modificar datos de un empleado
    }

    private void eliminarEmpleado() {
        System.out.println("Eliminando empleado");
        // Lógica para eliminar empleado
    }
}
