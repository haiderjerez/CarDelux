package Controller;

import DB.QueryExecutor;
import Model.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {

    // Listar todos los clientes
    public List<Cliente> listarClientes() {
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
    public void agregarCliente(Cliente cliente) {
        String query = "INSERT INTO Clientes(nombre, email, telefono, direccion) VALUES(?, ?, ?, ?)";
        Object[] params = {cliente.getNombre(), cliente.getEmail(), cliente.getTelefono(), cliente.getDireccion()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Actualizar un cliente existente
    public void actualizarCliente(Cliente cliente) {
        String query = "UPDATE Clientes SET nombre = ?, email = ?, telefono = ?, direccion = ? WHERE id_cliente = ?";
        Object[] params = {cliente.getNombre(), cliente.getEmail(), cliente.getTelefono(), cliente.getDireccion(), cliente.getIdCliente()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Eliminar un cliente
    public void eliminarCliente(int idCliente) {
        String query = "DELETE FROM Clientes WHERE id_cliente = ?";
        Object[] params = {idCliente};
        QueryExecutor.executePreparedUpdate(query, params);
    }
}
