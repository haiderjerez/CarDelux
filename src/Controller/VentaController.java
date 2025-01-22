package Controller;

import DB.QueryExecutor;
import Model.Venta;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaController {

    // Listar todas las ventas
    public List<Venta> listarVentas() {
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
                        rs.getDouble("monto")
                );
                ventas.add(venta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ventas;
    }

    // Agregar una nueva venta
    public void agregarVenta(Venta venta) {
        String query = "INSERT INTO Ventas(id_cliente, id_vehiculo, fecha_venta, monto) VALUES(?, ?, ?, ?)";
        Object[] params = {venta.getIdCliente(), venta.getIdVehiculo(), venta.getFechaVenta(), venta.getMonto()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Actualizar una venta existente
    public void actualizarVenta(Venta venta) {
        String query = "UPDATE Ventas SET id_cliente = ?, id_vehiculo = ?, fecha_venta = ?, monto = ? WHERE id_venta = ?";
        Object[] params = {venta.getIdCliente(), venta.getIdVehiculo(), venta.getFechaVenta(), venta.getMonto(), venta.getIdVenta()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Eliminar una venta
    public void eliminarVenta(int idVenta) {
        String query = "DELETE FROM Ventas WHERE id_venta = ?";
        Object[] params = {idVenta};
        QueryExecutor.executePreparedUpdate(query, params);
    }
}
