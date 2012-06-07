package jliftsim;

import java.util.Observable;

/**
 *
 * @author Bernard Ladenthin (bernard@ladenthin.net)
 * @version 0.1a
 */
public class CreateObservable extends Observable {

    public void predefinedChanged(CreateNotifyArg cna) {
        this.setChanged();
        this.notifyObservers(cna);
    }
}
