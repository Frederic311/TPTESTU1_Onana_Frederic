package com.stjean.operation;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private int id;
    private String name;
    private int age;
    private String email;
    private String phone;
    private String city;
    private double balancePersonnel;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getBalancePersonnel() {
        return balancePersonnel;
    }

    public void setBalancePersonnel(double balancePersonnel) {
        this.balancePersonnel = balancePersonnel;
    }

    public User(int id, String name, int age, String email, String phone, String city, double balancePersonnel) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.balancePersonnel = balancePersonnel;
    }

    private static final ArrayList<User> users = new ArrayList<>();

    public static void addUser(User user) throws EmailInvalidException {
        validateEmail(user.getEmail());
        users.add(user);
    }

    private static void validateEmail(String email) throws EmailInvalidException {
        String emailRegex = "^[\\w!#$%&'*+/=?^`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new EmailInvalidException("Invalid email format.");
        }
    }

    public static void deleteUser(int id) throws DeletionInvalidException {
        int index = findUserIndex(id);
        if (index == -1) {
            throw new DeletionInvalidException("User with ID " + id + " not found.");
        }
        users.remove(index);
    }

    private static int findUserIndex(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<User> listUsers() {

        return new ArrayList<>(users);
    }

    public static User displayUser(int id) throws DeletionInvalidException {
        int index = findUserIndex(id);
        if (index == -1) {
            throw new DeletionInvalidException("User with ID " + id + " not found.");
        }
        return users.get(index);
    }

    public static class EmailInvalidException extends Exception {
        public EmailInvalidException(String message) {
            super(message);
        }
    }

    public static class DeletionInvalidException extends Exception {
        public DeletionInvalidException(String message) {
            super(message);
        }
    }

    public static double analyseSoldeGeneral() throws NegativeGeneralBalanceException {
        double totalBalance = 0;

        for (User user : users) {
            totalBalance += user.getBalancePersonnel();
        }

        if (totalBalance < 0) {
            throw new NegativeGeneralBalanceException("Negative general balance detected.");
        }

        return totalBalance;
    }

    public static User getRichestUser() {
        if (users.isEmpty()) {
            return null;
        }

        User richestUser = users.get(0);
        for (int i = 1; i < users.size(); i++) {
            if (users.get(i).getBalancePersonnel() > richestUser.getBalancePersonnel()) {
                richestUser = users.get(i);
            }
        }

        return richestUser;
    }

    public static class NegativeGeneralBalanceException extends Exception {
        public NegativeGeneralBalanceException(String message) {
            super(message);
        }
    }

}