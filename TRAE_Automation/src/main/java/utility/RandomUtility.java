package utility;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtility {
    public static String getRandomAlphaNumericString() {
        return RandomStringUtils.randomAlphanumeric(4, 29);
    }
}
