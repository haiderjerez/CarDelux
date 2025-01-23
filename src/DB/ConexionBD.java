package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Parámetros de conexión - ¡Cámbialos según tu configuración!
    private static final String URL = "jdbc:postgresql://localhost:5432/deluxcar";
    private static final String USUARIO = "postgres";
    private static final String CONTRASEÑA = "campus2023";

    // Método para obtener la conexión
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Cargar el driver de PostgreSQL
            Class.forName("org.postgresql.Driver");
            // Establecer la conexión
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo cargar el driver de PostgreSQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: No se pudo conectar a la base de datos.");
            e.printStackTrace();
        }
        return conexion;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println("Conexión cerrada correctamente.");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión.");
                e.printStackTrace();
            }
        }
    }
}
