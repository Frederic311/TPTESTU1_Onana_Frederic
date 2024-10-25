import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.stjean.operation.OperationMathematique;
import com.stjean.operation.User;

public class TestOperationMathematique {

    @Test
    public void testAddUser_ValidEmail() {
        User user = new User(1, "John Doe", 30, "johndoe@example.com", "1234567890", "City A", 1000.0);
        OperationMathematique.addUser(user);
        Assertions.assertEquals(1, OperationMathematique.getUsers().size());
    }

    @Test
    public void testAddUser_InvalidEmail() {
        User user = new User(1, "John Doe", 30, "invalid_email", "1234567890", "City A", 1000.0);
        Assertions.assertThrows(EmailInvalidException.class, () -> OperationMathematique.addUser(user));
    }

    @Test
    public void testDeleteUser_ExistingUser() {
        User user = new User(1, "John Doe", 30, "johndoe@example.com", "1234567890", "City A", 1000.0);
        OperationMathematique.addUser(user);
        OperationMathematique.deleteUser(1);
        Assertions.assertEquals(0, OperationMathematique.getUsers().size());
    }

    @Test
    public void testDeleteUser_NonexistentUser() {
        Assertions.assertThrows(DeletionInvalidException.class, () -> OperationMathematique.deleteUser(1));
    }

    @Test
    public void testListUsers() {
        User user1 = new User(1, "John Doe", 30, "johndoe@example.com", "1234567890", "City A", 1000.0);
        User user2 = new User(2, "Jane Smith", 25, "janesmith@example.com", "9876543210", "City B", 2000.0);
        OperationMathematique.addUser(user1);
        OperationMathematique.addUser(user2);
        ArrayList<User> users = OperationMathematique.listUsers();
        Assertions.assertEquals(2, users.size());
        Assertions.assertEquals(user1, users.get(0));
        Assertions.assertEquals(user2, users.get(1));
    }

    @Test
    public void testDisplayUser_ExistingUser() {
        User user = new User(1, "John Doe", 30, "johndoe@example.com", "1234567890", "City A", 1000.0);
        OperationMathematique.addUser(user);
        User displayedUser = OperationMathematique.displayUser(1);
        Assertions.assertEquals(user, displayedUser);
    }

    @Test
    public void testDisplayUser_NonexistentUser() {
        Assertions.assertThrows(DeletionInvalidException.class, () -> OperationMathematique.displayUser(1));
    }

    @Test
    public void testAnalyseSoldeGeneral_PositiveBalance() {
        User user1 = new User(1, "John Doe", 30, "johndoe@example.com", "1234567890", "City A", 1000.0);
        User user2 = new User(2, "Jane Smith", 25, "janesmith@example.com", "9876543210", "City B", 2000.0);
        OperationMathematique.addUser(user1);
        OperationMathematique.addUser(user2);
        double totalBalance = OperationMathematique.analyseSoldeGeneral();
        Assertions.assertEquals(3000.0, totalBalance);
    }

    @Test
    public void testAnalyseSoldeGeneral_NegativeBalance() {
        User user1 = new User(1, "John Doe", 30, "johndoe@example.com", "1234567890", "City A", -500.0);
        OperationMathematique.addUser(user1);
        Assertions.assertThrows(NegativeGeneralBalanceException.class, () -> OperationMathematique.analyseSoldeGeneral());
    }

    @Test
    public void testGetRichestUser() {
        User user1 = new User(1, "John Doe", 30, "johndoe@example.com", "1234567890", "City A", 1000.0);
        User user2 = new User(2, "Jane Smith", 25, "janesmith@example.com", "9876543210", "City B", 2000.0);
        OperationMathematique.addUser(user1);
        OperationMathematique.addUser(user2);
        User richestUser = OperationMathematique.getRichestUser();
        Assertions.assertEquals(user2, richestUser);
    }
}