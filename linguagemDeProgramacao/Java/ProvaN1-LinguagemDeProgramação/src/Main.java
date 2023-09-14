import java.util.ArrayList;

public class Main {

    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list) {

        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list
        for (T element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list
        return newList;
    }

    public static String dateWithMostWarnings(ArrayList<String> StringList) {
        int maxWarningCount = 0;
        ArrayList<String> daysWithMaxWarnings = new ArrayList<>();
        String string = " ";

        for (int i = 0; i < StringList.size(); i++) {
            string = StringList.get(i);

            if (string.contains("WARNING")) {
                String data = string.substring(0, 10);
                int count = 1;

                for (int j = 0; j < StringList.size(); j++) {
                    String string2 = StringList.get(j);
                    String data2 = string2.substring(0, 10);

                    // Checks if the string is the same.
                    if (string.equals(string2)) {
                        continue;
                    }

                    // Verify if the date is the same and if it has WARNING then count +1
                    if (data.equals(data2) && string2.contains("WARNING")) {
                        count += 1;
                    }
                }

                // If the count reaches the most count value, add the day to the list
                if (count > maxWarningCount) {
                    maxWarningCount = count;

                    // reset the list then add the data
                    daysWithMaxWarnings.clear();
                    daysWithMaxWarnings.add(data);

                } else if (count == maxWarningCount) {

                    // Adds the data
                    daysWithMaxWarnings.add(data);
                }
            }
        }

        daysWithMaxWarnings = removeDuplicates(daysWithMaxWarnings);

        return "The day: " + daysWithMaxWarnings + " was the day with most warnings;\nIn that day it occored "
                + maxWarningCount + " times\n";
    }

    public static ArrayList<String> wichUserReceivedThat(String textToFind, ArrayList<String> StringList) {
        String string, user;
        ArrayList<String> usersLists = new ArrayList<>();

        for (int i = 0; i < StringList.size(); i++) {
            string = StringList.get(i);

            if (string.contains(textToFind)) {

                user = string.substring(string.indexOf("Usuário:") + 9, string.indexOf(" - ID da Transação"));

                usersLists.add(user);
            }
        }
        usersLists = removeDuplicates(usersLists);
        return usersLists;
    }

    public static void countInTheLog(String textToFind, ArrayList<String> StringList) {
        String string;
        int count = 0;

        for (int i = 0; i < StringList.size(); i++) {
            string = StringList.get(i);
            if (string.contains(textToFind)) {
                count += 1;
            }
        }
        System.out.println("The text: " + textToFind + " - Appers: " + count + "\n");
    }

    public static void daysWithError(ArrayList<String> StringList) {
        String string;
        ArrayList<String> daysWithErrors = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < StringList.size(); i++) {
            string = StringList.get(i);
            if (string.contains("ERROR - ")) {
                count += 1;
                daysWithErrors.add(string.substring(0, 10));
            }
        }
        System.out.println("These are the days that occor errors:\n" + daysWithErrors);
        System.out.println("The system registered errors in " + count + " days\n");
    }

    public static void findUser(String userName, ArrayList<String> StringList) {
        String string;
        int countWithError = 0, count = 0;

        for (int i = 0; i < StringList.size(); i++) {
            string = StringList.get(i);

            if (string.contains(userName)) {
                count += 1;
            }

            if (string.contains(userName) && string.contains("ERROR - ")) {
                countWithError += 1;
            }
        }
        System.out.println(userName + " - Appers: " + count + " Times and " + countWithError + " were with errors\n");
    }

    public static ArrayList<String> showAllUsers(ArrayList<String> StringList) {
        String string;
        ArrayList<String> usersLists = new ArrayList<>();

        for (int i = 0; i < StringList.size(); i++) {
            string = StringList.get(i);
            usersLists.add(string.substring(string.indexOf("Usuário:") + 9, string.indexOf(" - ID da Transação:")));
        }

        usersLists = removeDuplicates(usersLists);
        return usersLists;
    }

    public static void main(String[] args) {

        // Constante Java com o valor do caminho do arquivo
        final String caminhoDoArquivo = "src/ecommerce_log.txt";

        // Declaração de um ArrayList de String para armazenar cada linha do log do
        // arquivo
        ArrayList<String> logs;

        // Utilização do método para ler o arquivo de texto e atribuir cada linha ao
        // ArrayList como Strings
        logs = LeituraArquivoTxt.lerArquivoTxt(caminhoDoArquivo);

        // Completed or debbuing

        // Question 1
        System.out.println("These are all the users that acessed the system: " + showAllUsers(logs) + "\n");

        // Question 2
        daysWithError(logs);

        // Question 3
        System.out.println(dateWithMostWarnings(logs));

        // Question 4
        countInTheLog("INFO - Módulo de Autenticação", logs);

        // Question 5
        findUser("bob456", logs);

        // Question 6
        System.out.println("These are the user that received a 'Aviso: operação incompleta.' msg: "
                + wichUserReceivedThat("Aviso: operação incompleta.", logs));
    }
}
