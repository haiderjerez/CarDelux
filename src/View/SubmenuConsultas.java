package View;

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
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listarVehiculosDisponibles();
                    break;
                case 2:
                    clientesConComprasRecientes();
                    break;
                case 3:
                    historialServiciosPorVehiculo();
                    break;
                case 4:
                    proveedoresPiezasUtilizados();
                    break;
                case 5:
                    rendimientoPersonalVentas();
                    break;
                case 6:
                    serviciosRealizadosPorEmpleado();
                    break;
                case 7:
                    clientesPotencialesVehiculosInteres();
                    break;
                case 8:
                    empleadosDepartamentoServicio();
                    break;
                case 9:
                    vehiculosVendidosEnRangoPrecios();
                    break;
                case 10:
                    clientesConMultiplesCompras();
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private void listarVehiculosDisponibles() {
        // Lógica para listar vehículos disponibles
        System.out.println("Listando vehículos disponibles...");
        // Aquí puedes agregar la lógica para obtener los vehículos disponibles de la base de datos
    }

    private void clientesConComprasRecientes() {
        // Lógica para listar clientes con compras recientes
        System.out.println("Consultando clientes con compras recientes...");
        // Lógica para mostrar los clientes con compras recientes
    }

    private void historialServiciosPorVehiculo() {
        // Lógica para consultar historial de servicios por vehículo
        System.out.println("Consultando historial de servicios por vehículo...");
        // Lógica para obtener los servicios realizados por vehículo
    }

    private void proveedoresPiezasUtilizados() {
        // Lógica para consultar proveedores de piezas utilizados
        System.out.println("Consultando proveedores de piezas utilizados...");
        // Lógica para consultar los proveedores de piezas
    }

    private void rendimientoPersonalVentas() {
        // Lógica para consultar rendimiento del personal de ventas
        System.out.println("Consultando rendimiento del personal de ventas...");
        // Lógica para obtener el rendimiento de ventas de los empleados
    }

    private void serviciosRealizadosPorEmpleado() {
        // Lógica para consultar los servicios realizados por un empleado
        System.out.println("Consultando servicios realizados por un empleado...");
        // Lógica para mostrar los servicios realizados por empleados
    }

    private void clientesPotencialesVehiculosInteres() {
        // Lógica para consultar clientes potenciales y vehículos de interés
        System.out.println("Consultando clientes potenciales y vehículos de interés...");
        // Lógica para mostrar clientes potenciales y los vehículos de interés
    }

    private void empleadosDepartamentoServicio() {
        // Lógica para consultar empleados del departamento de servicio
        System.out.println("Consultando empleados del departamento de servicio...");
        // Lógica para mostrar los empleados de servicio
    }

    private void vehiculosVendidosEnRangoPrecios() {
        // Lógica para consultar vehículos vendidos en un rango de precios
        System.out.println("Consultando vehículos vendidos en un rango de precios...");
        // Lógica para obtener los vehículos vendidos dentro de un rango de precios
    }

    private void clientesConMultiplesCompras() {
        // Lógica para consultar clientes con múltiples compras
        System.out.println("Consultando clientes con múltiples compras...");
        // Lógica para mostrar los clientes con múltiples compras
    }
}
