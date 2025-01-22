package Controller;

import DB.QueryExecutor;
import Model.Proveedor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorController {

    // Listar todos los proveedores
    public List<Proveedor> listarProveedores() {
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
    public void agregarProveedor(Proveedor proveedor) {
        String query = "INSERT INTO Proveedores(nombre, contacto, telefono, direccion) VALUES(?, ?, ?, ?)";
        Object[] params = {proveedor.getNombre(), proveedor.getContacto(), proveedor.getTelefono(), proveedor.getDireccion()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Actualizar un proveedor existente
    public void actualizarProveedor(Proveedor proveedor) {
        String query = "UPDATE Proveedores SET nombre = ?, contacto = ?, telefono = ?, direccion = ? WHERE id_proveedor = ?";
        Object[] params = {proveedor.getNombre(), proveedor.getContacto(), proveedor.getTelefono(), proveedor.getDireccion(), proveedor.getIdProveedor()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Eliminar un proveedor
    public void eliminarProveedor(int idProveedor) {
        String query = "DELETE FROM Proveedores WHERE id_proveedor = ?";
        Object[] params = {idProveedor};
        QueryExecutor.executePreparedUpdate(query, params);
    }
}
