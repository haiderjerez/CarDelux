package Controller;

import DB.QueryExecutor;
import Model.Proveedor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorController {

    // Listar todos los proveedores
    public static List<Proveedor> listarProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String query = "SELECT * FROM Proveedores";
        ResultSet rs = QueryExecutor.executeQuery(query);
        try {
            while (rs.next()) {
                Proveedor proveedor = new Proveedor(
                        rs.getInt("id_proveedor"),
                        rs.getString("nombre"),
                        rs.getString("contacto"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                );
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }

    // Agregar un nuevo proveedor
    public static boolean agregarProveedor(String nombre, String contacto, String telefono, String direccion) {
        String query = "INSERT INTO Proveedores(nombre, contacto, telefono, direccion) VALUES(?, ?, ?, ?)";
        Object[] params = {nombre, contacto, telefono, direccion};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }

    // Actualizar un proveedor existente
    public static boolean actualizarProveedor(int idProveedor, String nuevoNombre, String nuevoContacto, String nuevoTelefono, String nuevaDireccion) {
        String query = "UPDATE Proveedores SET nombre = ?, contacto = ?, telefono = ?, direccion = ? WHERE id_proveedor = ?";
        Object[] params = {nuevoNombre, nuevoContacto, nuevoTelefono, nuevaDireccion, idProveedor};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }

    // Eliminar un proveedor
    public static boolean eliminarProveedor(int idProveedor) {
        String query = "DELETE FROM Proveedores WHERE id_proveedor = ?";
        Object[] params = {idProveedor};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }
}
