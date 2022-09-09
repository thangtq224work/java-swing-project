/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import utils.Helper;

/**
 *
 * @author Thang
 */
public class HocVien {
    private int maHV,maKH;
    private String maNH,tenNH;
    protected double diem;

    public HocVien() {
    }

    public String getTenNH() {
        return tenNH;
    }

    public void setTenNH(String tenNH) {
        this.tenNH = tenNH;
    }
    public HocVien(int maHV, int maKH, String maNH, double diem) {
        this.maHV = maHV;
        this.maKH = maKH;
        this.maNH = maNH;
        this.diem = diem;
    }

    public HocVien(int maHV, int maKH, String maNH, String tenNH, double diem) {
        this.maHV = maHV;
        this.maKH = maKH;
        this.maNH = maNH;
        this.tenNH = tenNH;
        this.diem = diem;
    }
    

    public int getMaHV() {
        return maHV;
    }

    public void setMaHV(int maHV) {
        this.maHV = maHV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }
    public String getXepLoai(double diem){
        if(diem<5){
            return "Yếu";
        }
        else if(diem < 6.5){
            return "Trung bình";
        }
        
        else if(diem < 7.5){
            return "Khá";
        }
        
        else if(diem < 9){
            return "Giỏi ";
        }
        else{
            return "Xuất sác";
        }
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public double getDiem() {
        return Helper.roundNumber(diem) ;
    }

    public void setDiem(double diem) {
        this.diem = diem;
    }
    
}
