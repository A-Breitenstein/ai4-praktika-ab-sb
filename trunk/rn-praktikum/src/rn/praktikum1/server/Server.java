package rn.praktikum1.server;

import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.states.ServerState;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public class Server {

    private ServerState serverState;

    private User user;

    public static void main(String[] args) {


        //Exception Testing
//        Integer integer = Integer.valueOf("asd");
//        System.out.println(integer);

//        Command command = Command.valueOf("1");
//        System.out.println(command);
    }

    //----------#Setter|Getter

    public ServerState getServerState() {
        return serverState;
    }

    public void setServerState(ServerState serverState) {
        this.serverState = serverState;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void tellToClient(Message message) {
        //To change body of created methods use File | Settings | File Templates.
    }
}
