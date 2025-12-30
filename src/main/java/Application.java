import records.UserRecords;
import records.User;

public class Application {

    public static void main(String[] args) {
        UserRecords userRecords = new UserRecords("amy", 19);

        System.out.println(userRecords.toString());

        System.out.println(userRecords.age());

        User user = new User("alpha", 10);

        System.out.println(user);

        UserRecords uRecords = new UserRecords(null, 0);
        System.out.println(uRecords);

    }

}
