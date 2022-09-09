/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entitys;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.HelperDate;

/**
 *
 * @author Thang
 */
public class KhoaHoc {
    private String maCD,ghiChu,maNV;
    private int maKH,thoiLuong;
    private double hocPhi;
    private Date ngayTao,ngayKG;

    public KhoaHoc() {
    }

    public KhoaHoc(String maCD, String ghiChu, String maNV, int maKH, int thoiLuong, double hocPhi, Date ngayTao, Date ngayKG) {
        this.maCD = maCD;
        this.ghiChu = ghiChu;
        this.maNV = maNV;
        this.maKH = maKH;
        this.thoiLuong = thoiLuong;
        this.hocPhi = hocPhi;
        this.ngayTao = ngayTao;
        this.ngayKG = ngayKG;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public int getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayKG() {
        return ngayKG;
    }

    public void setNgayKG(Date ngayKG) {
        this.ngayKG = ngayKG;
    }

    @Override
    public String toString() {
        try {
            return this.getMaCD() + " ("+HelperDate.parseString(this.getNgayKG())+")"; //To change body of generated methods, choose Tools | Templates.
        } catch (Exception ex) {
            Logger.getLogger(KhoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
}
