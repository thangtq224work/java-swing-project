/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entitys.KhoaHoc;
import Entitys.NguoiHoc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.jdbcHelper;

/**
 *
 * @author Thang
 */
public class DAOKhoaHoc implements DAOInterface<KhoaHoc, Integer> {

    @Override
    public ArrayList<KhoaHoc> getAll() {
        ArrayList<KhoaHoc> arrayList = new ArrayList<>();
        String query = "select * From KhoaHoc";
//        String query = "select KhoaHoc.MaCD,MaKH,ChuyenDe.TenCD,GhiChu  , ChuyenDe.HocPhi, ChuyenDe.ThoiLuong, KhoaHoc.NgayTao,KhoaHoc.NgayKG,KhoaHoc.MaNV from KhoaHoc join ChuyenDe on KhoaHoc.MaCD = ChuyenDe.MaCD";
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                Date kg = new java.sql.Date(rs.getDate("NgayKG").getTime());
                Date nt = new java.sql.Date(rs.getDate("NgayTao").getTime());
                KhoaHoc kh = new KhoaHoc(rs.getString("MaCD"), rs.getString("GhiChu"), rs.getString("MaNV"), rs.getInt("MaKH"), rs.getInt("ThoiLuong"), rs.getFloat("HocPhi"), nt, kg);
                arrayList.add(kh);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(DAOKhoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    @Override
    public int insertToDB(KhoaHoc t) {
        String query = "INSERT INTO KhoaHoc(MaCD,MaNV,HocPhi,ThoiLuong,NgayKG,NgayTao,GhiChu) VALUES (?,?,?,?,?,?,?)";
        try {
            return jdbcHelper.update(query, t.getMaCD(), t.getMaNV(), t.getHocPhi(), t.getThoiLuong(), t.getNgayKG(), t.getNgayTao(), t.getGhiChu());
        } catch (Exception ex) {
            Logger.getLogger(DAOKhoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int updateToDB(KhoaHoc t) {
        String query = "update KhoaHoc set NgayKG = ? where MaKH = ?";
        try {
            return jdbcHelper.update(query, t.getNgayKG(), t.getMaKH());
        } catch (Exception ex) {
            Logger.getLogger(DAOKhoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public int delete(Integer t) {
        String query = "delete KhoaHoc where MaKH =?";
        try {
            return jdbcHelper.update(query, t);
        } catch (Exception ex) {
            Logger.getLogger(DAOKhoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public KhoaHoc getByID(Integer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<KhoaHoc> getAllByChuyenDe(String maCD) {

        String query = "select * from KhoaHoc where maCD =?";
        
        ArrayList<KhoaHoc> arrayList = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(query,maCD);
            while (rs.next()) {
                Date kg = new java.sql.Date(rs.getDate("NgayKG").getTime());
                Date nt = new java.sql.Date(rs.getDate("NgayTao").getTime());
                KhoaHoc kh = new KhoaHoc(rs.getString("MaCD"), rs.getString("GhiChu"), rs.getString("MaNV"), rs.getInt("MaKH"), rs.getInt("ThoiLuong"), rs.getFloat("HocPhi"), nt, kg);
                arrayList.add(kh);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(DAOKhoaHoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

}
