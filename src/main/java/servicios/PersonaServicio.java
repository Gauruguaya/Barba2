package servicios;

import Entidades.Persona;
import java.util.List;
import java.util.Scanner;
import metodos.ValidarCPF;
import repositorios.PersonaRepositorio;

public class PersonaServicio {
 private final PersonaRepositorio personaRepositorio;
//inyección de instancia PersonaRepositorio en el constructor
    public PersonaServicio(PersonaRepositorio personaRepositorio) {
        this.personaRepositorio = personaRepositorio;
    }

    public void menuPersonas() {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Menú de Personas:");
            System.out.println("1. Registrar persona");
            System.out.println("2. Listar todas las personas");
            System.out.println("3. Encontrar persona por ID");
            System.out.println("4. Actualizar persona");
            System.out.println("5. Eliminar persona");
            System.out.println("6. Salir");

            System.out.print("Seleccione una opción: ");
            int opcion = input.nextInt();
            input.nextLine();

            switch (opcion) {
                case 1:
                    registrarPersona(input);
                    break;
                case 2:
                    obtenerTodasLasPersonas();
                    break;
                case 3:
                    encontrarPersonaxId(input);
                    break;
                case 4:
                    actualizarPersona(input);
                    break;
                case 5:
                    eliminarPersona(input);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public void registrarPersona(Scanner input) {
        System.out.print("Registrar un barbero? (si/no): ");
        boolean isBarbero = input.nextLine().equalsIgnoreCase("si");

        if (input.nextLine().equalsIgnoreCase("si")) {
            String nombre;
            do {
                System.out.print("Ingrese el nombre del barbero: ");
                nombre = input.nextLine();
                if (nombre.trim().isEmpty()) {
                    System.out.println("El nombre no puede estar vacío. Intente de nuevo.");
                }
            } while (nombre.trim().isEmpty());

            String cpf;
            do {
                System.out.print("Ingrese el CPF del barbero: ");
                cpf = input.nextLine();
                if (!ValidarCPF.isCPF(cpf)) {
                    System.out.println("CPF inválido. Intente de nuevo.");
                }
            } while (!ValidarCPF.isCPF(cpf));

             String tel;
                do {
                    System.out.print("Ingrese el teléfono del barbero: ");
                    tel = input.nextLine();
                    if (tel.trim().isEmpty()) {
                        System.out.println("El teléfono no puede estar vacío. Intente de nuevo.");
                    }
                } while (tel.trim().isEmpty());
            //falta la validación de formatos de números telefónicos
              // Crea una nueva instancia de Persona y guarda en la base de datos
        Persona nuevaPersona = new Persona(isBarbero, -1, cpf, nombre, tel, null);
        personaRepositorio.registrarPersona(nuevaPersona);
        System.out.println("Persona registrada exitosamente.");

        } else {
            // Lógica para registrar un cliente
            System.out.print("Registrar un cliente? (si/no): ");
            String respuestaCliente = input.nextLine();
            if (respuestaCliente.equalsIgnoreCase("si")) {
                String nombre;
                do {
                    System.out.print("Ingrese el nombre del cliente: ");
                    nombre = input.nextLine();
                    if (nombre.trim().isEmpty()) {
                        System.out.println("El nombre no puede estar vacío. Intente de nuevo.");
                    }
                } while (nombre.trim().isEmpty());

                String tel;
                do {
                    System.out.print("Ingrese el teléfono del cliente: ");
                    tel = input.nextLine();
                    if (tel.trim().isEmpty()) {
                        System.out.println("El teléfono no puede estar vacío. Intente de nuevo.");
                    }
                } while (tel.trim().isEmpty());

                String anivCliente;
                do {
                    System.out.print("Ingrese la fecha de nacimiento del cliente (yyyy-mm-dd): ");
                    anivCliente = input.nextLine();
                    if (anivCliente.trim().isEmpty()) {
                        System.out.println("La fecha de nacimiento no puede estar vacía. Intente de nuevo.");
                    }
                } while (anivCliente.trim().isEmpty());
        //falta la validación de formatos de números telefónicos
              // Crea una nueva instancia de Persona y guarda en la base de datos
        Persona nuevaPersona = new Persona(isBarbero, -1, "", nombre, tel, null);
        personaRepositorio.registrarPersona(nuevaPersona);
        System.out.println("Persona registrada exitosamente.");
            }
        }
    }
    
    public void obtenerTodasLasPersonas() {
        List<Persona> personas = personaRepositorio.obtenerTodasLasPersonas();
        // Mostrar la lista de personas
    }

    public void encontrarPersonaxId(Scanner input) {
        System.out.print("Ingrese el ID de la persona: ");
        int personaId = input.nextInt();
        input.nextLine();
        Persona persona = personaRepositorio.encontrarPersonaxId(personaId);
        // Mostrar los datos de la persona
    }

    public void actualizarPersona(Scanner input) {
        // falta lógica de actualización de personas
    }

    public void eliminarPersona(Scanner input) {
        System.out.print("Ingrese el ID de la persona a eliminar: ");
        int personaId = input.nextInt();
        input.nextLine();
        personaRepositorio.eliminarPersona(personaId);
    }
}

       





    

    

