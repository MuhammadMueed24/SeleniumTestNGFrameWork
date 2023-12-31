package Util;

import java.util.Random;

public class RandomEmailPasswordGenerator {

    // Method to generate a random email address
    public String generateRandomEmail() {
        // List of common email domains
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com"};
        String[] characters = "abcdefghijklmnopqrstuvwxyz1234567890".split("");

        StringBuilder email = new StringBuilder();
        Random random = new Random();

        // Generate a random username of 10 characters
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(characters.length);
            email.append(characters[randomIndex]);
        }

        // Add "@" symbol
        email.append("@");

        // Choose a random domain from the list
        int randomDomainIndex = random.nextInt(domains.length);
        email.append(domains[randomDomainIndex]);

        return email.toString();
    }

    // Method to generate a random password of a given length
    public String generateRandomPassword(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }

}