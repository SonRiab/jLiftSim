package jliftsim.panel;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jliftsim.frame.SimFrame;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class CreatePanel extends JPanel implements ActionListener {
    private JLabel m_JLabelFloors;
    private JLabel m_JLabelEngineMaxPower;
    private JLabel m_JLabelEngineMaxSpeed;
    private JLabel m_JLabelEngineMaxLoad;
    private JLabel m_JLabelEngineMaxAcceleration;

    private Integer[] m_JComboBoxItemsFloors =
        {10, 50, 100, 163, 250, 500, 1000, 2000, 5000, 9000};
    private Integer[] m_JComboBoxItemsEngineMaxPower =
        {1, 2, 5, 10, 20, 50};
    private Integer[] m_JComboBoxItemsEngineMaxSpeed =
        {10, 15, 20, 30, 40, 50, 60, 70, 80, 90, 100};
    private Integer[] m_JComboBoxItemsEngineMaxLoad =
        {1000, 1500, 2000, 5000, 10000};
    private Integer[] m_JComboBoxItemsEngineMaxAcceleration =
        {5, 10, 15, 20, 25, 30, 50};

    private JComboBox<Integer> m_JComboBoxFloors;
    private JComboBox<Integer> m_JComboBoxEngineMaxPower;
    private JComboBox<Integer> m_JComboBoxEngineMaxSpeed;
    private JComboBox<Integer> m_JComboBoxEngineMaxLoad;
    private JComboBox<Integer> m_JComboBoxEngineMaxAcceleration;

    private JButton m_JButtonCreateInstance;

    private List<SimFrame> m_SimFrames;

    public CreatePanel() {
        m_SimFrames = new ArrayList<>();
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        this.setLayout(null);
        Dimension dm = new Dimension();
        dm.setSize(300, 240);
        this.setPreferredSize(dm);

        /*
         * JLabel
         */
        m_JLabelFloors = new JLabel();
        m_JLabelFloors.setText("Number of floors");
        m_JLabelFloors.setBounds(10, 10, 200, 20);
        this.add(m_JLabelFloors);

        m_JLabelEngineMaxPower = new JLabel();
        m_JLabelEngineMaxPower.setText("Engine Max Power [kw]");
        m_JLabelEngineMaxPower.setBounds(10, 50, 200, 20);
        this.add(m_JLabelEngineMaxPower);

        m_JLabelEngineMaxSpeed = new JLabel();
        m_JLabelEngineMaxSpeed.setText("Engine Max Speed [km/h]");
        m_JLabelEngineMaxSpeed.setBounds(10, 90, 200, 20);
        this.add(m_JLabelEngineMaxSpeed);

        m_JLabelEngineMaxLoad = new JLabel();
        m_JLabelEngineMaxLoad.setText("Engine Max Load [kg]");
        m_JLabelEngineMaxLoad.setBounds(10, 130, 200, 20);
        this.add(m_JLabelEngineMaxLoad);

        m_JLabelEngineMaxAcceleration = new JLabel();
        m_JLabelEngineMaxAcceleration.setText("Engine Max Acceleration [m/s²]");
        m_JLabelEngineMaxAcceleration.setBounds(10, 170, 200, 20);
        this.add(m_JLabelEngineMaxAcceleration);

        /*
         * JComboBox
         */
        //Floors
        m_JComboBoxFloors = new JComboBox<>();
        for(Integer i : m_JComboBoxItemsFloors ) {
            m_JComboBoxFloors.addItem(i);
        }
        m_JComboBoxFloors.setBounds(210, 10, 80, 20);
        this.add(m_JComboBoxFloors);

        //EngineMaxPower
        m_JComboBoxEngineMaxPower = new JComboBox<>();
        for(Integer i : m_JComboBoxItemsEngineMaxPower ) {
            m_JComboBoxEngineMaxPower.addItem(i);
        }
        m_JComboBoxEngineMaxPower.setBounds(210, 50, 80, 20);
        this.add(m_JComboBoxEngineMaxPower);

        //EngineMaxSpeed
        m_JComboBoxEngineMaxSpeed = new JComboBox<>();
        for(Integer i : m_JComboBoxItemsEngineMaxSpeed ) {
            m_JComboBoxEngineMaxSpeed.addItem(i);
        }
        m_JComboBoxEngineMaxSpeed.setBounds(210, 90, 80, 20);
        this.add(m_JComboBoxEngineMaxSpeed);

        //EngineMaxLoad
        m_JComboBoxEngineMaxLoad = new JComboBox<>();
        for(Integer i : m_JComboBoxItemsEngineMaxLoad ) {
            m_JComboBoxEngineMaxLoad.addItem(i);
        }
        m_JComboBoxEngineMaxLoad.setBounds(210, 130, 80, 20);
        this.add(m_JComboBoxEngineMaxLoad);

        //EngineMaxAcceleration
        m_JComboBoxEngineMaxAcceleration = new JComboBox<>();
        for(Integer i : m_JComboBoxItemsEngineMaxAcceleration ) {
            m_JComboBoxEngineMaxAcceleration.addItem(i);
        }
        m_JComboBoxEngineMaxAcceleration.setBounds(210, 170, 80, 20);
        this.add(m_JComboBoxEngineMaxAcceleration);

        /*
         * JButton
         */
        m_JButtonCreateInstance = new JButton();
        m_JButtonCreateInstance.setText("Create lift simulation");
        m_JButtonCreateInstance.setBounds(10, 210, 170, 25);
        m_JButtonCreateInstance.addActionListener(this);
        this.add(m_JButtonCreateInstance);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name         = String.valueOf(m_SimFrames.size());
        int floors          = (int)m_JComboBoxFloors.getSelectedItem();
        int maxPower        = (int)m_JComboBoxEngineMaxPower.getSelectedItem();
        int maxSpeed        = (int)m_JComboBoxEngineMaxSpeed.getSelectedItem();
        int maxLoad         = (int)m_JComboBoxEngineMaxLoad.getSelectedItem();
        int maxAcceleration = (int)m_JComboBoxEngineMaxAcceleration.
            getSelectedItem();

        if(e.getSource() == m_JButtonCreateInstance) {
            m_JComboBoxEngineMaxLoad.getSelectedItem();

            SimFrame newSimFrame = new SimFrame(
                name,floors,maxPower,maxSpeed,maxLoad,maxAcceleration
            );

            m_SimFrames.add(newSimFrame);
            System.out.println("Add new SimFrame ("+name+")");
        }
    }
}
