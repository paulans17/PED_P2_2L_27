package lineales;

import modelos.I_Pila;

public class LEGPila<E> implements I_Pila<E> {
    private LEG<E> lista;

    public LEGPila() {
        lista = new LEG<>();
    }

    public void apilar(E elem) {
        lista.insertar(elem);
    }

    public E desapilar() {
        return lista.eliminarPrimero();
    }

    public E cima() {
        return lista.primero();
    }

    public boolean esVacia() {
        return lista.esVacia();
    }

    public void vaciar() {
        lista.vaciar();
    }

    public String toString() {
        return lista.toString();
    }
}
