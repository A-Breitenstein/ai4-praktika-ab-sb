package rn.praktikum1.server;

/**
 * User: Alex
 * Date: 26.03.13
 * Time: 09:51
 */
public enum Command {

    //SERVER

    QUIT,
    STAT,
    LIST,
    RETR,
    DELE,
    NOOP,
    RSET,

    //Optional

    TOP,
    UIDL,
    USER,
    PASS,
    APOP,

    //CLIENT only

    LOGO,
    CNFG

}
