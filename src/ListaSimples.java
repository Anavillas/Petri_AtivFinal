import java.awt.font.FontRenderContext;

public class ListaSimples implements IEstruturaSimples{
    private int tamanho;
    private Object lista [];

    public ListaSimples(int tamanhoDaLista) {
        this.tamanho = tamanhoDaLista;
        lista = new Object[tamanhoDaLista];

        System.out.println("A lista foi criada com sucesso, tamanho da lista: "+tamanhoDaLista);
    }


    @Override
    public void inserirElemento(Object elemento) {
        for (int i = 0; i <this.tamanho; i++){
            if (posicaoVazia(i)){
                this.lista[i] = elemento;
                break;
            }
        }
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) {
        if (verificarIntervalo(indice)){
            if (lista[indice]==null){
                this.lista[indice] = elemento;
            } else {
                System.out.println("A posição já está ocupada, remova o elemento antes de inserir um novo.");
            }
        }
    }

    @Override
    public void inserirSequencia(Object... elementos) {
        for (int i = 0; i < elementos.length; i++) {
            inserirElemento(elementos[i]);
        }
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()) {
            System.out.println("Não há nada para remover");
            return false;
        } else {
            for (int i = tamanho - 1; i >= 0; i--) {
                if (lista[i] != null) {
                    lista[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public Object removerIndice(int indice) {
        if(verificarIntervalo(indice)) {
            if(posicaoVazia(indice)) {
                System.out.println("A posição informada já está vazia.");
            } else {
                this.lista[indice] = null;
            }

        }
        return null;
    }

    @Override
    public void removerSequencia(Object... elementos) {
        for (int i = 0; i < elementos.length; i++) {
            Object elemento = elementos[i];

            for (int j = 0; j < this.tamanho; j++) {
                if (this.lista[j] != null && this.lista[j] == elemento) {
                    this.lista[j] = null;
                    break;
                }
            }
        }
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        if (estaVazia()){
            System.out.println("Hey, ta vaziu... ziu...ziu");
        }
        for (int i = 0; i < this.tamanho; i++) {
            if(this.lista[i] == elemento){
                this.lista[i] = null;
            }
        }

    }

    @Override
    public boolean estaCheia() {
        if (this.lista[0] != null){
            return true;
        }
        return false;
    }

    @Override
    public boolean estaVazia() {
        if (this.lista[0]==null){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.lista[i] == elemento) {
                System.out.printf("Elemento "+elemento+" encontrado no índice "+i);
                return true;
            }
        }
        System.out.println("Elemento não encontrado.");
        return false;
    }

    @Override
    public Object buscarElementoIndice(int indice) {
        if (indice >= 0 && indice < this.tamanho) {
            System.out.println("Índice encontrado: "+this.lista[indice]);
            return this.lista[indice];
        } else {
            System.out.println("Índice fora dos limites.");
            return null;
        }
    }

    @Override
    public void ordenarCrescente() {
        if (estaVazia()) {
            System.out.println("Sem elementos na lista.");
            return;
        }
        for (int i = 0; i < this.tamanho - 1; i++) {
            for (int j = i + 1; j < this.tamanho; j++) {
                if (this.lista[i] != null && this.lista[j] != null) {
                    int valordoI = (int) this.lista[i];
                    int valordoJ = (int) this.lista[j];

                    if (valordoI > valordoJ) {
                        Object guardarValor = this.lista[i];
                        this.lista[i] = this.lista[j];
                        this.lista[j] = guardarValor;
                    }
                }
            }
        }
    }



    @Override
    public void ordenarDecrescente() {
        if (estaVazia()) {
            System.out.println("Sem elementos na lista.");
            return;
        }

        for (int i = 0; i < this.tamanho - 1; i++) {
            for (int j = i + 1; j < this.tamanho; j++) {

                if (this.lista[i] != null && this.lista[j] != null) {
                    int valordoI = (int) this.lista[i];
                    int valordoJ = (int) this.lista[j];

                    if (valordoI < valordoJ) {
                        Object guardarValor = this.lista[i];
                        this.lista[i] = this.lista[j];
                        this.lista[j] = guardarValor;
                    }
                }
            }
        }
    }

    @Override
    public int quantidadeElementos() {
        int cont = 0;

        if (estaVazia()){
            System.out.println("Existem "+ cont + " elementos na lista!");
        } else {
            for (int i = 0; i < tamanho; i++) {
                if (this.lista[i] != null){
                    cont = cont + 1;
                } else {
                    break;
                }
            }
            System.out.println("Existem "+ cont + " elementos na lista!");
        } return cont;
    }

    @Override
    public void dobrarCapacidade() {
        int novoTamanho = this.tamanho * 2;
        Object[] novaLista = new Object[novoTamanho];

        for (int i = 0; i < this.tamanho; i++) {
            novaLista[i] = this.lista[i];
        }

        this.lista = novaLista;
        this.tamanho = novoTamanho;

        System.out.println("EITA QUE DUPLICOU! A lista agora tem " + this.tamanho+" de tamanho.");
    }
    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.lista[i] == (elementoAntigo)){
                this.lista[i] = elementoNovo;
                System.out.println("Infelizmente vamos aposentar o "+elementoAntigo+" e substituir pelo "+elementoNovo+"! Babilônico!!!");
                return;
            }

        }
        System.out.println("Elemento não encontrado.");
    }

    @Override
    public void limpar() {
        for (int i = 0; i < this.tamanho; i++) {
            this.lista[i] = null;
        }
        System.out.println("Lista limpinha sem sujeira!");
    }

    @Override
    public void exibir() {
        StringBuilder saida = new StringBuilder("[");
        for (int i = 0; i < this.tamanho; i++) {
            saida.append(this.lista[i]);
            if (i < this.tamanho - 1) {
                saida.append(", ");
            }
        }
        saida.append("]\n");
        System.out.println(saida);
    }

    @Override
    public Object obterPrimeiroElemento() {
        if (estaVazia()){
            System.out.println("... psiu, não tem nada na lista");
        } else {
            for (int i = 0; i < this.tamanho ; i++) {
                if (this.lista[i] != null){
                    System.out.println("Primeiro elemento encontrado: [" + this.lista[i] + "] no indíce "+i);
                    return this.lista[i];
                }
            }
        } return null;
    }

    @Override
    public Object obterUltimoElemento() {
        if (estaVazia()) {
            System.out.println("... psiu, não tem nada na lista");
        } else {
            for (int i = this.tamanho - 1; i >= 0; i--) {
                if (this.lista[i] != null) {
                    System.out.println("Último elemento encontrado: [" + this.lista[i] + "] no índice " + i);
                    return this.lista[i];
                }
            }
        }
        return null;
    }

    public boolean verificarIntervalo(int indice){
        if(indice >= 0 || indice <= this.tamanho-1) {
            return true;
        } else {
            System.out.println("O indice informado está fora do intervalo da lista.");
            return false;
        }
    }
    public boolean posicaoVazia(int i){
        if (this.lista[i] == null){
            return true;
        }
        return false;    }
    }
