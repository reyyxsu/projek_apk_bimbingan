/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sourcecode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import java.util.Date;
import javax.swing.table.TableModel;

/**
 *
 * @author Ariyal Zarhan
 */
public class pembayaran_pendaftar extends javax.swing.JFrame {
    Koneksi koneksi = new Koneksi();
    DefaultTableModel model = new DefaultTableModel();
    
    public void loadData()
    {
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
           try {
            String url = "jdbc:mysql://localhost:3306/databasebimbel";
            String user = "root";
            String password = "";

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
                String query = "SELECT * FROM biaya_bimbel_pendaftar";
            ResultSet rs = stmt.executeQuery(query);

            // Fetch Data
            while (rs.next()) {
                String id = rs.getString("id");
                String nama_pendaftar = rs.getString("nama_pendaftar");
                String lama_bimbingan = rs.getString("lama_bimbingan");
                String biaya_bimbingan = rs.getString("biaya_bimbingan");
                String cicilan_biaya = rs.getString("cicilan_biaya");
                String biaya_akhir = rs.getString("biaya_akhir");
                String tanggal_pendaftaran = rs.getString("tanggal_pendaftaran");
                model.addRow(new Object[]{id, nama_pendaftar, lama_bimbingan, biaya_bimbingan, cicilan_biaya, biaya_akhir, tanggal_pendaftaran});
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void autonumber()
    {
        try
        {
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM biodata_pendaftar ORDER BY id DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next())
            {
                String NoID= r.getString("id").substring(2);
                String ID = "" + (Integer.parseInt(NoID) + 1);
                String Nol = "";
                
                if(ID.length()==1)
                {
                    Nol = "00";
                }else if(ID.length()==2)
                {
                    Nol = "0";
                }else if(ID.length()==3)
                {
                    Nol = "";
                }
                
                txId3.setText("ID" + Nol + ID);
                
            }
            else
            {
                txId3.setText("ID001");
            }
            r.close();
            s.close();
        }
        catch(Exception e)
        {
            System.out.println("autonumber error");
        }
    }
    
     private void updateTime() {
        // Format tanggal dan waktu
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss");
        String currentTime = formatter.format(new Date());
        // Set teks JLabel
         txTanggal.setText(currentTime);
    }
     
      public void clear(){
        txNama3.setText("");
        txBiayaAwal.setText("");
        txCicilan.setText("");
        txBiayaAkhir.setText("");
        btnSimpan.setEnabled(true);
    }
    /**
     * Creates new form data_pendaftar
     */
    public pembayaran_pendaftar() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Pendaftar");
        model.addColumn("Lama Bimbingan");
        model.addColumn("Biaya Bimbingan");
        model.addColumn("Cicilan Biaya");
        model.addColumn("Biaya Akhir");
        model.addColumn("Tanggal Pendaftaran");
        Tabel.setModel(model);
        loadData();
        autonumber();
        txId3.setEnabled(false);
        txNama3.setEnabled(false);
        cbLama.setEnabled(false);
        txBiayaAwal.setEnabled(false);
        txCicilan.setEnabled(false);
        txBiayaAkhir.setEnabled(false);
        txTanggal.setEnabled(false);
       Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
    });
           timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        txId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txNama = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txAlamat = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txTtl = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txAgama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        btnPrint = new javax.swing.JButton();
        btnGenerate = new javax.swing.JButton();
        txCari = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txCicilan = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txId3 = new javax.swing.JTextField();
        btnJumlah = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txBiayaAwal = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txBiayaAkhir = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbLama = new javax.swing.JComboBox<>();
        txTanggal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txNama3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txArea = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jLabel7.setText("ID PENDAFTAR:");

        jLabel8.setText("NAMA PENDAFTAR:");

        txNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNamaActionPerformed(evt);
            }
        });

        jLabel9.setText("ALAMAT:");

        jLabel10.setText("TEMPAT TANGGAL LAHIR:");

        jLabel11.setText("AGAMA:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1160, 660));
        getContentPane().setLayout(null);

        Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Pendaftar", "Program Pendaftar", "Hari Bimbingan", "Jam Bimbingan", "Tanggal Pendaftaran"
            }
        ));
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 310, 1110, 260);

        btnPrint.setText("PRINT");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrint);
        btnPrint.setBounds(610, 580, 67, 25);

        btnGenerate.setText("GENERATE PRINT");
        btnGenerate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerate);
        btnGenerate.setBounds(460, 580, 133, 25);

        txCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCariActionPerformed(evt);
            }
        });
        getContentPane().add(txCari);
        txCari.setBounds(890, 10, 225, 30);

        jLabel6.setText("CICILAN BIAYA:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(80, 170, 89, 16);
        getContentPane().add(txCicilan);
        txCicilan.setBounds(210, 170, 170, 22);

        jLabel16.setText("TANGGAL & JAM:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(50, 270, 99, 16);
        getContentPane().add(txId3);
        txId3.setBounds(180, 10, 180, 30);

        btnJumlah.setText("JUMLAHKAN");
        btnJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJumlahActionPerformed(evt);
            }
        });
        getContentPane().add(btnJumlah);
        btnJumlah.setBounds(230, 200, 101, 25);

        jLabel13.setText("Rp. ");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(180, 230, 23, 16);
        getContentPane().add(txBiayaAwal);
        txBiayaAwal.setBounds(210, 138, 170, 22);

        jLabel5.setText("BIAYA AWAL BIMBINGAN:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 140, 149, 16);
        getContentPane().add(txBiayaAkhir);
        txBiayaAkhir.setBounds(210, 230, 160, 22);

        jLabel15.setText("Rp. ");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(180, 170, 23, 16);

        cbLama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Bulan", "2 Bulan", "3 Bulan", "4 Bulan", "5 Bulan", "6 Bulan", "7 Bulan", "8 Bulan", "9 Bulan", "10 Bulan", "11 Bulan", "12 Bulan" }));
        cbLama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLamaActionPerformed(evt);
            }
        });
        getContentPane().add(cbLama);
        cbLama.setBounds(180, 90, 100, 30);
        getContentPane().add(txTanggal);
        txTanggal.setBounds(160, 260, 230, 30);

        jLabel4.setText("LAMA BIMBINGAN:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(70, 100, 105, 16);

        jLabel12.setText("Rp. ");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(180, 140, 23, 16);

        jLabel14.setText("BIAYA AKHIR BIMBINGAN:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(20, 230, 146, 16);

        jLabel2.setText("ID PENDAFTAR:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(80, 20, 90, 16);

        jLabel3.setText("NAMA PENDAFTAR:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 60, 112, 16);
        getContentPane().add(txNama3);
        txNama3.setBounds(180, 50, 260, 30);

        jLabel1.setText("CARI DATA:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(810, 20, 69, 16);

        btnSimpan.setText("SIMPAN");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });
        getContentPane().add(btnSimpan);
        btnSimpan.setBounds(10, 580, 77, 25);

        btnEdit.setText("EDIT");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        getContentPane().add(btnEdit);
        btnEdit.setBounds(110, 580, 59, 25);

        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });
        getContentPane().add(btnHapus);
        btnHapus.setBounds(190, 580, 71, 25);

        btnBatal.setText("BATAL");
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });
        getContentPane().add(btnBatal);
        btnBatal.setBounds(270, 580, 69, 25);

        btnKeluar.setText("EXIT PROGRAM");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });
        getContentPane().add(btnKeluar);
        btnKeluar.setBounds(960, 580, 121, 25);

        btnPrevious.setText("PREVIOUS PROGRAM");
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrevious);
        btnPrevious.setBounds(800, 580, 153, 25);

        txArea.setColumns(20);
        txArea.setRows(5);
        txArea.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                txAreaAncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane2.setViewportView(txArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(570, 60, 520, 240);

        jLabel19.setText("PRINT PREVIEW");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(580, 40, 150, 16);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sourcecode/gif_java.gif"))); // NOI18N
        getContentPane().add(jLabel18);
        jLabel18.setBounds(0, -60, 1530, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCariActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID");
        tabel.addColumn("Nama Pendaftar");
        tabel.addColumn("Lama Bimbingan");
        tabel.addColumn("Biaya Bimbingan");
        tabel.addColumn("Cicilan Biaya");
        tabel.addColumn("Biaya Akhir");
        tabel.addColumn("Tanggal Pendaftaran");
        try{
            Connection c = Koneksi.getKoneksi();
            String sql = "Select * from biaya_bimbel_pendaftar where nama_pendaftar like '%" + txCari.getText() + "%'";
            Statement stat = c.createStatement();
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                tabel.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                });
            }
            Tabel.setModel(tabel);
            loadData();
        }catch(Exception e){
           System.out.println("Cari Data Error");
        }finally{
        }
    }//GEN-LAST:event_txCariActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        String id = txId3.getText();
        String nama_pendaftar = txNama3.getText();
        String lama_bimbingan = (String)cbLama.getSelectedItem();
        String biaya_bimbingan = txBiayaAwal.getText();
        String cicilan_biaya = txCicilan.getText();
        String biaya_akhir = txBiayaAkhir.getText();
        String tanggal_pendaftaran = txTanggal.getText();
        try
        {
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO biaya_bimbel_pendaftar VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, nama_pendaftar);
            p.setString(3, lama_bimbingan);
            p.setString(4, biaya_bimbingan);
            p.setString(5, cicilan_biaya);
            p.setString(6, biaya_akhir);
            p.setString(7, tanggal_pendaftaran);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(this, "Data Tersimpan" + "\n Mohon membawa berkas akte lahir, kartu keluarga, dan biaya cicilan saat verifikasi berkas ditempat" + "\n Mohon cek email anda secara berkala.");
            dispose();
            home FormEnam = new home();
            FormEnam.setVisible(true);
        }
        catch(SQLException e)
        {
            System.out.println("Terjadi Kesalahan");
        }
        finally
        {
            loadData();
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
         int i = Tabel.getSelectedRow();
    if (i == -1)
    {
        return;
    }
    String id = (String)model.getValueAt(i, 0);
    String nama_pendaftar = txNama3.getText();
    String lama_bimbingan = (String)cbLama.getSelectedItem();
    String biaya_bimbingan = txBiayaAwal.getText();
    String cicilan_biaya = txCicilan.getText();
    String biaya_akhir = txBiayaAkhir.getText();
    String tanggal_pendaftaran = txTanggal.getText();
    
    int question = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Diedit?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
    if(question == JOptionPane.OK_OPTION){
        try{
        Connection c = Koneksi.getKoneksi();
        String sql = "UPDATE biaya_bimbel_pendaftar SET nama_pendaftar = ?, lama_bimbingan = ?, biaya_bimbingan = ?, cicilan_biaya = ?, biaya_akhir = ?, tanggal_pendaftaran = ? WHERE id = ?";
        PreparedStatement p = c.prepareStatement(sql);
        p.setString(1, nama_pendaftar);
        p.setString(2, lama_bimbingan);
        p.setString(3, biaya_bimbingan);
        p.setString(4, cicilan_biaya);
        p.setString(5, biaya_akhir);
        p.setString(6, tanggal_pendaftaran);
        p.setString(7, id); 
        p.executeUpdate();
        p.close();
        JOptionPane.showMessageDialog(this, "Data Telah Terubah");
        btnSimpan.setEnabled(true);
    }
    catch(SQLException e)
    {
        System.out.println("Update Error: " + e.getMessage());
    }
    finally
    {
        loadData();
        autonumber();
    }
    }
    if(question == JOptionPane.CANCEL_OPTION){
        }
    }//GEN-LAST:event_btnEditActionPerformed

   
               
    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        int i = Tabel.getSelectedRow();
        if(i == -1){
            return;
        }
        
        String id = (String)model.getValueAt(i, 0);
        
        int question = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Dihapus?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(question == JOptionPane.OK_OPTION){
            try{
                Connection c = Koneksi.getKoneksi();
                String sql = "DELETE FROM biaya_bimbel_pendaftar WHERE id = ?";
                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, id);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(null, "Data Terhapus");
            }catch(SQLException e){
                System.out.println("Terjadi Kesalahan");
            }finally{
                loadData();
                autonumber();
                clear();
            }
        }
        if(question == JOptionPane.CANCEL_OPTION){
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void txNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNamaActionPerformed

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        // TODO add your handling code here:
        btnSimpan.setEnabled(false);
        int i = Tabel.getSelectedRow();
        TableModel model = Tabel.getModel();
        if (i == -1){
            return;
        }
        
        String id = (String)model.getValueAt(i, 0);
        txId3.setText(id);
        String nama_pendaftar = (String)model.getValueAt(i, 1);
        txNama3.setText(nama_pendaftar);
        String lama_bimbingan = (String)model.getValueAt(i, 2);
        cbLama.setSelectedItem(lama_bimbingan);
        String biaya_bimbingan = (String)model.getValueAt(i, 3);
        txBiayaAwal.setText(biaya_bimbingan);
        String cicilan_biaya = (String)model.getValueAt(i, 4);
        txCicilan.setText(cicilan_biaya);
        String biaya_akhir = (String)model.getValueAt(i, 5);
        txBiayaAkhir.setText(biaya_akhir);
        txNama3.setEnabled(true);
        cbLama.setEnabled(true);
        txCicilan.setEnabled(true);
    }//GEN-LAST:event_TabelMouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        clear();
        btnSimpan.setEnabled(true);
        txNama3.setEnabled(false);
        cbLama.setEnabled(false);
        txBiayaAwal.setEnabled(false);
        txCicilan.setEnabled(false);
        loadData();
        autonumber();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        dispose();
        dashboard_admin formsatu = new dashboard_admin();
        formsatu.setVisible(true);
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void cbLamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLamaActionPerformed
        // TODO add your handling code here:
        String itemSelected = (String)cbLama.getSelectedItem();
        int bayar = 100000;
        if("1 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar);
        }
        else if("2 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 2);
        }
        else if("3 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 3);
        }
        else if("4 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 4);
        }
        else if("5 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 5);
        }
        else if("6 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 6);
        }
        else if("7 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 7);
        }
        else if("8 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 8);
        }
        else if("9 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 9);
        }
        else if("10 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 10);
        }
        else if("11 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 11);
        }
        else if("12 Bulan".equals(itemSelected))
        {
            txBiayaAwal.setText("" + bayar * 12);
        }
    }//GEN-LAST:event_cbLamaActionPerformed

    private void btnJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJumlahActionPerformed
        // TODO add your handling code here:
        int a = Integer.parseInt(txBiayaAwal.getText());
        int b = Integer.parseInt(txCicilan.getText());
        if (a > b)
        {
            int hasil = a-b;
            txBiayaAkhir.setText(Integer.toString(hasil));
        }
        else if (a < b)
        {
            txBiayaAkhir.setText("LUNAS");
        }
        else if(a == b)
        {
            txBiayaAkhir.setText("LUNAS");
        }
    }//GEN-LAST:event_btnJumlahActionPerformed

    private void txAreaAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_txAreaAncestorMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_txAreaAncestorMoved

    private void btnGenerateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateActionPerformed
        // TODO add your handling code here:
        txArea.setText("===================================================\n");
        txArea.setText(txArea.getText()+"                              FORM PEMBAYARAN BIMBINGAN\n");
        txArea.setText(txArea.getText()+"ID Pendaftar: " + txId3.getText() + "\n");
        txArea.setText(txArea.getText()+"Nama Pendaftar: " + txNama3.getText() + "\n");
        txArea.setText(txArea.getText()+"Lama Bimbingan: "+ cbLama.getSelectedItem() + "\n");
        txArea.setText(txArea.getText()+"Biaya Awal Bimbingan: Rp "+txBiayaAwal.getText() + "\n");
        txArea.setText(txArea.getText()+"Biaya Cicilan Yang Dibayar: Rp " + txCicilan.getText() + "\n" );
        txArea.setText(txArea.getText()+"Biaya Akhir Cicilan: Rp " + txBiayaAkhir.getText() + "\n");
        txArea.setText(txArea.getText()+"Tanggal dan Jam Pendaftaran: "+txTanggal.getText());
        txArea.setText(txArea.getText()+"\n");
        txArea.setText(txArea.getText()+"\n");
        txArea.setText(txArea.getText()+"\n");
        txArea.setText(txArea.getText()+"Mohon membawa berkas akte lahir, kartu keluarga, dan biaya cicilan saat verifikasi." + "\n");
        txArea.setText(txArea.getText()+"Mohon cek email Anda secara berkala." + "\n");
    }//GEN-LAST:event_btnGenerateActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        // TODO add your handling code here:
        try
        {
            txArea.print();
        }
        catch (Exception e)
        {

        }
    }//GEN-LAST:event_btnPrintActionPerformed

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
            java.util.logging.Logger.getLogger(pembayaran_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembayaran_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembayaran_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembayaran_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pembayaran_pendaftar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnGenerate;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnJumlah;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cbLama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txAgama;
    private javax.swing.JTextField txAlamat;
    private javax.swing.JTextArea txArea;
    private javax.swing.JTextField txBiayaAkhir;
    public javax.swing.JTextField txBiayaAwal;
    private javax.swing.JTextField txCari;
    private javax.swing.JTextField txCicilan;
    public javax.swing.JTextField txId;
    public javax.swing.JTextField txId3;
    public javax.swing.JTextField txNama;
    public javax.swing.JTextField txNama3;
    private javax.swing.JTextField txTanggal;
    private javax.swing.JTextField txTtl;
    // End of variables declaration//GEN-END:variables
}
