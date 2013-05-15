/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.cofares.fsm;

import java.util.HashMap;

/**
 *
 * @author pascalfares
 */
class TransitionTable {
    HashMap<Event, Action> actions;
    HashMap<Event, State> nextStates;
    
}
