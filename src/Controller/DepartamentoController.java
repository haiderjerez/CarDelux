package Controller;

import DB.QueryExecutor;
import Model.Departamento;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoController {

    // Listar todos los departamentos
    public List<Departamento> listarDepartamentos() {
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
    public void agregarDepartamento(Departamento departamento) {
        String query = "INSERT INTO Departamentos(nombre, descripcion) VALUES(?, ?)";
        Object[] params = {departamento.getNombre(), departamento.getDescripcion()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Actualizar un departamento existente
    public void actualizarDepartamento(Departamento departamento) {
        String query = "UPDATE Departamentos SET nombre = ?, descripcion = ? WHERE id_departamento = ?";
        Object[] params = {departamento.getNombre(), departamento.getDescripcion(), departamento.getIdDepartamento()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Eliminar un departamento
    public void eliminarDepartamento(int idDepartamento) {
        String query = "DELETE FROM Departamentos WHERE id_departamento = ?";
        Object[] params = {idDepartamento};
        QueryExecutor.executePreparedUpdate(query, params);
    }
}
