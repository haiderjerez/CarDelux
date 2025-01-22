package Model;

public class Vehiculo {
    private int idVehiculo;
    private String marca;
    private String modelo;
    private int yearCarro;
    private int idEstado;
    private double precio;

    // Constructor
    public Vehiculo(int idVehiculo, String marca, String modelo, int yearCarro, int idEstado, double precio) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.yearCarro = yearCarro;
        this.idEstado = idEstado;
        this.precio = precio;
    }

    // Getters y setters
    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getYearCarro() {
        return yearCarro;
    }

    public void setYearCarro(int yearCarro) {
        this.yearCarro = yearCarro;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
