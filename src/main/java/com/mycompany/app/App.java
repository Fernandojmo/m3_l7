// package com.mycompany.app;
// public class App {
//     private static final String MESSAGE = "Hello World!";
//     public App() {}
//     public static void main(String[] args) {
//         System.out.println(MESSAGE);
//     }
//     public String getMessage() {
//         return MESSAGE;
//     }
//     public String getAnotherMessage() {
//         String VariableErronea = "variable erronea";
//         return VariableErronea;
//     }
// }


package com.mycompany.app;

public class App {
    private static final String MESSAGE = "Hello World!";

    public App() {
        // Constructor vacío innecesario
    }

    public static void main(String[] args) {
        System.out.println(MESSAGE);
    }

    public String getMessage() {
        return MESSAGE;
    }

    public String getAnotherMessage() {
        String VariableErronea = "variable erronea"; // Uso de nombres de variables poco descriptivos
        return VariableErronea;
    }

    public void unusedMethod() {
        // Método sin uso
    }

    public int divideByZero(int number) {
        return number / 0; // División por cero
    }

    public void catchException() {
        try {
            // Código susceptible a lanzar una excepción
        } catch (Exception e) {
            // Captura de excepciones genéricas
        }
    }

    public void ignoreReturnValue() {
        Math.random(); // Ignorar el valor de retorno de un método
    }

    public void infiniteLoop() {
        while (true) {
            // Ciclo infinito sin una condición de salida
        }
    }
}

