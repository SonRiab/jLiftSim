package jliftsim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Observable;
import java.util.Observer;
import jliftsim.frame.SimFrame;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class Sim extends Observable implements Observer, ActionListener, WindowListener, UserAction {

    SimData m_SimData;
    SimFrame m_SimFrame;
    NotifyRemove m_NotifyRemove;

    public Sim (
         NotifyRemove notifyRemove,
         String name
        ,int floors
        ,int maxPower
        ,int maxSpeed
        ,int maxLoad
        ,int maxAcceleration
    ) {
        m_NotifyRemove = notifyRemove;
        m_SimData = new SimData(
            name, floors, maxPower, maxSpeed, maxLoad, maxAcceleration);
        m_SimFrame = new SimFrame(this);
        m_SimFrame.setTitle(name);
        m_SimFrame.addWindowListener(this);
    }

    public void connectObserver() {
        this.addObserver(m_SimFrame);
        this.addObserver(m_SimFrame.getSimPanelInstance());
        this.addObserver(m_SimFrame.getSimPanelInstance().getEnginePanelInstance());
        this.addObserver(m_SimFrame.getSimPanelInstance().getInCabinRoomPanelInstance().getInCabinRoomFloorsPanelInstance());
        this.addObserver(m_SimFrame.getSimPanelInstance().getAnimationPanelInstance());
        this.addObserver(m_SimFrame.getSimPanelInstance().getAnimationPanelInstance());
        this.addObserver(m_SimData);
        System.out.println("countObservers: "+countObservers());
        m_SimData.addObserver(this);
    }

    public void startSimulation() {
        m_SimData.fireInitData();
        System.out.println("Start Simulation");
    }

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("Update in Sim: " +arg.toString());
        System.out.println("Now notify Childs.");
        this.setChanged();
        this.notifyObservers(arg);
        this.clearChanged();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowOpened(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        m_SimData = null;
        m_SimFrame = null;
        m_NotifyRemove.notifyRemove(this);
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void userActionAlarm() {
        System.out.println("Function in Sim: actionButtonAlarm");
        setChanged();
        notifyObservers("actionButtonAlarm pressed");
        clearChanged();
    }

    @Override
    public void userActionHand() {
        System.out.println("Function in Sim: actionButtonHand");
        setChanged();
        notifyObservers("actionButtonHand pressed");
        clearChanged();
    }

    @Override
    public void userActionDoorClose() {
        System.out.println("Function in Sim: actionButtonDoorClose");
        setChanged();
        notifyObservers("actionButtonDoorClose pressed");
        clearChanged();
    }

    @Override
    public void userActionEmergencyHold() {
        System.out.println("Function in Sim: actionButtonEmergencyHold");
        setChanged();
        notifyObservers("actionButtonEmergencyHold pressed");
        clearChanged();
    }

    @Override
    public void userActionAirCondition() {
        System.out.println("Function in Sim: actionButtonAirCondition");
        setChanged();
        notifyObservers("actionButtonAirCondition pressed");
        clearChanged();
    }

    @Override
    public void userActionDoorOpen() {
        System.out.println("Function in Sim: actionButtonDoorOpen");
        setChanged();
        notifyObservers("actionButtonDoorOpen pressed");
        clearChanged();
    }

    @Override
    public void userActionToFloor(int floor) {
        System.out.println("Function in Sim: userActionToFloor");
        setChanged();
        notifyObservers("call to floor: "+String.valueOf(floor));
        clearChanged();
    }
}
