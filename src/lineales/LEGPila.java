package lineales;

import modelos.I_Pila;

public class LEGPila<E> extends LEG<E> implements I_Pila<E> {

    public LEGPila() {
        super();
    }

    public void apilar(E elem) {
        insertarAlInicio(elem);
    }

    public E desapilar() {
        return eliminarPrimero();
    }

    public E cima() {
        return super.primero();
    }

    public String toString() {
        return super.toString();
    }
}
