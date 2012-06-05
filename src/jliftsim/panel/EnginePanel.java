package jliftsim.panel;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class EnginePanel extends JPanel implements Observer {

    private JLabel m_JLabelCurrentPower;
    private JLabel m_JLabelCurrentSpeed;
    private JLabel m_JLabelCurrentLoad;
    private JLabel m_JLabelCurrentAcceleration;

    private JProgressBar m_JProgressBarCurrentPower;
    private JProgressBar m_JProgressBarCurrentSpeed;
    private JProgressBar m_JProgressBarCurrentLoad;
    private JProgressBar m_JProgressBarCurrentAcceleration;

    private JTextField m_JTextFieldCurrentPower;
    private JTextField m_JTextFieldCurrentSpeed;
    private JTextField m_JTextFieldCurrentLoad;
    private JTextField m_JTextFieldCurrentAcceleration;

    private JLabel m_JLabelCurrentPowerUnit;
    private JLabel m_JLabelCurrentSpeedUnit;
    private JLabel m_JLabelCurrentLoadUnit;
    private JLabel m_JLabelCurrentAccelerationUnit;

    private JLabel m_JLabelMaxPower;
    private JLabel m_JLabelMaxSpeed;
    private JLabel m_JLabelMaxLoad;
    private JLabel m_JLabelMaxAcceleration;

    private JTextField m_JTextFieldMaxPower;
    private JTextField m_JTextFieldMaxSpeed;
    private JTextField m_JTextFieldMaxLoad;
    private JTextField m_JTextFieldMaxAcceleration;

    private JLabel m_JLabelMaxPowerUnit;
    private JLabel m_JLabelMaxSpeedUnit;
    private JLabel m_JLabelMaxLoadUnit;
    private JLabel m_JLabelMaxAccelerationUnit;

    private JSeparator m_CurrentMaxSeparator;
    private JSeparator m_BottomSeparator;

    public EnginePanel() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        this.setLayout(null);
        Dimension dm = new Dimension();
        dm.setSize(700, 170);
        this.setPreferredSize(dm);

        /*
         * Common size
         */
        Rectangle r = new Rectangle();

        //######################################################################
        /*
         * Current Label
         */
        r.x = 10;
        r.y = 10;
        r.width = 120;
        r.height = 20;
        m_JLabelCurrentPower = new JLabel();
        m_JLabelCurrentPower.setText("Current power");
        m_JLabelCurrentPower.setBounds(r);
        this.add(m_JLabelCurrentPower);

        r.y += 40;
        m_JLabelCurrentSpeed = new JLabel();
        m_JLabelCurrentSpeed.setText("Current speed");
        m_JLabelCurrentSpeed.setBounds(r);
        this.add(m_JLabelCurrentSpeed);

        r.y += 40;
        m_JLabelCurrentLoad = new JLabel();
        m_JLabelCurrentLoad.setText("Current load");
        m_JLabelCurrentLoad.setBounds(r);
        this.add(m_JLabelCurrentLoad);

        r.y += 40;
        m_JLabelCurrentAcceleration = new JLabel();
        m_JLabelCurrentAcceleration.setText("Current acceleration");
        m_JLabelCurrentAcceleration.setBounds(r);
        this.add(m_JLabelCurrentAcceleration);

        //######################################################################
        /*
         * Current Progress Bar
         */
        r.x = 140;
        r.y = 10;
        r.width = 100;
        r.height = 20;
        m_JProgressBarCurrentPower = new JProgressBar();
        m_JProgressBarCurrentPower.setBounds(r);
        m_JProgressBarCurrentPower.setStringPainted(true);
        this.add(m_JProgressBarCurrentPower);

        r.y += 40;
        m_JProgressBarCurrentSpeed = new JProgressBar();
        m_JProgressBarCurrentSpeed.setBounds(r);
        m_JProgressBarCurrentSpeed.setStringPainted(true);
        this.add(m_JProgressBarCurrentSpeed);

        r.y += 40;
        m_JProgressBarCurrentLoad = new JProgressBar();
        m_JProgressBarCurrentLoad.setBounds(r);
        m_JProgressBarCurrentLoad.setStringPainted(true);
        this.add(m_JProgressBarCurrentLoad);

        r.y += 40;
        m_JProgressBarCurrentAcceleration = new JProgressBar();
        m_JProgressBarCurrentAcceleration.setBounds(r);
        m_JProgressBarCurrentAcceleration.setStringPainted(true);
        this.add(m_JProgressBarCurrentAcceleration);

        //######################################################################
        /*
         * Current Values
         */
        r.x = 250;
        r.y = 10;
        r.width = 60;
        r.height = 20;
        m_JTextFieldCurrentPower = new JTextField();
        m_JTextFieldCurrentPower.setBounds(r);
        m_JTextFieldCurrentPower.setEditable(false);
        this.add(m_JTextFieldCurrentPower);

        r.y += 40;
        m_JTextFieldCurrentSpeed = new JTextField();
        m_JTextFieldCurrentSpeed.setBounds(r);
        m_JTextFieldCurrentSpeed.setEditable(false);
        this.add(m_JTextFieldCurrentSpeed);

        r.y += 40;
        m_JTextFieldCurrentLoad = new JTextField();
        m_JTextFieldCurrentLoad.setBounds(r);
        m_JTextFieldCurrentLoad.setEditable(false);
        this.add(m_JTextFieldCurrentLoad);

        r.y += 40;
        m_JTextFieldCurrentAcceleration = new JTextField();
        m_JTextFieldCurrentAcceleration.setBounds(r);
        m_JTextFieldCurrentAcceleration.setEditable(false);
        this.add(m_JTextFieldCurrentAcceleration);

        //######################################################################
        /*
         * Current Label Unit
         */
        r.x = 320;
        r.y = 10;
        r.width = 30;
        r.height = 20;
        m_JLabelCurrentPowerUnit = new JLabel();
        m_JLabelCurrentPowerUnit.setText("kw");
        m_JLabelCurrentPowerUnit.setBounds(r);
        this.add(m_JLabelCurrentPowerUnit);

        r.y += 40;
        m_JLabelCurrentSpeedUnit = new JLabel();
        m_JLabelCurrentSpeedUnit.setText("km/h");
        m_JLabelCurrentSpeedUnit.setBounds(r);
        this.add(m_JLabelCurrentSpeedUnit);

        r.y += 40;
        m_JLabelCurrentLoadUnit = new JLabel();
        m_JLabelCurrentLoadUnit.setText("kg");
        m_JLabelCurrentLoadUnit.setBounds(r);
        this.add(m_JLabelCurrentLoadUnit);

        r.y += 40;
        m_JLabelCurrentAccelerationUnit = new JLabel();
        m_JLabelCurrentAccelerationUnit.setText("m/s²");
        m_JLabelCurrentAccelerationUnit.setBounds(r);
        this.add(m_JLabelCurrentAccelerationUnit);

        //######################################################################
        /*
         * Max Label
         */
        r.x = 370;
        r.y = 10;
        r.width = 100;
        r.height = 20;
        m_JLabelMaxPower = new JLabel();
        m_JLabelMaxPower.setText("Max power");
        m_JLabelMaxPower.setBounds(r);
        this.add(m_JLabelMaxPower);

        r.y += 40;
        m_JLabelMaxSpeed = new JLabel();
        m_JLabelMaxSpeed.setText("Max speed");
        m_JLabelMaxSpeed.setBounds(r);
        this.add(m_JLabelMaxSpeed);

        r.y += 40;
        m_JLabelMaxLoad = new JLabel();
        m_JLabelMaxLoad.setText("Max Load");
        m_JLabelMaxLoad.setBounds(r);
        this.add(m_JLabelMaxLoad);

        r.y += 40;
        m_JLabelMaxAcceleration = new JLabel();
        m_JLabelMaxAcceleration.setText("Max Acceleration");
        m_JLabelMaxAcceleration.setBounds(r);
        this.add(m_JLabelMaxAcceleration);

        //######################################################################
        /*
         * Max JTextField
         */
        r.x = 480;
        r.y = 10;
        r.width = 60;
        r.height = 20;
        m_JTextFieldMaxPower = new JTextField();
        m_JTextFieldMaxPower.setBounds(r);
        m_JTextFieldMaxPower.setEditable(false);
        this.add(m_JTextFieldMaxPower);

        r.y += 40;
        m_JTextFieldMaxSpeed = new JTextField();
        m_JTextFieldMaxSpeed.setBounds(r);
        m_JTextFieldMaxSpeed.setEditable(false);
        this.add(m_JTextFieldMaxSpeed);

        r.y += 40;
        m_JTextFieldMaxLoad = new JTextField();
        m_JTextFieldMaxLoad.setBounds(r);
        m_JTextFieldMaxLoad.setEditable(false);
        this.add(m_JTextFieldMaxLoad);

        r.y += 40;
        m_JTextFieldMaxAcceleration = new JTextField();
        m_JTextFieldMaxAcceleration.setBounds(r);
        m_JTextFieldMaxAcceleration.setEditable(false);
        this.add(m_JTextFieldMaxAcceleration);

        //######################################################################
        /*
         * Current Label Unit
         */
        r.x = 550;
        r.y = 10;
        r.width = 30;
        r.height = 20;
        m_JLabelMaxPowerUnit = new JLabel();
        m_JLabelMaxPowerUnit.setText("kw");
        m_JLabelMaxPowerUnit.setBounds(r);
        this.add(m_JLabelMaxPowerUnit);

        r.y += 40;
        m_JLabelMaxSpeedUnit = new JLabel();
        m_JLabelMaxSpeedUnit.setText("km/h");
        m_JLabelMaxSpeedUnit.setBounds(r);
        this.add(m_JLabelMaxSpeedUnit);

        r.y += 40;
        m_JLabelMaxLoadUnit = new JLabel();
        m_JLabelMaxLoadUnit.setText("kg");
        m_JLabelMaxLoadUnit.setBounds(r);
        this.add(m_JLabelMaxLoadUnit);

        r.y += 40;
        m_JLabelMaxAccelerationUnit = new JLabel();
        m_JLabelMaxAccelerationUnit.setText("m/s²");
        m_JLabelMaxAccelerationUnit.setBounds(r);
        this.add(m_JLabelMaxAccelerationUnit);

        //######################################################################
        /*
         * Separator
         */
        r.x = 360;
        r.y = 10;
        r.height = dm.height - (r.y*2);
        r.width = 2;
        m_CurrentMaxSeparator = new JSeparator();
        m_CurrentMaxSeparator.setOrientation(SwingConstants.VERTICAL);
        m_CurrentMaxSeparator.setBounds(r);
        this.add(m_CurrentMaxSeparator);

        r.x = 0;
        r.height = 2;
        r.y = dm.height - r.height;
        r.width = dm.width;
        m_BottomSeparator = new JSeparator();
        m_BottomSeparator.setBounds(r);
        this.add(m_BottomSeparator);

        /*
         * @TODO: remove
         */
        setPseudoData();
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void setPseudoData() {
        m_JProgressBarCurrentPower.setValue(50);
        m_JProgressBarCurrentSpeed.setValue(50);
        m_JProgressBarCurrentLoad.setValue(50);
        m_JProgressBarCurrentAcceleration.setValue(50);

        m_JTextFieldCurrentPower.setText("50");
        m_JTextFieldCurrentSpeed.setText("50");
        m_JTextFieldCurrentLoad.setText("50");
        m_JTextFieldCurrentAcceleration.setText("50");

        m_JTextFieldMaxPower.setText("100");
        m_JTextFieldMaxSpeed.setText("100");
        m_JTextFieldMaxLoad.setText("100");
        m_JTextFieldMaxAcceleration.setText("100");
    }
}
