package rn.praktikum1.server.states;

import rn.helperlein.Log;
import rn.praktikum1.server.Command;
import rn.praktikum1.server.Server;
import rn.praktikum1.server.provider.MailProvider;
import rn.praktikum1.server.provider.UserProvider;
import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;

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

            String strCommandIn = input.substring(0, 4);
            String strContentIn = "";

            if (input.length() >= 5) {
                strContentIn = input.substring(5);
            }

            try {
                final Command commandIn = Command.valueOf(strCommandIn);

                switch (commandIn) {
                    case USER: {

                        User user = UserProvider.findUser(strContentIn);

                        if (user != null && serverInstance.getUser() == null) {
                            Log.log("Der "+user.getUsername()+" versucht sich anzumelden");
                            serverInstance.setUser(user);

                            serverInstance.responseOK();

                        } else {
                            Log.log("Der User "+strContentIn+" besitzt kein Mail Konto");
                            serverInstance.responseError();

                        }
                    }
                    break;
                    case PASS: {

                        User user = serverInstance.getUser();
                        Boolean validPassword;

                        if (user != null) {
                            Log.log("Der User"+user.getUsername()+" versucht sich mit dem Passwort: "+strContentIn+" anzumelden");
                            validPassword = UserProvider.login(user,strContentIn);

                            if (validPassword) {
                                Log.log("Der User "+user.getUsername()+" hat sich erfolgreich angemeldet, SERVER wechselt in den Zustand: "+TRANSACTION.name());

                                serverInstance.responseOK();
                                serverInstance.changeServerStateToTRANSACTION();
                            } else {
                                Log.log("Der User "+user.getUsername()+" hat ein falsches Passwort angegeben");
                                serverInstance.responseError();
                            }


                        } else {
                            Log.log("Es wurde zuerst der PASS Befehl gesendet ...");
                            serverInstance.responseError();
                        }

                    }
                    break;
                    case QUIT: {
                        Log.log("Quit befehl erhalten");
                        serverInstance.responseOK();
                        serverInstance.closeSocket();

                    }
                    break;

                    default:{
                        Log.log("Kein zulässiger Befehl im Zustand"+AUTHORIZATION.name());
                        serverInstance.responseError();
                    }

                }
            }catch (IllegalArgumentException iAE){
                Log.log("Unbekannte eingabe: " + strCommandIn);
                serverInstance.responseError();
            }

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

                String strCommandIn = input.substring(0, 4);
                String strContentIn = "";

                if (input.length() >= 5) {
                    strContentIn = input.substring(5);
                }

                try {

                    final Command commandIn = Command.valueOf(input);
                    final User user = serverInstance.getUser();

                    switch (commandIn) {
                        case STAT : {

                            MailProvider.addUsersMailsToUser(user);

                            final int numberOfMailsOfUser = user.getNumberOfMails(),
                                      sumOfMailsize = user.getMessagesSize();

                                final int intParameterArray[] = {numberOfMailsOfUser, sumOfMailsize};

                                //TODO:Log
                                Log.log("inhalt............");
                                serverInstance.responseOK(intParameterArray);

                        } break;
                        case LIST : {
                            if (!strContentIn.isEmpty()) {
                                try {
                                    Integer mailNumber = Integer.valueOf(strContentIn);
                                    //blablabla keine lust mehr schon so spät und kann nicht mehr denken
                                    //bessere lösung für das response überlegen, momentan unschön
                                    Message message = serverInstance.getUser().getMailById(mailNumber);

                                    //TODO:Problem "..." == CRLF : eher nicht, sieht aus wie 3*TerminationOctet
                                    //TODO:Log
                                    Log.log("nochmerh inhalt..............");
                                    serverInstance.responseLIST_MESSAGE_OK(message);

                                } catch (NumberFormatException nFE) {
                                    Log.log("Fehler: Format der Eingabe nicht korrekt: " + input);
                                    serverInstance.responseError();
                                }
                            }else{
                                serverInstance.responseLISTOK(user.getUserMails());
                            }
                        } break;
                        case RETR : {} break;
                        case DELE : {} break;
                        case NOOP : {} break;
                        case RSET : {} break;
                    }
                }catch (IllegalArgumentException iAE){

                    try {
                        final Integer mailNumber = Integer.valueOf(input);

                        Message message = serverInstance.getUser().getMailById(mailNumber);

//                        serverInstance.tellToClient(message);

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
