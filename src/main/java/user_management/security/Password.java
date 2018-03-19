package user_management.security;

import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;


public class Password {

    private final static int workload = 12;
    public String hash;

    public Password(String password) {

        this.hash = hashPassword(password);
    }

    public static String hashPassword(String password_plaintext) {
        //random data that is used as an additional input to a one-way function that "hashes" data,
        // a password or passphrase
        String presalt = password_plaintext;
        String hash = BCrypt.hashpw(presalt, BCrypt.gensalt(workload));

        return hash;


    }

    public boolean matches(String password_plaintext) {

        // Note: normally a match method would include a check to see if the hash is valid but for this exam we will
        //       assume that all the passwords we will check are valid. All of the password hashes in the users.json
        //       file are valid so there should be no worry about this as long as you don't overwrite them manually.

        // hashToCheckAgainst = this.hash
        // hasher.check(password, hashToCheckAgainst)

        if(BCrypt.checkpw(password_plaintext, hash)) {
            return true;
        }
            // return true if check is true
            // return false if check is false
        return false;
    }

    public String getHash() {

        return hash;
    }
}
