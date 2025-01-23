package Model;

import java.sql.Date;

public class Venta {
    private int idVenta;
    private int idCliente;
    private int idVehiculo;
    private Date fechaVenta;
    private double monto;
    private double comision;
    private int idEmpleado;

    // Constructor
    public Venta(int idVenta, int idCliente, int idVehiculo, Date fechaVenta, double monto, double comision, int idEmpleado) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idVehiculo = idVehiculo;
        this.fechaVenta = fechaVenta;
        this.monto = monto;
        this.comision = comision;
        this.idEmpleado = idEmpleado;
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
    public double getComision() {
        return comision;
    }
    public void setComision(double comision) {
        this.comision = comision;
    }
    public int getIdEmpleado() {
        return idEmpleado;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
}
