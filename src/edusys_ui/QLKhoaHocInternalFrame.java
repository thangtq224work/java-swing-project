/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edusys_ui;

import DAO.DAOChuyenDe;
import DAO.DAOInterface;
import DAO.DAOKhoaHoc;
import Entitys.ChuyenDe;
import Entitys.KhoaHoc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import utils.Auth;
import utils.Check;
import utils.Helper;
import utils.HelperDate;

/**
 *
 * @author Thang
 */
public class QLKhoaHocInternalFrame extends javax.swing.JInternalFrame {

    int index;
    DefaultComboBoxModel<ChuyenDe> comboBoxModel;
    static DAOInterface daoKH = new DAOKhoaHoc();
    static DAOChuyenDe daoCD = new DAOChuyenDe();
    DefaultTableModel tableModel;
    ArrayList<ChuyenDe> chuyenDeList = new ArrayList<>();
    ArrayList<KhoaHoc> baseKhoaHocList = new ArrayList<>();
    ArrayList<KhoaHoc> khoaHocList = new ArrayList<>();
    boolean specifyBtnMoi;

    /**
     * Creates new form QLChuyenDeJInternalFrame
     */
    public QLKhoaHocInternalFrame() {
        initComponents();
        customTable();
        setting();
        getDataAndFillToComboBox();
        baseKhoaHocList = daoKH.getAll();
        cbKhoaHocActionPerformed(null);
    }

    private void setting() {
        tblBang.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        txtKhaiGiang.setDateFormatString(HelperDate.getFormat());
        disableComponent(txtCD, txtHocPhi, txtNguoiTao, txtThoiLuong, txtNgayTao, btnThem);
        specifyBtnMoi = true;
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
        jLabel3 = new javax.swing.JLabel();
        txtCD = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBang = new javax.swing.JTable();
        lblRecord = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtHocPhi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtThoiLuong = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cbKhoaHoc = new javax.swing.JComboBox<>();
        txtKhaiGiang = new org.netbeans.modules.form.InvalidComponent();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setClosable(true);
        setIconifiable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Qu???n l?? kh??a h???c");

        jLabel3.setText("Chuy??n ?????");

        jLabel5.setText("Khai gi???ng");

        btnThem.setText("Th??m");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("S???a");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("X??a");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("M???i");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btn1.setText("|<");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setText("<<");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setText(">>");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setText(">|");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        tblBang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblBang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblBangMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblBang);

        lblRecord.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRecord.setText("jLabel7");

        jLabel7.setText("H???c ph??");

        jLabel8.setText("Th???i l?????ng (gi???)");

        jLabel9.setText("Ng?????i t???o");

