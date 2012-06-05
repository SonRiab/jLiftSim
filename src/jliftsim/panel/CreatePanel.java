package jliftsim.panel;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import jliftsim.frame.SimFrame;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class CreatePanel extends JPanel implements ActionListener {
    private CreateFloorsPanel m_CreateFloorsPanel;
    private CreateEnginePanel m_CreateEnginePanel;

    private JButton m_JButtonCreateInstance;

    private List<SimFrame> m_SimFrames;

    public CreatePanel() {
        m_SimFrames = new ArrayList<>();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        this.setLayout(null);
        Dimension dm = new Dimension();
        dm.setSize(300, 230);
        this.setPreferredSize(dm);

        /*
         * Common size
         */
        Rectangle r = new Rectangle();

        m_CreateFloorsPanel = new CreateFloorsPanel();
        r.x = 0;
        r.y = 0;
        r.width = m_CreateFloorsPanel.getPreferredSize().width;
        r.height = m_CreateFloorsPanel.getPreferredSize().height;
        m_CreateFloorsPanel.setBounds(r);
        m_CreateFloorsPanel.setBackground(java.awt.Color.BLUE);
        this.add(m_CreateFloorsPanel);

        m_CreateEnginePanel = new CreateEnginePanel();
        r.y += r.height;
        r.width = m_CreateEnginePanel.getPreferredSize().width;
        r.height = m_CreateEnginePanel.getPreferredSize().height;
        m_CreateEnginePanel.setBounds(r);
        m_CreateEnginePanel.setBackground(java.awt.Color.YELLOW);
        this.add(m_CreateEnginePanel);

        /*
         * JButton
         */
        m_JButtonCreateInstance = new JButton();
        r.x = 10;
        r.y += r.height;
        r.width = 170;
        r.height = 20;
        m_JButtonCreateInstance.setText("Create lift simulation");
        m_JButtonCreateInstance.setBounds(r);
        m_JButtonCreateInstance.addActionListener(this);
        this.add(m_JButtonCreateInstance);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name         = String.valueOf(m_SimFrames.size());
        int floors          = m_CreateFloorsPanel.getFloors();
        int maxPower        = m_CreateEnginePanel.getMaxPower();
        int maxSpeed        = m_CreateEnginePanel.getMaxSpeed();
        int maxLoad         = m_CreateEnginePanel.getMaxLoad();
        int maxAcceleration = m_CreateEnginePanel.getMaxAcceleration();

        if(e.getSource() == m_JButtonCreateInstance) {
            SimFrame newSimFrame = new SimFrame(
                name,floors,maxPower,maxSpeed,maxLoad,maxAcceleration
            );

            m_SimFrames.add(newSimFrame);
            System.out.println("Add new SimFrame ("+name+")");
        }
    }
}
