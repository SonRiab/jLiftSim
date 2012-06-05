package jliftsim.frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import jliftsim.panel.SimPanel;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class SimFrame extends JFrame {

    SimPanel m_SimPanel;

    private void createAndShowGUI(
         String name
        ,int floors
        ,int maxPower
        ,int maxSpeed
        ,int maxLoad
        ,int maxAcceleration
    ) {
        m_SimPanel = new SimPanel(
            name, floors, maxPower, maxSpeed, maxLoad, maxAcceleration);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("jLiftSim SimFrame ("+name+")");
        this.add(m_SimPanel);
        /*
         * http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=4511106
         * First Call To JWindow.pack() gives inconsistent
         * size(height rtns one Pixel less)
         * resolution: call this.pack() twice
         */
        this.pack();
        this.pack();
        centerThis();
    }

    public SimFrame(
         String name
        ,int floors
        ,int maxPower
        ,int maxSpeed
        ,int maxLoad
        ,int maxAcceleration
    ) {
        createAndShowGUI(
            name, floors, maxPower, maxSpeed, maxLoad, maxAcceleration);
    }

    public void centerThis() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int top  = (screenSize.height - getHeight()) / 2;
        int left = (screenSize.width  - getWidth() ) / 2;
        setLocation(left, top);
    }
}
