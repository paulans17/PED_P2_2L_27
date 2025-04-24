package lineales;

import modelos.I_Cola;

public class LEGCola<E> implements I_Cola<E> {
    private LEGConUltimo<E> lista;

    public LEGCola() {
        lista = new LEGConUltimo<>();
    }

    public void encolar(E elem) {
        lista.insertarFinal(elem);
    }

    public E desencolar() {
        return lista.eliminarPrimero();
    }

    public E primero() {
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
