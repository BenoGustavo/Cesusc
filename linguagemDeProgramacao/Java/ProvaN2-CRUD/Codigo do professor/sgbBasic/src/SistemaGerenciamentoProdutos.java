import java.util.Scanner;

public class SistemaGerenciamentoProdutos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;
        int quantidadeProdutos = 0;
        String[] nomesProdutos = new String[100];
        double[] precosProdutos = new double[100];
        int[] quantidadesProdutos = new int[100];

        do {
            System.out.println("\n----- Sistema de Gerenciamento de Produtos -----");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.print("\nNome do Produto: ");
                    String nomeProduto = scanner.nextLine();

                    System.out.print("Preço do Produto: ");
                    double precoProduto = scanner.nextDouble();

                    System.out.print("Quantidade do Produto: ");
                    int quantidadeProduto = scanner.nextInt();

                    nomesProdutos[quantidadeProdutos] = nomeProduto;
                    precosProdutos[quantidadeProdutos] = precoProduto;
                    quantidadesProdutos[quantidadeProdutos] = quantidadeProduto;
                    quantidadeProdutos++;

                    System.out.println("\nProduto cadastrado com sucesso!");
                }
                case 2 -> {
                    System.out.println("\n----- Lista de Produtos -----");
                    for (int i = 0; i < quantidadeProdutos; i++) {
                        System.out.println("Nome: " + nomesProdutos[i]);
                        System.out.println("Preço: R$ " + precosProdutos[i]);
                        System.out.println("Quantidade: " + quantidadesProdutos[i]);
                        System.out.println("-----------------------");
                    }
                }
                case 3 -> System.out.println("\nSaindo... Obrigado!");
                default -> System.out.println("\nOpção inválida. Por favor, escolha uma opção válida.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}
