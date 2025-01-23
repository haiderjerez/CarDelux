package View;

import Controller.ServicioController;
import Model.Servicio;

import java.util.List;
import java.util.Scanner;

public class ServicioView {
    private Scanner scanner;

    public ServicioView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("***** MENU DE GESTIÓN DE SERVICIOS *****");
            System.out.println("1. Registrar Servicio");
            System.out.println("2. Listar Servicios");
            System.out.println("3. Modificar Servicio");
            System.out.println("4. Eliminar Servicio");
            System.out.println("5. Volver al Menú Principal");
            System.out.print(">> Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    registrarServicio();
                    break;
                case 2:
                    listarServicios();
                    break;
                case 3:
                    modificarServicio();
                    break;
                case 4:
                    eliminarServicio();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void registrarServicio() {
        System.out.println("Registro de un nuevo servicio");
        System.out.print("Ingrese el nombre del servicio: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la descripción del servicio: ");
        String descripcion = scanner.nextLine();

        System.out.print("Ingrese el precio del servicio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        boolean registrado = ServicioController.agregarServicio(nombre, descripcion, precio);

        if (registrado) {
            System.out.println("Servicio registrado exitosamente.");
        } else {
            System.out.println("Ocurrió un error al registrar el servicio.");
        }
    }

    private void listarServicios() {
        System.out.println("Listando servicios...");
        List<Servicio> servicios = ServicioController.listarServicios();

        if (servicios.isEmpty()) {
            System.out.println("No hay servicios registrados.");
        } else {
            for (Servicio servicio : servicios) {
                System.out.println(servicio);
            }
        }
    }

    private void modificarServicio() {
        System.out.println("Modificando servicio");
        System.out.print("Ingrese el ID del servicio a modificar: ");
        int idServicio = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Ingrese la nueva descripción del servicio: ");
        String nuevaDescripcion = scanner.nextLine();

        System.out.print("Ingrese el nuevo precio del servicio: ");
        double nuevoPrecio = scanner.nextDouble();
        scanner.nextLine();

        Servicio servicio = new Servicio(idServicio, nuevaDescripcion, nuevoPrecio);
        ServicioController servicioController = new ServicioController();
        servicioController.actualizarServicio(servicio);

        System.out.println("Servicio modificado exitosamente.");
    }

    private void eliminarServicio() {
        System.out.println("Eliminando servicio");
        System.out.print("Ingrese el ID del servicio a eliminar: ");
        int idServicio = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        boolean eliminado = ServicioController.eliminarServicio(idServicio);

        if (eliminado) {
            System.out.println("Servicio eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un servicio con el ID proporcionado o no se pudo eliminar.");
        }
    }
}
