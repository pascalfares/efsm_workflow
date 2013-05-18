package net.cofares.fsm;

/**
 *
 * @author pascalfares
 */
public class State {
    /**
     * id : la référence de l'activité (état)
     */
    String id;
    /**
     * Action à executer en entrant
     */
    //abstract void entrant();
    /**
     * Action à executer en sortant
     */
    //abstract void sortant();
    /**
     * Table des transitions: état courant -> evenement/action -> prochain état
     */
    TransitionTable t;
    
    /**
     * Réaliser la transition avec l'évenement ev
     * @param ev lévenement recut
     * @return prochain état
     */
    State eval(Event ev) {
        Action a = t.getAction(ev);
        //Executer action a
        //Si reussite changer d'état sinon anomalie?
        return t.getNextState(ev);
    }
    
    public void addTransition(Event ev, Action a, State ns) {
        t.addAction(ev, a);
        t.addTransition(ev, ns);
    }
}
