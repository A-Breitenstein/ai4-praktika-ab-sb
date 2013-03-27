package rn.praktikum1.server.states;

import rn.praktikum1.server.Server;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 09:09
 */
public interface ServerStateTransitions {

    /**
     * Wechselt den Zustand des Automaten der Übergeben wird in AUTHORIZATION
     *
     * @param serverInstant instant of a Running Server
     */
    public void changeServerStateToAUTHORIZATION(Server serverInstant);

    /**
     * Wechselt den Zustand des Automaten der Übergeben wird in TRANSACTION
     *
     * @param serverInstant instant of a Running Server
     */
    public void changeServerStateToTRANSACTION(Server serverInstant);

    /**
     * Wechselt den Zustand des Automaten der Übergeben wird in UPDATE
     *
     * @param serverInstant instant of a Running Server
     */
    public void changeServerStateToUPDATE(Server serverInstant);
}
