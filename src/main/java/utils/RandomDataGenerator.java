package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.logging.Logger;
import com.github.javafaker.Faker;

public class RandomDataGenerator {
    private static final Faker FAKER = new Faker();
    private static final Logger LOGGER = AqualityServices.getLogger();
    private static final String UPPER_CASE_REGEX = "[A-Z]";
    private static final String SPECIAL_CHAR_REGEX = "[!@#$%^&*]";
    private static final int MIN_PASSWORD_LENGTH = 10;
    private static final int MAX_PASSWORD_LENGTH = 15;

    private RandomDataGenerator() {
    }

    public static String getRandomPassword(String emailPrefix) {
        String basePassword = FAKER.internet().password(MIN_PASSWORD_LENGTH, MAX_PASSWORD_LENGTH, true, true, true);
        String upperCase = FAKER.regexify(UPPER_CASE_REGEX);
        String specialChar = FAKER.regexify(SPECIAL_CHAR_REGEX);
        String digit = FAKER.number().digit();
        String emailChar = String.valueOf(emailPrefix.charAt(0));

        String finalPassword = basePassword + upperCase + specialChar + digit + emailChar;

        LOGGER.info(String.format("Random password generated: %s", finalPassword));
        return finalPassword;
    }

    public static String getRandomEmailPrefix() {
        String prefix = FAKER.name().username();
        LOGGER.info(String.format("A random email prefix has been generated: %s", prefix));
        return prefix;
    }

    public static String getRandomEmailDomain() {
        String domain = FAKER.internet().slug();
        LOGGER.info(String.format("A random email domain has been generated: %s", domain));
        return domain;
    }
}