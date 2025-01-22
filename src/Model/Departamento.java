package Model;

public class Departamento {
    private int idDepartamento;
    private String nombre;
    private String descripcion;

    // Constructor
    public Departamento(int idDepartamento, String nombre, String descripcion) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    // Getters y setters
    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
