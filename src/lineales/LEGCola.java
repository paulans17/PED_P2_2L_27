package lineales;

import modelos.I_Cola;

public class LEGCola<E> extends LEGConUltimo<E> implements I_Cola<E> {

    public LEGCola() {
        super();
    }

    public void encolar(E elemento) {
        insertarAlFinal(elemento);
    }

    public E desencolar() {
        return eliminarPrimero();
    }

    public E primero() {
        return super.primero();
    }

    public String toString() {
        return super.toString();
    }
}
