package jliftsim;

import jliftsim.frame.CreateFrame;
import jliftsim.frame.SimFrame;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class JLiftSim {

    private static void createAndShowGUI() {
        CreateFrame createFrame;
        SimFrame[] simFrames;
        createFrame = new CreateFrame();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
