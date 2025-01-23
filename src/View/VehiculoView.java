package View;

import Controller.VehiculoController;

import java.util.Scanner;

public class VehiculoView {
    private Scanner scanner;

    public VehiculoView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU DE GESTIÓN DE VEHÍCULOS *****");
            System.out.println("1. Registrar Vehículo");
            System.out.println("2. Listar Vehículos");
            System.out.println("3. Modificar Vehículo");
            System.out.println("4. Eliminar Vehículo");
            System.out.println("5. Volver al Menú Principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    registrarVehiculo();
                    break;
                case 2:
                    listarVehiculos();
                    break;
                case 3:
                    modificarVehiculo();
                    break;
                case 4:
                    eliminarVehiculo();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarVehiculo() {
        System.out.println("Registro de un nuevo vehículo");
        System.out.print("Ingrese la marca del vehículo: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese el año del vehículo: ");
        int year_carro = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el precio del vehículo: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        boolean registroExitoso = VehiculoController.agregarVehiculo(marca, modelo, year_carro, precio);

        if (registroExitoso) {
            System.out.println("Vehículo registrado exitosamente.");
        } else {
            System.out.println("Ocurrió un error al registrar el vehículo. Intente nuevamente.");
        }
    }

    private void listarVehiculos() {
        System.out.println("Listando vehículos...");
        VehiculoController.listarVehiculos().forEach(vehiculo -> {
            System.out.println("ID: " + vehiculo.getIdVehiculo());
            System.out.println("Marca: " + vehiculo.getMarca());
            System.out.println("Modelo: " + vehiculo.getModelo());
            System.out.println("Año: " + vehiculo.getYearCarro());
            System.out.println("Precio: " + vehiculo.getPrecio());
            System.out.println("---------------------------");
        });
    }

    private void modificarVehiculo() {
        System.out.println("Modificando vehículo");
        System.out.print("Ingrese el ID del vehículo a modificar: ");
        int idVehiculo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la nueva marca del vehículo (deje en blanco para no modificar): ");
        String nuevaMarca = scanner.nextLine();

        System.out.print("Ingrese el nuevo modelo del vehículo (deje en blanco para no modificar): ");
        String nuevoModelo = scanner.nextLine();

        System.out.print("Ingrese el nuevo año del vehículo (0 para no modificar): ");
        int nuevoAnio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el nuevo precio del vehículo (0.0 para no modificar): ");
        double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine();

        boolean actualizado = VehiculoController.actualizarVehiculo(idVehiculo, nuevaMarca, nuevoModelo, nuevoAnio, nuevoPrecio);

        if (actualizado) {
            System.out.println("Vehículo modificado exitosamente.");
        } else {
            System.out.println("No se encontró un vehículo con el ID proporcionado o no se pudo modificar.");
        }
    }

    private void eliminarVehiculo() {
        System.out.println("Eliminando vehículo");
        System.out.print("Ingrese el ID del vehículo a eliminar: ");
        int idVehiculo = scanner.nextInt();
        scanner.nextLine();

        boolean eliminado = VehiculoController.eliminarVehiculo(idVehiculo);

        if (eliminado) {
            System.out.println("Vehículo eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un vehículo con el ID proporcionado o no se pudo eliminar.");
        }
    }
}
