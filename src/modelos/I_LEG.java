package modelos;

public interface I_LEG<E> {
    void insertarAlInicio(E elemento);
    void insertarAlFinal(E elemento);
    boolean esVacia();
    E eliminarPrimero();
    E primero();
    void vaciar();
}
