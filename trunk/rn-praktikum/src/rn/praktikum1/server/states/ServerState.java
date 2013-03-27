package rn.praktikum1.server.states;

import rn.praktikum1.server.Command;
import rn.praktikum1.server.Server;
import rn.praktikum1.server.mails.Message;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public enum ServerState implements ServerStateTransitions,Evaluator{

    //AUTHORIZATION - STATE

    AUTHORIZATION{
        @Override
        public void changeServerStateToAUTHORIZATION(Server serverInstance) {
            serverInstance.setServerState(AUTHORIZATION);
        }

        @Override
        public void changeServerStateToTRANSACTION(Server serverInstance) {
            serverInstance.setServerState(TRANSACTION);
        }

        @Override
        public void changeServerStateToUPDATE(Server serverInstance) {
            serverInstance.setServerState(UPDATE);
        }

        @Override
        public void evaluate(Server serverInstance, String input) {

        }
    },

    //TRANSACTION - State

    TRANSACTION{

        @Override
        public void changeServerStateToAUTHORIZATION(Server serverInstance) {
            serverInstance.setServerState(AUTHORIZATION);
        }

        @Override
        public void changeServerStateToTRANSACTION(Server serverInstance) {
            serverInstance.setServerState(TRANSACTION);
        }

        @Override
        public void changeServerStateToUPDATE(Server serverInstance) {
            serverInstance.setServerState(UPDATE);
        }


        @Override
        public void evaluate(Server serverInstance, String input) {
            {


                try {

                    //TODO:TOP Befehl da dreizeilig durch: "T".equals("T ".replace(" ","")) les- und als Enum erstellbar

                    final Command commandIn = Command.valueOf(input);

                    switch (commandIn) {
                        case STAT : {} break;
                        case LIST : {} break;
                        case RETR : {} break;
                        case DELE : {} break;
                        case NOOP : {} break;
                        case RSET : {} break;
                    }
                }catch (IllegalArgumentException iAE){

                    try {
                        final Integer mailNumber = Integer.valueOf(input);

                        Message message = serverInstance.getUser().getMailById(mailNumber);

                        serverInstance.tellToClient(message);

                    }catch (NumberFormatException nFE){
                        changeServerStateToUPDATE(serverInstance);
                    }
                }



            }
        }
    },

    //UPDATE - State

    UPDATE{
        @Override
        public void changeServerStateToAUTHORIZATION(Server serverInstance) {
            serverInstance.setServerState(AUTHORIZATION);
        }

        @Override
        public void changeServerStateToTRANSACTION(Server serverInstance) {
            serverInstance.setServerState(TRANSACTION);
        }

        @Override
        public void changeServerStateToUPDATE(Server serverInstance) {
            serverInstance.setServerState(UPDATE);
        }

        @Override
        public void evaluate(Server serverInstance, String input) {
            //To change body of implemented methods use File | Settings | File Templates.
        }
    };

}
