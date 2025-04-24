package modelos;

public interface I_LEGConUltimo<E> extends I_LEG<E> {
    E ultimo();
    void eliminarUltimo();
    void vaciar();
}
