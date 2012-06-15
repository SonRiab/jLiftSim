package jliftsim;

import java.util.Observable;
import jliftsim.data.EngineData;
import jliftsim.data.FloorData;
import jliftsim.data.NameData;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class CreateObservable extends Observable {

    public void engineChanged(EngineData ed) {
        this.setChanged();
        this.notifyObservers(ed);
        this.clearChanged();
    }

    public void floorChanged(FloorData fd) {
        this.setChanged();
        this.notifyObservers(fd);
        this.clearChanged();
    }

    public void nameChanged(NameData nd) {
        this.setChanged();
        this.notifyObservers(nd);
        this.clearChanged();
    }
}
