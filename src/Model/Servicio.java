package Model;

public class Servicio {
    private int idServicio;
    private String descripcion;
    private double precio;

    // Constructor
    public Servicio(int idServicio, String descripcion, double precio) {
        this.idServicio = idServicio;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Getters y setters
    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
