/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.fsm;

import java.util.HashMap;

/**
 * s -> event/action -> s' Table de transition associé à un état donné (attribut
 * de l'état)
 * @author pascalfares
 */
class TransitionTable {
    /**
     * Table des actions e/a
     */
    HashMap<Event, Action> actions;
    /**
     * Tables des transition e -> s'
     */
    HashMap<Event, State> nextStates;
    
    public Action getAction(Event e) {
        return actions.get(e);
    }
    public void addAction(Event e, Action a) {
        actions.put(e, a);
    }
    
    public State getNextState(Event e) {
        return nextStates.get(e);
    }
    
    public void addTransition(Event e, State s) {
        nextStates.put(e,s);
    }
}
