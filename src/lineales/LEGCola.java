package lineales;

import modelos.I_Cola;

public class LEGCola<E> extends LEGConUltimo<E> implements I_Cola<E> {
    private LEGConUltimo<E> lista;

    public LEGCola() {
        lista = new LEGConUltimo<>();
    }

    public void encolar(E elemento) {
        lista.insertarAlFinal(elemento);
    }

    public E desencolar() {
        return lista.eliminarPrimero();
    }

    public E primero() {
        return lista.primero();
    }

    public String toString() {
        return lista.toString();
    }
}
