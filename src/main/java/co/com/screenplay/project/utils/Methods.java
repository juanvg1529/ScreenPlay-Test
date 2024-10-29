package co.com.screenplay.project.utils;

import java.util.Random;

public class Methods {

    public static int randomNumber() {
        Random random = new Random();
        return random.nextInt(100000) + 1;
    }
}
