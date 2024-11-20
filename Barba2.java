package com.mycompany.barba2;

import java.util.Scanner;
import repositorios.PersonaRepositorio;
import servicios.PersonaServicio;

public class Barba2 {
    private final PersonaServicio personaServicio;
    public Barba2(PersonaServicio personaServicio) {
        this.personaServicio = personaServicio;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PersonaRepositorio personaRepositorio = new PersonaRepositorio();
        PersonaServicio personaServicio = new PersonaServicio(personaRepositorio);
        Barba2 app = new Barba2(personaServicio);
        app.run(input);
    }
    // ¿Es necesario agregar aquí la llamada a los métodos de PersonaServicio?¿Cómo?
       
    private void run(Scanner input){
        boolean exit = false;
    
        while (!exit) {
            System.out.println("¿A qué área desea acceder?");
            System.out.println("1 - personas");
            System.out.println("2 - productos");
            System.out.println("3 - servicios");
            System.out.println("4 - salir");
            System.out.print("Seleccione una opción: ");
            int opcion = input.nextInt();
            input.nextLine(); 

            switch (opcion) {
                case 1 -> personaServicio.menuPersonas();
                case 2 -> // Lógica para productos
                    System.out.println("Área de productos no implementada.");
                case 3 -> // Lógica para servicios
                    System.out.println("Área de servicios no implementada.");
                case 4 -> exit = true;
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}

