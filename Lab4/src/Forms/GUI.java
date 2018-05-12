package Forms;

import javax.swing.*;
import java.awt.*;

/**
 * basic gui class
 */

public class GUI extends JFrame
{
    private JButton compareButton;
    private JTextArea firstStringTextArea;
    private JTextArea secondStringTextArea;
    private JTextArea resultValueStringArea;
    private JLabel resultStringLabel;

    /**
     * @return compare button object
     */

    public JButton getCompareButton() {
        return compareButton;
    }

    /**
     * @return first TextArea object
     */

    public JTextArea getFirstStringTextArea() {
        return firstStringTextArea;
    }

    /**
     * @return second TextArea object
     */

    public JTextArea getSecondStringTextArea() {
        return secondStringTextArea;
    }

    /**
     * @return result TextArea object
     */

    public JTextArea getResultValueStringArea() {
        return resultValueStringArea;
    }

    /**
     * Constructor
     * Builds gui
     * @param title
     */

    public GUI(String title) {
        super(title);

        JPanel mainPanel = new JPanel();
        BoxLayout mainLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(mainLayout);

        Container enterData = new Container();
        mainPanel.add(enterData);
        mainPanel.add(Box.createVerticalStrut(10));
        enterData.setLayout(new BoxLayout(enterData,BoxLayout.X_AXIS));

        compareButton = new JButton("Compare");
        firstStringTextArea = new JTextArea(10, 20);
        secondStringTextArea = new JTextArea(10, 20);
        firstStringTextArea.setLineWrap(true);
        secondStringTextArea.setLineWrap(true);

        enterData.add(firstStringTextArea);
        enterData.add(compareButton);
        enterData.add(secondStringTextArea);

        Container resultText = new Container();
        BoxLayout boxLayout = new BoxLayout(resultText,BoxLayout.X_AXIS);
        resultText.setLayout((boxLayout));

        resultStringLabel = new JLabel("Result");
        resultText.add(resultStringLabel);


        Container resultInfo = new Container();
        BoxLayout resultboxLayout = new BoxLayout(resultInfo,BoxLayout.X_AXIS);
        resultInfo.setLayout(resultboxLayout);

        resultValueStringArea = new JTextArea(5, 20);
        resultValueStringArea.setLineWrap(true);
        resultValueStringArea.setEditable(false);
        resultInfo.add(resultValueStringArea);

        mainPanel.add(resultText);
        mainPanel.add(Box.createVerticalStrut(10));
        mainPanel.add(resultInfo);

        this.add((mainPanel));
        this.pack();
        this.setVisible(true);
    }
}