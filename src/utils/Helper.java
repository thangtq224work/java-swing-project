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
public class Helper {
    public static int parseInt(String input){
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new NumberFormatException("Không phải là 1 số nguyên");
        }
    }
    public static double parseDouble(String input){
        try {
            return Double.parseDouble(input);
        } catch (Exception e) {
            throw new NumberFormatException("Không phải là 1 số thực");
        }
    }
    public static double roundNumber(double input){
        return ((double)Math.round(input*100)/100);
    }
}
