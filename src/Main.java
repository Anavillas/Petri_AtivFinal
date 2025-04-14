import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tamanho da lista: ");
        int tamanho = scanner.nextInt();

        ListaSimples lista = new ListaSimples(tamanho);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Inserir elemento");
            System.out.println("2. Inserir elemento no índice");
            System.out.println("3. Inserir sequência de elementos");
            System.out.println("4. Remover elemento");
            System.out.println("5. Remover elemento por índice");
            System.out.println("6. Remover sequência de elementos");
            System.out.println("7. Remover todas as ocorrências de um elemento");
            System.out.println("8. Verificar se a lista está cheia");
            System.out.println("9. Verificar se a lista está vazia");
            System.out.println("10. Buscar elemento");
            System.out.println("11. Buscar elemento por índice");
            System.out.println("12. Ordenar lista em ordem crescente");
            System.out.println("13. Ordenar lista em ordem decrescente");
            System.out.println("14. Mostrar quantidade de elementos");
            System.out.println("15. Dobrar a capacidade da lista");
            System.out.println("16. Editar elemento");
            System.out.println("17. Limpar lista");
            System.out.println("18. Exibir lista");
            System.out.println("19. Obter primeiro elemento");
            System.out.println("20. Obter último elemento");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o elemento a ser inserido: ");
                    scanner.nextLine();
                    int elemento = scanner.nextInt();
                    lista.inserirElemento(elemento);
                    lista.exibir();
                    break;
                case 2:
                    System.out.print("Digite o índice: ");
                    int indice = scanner.nextInt();
                    System.out.print("Digite o elemento a ser inserido: ");
                    scanner.nextLine();
                    int elementoIndice = scanner.nextInt();
                    lista.inserirElementoIndice(elementoIndice, indice);
                    lista.exibir();

                    break;
                case 3:
                    System.out.println("Digite a quantidade de elementos a serem inseridos:");
                    int qtd = scanner.nextInt();
                    scanner.nextLine();
                    Object[] sequencia = new Object[qtd];
                    for (int i = 0; i < qtd; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        sequencia[i] = scanner.nextInt();
                    }
                    lista.inserirSequencia(sequencia);
                    lista.exibir();
                    break;
                case 4:
                    lista.removerElemento();
                    break;
                case 5:
                    System.out.print("Digite o índice do elemento a ser removido: ");
                    int indiceRemover = scanner.nextInt();
                    lista.removerIndice(indiceRemover);
                    lista.exibir();
                    break;
                case 6:
                    System.out.println("Digite a quantidade de elementos a serem removidos:");
                    int remQtd = scanner.nextInt();
                    scanner.nextLine();
                    Object[] removerSeq = new Object[remQtd];
                    for (int i = 0; i < remQtd; i++) {
                        System.out.print("Elemento " + (i + 1) + ": ");
                        removerSeq[i] = scanner.nextInt();
                    }
                    lista.removerSequencia(removerSeq);
                    lista.exibir();
                    break;
                case 7:
                    System.out.print("Digite o elemento a ser removido de todas as ocorrências: ");
                    scanner.nextLine();
                    int elementoRemover = scanner.nextInt();
                    lista.removerTodasOcorrencias(elementoRemover);
                    lista.exibir();

                    break;
                case 8:
                    System.out.println(lista.estaCheia() ? "A lista está cheia!" : "A lista não está cheia.");
                    break;
                case 9:
                    System.out.println(lista.estaVazia() ? "A lista está vazia!" : "A lista não está vazia.");
                    break;
                case 10:
                    System.out.print("Digite o elemento a ser buscado: ");
                    scanner.nextLine();
                    int elementoBuscar = scanner.nextInt();
                    lista.buscarElemento(elementoBuscar);
                    lista.exibir();

                    break;
                case 11:
                    System.out.print("Digite o índice para buscar o elemento: ");
                    int indiceBuscar = scanner.nextInt();
                    lista.buscarElementoIndice(indiceBuscar);
                    lista.exibir();

                    break;
                case 12:
                    lista.ordenarCrescente();
                    lista.exibir();

                    break;
                case 13:
                    lista.ordenarDecrescente();
                    lista.exibir();

                    break;
                case 14:
                    lista.quantidadeElementos();
                    lista.exibir();

                    break;
                case 15:
                    lista.dobrarCapacidade();
                    lista.exibir();

                    break;
                case 16:
                    System.out.print("Digite o elemento antigo a ser editado: ");
                    scanner.nextLine();
                    int elementoAntigo = scanner.nextInt();
                    System.out.print("Digite o novo elemento: ");
                    int elementoNovo = scanner.nextInt();
                    lista.editarElemento(elementoAntigo, elementoNovo);
                    lista.exibir();

                    break;
                case 17:
                    lista.limpar();
                    break;
                case 18:
                    lista.exibir();
                    break;
                case 19:
                    lista.obterPrimeiroElemento();
                    lista.exibir();

                    break;
                case 20:
                    lista.obterUltimoElemento();
                    lista.exibir();

                    break;
                case 0:
                    System.out.println("tchauuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
                    return;
                default:
                    System.out.println("Opção inválida! Insira uma opção correta. `-´");
            }
        }
    }
}
