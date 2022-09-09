/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

/**
 *
 * @author Thang
 */
public class ChuyenDe {
    private String maCD,tenCD,hinh,moTa;
    private float hocPhi;
    private int thoiLuong;

    public ChuyenDe() {
    }

    public ChuyenDe(String maCD, String tenCD, String hinh, String moTa, float hocPhi, int thoiLuong) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.hinh = hinh;
        this.moTa = moTa;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public float getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(float hocPhi) {
        this.hocPhi = hocPhi;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    @Override
    public String toString() {
        return this.getTenCD(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
