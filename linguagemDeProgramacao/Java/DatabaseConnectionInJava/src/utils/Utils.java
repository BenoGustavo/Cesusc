package utils;

import java.util.ArrayList;

public class Utils {

    public static boolean isStringAnInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int convertStringToInteger(String string) {
        return Integer.parseInt(string);
    }

    public static boolean isUserInputValid(String userInput, ArrayList<Integer> validOptions) {
        if (isStringAnInteger(userInput) && userInput != null && !userInput.isEmpty()) {
            int userInputAsInteger = convertStringToInteger(userInput);

            if (validOptions.contains(userInputAsInteger)) {
                return true;
            }
        }
        return false;
    }
}
