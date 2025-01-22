package View;

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
        // Lógica para registrar departamento (ingreso de datos)
    }

    private void listarDepartamentos() {
        System.out.println("Listando departamentos...");
        // Lógica para listar departamentos registrados
    }

    private void modificarDepartamento() {
        System.out.println("Modificando departamento");
        // Lógica para modificar datos de un departamento
    }

    private void eliminarDepartamento() {
        System.out.println("Eliminando departamento");
        // Lógica para eliminar departamento
    }
}
