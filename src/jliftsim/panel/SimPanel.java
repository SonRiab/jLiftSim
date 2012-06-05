package jliftsim.panel;

import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class SimPanel extends JPanel {
    private String m_Name;
    private int m_Floors;
    private int m_MaxPower;
    private int m_MaxSpeed;
    private int m_MaxLoad;
    private int m_MaxAcceleration;

    private AnimationPanel m_AnimationPanel;
    private EnginePanel m_EnginePanel;
    private InCabinRoomPanel m_InCabinRoomPanel;

    private void createAndShowGUI() {
        this.setLayout(null);
        Dimension dm = new Dimension();
        dm.setSize(1000, 600);
        this.setPreferredSize(dm);

        m_EnginePanel = new EnginePanel();
        m_EnginePanel.setBounds(0, 0, 700, 200);
        //m_EnginePanel.setBackground(java.awt.Color.BLUE);
        this.add(m_EnginePanel);

        m_InCabinRoomPanel = new InCabinRoomPanel();
        m_InCabinRoomPanel.setBounds(0, 200, 700, 400);
        //m_InCabinRoomPanel.setBackground(java.awt.Color.CYAN);
        this.add(m_InCabinRoomPanel);

        m_AnimationPanel = new AnimationPanel();
        m_AnimationPanel.setBounds(700, 0, 300, 600);
        //m_AnimationPanel.setBackground(java.awt.Color.RED);
        this.add(m_AnimationPanel);
    }

    public SimPanel(
         String name
        ,int floors
        ,int maxPower
        ,int maxSpeed
        ,int maxLoad
        ,int maxAcceleration
    ) {
        m_Name = name;
        m_Floors = floors;
        m_MaxPower = maxPower;
        m_MaxSpeed = maxSpeed;
        m_MaxLoad = maxLoad;
        m_MaxAcceleration = maxAcceleration;

        createAndShowGUI();
    }
}
