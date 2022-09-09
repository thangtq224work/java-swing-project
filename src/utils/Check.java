/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Thang
 */
public class Check {

    private static String SDT = "^0\\d{9,10}$";
    private static String Email = "^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}$|^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}\\.[a-z]{2,3}$";
    public static boolean isSDT(String input){
        return input.matches(SDT);
    }
    public static boolean isEmail(String input){
        return input.matches(Email);
    }

    public static boolean checkNull(String... s) {
        boolean tmp = true;
        for (String string : s) {
            if (string.isEmpty()) {
                tmp = false;
                break;
            }
        }
        return tmp;
    }

    public static boolean isANumberInteger(String input) {
        try {
            int tmp = Helper.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    public static boolean isANumberDouble(String input) {
        try {
            double tmp = Helper.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    public static boolean checkLength(int min, int max, String s) {

        if (s.length() >= min && s.length() <= max) {
            return true;
        }
        return false;
    }

    public static boolean checkTrung(String s1, String s2) {
        if (s1.equalsIgnoreCase(s2)) {
            return true;
        }
        return false;
    }
}
