
package ge.mziuri.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    
    private int id;
    private String firstname;
    private String surname;
    private String username;
    private String password;
    private boolean VIPStatus;
    private List<Article> WantToRead = new ArrayList<>(); 
    private List<Article> AlreadyRead = new ArrayList<>(); 
    private List<Article> Favorites = new ArrayList<>(); 
        
    public User() {
    }

    public User(String firstname, String surname, String username, String password, boolean VIPStatus) {
        this.firstname = firstname;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.VIPStatus = VIPStatus;
    }

    public User(String firstname, String lastname, String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstame(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isVIPStatus() {
        return VIPStatus;
    }

    public void setVIPStatus(boolean VIPStatus) {
        this.VIPStatus = VIPStatus;
    }

    public List<Article> getWantToRead() {
        return WantToRead;
    }

    public void setWantToRead(List<Article> WantToRead) {
        this.WantToRead = WantToRead;
    }

    public List<Article> getAlreadyRead() {
        return AlreadyRead;
    }

    public void setAlreadyRead(List<Article> AlreadyRead) {
        this.AlreadyRead = AlreadyRead;
    }

    public List<Article> getFavorites() {
        return Favorites;
    }

    public void setFavorites(List<Article> Favorites) {
        this.Favorites = Favorites;
    }
    
    
    
}
