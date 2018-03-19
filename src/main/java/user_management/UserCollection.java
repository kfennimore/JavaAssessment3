package user_management;

import user_management.security.UserAuthenticationFailedException;
import user_management.validation.EmailNotAvailableException;
import user_management.validation.InvalidEmailException;
import user_management.validation.PasswordTooSimpleException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCollection extends ArrayList<User> {

    public User findById(int id) {

        Iterator findID= iterator();

        //while there are more items in the array...go to the next one
        while (findID.hasNext()) {
            //cast this to user
            User user = (User) findID.next();
            //if the id matches the arguments id then return that user
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User findByEmail(String email) {

        Iterator findEmail= iterator();

        //while there are more items in the array...go to the next one
        while (findEmail.hasNext()) {
            //cast this to user
            User user = (User) findEmail.next();
            //if the email matches the arguments email then return that element
            //Im not sure if equalsIgnoreCase would be good here
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    public User attemptLogin(String email, String password) throws UserAuthenticationFailedException {
        User emailUser = findByEmail(email);

        //throw exception if the user doesnt exist or the password DOES NOT EQUAL (its failing if I put a ! before the
        //or statement...this doesnt make any sense!!!!
        if (emailUser.getEmail() == null || !emailUser.getPassword().matches(password)) {
            throw new UserAuthenticationFailedException();
        }
        return emailUser;
    }

    //Valid REGEX email address
    public static final Pattern ValidEmailRegex =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static boolean validate(String emailStr) {
        Matcher matcher = ValidEmailRegex.matcher(emailStr);
        return matcher.find();
    }

    //Valid Regex Password
    public static final Pattern ValidPasswordRegex =
            Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}");

    public static boolean validatePassword(String password) {
        Matcher matcher = ValidPasswordRegex.matcher(password);
        return matcher.find();
    }


    public int createUser(String name, String email, String password) throws EmailNotAvailableException, InvalidEmailException, PasswordTooSimpleException {
        int currentId = 0;
        User user;

        do {
            currentId++;
            user = findById(currentId);
        } while (!(user == null));
        
        user = new User(currentId, name, email, password);


        //if the email does not pass the Regex validate method throw exception
        if (!validate(email)) {
            throw new InvalidEmailException();
        }

        //If the password does not pass the Regex password method throw exception
        if (!validatePassword(password)) {
            throw new PasswordTooSimpleException();
        }

        //If the email is already being used...throw the exception
        if (findByEmail(email) != null) {
            throw new EmailNotAvailableException();
        }


        this.add(user);

        return user.getId();
    }


}

