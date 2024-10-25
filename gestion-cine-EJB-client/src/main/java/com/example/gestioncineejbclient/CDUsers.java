package com.example.gestioncineejbclient;

import javax.annotation.ManagedBean;
import javax.ejb.Remote;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;
@Named
@RequestScoped
@Remote
public interface CDUsers {

    public List<CD> listAvailableCDs();
    public List<CD> listBorrowedCDs(Long userId);
    public void borrowCD(Long userId, Long cdId);
    public void returnCD(Long cdId);

}