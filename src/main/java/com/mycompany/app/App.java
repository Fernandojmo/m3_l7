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


// package com.mycompany.app;

// public class App {
//     private static final String MESSAGE = "Hello World!";

//     public App() {
//         // Constructor vacío innecesario
//     }

//     public static void main(String[] args) {
//         System.out.println(MESSAGE);
//     }

//     public String getMessage() {
//         return MESSAGE;
//     }

//     public String getAnotherMessage() {
//         String VariableErronea = "variable erronea"; // Uso de nombres de variables poco descriptivos
//         return VariableErronea;
//     }

//     public void unusedMethod() {
//         // Método sin uso
//     }

//     public int divideByZero(int number) {
//         return number / 0; // División por cero
//     }

//     public void catchException() {
//         try {
//             // Código susceptible a lanzar una excepción
//         } catch (Exception e) {
//             // Captura de excepciones genéricas
//         }
//     }

//     public void ignoreReturnValue() {
//         Math.random(); // Ignorar el valor de retorno de un método
//     }

//     public void infiniteLoop() {
//         while (true) {
//             // Ciclo infinito sin una condición de salida
//         }
//     }
// }

package com.mycompany.app;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class App {
    private static final String MESSAGE = "Hello World!";
    
    public static void main(String[] args) {
        System.out.println(MESSAGE);
        
        // Bugs
        divideByZero(10);
        nullPointerException();
        
        // Vulnerabilidades
        String password = "myPassword123";
        insecureEncryption(password);
        sqlInjection("John");
        
        // Code Smells
        unusedMethod();
        magicNumber(42);
        
        // Security Hotspots
        insecureCookie();
        insecureDeserialization();
    }
    
    public static int divideByZero(int number) {
        return number / 0; // Bug: División por cero
    }
    
    public static void nullPointerException() {
        String value = null;
        if (value.equals("test")) { // Bug: NullPointerException
            System.out.println("Match!");
        }
    }
    
    public static void insecureEncryption(String data) {
        try {
            String encodedData = Base64.getEncoder().encodeToString(data.getBytes("utf-8")); // Vulnerabilidad: Encriptación insegura
            System.out.println(encodedData);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    
    public static void sqlInjection(String name) {
        String query = "SELECT * FROM users WHERE name = '" + name + "'"; // Vulnerabilidad: SQL Injection
        // Realizar la consulta a la base de datos...
    }
    
    public static void unusedMethod() {
        // Code Smell: Método sin uso
    }
    
    public static void magicNumber(int value) {
        if (value == 42) { // Code Smell: Uso de número mágico
            System.out.println("The answer to the ultimate question of life, the universe, and everything.");
        }
    }
    
    public static void insecureCookie() {
        String sessionId = "ABC123";
        // Enviar sessionId como cookie insegura
    }
    
    public static void insecureDeserialization() {
        // Lógica para deserializar datos inseguramente
    }
}
