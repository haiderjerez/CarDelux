package Model;

import java.sql.Date;

public class Venta {
    private int idVenta;
    private int idCliente;
    private int idVehiculo;
    private Date fechaVenta;
    private double monto;

    // Constructor
    public Venta(int idVenta, int idCliente, int idVehiculo, Date fechaVenta, double monto) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idVehiculo = idVehiculo;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
    }

    // Getters y setters
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
