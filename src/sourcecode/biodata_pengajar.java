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
public class biodata_pengajar extends javax.swing.JFrame {
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
            String query = "SELECT * FROM biodata_pengajar";
            ResultSet rs = stmt.executeQuery(query);

            // Fetch Data
            while (rs.next()) {
                String pid = rs.getString("pid");
                String nama_pengajar = rs.getString("nama_pengajar");
                String tempat_tanggal_lahir_pengajar = rs.getString("tempat_tanggal_lahir_pengajar");
                String agama_pengajar = rs.getString("agama_pengajar");
                String jenis_kelamin_pengajar = rs.getString("jenis_kelamin_pengajar");
                String alamat_pengajar = rs.getString("alamat_pengajar");
                String no_telepon_pengajar = rs.getString("no_telepon_pengajar");
                String universitas_pengajar = rs.getString("universitas_pengajar");
                String jurusan_universitas = rs.getString("jurusan_universitas");
                String lulusan_pengajar = rs.getString("lulusan_pengajar");
                String tanggal_pendaftaran = rs.getString("tanggal_pendaftaran");
                model.addRow(new Object[]{pid, nama_pengajar, tempat_tanggal_lahir_pengajar, agama_pengajar, jenis_kelamin_pengajar, alamat_pengajar, no_telepon_pengajar, universitas_pengajar, jurusan_universitas, lulusan_pengajar, tanggal_pendaftaran});
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
   private void autonumber(){
        try{
            Connection c = Koneksi.getKoneksi();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM biodata_pengajar ORDER BY pid DESC";
            ResultSet r = s.executeQuery(sql);
            if (r.next())
            {
                String NoPID= r.getString("pid").substring(3);
                String PID = "" + (Integer.parseInt(NoPID) + 1);
                String Nol = "";
                
                if(PID.length()==1)
                {
                    Nol = "00";
                }else if(PID.length()==2)
                {
                    Nol = "0";
                }else if(PID.length()==3)
                {
                    Nol = "";
                }
                
                txPid.setText("PID" + Nol + PID);
                
            }
            else
            {
                txPid.setText("PID001");
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
        txNamaPengajar.setText("");
        txTtlPengajar.setText("");
        txAgamaPengajar.setText("");
        txAlamatPengajar.setText("");
        txTeleponPengajar.setText("");
        txUniversitas.setText("");
        txJurusan.setText("");
    }
    /**
     * Creates new form data_pendaftar
     */
    public biodata_pengajar() {
        initComponents();
        this.setLocationRelativeTo(null);
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Pengajar");
        model.addColumn("TTL");
        model.addColumn("Agama");
        model.addColumn("JK");
        model.addColumn("Alamat");
        model.addColumn("Telepon");
        model.addColumn("Universitas Asal");
        model.addColumn("Jurusan Universitas");
        model.addColumn("Lulusan Pengajar");
        model.addColumn("Tanggal Pendaftaran");
        Tabel.setModel(model);
        loadData();
        autonumber();
        txPid.setEnabled(false);
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
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        txPid = new javax.swing.JTextField();
        txNamaPengajar = new javax.swing.JTextField();
        txTtlPengajar = new javax.swing.JTextField();
        txAgamaPengajar = new javax.swing.JTextField();
        cbJeniskelaminPengajar = new javax.swing.JComboBox<>();
        txAlamatPengajar = new javax.swing.JTextField();
        txTeleponPengajar = new javax.swing.JTextField();
        txUniversitas = new javax.swing.JTextField();
        txJurusan = new javax.swing.JTextField();
        cbLulusan = new javax.swing.JComboBox<>();
        txTanggal = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
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
        jScrollPane1.setBounds(20, 370, 1110, 200);

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
        getContentPane().add(txPid);
        txPid.setBounds(190, 0, 130, 30);
        getContentPane().add(txNamaPengajar);
        txNamaPengajar.setBounds(190, 32, 240, 30);
        getContentPane().add(txTtlPengajar);
        txTtlPengajar.setBounds(190, 62, 230, 30);
        getContentPane().add(txAgamaPengajar);
        txAgamaPengajar.setBounds(190, 92, 180, 30);

        cbJeniskelaminPengajar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - Laki", "Perempuan" }));
        getContentPane().add(cbJeniskelaminPengajar);
        cbJeniskelaminPengajar.setBounds(190, 122, 130, 30);
        getContentPane().add(txAlamatPengajar);
        txAlamatPengajar.setBounds(190, 152, 360, 30);
        getContentPane().add(txTeleponPengajar);
        txTeleponPengajar.setBounds(190, 182, 250, 30);
        getContentPane().add(txUniversitas);
        txUniversitas.setBounds(190, 212, 250, 30);
        getContentPane().add(txJurusan);
        txJurusan.setBounds(190, 242, 240, 30);

        cbLulusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "D4", "S1", "S2", "S3" }));
        getContentPane().add(cbLulusan);
        cbLulusan.setBounds(190, 272, 60, 30);
        getContentPane().add(txTanggal);
        txTanggal.setBounds(190, 302, 280, 30);

        jPanel1.setLayout(null);

        jLabel2.setText("ID PENGAJAR:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(300, 130, 80, 16);

        jLabel6.setText("ID PENGAJAR:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(80, 10, 90, 16);

        jLabel3.setText("NAMA PENGAJAR:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(60, 40, 102, 16);

        jLabel4.setText("TEMPAT TANGGAL LAHIR:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 70, 149, 16);

        jLabel24.setText("AGAMA:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(110, 100, 47, 16);

        jLabel5.setText("JENIS KELAMIN:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 130, 91, 16);

        jLabel19.setText("ALAMAT:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(110, 160, 53, 16);

        jLabel20.setText("NO. TELEPON:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(80, 190, 82, 16);

        jLabel21.setText("ASAL UNIVERSITAS:");
        jPanel1.add(jLabel21);
        jLabel21.setBounds(50, 220, 118, 16);

        jLabel22.setText("JURUSAN UNIVERSITAS:");
        jPanel1.add(jLabel22);
        jLabel22.setBounds(20, 250, 141, 16);

        jLabel23.setText("TINGKAT LULUSAN:");
        jPanel1.add(jLabel23);
        jLabel23.setBounds(50, 280, 112, 16);

        jLabel13.setText("TANGGAL & JAM:");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(60, 310, 99, 16);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 0, 170, 360);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sourcecode/gif_java.gif"))); // NOI18N
        getContentPane().add(jLabel18);
        jLabel18.setBounds(0, -60, 1530, 730);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txCariActionPerformed
        // TODO add your handling code here:
        DefaultTableModel tabel = new DefaultTableModel();
        tabel.addColumn("ID");
        tabel.addColumn("Nama Pengajar");
        tabel.addColumn("TTL");
        tabel.addColumn("Agama");
        tabel.addColumn("JK");
        tabel.addColumn("Alamat");
        tabel.addColumn("Telepon");
        tabel.addColumn("Universitas Asal");
        tabel.addColumn("Jurusan Universitas");
        tabel.addColumn("Lulusan Pengajar");
        tabel.addColumn("Tanggal Pendaftaran");
        try{
            Connection c = Koneksi.getKoneksi();
            String sql = "Select * from biodata_pengajar where nama_pendaftar like '%" + txCari.getText() + "%'";
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
        String pid = txPid.getText();
        String nama_pengajar = txNamaPengajar.getText();
        String tempat_tanggal_lahir_pengajar = txTtlPengajar.getText();
        String agama_pengajar = txAgamaPengajar.getText();
        String jenis_kelamin_pengajar = (String)cbJeniskelaminPengajar.getSelectedItem();
        String alamat_pengajar = txAlamatPengajar.getText();
        String no_telepon_pengajar = txTeleponPengajar.getText();
        String universitas_pengajar = txUniversitas.getText();
        String jurusan_universitas = txJurusan.getText();
        String lulusan_pengajar = (String)cbLulusan.getSelectedItem();
        String tanggal_pendaftaran = txTanggal.getText();
        try
        {
            Connection c = Koneksi.getKoneksi();
            String sql = "INSERT INTO biodata_pengajar VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, pid);
            p.setString(2, nama_pengajar);
            p.setString(3, tempat_tanggal_lahir_pengajar);
            p.setString(4, agama_pengajar);
            p.setString(5, jenis_kelamin_pengajar);
            p.setString(6, alamat_pengajar);
            p.setString(7, no_telepon_pengajar);
            p.setString(8, universitas_pengajar);
            p.setString(9, jurusan_universitas);
            p.setString(10, lulusan_pengajar);
            p.setString(11, tanggal_pendaftaran);
            p.executeUpdate();
            p.close();
            JOptionPane.showMessageDialog(this, "Data Tersimpan!!");
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
        String pid = (String)model.getValueAt(i, 0);
        String nama_pengajar = txNamaPengajar.getText();
        String tempat_tanggal_lahir_pengajar = txTtlPengajar.getText();
        String agama_pengajar = txAgamaPengajar.getText();
        String jenis_kelamin_pengajar = (String)cbJeniskelaminPengajar.getSelectedItem();
        String alamat_pengajar = txAlamatPengajar.getText();
        String no_telepon_pengajar = txTeleponPengajar.getText();
        String universitas_pengajar = txUniversitas.getText();
        String jurusan_universitas = txJurusan.getText();
        String lulusan_pengajar = (String)cbLulusan.getSelectedItem();
        String tanggal_pendaftaran = txTanggal.getText();
    
    int question = JOptionPane.showConfirmDialog(null, "Yakin Data Akan Diedit?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE);
    if(question == JOptionPane.OK_OPTION){
        try{
        Connection c = Koneksi.getKoneksi();
        String sql = "UPDATE biodata_pengajar SET nama_pengajar = ?, tempat_tanggal_lahir_pengajar = ?, agama_pengajar = ?, jenis_kelamin_pengajar = ?, alamat_pengajar = ?, no_telepon_pengajar = ?, universitas_pengajar = ?, jurusan_universitas = ?, lulusan_pengajar = ?, tanggal_pendaftaran = ? WHERE pid = ?";
        PreparedStatement p = c.prepareStatement(sql);
            p.setString(1, nama_pengajar);
            p.setString(2, tempat_tanggal_lahir_pengajar);
            p.setString(3, agama_pengajar);
            p.setString(4, jenis_kelamin_pengajar);
            p.setString(5, alamat_pengajar);
            p.setString(6, no_telepon_pengajar);
            p.setString(7, universitas_pengajar);
            p.setString(8, jurusan_universitas);
            p.setString(9, lulusan_pengajar);
            p.setString(10, tanggal_pendaftaran);
            p.setString(11, pid);
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

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        // TODO add your handling code here:
        btnSimpan.setEnabled(false);
        int i = Tabel.getSelectedRow();
        TableModel model = Tabel.getModel();
        if (i == -1){
            return;
        }
        
        String id = (String)model.getValueAt(i, 0);
        txPid.setText(id);
        String nama_pengajar = (String)model.getValueAt(i, 1);
        txNamaPengajar.setText(nama_pengajar);
        String tempat_tanggal_lahir_pengajar = (String)model.getValueAt(i, 2);
        txTtlPengajar.setText(tempat_tanggal_lahir_pengajar);
        String agama_pengajar = (String)model.getValueAt(i, 3);
        txAgamaPengajar.setText(agama_pengajar);
        String jenis_kelamin_pengajar = (String)model.getValueAt(i, 4);
        cbJeniskelaminPengajar.setSelectedItem(jenis_kelamin_pengajar);
        String alamat_pengajar = (String)model.getValueAt(i, 5);
        txAlamatPengajar.setText(alamat_pengajar);
        String no_telepon_pengajar = (String)model.getValueAt(i, 6);
        txTeleponPengajar.setText(no_telepon_pengajar);
        String universitas_pengajar = (String)model.getValueAt(i, 7);
        txUniversitas.setText(universitas_pengajar);
        String jurusan_universitas = (String)model.getValueAt(i, 8);
        txJurusan.setText(jurusan_universitas);
        String lulusan_pengajar = (String)model.getValueAt(i, 9);
        cbLulusan.setSelectedItem(lulusan_pengajar);
        String tanggal_pendaftaran = (String)model.getValueAt(i, 10);
        txTanggal.setText(tanggal_pendaftaran);
        
        
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
            java.util.logging.Logger.getLogger(biodata_pengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(biodata_pengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(biodata_pengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(biodata_pengajar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new biodata_pengajar().setVisible(true);
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
    private javax.swing.JComboBox<String> cbJeniskelaminPengajar;
    private javax.swing.JComboBox<String> cbLulusan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JTextField txAgamaPengajar;
    private javax.swing.JTextField txAlamat;
    private javax.swing.JTextField txAlamatPengajar;
    private javax.swing.JTextField txCari;
    public javax.swing.JTextField txId;
    private javax.swing.JTextField txJurusan;
    public javax.swing.JTextField txNama;
    private javax.swing.JTextField txNamaPengajar;
    private javax.swing.JTextField txPid;
    private javax.swing.JTextField txTanggal;
    private javax.swing.JTextField txTeleponPengajar;
    private javax.swing.JTextField txTtl;
    private javax.swing.JTextField txTtlPengajar;
    private javax.swing.JTextField txUniversitas;
    // End of variables declaration//GEN-END:variables
}
