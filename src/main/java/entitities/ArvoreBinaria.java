package entitities;

public class ArvoreBinaria<T extends Comparable<T>> {

    private No<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T dado) {
        No<T> novoNo = new No<>(dado);
        raiz = inserir(raiz, novoNo);
    }

    private No<T> inserir(No<T> atual, No<T> novoNo) {
        if (atual == null) {
            return novoNo;
        }
        else if (novoNo.getDado().compareTo(atual.getDado()) < 0) {
            atual.setNoEsquerdo(inserir(atual.getNoEsquerdo(), novoNo));
        } else {
            atual.setNoDireito(inserir(atual.getNoDireito(), novoNo));
        }
        return atual;
    }

    public void exibirEmOrdem() {
        System.out.println("\n Exibir em ordem"); // Show InOrder
        exibirEmOrdem(this.raiz);
    }

    private void exibirEmOrdem(No<T> atual) {
        if (atual != null) {
            exibirEmOrdem(atual.getNoEsquerdo());
            System.out.print(atual.getDado() + ", ");
            exibirEmOrdem(atual.getNoDireito());
        }
    }

    public void exibirPosOrdem() {
        System.out.println("\n Exibir Pós Ordem"); // Show PostOrder
        exibirPosOrdem(this.raiz);
    }

    private void exibirPosOrdem(No<T> atual) {
        if (atual != null) {
            exibirPosOrdem(atual.getNoEsquerdo());
            exibirPosOrdem(atual.getNoDireito());
            System.out.print(atual.getDado() + ", ");
        }
    }

    public void exibirPreOrdem() {
        System.out.println("\n Exibir Pré Ordem"); // Show PreOrder
        exibirPreOrdem(this.raiz);
    }

    private void exibirPreOrdem(No<T> atual) {
        if (atual != null) {
            System.out.print(atual.getDado() + ", ");
            exibirPreOrdem(atual.getNoEsquerdo());
            exibirPreOrdem(atual.getNoDireito());
        }
    }

    public void remover(T dado) {
        try {
            No<T> atual = this.raiz;
            No<T> pai = null;
            No<T> filho = null;
            No<T> temp = null;

            while (atual != null && !atual.getDado().equals(dado)) {
                pai = atual;
                if (dado.compareTo(atual.getDado()) < 0) {
                    atual = atual.getNoEsquerdo();
                } else {
                    atual = atual.getNoDireito();
                }
            }

            if (atual == null) {
                System.out.println("Dado não encontrado! (Bloco Try)");
            }

            if (pai == null) {
                if (atual.getNoDireito() == null) {
                    this.raiz = atual.getNoEsquerdo();
                }
                else if (atual.getNoEsquerdo() == null) {
                    this.raiz = atual.getNoDireito();
                } else {
                    for (temp = atual, filho = atual.getNoEsquerdo();
                         filho.getNoDireito() != null;
                         temp = filho, filho = filho.getNoEsquerdo()
                    ){
                        if (filho != atual.getNoEsquerdo()) {
                            temp.setNoDireito(filho.getNoEsquerdo());
                            filho.setNoEsquerdo(raiz.getNoEsquerdo());
                        }
                    }
                    filho.setNoDireito(raiz.getNoDireito());
                    raiz = filho;
                }
            }
            else if (atual.getNoDireito() == null) {
                if (pai.getNoEsquerdo() == atual) {
                    pai.setNoEsquerdo(atual.getNoEsquerdo());
                } else {
                    pai.setNoDireito(atual.getNoEsquerdo());
                }
            }
            else if (atual.getNoEsquerdo() == null) {
                if (pai.getNoEsquerdo() == atual) {
                    pai.setNoEsquerdo(atual.getNoDireito());
                } else {
                    pai.setNoDireito(atual.getNoDireito());
                }
            } else {
                for (temp = atual, filho = atual.getNoEsquerdo();
                     filho.getNoDireito() != null;
                     temp = filho, filho = filho.getNoDireito()
                ){
                    if (filho != atual.getNoEsquerdo()) {
                        temp.setNoDireito(filho.getNoEsquerdo());
                        filho.setNoEsquerdo(atual.getNoEsquerdo());
                    }
                    filho.setNoDireito(atual.getNoDireito());
                    if (pai.getNoEsquerdo() == atual) {
                        pai.setNoEsquerdo(filho);
                    } else {
                        pai.setNoDireito(filho);
                    }
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Dado não encontrado! (Bloco Catch)");
        }
    }
}