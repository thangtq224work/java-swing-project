/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entitys.HocVien;
import Entitys.NguoiHoc;
import Entitys.NhanVien;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.jdbcHelper;

/**
 *
 * @author Thang
 */
public class DAOHocVien implements DAOInterface<HocVien, Integer> {

    @Override
    public ArrayList<HocVien> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertToDB(HocVien t) {
        String query = "INSERT INTO HocVien(MaKH,MaNH,Diem) VALUES (?,?,?)";
        try {
            return jdbcHelper.update(query, t.getMaKH(), t.getMaNH(), t.getDiem());
        } catch (Exception ex) {
            Logger.getLogger(DAOHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int updateToDB(HocVien t) {
        String query = "update HocVien set Diem = ? where MaHV = ?";
        try {
            return jdbcHelper.update(query, t.getDiem(), t.getMaHV());
        } catch (Exception ex) {
            Logger.getLogger(DAOHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int delete(Integer t) {
        String query = "delete HocVien where MaHV = ?";
        try {
            return jdbcHelper.update(query, t);
        } catch (SQLException ex) {
            Logger.getLogger(DAOHocVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;

    }

    @Override
    public HocVien getByID(Integer t) {
        String query = "select * from HocVien join NguoiHoc on HocVien.MaNH = NguoiHoc.MaNH where HocVien.MaHV = ?";
        HocVien hv = null;
        try {
            ResultSet rs = jdbcHelper.query(query, t);
            while (rs.next()) {
                hv = new HocVien(rs.getInt("MaHV"), rs.getInt("MaKH"), rs.getString("MaNH"), rs.getString("HoTen"), rs.getFloat("Diem"));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(DAONguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hv;
    }

    public HocVien getByIDAndKH(Integer t, String maKH) {
        String query = "select * from HocVien join NguoiHoc on HocVien.MaNH = NguoiHoc.MaNH where NguoiHoc.MaNH like ? and HocVien.MaKH = ?";
        HocVien hv = null;
        try {
            ResultSet rs = jdbcHelper.query(query, maKH, t);
            while (rs.next()) {
                hv = new HocVien(rs.getInt("MaHV"), rs.getInt("MaKH"), rs.getString("MaNH"), rs.getString("HoTen"), rs.getFloat("Diem"));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(DAONguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hv;
    }

    public ArrayList<HocVien> getAllInCourse(int MaKH) {
        ArrayList<HocVien> arrayList = new ArrayList<>();
        String query = "select MaHV,NguoiHoc.MaNH,MaKH,NguoiHoc.HoTen,Diem from HocVien join NguoiHoc on HocVien.MaNH = NguoiHoc.MaNH where HocVien.MaKH = ?";
        try {
            ResultSet rs = jdbcHelper.query(query, MaKH);
            while (rs.next()) {
                HocVien hv = new HocVien(rs.getInt("MaHV"), MaKH, rs.getString("MaNH"), rs.getString("HoTen"), rs.getFloat("Diem"));
                arrayList.add(hv);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(DAONguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

}
