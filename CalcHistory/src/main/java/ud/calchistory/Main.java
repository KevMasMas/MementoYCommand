package ud.calchistory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        Caretaker caretaker = new Caretaker();
        Scanner scanner = new Scanner(System.in);
        String command;
        
        while (true) {
            System.out.println("Ingrese una operación (suma, resta, multiplicacion, division) o 'deshacer', 'rehacer' o 'salir':");
            command = scanner.nextLine();
            
            if (command.equalsIgnoreCase("salir")) {
                break;
            } else if (command.equalsIgnoreCase("deshacer")) {
                Memento memento = caretaker.deshacer();
                if (memento != null) {
                    calculadora.restaurarEstado(memento);
                    System.out.println("Deshecho. Estado actual: " + calculadora.getEstado());
                } else {
                    System.out.println("No se puede deshacer.");
                }
            } else if (command.equalsIgnoreCase("rehacer")) {
                Memento memento = caretaker.rehacer();
                if (memento != null) {
                    calculadora.restaurarEstado(memento);
                    System.out.println("Rehecho. Estado actual: " + calculadora.getEstado());
                } else {
                    System.out.println("No se puede rehacer.");
                }
            } else {
                System.out.println("Ingrese el valor:");
                double valor = scanner.nextDouble();
                scanner.nextLine(); // Consume newline

                Command operationCommand = null;
                switch (command.toLowerCase()) {
                    case "suma":
                        operationCommand = new SumaCommand(calculadora, valor);
                        break;
                    case "resta":
                        operationCommand = new RestaCommand(calculadora, valor);
                        break;
                    case "multiplicacion":
                        operationCommand = new MultiplicacionCommand(calculadora, valor);
                        break;
                    case "division":
                        operationCommand = new DivisionCommand(calculadora, valor);
                        break;
                    default:
                        System.out.println("Operación no válida.");
                        continue;
                }

                operationCommand.execute();
                caretaker.guardarEstado(calculadora.guardarEstado());
                System.out.println("Estado actual: " + calculadora.getEstado());
            }
        }
        scanner.close();
    }
}