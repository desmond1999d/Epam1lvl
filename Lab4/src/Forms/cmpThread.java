package Forms;

/**
 * Thread, that compares two symbols
 */

public class cmpThread extends Thread {
    private char firstSymbol;
    private char secondSymbol;
    private boolean result;

    /**
     * constructor
     * @param first first symbol
     * @param second second symbol
     */

    public cmpThread(char first, char second) {
        firstSymbol = first;
        secondSymbol = second;
    }

    /**
     * @return true if equal, otherwise - false
     */

    public boolean getResult() {
        return result;
    }

    /**
     * Comparison action
     */

    @Override
    public void run() {
        if (firstSymbol == secondSymbol)
            result = true;
        else
            result = false;
    }
}
