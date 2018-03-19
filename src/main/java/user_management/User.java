package user_management;

import user_management.security.Password;

public class User {
    public User user1;


    private int id;
    private String name;
    private String email;
    private Password password;

    //constructor that takes a user_management.security.Password type password
    public User(int id, String name, String email, Password password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;

    }

    //constructor that takes a string password
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        //create new Password object
        this.password = new Password(password);
    }

    public Password getPassword() {
        return this.password;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password= new Password(password);
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    @Override
    public String toString() {

        return name + " - " + email;
    }

    @Override
    public boolean equals(Object obj) {
        user1 = (User) obj;
        //checking an instance. It returns true when the parameter obj is non-null and can be cast to
        // MyClass without raising a ClassCastException
        return User.class.isInstance(obj) && this.password == user1.password && this.email.equals(user1.email)
                && this.id == user1.id;
    }
}

