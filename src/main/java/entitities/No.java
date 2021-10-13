package entitities;

public class No<T extends Comparable<T>> {

    private T dado;
    private No<T> noEsquerdo;
    private No<T> noDireito;

    public No() {
    }

    public No(T dado) {
        this.dado = dado;
        this.noEsquerdo = null;
        this.noDireito = null;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    public No<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(No<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public No<T> getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(No<T> noDireito) {
        this.noDireito = noDireito;
    }

    @Override
    public String toString() {
        return "No{" +
                "dado=" + dado +
                '}';
    }
}
