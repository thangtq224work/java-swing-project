/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entitys.ChuyenDe;
import Entitys.NhanVien;
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
public class DAOChuyenDe implements DAOInterface<ChuyenDe, String> {

    @Override
    public ArrayList<ChuyenDe> getAll() {
        ArrayList<ChuyenDe> arrayList = new ArrayList<>();
        String query = "select * from ChuyenDe";
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                ChuyenDe cd = new ChuyenDe(rs.getString("MaCD"), rs.getString("TenCD"),  rs.getString("Hinh"),  rs.getString("MoTa"), rs.getFloat("HocPhi"), rs.getInt("ThoiLuong"));
                arrayList.add(cd);
            }
            rs.getStatement().getConnection().close();

        } catch (SQLException ex) {
            Logger.getLogger(DAONhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    @Override
    public int insertToDB(ChuyenDe t) {
        String query = "insert into ChuyenDe(MaCD,TenCD,ThoiLuong,HocPhi,Hinh,MoTa) values (?,?,?,?,?,?)";
        int tmp = -1;
        try {
            tmp = jdbcHelper.update(query, t.getMaCD(),t.getTenCD(),t.getThoiLuong(),t.getHocPhi(),t.getHinh(),t.getMoTa());
        } catch (Exception ex) {
            System.out.println("+1");
        }
        return tmp;

    }

    @Override
    public int updateToDB(ChuyenDe t) {
        String query = "update ChuyenDe set TenCD = ? , ThoiLuong = ? , HocPhi = ? , Hinh = ? , MoTa = ? where MaCD = ?";
        try {
            return jdbcHelper.update(query, t.getTenCD(),t.getThoiLuong(),t.getHocPhi(),t.getHinh(),t.getMoTa(),t.getMaCD());
        } catch (Exception ex) {
            
        }
        return -1;
    }

    @Override
    public int delete(String t) {
        String query = "delete ChuyenDe where MaCD=?";
        try {
            return jdbcHelper.update(query, t);
        } catch (Exception ex) {
            Logger.getLogger(DAOChuyenDe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public ChuyenDe getByID(String t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