        jLabel10.setText("Ng??y t???o");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), "Chuy??n ?????"));

        cbKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbKhoaHoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKhoaHocItemStateChanged(evt);
            }
        });
        cbKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("M?? t???");

        txtGhiChu.setColumns(20);
        txtGhiChu.setLineWrap(true);
        txtGhiChu.setRows(5);
        txtGhiChu.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtGhiChu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnMoi)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addGap(31, 31, 31)
                                .addComponent(lblRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btn1)
                                .addGap(18, 18, 18)
                                .addComponent(btn2)
                                .addGap(18, 18, 18)
                                .addComponent(btn3)
                                .addGap(18, 18, 18)
                                .addComponent(btn4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCD, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(249, 249, 249))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(42, 42, 42)
                                                .addComponent(txtNgayTao))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(txtKhaiGiang, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(249, 249, 249))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))))
                                .addGap(19, 19, 19)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtCD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addComponent(txtKhaiGiang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtHocPhi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnMoi)
                    .addComponent(btnXoa)
                    .addComponent(btn1)
                    .addComponent(btn2)
                    .addComponent(btn3)
                    .addComponent(btn4)
                    .addComponent(lblRecord))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        index = tblBang.getSelectedRow();
        KhoaHoc kh = khoaHocList.get(index);
        Date kg = txtKhaiGiang.getDate();
        Date nt = null;
        try {
            nt = HelperDate.parseDate(txtNgayTao.getText());
        } catch (Exception ex) {

        }
        if (kg == null) {
            JOptionPane.showMessageDialog(this, "Ng??y khai gi???ng kh??ng h???p l???", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (kg.before(nt)) {
            JOptionPane.showMessageDialog(this, "Ng??y t???o ph???i tr?????c ng??y khai gi???ng", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        kh.setNgayKG(kg);
        kh.setGhiChu(txtGhiChu.getText().trim());

        int success = daoKH.updateToDB(kh);
        if (success > 0) {
            khoaHocList.set(index, kh);
            try {
                tableModel.setValueAt(HelperDate.parseString(kg), index, 3);
            } catch (ParseException ex) {
                Logger.getLogger(QLKhoaHocInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "C???p nh???t th???t b???i", "Th??ng b??o", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblBangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangMousePressed
        // TODO add your handling code here:
        index = tblBang.getSelectedRow();
        fillToForm(index);
    }//GEN-LAST:event_tblBangMousePressed

    private void cbKhoaHocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKhoaHocItemStateChanged
        // TODO add your handling code here:


    }//GEN-LAST:event_cbKhoaHocItemStateChanged

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        if (Auth.getRole()) {
            int maKH = Helper.parseInt(tableModel.getValueAt(index, 0).toString());
            KhoaHoc kh = getForm();

            int success = daoKH.delete(maKH);
            if (success > 0) {
                JOptionPane.showMessageDialog(this, "X??a nh??n vi??n th??nh c??ng", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
                System.out.println(baseKhoaHocList.size());
                khoaHocList.remove(index);
                tableModel.removeRow(index);
                for (KhoaHoc kh1 : baseKhoaHocList) {
                    if (kh1.getMaKH() == maKH) {
                        baseKhoaHocList.remove(kh1);
                        break;
                    }
                }
                System.out.println(baseKhoaHocList.size());
                if (tableModel.getRowCount() == 0) {
                    disableComponent(btnSua, btnXoa, btn1, btn2, btn3, btn4);
                    clearForm();
                } else if (tableModel.getRowCount() == index) {
                    index--;
                    fillToForm(index);
                } else {
                    fillToForm(index);
                }

            } else {
                JOptionPane.showMessageDialog(this, "X??a nh??n vi??n th???t b???i .", "Th??ng b??o", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "B???n kh??ng c?? quy???n x??a", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);

        }

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        if (specifyBtnMoi) {
            index = tblBang.getSelectedRow();
            clearForm();
            btnMoi.setText("H???y");
            disableComponent(btn1, btn2, btn3, btn4, btnXoa, btnSua);
            enableComponent(btnThem);
            specifyBtnMoi = false;
            txtNguoiTao.setText(Auth.nv.getMaNV());
            try {
                txtNgayTao.setText(HelperDate.parseString(new Date()));
            } catch (ParseException ex) {
                Logger.getLogger(QLKhoaHocInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            txtKhaiGiang.setDate(HelperDate.ad??ay(2)); // Th??m 3 ng??y t??nh t??? hi???n t???i 
        } else {
            btnMoi.setText("M???i");
            System.out.println(index);
            if (khoaHocList.size() > 0) {
                enableComponent(btn1, btn2, btn3, btn4, btnXoa, btnSua);
                fillToForm(index);
            }
            disableComponent(btnThem);
            specifyBtnMoi = true;
        }
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        // TODO add your handling code here:
        btnFirst();
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
        btnPrevious();
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        // TODO add your handling code here:
        btnLast();
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        // TODO add your handling code here:
        btnNext();
    }//GEN-LAST:event_btn3ActionPerformed

    private void cbKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhoaHocActionPerformed
        // TODO add your handling code here:
        ChuyenDe cd = comboBoxModel.getElementAt(cbKhoaHoc.getSelectedIndex());
        System.out.println(cd.getMaCD() + "+1");
        khoaHocList.clear();
        khoaHocList = (ArrayList<KhoaHoc>) duyetList(cd.getMaCD(), baseKhoaHocList);
        if (khoaHocList.size() > 0) {
            enableComponent(btnSua, btnXoa, btn1, btn2, btn3, btn4);
            txtHocPhi.setText(cd.getHocPhi() + "");
            txtThoiLuong.setText(cd.getThoiLuong() + "");
            txtCD.setText(cd.getTenCD() + "");
            txtHocPhi.setText(cd.getHocPhi() + "");
            fillToTable(khoaHocList);
        } else {
            txtKhaiGiang.setDate(null);
            disableComponent(btnSua, btnXoa, btn1, btn2, btn3, btn4);
            fillToTable(khoaHocList);
        }


    }//GEN-LAST:event_cbKhoaHocActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        KhoaHoc kh = getForm();
        if (kh != null) {
            int success = daoKH.insertToDB(kh);
            if (success > 0) {
                JOptionPane.showMessageDialog(this, "Th??m kh??a h???c th??nh c??ng", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
                baseKhoaHocList.clear();
                baseKhoaHocList = daoKH.getAll();
                cbKhoaHocActionPerformed(evt);
                index = tableModel.getRowCount() - 1;
                fillToForm(index);
                specifyBtnMoi = true;
                enableComponent(btn1, btn2, btn3, btn4, btnXoa, btnSua);
                disableComponent(btnThem);
                btnMoi.setText("M???i");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Th??m kh??a h???c kh??ng th??nh c??ng", "Th??ng b??o", JOptionPane.WARNING_MESSAGE);
        }
//     public KhoaHoc(String maCD, String ghiChu, String maNV, int maKH, int thoiLuong, double hocPhi, Date ngayTao, Date ngayKG) {


    }//GEN-LAST:event_btnThemActionPerformed
    private void btnFirst() {
        if (index == 0) {
            JOptionPane.showMessageDialog(this, "???? ?????n b???n ghi ?????u", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
        } else {

            index = 0;
            fillToForm(index);
//        btn1.setEnabled(false);
        }
    }

    private void btnPrevious() {
        if (index > 0) {
            index--;
            fillToForm(index);
        } else {
            JOptionPane.showMessageDialog(this, "???? ?????n b???n ghi ?????u", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btnNext() {
        if (index < khoaHocList.size() - 1) {
            index++;
            fillToForm(index);
//            btn1.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "???? ?????n b???n ghi cu???i", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void btnLast() {
        if (index == khoaHocList.size() - 1) {
            JOptionPane.showMessageDialog(this, "???? ?????n b???n ghi cu???i", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
//            btn1.setEnabled(true);
        } else {
            index = khoaHocList.size() - 1;
            fillToForm(index);
        }
    }

    private void disableComponent(JComponent... component) {
        for (JComponent jComponent : component) {
            jComponent.setEnabled(false);
        }
    }

    private void enableComponent(JComponent... component) {
        for (JComponent jComponent : component) {
            jComponent.setEnabled(true);
        }
    }

    private void customTable() {
        String arr[] = {"M?? KH", "Th???i l?????ng", "H???c ph??", "Khai gi???ng", "T???o b???i", "Ng??y t???o"};
        tableModel = new DefaultTableModel(arr, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };
        tblBang.setModel(tableModel);
    }

    private void fillToTable(List<KhoaHoc> khoaHocs) {
        if (khoaHocs.size() > 0) {
            index = 0;
            tableModel.setRowCount(0);
            for (KhoaHoc kh : khoaHocs) {
                try {
                    tableModel.addRow(new Object[]{
                        kh.getMaKH(), kh.getThoiLuong(), kh.getHocPhi(), HelperDate.parseString(kh.getNgayKG()), kh.getMaNV(), HelperDate.parseString(kh.getNgayTao())
                    });
                } catch (ParseException ex) {
                    Logger.getLogger(QLKhoaHocInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            fillToForm(index);
        } else {
            tableModel.setRowCount(0);
        }
    }

    private void fillToForm(int i) {
        txtCD.setText(comboBoxModel.getSelectedItem().toString());
        txtNguoiTao.setText(khoaHocList.get(i).getMaNV());
        try {
            txtNgayTao.setText(HelperDate.parseString(khoaHocList.get(i).getNgayTao()));
        } catch (ParseException ex) {
            Logger.getLogger(QLKhoaHocInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtGhiChu.setText(khoaHocList.get(i).getGhiChu());
        try {
            txtKhaiGiang.setDate(HelperDate.parseDate(tableModel.getValueAt(i, 3).toString()));
        } catch (ParseException ex) {
            Logger.getLogger(QLKhoaHocInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
//        txtKhaiGiang.setDateFormatString(khoaHocList.get(i).getNgayKG().toString());
        tblBang.setRowSelectionInterval(i, i);
        lblRecord.setText((i + 1) + " / " + (khoaHocList.size()));
    }

    private void clearForm() {
        lblRecord.setText(" ? / " + (khoaHocList.size()));
        txtGhiChu.setText("");
        tblBang.getSelectionModel().clearSelection();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbKhoaHoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblRecord;
    private javax.swing.JTable tblBang;
    private javax.swing.JTextField txtCD;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHocPhi;
    private org.netbeans.modules.form.InvalidComponent txtKhaiGiang;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtThoiLuong;
    // End of variables declaration//GEN-END:variables

    private void getDataAndFillToComboBox() {
        chuyenDeList = daoCD.getAll();
        comboBoxModel = new DefaultComboBoxModel<>();
        comboBoxModel.removeAllElements();
        for (ChuyenDe cd : chuyenDeList) {
            comboBoxModel.addElement(cd);
        }
        cbKhoaHoc.setModel((ComboBoxModel) comboBoxModel);
    }

    private List<KhoaHoc> duyetList(String ma, List<KhoaHoc> baseKhoaHocs) {
        List<KhoaHoc> list = new ArrayList<>();
        for (KhoaHoc baseKhoaHoc : baseKhoaHocs) {
            if (ma.equalsIgnoreCase(baseKhoaHoc.getMaCD())) {
                list.add(baseKhoaHoc);
            }
        }
        return list;
    }

    private boolean check(String input) {
        return Check.checkLength(0, 255, input);
    }

    private KhoaHoc getForm() {
        try {
            if (!check(txtGhiChu.getText().trim())) {
                return null;
            }
            return new KhoaHoc(((ChuyenDe) cbKhoaHoc.getSelectedItem()).getMaCD(), txtGhiChu.getText().trim(), txtNguoiTao.getText(), 0, Helper.parseInt(txtThoiLuong.getText()), Helper.parseDouble(txtHocPhi.getText()), HelperDate.parseDate(txtNgayTao.getText()), txtKhaiGiang.getDate());
        } catch (ParseException ex) {
            Logger.getLogger(QLKhoaHocInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
