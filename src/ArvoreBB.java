public class ArvoreBB {
    private No raiz;

    public ArvoreBB() {
        raiz = null;
    }

    private class No {
        int dado;
        No esquerda;
        No direita;

        public No(int dado) {
            this.dado = dado;
            esquerda = null;
            direita = null;
        }
    }

    public void inserir(int dado) {
        raiz = inserirRec(raiz, dado);
    }

    private No inserirRec(No raiz, int dado) {
        if (raiz == null) {
            raiz = new No(dado);
            return raiz;
        }

        if (dado < raiz.dado) {
            raiz.esquerda = inserirRec(raiz.esquerda, dado);
        } else if (dado > raiz.dado) {
            raiz.direita = inserirRec(raiz.direita, dado);
        }

        return raiz;
    }

    public boolean buscar(int dado) {
        return buscarRec(raiz, dado);
    }

    private boolean buscarRec(No raiz, int dado) {
        if (raiz == null) {
            return false;
        }

        if (dado == raiz.dado) {
            return true;
        }

        if (dado < raiz.dado) {
            return buscarRec(raiz.esquerda, dado);
        } else {
            return buscarRec(raiz.direita, dado);
        }
    }

    public void remover(int dado) {
        raiz = removerRec(raiz, dado);
    }

    private No removerRec(No raiz, int dado) {
        if (raiz == null) {
            return raiz;
        }

        if (dado < raiz.dado) {
            raiz.esquerda = removerRec(raiz.esquerda, dado);
        } else if (dado > raiz.dado) {
            raiz.direita = removerRec(raiz.direita, dado);
        } else {
            if (raiz.esquerda == null) {
                return raiz.direita;
            } else if (raiz.direita == null) {
                return raiz.esquerda;
            }

            raiz.dado = menorValor(raiz.direita);

            raiz.direita = removerRec(raiz.direita, raiz.dado);
        }

        return raiz;
    }

    private int menorValor(No raiz) {
        int menorValor = raiz.dado;
        while (raiz.esquerda != null) {
            menorValor = raiz.esquerda.dado;
            raiz = raiz.esquerda;
        }
        return menorValor;
    }

    public void imprimirArvoreVertical() {
        imprimirArvoreVerticalRec(raiz, "");
    }

    private void imprimirArvoreVerticalRec(No raiz, String espacamento) {
        if (raiz != null) {
            imprimirArvoreVerticalRec(raiz.direita, espacamento + "    ");
            System.out.println(espacamento + raiz.dado);
            imprimirArvoreVerticalRec(raiz.esquerda, espacamento + "    ");
        }
    }
}
