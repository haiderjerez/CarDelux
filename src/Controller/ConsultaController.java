package Controller;

import DB.QueryExecutor;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaController {

    // 1. Listar Vehículos Disponibles
    public static void listarVehiculosDisponibles() {
        String query = "SELECT vehiculos.marca, vehiculos.modelo, vehiculos.year_carro AS year, vehiculos.precio, estado.nombre AS estado FROM vehiculos JOIN estado ON vehiculos.id_estados = estado.id_estado";
        ejecutarConsulta(query);
    }

    // 2. Clientes con Compras Recientes
    public static void clientesConComprasRecientes() {
        String query = "SELECT clientes.nombre, clientes.apellido, vehiculos.marca, vehiculos.modelo, ventas.fecha_venta FROM Clientes JOIN Ventas ON clientes.id_cliente = ventas.id_cliente JOIN Vehiculos ON ventas.id_vehiculo = vehiculos.id_vehiculo WHERE ventas.fecha_venta >= CURRENT_DATE - INTERVAL '30 days'";
        ejecutarConsulta(query);
    }

    // 3. Historial de Servicios por Vehículo
    public static void historialServiciosPorVehiculo() {
        String query = "SELECT servicios.descripcion, servicios.fecha_servicio, empleados.nombre, empleados.apellido FROM Servicios JOIN Empleados ON servicios.id_empleado = empleados.id_empleado WHERE servicios.id_vehiculo = 1";
        ejecutarConsulta(query);
    }

    // 4. Proveedores de Piezas Utilizados
    public static void proveedoresDePiezasUtilizados() {
        String query = "SELECT DISTINCT proveedores.nombre FROM Piezas JOIN Proveedores ON piezas.id_proveedor = proveedores.id_proveedor JOIN Servicios s ON s.id_servicio = piezas.id_pieza";
        ejecutarConsulta(query);
    }

    // 5. Rendimiento del Personal de Ventas
    public static void rendimientoPersonalVentas() {
        String query = "SELECT empleados.nombre, empleados.apellido, SUM(ventas.comision) AS total_comisiones FROM Empleados JOIN Ventas ON empleados.id_empleado = ventas.id_empleado WHERE empleados.id_departamento = 'Ventas' GROUP BY empleados.id_empleado";
        ejecutarConsulta(query);
    }

    // 6. Servicios Realizados por un Empleado
    public static void serviciosPorEmpleado() {
        String query = "SELECT servicios.descripcion, servicios.fecha_servicio, vehiculos.marca, vehiculos.modelo FROM Servicios JOIN Vehiculos ON servicios.id_vehiculo = vehiculos.id_vehiculo WHERE servicios.id_empleado = 1";
        ejecutarConsulta(query);
    }

    // 7. Clientes Potenciales y Vehículos de Interés
    public static void clientesPotencialesYVehiculosInteres() {
        String query = "SELECT * FROM clientespotenciales";
        ejecutarConsulta(query);
    }

    // 8. Empleados del Departamento de Servicio
    public static void empleadosDepartamentoServicio() {
        String query = "SELECT empleados.nombre AS nombre, empleados.horario AS horario, departamento.nombre AS departamento FROM empleados JOIN departamento ON empleados.id_departamento = departamento.id_departamento WHERE departamento.nombre = 'servicios'";
        ejecutarConsulta(query);
    }

    // 9. Vehículos Vendidos en un Rango de Precios
    public static void vehiculosVendidosEnRangoPrecios() {
        String query = "SELECT vehiculos.marca AS marca, vehiculos.modelo AS modelo, vehiculos.precio AS precio, estado.nombre AS estado FROM vehiculos JOIN estado ON vehiculos.id_estados = estado.id_estado WHERE vehiculos.precio BETWEEN 20000 AND 50000";
        ejecutarConsulta(query);
    }

    // 10. Clientes con Múltiples Compras
    public static void clientesConMultiplesCompras() {
        String query = "SELECT c.nombre, c.apellido, COUNT(ve.id_venta) AS compras_realizadas FROM Clientes c JOIN Ventas ve ON c.id_cliente = ve.id_cliente GROUP BY c.id_cliente HAVING COUNT(ve.id_venta) > 1";
        ejecutarConsulta(query);
    }

    // Método auxiliar para ejecutar consultas y mostrar resultados utilizando QueryExecutor
    private static void ejecutarConsulta(String query) {
        try (ResultSet rs = QueryExecutor.executeQuery(query)) {
            while (rs.next()) {
                int columnCount = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print(rs.getMetaData().getColumnName(i) + ": " + rs.getString(i) + "  ");
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("Error ejecutando la consulta: " + e.getMessage());
        }
    }
}