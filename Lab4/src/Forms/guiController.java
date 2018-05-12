package Forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * creates gui object, sets actions, performed by compare button
 */

public class guiController {

    public GUI gui;

    /**
     * constructor
     */

    public guiController() {
        gui = new GUI("Comparator");
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.pack();
        gui.setVisible(true);
        gui.getCompareButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringComparisonThread strCmp = new stringComparisonThread(gui.getFirstStringTextArea().getText(),
                        gui.getSecondStringTextArea().getText());
                strCmp.start();
                try {
                    strCmp.join();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                gui.getResultValueStringArea().setText(strCmp.getResult());
            }
        });
    }
}