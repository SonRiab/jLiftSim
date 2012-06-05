package jliftsim.panel;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class CreateEnginePanel  extends JPanel {
    private JLabel m_JLabelMaxPower;
    private JLabel m_JLabelMaxSpeed;
    private JLabel m_JLabelMaxLoad;
    private JLabel m_JLabelMaxAcceleration;

    private Integer[] m_JComboBoxItemsMaxPower =
        {1, 2, 5, 10, 20, 50};
    private Integer[] m_JComboBoxItemsMaxSpeed =
        {10, 15, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    private Integer[] m_JComboBoxItemsMaxLoad =
        {1000, 1500, 2000, 5000, 10000};
    private Integer[] m_JComboBoxItemsMaxAcceleration =
        {5, 10, 15, 20, 25, 30, 50};

    private JComboBox<Integer> m_JComboBoxMaxPower;
    private JComboBox<Integer> m_JComboBoxMaxSpeed;
    private JComboBox<Integer> m_JComboBoxMaxLoad;
    private JComboBox<Integer> m_JComboBoxMaxAcceleration;

    private JLabel m_JLabelMaxPowerUnit;
    private JLabel m_JLabelMaxSpeedUnit;
    private JLabel m_JLabelMaxLoadUnit;
    private JLabel m_JLabelMaxAccelerationUnit;

    public CreateEnginePanel() {
        createAndShowGUI();
    }

    public int getMaxPower() {
        return (int)m_JComboBoxMaxPower.getSelectedItem();
    }
    public int getMaxSpeed() {
        return (int)m_JComboBoxMaxSpeed.getSelectedItem();
    }
    public int getMaxLoad() {
        return (int)m_JComboBoxMaxLoad.getSelectedItem();
    }
    public int getMaxAcceleration() {
        return (int)m_JComboBoxMaxAcceleration.getSelectedItem();
    }

    private void createAndShowGUI() {
        this.setLayout(null);
        Dimension dm = new Dimension();
        dm.setSize(300, 160);
        this.setPreferredSize(dm);

        /*
         * Common size
         */
        Rectangle r = new Rectangle();

        //######################################################################
        /*
         * JLabel
         */
        m_JLabelMaxPower = new JLabel();
        r.x = 10;
        r.y = 10;
        r.width = 120;
        r.height = 20;
        m_JLabelMaxPower.setText("Max Power");
        m_JLabelMaxPower.setBounds(r);
        this.add(m_JLabelMaxPower);

        m_JLabelMaxSpeed = new JLabel();
        r.y += 40;
        m_JLabelMaxSpeed.setText("Max Speed");
        m_JLabelMaxSpeed.setBounds(r);
        this.add(m_JLabelMaxSpeed);

        m_JLabelMaxLoad = new JLabel();
        r.y += 40;
        m_JLabelMaxLoad.setText("Max Load");
        m_JLabelMaxLoad.setBounds(r);
        this.add(m_JLabelMaxLoad);

        m_JLabelMaxAcceleration = new JLabel();
        r.y += 40;
        m_JLabelMaxAcceleration.setText("Max Acceleration");
        m_JLabelMaxAcceleration.setBounds(r);
        this.add(m_JLabelMaxAcceleration);

        //######################################################################
        /*
         * JComboBox
         */
        //EngineMaxPower
        m_JComboBoxMaxPower = new JComboBox<>();
        r.x = 130;
        r.y = 10;
        r.width = 80;
        r.height = 20;
        for(Integer i : m_JComboBoxItemsMaxPower ) {
            m_JComboBoxMaxPower.addItem(i);
        }
        m_JComboBoxMaxPower.setBounds(r);
        this.add(m_JComboBoxMaxPower);

        //EngineMaxSpeed
        m_JComboBoxMaxSpeed = new JComboBox<>();
        r.y += 40;
        for(Integer i : m_JComboBoxItemsMaxSpeed ) {
            m_JComboBoxMaxSpeed.addItem(i);
        }
        m_JComboBoxMaxSpeed.setBounds(r);
        this.add(m_JComboBoxMaxSpeed);

        //EngineMaxLoad
        m_JComboBoxMaxLoad = new JComboBox<>();
        r.y += 40;
        for(Integer i : m_JComboBoxItemsMaxLoad ) {
            m_JComboBoxMaxLoad.addItem(i);
        }
        m_JComboBoxMaxLoad.setBounds(r);
        this.add(m_JComboBoxMaxLoad);

        //EngineMaxAcceleration
        m_JComboBoxMaxAcceleration = new JComboBox<>();
        r.y += 40;
        for(Integer i : m_JComboBoxItemsMaxAcceleration ) {
            m_JComboBoxMaxAcceleration.addItem(i);
        }
        m_JComboBoxMaxAcceleration.setBounds(r);
        this.add(m_JComboBoxMaxAcceleration);

        //######################################################################
        /*
         * Current Label Unit
         */
        m_JLabelMaxPowerUnit = new JLabel();
        r.x = 220;
        r.y = 10;
        r.width = 30;
        r.height = 20;
        m_JLabelMaxPowerUnit.setText("kw");
        m_JLabelMaxPowerUnit.setBounds(r);
        this.add(m_JLabelMaxPowerUnit);

        m_JLabelMaxSpeedUnit = new JLabel();
        r.y += 40;
        m_JLabelMaxSpeedUnit.setText("km/h");
        m_JLabelMaxSpeedUnit.setBounds(r);
        this.add(m_JLabelMaxSpeedUnit);

        m_JLabelMaxLoadUnit = new JLabel();
        r.y += 40;
        m_JLabelMaxLoadUnit.setText("kg");
        m_JLabelMaxLoadUnit.setBounds(r);
        this.add(m_JLabelMaxLoadUnit);

        m_JLabelMaxAccelerationUnit = new JLabel();
        r.y += 40;
        m_JLabelMaxAccelerationUnit.setText("m/s²");
        m_JLabelMaxAccelerationUnit.setBounds(r);
        this.add(m_JLabelMaxAccelerationUnit);

    }

}
