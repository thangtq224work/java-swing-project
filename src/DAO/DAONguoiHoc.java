/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entitys.KhoaHoc;
import Entitys.NguoiHoc;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.jdbcHelper;

/**
 *
 * @author Thang
 */
public class DAONguoiHoc implements DAOInterface<NguoiHoc, String> {

    @Override
    public ArrayList<NguoiHoc> getAll() {
        String query = "select * from NguoiHoc";
        ArrayList<NguoiHoc> arrayList = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                Date ns = new Date(rs.getDate("NgaySinh").getTime());
                Date dk = new Date(rs.getDate("NgayDK").getTime());
                NguoiHoc nh = new NguoiHoc(rs.getString("MaNH"), rs.getString("HoTen"), rs.getString("DienThoai"), rs.getString("Email"), rs.getString("GhiChu"), rs.getString("MaNV"), dk, ns, rs.getBoolean("GioiTinh"));
                arrayList.add(nh);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(DAONguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    @Override
    public int insertToDB(NguoiHoc t) {
        String query = "INSERT INTO NguoiHoc(MaNH,HoTen,DienThoai,Email,GioiTinh,MaNV,NgaySinh,NgayDK,GhiChu) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            return jdbcHelper.update(query, t.getMaNH(), t.getTenNH(), t.getDienThoai(), t.getEmail(), t.isGioiTinh(), t.getMaNV(), t.getNgaySinh(), t.getNgayDK(), t.getGhiChu());
        } catch (Exception ex) {
            System.out.println("+1");
        }
        return -1;
    }

    @Override
    public int updateToDB(NguoiHoc t) {
        String query = "update NguoiHoc set HoTen=?,DienThoai=?,Email=?,GhiChu=?,GioiTinh=?,NgaySinh=? where MaNH=?";
        try {
            return jdbcHelper.update(query, t.getTenNH(), t.getDienThoai(), t.getEmail(), t.getGhiChu(), t.isGioiTinh(), t.getNgaySinh(), t.getMaNH());
        } catch (Exception ex) {
            Logger.getLogger(DAONguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int delete(String t) {
        String query = "delete NguoiHoc where MaNH = ?";
        try {
            return jdbcHelper.update(query, t);
        } catch (Exception ex) {
            Logger.getLogger(DAONguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public NguoiHoc getByID(String t) {
        String query = "select * from NguoiHoc where MaNH = ?";
        NguoiHoc nh = null;
        try {
            ResultSet rs = jdbcHelper.query(query,t);
            while (rs.next()) {
                Date ns = new Date(rs.getDate("NgaySinh").getTime());
                Date dk = new Date(rs.getDate("NgayDK").getTime());
                 nh = new NguoiHoc(rs.getString("MaNH"), rs.getString("HoTen"), rs.getString("DienThoai"), rs.getString("Email"), rs.getString("GhiChu"), rs.getString("MaNV"), dk, ns, rs.getBoolean("GioiTinh"));
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(DAONguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nh;
    }

    public ArrayList<NguoiHoc> getAllNotInCourse(int maKH) {

        String query = "select * from NguoiHoc where MaNH not in (select MaNH from HocVien join KhoaHoc on HocVien.MaKH = KhoaHoc.MaKH where HocVien.MaKH = ? )";
        ArrayList<NguoiHoc> arrayList = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(query,maKH);
            while (rs.next()) {
                Date ns = new Date(rs.getDate("NgaySinh").getTime());
                Date dk = new Date(rs.getDate("NgayDK").getTime());
                NguoiHoc nh = new NguoiHoc(rs.getString("MaNH"), rs.getString("HoTen"), rs.getString("DienThoai"), rs.getString("Email"), rs.getString("GhiChu"), rs.getString("MaNV"), dk, ns, rs.getBoolean("GioiTinh"));
                arrayList.add(nh);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(DAONguoiHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

}
