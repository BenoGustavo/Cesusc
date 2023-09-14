import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeituraArquivoTxt {

    public static ArrayList<String> lerArquivoTxt(String caminhoDoArquivo) {
        ArrayList<String> linhasDoArquivo = new ArrayList<>();

        try {
            // Abre o arquivo para leitura
            FileReader fileReader = new FileReader(caminhoDoArquivo);

            // Cria um BufferedReader para ler o arquivo
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;

            // Lê cada linha do arquivo e a adiciona à lista
            while ((linha = bufferedReader.readLine()) != null) {
                linhasDoArquivo.add(linha);
            }

            // Fecha o arquivo
            bufferedReader.close();
        } catch (IOException e) {
            // Tratamento de exceção em caso de erro de leitura
            e.printStackTrace();
        }

        // Retorna a lista de linhas do arquivo
        return linhasDoArquivo;
    }

}
