package rn.praktikum1.server.states;

import rn.praktikum1.server.Command;
import rn.praktikum1.server.Server;
import rn.praktikum1.server.mails.Message;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 07:41
 */
public enum ServerState implements ServerStateTransitions{

    //AUTHORIZATION - STATE

    AUTHORIZATION{
        @Override
        public void changeServerStateToAUTHORIZATION(Server serverInstant) {
            serverInstant.setServerState(AUTHORIZATION);
        }

        @Override
        public void changeServerStateToTRANSACTION(Server serverInstant) {
            serverInstant.setServerState(TRANSACTION);
        }

        @Override
        public void changeServerStateToUPDATE(Server serverInstant) {
            serverInstant.setServerState(UPDATE);
        }
    },

    //TRANSACTION - State

    TRANSACTION{

        public void commandIn(Server serverInstant, String input) {


            try {
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

                    Message message = serverInstant.getUser().getMailById(mailNumber);

                    serverInstant.tellToClient(message);

                }catch (NumberFormatException nFE){
                    changeServerStateToUPDATE(serverInstant);
                }
            }



        }


        @Override
        public void changeServerStateToAUTHORIZATION(Server serverInstant) {
            serverInstant.setServerState(AUTHORIZATION);
        }

        @Override
        public void changeServerStateToTRANSACTION(Server serverInstant) {
            serverInstant.setServerState(TRANSACTION);
        }

        @Override
        public void changeServerStateToUPDATE(Server serverInstant) {
            serverInstant.setServerState(UPDATE);
        }
    },

    //UPDATE - State

    UPDATE{
        @Override
        public void changeServerStateToAUTHORIZATION(Server serverInstant) {
            serverInstant.setServerState(AUTHORIZATION);
        }

        @Override
        public void changeServerStateToTRANSACTION(Server serverInstant) {
            serverInstant.setServerState(TRANSACTION);
        }

        @Override
        public void changeServerStateToUPDATE(Server serverInstant) {
            serverInstant.setServerState(UPDATE);
        }
    };

}
