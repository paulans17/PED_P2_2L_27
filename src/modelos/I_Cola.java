package modelos;

public interface I_Cola<E> {
    void encolar(E elem);
    E desencolar();
    E primero();
}
