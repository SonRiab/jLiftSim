package jliftsim;

import java.util.Observable;
import jliftsim.data.CreateFrameData;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class CreateObservable extends Observable {

    public void predefinedChanged(CreateFrameData cna) {
        this.setChanged();
        this.notifyObservers(cna);
    }
}
