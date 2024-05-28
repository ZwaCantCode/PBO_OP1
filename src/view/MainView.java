/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import control.CustomerControl;
import control.KendaraanControl;
import control.MobilControl;
import control.MotorControl;
import exception.*;
import javax.swing.JOptionPane;
import model.Kendaraan;
import model.Customer;
import model.Mobil;
import model.Motor;

/**
 *
 * @author jppjo
 */
public class MainView extends javax.swing.JFrame {

    /**
     * Creates new form MainView
     */
    private KendaraanControl kc = new KendaraanControl();
    private MotorControl mtrc = new MotorControl();
    private MobilControl mblc = new MobilControl();
    private CustomerControl cc = new CustomerControl();
    private Kendaraan k = null;
    private Mobil mbl = null;
    private Motor mtr = null;
    private Customer c = null;
    String actionKendaraan = null;
    String action = null, actionCustomer = null;
    int idCustomer = 0;
    
    private void inputKosongKendaraanException() throws InputKosongException {
        if (idkendaraanInputTextField.getText().isEmpty() || hargaKendaraanInputTextField.getText().isEmpty())
            throw new InputKosongException();
    }

    private void inputKosongCustomerException() throws InputKosongException {
        if (namaCustomerInputTextField.getText().isEmpty() || alamatTextArea.getText().isEmpty() || nomorTeleponInputTextField.getText().isEmpty())
            throw new InputKosongException();
    }

    private void inputSpecialAtributeKendaraanException() throws InputSpecialAtributeException {
        if (jenisKendaraanInputButton.getText().equals("Motor") && !isInteger(specialAtributeInputTextField.getText()))
            throw new InputSpecialAtributeException();
    }

    private void noTelponException() throws NoTelponException {
        if (!nomorTeleponInputTextField.getText().matches("^\\+?[0-9]+$"))
            throw new NoTelponException();
    }
    
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public MainView() {
        initComponents();
        showKendaraan();
        showCustomer();
        setComponentsKendaraan(false);
        setComponentsCustomer(false);
        setKendaraanEditDeleteButton(false);
        setEditDeleteButtonCustomer(false);
        clearTextKendaraan();
        clearTextCustomer();
    }
    
    private void setComponentsKendaraan(boolean value) {
        idkendaraanInputTextField.setEnabled(value);
        namaKendaraanInputTextField.setEnabled(value);
        hargaKendaraanInputTextField.setEnabled(value);
        jenisKendaraanInputButton.setEnabled(value);
        specialAtributeInputTextField.setEnabled(value);
        jenisKendaraanInputButton.setEnabled(value);
    }

    private void setComponentsCustomer(boolean value) {
        namaCustomerInputTextField.setEnabled(value);
        nomorTeleponInputTextField.setEnabled(value);
        alamatTextArea.setEnabled(value);
    }

    private void setKendaraanEditDeleteButton(boolean value) {
        barukanKendaraanButton.setEnabled(value);
        hapusKendaraanButton.setEnabled(value);
    }

    private void setEditDeleteButtonCustomer(boolean value) {
        barukanCustomerButton.setEnabled(value);
        hapusCustomerButton.setEnabled(value);
    }

    private void clearTextKendaraan() {
        idkendaraanInputTextField.setText("");
        namaKendaraanInputTextField.setText("");
        hargaKendaraanInputTextField.setText("");
        jenisKendaraanInputButton.setText("");
        SearchKendaraanInputTextField.setText("");
        specialAtributeInputTextField.setText("");
        specialAtributeInputPanelLabel.setText("");
    }

    private void clearTextCustomer() {
        namaCustomerInputTextField.setText("");
        nomorTeleponInputTextField.setText("");
        alamatTextArea.setText("");
        searchCustomerInputTextField.setText("");
    }

    private void setSpecialAtributeLabel() {
        if (jenisKendaraanInputButton.getText().equals("Mobil")) {
            specialAtributeInputPanelLabel.setText("Jenis Mesin");
        } else {
            specialAtributeInputPanelLabel.setText("Jumlah Tak");
        }
    }

    private void showKendaraan() {
        mobilTextArea.setText("List Motor: \n ============= \n" + mtrc.showStringKendaraan());
        motorTextArea.setText("List Mobil: \n ============= \n" + mblc.showStringKendaraan());
    }

    private void showCustomer() {
        customerTextArea.setText("List Customer: \n ============= \n" + cc.showAllStringCustomer());
    }

