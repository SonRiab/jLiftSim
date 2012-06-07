package jliftsim;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class CreateNotifyArg extends Object {

    public int floors;
    public int maxPower;
    public int maxSpeed;
    public int maxLoad;
    public int maxAcceleration;

    public void CreateNotifyArg(
        int floors,
        int maxPower,
        int maxSpeed,
        int maxLoad,
        int maxAcceleration
    ) {
        this.floors = floors;
        this.maxPower = maxPower;
        this.maxSpeed = maxSpeed;
        this.maxLoad = maxLoad;
        this.maxAcceleration = maxAcceleration;
    }

    public void CreateNotifyArg( ) { }
}
