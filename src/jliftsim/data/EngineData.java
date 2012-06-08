package jliftsim.data;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class EngineData extends Object {

    public int maxPower;
    public int maxSpeed;
    public int maxLoad;
    public int maxAcceleration;

    public void EngineData(
        int maxPower,
        int maxSpeed,
        int maxLoad,
        int maxAcceleration
    ) {
        this.maxPower = maxPower;
        this.maxSpeed = maxSpeed;
        this.maxLoad = maxLoad;
        this.maxAcceleration = maxAcceleration;
    }

    public void EngineData( ) { }
}
