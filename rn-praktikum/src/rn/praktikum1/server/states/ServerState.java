package rn.praktikum1.server.states;

import rn.helperlein.Log;
import rn.praktikum1.server.Command;
import rn.praktikum1.server.Server;
import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.provider.MailProvider;
import rn.praktikum1.server.provider.UserProvider;

import java.util.List;

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

                        User user = UserProvider.getUserByUsername(strContentIn);

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
                        Log.log("Kein zulässiger Befehl '" + strCommandIn + "' im Zustand "+AUTHORIZATION.name());
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

                    final Command commandIn = Command.valueOf(strCommandIn);
                    final User user = serverInstance.getUser();

                    switch (commandIn) {
                        case STAT : {

                            MailProvider.addMessagesToUser(user);

                            final int numberOfMailsOfUser = user.getNumberOfMails(),
                                      sumOfMailsize = user.getMessagesSize();

                                final int intParameterArray[] = {numberOfMailsOfUser, sumOfMailsize};

                                Log.log("STAT für User " +user.getUsername()+ " mit "+numberOfMailsOfUser+" emails, insgesamt " +sumOfMailsize+ " Zeichen");
                                serverInstance.responseOK(intParameterArray);

                        } break;

                        case LIST : {
                            if (!strContentIn.isEmpty()) {
                                try {
                                    int mailNumber = Integer.valueOf(strContentIn).intValue();

                                    if (mailNumber < 0 && mailNumber > user.getNumberOfMails()) {

                                        Log.log("Der vom User " +user.getUsername()+ " gewählte index liegt ausserhalb des bereiches der vorhandenen Nachrichten");
                                        serverInstance.responseError();

                                    } else {

                                        Message message = serverInstance.getUser().getMailById(mailNumber);

                                        Log.log("User "+user.getUsername()+" ruft Mail mit index "+mailNumber+" ab");
                                        serverInstance.responseLIST_MESSAGE_OK(mailNumber,message);
                                    }


                                } catch (NumberFormatException nFE) {
                                    Log.log("Fehler: Format der Eingabe nicht korrekt: " + input);
                                    serverInstance.responseError();
                                }
                            }else{
                                serverInstance.responseOK();
                                serverInstance.responseLISTOK(user.getUserMails());
                            }
                        } break;

                        case RETR : {

                            int mailId = Integer.valueOf(strContentIn).intValue();

                            serverInstance.responseOK();
                            serverInstance.responseRETR(mailId);
                        } break;
                        case DELE : {

                        if (!strContentIn.isEmpty()) {
                            try {
                                int mailNumber = Integer.valueOf(strContentIn).intValue();
                                
                                if (mailNumber < 0 && mailNumber > user.getNumberOfMails()) {

                                    Log.log("Der vom User " +user.getUsername()+ " gewählte index liegt ausserhalb des bereiches der vorhandenen Nachrichten");
                                    serverInstance.responseError();

                                } else {
                                    
                                    user.setDelete(true);
                                    
                                    Message message = serverInstance.getUser().getMailById(mailNumber);

                                    message.setInvalid();
                                    
                                    Log.log("User "+user.getUsername()+" setzt Mail mit index "+mailNumber+" auf gelöscht");
                                    serverInstance.responseLIST_MESSAGE_OK(mailNumber,message);
                                }


                            } catch (NumberFormatException nFE) {
                                Log.log("Fehler: Format der Eingabe nicht korrekt: " + input);
                                serverInstance.responseError();
                            }
                        }else{
                            Log.log("DELE hat keinen parameter: " +input);
                            serverInstance.responseError();
                        }
                            
                        } break;
                        case NOOP : {
                            Log.log("NOOP Befehl erhalten, antworte mit +OK");
                            serverInstance.responseOK();
                        } break;
                        case RSET : {

                            if (user.isDelete()) {

                                List<Message> messageList = user.getUserMails();

                                int restoredMessages = 0;

                                for (int i = 0; i < messageList.size(); i++) {

                                    Message message = messageList.get(i);

                                    if (!message.isValid()) {

                                        message.setValid();

                                        Log.log("Message mit Id "+message.getId()+" wiederhergestellt");

                                        restoredMessages++;
                                    }
                                }

                                Log.log("User "+ user.getUsername() + " hat " + restoredMessages + " Nachrichten wiederhergestellt");

                            }else {
                                Log.log("User " + user.getUsername() + " versucht Nachrichten wiederherzustellen, keine gelöschten vorhanden");
                                serverInstance.responseError();
                            }

                        } break;
                        case UIDL : {

                            Log.log("Hash's für Nachrichten von User "+user.getUsername()+" werden erstellt und gesendet");

                            serverInstance.responseOK();
                            serverInstance.responseUIDL(user.getUserMails());
                        } break;

                        case QUIT: {

                            Log.log("User "+ user.getUsername() + " hat den QUIT Befehl gesendet, SERVER wechselt in den Zustand: "+UPDATE.name());

                            serverInstance.changeServerStateToUPDATE();
                        } break;


                        default:{
                            Log.log("Kein zulässiger Befehl '" + strCommandIn + "' im Zustand "+TRANSACTION.name());
                            serverInstance.responseError();
                        }
                    }
                }catch (IllegalArgumentException iAE){
                    Log.log("Unbekannte eingabe: " + strCommandIn);
                    serverInstance.responseError();
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

            User user = serverInstance.getUser();

            if (user.isDelete()) {

                List<Message> messages = user.getUserMails();

                for (Message message : messages) {
                    if (!message.isValid()) {
                        Log.log("Lösche Nachricht " + message.getId() + " permanent");
                        MailProvider.deleteMailById(message);
                    }
                }

            }


            Log.log("SERVER beendet Verbindung");

            serverInstance.responseOK();
            serverInstance.closeSocket();

        }
    };

}
