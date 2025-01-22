package Controller;

import DB.QueryExecutor;
import Model.ClientePotencial;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientePotencialController {

    // Listar todos los clientes potenciales
    public List<ClientePotencial> listarClientesPotenciales() {
        List<ClientePotencial> clientesPotenciales = new ArrayList<>();
        String query = "SELECT * FROM ClientesPotenciales";
        ResultSet rs = QueryExecutor.executeQuery(query);
        try {
            while (rs.next()) {
                ClientePotencial clientePotencial = new ClientePotencial(
                        rs.getInt("id_cliente_potencial"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("telefono")
                );
                clientesPotenciales.add(clientePotencial);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientesPotenciales;
    }

    // Agregar un nuevo cliente potencial
    public void agregarClientePotencial(ClientePotencial clientePotencial) {
        String query = "INSERT INTO ClientesPotenciales(nombre, email, telefono) VALUES(?, ?, ?)";
        Object[] params = {clientePotencial.getNombre(), clientePotencial.getEmail(), clientePotencial.getTelefono()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Actualizar un cliente potencial existente
    public void actualizarClientePotencial(ClientePotencial clientePotencial) {
        String query = "UPDATE ClientesPotenciales SET nombre = ?, email = ?, telefono = ? WHERE id_cliente_potencial = ?";
        Object[] params = {clientePotencial.getNombre(), clientePotencial.getEmail(), clientePotencial.getTelefono(), clientePotencial.getIdClientePotencial()};
        QueryExecutor.executePreparedUpdate(query, params);
    }

    // Eliminar un cliente potencial
    public void eliminarClientePotencial(int idClientePotencial) {
        String query = "DELETE FROM ClientesPotenciales WHERE id_cliente_potencial = ?";
        Object[] params = {idClientePotencial};
        QueryExecutor.executePreparedUpdate(query, params);
    }
}
