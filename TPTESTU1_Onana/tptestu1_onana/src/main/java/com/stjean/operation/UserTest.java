package com.stjean.operation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
@Test
void testAddUser() {
    User user = new User(1, "test@example.com", 100.0);
    User.addUser(user);
    assertTrue(User.listUsers().contains(user));
}


}
