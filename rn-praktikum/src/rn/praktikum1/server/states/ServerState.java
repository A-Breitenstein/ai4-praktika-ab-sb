package rn.praktikum1.server.states;

import rn.helperlein.Log;
import rn.praktikum1.server.Command;
import rn.praktikum1.server.Server;
import rn.praktikum1.server.mails.Message;
import rn.praktikum1.server.mails.User;
import rn.praktikum1.server.provider.MailProvider;
import rn.praktikum1.server.provider.UserProvider;

import java.util.ArrayList;
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
                            serverInstance.setUser(user);
                            serverInstance.initLogger();

                            serverInstance.getLogger().info("Der " + user.getUsername() + " versucht sich anzumelden");

                            Log.log("Der " + user.getUsername() + " versucht sich anzumelden");

                            serverInstance.responseOK();

                        } else {
                            serverInstance.getLogger().error("Der User "+strContentIn+" besitzt kein Mail Konto");
                            Log.log("Der User "+strContentIn+" besitzt kein Mail Konto");
                            serverInstance.responseError();

                        }
                    }
                    break;
                    case PASS: {

                        User user = serverInstance.getUser();
                        Boolean validPassword;

                        if (user != null) {
                            serverInstance.getLogger().info("Der User"+user.getUsername()+" versucht sich mit dem Passwort: "+strContentIn+" anzumelden");
                            Log.log("Der User"+user.getUsername()+" versucht sich mit dem Passwort: "+strContentIn+" anzumelden");
                            validPassword = UserProvider.login(user,strContentIn);

                            if (validPassword) {
                                serverInstance.getLogger().debug("Der User "+user.getUsername()+" hat sich erfolgreich angemeldet, SERVER wechselt in den Zustand: "+TRANSACTION.name());
                                Log.log("Der User "+user.getUsername()+" hat sich erfolgreich angemeldet, SERVER wechselt in den Zustand: "+TRANSACTION.name());

                                serverInstance.responseOK();
                                serverInstance.changeServerStateToTRANSACTION();
                            } else {
                                serverInstance.getLogger().warn("Der User "+user.getUsername()+" hat ein falsches Passwort angegeben");
                                Log.log("Der User "+user.getUsername()+" hat ein falsches Passwort angegeben");
                                serverInstance.responseError();
                            }


                        } else {
                            serverInstance.getLogger().debug("Es wurde zuerst der PASS Befehl gesendet ...");
                            Log.log("Es wurde zuerst der PASS Befehl gesendet ...");
                            serverInstance.responseError();
                        }

                    }
                    break;
                    case QUIT: {
                        serverInstance.getLogger().info("Quit befehl erhalten");
                        Log.log("Quit befehl erhalten");
                        serverInstance.responseOK();
                        serverInstance.closeSocket();

                    }
                    break;

                    default:{
//                        serverInstance.getLogger().debug("Kein zulässiger Befehl '" + strCommandIn + "' im Zustand "+AUTHORIZATION.name());
                        Log.log("Kein zulässiger Befehl '" + strCommandIn + "' im Zustand "+AUTHORIZATION.name());
                        serverInstance.responseError();
                    }

                }
            }catch (IllegalArgumentException iAE){
//                serverInstance.getLogger().warn("Unbekannte eingabe: " + strCommandIn);
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

                                serverInstance.getLogger().info("STAT für User " +user.getUsername()+ " mit "+numberOfMailsOfUser+" emails, insgesamt " +sumOfMailsize+ " Zeichen");
                                Log.log("STAT für User " +user.getUsername()+ " mit "+numberOfMailsOfUser+" emails, insgesamt " +sumOfMailsize+ " Zeichen");
                                serverInstance.responseOK(intParameterArray);

                        } break;

                        case LIST : {
                            if (!strContentIn.isEmpty()) {
                                try {
                                    int mailNumber = Integer.valueOf(strContentIn).intValue();

                                    if (mailNumber < 0 && mailNumber > user.getNumberOfMails()) {

                                        serverInstance.getLogger().error("Der vom User " +user.getUsername()+ " gewählte index liegt ausserhalb des bereiches der vorhandenen Nachrichten");
                                        Log.log("Der vom User " +user.getUsername()+ " gewählte index liegt ausserhalb des bereiches der vorhandenen Nachrichten");
                                        serverInstance.responseError();

                                    } else {

                                        Message message = serverInstance.getUser().getMailById(mailNumber);

                                        serverInstance.getLogger().info("User "+user.getUsername()+" ruft Mail mit index "+mailNumber+" ab");
                                        Log.log("User "+user.getUsername()+" ruft Mail mit index "+mailNumber+" ab");
                                        serverInstance.responseLIST_MESSAGE_OK(mailNumber,message);
                                    }


                                } catch (NumberFormatException nFE) {
                                    serverInstance.getLogger().warn("Fehler: Format der Eingabe nicht korrekt: " + input);
                                    Log.log("Fehler: Format der Eingabe nicht korrekt: " + input);
                                    serverInstance.responseError();
                                }
                            }else{
                                serverInstance.getLogger().info("LIST wurde ohne Parameter gesendet");
                                serverInstance.responseOK();
                                serverInstance.responseLISTOK(user.getUserMails());
                            }
                        } break;

                        case RETR : {

                            int mailId = Integer.valueOf(strContentIn).intValue();

                            serverInstance.getLogger().info("RETR wurde gesendet, mit id: " +mailId);
                            serverInstance.responseOK();
                            serverInstance.responseRETR(mailId);
                        } break;
                        case DELE : {

                        if (!strContentIn.isEmpty()) {
                            try {
                                int mailNumber = Integer.valueOf(strContentIn).intValue();
                                
                                if (mailNumber < 0 && mailNumber > user.getNumberOfMails()) {

                                    serverInstance.getLogger().error("Der vom User " +user.getUsername()+ " gewählte index liegt ausserhalb des bereiches der vorhandenen Nachrichten");
                                    Log.log("Der vom User " +user.getUsername()+ " gewählte index liegt ausserhalb des bereiches der vorhandenen Nachrichten");
                                    serverInstance.responseError();

                                } else {
                                    
                                    user.setDelete(true);
                                    
                                    Message message = serverInstance.getUser().getMailById(mailNumber);

                                    message.setInvalid();

                                    serverInstance.getLogger().info("User "+user.getUsername()+" setzt Mail mit index "+mailNumber+" auf gelöscht");
                                    Log.log("User "+user.getUsername()+" setzt Mail mit index "+mailNumber+" auf gelöscht");
                                    serverInstance.responseLIST_MESSAGE_OK(mailNumber,message);
                                }


                            } catch (NumberFormatException nFE) {
                                serverInstance.getLogger().warn("Fehler: Format der Eingabe nicht korrekt: " + input);
                                Log.log("Fehler: Format der Eingabe nicht korrekt: " + input);
                                serverInstance.responseError();
                            }
                        }else{
                            serverInstance.getLogger().error("DELE hat keinen parameter: " +input);
                            Log.log("DELE hat keinen parameter: " +input);
                            serverInstance.responseError();
                        }
                            
                        } break;
                        case NOOP : {
                            serverInstance.getLogger().info("NOOP Befehl erhalten, antworte mit +OK");
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

                                        serverInstance.getLogger().info("Message mit Id "+message.getId()+" wiederhergestellt");
                                        Log.log("Message mit Id "+message.getId()+" wiederhergestellt");

                                        restoredMessages++;
                                    }
                                }

                                serverInstance.getLogger().info("User "+ user.getUsername() + " hat " + restoredMessages + " Nachrichten wiederhergestellt");
                                Log.log("User "+ user.getUsername() + " hat " + restoredMessages + " Nachrichten wiederhergestellt");

                            }else {
                                serverInstance.getLogger().info("User " + user.getUsername() + " versucht Nachrichten wiederherzustellen, keine gelöschten vorhanden");
                                Log.log("User " + user.getUsername() + " versucht Nachrichten wiederherzustellen, keine gelöschten vorhanden");
                                serverInstance.responseError();
                            }

                        } break;
                        case UIDL : {


                            serverInstance.getLogger().info("Hash's für Nachrichten von User "+user.getUsername()+" werden erstellt und gesendet");
                            Log.log("Hash's für Nachrichten von User "+user.getUsername()+" werden erstellt und gesendet");

                            if (user.getUserMails() == null) {
                                MailProvider.addMessagesToUser(user);
                            }

                            serverInstance.responseOK();

                            List<Message> usermails = new ArrayList<Message>();


                                if (!strContentIn.isEmpty()) {
                                    int index = Integer.valueOf(strContentIn).intValue()-1;
                                    if (index < 0 && index > user.getNumberOfMails())
                                        usermails.add(user.getUserMails().get(index));

                                }else{
                                    usermails = user.getUserMails();
                                }

                                serverInstance.responseUIDL(usermails);


                        } break;

                        case QUIT: {

                            serverInstance.getLogger().debug("User " + user.getUsername() + " hat den QUIT Befehl gesendet, SERVER wechselt in den Zustand: " + UPDATE.name());
                            Log.log("User " + user.getUsername() + " hat den QUIT Befehl gesendet, SERVER wechselt in den Zustand: " + UPDATE.name());

                            serverInstance.changeServerStateToUPDATE();
                        } break;


                        default:{
                            serverInstance.getLogger().error("Kein zulässiger Befehl '" + strCommandIn + "' im Zustand "+TRANSACTION.name());
                            Log.log("Kein zulässiger Befehl '" + strCommandIn + "' im Zustand "+TRANSACTION.name());
                            serverInstance.responseError();
                        }
                    }
                }catch (IllegalArgumentException iAE){
                    serverInstance.getLogger().warn("Unbekannte eingabe: " + strCommandIn);
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
                        serverInstance.getLogger().info("Lösche Nachricht " + message.getId() + " permanent");
                        Log.log("Lösche Nachricht " + message.getId() + " permanent");
                        MailProvider.deleteMailById(message);
                    }
                }

            }


            serverInstance.getLogger().debug("SERVER beendet Verbindung");
            Log.log("SERVER beendet Verbindung");

            serverInstance.responseOK();
            serverInstance.closeSocket();

        }
    };

}
