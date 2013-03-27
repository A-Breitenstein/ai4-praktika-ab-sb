package rn.praktikum1.server.states;

import rn.praktikum1.server.Server;

/**
 * Created with IntelliJ IDEA.
 * User: abg628
 * Date: 27.03.13
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public interface Evaluator {
    void evaluate(Server serverInstance,String input);
}
