package com.example.gestioncineejbclient;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

public class CDController {
    @EJB
    private CDUsers cd;

    private Long userId; // Id de l'utilisateur en cours (simulation)
    private Long cdId;   // Id du CD sélectionné pour emprunt/retour

    public CDController() {
        try {
            InitialContext ctx = new InitialContext();
            cd = (CDUsers) ctx.lookup("ejb:/gestion-cine-EJB-server/CDUsersImpl!org.example.CDUsers");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public List<CD> getAvailableCDs() {
        return cd.listAvailableCDs();
    }

    public List<CD> getBorrowedCDs() {
        return cd.listBorrowedCDs(userId);
    }

    public void borrowCD() {
        cd.borrowCD(userId, cdId);
    }

    public void returnCD() {
        cd.returnCD(cdId);
    }
}
