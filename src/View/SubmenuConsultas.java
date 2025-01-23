package View;

import Controller.ConsultaController;

import java.util.Scanner;

public class SubmenuConsultas {
    private Scanner scanner;

    public SubmenuConsultas() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** SUBMENU 8. Consultas *****");
            System.out.println("1. Listar Vehículos Disponibles");
            System.out.println("2. Clientes con Compras Recientes");
            System.out.println("3. Historial de Servicios por Vehículo");
            System.out.println("4. Proveedores de Piezas Utilizados");
            System.out.println("5. Rendimiento del Personal de Ventas");
            System.out.println("6. Servicios Realizados por un Empleado");
            System.out.println("7. Clientes Potenciales y Vehículos de Interés");
            System.out.println("8. Empleados del Departamento de Servicio");
            System.out.println("9. Vehículos Vendidos en un Rango de Precios");
            System.out.println("10. Clientes con Múltiples Compras");
            System.out.println("11. Volver al menú principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ConsultaController.listarVehiculosDisponibles();
                    break;
                case 2:
                    ConsultaController.clientesConComprasRecientes();
                    break;
                case 3:
                    ConsultaController.historialServiciosPorVehiculo();
                    break;
                case 4:
                    ConsultaController.proveedoresDePiezasUtilizados();
                    break;
                case 5:
                    ConsultaController.rendimientoPersonalVentas();
                    break;
                case 6:
                    ConsultaController.serviciosPorEmpleado();
                    break;
                case 7:
                    ConsultaController.clientesPotencialesYVehiculosInteres();
                    break;
                case 8:
                    ConsultaController.empleadosDepartamentoServicio();
                    break;
                case 9:
                    ConsultaController.vehiculosVendidosEnRangoPrecios();
                    break;
                case 10:
                    ConsultaController.clientesConMultiplesCompras();
                    break;
                case 11:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 11);
    }
}