    private boolean mobilIsSelected() {
        return jenisKendaraanInputButton.getText().equals("Mobil");
    }

    private void doSearchKendaraan() {
        if (SearchKendaraanInputTextField.getText().isEmpty())
            return;
        k = kc.searchDataKendaraan(SearchKendaraanInputTextField.getText());
        if (k != null) {
            setKendaraanEditDeleteButton(true);
            idkendaraanInputTextField.setText(k.getId_kendaraan());
            namaKendaraanInputTextField.setText(k.getNama());
            hargaKendaraanInputTextField.setText(Float.toString(k.getHarga()));
            jenisKendaraanInputButton.setText(k.getJenis());
            setSpecialAtributeLabel();
            specialAtributeInputTextField.setText(k.getSpecial());
        } else {
            JOptionPane.showMessageDialog(rootPane, "NOT FOUND !!!");
        }
    }

    private void doSearchCustomer() {
        if (searchCustomerInputTextField.getText().isEmpty())
            return;
        c = cc.searchCustomerById(Integer.parseInt(searchCustomerInputTextField.getText()));
        if (c == null) {
            JOptionPane.showMessageDialog(rootPane, "NOT FOUND !!!");
            return;
        }
        setEditDeleteButtonCustomer(true);
        clearTextCustomer();
        namaCustomerInputTextField.setText(c.getNama());
        nomorTeleponInputTextField.setText(c.getAlamat());
        alamatTextArea.setText(c.getNo_telepon());
        idCustomer = c.getId_customer();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        CustomerPanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        searchCustomerInputTextField = new javax.swing.JTextField();
        searchCustomerButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        barukanCustomerButton = new javax.swing.JButton();
        hapusCustomerButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        namaCustomerInputTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nomorTeleponInputTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamatTextArea = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        customerTextArea = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        KendaraanPanel = new javax.swing.JPanel();
        SearchKendaraanInputPanel = new javax.swing.JPanel();
        SearchKendaraanInputLabel = new javax.swing.JLabel();
        SearchKendaraanInputTextField = new javax.swing.JTextField();
        SearchKendaraanInputButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        barukanKendaraanButton = new javax.swing.JButton();
        hapusKendaraanButton = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        hargaKendaraanInputTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jenisKendaraanInputButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        namaKendaraanInputTextField = new javax.swing.JTextField();
        idkendaraanInputTextField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        specialAtributeInputPanelLabel = new javax.swing.JLabel();
        specialAtributeInputTextField = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        motorTextArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        mobilTextArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(146, 127, 116));

        CustomerPanel.setBackground(new java.awt.Color(102, 102, 102));
        CustomerPanel.setForeground(new java.awt.Color(102, 102, 102));

        jLabel6.setText("Pencarian Customer");

        searchCustomerInputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchCustomerInputTextFieldKeyTyped(evt);
            }
        });

        searchCustomerButton.setText("Cari");
        searchCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCustomerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(searchCustomerInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1077, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchCustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchCustomerButton, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(searchCustomerInputTextField))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPanel10KeyTyped(evt);
            }
        });

        jButton5.setText("Tambah");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        barukanCustomerButton.setText("Barukan");
        barukanCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanCustomerButtonActionPerformed(evt);
            }
        });

        hapusCustomerButton.setText("Hapus");
        hapusCustomerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusCustomerButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Nama Customer");

        jLabel8.setText("Nomor Telepon");

        nomorTeleponInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomorTeleponInputTextFieldActionPerformed(evt);
            }
        });
        nomorTeleponInputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nomorTeleponInputTextFieldKeyTyped(evt);
            }
        });

        jLabel9.setText("Alaamt");

        alamatTextArea.setColumns(20);
        alamatTextArea.setRows(5);
        jScrollPane2.setViewportView(alamatTextArea);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barukanCustomerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapusCustomerButton))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomorTeleponInputTextField)
                    .addComponent(namaCustomerInputTextField))
                .addGap(63, 63, 63)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(barukanCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hapusCustomerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(namaCustomerInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(nomorTeleponInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        customerTextArea.setColumns(20);
        customerTextArea.setRows(5);
        jScrollPane1.setViewportView(customerTextArea);

        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CustomerPanelLayout = new javax.swing.GroupLayout(CustomerPanel);
        CustomerPanel.setLayout(CustomerPanelLayout);
        CustomerPanelLayout.setHorizontalGroup(
            CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustomerPanelLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(13, 13, 13))
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        CustomerPanelLayout.setVerticalGroup(
            CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Customer", CustomerPanel);

        KendaraanPanel.setBackground(new java.awt.Color(70, 71, 77));

        SearchKendaraanInputPanel.setBackground(new java.awt.Color(21, 21, 22));

        SearchKendaraanInputLabel.setFont(new java.awt.Font("Courier New", 0, 11)); // NOI18N
        SearchKendaraanInputLabel.setText("Pencarian Kendaraan");

        SearchKendaraanInputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SearchKendaraanInputTextFieldKeyPressed(evt);
            }
        });

        SearchKendaraanInputButton.setText("Cari");
        SearchKendaraanInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchKendaraanInputButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(91, 91, 91));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        barukanKendaraanButton.setText("Barukan");
        barukanKendaraanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barukanKendaraanButtonActionPerformed(evt);
            }
        });

        hapusKendaraanButton.setText("Hapus");
        hapusKendaraanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusKendaraanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barukanKendaraanButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hapusKendaraanButton)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(barukanKendaraanButton)
                    .addComponent(hapusKendaraanButton))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel3.setText("Harga");

        hargaKendaraanInputTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hargaKendaraanInputTextFieldKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(hargaKendaraanInputTextField))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hargaKendaraanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setText("Jenis Kendaraan");

        jenisKendaraanInputButton.setText("Mobil");
        jenisKendaraanInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisKendaraanInputButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jenisKendaraanInputButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jenisKendaraanInputButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setText("ID-Kendaraan");

        jLabel2.setText("Nama");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(namaKendaraanInputTextField)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(namaKendaraanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(idkendaraanInputTextField))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idkendaraanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        specialAtributeInputPanelLabel.setText("Jenis Mesin");

        specialAtributeInputTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                specialAtributeInputTextFieldActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(specialAtributeInputPanelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(specialAtributeInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(specialAtributeInputPanelLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specialAtributeInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        motorTextArea.setColumns(20);
        motorTextArea.setRows(5);
        jScrollPane3.setViewportView(motorTextArea);

        mobilTextArea.setColumns(20);
        mobilTextArea.setRows(5);
        jScrollPane4.setViewportView(mobilTextArea);

        javax.swing.GroupLayout SearchKendaraanInputPanelLayout = new javax.swing.GroupLayout(SearchKendaraanInputPanel);
        SearchKendaraanInputPanel.setLayout(SearchKendaraanInputPanelLayout);
        SearchKendaraanInputPanelLayout.setHorizontalGroup(
            SearchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchKendaraanInputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SearchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SearchKendaraanInputPanelLayout.createSequentialGroup()
                        .addGroup(SearchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SearchKendaraanInputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchKendaraanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(SearchKendaraanInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SearchKendaraanInputPanelLayout.createSequentialGroup()
                        .addGroup(SearchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SearchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))))
                .addContainerGap())
        );
        SearchKendaraanInputPanelLayout.setVerticalGroup(
            SearchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SearchKendaraanInputPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(SearchKendaraanInputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SearchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchKendaraanInputTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchKendaraanInputButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SearchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(SearchKendaraanInputPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        javax.swing.GroupLayout KendaraanPanelLayout = new javax.swing.GroupLayout(KendaraanPanel);
        KendaraanPanel.setLayout(KendaraanPanelLayout);
        KendaraanPanelLayout.setHorizontalGroup(
            KendaraanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        KendaraanPanelLayout.setVerticalGroup(
            KendaraanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KendaraanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SearchKendaraanInputPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Kendaraan", KendaraanPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SearchKendaraanInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchKendaraanInputButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchKendaraanInputButtonActionPerformed

    private void barukanKendaraanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanKendaraanButtonActionPerformed
        // TODO add your handling code here:
        actionKendaraan = "update";
        setComponentsKendaraan (true);
        idkendaraanInputTextField.setEnabled(false);
    }//GEN-LAST:event_barukanKendaraanButtonActionPerformed

    private void hapusKendaraanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusKendaraanButtonActionPerformed
        // TODO add your handling code here:
        int opsi = JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Hapus?", "Hapus Data", JOptionPane.YES_NO_OPTION);
        if (opsi == JOptionPane.NO_OPTION || opsi == JOptionPane.CLOSED_OPTION)
            return;
        kc.deleteDataKendaraan(idkendaraanInputTextField.getText());
        clearTextKendaraan();
        setKendaraanEditDeleteButton(false);
        setComponentsKendaraan(false);
        showKendaraan();
    }//GEN-LAST:event_hapusKendaraanButtonActionPerformed

    private void specialAtributeInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_specialAtributeInputTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_specialAtributeInputTextFieldActionPerformed

    private void searchCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCustomerButtonActionPerformed
        // TODO add your handling code here:
        doSearchCustomer();
    }//GEN-LAST:event_searchCustomerButtonActionPerformed

    private void SearchKendaraanInputTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKendaraanInputTextFieldKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyChar() == '\n') {
            doSearchKendaraan();
        }
    }//GEN-LAST:event_SearchKendaraanInputTextFieldKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        actionKendaraan = "add";
        clearTextKendaraan();
        setKendaraanEditDeleteButton(false); 
        setComponentsKendaraan(true);
        setKendaraanEditDeleteButton(false);
        idkendaraanInputTextField.setEnabled(false);
        idkendaraanInputTextField.setText(kc.generateId());
        jenisKendaraanInputButton.setText("Mobil");
        setSpecialAtributeLabel();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void hargaKendaraanInputTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hargaKendaraanInputTextFieldKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (!Character.isDigit(key) || key == '.') {
            evt.consume();
            JOptionPane.showMessageDialog(null, "Hanya bisa masukan angka !!", "Input Failure", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_hargaKendaraanInputTextFieldKeyTyped

    private void jenisKendaraanInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisKendaraanInputButtonActionPerformed
        // TODO add your handling code here:
        switch (jenisKendaraanInputButton.getText()) {
            case "Mobil":
                jenisKendaraanInputButton.setText("Motor");
                break;
            case "Motor":
                jenisKendaraanInputButton.setText("Mobil");
                break;
        }
        setSpecialAtributeLabel();
    }//GEN-LAST:event_jenisKendaraanInputButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (actionKendaraan == null)
            return;
        try {
            inputKosongKendaraanException();
            inputSpecialAtributeKendaraanException();
            int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + actionKendaraan + "?");
            if (dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION)
                return;
            switch (actionKendaraan) {
                case "add":
                    if (mobilIsSelected()) {
                        mbl = new Mobil(specialAtributeInputTextField.getText(), namaKendaraanInputTextField.getText(),
                                jenisKendaraanInputButton.getText(), Float.parseFloat(hargaKendaraanInputTextField.getText()));
                        mblc.insertDataKendaraan(mbl);
                    } else {
                        mtr = new Motor(Integer.parseInt(specialAtributeInputTextField.getText()), namaKendaraanInputTextField.getText(),
                                jenisKendaraanInputButton.getText(), Float.parseFloat(hargaKendaraanInputTextField.getText()));
                        mtrc.insertDataKendaraan(mtr);
                    }
                    clearTextKendaraan();
                    setKendaraanEditDeleteButton(false);
                    setComponentsKendaraan(false);
                    showKendaraan();
                    break;
                case "update":
                    if (mobilIsSelected()) {
                        mbl = new Mobil(specialAtributeInputTextField.getText(), idkendaraanInputTextField.getText(), namaKendaraanInputTextField.getText(),
                                jenisKendaraanInputButton.getText(), Float.parseFloat(hargaKendaraanInputTextField.getText()));
                        mblc.updateDataKendaraan(mbl);
                    } else {
                        mtr = new Motor(Integer.parseInt(specialAtributeInputTextField.getText()), idkendaraanInputTextField.getText(), namaKendaraanInputTextField.getText(),
                                jenisKendaraanInputButton.getText(), Float.parseFloat(hargaKendaraanInputTextField.getText()));
                        mtrc.updateDataKendaraan(mtr);
                    }
                    clearTextKendaraan();
                    setKendaraanEditDeleteButton(false);
                    setComponentsKendaraan(false);
                    showKendaraan();
                    break;
                default:
                    break;
            }
            actionKendaraan = null;
        } catch (InputKosongException e) {
            JOptionPane.showMessageDialog(rootPane, e.message());
        } catch (InputSpecialAtributeException e) {
            JOptionPane.showMessageDialog(rootPane, e.message(jenisKendaraanInputButton.getText()));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchCustomerInputTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchCustomerInputTextFieldKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyChar() == '\n'){ 
            doSearchCustomer();
        }
    }//GEN-LAST:event_searchCustomerInputTextFieldKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        actionCustomer = "add";
        clearTextCustomer();
        setEditDeleteButtonCustomer(true);
        setComponentsCustomer(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void barukanCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barukanCustomerButtonActionPerformed
        // TODO add your handling code here:
        actionCustomer = "update";
        setComponentsCustomer(true);
    }//GEN-LAST:event_barukanCustomerButtonActionPerformed

    private void hapusCustomerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusCustomerButtonActionPerformed
        // TODO add your handling code here:
        clearTextCustomer();
        setEditDeleteButtonCustomer(false);
        setComponentsCustomer(false);
        int opsi = JOptionPane.showConfirmDialog(rootPane, "Yakin Ingin Hapus ?", "Hapus Data", JOptionPane.YES_NO_OPTION); 
        if (opsi == JOptionPane.NO_OPTION || opsi == JOptionPane.CLOSED_OPTION) {
            idCustomer = -1;
            return;
        }
        cc.deleteDataCustomer(idCustomer);
        idCustomer = -1;
        showCustomer();
    }//GEN-LAST:event_hapusCustomerButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int dialog = JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + actionKendaraan + "?");
        if (dialog == JOptionPane.CLOSED_OPTION || dialog == JOptionPane.NO_OPTION || dialog == JOptionPane.CANCEL_OPTION)
            return;
        try {
            inputKosongCustomerException();
            noTelponException();
            if (JOptionPane.showConfirmDialog(rootPane, "yakin ingin melakukan " + actionCustomer + "?") == JOptionPane.CLOSED_OPTION)
                return;
            switch (actionCustomer) {
                case "add":
                    c = new Customer(namaCustomerInputTextField.getText(), nomorTeleponInputTextField.getText(), alamatTextArea.getText());
                    cc.insertDataCustomer(c);
                    clearTextCustomer();
                    setEditDeleteButtonCustomer(false);
                    setComponentsCustomer(false);
                    break;
                case "update":
                    c = new Customer(namaCustomerInputTextField.getText(), nomorTeleponInputTextField.getText(), alamatTextArea.getText());
                    cc.updateDataCustomer(c, idCustomer);
                    clearTextCustomer();
                    setEditDeleteButtonCustomer(false);
                    setComponentsCustomer(false);
                    break;
                default:
                    break;
            }
            showCustomer();
            actionCustomer = null;
        } catch (InputKosongException e) {
            System.out.println(e);
        } catch (NoTelponException e) {
            JOptionPane.showMessageDialog(rootPane, e.message());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jPanel10KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel10KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel10KeyTyped

    private void nomorTeleponInputTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomorTeleponInputTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomorTeleponInputTextFieldActionPerformed

    private void nomorTeleponInputTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomorTeleponInputTextFieldKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_nomorTeleponInputTextFieldKeyTyped
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CustomerPanel;
    private javax.swing.JPanel KendaraanPanel;
    private javax.swing.JButton SearchKendaraanInputButton;
    private javax.swing.JLabel SearchKendaraanInputLabel;
    private javax.swing.JPanel SearchKendaraanInputPanel;
    private javax.swing.JTextField SearchKendaraanInputTextField;
    private javax.swing.JTextArea alamatTextArea;
    private javax.swing.JButton barukanCustomerButton;
    private javax.swing.JButton barukanKendaraanButton;
    private javax.swing.JTextArea customerTextArea;
    private javax.swing.JButton hapusCustomerButton;
    private javax.swing.JButton hapusKendaraanButton;
    private javax.swing.JTextField hargaKendaraanInputTextField;
    private javax.swing.JTextField idkendaraanInputTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jenisKendaraanInputButton;
    private javax.swing.JTextArea mobilTextArea;
    private javax.swing.JTextArea motorTextArea;
    private javax.swing.JTextField namaCustomerInputTextField;
    private javax.swing.JTextField namaKendaraanInputTextField;
    private javax.swing.JTextField nomorTeleponInputTextField;
    private javax.swing.JButton searchCustomerButton;
    private javax.swing.JTextField searchCustomerInputTextField;
    private javax.swing.JLabel specialAtributeInputPanelLabel;
    private javax.swing.JTextField specialAtributeInputTextField;
    // End of variables declaration//GEN-END:variables
}
