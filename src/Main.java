import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBB arvore = new ArvoreBB();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Professora Marina, escolha uma opção:");
            System.out.println("1. Inserir valor");
            System.out.println("2. Buscar valor");
            System.out.println("3. Remover valor");
            System.out.println("4. Imprimir árvore");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor para inserir:");
                    int valorInserir = scanner.nextInt();
                    arvore.inserir(valorInserir);
                    break;
                case 2:
                    System.out.println("Digite o valor para buscar:");
                    int valorBuscar = scanner.nextInt();
                    boolean encontrado = arvore.buscar(valorBuscar);
                    System.out.println("Valor encontrado: " + encontrado);
                    break;
                case 3:
                    System.out.println("Digite o valor para remover:");
                    int valorRemover = scanner.nextInt();
                    arvore.remover(valorRemover);
                    break;
                case 4:
                    System.out.println("Árvore:");
                    arvore.imprimirArvoreVertical();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
