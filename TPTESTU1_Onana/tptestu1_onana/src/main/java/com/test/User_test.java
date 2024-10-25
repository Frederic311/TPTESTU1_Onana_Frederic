package com.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class User_test {

    @Test
    public void testAddUser() throws EmailInvalidException {

        User user = new User("John Doe", "johndoe@example.com", 1000.0);


        UserManagement.addUser(user);
        assertEquals(1, UserManagement.listUsers().size());
        assertEquals(user, UserManagement.listUsers().get(0));


        assertThrows(EmailInvalidException.class, () -> UserManagement.addUser(new User("Jane Smith", "invalid_email", 2000.0)));
    }

    @Test
    public void testDeleteUser() throws DeletionInvalidException {

        User user1 = new User("John Doe", "johndoe@example.com", 1000.0);
        User user2 = new User("Jane Smith", "janesmith@example.com", 2000.0);
        UserManagement.addUser(user1);
        UserManagement.addUser(user2);


        UserManagement.deleteUser(user1.getId());
        assertEquals(1, UserManagement.listUsers().size());
        assertEquals(user2, UserManagement.listUsers().get(0));


        assertThrows(DeletionInvalidException.class, () -> UserManagement.deleteUser(999));
    }

    @Test
    public void testListUsers() {

        User user1 = new User("John Doe", "johndoe@example.com", 1000.0);
        User user2 = new User("Jane Smith", "janesmith@example.com", 2000.0);
        User user3 = new User("Alice Johnson", "alicejohnson@example.com", 3000.0);
        UserManagement.addUser(user1);
        UserManagement.addUser(user2);
        UserManagement.addUser(user3);


        ArrayList<User> users = UserManagement.listUsers();
        assertEquals(3, users.size());
        assertTrue(users.contains(user1));
        assertTrue(users.contains(user2));
        assertTrue(users.contains(user3));
    }

    @Test
    public void testDisplayUser() throws DeletionInvalidException {

        User user = new User("John Doe", "johndoe@example.com", 1000.0);
        UserManagement.addUser(user);


        User displayedUser = UserManagement.displayUser(user.getId());
        assertEquals(user, displayedUser);


        assertThrows(DeletionInvalidException.class, () -> UserManagement.displayUser(999));
    }

    @Test
    public void testAnalyseSoldeGeneral() throws NegativeGeneralBalanceException {

        User user1 = new User("John Doe", "johndoe@example.com", 1000.0);
        User user2 = new User("Jane Smith", "janesmith@example.com", -500.0);
        UserManagement.addUser(user1);
        UserManagement.addUser(user2);


        double totalBalance = UserManagement.analyseSoldeGeneral();
        assertEquals(500.0, totalBalance);

        user2.setBalancePersonnel(-1500.0);
        assertThrows(NegativeGeneralBalanceException.class, () -> UserManagement.analyseSoldeGeneral());
    }

    @Test
    public void testGetRichestUser() {

        User user1 = new User("John Doe", "johndoe@example.com", 1000.0);
        User user2 = new User("Jane Smith", "janesmith@example.com", 2000.0);
        User user3 = new User("Alice Johnson", "alicejohnson@example.com", 3000.0);
        UserManagement.addUser(user1);
        UserManagement.addUser(user2);
        UserManagement.addUser(user3);


        User richestUser = UserManagement.getRichestUser();
        assertEquals(user3, richestUser);

        UserManagement.deleteUser(user1.getId());
        UserManagement.deleteUser(user2.getId());
        UserManagement.deleteUser(user3.getId());
        assertNull(UserManagement.getRichestUser());
    }
}
