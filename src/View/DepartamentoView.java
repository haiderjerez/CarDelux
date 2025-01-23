package View;

import Controller.DepartamentoController;

import java.util.Scanner;

public class DepartamentoView {
    private Scanner scanner;

    public DepartamentoView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU DE GESTIÓN DE DEPARTAMENTOS *****");
            System.out.println("1. Registrar Departamento");
            System.out.println("2. Listar Departamentos");
            System.out.println("3. Modificar Departamento");
            System.out.println("4. Eliminar Departamento");
            System.out.println("5. Volver al Menú Principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarDepartamento();
                    break;
                case 2:
                    listarDepartamentos();
                    break;
                case 3:
                    modificarDepartamento();
                    break;
                case 4:
                    eliminarDepartamento();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarDepartamento() {
        System.out.println("Registro de un nuevo departamento");
        System.out.print("Ingrese el nombre del departamento: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la descripción del departamento: ");
        String descripcion = scanner.nextLine();

        try {
            DepartamentoController.agregarDepartamento(nombre, descripcion);
            System.out.println("Departamento registrado exitosamente.");
        } catch (Exception e) {
            System.out.println("Hubo un error al registrar el departamento. Intente de nuevo.");
            e.printStackTrace();
        }
    }

    private void listarDepartamentos() {
        System.out.println("Listando departamentos...");
        try {
            var departamentos = DepartamentoController.listarDepartamentos();
            if (departamentos.isEmpty()) {
                System.out.println("No hay departamentos registrados.");
            } else {
                System.out.println("Lista de Departamentos:");
                departamentos.forEach(departamento -> {
                    System.out.println("ID: " + departamento.getIdDepartamento());
                    System.out.println("Nombre: " + departamento.getNombre());
                    System.out.println("Descripción: " + departamento.getDescripcion());
                    System.out.println("--------------------");
                });
            }
        } catch (Exception e) {
            System.out.println("Hubo un error al listar los departamentos. Intente de nuevo.");
            e.printStackTrace();
        }
    }

    private void modificarDepartamento() {
        System.out.println("Modificando departamento");

        try {
            System.out.print("Ingrese el ID del departamento a modificar: ");
            int idDepartamento = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            System.out.print("Ingrese el nuevo nombre del departamento (deje en blanco para no modificar): ");
            String nuevoNombre = scanner.nextLine();

            System.out.print("Ingrese la nueva descripción del departamento (deje en blanco para no modificar): ");
            String nuevaDescripcion = scanner.nextLine();

            boolean actualizado = DepartamentoController.actualizarDepartamento(idDepartamento, nuevoNombre, nuevaDescripcion);

            if (actualizado) {
                System.out.println("Departamento modificado exitosamente.");
            } else {
                System.out.println("No se encontró un departamento con el ID proporcionado o no se pudo modificar.");
            }
        } catch (Exception e) {
            System.out.println("Hubo un error al modificar el departamento. Intente de nuevo.");
            e.printStackTrace();
        }
    }

    private void eliminarDepartamento() {
        System.out.println("Eliminando departamento");
        try {
            System.out.print("Ingrese el ID del departamento a eliminar: ");
            int idDepartamento = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            boolean eliminado = DepartamentoController.eliminarDepartamento(idDepartamento);

            if (eliminado) {
                System.out.println("Departamento eliminado exitosamente.");
            } else {
                System.out.println("No se encontró un departamento con el ID proporcionado o no se pudo eliminar.");
            }
        } catch (Exception e) {
            System.out.println("Hubo un error al eliminar el departamento. Intente de nuevo.");
            e.printStackTrace();
        }
    }
}
