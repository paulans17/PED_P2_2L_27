package lineales;

import modelos.I_LEGConUltimo;

public class LEGConUltimo<E> implements I_LEGConUltimo<E> {
    private static class NodoLEGConUltimo<E> {
        private final E dato;
        private NodoLEGConUltimo<E> siguiente;

        public NodoLEGConUltimo(E dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    private NodoLEGConUltimo<E> primero;
    private NodoLEGConUltimo<E> ultimo;

    @Override
    public void insertarAlInicio(E elemento) {
        NodoLEGConUltimo<E> nuevo = new NodoLEGConUltimo<>(elemento);
        nuevo.siguiente = primero;
        primero = nuevo;
        if (ultimo == null) {
            ultimo = nuevo;
        }
    }

    @Override
    public void insertarAlFinal(E elemento) {
        NodoLEGConUltimo<E> nuevo = new NodoLEGConUltimo<>(elemento);
        if (esVacia()) {
            primero = nuevo;
        } else {
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
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
        if (primero == null) {
            ultimo = null; // Si la lista queda vacía, también actualizamos el último
        }
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
    public E ultimo() {
        if(esVacia()) {
            return null;
        }
        return ultimo.dato;
    }

    @Override
    public void eliminarUltimo() {
        if (esVacia()) {
            return;
        }
        if (primero == ultimo) {
            primero = null;
            ultimo = null;
        } else {
            NodoLEGConUltimo<E> actual = primero;
            while (actual.siguiente != ultimo) {
                actual = actual.siguiente;
            }
            actual.siguiente = null;
            ultimo = actual;
        }
    }

    @Override
    public void vaciar() {
        primero = null;
        ultimo = null;
    }
}
