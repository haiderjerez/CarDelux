package Controller;

import DB.QueryExecutor;
import Model.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoController {

    // Listar todos los empleados
    public List<Empleado> listarEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT * FROM Empleados";
        ResultSet rs = QueryExecutor.executeQuery(query);
        try {
            while (rs.next()) {
                Empleado empleado = new Empleado(
                        rs.getInt("id_empleado"),
                        rs.getString("nombre"),
                        rs.getString("puesto"),
                        rs.getString("telefono"),
                        rs.getDouble("salario")
                );
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    // Agregar un nuevo empleado
    public void agregarEmpleado(Empleado empleado) {
        String query = "INSERT INTO Empleados(nombre, puesto, telefono, salario) VALUES(?, ?, ?, ?)";
        Object[] params = {empleado.getNombre(), empleado.getPuesto(), empleado.getTelefono(), empleado.getSalario()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Actualizar un empleado existente
    public void actualizarEmpleado(Empleado empleado) {
        String query = "UPDATE Empleados SET nombre = ?, puesto = ?, telefono = ?, salario = ? WHERE id_empleado = ?";
        Object[] params = {empleado.getNombre(), empleado.getPuesto(), empleado.getTelefono(), empleado.getSalario(), empleado.getIdEmpleado()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Eliminar un empleado
    public void eliminarEmpleado(int idEmpleado) {
        String query = "DELETE FROM Empleados WHERE id_empleado = ?";
        Object[] params = {idEmpleado};
        QueryExecutor.executePreparedUpdate(query, params);
    }
}
