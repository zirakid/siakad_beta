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
public class Matkul extends javax.swing.JFrame {
koneksi kon=new koneksi();
private Object [][] datamatkul=null;
private String[]label={"Kode","Nama Matkul"};

    /**
     * Creates new form Matkul
     */
    public Matkul() {
        initComponents();
        kon.config();
        BacaTabelMatkul();
        nonaktif();
        isiKode();
        isiNamaMatkul();
    }
    
    void isiKode()
{
    try
{
        String sql="select *from mata_kuliah";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiNamaMatkul()
{
    try
{
        String sql="select *from matkul";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    private void BacaTabelMatkul()
{
    try
{
    String sql="Select *From mata_kuliah order by kode_matkul";
    kon.rs=kon.st.executeQuery(sql);
    ResultSetMetaData m=kon.rs.getMetaData();
    int kolom=m.getColumnCount();
    int baris=0;
    while(kon.rs.next()){
        baris=kon.rs.getRow();
    }
    datamatkul=new Object[baris][kolom];
    int x=0;
    kon.rs.beforeFirst();
    while(kon.rs.next()){
        datamatkul[x][0]=kon.rs.getString("kode_matkul");
        datamatkul[x][1]=kon.rs.getString("nama");
        x++;
        }
    tableMatkul.setModel(new DefaultTableModel(datamatkul,label));
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    private void BacaTabelMatkul2()
{
    try
{
    String sql="select *from mata_kuliah where kode_matkul like '%" +tCari.getText()+ "%' ";
    kon.rs=kon.st.executeQuery(sql);
    ResultSetMetaData m=kon.rs.getMetaData();
    int kolom=m.getColumnCount();
    int baris=0;
    while(kon.rs.next()){
        baris=kon.rs.getRow();
    }
    datamatkul=new Object[baris][kolom];
    int x=0;
    kon.rs.beforeFirst();
    while(kon.rs.next()){
        datamatkul[x][0]=kon.rs.getString("kode_matkul");
        datamatkul[x][1]=kon.rs.getString("nama");
        x++;
        }
    tableMatkul.setModel(new DefaultTableModel( datamatkul,label));
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
        String sql="Select *From mata_kuliah where kode_matkul='"+tKode.getText()+"'";
       kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiNamaMatkul2()
{
    try
    {
        kon.config();
        String sql="Select *From mata_kuliah where nama='"+tNama.getText()+"'";
       kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    private void setTable()
{
    int row=tableMatkul.getSelectedRow();
    tKode.setText((String)tableMatkul.getValueAt(row,0));
    tNama.setText((String)tableMatkul.getValueAt(row,1));
}
    
    private void BersihField()
{
   tKode.setText(""); 
   tNama.setText("");
   tCari.setText("");
}
    
    private void aktif()
{
   tKode.setEnabled(true);
   tNama.setEnabled(true);
   tCari.setEnabled(true);
}
    
    private void nonaktif()
{
   tKode.setEnabled(true);
   tNama.setEnabled(true);
   tCari.setEnabled(true);
   bTambah.setEnabled(true);
   bUpdate.setEnabled(false);
   bSimpan.setEnabled(false);
   bBatal.setEnabled(true);
   bEdit.setEnabled(true);
   bHapus.setEnabled(true);
}

    private void SimpanData()
{
    try
    {
        String sql="insert into mata_kuliah values('"+tKode.getText()+"','"+tNama.getText()+"')";
        kon.st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        BersihField();
        BacaTabelMatkul();
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
    }
}
    
    private void EditData()
{
    try
    {
     String sql="Update mata_kuliah set kode_matkul='" +tKode   .getText()
                +"',nama='"         +tNama   .getText()
                +"' where kode_matkul='"           +tKode   .getText()+"'";
     kon.st.executeUpdate(sql);
     JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
     BersihField();
     BacaTabelMatkul();
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
       String sql="Delete from mata_kuliah where kode_matkul='"+tKode.getText()+"'";
       kon.st.executeUpdate(sql);
       JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
       BersihField();
       BacaTabelMatkul();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tKode = new javax.swing.JTextField();
        tNama = new javax.swing.JTextField();
        bTambah = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMatkul = new javax.swing.JTable();
        tCari = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(76, 193, 247));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Kode");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nama Matkul");

        tNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaActionPerformed(evt);
            }
        });

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bSimpan.setText("Simpan");
        bSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSimpanActionPerformed(evt);
            }
        });

        bEdit.setText("Edit");
        bEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEditActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bBatal.setText("Batal");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        bUpdate.setText("Update");
        bUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUpdateActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data Mata kuliah");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tKode)
                            .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(bTambah)
                                .addGap(18, 18, 18)
                                .addComponent(bSimpan)
                                .addGap(18, 18, 18)
                                .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(79, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(143, 143, 143)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bSimpan)
                    .addComponent(bEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBatal)
                    .addComponent(bUpdate)
                    .addComponent(bHapus))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jLabel5)
                    .addContainerGap(265, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 50, 420, 329);

        jPanel2.setBackground(new java.awt.Color(25, 233, 181));

        tableMatkul.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Kode", "Nama Matkul"
            }
        ));
        tableMatkul.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMatkulMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMatkul);

        tCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tCariActionPerformed(evt);
            }
        });
        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCariKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Pencarian");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Table Mata kuliah");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(460, 50, 602, 330);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/Bg_matkul.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 1100, 460);

        setSize(new java.awt.Dimension(1116, 478));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tCariActionPerformed

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
        if (tKode.getText().isEmpty() || tNama.getText().isEmpty())
            {
            JOptionPane.showMessageDialog(this, "Lengkapi Data", "Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
            bTambah.setEnabled(true);
        }
             else 
                    {
                        bTambah.setEnabled(true);
                        SimpanData();
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

    private void tCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyTyped
        // TODO add your handling code here:
        kon.config();
        BacaTabelMatkul2();
    }//GEN-LAST:event_tCariKeyTyped

    private void tableMatkulMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMatkulMouseClicked
        // TODO add your handling code here:
        setTable();
        isiKode2();
        isiNamaMatkul2();
        bHapus.setEnabled(true);
        bEdit.setEnabled(true);
        bTambah.setEnabled(false);
        bUpdate.setEnabled(false);
    }//GEN-LAST:event_tableMatkulMouseClicked

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Anda Ingin menghapus ?","konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                HapusData();
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                } else {
            JOptionPane.showMessageDialog(this, "Data Batal Dihapus","Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
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
        tKode.setEnabled(false);
    }//GEN-LAST:event_bEditActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
        bUpdate.setEnabled(false);
        bTambah.setEnabled(true);
        EditData();
    }//GEN-LAST:event_bUpdateActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        BersihField();
        nonaktif();
    }//GEN-LAST:event_formWindowActivated

    private void tNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaActionPerformed

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
            java.util.logging.Logger.getLogger(Matkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matkul.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Matkul().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tKode;
    private javax.swing.JTextField tNama;
    private javax.swing.JTable tableMatkul;
    // End of variables declaration//GEN-END:variables

    
}
