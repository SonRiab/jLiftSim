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
