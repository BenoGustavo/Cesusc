# Construção Passo a Passo do código

## Setup
Baixando o JDBC da internet e adicionando ao projeto


## Passo 1: Configuração Inicial e Conexão com o Banco de Dados
Primeiro, vamos configurar o ambiente e fazer a conexão com o banco de dados SQLite.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class SistemaGerenciamentoPessoasDb {

    private static final String DB_URL = "jdbc:sqlite:pessoas.db";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            System.out.println("Conexão bem-sucedida com o banco de dados.");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
```
### Explicação:
1. Importamos as classes necessárias para trabalhar com a conexão do banco de dados e entrada de dados.
2. Dentro do main, usamos um bloco try-with-resources para estabelecer uma conexão com o banco de dados SQLite. Se a conexão for bem-sucedida, uma mensagem é impressa no console.
> Execute o código para verificar se a conexão com o banco de dados está funcionando.

## Passo 2: Criar a Tabela de Pessoas
Agora vamos adicionar um método para criar a tabela de pessoas se ela ainda não existir.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class SistemaGerenciamentoPessoasDb {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            // CÓDIGO ADICIONADO
            criarTabelaPessoas(connection);
            System.out.println("Tabela 'pessoas' criada ou já existente.");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    
    // CÓDIGO ADICIONADO
    private static void criarTabelaPessoas(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS pessoas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "idade INTEGER NOT NULL," +
                "email TEXT NOT NULL" +
                ");";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }
}
```

### Explicação:

1. Criamos um método chamado criarTabelaPessoas que recebe um objeto Connection como parâmetro.
2. Usamos um bloco try-with-resources com um PreparedStatement para executar a query SQL que cria a tabela.
3. No main, chamamos criarTabelaPessoas após estabelecer a conexão com o banco de dados.
> Execute o código para verificar se a tabela é criada com sucesso.

## Passo 3: Menu Principal
Agora vamos implementar o menu principal que o usuário verá para interagir com o programa.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class SistemaGerenciamentoPessoasDb {
    
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(DB_URL)) {

            criarTabelaPessoas(connection);

            // CÓDIGO ADICIONADO
            int opcao;
            do {
                System.out.println("\n----- Sistema de Gerenciamento de Pessoas -----");
                System.out.println("1 - Cadastrar Pessoa");
                System.out.println("2 - Listar Pessoas");
                System.out.println("3 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

            } while (opcao != 3);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    
    private static void criarTabelaPessoas(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS pessoas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "idade INTEGER NOT NULL," +
                "email TEXT NOT NULL" +
                ");";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }
}
```

### Explicação:
1. Criamos um scanner para ler a entrada do usuário.
2. Inicializamos uma variável opcao para armazenar a escolha do usuário.
3. Um loop do-while exibe o menu até que o usuário escolha sair (opção 3).
> Execute o código para verificar se o menu aparece corretamente.

## Passo 4: Cadastrar Pessoas
Neste passo, vamos implementar as funcionalidades de cadastrar pessoas. 

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class SistemaGerenciamentoPessoasDb {
    
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(DB_URL)) {

            criarTabelaPessoas(connection);
            
            int opcao;
            do {
                System.out.println("\n----- Sistema de Gerenciamento de Pessoas -----");
                System.out.println("1 - Cadastrar Pessoa");
                System.out.println("2 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();

                // CÓDIGO ADICIONADO
                switch (opcao) {
                    case 1 -> {
                        scanner.nextLine();

                        System.out.print("\nNome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();

                        System.out.print("Email: ");
                        String email = scanner.next();

                        cadastrarPessoa(connection, nome, idade, email);
                        System.out.println("\nPessoa cadastrada com sucesso!");
                    }                    
                    case 2 -> System.out.println("\nSaindo... Obrigado!");
                    default -> System.out.println("\nOpção inválida. Por favor, escolha uma opção válida.");
                }
                
            } while (opcao != 3);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    
    private static void criarTabelaPessoas(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS pessoas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "idade INTEGER NOT NULL," +
                "email TEXT NOT NULL" +
                ");";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }

    // CÓDIGO ADICIONADO
    private static void cadastrarPessoa(Connection connection, String nome, int idade, String email) throws SQLException {
        String sql = "INSERT INTO pessoas (nome, idade, email) VALUES (?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.setInt(2, idade);
            statement.setString(3, email);
            statement.executeUpdate();
        }
    }
}
```

### Explicação:
1. Adicionamos a condicional switch/case para avaliar qual o objetivo do usuário.
2. Se cadastro solicitamos todas as informações de cadastro e passamos para o método de cadastro.
3. Criamos um método cadastrarPessoa para cadastrar as informações recebidas do usuário e adicionamos ao menu de pessoas
na condicional switch/case como opção 1
> Execute o código para verificar se o menu aparece corretamente.


## Passo 5: Listar Pessoas
Neste passo, vamos implementar as funcionalidades de listar pessoas.

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class SistemaGerenciamentoPessoasDb {
    
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             Connection connection = DriverManager.getConnection(DB_URL)) {

            criarTabelaPessoas(connection);
            
            int opcao;
            do {
                System.out.println("\n----- Sistema de Gerenciamento de Pessoas -----");
                System.out.println("1 - Cadastrar Pessoa");
                // CÓDIGO ADICIONADO
                System.out.println("2 - Listar Pessoas");
                System.out.println("3 - Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 1 -> {
                        scanner.nextLine();

                        System.out.print("\nNome: ");
                        String nome = scanner.nextLine();

                        System.out.print("Idade: ");
                        int idade = scanner.nextInt();

                        System.out.print("Email: ");
                        String email = scanner.next();

                        cadastrarPessoa(connection, nome, idade, email);
                        System.out.println("\nPessoa cadastrada com sucesso!");
                    }
                    // CÓDIGO ADICIONADO
                    case 2 -> listarPessoas(connection);
                    case 3 -> System.out.println("\nSaindo... Obrigado!");
                    default -> System.out.println("\nOpção inválida. Por favor, escolha uma opção válida.");
                }
                
            } while (opcao != 3);

        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
    
    private static void criarTabelaPessoas(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS pessoas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome TEXT NOT NULL," +
                "idade INTEGER NOT NULL," +
                "email TEXT NOT NULL" +
                ");";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }

    // CÓDIGO ADICIONADO
    private static void cadastrarPessoa(Connection connection, String nome, int idade, String email) throws SQLException {
        String sql = "INSERT INTO pessoas (nome, idade, email) VALUES (?, ?, ?);";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nome);
            statement.setInt(2, idade);
            statement.setString(3, email);
            statement.executeUpdate();
        }
    }

    private static void listarPessoas(Connection connection) throws SQLException {
        String sql = "SELECT * FROM pessoas;";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            System.out.println("\n----- Lista de Pessoas -----");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                int idade = resultSet.getInt("idade");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Idade: " + idade);
                System.out.println("Email: " + email);
                System.out.println("-----------------------");
            }
        }
    }
}
```

### Explicação:
1. Criamos um método listarPessoas para conectar com o banco de dados e listar todas as pessoas cadastradas.
2. Adicionamos o método listarPessoas como a opção 2 e alteramos a opção sair para 3.
> Execute o código para verificar se o menu aparece corretamente.