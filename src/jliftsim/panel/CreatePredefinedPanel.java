package jliftsim.panel;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jliftsim.CreateObservable;
import jliftsim.data.CreateFrameData;

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

        m_JLabelPredefined = new JLabel();
        m_JComboBoxPredefined = new JComboBox<>();

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
        m_JLabelPredefined.setText("Predefined");
        m_JLabelPredefined.setBounds(r);
        this.add(m_JLabelPredefined);

        /*
         * JComboBox
         */
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

                CreateFrameData cfd = new CreateFrameData();
                switch(m_JComboBoxPredefined.getSelectedIndex()) {
                    case 0: //default
                        cfd.floors = 50;
                        cfd.maxPower = 10;
                        cfd.maxSpeed = 60;
                        cfd.maxLoad = 5000;
                        cfd.maxAcceleration = 20;
                        break;
                    case 1: //Burj Khalifa (Dubai)
                        cfd.floors = 163;
                        cfd.maxPower = 11;
                        cfd.maxSpeed = 61;
                        cfd.maxLoad = 5001;
                        cfd.maxAcceleration = 21;
                        break;
                    case 2: //Taipei 101 (Taipei)
                        cfd.floors = 101;
                        cfd.maxPower = 12;
                        cfd.maxSpeed = 62;
                        cfd.maxLoad = 5002;
                        cfd.maxAcceleration = 22;
                        break;
                    case 3: //Petronas Towers (Kuala Lumpur)
                        cfd.floors = 88;
                        cfd.maxPower = 13;
                        cfd.maxSpeed = 63;
                        cfd.maxLoad = 5003;
                        cfd.maxAcceleration = 23;
                        break;
                    case 4: //Commerzbank Tower (Frankfurt a. M.)
                        cfd.floors = 56;
                        cfd.maxPower = 14;
                        cfd.maxSpeed = 64;
                        cfd.maxLoad = 5004;
                        cfd.maxAcceleration = 24;
                        break;
                    case 5: //Messeturm (Frankfurt a. M.)
                        cfd.floors = 56;
                        cfd.maxPower = 15;
                        cfd.maxSpeed = 65;
                        cfd.maxLoad = 5005;
                        cfd.maxAcceleration = 25;
                        break;
                    case 6: //Park Inn (Berlin)
                        cfd.floors = 41;
                        cfd.maxPower = 16;
                        cfd.maxSpeed = 66;
                        cfd.maxLoad = 5006;
                        cfd.maxAcceleration = 26;
                        break;
                }
                m_CreateObservable.predefinedChanged(cfd);
            }
        }
    }
}
