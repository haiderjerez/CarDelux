package Controller;

import DB.QueryExecutor;
import Model.Servicio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicioController {

    // Listar todos los servicios
    public static List<Servicio> listarServicios() {
        List<Servicio> servicios = new ArrayList<>();
        String query = "SELECT * FROM Servicios";
        ResultSet rs = QueryExecutor.executeQuery(query);
        try {
            while (rs.next()) {
                Servicio servicio = new Servicio(
                        rs.getInt("id_servicio"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio")
                );
                servicios.add(servicio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return servicios;
    }

    // Agregar un nuevo servicio
    public static boolean agregarServicio(String descripcion, String s, double precio) {
        String query = "INSERT INTO Servicios(descripcion, precio) VALUES(?, ?)";
        Object[] params = {descripcion, precio};
        QueryExecutor.executePreparedUpdate(query, params);
        return true;
    }

    // Actualizar un servicio existente
    public void actualizarServicio(Servicio servicio) {
        String query = "UPDATE Servicios SET descripcion = ?, precio = ? WHERE id_servicio = ?";
        Object[] params = {servicio.getDescripcion(), servicio.getPrecio(), servicio.getIdServicio()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Eliminar un servicio
    public static boolean eliminarServicio(int idServicio) {
        String query = "DELETE FROM Servicios WHERE id_servicio = ?";
        Object[] params = {idServicio};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }
}
