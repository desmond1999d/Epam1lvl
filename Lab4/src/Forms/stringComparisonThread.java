package Forms;

/**
 * Class, that contains 2 strings and using cmpThread
 * compares them symbol by symbol
 */

public class stringComparisonThread extends Thread {
    private String firstString;
    private String secondString;
    private cmpThread compareChars;
    private String result;

    /**
     * Constructor
     * @param first first line
     * @param second second line
     */

    public stringComparisonThread(String first, String second) {
        firstString = first;
        secondString = second;
    }

    /**
     * @return result string
     */

    public String getResult() {
        return result;
    }

    /**
     * sends 2 symbols to a cmpThread and compares 2 strings symbol by symbol
     */

    @Override
    public void run() {
        if (firstString.length() != secondString.length()) {
            result = "Strings have different length.";
            return;
        }
        for (int i = 0; (i < firstString.length() && i < secondString.length()); i++) {
            compareChars = new cmpThread(firstString.charAt(i), secondString.charAt(i));
            compareChars.start();
            try {
                compareChars.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!compareChars.getResult()) {
                result = "Strings are different. First different symbol is " + (i + 1) + ". Symbol '" +
                        firstString.charAt(i) + "' was changed with '" + secondString.charAt(i) + "'.";
                return;
            }
        }
        result = "Strings are equal.";
        return;
    }
}
