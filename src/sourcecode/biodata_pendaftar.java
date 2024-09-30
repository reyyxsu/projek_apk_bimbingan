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
public class biodata_pendaftar extends javax.swing.JFrame {
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
            String query = "SELECT * FROM biodata_pendaftar";
            ResultSet rs = stmt.executeQuery(query);

            // Fetch Data
            while (rs.next()) {
                String id = rs.getString("id");
                String nama_pendaftar = rs.getString("nama_pendaftar");
                String alamat = rs.getString("alamat");
                String tempat_tanggal_lahir = rs.getString("tempat_tanggal_lahir");
                String agama = rs.getString("agama");
                String jenis_kelamin = rs.getString("jenis_kelamin");
                String asal_sekolah = rs.getString("asal_sekolah");
                String kelas = rs.getString("kelas");
                String email = rs.getString("email");
                String telepon = rs.getString("telepon");
                String tanggal_pendaftaran = rs.getString("tanggal_pendaftaran");
                model.addRow(new Object[]{id, nama_pendaftar, alamat, tempat_tanggal_lahir, agama, jenis_kelamin, asal_sekolah, kelas, email, telepon, tanggal_pendaftaran});
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
                
                txId1.setText("ID" + Nol + ID);
                
            }
            else
            {
                txId1.setText("ID001");
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
        txNama1.setText("");
        txAlamat1.setText("");
        txTtl1.setText("");
        txAgama1.setText("");
        txSekolah.setText("");
        txEmail.setText("");
        txTelepon.setText("");
    }
    /**
     * Creates new form data_pendaftar
     */
    public biodata_pendaftar() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Pendaftar");
        model.addColumn("Alamat");
        model.addColumn("TTL");
        model.addColumn("Agama");
        model.addColumn("JK");
        model.addColumn("Asal Sekolah");
        model.addColumn("Kelas");
        model.addColumn("Email");
        model.addColumn("Telepon");
        model.addColumn("Tanggal Pendaftaran");
        Tabel.setModel(model);
        loadData();
        autonumber();
        txId1.setEnabled(false);
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
        txCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txId1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txNama1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txAlamat1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txTtl1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txAgama1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbKelamin = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txSekolah = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txTelepon = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txTanggal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbKelas = new javax.swing.JComboBox<>();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
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
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nama Pendaftar", "Alamat", "TTL", "Agama", "JK", "Asal Sekolah", "Kelas", "Email", "Telepon", "Tanggal Pendaftaran"
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

        txCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txCariActionPerformed(evt);
            }
        });
        getContentPane().add(txCari);
        txCari.setBounds(890, 10, 225, 30);

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

        jLabel12.setText("ID PENDAFTAR:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(60, 6, 90, 20);
        getContentPane().add(txId1);
        txId1.setBounds(160, 2, 163, 30);

        jLabel13.setText("NAMA PENDAFTAR:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(40, 36, 112, 20);

        txNama1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNama1ActionPerformed(evt);
            }
        });
        getContentPane().add(txNama1);
        txNama1.setBounds(160, 32, 407, 30);

        jLabel14.setText("ALAMAT:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(100, 66, 53, 20);
        getContentPane().add(txAlamat1);
        txAlamat1.setBounds(160, 62, 377, 30);

        jLabel15.setText("TEMPAT TANGGAL LAHIR:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 96, 149, 20);
        getContentPane().add(txTtl1);
        txTtl1.setBounds(160, 92, 289, 30);

        jLabel16.setText("AGAMA:");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(110, 126, 47, 20);
        getContentPane().add(txAgama1);
        txAgama1.setBounds(160, 122, 198, 30);

        jLabel2.setText("JENIS KELAMIN:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 156, 91, 20);

        cbKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - Laki", "Perempuan" }));
        getContentPane().add(cbKelamin);
        cbKelamin.setBounds(160, 160, 90, 20);

        jLabel3.setText("ASAL SEKOLAH:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 186, 92, 20);
        getContentPane().add(txSekolah);
        txSekolah.setBounds(160, 180, 350, 30);

        jLabel5.setText("EMAIL:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 216, 40, 20);

        txEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txEmailActionPerformed(evt);
            }
        });
        getContentPane().add(txEmail);
        txEmail.setBounds(160, 212, 340, 30);

        jLabel6.setText("NO. TELEPON:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(62, 246, 90, 20);
        getContentPane().add(txTelepon);
        txTelepon.setBounds(160, 240, 340, 30);

        jLabel17.setText("TANGGAL & JAM:");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(60, 276, 99, 20);
        getContentPane().add(txTanggal);
        txTanggal.setBounds(160, 272, 274, 30);

        jLabel4.setText("KELAS:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(520, 190, 41, 16);

        cbKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        getContentPane().add(cbKelas);
        cbKelas.setBounds(570, 190, 50, 22);

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
        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 0, 150, 300);

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
        tabel.addColumn("Alamat");
        tabel.addColumn("TTL");
        tabel.addColumn("Agama");
        tabel.addColumn("JK");
        tabel.addColumn("Asal Sekolah");
        tabel.addColumn("Kelas");
        tabel.addColumn("Email");
        tabel.addColumn("Telepon");
        tabel.addColumn("Tanggal Pendaftaran");
        try{
            Connection c = Koneksi.getKoneksi();
            String sql = "Select * from biodata_pendaftar where nama_pendaftar like '%" + txCari.getText() + "%'";
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
                    rs.getString(8),
                    rs.getString(9),
                    rs.getString(10),
                    rs.getString(11),
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
        String id = txId1.getText();
        String nama_pendaftar = txNama1.getText();
        String alamat = txAlamat1.getText();
        String tempat_tanggal_lahir = txTtl1.getText();
        String agama = txAgama1.getText();
        String jenis_kelamin = (String)cbKelamin.getSelectedItem();
        String asal_sekolah = txSekolah.getText();
        String kelas = (String)cbKelas.getSelectedItem();
        String email = txEmail.getText();
        String telepon = txTelepon.getText();
        String tanggal_pendaftaran = txTanggal.getText();
        try
        {
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO biodata_pendaftar VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, nama_pendaftar);
            p.setString(3, alamat);
            p.setString(4, tempat_tanggal_lahir);
            p.setString(5, agama);
            p.setString(6, jenis_kelamin);
            p.setString(7, asal_sekolah);
            p.setString(8, kelas);
            p.setString(9, email);
            p.setString(10, telepon);
            p.setString(11, tanggal_pendaftaran);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(this, "Pendaftaran Berhasil!!");
        }
        catch(SQLException e)
        {
            System.out.println("Terjadi Kesalahan");
        }
        finally
        {
            loadData();
            autonumber();
            clear();
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
    String nama_pendaftar = txNama1.getText();
    String alamat = txAlamat1.getText();
    String tempat_tanggal_lahir = txTtl1.getText();
    String agama = txAgama1.getText();
    String jenis_kelamin = (String)cbKelamin.getSelectedItem();
    String asal_sekolah = txSekolah.getText();
    String kelas = (String)cbKelas.getSelectedItem();
    String email = txEmail.getText();
    String telepon = txTelepon.getText();
    String tanggal_pendaftaran = txTanggal.getText();
    
    int question = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Diedit?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
    if(question == JOptionPane.OK_OPTION){
        try{
        Connection c = Koneksi.getKoneksi();
        String sql = "UPDATE biodata_pendaftar SET nama_pendaftar = ?, alamat = ?, tempat_tanggal_lahir = ?, agama = ?, jenis_kelamin = ?, asal_sekolah = ?, kelas = ?, email = ?, telepon = ?, tanggal_pendaftaran = ? WHERE id = ?";
        PreparedStatement p = c.prepareStatement(sql);
        p.setString(1, nama_pendaftar);
        p.setString(2, alamat);
        p.setString(3, tempat_tanggal_lahir);
        p.setString(4, agama);
        p.setString(5, jenis_kelamin);
        p.setString(6, asal_sekolah);
        p.setString(7, kelas);
        p.setString(8, email);
        p.setString(9, telepon);
        p.setString(10, tanggal_pendaftaran);
        p.setString(11, id); 
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
                String sql = "DELETE FROM biodata_pendaftar WHERE id = ?";
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

    private void txNama1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNama1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNama1ActionPerformed

    private void txEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txEmailActionPerformed

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        // TODO add your handling code here:
        btnSimpan.setEnabled(false);
        int i = Tabel.getSelectedRow();
        TableModel model = Tabel.getModel();
        if (i == -1){
            return;
        }
        
        String id = (String)model.getValueAt(i, 0);
        txId1.setText(id);
        String nama_pendaftar = (String)model.getValueAt(i, 1);
        txNama1.setText(nama_pendaftar);
        String alamat = (String)model.getValueAt(i, 2);
        txAlamat1.setText(alamat);
        String tempat_tanggal_lahir = (String)model.getValueAt(i, 3);
        txTtl1.setText(tempat_tanggal_lahir);
        String agama = (String)model.getValueAt(i, 4);
        txAgama1.setText(agama);
        String jenis_kelamin = (String)model.getValueAt(i, 5);
        cbKelamin.setSelectedItem(jenis_kelamin);
        String asal_sekolah= (String)model.getValueAt(i, 6);
        txSekolah.setText(asal_sekolah);
        String kelas = (String)model.getValueAt(i, 7);
        cbKelas.setSelectedItem(kelas);
        String email = (String)model.getValueAt(i, 8);
        txEmail.setText(email);
        String telepon = (String)model.getValueAt(i, 9);
        txTelepon.setText(telepon);
    }//GEN-LAST:event_TabelMouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        clear();
        btnSimpan.setEnabled(true);
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
            java.util.logging.Logger.getLogger(biodata_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(biodata_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(biodata_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(biodata_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new biodata_pendaftar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cbKelamin;
    private javax.swing.JComboBox<String> cbKelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txAgama;
    private javax.swing.JTextField txAgama1;
    private javax.swing.JTextField txAlamat;
    private javax.swing.JTextField txAlamat1;
    private javax.swing.JTextField txCari;
    private javax.swing.JTextField txEmail;
    public javax.swing.JTextField txId;
    public javax.swing.JTextField txId1;
    public javax.swing.JTextField txNama;
    public javax.swing.JTextField txNama1;
    private javax.swing.JTextField txSekolah;
    private javax.swing.JTextField txTanggal;
    private javax.swing.JTextField txTelepon;
    private javax.swing.JTextField txTtl;
    private javax.swing.JTextField txTtl1;
    // End of variables declaration//GEN-END:variables
}
