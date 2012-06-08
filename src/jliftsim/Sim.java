package jliftsim;

import java.util.Observable;
import java.util.Observer;
import jliftsim.frame.SimFrame;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class Sim extends Observable implements Observer {

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
        m_SimFrame = new SimFrame();
    }

    public void connectObserver() {
        this.addObserver(m_SimFrame);
        this.addObserver(m_SimFrame.getSimPanelInstance());
        this.addObserver(m_SimFrame.getSimPanelInstance().getEnginePanelInstance());
        this.addObserver(m_SimFrame.getSimPanelInstance().getInCabinRoomPanelInstance());
        this.addObserver(m_SimFrame.getSimPanelInstance().getAnimationPanelInstance());
        this.addObserver(m_SimData);
        m_SimData.addObserver(this);
    }

    public void startSimulation() {
        m_SimData.fireInitData();
        System.out.println("Start Simulation");
    }

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("Update in Sim CLASS: " +arg.toString());
        this.setChanged();
        this.notifyObservers(arg);
    }
}
