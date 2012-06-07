package jliftsim;

import java.util.Observable;
import java.util.Observer;
import jliftsim.frame.SimFrame;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class SimData extends Observable implements Observer {

    private String m_Name;
    private int m_Floors;
    private int m_MaxPower;
    private int m_MaxSpeed;
    private int m_MaxLoad;
    private int m_MaxAcceleration;
    private SimFrame m_SimFrame;

    public SimData (
         String name
        ,int floors
        ,int maxPower
        ,int maxSpeed
        ,int maxLoad
        ,int maxAcceleration
    ) {
        m_Name = name;
        m_Floors = floors;
        m_MaxPower = maxPower;
        m_MaxSpeed = maxSpeed;
        m_MaxLoad = maxLoad;
        m_MaxAcceleration = maxAcceleration;
    }

    public void fireInitData() {
        System.out.println("fire init data");
        setChanged();
        notifyObservers("fireInitData");
    }

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("Update in SimData"+arg.toString());
    }
}
