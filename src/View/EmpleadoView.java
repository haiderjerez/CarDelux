package View;

import Controller.EmpleadoController;

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
            scanner.nextLine(); 

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

        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del empleado: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese el cargo del empleado: ");
        String cargo = scanner.nextLine();

        System.out.print("Ingrese el salario del empleado: ");
        double salario = scanner.nextDouble();
        scanner.nextLine(); 

        boolean registrado = EmpleadoController.agregarEmpleado(nombre, apellido, cargo, salario);

        if (registrado) {
            System.out.println("Empleado registrado exitosamente.");
        } else {
            System.out.println("Ocurrió un error al registrar el empleado.");
        }
    }

    private void listarEmpleados() {
        System.out.println("Listando empleados...");
        var empleados = EmpleadoController.listarEmpleados();

        if (empleados == null || empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            empleados.forEach(empleado -> {
                System.out.println("ID: " + empleado.getIdEmpleado());
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Apellido: " + empleado.getApellido());
                System.out.println("Cargo: " + empleado.getPuesto());
                System.out.println("Salario: " + empleado.getSalario());
                System.out.println("-----------------------------");
            });
        }
    }

    private void modificarEmpleado() {
        System.out.println("Modificando empleado");

        System.out.print("Ingrese el ID del empleado a modificar: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el nuevo nombre del empleado (deje en blanco para no modificar): ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese el nuevo apellido del empleado (deje en blanco para no modificar): ");
        String nuevoApellido = scanner.nextLine();

        System.out.print("Ingrese el nuevo cargo del empleado (deje en blanco para no modificar): ");
        String nuevoPuesto = scanner.nextLine();

        System.out.print("Ingrese el nuevo salario del empleado (-1 para no modificar): ");
        double nuevoSalario = scanner.nextDouble();
        scanner.nextLine(); 

        boolean actualizado = EmpleadoController.actualizarEmpleado(
                idEmpleado,
                nuevoNombre.isEmpty() ? null : nuevoNombre,
                nuevoApellido.isEmpty() ? null : nuevoApellido,
                nuevoPuesto.isEmpty() ? null : nuevoPuesto,
                nuevoSalario == -1 ? null : nuevoSalario
        );

        if (actualizado) {
            System.out.println("Empleado modificado exitosamente.");
        } else {
            System.out.println("No se encontró un empleado con el ID proporcionado o no se pudo modificar.");
        }
    }

    private void eliminarEmpleado() {
        System.out.println("Eliminando empleado");

        System.out.print("Ingrese el ID del empleado a eliminar: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();

        boolean eliminado = EmpleadoController.eliminarEmpleado(idEmpleado);

        if (eliminado) {
            System.out.println("Empleado eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un empleado con el ID proporcionado o no se pudo eliminar.");
        }
    }
}
