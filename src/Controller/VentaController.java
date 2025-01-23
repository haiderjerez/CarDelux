package Controller;

import DB.QueryExecutor;
import Model.Venta;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaController {

    // Listar todas las ventas
    public static List<Venta> listarVentas() {
        List<Venta> ventas = new ArrayList<>();
        String query = "SELECT * FROM Ventas";
        ResultSet rs = QueryExecutor.executeQuery(query);
        try {
            while (rs.next()) {
                Venta venta = new Venta(
                        rs.getInt("id_venta"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_vehiculo"),
                        rs.getDate("fecha_venta"),
                        rs.getDouble("monto"),
                        rs.getDouble("comision"),
                        rs.getInt("id_empleado")
                );
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    // Agregar una nueva venta
    public static boolean agregarVenta(int idCliente, int idVehiculo, String fechaVenta, double precioVenta, double comision, int idEmpleado) {
        String query = "INSERT INTO Ventas(id_cliente, id_vehiculo, fecha_venta, monto) VALUES(?, ?, ?, ?)";
        try {
            Object[] params = {idCliente, idVehiculo, Date.valueOf(fechaVenta), precioVenta};
            return QueryExecutor.executePreparedUpdate(query, params) > 0;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Actualizar una venta existente
    public static boolean actualizarVenta(int idVenta, int nuevoIdCliente, int nuevoIdVehiculo, String nuevaFechaVenta, double nuevoPrecioVenta, double nuevaComision, int nuevoIdEmpleado) {
        String query = "UPDATE Ventas SET id_cliente = ?, id_vehiculo = ?, fecha_venta = ?, monto = ?, comision = ?, id_empleado = ? WHERE id_venta = ?";
        Object[] params = {nuevoIdCliente, nuevoIdVehiculo, Date.valueOf(nuevaFechaVenta), nuevoPrecioVenta, nuevaComision, nuevoIdEmpleado, idVenta};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }

    // Eliminar una venta
    public static boolean eliminarVenta(int idVenta) {
        String query = "DELETE FROM Ventas WHERE id_venta = ?";
        Object[] params = {idVenta};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }
}
