/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Thang
 */
public class HelperDate {
    private static String format = "dd-MM-yyyy";
    private static SimpleDateFormat sdf = new SimpleDateFormat(format);
    public static Date parseDate(String input) throws ParseException{
        return sdf.parse(input);
    }
    public static String parseString(Date input) throws ParseException{
        return sdf.format(input);
    }
    public static Date adđay(int input){
        Date d = new Date((new Date().getTime() + input*1000*60*60*24));
        return d;
    }

    public static String getFormat() {
        return format;
    }

    public static void setFormat(String format) {
        HelperDate.format = format;
    }

    public static SimpleDateFormat getSdf() {
        return sdf;
    }

    public static void setSdf(SimpleDateFormat sdf) {
        HelperDate.sdf = sdf;
    }
    
}
