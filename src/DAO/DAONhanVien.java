/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entitys.NhanVien;
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
public class DAONhanVien implements DAOInterface<NhanVien, String> {

    @Override
    public int insertToDB(NhanVien t) {
        String query = "insert into NhanVien(MaNV,HoTen,MatKhau,VaiTro) values (?,?,?,?)";
        try {
            return jdbcHelper.update(query, t.getMaNV(), t.getHoTen(), t.getMatKhau(), t.isVaiTro());
        } catch (Exception e) {
            
        }
        return -1;
    }

    @Override
    public int updateToDB(NhanVien t) {
        String query = "update NhanVien set HoTen=? , MatKhau = ? , VaiTro = ?,TrangThai = ? where MaNV = ?";
        try {
            return jdbcHelper.update(query, t.getHoTen(), t.getMatKhau(), t.isVaiTro(),t.isTrangThai(),t.getMaNV());
        } catch (Exception e) {
            
        }
        return -1;
    }

    @Override
    public ArrayList<NhanVien> getAll() {
        ArrayList<NhanVien> arrayList = new ArrayList<>();
        String query = "select * from NhanVien WHERE TrangThai = 0";
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString("MaNV"), rs.getString("HoTen"), rs.getString("MatKhau"), rs.getBoolean("VaiTro"),rs.getBoolean("TrangThai"));
                arrayList.add(nv);
            }
            rs.getStatement().getConnection().close();

        } catch (Exception ex) {
            Logger.getLogger(DAONhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }
    public ArrayList<NhanVien> getNAll() {
        ArrayList<NhanVien> arrayList = new ArrayList<>();
        String query = "select * from NhanVien WHERE TrangThai = 1";
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString("MaNV"), rs.getString("HoTen"), rs.getString("MatKhau"), rs.getBoolean("VaiTro"),rs.getBoolean("TrangThai"));
                arrayList.add(nv);
            }
            rs.getStatement().getConnection().close();

        } catch (SQLException ex) {
            Logger.getLogger(DAONhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    @Override
    public int delete(String t) {
        throw new RuntimeException();
    }

    @Override
    public NhanVien getByID(String t) {
        NhanVien nv = null;
        try {
            String query = "select * from NhanVien where maNV=?";
            ResultSet ps = jdbcHelper.query(query, t);
            if (ps.next()) {
                nv = new NhanVien(ps.getString(1), ps.getString(3), ps.getString(2), ps.getBoolean(4));
            }
        } catch (Exception ex) {
            Logger.getLogger(DAONhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nv;
    }

}
