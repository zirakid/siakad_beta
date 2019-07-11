/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemkampus_beta;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import sun.misc.Cleaner;

/**
 *
 * @author Fuad Hanif S
 */
public class Lokasi extends javax.swing.JFrame {
koneksi kon=new koneksi();
private Object [][] datalokasi=null;
private String[]label={"kode","Tempat Lokasi"};



    /**
     * Creates new form Lokasi
     */
    public Lokasi() {
        initComponents();
        kon.config();
        BacaTabelLokasi();
        nonaktif();
        isiKode();
        isiTempatLokasi();
        tid_lokasi.setVisible(false);
       
    }

    
    void isiKode()
{
    try
{
        String sql="select *from lokasi";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiTempatLokasi()
{
    try
    {
        String sql="Select *From lokasi";
        kon.rs=kon.st.executeQuery(sql);
        while (kon.rs.next()){
            cbLokasi.addItem(kon.rs.getString("tempat_lokasi"));
            }
        }catch(SQLException e){
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
    
    private void BacaTabelLokasi()
{
    try
{
    String sql="Select *From lokasi order by kode_lokasi";
    kon.rs=kon.st.executeQuery(sql);
    ResultSetMetaData m=kon.rs.getMetaData();
    int kolom=m.getColumnCount();
    int baris=0;
    while(kon.rs.next()){
        baris=kon.rs.getRow();
    }
    datalokasi=new Object[baris][kolom];
    int x=0;
    kon.rs.beforeFirst();
    while(kon.rs.next()){
        datalokasi[x][0]=kon.rs.getString("kode_lokasi");
        datalokasi[x][1]=kon.rs.getString("tempat_lokasi");
        x++;
        }
    tableLokasi1.setModel(new DefaultTableModel(datalokasi,label));
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    private void BacaTabelLokasi2()
{
    try
{
    String sql="select *from lokasi where kode_lokasi like '%"   +tCari1.getText()+ "%'"
            +"OR tempat_lokasi like '%"                   +tCari1.getText()+ "%'";
    kon.rs=kon.st.executeQuery(sql);
    ResultSetMetaData m=kon.rs.getMetaData();
    int kolom=m.getColumnCount();
    int baris=0;
    while(kon.rs.next()){
        baris=kon.rs.getRow();
    }
    datalokasi=new Object[baris][kolom];
    int x=0;
    kon.rs.beforeFirst();
    while(kon.rs.next()){
        datalokasi[x][0]=kon.rs.getString("kode_lokasi");
        datalokasi[x][1]=kon.rs.getString("tempat_lokasi");
        x++;
        }
    tableLokasi1.setModel(new DefaultTableModel(datalokasi,label));
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    void isiKode2()
{
    try
    {
        kon.config();
        String sql="Select *From lokasi where kode_lokasi='"+tKode.getText()+"'";
       kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiTempatLokasi2()
{
    try
    {
        String sql="Select *From lokasi where tempat_lokasi='"+tid_lokasi.getText()+"'"; 
        kon.rs=kon.st.executeQuery(sql);
        if (kon.rs.next()){
            cbLokasi.setSelectedItem(kon.rs.getString("tempat_lokasi"));
            }
        }catch(SQLException e){
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
    
    private void setTable()
{
    int row=tableLokasi1.getSelectedRow();
    tKode.setText((String)tableLokasi1.getValueAt(row,0));
    tid_lokasi.setText((String)tableLokasi1.getValueAt(row,1));
}
    
    private void BersihField()
{
   tKode.setText(""); 
   tid_lokasi.setText("");
   tCari1.setText("");
}
    
    private void aktif()
{
   tKode.setEnabled(true);
   tid_lokasi.setEnabled(true);
   tCari1.setEnabled(true);
   cbLokasi.setEnabled(true);
}
    
    private void nonaktif()
{
   tKode.setEnabled(true);
   tid_lokasi.setEnabled(true);
   cbLokasi.setEnabled(true);
   tCari1.setEnabled(true);
   bTambah.setEnabled(true);
   bUpdate.setEnabled(true);
   bSimpan.setEnabled(false);
   bBatal.setEnabled(true);
   bEdit.setEnabled(true);
   bHapus.setEnabled(true);
}
    
    private void SimpanData()
{
    try
    {
        String sql="insert into lokasi values('"+tKode.getText()+"','"+tid_lokasi.getText()+"')";
        kon.st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        BersihField();
        BacaTabelLokasi();
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
    }
}
    
    private void EditData()
{
     try
    {
     String sql="Update lokasi set kode_lokasi='" +tKode   .getText()
                +"',tempat_lokasi='"         +tid_lokasi   .getText()
                +"' where kode_lokasi='"           +tKode   .getText()+"'";
     kon.st.executeUpdate(sql);
     JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
     BersihField();
     BacaTabelLokasi();
     kon.st.close();
    }
     catch(SQLException e){
             JOptionPane.showMessageDialog(null,e);
     }
}
    
    private void HapusData()
{
    try
    {
       String sql="Delete from lokasi where kode_lokasi='"+tKode.getText()+"'";
       kon.st.executeUpdate(sql);
       JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
       BersihField();
       BacaTabelLokasi();
       kon.st.close();
       }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tKode = new javax.swing.JTextField();
        bEdit = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bTambah = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbLokasi = new javax.swing.JComboBox<>();
        tid_lokasi = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableLokasi1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tCari1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(85, 143, 242));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tempat Lokasi");

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        bBatal.setText("Batal");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Data Lokasi");

        cbLokasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=PILIH=" }));
        cbLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLokasiActionPerformed(evt);
            }
        });

        tid_lokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tid_lokasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bTambah)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(bSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addComponent(tKode, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(cbLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tid_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(bUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tid_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bSimpan)
                    .addComponent(bEdit))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBatal)
                    .addComponent(bUpdate)
                    .addComponent(bHapus))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 50, 380, 260);

        jPanel1.setBackground(new java.awt.Color(246, 71, 71));

        tableLokasi1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode", "Tempat Lokasi"
            }
        ));
        tableLokasi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLokasi1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableLokasi1);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pencarian");

        tCari1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCari1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tCari1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(410, 50, 574, 262);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/Bg_lokasi.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1030, 360);

        setSize(new java.awt.Dimension(1046, 398));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLokasiActionPerformed
        // TODO add your handling code here:
        try
        {
            kon.config();
            String sql="Select *From lokasi where tempat_lokasi='"+cbLokasi.getSelectedItem()+"'";
            kon.rs=kon.st.executeQuery(sql);
            if (kon.rs.next()){
                tid_lokasi.setText(kon.rs.getString("tempat_lokasi"));
            }
        }catch(SQLException e){
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }//GEN-LAST:event_cbLokasiActionPerformed

    private void tid_lokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tid_lokasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tid_lokasiActionPerformed
           
    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
        aktif();
        bBatal.setEnabled(true);
        bTambah.setEnabled(false);
        bSimpan.setEnabled(true);
        
    }//GEN-LAST:event_bTambahActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        // TODO add your handling code here:
        nonaktif();
        BersihField();
        bTambah.setEnabled(true);
        cbLokasi.setSelectedItem("=PILIH=");
        try     
            {
                kon.st.close();
            }   
        catch (SQLException ex) 
            {
                Logger.getLogger(DataDosen.class.getName()).log(Level.SEVERE, null, ex);
             }
                     
    }//GEN-LAST:event_bBatalActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
        // TODO add your handling code here:
        if (tid_lokasi.getText().isEmpty() || tKode.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Lengkapi Data", "Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
            bTambah.setEnabled(true);
        }
             else 
                    {
                        bTambah.setEnabled(true);
                        SimpanData();
                        cbLokasi.setSelectedItem("=PILIH=");
        try 
            {
                 kon.st.close();
            }
        catch (SQLException ex)
            {
                 Logger.getLogger(DataDosen.class.getName()).log(Level.SEVERE, null, ex);     
            }
        }
    }//GEN-LAST:event_bSimpanActionPerformed

    private void tCari1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCari1KeyTyped
        // TODO add your handling code here:
        kon.config();
        BacaTabelLokasi2();
    }//GEN-LAST:event_tCari1KeyTyped

    private void tableLokasi1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLokasi1MouseClicked
        // TODO add your handling code here:
        setTable();
        isiKode2();
        isiTempatLokasi2();
        bHapus.setEnabled(true);
        bEdit.setEnabled(true);
        bTambah.setEnabled(false);
        bUpdate.setEnabled(false);
    }//GEN-LAST:event_tableLokasi1MouseClicked

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Anda Ingin menghapus ?","konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                HapusData();
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                cbLokasi.setSelectedItem("=PILIH=");
                } else {
            JOptionPane.showMessageDialog(this, "Data Batal Dihapus","Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                cbLokasi.setSelectedItem("=PILIH=");
                return;
            }
                formWindowActivated(null);
    }//GEN-LAST:event_bHapusActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
        aktif();
        bEdit.setEnabled(false);
        bUpdate.setEnabled(true);
        bBatal.setEnabled(true);
        bHapus.setEnabled(false);
        bTambah.setEnabled(true);
        bSimpan.setEnabled(true);
    }//GEN-LAST:event_bEditActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
        bUpdate.setEnabled(false);
        bTambah.setEnabled(true);
        EditData();
        cbLokasi.setSelectedItem("=PILIH=");
    }//GEN-LAST:event_bUpdateActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        BersihField();
        nonaktif();
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(Lokasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lokasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lokasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lokasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lokasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bUpdate;
    private javax.swing.JComboBox<String> cbLokasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tCari1;
    private javax.swing.JTextField tKode;
    private javax.swing.JTable tableLokasi1;
    private javax.swing.JTextField tid_lokasi;
    // End of variables declaration//GEN-END:variables
}
