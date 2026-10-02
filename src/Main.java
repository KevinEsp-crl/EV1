import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<doctor> listaDoctores = new ArrayList<>();
    private static ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private static ArrayList<Cita> listaCitas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("CONTROL DE ACCESO ");
        System.out.print("Usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        if (!usuario.equals("admin") || !password.equals("1234")) {
            System.out.println("Acceso denegado. Credenciales incorrectas.");
            return; // Termina el programa si no es el administrador
        }

        int opcion;
        do {
            System.out.println("\n--- SISTEMA CLÍNICO ---");
            System.out.println("1. dar alta doctor");
            System.out.println("2. dar alta paciente"); // Corregí el número para que sea consecutivo
            System.out.println("3. crear una cita");
            System.out.println("4. ver todas citas");
            System.out.println("5. salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el salto de línea del buffer

            switch (opcion) {
                case 1 -> altaDoctor();
                case 2 -> altaPaciente();
                case 3 -> crearCita();
                case 4 -> verCitas();
                case 5 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }

    private static void altaDoctor() {
        System.out.println("\n[Alta Doctor]");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = scanner.nextLine();
        System.out.print("Identificador: ");
        String id = scanner.nextLine();

        listaDoctores.add(new doctor(nombre, especialidad, id));
        System.out.println("¡Doctor registrado con éxito!");
    }

    private static void altaPaciente() {
        System.out.println("\n[Alta Paciente]");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Identificador: ");
        String id = scanner.nextLine();
        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        System.out.print("Número: ");
        String numero = scanner.nextLine();
        System.out.print("Motivo: ");
        String motivo = scanner.nextLine();

        listaPacientes.add(new Paciente(nombre, id, correo, numero, motivo));
        System.out.println("¡Paciente registrado con éxito!");
    }


    private static void crearCita() {
        System.out.println("\n[Crear Cita]");
        if (listaDoctores.isEmpty() || listaPacientes.isEmpty()) {
            System.out.println("Error: Necesitas registrar mínimo un doctor y un paciente primero.");
            return;
        }

        System.out.print("Ingrese el Identificador del Paciente: ");
        String idPac = scanner.nextLine();
        Paciente pacEncontrado = null;
        for (Paciente p : listaPacientes) {
            if (p.getIdentificador().equals(idPac)) {
                pacEncontrado = p;
                break;
            }
        }

        System.out.print("Ingrese el Identificador del Doctor: ");
        String idDoc = scanner.nextLine();
        doctor docEncontrado = null;
        for (doctor d : listaDoctores) {
            if (d.getIdentificador().equals(idDoc)) {
                docEncontrado = d;
                break;
            }
        }

        if (pacEncontrado == null || docEncontrado == null) {
            System.out.println("Error: No se encontró el paciente o el doctor con esos códigos.");
            return;
        }

        System.out.print("Fecha de la cita (Formato AAAA-MM-DD): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr);

        listaCitas.add(new Cita(pacEncontrado, docEncontrado, fecha));
        System.out.println("¡Cita programada exitosamente!");
    }

    private static void verCitas() {
        System.out.println("\n[Todas las Citas Registradas]");
        if (listaCitas.isEmpty()) {
            System.out.println("No hay citas programadas actualmente.");
            return;
        }
        for (Cita c : listaCitas) {
            System.out.println("Fecha: " + c.fecha +
                    " | Paciente: " + c.paciente.getNombre() +
                    " | Doctor: " + c.doctor.getNombre());
        }
    }
}
