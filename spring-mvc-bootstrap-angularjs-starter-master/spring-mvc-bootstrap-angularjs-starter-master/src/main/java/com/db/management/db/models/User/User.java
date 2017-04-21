package com.db.management.db.models.User;


/**
 * Created by Admin on 10/04/2017.
 */
public class User {

    User(String name, String surname, String email, String password)
    {
        //this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        byte[] salt = PasswordResolver.getNextSalt();
        this.passwordHash = PasswordResolver.hash(password.toCharArray(), salt).toString();
    }
    User(String name, String surname, String email)
    {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }


    private int id;
    public int getId(){return this.id;}

    public String name;
    public String surname;
    public String email;
    private String passwordHash;
    public String getPasswordHash(){return this.passwordHash;}

    private String passwordSalt;
    public String getPasswordSalt(){return  this.passwordSalt;}


}
