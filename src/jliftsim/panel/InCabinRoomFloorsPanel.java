package jliftsim.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import jliftsim.UserAction;
import jliftsim.data.FloorData;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class InCabinRoomFloorsPanel extends JPanel implements Observer,
        ActionListener {
    
    private UserAction m_UserAction;

    private ArrayList<JButton> m_FloorButtonList;

    public InCabinRoomFloorsPanel(UserAction userAction) {
        m_UserAction = userAction;
        m_FloorButtonList = new ArrayList<>();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        this.setLayout(new GridLayout(0, 10));
    }

    private void removeButtons() {
        for(JButton button : m_FloorButtonList) {
            this.remove(button);
        }
        m_FloorButtonList.clear();
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update in InCabinRoomFloorsPanel: " +arg.toString());
        if( arg instanceof FloorData ) {
            FloorData fd = (FloorData)arg;
            //This should never be happened but is implemented
            removeButtons();
            for(int i=0; i<fd.floors;++i) {
                JButton button = new JButton(String.valueOf(i));
                m_FloorButtonList.add(button);
                button.addActionListener(this);
                this.add(button);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() instanceof JButton ) {
            JButton button = (JButton)e.getSource();
            int number = m_FloorButtonList.indexOf(button);
            m_UserAction.userActionToFloor(number);
        }
        
    }

}
