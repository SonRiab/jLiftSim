package jliftsim.panel;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jliftsim.CreateNotifyArg;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class CreateFloorsPanel extends JPanel implements Observer {
    
    private JLabel m_JLabelFloors;

    private Integer[] m_JComboBoxItemsFloors =
        {10, 41, 50, 56, 88, 100, 101, 163, 250, 500, 1000, 2000, 5000, 9000};

    private JComboBox<Integer> m_JComboBoxFloors;

    public CreateFloorsPanel() {
        createAndShowGUI();
    }

    public int getFloors() {
        return (int)m_JComboBoxFloors.getSelectedItem();
    }

    private void createAndShowGUI() {
        this.setLayout(null);
        Dimension dm = new Dimension();
        dm.setSize(300, 40);
        this.setPreferredSize(dm);

        /*
         * Common size
         */
        Rectangle r = new Rectangle();

        /*
         * JLabel
         */
        r.x = 10;
        r.y = 10;
        r.width = 120;
        r.height = 20;
        m_JLabelFloors = new JLabel();
        m_JLabelFloors.setText("Number of floors");
        m_JLabelFloors.setBounds(r);
        this.add(m_JLabelFloors);

        /*
         * JComboBox
         */
        m_JComboBoxFloors = new JComboBox<>();
        for(Integer i : m_JComboBoxItemsFloors ) {
            m_JComboBoxFloors.addItem(i);
        }
        r.x = 130;
        r.y = 10;
        r.width = 80;
        r.height = 20;
        m_JComboBoxFloors.setBounds(r);
        this.add(m_JComboBoxFloors);
    }

    @Override
    public void update(Observable o, Object arg) {
        CreateNotifyArg cna;
        if( arg instanceof CreateNotifyArg ) {
            cna = (CreateNotifyArg)arg;
                m_JComboBoxFloors.setSelectedItem(cna.floors);
        }
    }
}
