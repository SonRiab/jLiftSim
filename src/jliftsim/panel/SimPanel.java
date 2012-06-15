package jliftsim.panel;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import jliftsim.Sim;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class SimPanel extends JPanel implements Observer {

    private Sim m_SimInstance;

    private AnimationPanel m_AnimationPanel;
    private EnginePanel m_EnginePanel;
    private InCabinRoomPanel m_InCabinRoomPanel;

    public EnginePanel getEnginePanelInstance() {
        return m_EnginePanel;
    }

    public InCabinRoomPanel getInCabinRoomPanelInstance() {
        return m_InCabinRoomPanel;
    }

    public AnimationPanel getAnimationPanelInstance() {
        return m_AnimationPanel;
    }

    public SimPanel(Sim simInstance) {
        m_SimInstance = simInstance;
        m_EnginePanel = new EnginePanel(m_SimInstance);
        m_InCabinRoomPanel = new InCabinRoomPanel(m_SimInstance);
        m_AnimationPanel = new AnimationPanel(m_SimInstance);

        createAndShowGUI();
    }

    private void createAndShowGUI() {
        this.setLayout(null);
        Dimension dm = new Dimension();
        dm.setSize(1000, 600);
        this.setPreferredSize(dm);

        Dimension dmEnginePanel = m_EnginePanel.getPreferredSize();
        m_EnginePanel.setBounds(
            0, 0,
            dmEnginePanel.width, dmEnginePanel.height);
        //m_EnginePanel.setBackground(java.awt.Color.BLUE);
        this.add(m_EnginePanel);

        Dimension dmInCabinRoomPanel = m_InCabinRoomPanel.getPreferredSize();
        m_InCabinRoomPanel.getPreferredSize();
        m_InCabinRoomPanel.setBounds(
            0, dmEnginePanel.height,
            dmInCabinRoomPanel.width, dmInCabinRoomPanel.height);
        //m_InCabinRoomPanel.setBackground(java.awt.Color.CYAN);
        this.add(m_InCabinRoomPanel);

        Dimension dmAnimationPanel = m_AnimationPanel.getPreferredSize();
        m_AnimationPanel.setBounds(
            dmInCabinRoomPanel.width, 0,
            dmAnimationPanel.width, dmAnimationPanel.height);
        //m_AnimationPanel.setBackground(java.awt.Color.RED);
        this.add(m_AnimationPanel);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update in SimPanel: " +arg.toString());
    }
}
