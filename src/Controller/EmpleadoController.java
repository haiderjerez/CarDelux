package Controller;

import DB.QueryExecutor;
import Model.Empleado;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoController {

    // Listar todos los empleados
    public static List<Empleado> listarEmpleados() {
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
    public static boolean agregarEmpleado(String nombre, String apellido, String cargo, double salario) {
        String query = "INSERT INTO Empleados(nombre, puesto, telefono, salario) VALUES(?, ?, ?, ?)";
        Object[] params = {nombre, apellido, cargo, salario};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }

    // Actualizar un empleado existente
    public static boolean actualizarEmpleado(int idEmpleado, String nuevoNombre, String nuevoApellido, String nuevoPuesto, double nuevoSalario) {
        String query = "UPDATE Empleados SET nombre = ?, puesto = ?, telefono = ?, salario = ? WHERE id_empleado = ?";
        Object[] params = {nuevoNombre, nuevoApellido, nuevoPuesto, nuevoSalario, idEmpleado};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }

    // Eliminar un empleado
    public static boolean eliminarEmpleado(int idEmpleado) {
        String query = "DELETE FROM Empleados WHERE id_empleado = ?";
        Object[] params = {idEmpleado};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }
}
