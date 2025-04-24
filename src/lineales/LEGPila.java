package lineales;

import modelos.I_Pila;

public class LEGPila<E> extends LEG<E> implements I_Pila<E> {
    private LEG<E> lista;

    public LEGPila() {
        lista = new LEG<>();
    }

    public void apilar(E elem) {
        lista.insertarAlInicio(elem);
    }

    public E desapilar() {
        return lista.eliminarPrimero();
    }

    public E cima() {
        return lista.primero();
    }

    public String toString() {
        return lista.toString();
    }
}
