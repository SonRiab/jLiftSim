package jliftsim.panel;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class SimPanel extends JPanel implements Observer {

    private AnimationPanel m_AnimationPanel;
    private EnginePanel m_EnginePanel;
    private InCabinRoomPanel m_InCabinRoomPanel;

    public EnginePanel getEnginePanelInstance() {
        return m_EnginePanel;
    }

    public EnginePanel getInCabinRoomPanelInstance() {
        return m_EnginePanel;
    }

    public EnginePanel getAnimationPanelInstance() {
        return m_EnginePanel;
    }

    public SimPanel(
    ) {
        m_EnginePanel = new EnginePanel();
        m_InCabinRoomPanel = new InCabinRoomPanel();
        m_AnimationPanel = new AnimationPanel();

        createAndShowGUI();
    }

    private void createAndShowGUI() {
        this.setLayout(null);
        Dimension dm = new Dimension();
        dm.setSize(1000, 600);
        this.setPreferredSize(dm);

        m_EnginePanel.setBounds(0, 0, 700, 200);
        //m_EnginePanel.setBackground(java.awt.Color.BLUE);
        this.add(m_EnginePanel);

        m_InCabinRoomPanel.setBounds(0, 200, 700, 400);
        //m_InCabinRoomPanel.setBackground(java.awt.Color.CYAN);
        this.add(m_InCabinRoomPanel);

        m_AnimationPanel.setBounds(700, 0, 300, 600);
        //m_AnimationPanel.setBackground(java.awt.Color.RED);
        this.add(m_AnimationPanel);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update Endlich in SimPanel! ");
    }
}
