package jliftsim.panel;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import jliftsim.CreateObservable;
import jliftsim.frame.SimFrame;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class CreatePanel extends JPanel implements ActionListener {
    private CreateFloorsPanel m_CreateFloorsPanel;
    private CreateEnginePanel m_CreateEnginePanel;
    private CreatePredefinedPanel m_CreatePredefinedPanel;

    private JButton m_JButtonCreateInstance;

    private JSeparator m_FloorsSeparator;
    private JSeparator m_EngineSeparator;
    private JSeparator m_PredefinedSeparator;

    private List<SimFrame> m_SimFrames;

    private CreateObservable m_CreateObservable;

    public CreatePanel() {
        m_SimFrames = new ArrayList<>();
        m_CreateObservable = new CreateObservable();

        m_CreateFloorsPanel = new CreateFloorsPanel();
        m_CreateEnginePanel = new CreateEnginePanel();
        m_CreatePredefinedPanel = new CreatePredefinedPanel(
            m_CreateObservable);

        m_CreateObservable.addObserver(m_CreateFloorsPanel);
        m_CreateObservable.addObserver(m_CreateEnginePanel);

        m_JButtonCreateInstance = new JButton();
        m_FloorsSeparator = new JSeparator();
        m_EngineSeparator = new JSeparator();
        m_PredefinedSeparator = new JSeparator();

        createAndShowGUI();
    }

    private void createAndShowGUI() {
        this.setLayout(null);
        Dimension dm = new Dimension();
        dm.setSize(300, 278);
        this.setPreferredSize(dm);

        /*
         * Common size
         */
        Rectangle r = new Rectangle();
        Rectangle rFloorsSeparator = new Rectangle();
        Rectangle rEngineSeparator = new Rectangle();
        Rectangle rPredefinedSeparator = new Rectangle();

        r.x = 0;
        r.y = 0;
        r.width = m_CreateFloorsPanel.getPreferredSize().width;
        r.height = m_CreateFloorsPanel.getPreferredSize().height;

        rFloorsSeparator.x = 0;
        rFloorsSeparator.y = r.y + r.height;
        rFloorsSeparator.height = 2;
        rFloorsSeparator.width = r.width;
        
        m_CreateFloorsPanel.setBounds(r);
        //m_CreateFloorsPanel.setBackground(java.awt.Color.BLUE);
        this.add(m_CreateFloorsPanel);

        r.y += r.height + rFloorsSeparator.height;
        r.width = m_CreateEnginePanel.getPreferredSize().width;
        r.height = m_CreateEnginePanel.getPreferredSize().height;

        rEngineSeparator.x = 0;
        rEngineSeparator.y = r.y + r.height;
        rEngineSeparator.height = 2;
        rEngineSeparator.width = r.width;

        m_CreateEnginePanel.setBounds(r);
        //m_CreateEnginePanel.setBackground(java.awt.Color.YELLOW);
        this.add(m_CreateEnginePanel);

        r.y += r.height + rEngineSeparator.height;
        r.width = m_CreatePredefinedPanel.getPreferredSize().width;
        r.height = m_CreatePredefinedPanel.getPreferredSize().height;

        rPredefinedSeparator.x = 0;
        rPredefinedSeparator.y = r.y + r.height;
        rPredefinedSeparator.height = 2;
        rPredefinedSeparator.width = r.width;
        
        m_CreatePredefinedPanel.setBounds(r);
        //m_CreatePredefinedPanel.setBackground(java.awt.Color.LIGHT_GRAY);
        this.add(m_CreatePredefinedPanel);

        /*
         * JButton
         */
        r.x = 10;
        r.y += r.height + rEngineSeparator.height + 4;
        r.width = 170;
        r.height = 20;
        m_JButtonCreateInstance.setText("Create lift simulation");
        m_JButtonCreateInstance.setBounds(r);
        m_JButtonCreateInstance.addActionListener(this);
        this.add(m_JButtonCreateInstance);

        //######################################################################
        /*
         * Separator
         */
        m_FloorsSeparator.setBounds(rFloorsSeparator);
        this.add(m_FloorsSeparator);

        m_EngineSeparator.setBounds(rEngineSeparator);
        this.add(m_EngineSeparator);

        m_PredefinedSeparator.setBounds(rPredefinedSeparator);
        this.add(m_PredefinedSeparator);
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
