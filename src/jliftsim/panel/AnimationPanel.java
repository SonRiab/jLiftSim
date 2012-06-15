package jliftsim.panel;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import jliftsim.Sim;
import jliftsim.UserAction;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class AnimationPanel extends JPanel implements Observer {

    private UserAction m_UserAction;

    private JSeparator m_LeftSeparator;

    private JCheckBox m_JCheckBoxDoorClosing;
    private JCheckBox m_JCheckBoxDoorOpening;

    public AnimationPanel(UserAction userAction) {
        m_UserAction = userAction;
        m_LeftSeparator = new JSeparator();

        m_JCheckBoxDoorClosing = new JCheckBox();
        m_JCheckBoxDoorOpening = new JCheckBox();

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

        //######################################################################
        /*
         * JCheckBox
         */
        r.x = 10;
        r.y = 400;
        r.width = 160;
        r.height = 20;
        r.y += 40;
        m_JCheckBoxDoorClosing.setText("Door is closing");
        m_JCheckBoxDoorClosing.setEnabled(false);
        m_JCheckBoxDoorClosing.setSelected(true);
        m_JCheckBoxDoorClosing.setBounds(r);
        this.add(m_JCheckBoxDoorClosing);

        r.y += 40;
        m_JCheckBoxDoorOpening.setText("Door is opening");
        m_JCheckBoxDoorOpening.setEnabled(false);
        m_JCheckBoxDoorOpening.setSelected(true);
        m_JCheckBoxDoorOpening.setBounds(r);
        this.add(m_JCheckBoxDoorOpening);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update in AnimationPanel: " +arg.toString());
    }
}
