/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Entitys.NhanVien;

/**
 *
 * @author Thang
 */
public class Auth {
    public static NhanVien nv = null;
    public static void clear(){
        nv = null;
    }
    public static boolean isLogin(){
        return nv != null;
    }
    public static boolean getRole(){
        return Auth.isLogin() && nv.isVaiTro();
    }
}
