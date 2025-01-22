package Controller;

import DB.QueryExecutor;
import Model.Vehiculo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehiculoController {

    // Listar todos los vehículos
    public List<Vehiculo> listarVehiculos() {
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
    public void agregarVehiculo(Vehiculo vehiculo) {
        String query = "INSERT INTO Vehiculos(marca, modelo, year_carro, id_estados, precio) VALUES(?, ?, ?, ?, ?)";
        Object[] params = {vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getYearCarro(), vehiculo.getIdEstado(), vehiculo.getPrecio()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Actualizar un vehículo existente
    public void actualizarVehiculo(Vehiculo vehiculo) {
        String query = "UPDATE Vehiculos SET marca = ?, modelo = ?, year_carro = ?, id_estados = ?, precio = ? WHERE id_vehiculo = ?";
        Object[] params = {vehiculo.getMarca(), vehiculo.getModelo(), vehiculo.getYearCarro(), vehiculo.getIdEstado(), vehiculo.getPrecio(), vehiculo.getIdVehiculo()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Eliminar un vehículo
    public void eliminarVehiculo(int idVehiculo) {
        String query = "DELETE FROM Vehiculos WHERE id_vehiculo = ?";
        Object[] params = {idVehiculo};
        QueryExecutor.executePreparedUpdate(query, params);
    }
}
