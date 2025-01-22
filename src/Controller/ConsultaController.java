package Controller;

import DB.QueryExecutor;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaController {

    // Consulta personalizada, por ejemplo, clientes que han comprado un vehículo
    public ResultSet clientesQueHanCompradoVehiculos() {
        String query = "SELECT c.nombre, c.email, v.fecha_venta, v.monto " +
                "FROM Clientes c " +
                "JOIN Ventas v ON c.id_cliente = v.id_cliente";
        return QueryExecutor.executeQuery(query);
    }

    // Otra consulta, por ejemplo, ventas de un vehículo específico
    public ResultSet ventasDeVehiculo(int idVehiculo) {
        String query = "SELECT v.id_venta, c.nombre, v.fecha_venta, v.monto " +
                "FROM Ventas v " +
                "JOIN Clientes c ON v.id_cliente = c.id_cliente " +
                "WHERE v.id_vehiculo = ?";
        Object[] params = {idVehiculo};
        return QueryExecutor.executePreparedQuery(query, params);
    }
}
