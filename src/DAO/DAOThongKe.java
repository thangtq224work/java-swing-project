/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.jdbcHelper;

/**
 *
 * @author Thang
 */
public class DAOThongKe {

    public List<Object[]> getLuongNguoiHoc() {
        List list = new ArrayList();
        String query = "{call SP_LUONGNGUOIHOC()}";
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                Object obj[] = new Object[4];
                obj[0] = rs.getInt("NAM");
                obj[1] = rs.getInt("SOLUONG");
                obj[2] = rs.getDate("DAUTIEN");
                obj[3] = rs.getDate("CUOICUNG");
                list.add(obj);
            }
            rs.getStatement().getConnection().close();

        } catch (SQLException ex) {
            Logger.getLogger(DAOThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Object[]> getDiemChuyenDe() {
        List list = new ArrayList();
        String query = "{call SP_DIEMCHUYENDE()}";
        try {
            ResultSet rs = jdbcHelper.query(query);
            while (rs.next()) {
                Object obj[] = new Object[5];
                obj[0] = rs.getString("TenCD");
                obj[1] = rs.getInt("SOHV");
                obj[2] = rs.getDouble("THAPNHAT");
                obj[3] = rs.getDouble("TRUNGBINH");
                obj[4] = rs.getDouble("CAONHAT");
                list.add(obj);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Object[]> getDoanhThu(Integer year) {
        List list = new ArrayList();
        String query = "{call SP_DOANHTHU(?)}";
        try {
            ResultSet rs = jdbcHelper.query(query, year);
            while (rs.next()) {
                Object obj[] = new Object[7];
                obj[0] = rs.getString("TenCD");
                obj[1] = rs.getInt("SOKH");
                obj[2] = rs.getInt("SOHV");
                obj[3] = rs.getDouble("DOANHTHU");
                obj[4] = rs.getDouble("THAPNHAT");
                obj[5] = rs.getDouble("CAONHAT");
                obj[6] = rs.getDouble("TRUNGBINH");
                list.add(obj);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(DAOThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getTime() {
        String query = "select MIN(YEAR(NgayTao)) from KhoaHoc";
        try {
            ResultSet rs = jdbcHelper.query(query);
            rs.next();
            int tmp = rs.getInt(1);
            rs.getStatement().getConnection().close();
            return tmp;
        } catch (Exception ex) {
            Logger.getLogger(DAOThongKe.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }
        return 2000;
    }

}
