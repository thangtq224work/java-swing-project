/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edusys_ui;

import DAO.DAOChuyenDe;
import DAO.DAOHocVien;
import DAO.DAOInterface;
import DAO.DAOKhoaHoc;
import DAO.DAONguoiHoc;
import Entitys.ChuyenDe;
import Entitys.HocVien;
import Entitys.KhoaHoc;
import Entitys.NguoiHoc;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.HelperDate;

/**
 *
 * @author Thang
 */
public class QLHocVienJInternalFrame extends javax.swing.JInternalFrame {

    int index;
    static DAOInterface daoCD = new DAOChuyenDe();
    static DAOKhoaHoc daoKH = new DAOKhoaHoc();
    static DAOHocVien daoHV = new DAOHocVien();
    static DAONguoiHoc daoNH = new DAONguoiHoc();

    DefaultTableModel HVtableModel;
    DefaultTableModel NHtableModel;

    ArrayList<ChuyenDe> chuyenDeList = new ArrayList<>();
    ArrayList<HocVien> hocVienList = new ArrayList<>();
    ArrayList<KhoaHoc> khoaHocList = new ArrayList<>();
    ArrayList<NguoiHoc> nguoiHocList = new ArrayList<>();

    DefaultComboBoxModel<ChuyenDe> chuyenDeComboBoxModel = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<KhoaHoc> khoaHoccomboBoxModel1 = new DefaultComboBoxModel<>();

    /**
     * Creates new form QLChuyenDeJInternalFrame
     */
    public QLHocVienJInternalFrame() {
        initComponents();
        getChuyenDes();
        setting();
        customTable();
        cbChuyenDeActionPerformed(null);

    }

