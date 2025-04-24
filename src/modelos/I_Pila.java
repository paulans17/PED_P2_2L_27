package modelos;

public interface I_Pila<E> {
    void apilar(E elem);
    E desapilar();
    E cima();
    boolean esVacia();
    void vaciar();
}
