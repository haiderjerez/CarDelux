package View;

import Controller.VentaController;

import java.util.Date;
import java.util.Scanner;

public class VentaView {
    private Scanner scanner;

    public VentaView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU DE GESTIÓN DE VENTAS *****");
            System.out.println("1. Registrar Venta");
            System.out.println("2. Listar Ventas");
            System.out.println("3. Modificar Venta");
            System.out.println("4. Eliminar Venta");
            System.out.println("5. Volver al Menú Principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarVenta();
                    break;
                case 2:
                    listarVentas();
                    break;
                case 3:
                    modificarVenta();
                    break;
                case 4:
                    eliminarVenta();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarVenta() {
        System.out.println("Registro de una nueva venta");

        System.out.print("Ingrese el ID del cliente: ");
        int idCliente = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese el ID del vehículo: ");
        int idVehiculo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese la fecha de la venta (Formato: YYYY-MM-DD): ");
        String fechaVenta = scanner.nextLine();

        System.out.print("Ingrese el precio de la venta: ");
        double precioVenta = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese la comisión: ");
        double comision = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.print("Ingrese el ID del empleado: ");
        int idEmpleado = scanner.nextInt();
        scanner.nextLine();

        boolean registrado = VentaController.agregarVenta(idCliente, idVehiculo, fechaVenta, precioVenta, comision, idEmpleado);

        if (registrado) {
            System.out.println("Venta registrada exitosamente.");
        } else {
            System.out.println("Error al registrar la venta. Verifique los datos ingresados.");
        }
    }

    private void listarVentas() {
        System.out.println("Listando ventas...");
        var ventas = VentaController.listarVentas();

        if (ventas == null || ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            ventas.forEach(venta -> {
                System.out.println("ID Venta: " + venta.getIdVenta());
                System.out.println("ID Cliente: " + venta.getIdCliente());
                System.out.println("ID Vehículo: " + venta.getIdVehiculo());
                System.out.println("Fecha Venta: " + venta.getFechaVenta());
                System.out.println("Precio Venta: " + venta.getMonto());
                System.out.println("Comisión: " + venta.getComision());
                System.out.println("ID Empleado: " + venta.getIdEmpleado());
                System.out.println("---------------------------------");
            });
        }
    }

    private void modificarVenta() {
        System.out.println("Modificando venta");

        System.out.print("Ingrese el ID de la venta a modificar: ");
        int idVenta = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nuevo ID del cliente (deje en blanco para no modificar): ");
        String nuevoIdCliente = scanner.nextLine();

        System.out.print("Ingrese el nuevo ID del vehículo (deje en blanco para no modificar): ");
        String nuevoIdVehiculo = scanner.nextLine();

        System.out.print("Ingrese la nueva fecha de la venta (Formato: YYYY-MM-DD, deje en blanco para no modificar): ");
        String nuevaFechaVenta = scanner.nextLine();

        System.out.print("Ingrese el nuevo precio de la venta (-1 para no modificar): ");
        double nuevoPrecioVenta = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese la nueva comisión (-1 para no modificar): ");
        double nuevaComision = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Ingrese el nuevo ID del empleado (deje en blanco para no modificar): ");
        String nuevoIdEmpleado = scanner.nextLine();

        boolean actualizado = VentaController.actualizarVenta(
                idVenta,
                nuevoIdCliente.isEmpty() ? null : Integer.parseInt(nuevoIdCliente),
                nuevoIdVehiculo.isEmpty() ? null : Integer.parseInt(nuevoIdVehiculo),
                nuevaFechaVenta.isEmpty() ? null : nuevaFechaVenta,
                nuevoPrecioVenta == -1 ? null : nuevoPrecioVenta,
                nuevaComision == -1 ? null : nuevaComision,
                nuevoIdEmpleado.isEmpty() ? null : Integer.parseInt(nuevoIdEmpleado)
        );

        if (actualizado) {
            System.out.println("Venta modificada exitosamente.");
        } else {
            System.out.println("No se encontró una venta con el ID proporcionado o no se pudo modificar.");
        }
    }

    private void eliminarVenta() {
        System.out.println("Eliminando venta");

        System.out.print("Ingrese el ID de la venta a eliminar: ");
        int idVenta = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean eliminado = VentaController.eliminarVenta(idVenta);

        if (eliminado) {
            System.out.println("Venta eliminada exitosamente.");
        } else {
            System.out.println("No se encontró una venta con el ID proporcionado o no se pudo eliminar.");
        }
    }
}
