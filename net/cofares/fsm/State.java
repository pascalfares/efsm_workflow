/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.fsm;

/**
 *
 * @author pascalfares
 */
public abstract class State {
    /**
     * id : la référence de l'activité (état)
     */
    String id;
    /**
     * Action à executer en entrant
     */
    abstract void entrant();
    /**
     * Action à executer en sortant
     */
    abstract void sortant();
    /**
     * Table des transitions: état courant -> evenement/action -> prochain état
     */
    TransitionTable t;
    
    /**
     * Réaliser la transition avec l'évenement ev
     * @param ev lévenement recut
     * @return prochain état
     */
    abstract State eval(Event ev);
}
