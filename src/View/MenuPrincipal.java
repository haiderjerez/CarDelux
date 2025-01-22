package View;

import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;

    public MenuPrincipal() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU PRINCIPAL DEL CONCESIONARIO *****");
            System.out.println("1. Gestión de Vehículos");
            System.out.println("2. Gestión de Clientes");
            System.out.println("3. Gestión de Ventas");
            System.out.println("4. Gestión de Servicios");
            System.out.println("5. Gestión de Proveedores");
            System.out.println("6. Gestión de Empleados");
            System.out.println("7. Gestión de Departamentos");
            System.out.println("8. Consultas");
            System.out.println("9. Salir");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Llamar a la vista de vehículos
                    new VehiculoView().mostrarMenu();
                    break;
                case 2:
                    // Llamar a la vista de clientes
                    new ClienteView().mostrarMenu();
                    break;
                case 3:
                    // Llamar a la vista de ventas
                    new VentaView().mostrarMenu();
                    break;
                case 4:
                    // Llamar a la vista de servicios
                    new ServicioView().mostrarMenu();
                    break;
                case 5:
                    // Llamar a la vista de proveedores
                    new ProveedorView().mostrarMenu();
                    break;
                case 6:
                    // Llamar a la vista de empleados
                    new EmpleadoView().mostrarMenu();
                    break;
                case 7:
                    // Llamar a la vista de departamentos
                    new DepartamentoView().mostrarMenu();
                    break;
                case 8:
                    // Llamar al submenú de consultas
                    new SubmenuConsultas().mostrarMenu();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 9);
    }
}
