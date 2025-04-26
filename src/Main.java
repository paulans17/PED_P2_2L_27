//LIBRERIAS
import java.util.Scanner;

//PAQUETES
import lineales.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    //STRUCTS PRINCIPALES
    static LEGPila<Integer> p;
    static LEGCola<Integer> c1;
    static LEGCola<Integer> c2;

    //COPIAS
    static LEGPila<Integer> copiaOriginalPila;
    static LEGCola<Integer> copiaOriginalCola1;
    static LEGCola<Integer> copiaOriginalCola2;

    public static void main(String[] args) {
        inicializarEstructuras();
        mostrarMenuPrincipal();
    }

    public static void inicializarEstructuras() {
        p = new LEGPila<>();
        c1 = new LEGCola<>();
        c2 = new LEGCola<>();

        // PILA: 5, 3, 5, 2, 1
        p.apilar(1);
        p.apilar(2);
        p.apilar(5);
        p.apilar(3);
        p.apilar(5);

        // COLA C1: 5, 13, 5, 21, 30
        c1.encolar(5);
        c1.encolar(13);
        c1.encolar(5);
        c1.encolar(21);
        c1.encolar(30);

        // COLA C2: 6, 27, 5, 1, 21, 13
        c2.encolar(6);
        c2.encolar(27);
        c2.encolar(5);
        c2.encolar(1);
        c2.encolar(21);
        c2.encolar(13);

        //CLONACIÓN DE ESTRUCTURAS ORGIGINALES
        copiaOriginalPila = clonarPila(p);
        copiaOriginalCola1 = clonarCola(c1);
        copiaOriginalCola2 = clonarCola(c2);

        //IMPRIMIR ESTRUCTURAS
        System.out.println("PILA CREADA: " + p);
        System.out.println("COLA C1 CREADA: " + c1);
        System.out.println("COLA C2 CREADA: " + c2);
    }

    private static void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\tMENÚ PRINCIPAL");
            System.out.println("1. Practicar con PILAS");
            System.out.println("2. Practicar con COLAS");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> menuPilas();
                case 2 -> menuColas();
                case 0 -> System.out.println("Adios");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 0);
    }

    private static void menuPilas() {
        int opcion;
        do {
            System.out.println("Pila actual: " + p);

            System.out.println("\n\tSUBMENÚ DE PILAS");
            System.out.println("1. Restaurar pila");
            System.out.println("2. Eliminar elementos = nº de elementos (Iterativo)");
            System.out.println("3. Eliminar elementos = nº de elementos (Recursivo)");
            System.out.println("4. Eliminar duplicados");
            System.out.println("5. Detectar secuencias consecutivas");
            System.out.println("0. Volver al menú principal");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> p = clonarPila(copiaOriginalPila);
                case 2 -> eliminarElementosPilaIterativo();
                case 3 -> eliminarElementosPilaRecursivo();
                case 4 -> eliminarDuplicadosPila();
                case 5 -> detectarSecuenciasPila();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);
    }

    private static void menuColas() {
        int opcion;
        do {
            System.out.println("Cola c1: " + c1);
            System.out.println("Cola c2: " + c2);

            System.out.println("\n\tSUBMENÚ DE COLAS");
            System.out.println("1. Restaurar colas");
            System.out.println("2. Eliminar elementos = nº de elementos (Recursivo)");
            System.out.println("3. Rotación circular de cola c1");
            System.out.println("4. Intersección de colas");
            System.out.println("0. Volver al menú principal");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> {
                    c1 = clonarCola(copiaOriginalCola1);
                    c2 = clonarCola(copiaOriginalCola2);
                    System.out.println("Colas restauradas");
                }
                case 2 -> System.out.println("→ Implementar método recursivo.");
                case 3 -> System.out.println("→ Implementar rotación circular.");
                case 4 -> System.out.println("→ Implementar intersección.");
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción incorrecta.");
            }

        } while (opcion != 0);
    }

    private static LEGPila<Integer> clonarPila(LEGPila<Integer> original) {
        LEGPila<Integer> copia = new LEGPila<>();
        LEGPila<Integer> auxiliar = new LEGPila<>();

        while (!original.esVacia()) {
            int elemento = original.desapilar();
            auxiliar.apilar(elemento);
        }

        while (!auxiliar.esVacia()) {
            int elemento = auxiliar.desapilar();
            original.apilar(elemento);
            copia.apilar(elemento);
        }
        return copia;
    }

    private static LEGCola<Integer> clonarCola(LEGCola<Integer> original) {
        LEGCola<Integer> copia = new LEGCola<>();
        LEGCola<Integer> auxiliar = new LEGCola<>();

        while (!original.esVacia()) {
            int elemento = original.desencolar();
            auxiliar.encolar(elemento);
        }

        while (!auxiliar.esVacia()) {
            int elemento = auxiliar.desencolar();
            original.encolar(elemento);
            copia.encolar(elemento);
        }
        return copia;
    }

    //SUBMENUS PILAS
    private static void eliminarElementosPilaIterativo() {
        LEGPila<Integer> auxiliar = new LEGPila<>();
        int contador = 0;

        while (!p.esVacia()) {
            auxiliar.apilar(p.desapilar());
            contador++;
        }

        while (!auxiliar.esVacia()) {
            int valor = auxiliar.desapilar();
            if (valor != contador) {
                p.apilar(valor);
            }
        }

        System.out.println("→ Pila tras eliminar elementos == " + contador + ": " + p);
    }

    private static int contarRec(LEGPila<Integer> pila) {
        if (pila.esVacia()) return 0;
        int x = pila.desapilar();
        int cuenta = 1 + contarRec(pila);
        pila.apilar(x);
        return cuenta;
    }

    private static void eliminarRecAux(LEGPila<Integer> pila, int total) {
        if (pila.esVacia()) return;
        int x = pila.desapilar();
        eliminarRecAux(pila, total);
        if (x != total) pila.apilar(x);
    }

    private static void eliminarElementosPilaRecursivo() {
        int n = contarRec(p);
        eliminarRecAux(p, n);
        System.out.println("→ Pila tras eliminación recursiva: " + p);
    }

    private static void eliminarDuplicadosPila() {
        LEGPila<Integer> aux = new LEGPila<>();
        LEGPila<Integer> temp = new LEGPila<>();
        while (!p.esVacia()) {
            int x = p.desapilar();
            boolean encontrado = false;
            while (!aux.esVacia()) {
                if (aux.cima().equals(x)) {
                    encontrado = true;
                }
                temp.apilar(aux.desapilar());
            }
            while (!temp.esVacia()) {
                aux.apilar(temp.desapilar());
            }
            if (!encontrado) {
                aux.apilar(x);
            }
        }
        while (!aux.esVacia()) {
            p.apilar(aux.desapilar());
        }
        System.out.println("→ Pila tras eliminar duplicados: " + p);
    }

    private static void detectarSecuenciasPila() {
        System.out.print("Introduce una secuencia de enteros separados por espacios: ");
        String linea = sc.nextLine();
        if (linea == null || linea.trim().isEmpty()) {
            System.out.println("No hay datos.");
            return;
        }
        String[] tokens = linea.trim().split("\\s+");
        LEGPila<Integer> pilaSecuencia = new LEGPila<>();
        for (String t : tokens) {
            if (!t.isEmpty()) {
                pilaSecuencia.apilar(Integer.parseInt(t));
            }
        }
        LEGPila<Integer> aux = new LEGPila<>();
        while (!pilaSecuencia.esVacia()) aux.apilar(pilaSecuencia.desapilar());
        if (aux.esVacia()) {
            System.out.println("No hay datos.");
            return;
        }
        int prev = aux.desapilar(), start = prev, count = 1;
        boolean found = false;
        while (!aux.esVacia()) {
            int curr = aux.desapilar();
            if (curr == prev + 1) {
                count++;
            } else {
                found = isFound(prev, start, count, found);
                start = curr;
                count = 1;
            }
            prev = curr;
        }
        found = isFound(prev, start, count, found);
        if (!found) System.out.println("No se han encontrado secuencias consecutivas.");
    }

    private static boolean isFound(int prev, int start, int count, boolean found) {
        if (count > 1) {
            System.out.print("[");
            for (int v = start; v <= prev; v++) {
                System.out.print(v);
                if (v < prev) System.out.print(", ");
            }
            System.out.println("]");
            found = true;
        }
        return found;
    }


}