package lineales;

import modelos.I_LEG;

public class LEG<E> implements I_LEG<E> {
    private static class NodoLEG<E> {
        private final E dato;
        private NodoLEG<E> siguiente;

        public NodoLEG(E dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private NodoLEG<E> primero;

    @Override
    public void insertarAlInicio(E elemento) {
        NodoLEG<E> nuevo = new NodoLEG<>(elemento);
        nuevo.siguiente = primero;
        primero = nuevo;
    }

    @Override
    public void insertarAlFinal(E elemento) {
        NodoLEG<E> nuevo = new NodoLEG<>(elemento);
        if (esVacia()) {
            primero = nuevo;
        } else {
            NodoLEG<E> actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public E eliminarPrimero() {
        if (esVacia()) {
            return null;
        }
        E dato = primero.dato;
        primero = primero.siguiente;
        return dato;
    }

    @Override
    public E primero() {
        if (esVacia()) {
            return null;
        }
        return primero.dato;
    }

    @Override
    public void vaciar() {
        primero = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        NodoLEG<E> actual = primero;
        while (actual != null) {
            sb.append(actual.dato);
            if (actual.siguiente != null) sb.append(", ");
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }

}
