import java.io.*;
import java.util.*;

public class HashTablaNombres {

    // Suma código ASCII de caracteres y módulo del tamaño
    public static int hash(String s, int size) {
        int suma = 0;
        for (char c : s.toCharArray()) {
            suma += c;
        }
        return suma % size;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // ARCHIVO DE ENTRADA
            System.out.print("Nombre del archivo de entrada: ");
            String archivoEntrada = sc.nextLine();

            File file = new File(archivoEntrada);
            Scanner lector = new Scanner(file);

            System.out.println("\n--- CONTENIDO DEL ARCHIVO ---");

            ArrayList<String> nombres = new ArrayList<>();

            while (lector.hasNextLine()) {
                String nombre = lector.nextLine();
                System.out.println(nombre);
                nombres.add(nombre);
            }
            lector.close();

            // Crear tabla hash
            int size = nombres.size() * 2; 
            ArrayList<ArrayList<String>> tabla = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                tabla.add(new ArrayList<>());
            }

            // Insertar en la tabla hash
            for (String n : nombres) {
                int index = hash(n, size);
                tabla.get(index).add(n);
            }

            // Extraer todos los elementos de la tabla hash
            ArrayList<String> salida = new ArrayList<>();
            for (ArrayList<String> lista : tabla) {
                salida.addAll(lista);
            }

            // Ordenarlos alfabéticamente
            Collections.sort(salida);

            // ARCHIVO DE SALIDA
            System.out.print("\nNombre del archivo de salida: ");
            String archivoSalida = sc.nextLine();

            PrintWriter writer = new PrintWriter(archivoSalida);

            System.out.println("\n--- NOMBRES ORDENADOS (HASH) ---");
            for (String n : salida) {
                System.out.println(n);
                writer.println(n);
            }

            writer.close();
            System.out.println("\n✓ Archivo generado correctamente.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