    private void setting() {
        tblHocVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cbChuyenDe.setModel((ComboBoxModel) chuyenDeComboBoxModel);
        cbKhoaHoc.setModel((ComboBoxModel) khoaHoccomboBoxModel1);
//        disableComponent(btnThem, txtMaCD);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbChuyenDe = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        cbKhoaHoc = new javax.swing.JComboBox<>();
        tab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocVien = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Qu???n l?? h???c vi??n");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Chuy??n ?????"));

        cbChuyenDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbChuyenDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbChuyenDe, 0, 342, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(cbChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Kh??a h???c"));

        cbKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKhoaHoc, 0, 342, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(cbKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TT", "M?? HV", "M?? NH", "H??? t??n", "??i???m"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHocVien);

        btnXoa.setText("X??a kh???i kh??a h???c");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhat.setText("C???p nh???t ??i???m");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnCapNhat))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tab.addTab("H???c vi??n", jPanel1);

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblNguoiHoc);

        btnThem.setText("Th??m v??o kh??a h???c");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnThem)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tab.addTab("Ng?????i h???c", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbChuyenDeActionPerformed
        // TODO add your handling code here:
        if (chuyenDeComboBoxModel.getSize() > 0) {
            ChuyenDe cd = (ChuyenDe) cbChuyenDe.getSelectedItem();
            getKhoaHocs(cd.getMaCD());
            fillToComboBox(khoaHocList, khoaHoccomboBoxModel1);
        }
    }//GEN-LAST:event_cbChuyenDeActionPerformed

    private void cbKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoaHocActionPerformed
        // TODO add your handling code here:
        getComboBox();
    }//GEN-LAST:event_cbKhoaHocActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        int index = tblNguoiHoc.getSelectedRow();
        NguoiHoc nh = nguoiHocList.get(index);
        KhoaHoc kh = khoaHoccomboBoxModel1.getElementAt(cbKhoaHoc.getSelectedIndex());
        HocVien hv = new HocVien(0, kh.getMaKH(), nh.getMaNH(), nh.getTenNH(), 0);
        int success = daoHV.insertToDB(hv);
        if (success > 0) {
            hv = daoHV.getByIDAndKH(kh.getMaKH(), hv.getMaNH());
            if (hv != null) {
                if (HVtableModel.getRowCount() == 0) {
                    enableComponent(btnXoa, btnCapNhat);
                }
                hocVienList.add(hv);
                HVtableModel.addRow(new Object[]{
                    hocVienList.size(), hv.getMaHV(), hv.getMaNH(), hv.getTenNH(), hv.getDiem()});
                tblHocVien.setRowSelectionInterval(0, 0);
                NHtableModel.removeRow(index);
                nguoiHocList.remove(index);
                if (NHtableModel.getRowCount() == 0) {
                    disableComponent(btnThem);
                } else if (NHtableModel.getRowCount() == index) {
                    index--;
                    tblNguoiHoc.setRowSelectionInterval(index, index);
                } else {
                    tblNguoiHoc.setRowSelectionInterval(index, index);
                }
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (Auth.getRole()) {
            index = tblHocVien.getSelectedRow();
            int maHV = (int) tblHocVien.getValueAt(index, 1);
            int option = JOptionPane.showConfirmDialog(null, "B???n c?? mu???n x??a h???c vi??n c?? m?? " + maHV, "Th??ng b??o", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                int success = daoHV.delete(maHV);
                if (success > 0) {

                    String maNH = tblHocVien.getValueAt(index, 2).toString();
                    System.out.println(maNH);
                    NguoiHoc nh = daoNH.getByID(maNH);
                    if (nh != null) {
                        nguoiHocList.add(nh);
                        if (NHtableModel.getRowCount() == 0) {
                            enableComponent(btnThem);
                        }
                        try {
                            NHtableModel.addRow(new Object[]{
                                nh.getMaNH(), nh.getTenNH(), nh.isGioiTinh() ? "Nam" : "N???", HelperDate.parseString(nh.getNgaySinh()), nh.getDienThoai(), nh.getEmail()
                            });
                        } catch (Exception ex) {
                            Logger.getLogger(QLHocVienJInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        tblNguoiHoc.setRowSelectionInterval(0, 0);

                    }
                    hocVienList.remove(index);
                    HVtableModel.removeRow(index);
                    if (HVtableModel.getRowCount() == 0) {
                        disableComponent(btnCapNhat, btnXoa);
                    } else if (HVtableModel.getRowCount() == index) {
                        index--;
                        tblHocVien.setRowSelectionInterval(index, index);
                    } else {
                        tblHocVien.setRowSelectionInterval(index, index);
                    }
                    JOptionPane.showMessageDialog(null, "X??a h???c vi??n th??nh c??ng", "Th???ng b??o", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "B???n kh??ng c?? quy???n x??a", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        capNhat();
    }//GEN-LAST:event_btnCapNhatActionPerformed
    private void btnFirst() {
        if (index == 0) {
            JOptionPane.showMessageDialog(this, "???? ?????n b???n ghi ?????u", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
        } else {

            index = 0;
//            fillToForm(index);
//        btn1.setEnabled(false);
        }
    }

    private void btnPrevious() {
        if (index > 0) {
            index--;
//            fillToForm(index);
        } else {
            JOptionPane.showMessageDialog(this, "???? ?????n b???n ghi ?????u", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btnNext() {
        if (index < chuyenDeList.size() - 1) {
            index++;
//            fillToForm(index);
//            btn1.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "???? ?????n b???n ghi cu???i", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btnLast() {
        if (index == chuyenDeList.size() - 1) {
            JOptionPane.showMessageDialog(this, "???? ?????n b???n ghi cu???i", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
//            btn1.setEnabled(true);
        } else {
            index = chuyenDeList.size() - 1;
//            fillToForm(index);
        }
    }

    private void disableComponent(JComponent... components) {
        for (JComponent component : components) {
            component.setEnabled(false);
        }
    }

    private void enableComponent(JComponent... components) {
        for (JComponent component : components) {
            component.setEnabled(true);
        }
    }

    private void customTable() {
        HVtableModel = (DefaultTableModel) tblHocVien.getModel();
        String arr[] = {"M?? nh", "T??n NH", "Gi???i t??nh", "Ng??y sinh", "SDT", "Email"};
        NHtableModel = new DefaultTableModel(arr, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };
        tblNguoiHoc.setModel(NHtableModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbChuyenDe;
    private javax.swing.JComboBox<String> cbKhoaHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JTable tblHocVien;
    private javax.swing.JTable tblNguoiHoc;
    // End of variables declaration//GEN-END:variables

    private void getChuyenDes() {
        chuyenDeList.clear();
        chuyenDeList = daoCD.getAll();
        if (chuyenDeList.size() > 0) {
            fillToComboBox(chuyenDeList, chuyenDeComboBoxModel);
        }
    }

    private void fillToComboBox(ArrayList list, DefaultComboBoxModel cbb) {
        cbb.removeAllElements();
        for (Object object : list) {
            cbb.addElement(object);
        }
    }

    private void getKhoaHocs(String maCD) {
        khoaHocList.clear();
        khoaHocList = daoKH.getAllByChuyenDe(maCD);
    }

    private void fillToTable() {
        NHtableModel.setRowCount(0);
        HVtableModel.setRowCount(0);

        for (NguoiHoc nh : nguoiHocList) {
            try {
                NHtableModel.addRow(new Object[]{
                    nh.getMaNH(), nh.getTenNH(), nh.isGioiTinh() ? "Nam" : "N???", HelperDate.parseString(nh.getNgaySinh()), nh.getDienThoai(), nh.getEmail()
                });
            } catch (Exception ex) {
                Logger.getLogger(QLHocVienJInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (hocVienList.size() > 0) {
            for (int i = 0; i < hocVienList.size(); i++) {
                HVtableModel.addRow(new Object[]{
                    i + 1, hocVienList.get(i).getMaHV(), hocVienList.get(i).getMaNH(), hocVienList.get(i).getTenNH(), hocVienList.get(i).getDiem()});
            }
        }
        if (hocVienList.size() > 0) {
            tblHocVien.setRowSelectionInterval(0, 0);
            enableComponent(btnCapNhat, btnXoa);

        } else {
            disableComponent(btnCapNhat, btnXoa);
        }
        if (nguoiHocList.size() > 0) {
            tblNguoiHoc.setRowSelectionInterval(0, 0);
            enableComponent(btnThem);

        } else {
            disableComponent(btnThem);

        }
    }

    private void getComboBox() {
        int kh = cbKhoaHoc.getSelectedIndex();
        int cd = cbChuyenDe.getSelectedIndex();
        int maKH = -1;
        System.out.println(kh + " kh");
        hocVienList.clear();
        nguoiHocList.clear();
        if (kh == -1) {
            hocVienList = daoHV.getAllInCourse(maKH);
            nguoiHocList = daoNH.getAll();
        } else if (kh >= 0 && cd >= 0) {
            KhoaHoc khoaHoc = khoaHocList.get(kh);
            maKH = khoaHoc.getMaKH();
        }
        hocVienList = daoHV.getAllInCourse(maKH);
        nguoiHocList = daoNH.getAllNotInCourse(maKH);
        fillToTable();
    }

    private void capNhat() {
        for (int i = 0; i < HVtableModel.getRowCount(); i++) {
            try {
                if (tblHocVien.isEditing()) {
                    tblHocVien.getCellEditor().stopCellEditing();
                }
                double diem = Double.parseDouble(HVtableModel.getValueAt(i, 4).toString());
                if (diem >= 0 && diem <= 10) {
                    HocVien hv = hocVienList.get(i);
                    hv.setDiem(diem);
                    daoHV.updateToDB(hv);
                    hocVienList.set(i, hv);
                    System.out.println(hv.getDiem());
                }
            } catch (Exception e) {
            }

        }
        getComboBox();
        JOptionPane.showMessageDialog(null, "C???p nh???t ho??n t???t", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
    }
}
