/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.fsm;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The StateEngine is the event consumer The event generators are applications
 * or activities
 *
 * @author pascalfares
 */
public class StateEngine implements Runnable {

    State initial;
    State current;
    /**
     * The Event that has been recived by callback or any other method (not
     * defined yet)
     */
    Event recivedEvent = null;

    void engine() {
        //Get next event : push or pop
        //Fire event
        try {
            Event ev = waitAndGetNextEvent();
            current = current.eval(ev);
        } catch (InterruptedException ex) {
            Logger.getLogger(StateEngine.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    synchronized Event waitAndGetNextEvent() throws InterruptedException {
        Event rev;
        while (recivedEvent == null) {
            this.wait();
        }
        //recivedEvent!=null
        rev = recivedEvent;
        recivedEvent = null;
        this.notify();

        //An algorithme or a way to get event from event generator
        //Can be 
        // 1- network event
        // 2- Internal event from states
        // 3- Application event
        // 4- more ...      
        return rev;
    }

    public synchronized void sendEvent(Event ev) throws InterruptedException {
        while (recivedEvent != null) {
            this.wait();
        }
        //recivedEvent==null
        recivedEvent = ev;
        this.notify();

    }

    @Override
    public void run() {
        while (true) {
            engine();
        }
    }
}
