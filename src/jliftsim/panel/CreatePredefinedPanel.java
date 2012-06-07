package jliftsim.panel;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jliftsim.CreateNotifyArg;
import jliftsim.CreateObservable;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class CreatePredefinedPanel extends JPanel
    implements ItemListener {
    
    private JLabel m_JLabelPredefined;
    private CreateObservable m_CreateObservable;

    private String[] m_JComboBoxItemsPredefined =
        {
            "default",
            "Burj Khalifa (Dubai)",
            "Taipei 101 (Taipei)",
            "Petronas Towers (Kuala Lumpur)",
            "Commerzbank Tower (Frankfurt a. M.)",
            "Messeturm (Frankfurt a. M.)",
            "Park Inn (Berlin)"
        };

    private JComboBox<String> m_JComboBoxPredefined;

    public CreatePredefinedPanel(CreateObservable o) {
        m_CreateObservable = o;
        createAndShowGUI();
    }

    public String getPredefined() {
        return (String)m_JComboBoxPredefined.getSelectedItem();
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
        m_JLabelPredefined = new JLabel();
        m_JLabelPredefined.setText("Predefined");
        m_JLabelPredefined.setBounds(r);
        this.add(m_JLabelPredefined);

        /*
         * JComboBox
         */
        m_JComboBoxPredefined = new JComboBox<>();
        m_JComboBoxPredefined.addItemListener(this);
        for(String i : m_JComboBoxItemsPredefined ) {
            m_JComboBoxPredefined.addItem(i);
        }
        r.x = 130;
        r.y = 10;
        r.width = 160;
        r.height = 20;
        m_JComboBoxPredefined.setBounds(r);
        this.add(m_JComboBoxPredefined);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == m_JComboBoxPredefined) {
            if(e.getStateChange() == ItemEvent.SELECTED) {

                CreateNotifyArg cna = new CreateNotifyArg();
                switch(m_JComboBoxPredefined.getSelectedIndex()) {
                    case 0: //default
                        cna.floors = 50;
                        cna.maxPower = 10;
                        cna.maxSpeed = 60;
                        cna.maxLoad = 5000;
                        cna.maxAcceleration = 20;
                        break;
                    case 1: //Burj Khalifa (Dubai)
                        cna.floors = 163;
                        cna.maxPower = 10;
                        cna.maxSpeed = 60;
                        cna.maxLoad = 5000;
                        cna.maxAcceleration = 20;
                        break;
                    case 2: //Taipei 101 (Taipei)
                        cna.floors = 101;
                        cna.maxPower = 10;
                        cna.maxSpeed = 60;
                        cna.maxLoad = 5000;
                        cna.maxAcceleration = 20;
                        break;
                    case 3: //Petronas Towers (Kuala Lumpur)
                        cna.floors = 88;
                        cna.maxPower = 10;
                        cna.maxSpeed = 60;
                        cna.maxLoad = 5000;
                        cna.maxAcceleration = 20;
                        break;
                    case 4: //Commerzbank Tower (Frankfurt a. M.)
                        cna.floors = 56;
                        cna.maxPower = 10;
                        cna.maxSpeed = 60;
                        cna.maxLoad = 5000;
                        cna.maxAcceleration = 20;
                        break;
                    case 5: //Messeturm (Frankfurt a. M.)
                        cna.floors = 56;
                        cna.maxPower = 10;
                        cna.maxSpeed = 60;
                        cna.maxLoad = 5000;
                        cna.maxAcceleration = 20;
                        break;
                    case 6: //Park Inn (Berlin)
                        cna.floors = 41;
                        cna.maxPower = 10;
                        cna.maxSpeed = 60;
                        cna.maxLoad = 5000;
                        cna.maxAcceleration = 20;
                        break;
                }
                m_CreateObservable.predefinedChanged(cna);
            }
        }
    }
}
