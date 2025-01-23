package Controller;

import DB.QueryExecutor;
import Model.Departamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoController {

    // Listar todos los departamentos
    public static List<Departamento> listarDepartamentos() {
        List<Departamento> departamentos = new ArrayList<>();
        String query = "SELECT * FROM Departamentos";
        ResultSet rs = QueryExecutor.executeQuery(query);
        try {
            while (rs.next()) {
                Departamento departamento = new Departamento(
                        rs.getInt("id_departamento"),
                        rs.getString("nombre"),
                        rs.getString("descripcion")
                );
                departamentos.add(departamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamentos;
    }

    // Agregar un nuevo departamento
    public static void agregarDepartamento(String nombre, String descripcion) {
        String query = "INSERT INTO Departamentos(nombre, descripcion) VALUES(?, ?)";
        Object[] params = {nombre, descripcion};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Actualizar un departamento existente
    public static boolean actualizarDepartamento(int idDepartamento, String nuevoNombre, String nuevaDescripcion) {
        String query = "UPDATE Departamentos SET nombre = ?, descripcion = ? WHERE id_departamento = ?";
        Object[] params = {nuevoNombre, nuevaDescripcion, idDepartamento};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }

    // Eliminar un departamento
    public static boolean eliminarDepartamento(int idDepartamento) {
        String query = "DELETE FROM Departamentos WHERE id_departamento = ?";
        Object[] params = {idDepartamento};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }
}
