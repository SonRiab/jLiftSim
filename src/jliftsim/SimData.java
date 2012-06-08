package jliftsim;

import java.util.Observable;
import java.util.Observer;
import jliftsim.data.EngineData;
import jliftsim.data.FloorData;
import jliftsim.data.NameData;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class SimData extends Observable implements Observer {

    private EngineData m_EngineData;
    private FloorData m_FloorData;
    private NameData m_NameData;

    public SimData (
         String name
        ,int floors
        ,int maxPower
        ,int maxSpeed
        ,int maxLoad
        ,int maxAcceleration
    ) {
        m_EngineData = new EngineData();
        m_FloorData = new FloorData();
        m_NameData = new NameData();
        m_NameData.name = name;

        m_FloorData.floors = floors;

        m_EngineData.maxPower = maxPower;
        m_EngineData.maxSpeed = maxSpeed;
        m_EngineData.maxLoad = maxLoad;
        m_EngineData.maxAcceleration = maxAcceleration;
    }

    public void fireNameData() {
        System.out.println("fireNameData");
        setChanged();
        notifyObservers(m_NameData);
    }

    public void fireFloorData() {
        System.out.println("fireFloorData");
        setChanged();
        notifyObservers(m_FloorData);
    }

    public void fireEngineData() {
        System.out.println("fireEngineData");
        setChanged();
        notifyObservers(m_EngineData);
    }

    public void fireInitData() {
        fireNameData();
        fireFloorData();
        fireEngineData();
    }

    @Override
    public void update(Observable o, Object arg) {
        //throw new UnsupportedOperationException("Not supported yet.");
        System.out.println("Update in SimData CLASS: "+arg.getClass().toString());
    }
}
