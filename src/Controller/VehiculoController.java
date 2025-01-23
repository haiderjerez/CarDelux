package Controller;

import DB.QueryExecutor;
import Model.Vehiculo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoController {

    // Listar todos los vehículos
    public static List<Vehiculo> listarVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        String query = "SELECT * FROM Vehiculos";
        ResultSet rs = QueryExecutor.executeQuery(query);
        try {
            while (rs.next()) {
                Vehiculo vehiculo = new Vehiculo(
                        rs.getInt("id_vehiculo"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("year_carro"),
                        rs.getInt("id_estados"),
                        rs.getDouble("precio")
                );
                vehiculos.add(vehiculo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehiculos;
    }

    // Agregar un nuevo vehículo
    public static boolean agregarVehiculo(String marca, String modelo, int year_carro, double precio) {
        String query = "INSERT INTO Vehiculos(marca, modelo, year_carro, id_estados, precio) VALUES(?, ?, ?, ?, ?)";
        Object[] params = {marca, modelo, year_carro, 1, precio}; // Assuming default id_estados = 1
        QueryExecutor.executePreparedUpdate(query, params);
        return true;
    }

    // Actualizar un vehículo existente
    public static boolean actualizarVehiculo(int idVehiculo, String nuevaMarca, String nuevoModelo, int nuevoAnio, double nuevoPrecio) {
        String query = "UPDATE Vehiculos SET marca = ?, modelo = ?, year_carro = ?, precio = ? WHERE id_vehiculo = ?";
        Object[] params = {nuevaMarca, nuevoModelo, nuevoAnio, nuevoPrecio, idVehiculo};
        QueryExecutor.executePreparedUpdate(query, params);
        return true;
    }

    // Eliminar un vehículo
    public static boolean eliminarVehiculo(int idVehiculo) {
        String query = "DELETE FROM Vehiculos WHERE id_vehiculo = ?";
        Object[] params = {idVehiculo};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }
}
