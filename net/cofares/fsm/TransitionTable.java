package net.cofares.fsm;

import java.util.HashMap;

/**
 * s -> event/action -> s' Table de transition associé à un état donné (attribut
 * de l'état)
 * @author pascalfares
 */
public class TransitionTable {
    /**
     * Table des actions e/a
     */
    HashMap<Event, Action> actions;
    /**
     * Tables des transition e -> s'
     */
    HashMap<Event, State> nextStates;
    
    /**
     * @param e
     * @return 
     */
    public Action getAction(Event e) {
        return actions.get(e);
    }
    /**
     * 
     * @param e
     * @param a 
     */
    public void addAction(Event e, Action a) {
        actions.put(e, a);
    }
    /**
     * 
     * @param e
     * @return 
     */
    public State getNextState(Event e) {
        return nextStates.get(e);
    }
    /**
     * 
     * @param e
     * @param s 
     */
    public void addTransition(Event e, State s) {
        nextStates.put(e,s);
    }
}
