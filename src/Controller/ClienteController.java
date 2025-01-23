package Controller;

import DB.QueryExecutor;
import Model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    // Listar todos los clientes
    public static List<Cliente> listarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM Clientes";
        ResultSet rs = QueryExecutor.executeQuery(query);
        try {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono"),
                        rs.getString("direccion")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Agregar un nuevo cliente
    public static boolean agregarCliente(Cliente cliente) {
        String query = "INSERT INTO Clientes(nombre, telefono, direccion) VALUES(?, ?, ?, ?)";
        Object[] params = {cliente.getNombre(), cliente.getTelefono(), cliente.getDireccion()};
        return QueryExecutor.executePreparedUpdate(query, params) > 0;
    }

    // Actualizar un cliente
    public static boolean actualizarCliente(int idCliente, String nuevoNombre, String nuevoDireccion, String nuevoTelefono) {
        String query = "UPDATE Clientes SET nombre = ?, telefono = ?, direccion = ? WHERE id_cliente = ?";
        Object[] params = {nuevoNombre, nuevoTelefono, nuevoDireccion, idCliente};
        return QueryExecutor.executePreparedUpdate(query, params) > 0;
    }

    // Eliminar un cliente
    public static boolean eliminarCliente(int idCliente) {
        String query = "DELETE FROM Clientes WHERE id_cliente = ?";
        Object[] params = {idCliente};
        QueryExecutor.executePreparedUpdate(query, params);
        return false;
    }
}
