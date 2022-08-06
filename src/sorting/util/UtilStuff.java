package sorting.util;

import java.util.ArrayList;
import java.util.List;

public class UtilStuff {


    public static List<String> ERRORS = new ArrayList<>();

    public static double getPercentage(int n, int f) {
        return ((double) f / (double) n) * 100;
    }

    public static Commands getCommand(String s) {
        try {
            return Commands.valueOf(s.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Commands.ERROR;
        }
    }

}
