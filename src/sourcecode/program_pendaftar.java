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
public class program_pendaftar extends javax.swing.JFrame {
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
            String query = "SELECT * FROM program_bimbel_pendaftar";
            ResultSet rs = stmt.executeQuery(query);

            // Fetch Data
            while (rs.next()) {
                String id = rs.getString("id");
                String nama_pendaftar = rs.getString("nama_pendaftar");
                String program_bimbingan = rs.getString("program_bimbingan");
                String hari_bimbingan = rs.getString("hari_bimbingan");
                String jam_bimbingan = rs.getString("jam_bimbingan");
                String tanggal_pendaftaran = rs.getString("tanggal_pendaftaran");
                model.addRow(new Object[]{id, nama_pendaftar, program_bimbingan, hari_bimbingan, jam_bimbingan, tanggal_pendaftaran});
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
                
                txId2.setText("ID" + Nol + ID);
                
            }
            else
            {
                txId2.setText("ID001");
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
        txNama2.setText("");
        btnSimpan.setEnabled(true);
    }
    /**
     * Creates new form data_pendaftar
     */
    public program_pendaftar() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Pendaftar");
        model.addColumn("Program Bimbingan");
        model.addColumn("Hari Bimbingan");
        model.addColumn("Jam Bimbingan");
        model.addColumn("Tanggal Pendaftaran");
        Tabel.setModel(model);
        loadData();
        autonumber();
        txId2.setEnabled(false);
        cbProgram.setEnabled(false);
        cbHari.setEnabled(false);
        cbJam.setEnabled(false);
        txNama2.setEnabled(false);
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
        cbJam = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbProgram = new javax.swing.JComboBox<>();
        txTanggal = new javax.swing.JTextField();
        cbHari = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txNama2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txId2 = new javax.swing.JTextField();
        txCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
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

        cbJam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "15:00 - 16:30", "17:00 - 18:30", "19:00 - 20:30" }));
        getContentPane().add(cbJam);
        cbJam.setBounds(130, 160, 150, 22);

        jLabel4.setText("PROGRAM BIMBEL:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 100, 120, 16);

        cbProgram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bahasa Inggris", "Bahasa Jepang", "Matematika" }));
        getContentPane().add(cbProgram);
        cbProgram.setBounds(130, 100, 150, 22);
        getContentPane().add(txTanggal);
        txTanggal.setBounds(130, 190, 270, 22);

        cbHari.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Senin, Kamis", "Selasa, Jum'at", "Rabu, Sabtu" }));
        getContentPane().add(cbHari);
        cbHari.setBounds(130, 130, 160, 22);

        jLabel3.setText("NAMA PENDAFTAR:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 70, 120, 16);

        jLabel12.setText("TANGGAL & JAM:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(20, 190, 110, 16);

        jLabel2.setText("ID PENDAFTAR:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 40, 100, 16);

        txNama2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txNama2ActionPerformed(evt);
            }
        });
        getContentPane().add(txNama2);
        txNama2.setBounds(130, 70, 280, 22);

        jLabel5.setText("HARI BIMBEL:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(40, 130, 90, 16);

        jLabel6.setText("JAM BIMBEL:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(50, 160, 80, 16);
        getContentPane().add(txId2);
        txId2.setBounds(130, 40, 180, 22);

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
        jPanel1.setBounds(0, 20, 130, 210);

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
        tabel.addColumn("Program Bimbingan");
        tabel.addColumn("Hari Bimbingan");
        tabel.addColumn("Jam Bimbingan");
        tabel.addColumn("Tanggal Pendaftaran");
        try{
            Connection c = Koneksi.getKoneksi();
            String sql = "Select * from program_bimbel_pendaftar where nama_pendaftar like '%" + txCari.getText() + "%'";
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
       String id = txId2.getText();
        String nama_pendaftar = txNama2.getText();
        String program_bimbingan = (String)cbProgram.getSelectedItem();
        String hari_bimbingan = (String)cbHari.getSelectedItem();
        String jam_bimbingan = (String)cbJam.getSelectedItem();
        String tanggal_pendaftaran = txTanggal.getText();
        
        try
        {
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO program_bimbel_pendaftar VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, id);
            p.setString(2, nama_pendaftar);
            p.setString(3, program_bimbingan);
            p.setString(4, hari_bimbingan);
            p.setString(5, jam_bimbingan);
            p.setString(6, tanggal_pendaftaran);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(this, "Pendaftaran Berhasil!!");
            dispose();
            FormPembayaran formdua = new FormPembayaran();
            formdua.txId3.setText(txId2.getText());
            formdua.txNama3.setText(txNama2.getText());
            formdua.setVisible(true);
            
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
    String nama_pendaftar = txNama2.getText();
    String program_bimbingan = (String)cbProgram.getSelectedItem();
    String hari_bimbingan = (String)cbHari.getSelectedItem();
    String jam_bimbingan = (String)cbJam.getSelectedItem();
    String tanggal_pendaftaran = txTanggal.getText();
    
    int question = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Diedit?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
    if(question == JOptionPane.OK_OPTION){
        try{
        Connection c = Koneksi.getKoneksi();
        String sql = "UPDATE program_bimbel_pendaftar SET nama_pendaftar = ?, program_bimbingan = ?, hari_bimbingan = ?, jam_bimbingan = ?, tanggal_pendaftaran = ? WHERE id = ?";
        PreparedStatement p = c.prepareStatement(sql);
        p.setString(1, nama_pendaftar);
        p.setString(2, program_bimbingan);
        p.setString(3, hari_bimbingan);
        p.setString(4, jam_bimbingan);
        p.setString(5, tanggal_pendaftaran);
        p.setString(6, id); 
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
                String sql = "DELETE FROM program_bimbel_pendaftar WHERE id = ?";
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
        txId2.setText(id);
        String nama_pendaftar = (String)model.getValueAt(i, 1);
        txNama2.setText(nama_pendaftar);
        String program_bimbingan = (String)model.getValueAt(i, 2);
        cbProgram.setSelectedItem(program_bimbingan);
        String hari_bimbingan = (String)model.getValueAt(i, 3);
        cbHari.setSelectedItem(hari_bimbingan);
        String jam_bimbingan = (String)model.getValueAt(i, 4);
        cbJam.setSelectedItem(jam_bimbingan);
        txNama2.setEnabled(true);
        cbHari.setEnabled(true);
        cbProgram.setEnabled(true);
        cbJam.setEnabled(true);
        
    }//GEN-LAST:event_TabelMouseClicked

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        clear();
        btnSimpan.setEnabled(true);
        cbHari.setEnabled(false);
        cbProgram.setEnabled(false);
        cbJam.setEnabled(false);
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

    private void txNama2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txNama2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txNama2ActionPerformed

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
            java.util.logging.Logger.getLogger(program_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(program_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(program_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(program_pendaftar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new program_pendaftar().setVisible(true);
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
    public javax.swing.JComboBox<String> cbHari;
    public javax.swing.JComboBox<String> cbJam;
    public javax.swing.JComboBox<String> cbProgram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField txAlamat;
    private javax.swing.JTextField txCari;
    public javax.swing.JTextField txId;
    public javax.swing.JTextField txId2;
    public javax.swing.JTextField txNama;
    public javax.swing.JTextField txNama2;
    private javax.swing.JTextField txTanggal;
    private javax.swing.JTextField txTtl;
    // End of variables declaration//GEN-END:variables
}
