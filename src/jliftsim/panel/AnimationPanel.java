package jliftsim.panel;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class AnimationPanel extends JPanel implements Observer {

    private JSeparator m_LeftSeparator;

    public AnimationPanel() {
        m_LeftSeparator = new JSeparator();

        createAndShowGUI();
    }

    private void createAndShowGUI() {
        this.setLayout(null);
        Dimension dm = new Dimension();
        dm.setSize(300, 600);
        this.setPreferredSize(dm);

        /*
         * Common size
         */
        Rectangle r = new Rectangle();

        //######################################################################
        /*
         * Separator
         */
        r.x = 0;
        r.y = 0;
        r.height = dm.height;
        r.width = 2;
        m_LeftSeparator.setOrientation(SwingConstants.VERTICAL);
        m_LeftSeparator.setBounds(r);
        this.add(m_LeftSeparator);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update Endlich in AnimationPanel! ");
    }
}
