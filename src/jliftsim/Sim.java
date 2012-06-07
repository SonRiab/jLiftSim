package jliftsim;

import java.util.Observable;
import jliftsim.frame.SimFrame;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class Sim extends Observable {

    private String m_Name;
    private int m_Floors;
    private int m_MaxPower;
    private int m_MaxSpeed;
    private int m_MaxLoad;
    private int m_MaxAcceleration;
    private SimFrame m_SimFrame;

    public Sim (
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

        m_SimFrame = new SimFrame();
    }
}
