package rn.helperlein;

/**
 * Created with IntelliJ IDEA.
 * User: abg628
 * Date: 28.03.13
 * Time: 17:43
 * To change this template use File | Settings | File Templates.
 */
public class Log {

    public static void log(String message) {
        System.out.println(Thread.currentThread().getName()+": "+message);
    }
}
