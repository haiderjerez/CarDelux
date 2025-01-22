package Model;

public class ClientePotencial {
    private int idClientePotencial;
    private String nombre;
    private String email;
    private String telefono;

    // Constructor
    public ClientePotencial(int idClientePotencial, String nombre, String email, String telefono) {
        this.idClientePotencial = idClientePotencial;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y setters
    public int getIdClientePotencial() {
        return idClientePotencial;
    }

    public void setIdClientePotencial(int idClientePotencial) {
        this.idClientePotencial = idClientePotencial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
