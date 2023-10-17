import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SistemaGerenciamentoProdutosDb {

    private static final String DB_URL = "jdbc:sqlite:produtos.db";

    public static void main(String[] args) {
        // try-with-resources
        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(DB_URL)
            ) {

            // Criar tabela produtos, se ainda não existir
            criarTabelaProdutos(connection);

            int opcao;

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

                        cadastrarProduto(connection, nomeProduto, precoProduto, quantidadeProduto);
                        System.out.println("\nProduto cadastrado com sucesso!");
                    }
                    case 2 -> listarProdutos(connection);
                    case 3 -> System.out.println("\nSaindo... Obrigado!");
                    default -> System.out.println("\nOpção inválida. Por favor, escolha uma opção válida.");
                }

            } while (opcao != 3);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void criarTabelaProdutos(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "preco REAL NOT NULL," +
                "quantidade INTEGER NOT NULL" +
                ");";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }

    private static void cadastrarProduto(Connection connection, String nome, double preco, int quantidade) throws SQLException {
        String sql = "INSERT INTO produtos (nome, preco, quantidade) VALUES (?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.setDouble(2, preco);
            statement.setInt(3, quantidade);
            statement.executeUpdate();
        }
    }

    private static void listarProdutos(Connection connection) throws SQLException {
        String sql = "SELECT * FROM produtos;";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n----- Lista de Produtos -----");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");
                int quantidade = resultSet.getInt("quantidade");


                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Preço: R$ " + preco);
                System.out.println("Quantidade: " + quantidade);
                System.out.println("-----------------------");
            }
        }
    }
}

