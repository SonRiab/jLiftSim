package jliftsim;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import jliftsim.frame.SimFrame;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class Sim extends Observable implements Observer, ActionListener {

    SimData m_SimData;
    SimFrame m_SimFrame;

    public Sim (
         String name
        ,int floors
        ,int maxPower
        ,int maxSpeed
        ,int maxLoad
        ,int maxAcceleration
    ) {
        m_SimData = new SimData(
            name, floors, maxPower, maxSpeed, maxLoad, maxAcceleration);
        m_SimFrame = new SimFrame(this);
    }

    public void connectObserver() {
        this.addObserver(m_SimFrame);
        this.addObserver(m_SimFrame.getSimPanelInstance());
        this.addObserver(m_SimFrame.getSimPanelInstance().getEnginePanelInstance());
        this.addObserver(m_SimFrame.getSimPanelInstance().getInCabinRoomPanelInstance());
        this.addObserver(m_SimFrame.getSimPanelInstance().getAnimationPanelInstance());
        this.addObserver(m_SimData);
        System.out.println("countObservers: "+countObservers());
        m_SimData.addObserver(this);
    }

    public void startSimulation() {
        m_SimData.fireInitData();
        System.out.println("Start Simulation");
    }

    public void actionButtonEmergencyHold() {
        System.out.println("Function in Sim: actionButtonEmergencyHold");
        setChanged();
        notifyObservers("actionButtonEmergencyHold pressed");
        clearChanged();
    }

    public void actionButtonHand() {
        System.out.println("Function in Sim: actionButtonHand");
        setChanged();
        notifyObservers("actionButtonHand pressed");
        clearChanged();
    }

    public void actionButtonAlarm() {
        System.out.println("Function in Sim: actionButtonAlarm");
        setChanged();
        notifyObservers("actionButtonAlarm pressed");
        clearChanged();
    }

    public void actionButtonDoorClose() {
        System.out.println("Function in Sim: actionButtonDoorClose");
        setChanged();
        notifyObservers("actionButtonDoorClose pressed");
        clearChanged();
    }

    public void actionButtonAirCondition() {
        System.out.println("Function in Sim: actionButtonAirCondition");
        setChanged();
        notifyObservers("actionButtonAirCondition pressed");
        clearChanged();
    }

    public void actionButtonDoorOpen() {
        System.out.println("Function in Sim: actionButtonDoorOpen");
        setChanged();
        notifyObservers("actionButtonDoorOpen pressed");
        clearChanged();
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
