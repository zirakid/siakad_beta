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
public class Jurusan extends javax.swing.JFrame {
koneksi kon=new koneksi();
private Object [][] datajurusan=null;
private String[]label={"Kode_Jurusan","Jurusan","Gelar"};

    /**
     * Creates new form Jurusan
     */
    public Jurusan() {
        initComponents();
        kon.config();
        BacaTabelJurusan();
        nonaktif();
        isiKode();
        isiNamaJurusan();
        isiGelar();
        tgelar.setVisible(false);
    }
    
     void isiKode()
{
    try
{
        String sql="select *from jurusan";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
     
     void isiNamaJurusan()
{
    try
{
        String sql="select *from jurusan";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
     void isiGelar()
{
    try
    {
        String sql="Select *From gelar";
        kon.rs=kon.st.executeQuery(sql);
        while (kon.rs.next()){
            cbGelar.addItem(kon.rs.getString("nama_gelar"));
            }
        }catch(SQLException e){
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
     
     private void BacaTabelJurusan()
{
    try
{
    String sql="Select *From jurusan order by kode_jurusan";
    kon.rs=kon.st.executeQuery(sql);
    ResultSetMetaData m=kon.rs.getMetaData();
    int kolom=m.getColumnCount();
    int baris=0;
    while(kon.rs.next()){
        baris=kon.rs.getRow();
    }
    datajurusan=new Object[baris][kolom];
    int x=0;
    kon.rs.beforeFirst();
    while(kon.rs.next()){
        datajurusan[x][0]=kon.rs.getString("kode_jurusan");
        datajurusan[x][1]=kon.rs.getString("nama_jurusan");
        datajurusan[x][2]=kon.rs.getString("gelar");
        x++;
        }
    tableJurusan.setModel(new DefaultTableModel(datajurusan,label));
    }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
}
     
     private void BacaTabelJurusan2()
{
    try
{
    String sql="select *from jurusan where kode_jurusan like '%"    +tPencarianJurusan.getText()+ "%'"
                +"or nama_jurusan like '%"                  +tPencarianJurusan.getText()+ "%'"
                +"or gelar like '%"                         +tPencarianJurusan.getText()+ "%'";
 
    kon.rs=kon.st.executeQuery(sql);
    ResultSetMetaData m=kon.rs.getMetaData();
    int kolom=m.getColumnCount();
    int baris=0;
    while(kon.rs.next()){
        baris=kon.rs.getRow();
    }
    datajurusan=new Object[baris][kolom];
    int x=0;
    kon.rs.beforeFirst();
    while(kon.rs.next()){
        datajurusan[x][0]=kon.rs.getString("kode_jurusan");
        datajurusan[x][1]=kon.rs.getString("nama_jurusan");
        datajurusan[x][2]=kon.rs.getString("gelar");
        x++;
        }
    tableJurusan.setModel(new DefaultTableModel(datajurusan,label));
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
        String sql="Select *From jurusan where kode_jurusan='"+tKodeJurusan.getText()+"'";
       kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
     
     void isiNamaJurusan2()
{
    try
    {
        kon.config();
        String sql="Select *From jurusan where nama_jurusan='"+tNamaJurusan.getText()+"'";
       kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
     
     void isiGelar2()
{
    try
    {
        String sql="Select *From gelar where nama_gelar='"+tgelar.getText()+"'"; 
        kon.rs=kon.st.executeQuery(sql);
        if (kon.rs.next()){
            cbGelar.setSelectedItem(kon.rs.getString("nama_gelar"));
            }
        }catch(SQLException e){
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
     
     private void setTable()
{
    int row=tableJurusan.getSelectedRow();
    tKodeJurusan.setText((String)tableJurusan.getValueAt(row,0));
    tNamaJurusan.setText((String)tableJurusan.getValueAt(row,1));
    tgelar.setText((String)tableJurusan.getValueAt(row,2));
}
     
      private void BersihField()
{
   tKodeJurusan.setText(""); 
   tNamaJurusan.setText("");
   tPencarianJurusan.setText("");
}
      
      private void aktif()
{
   tKodeJurusan.setEnabled(true);
   tNamaJurusan.setEnabled(true);
   tgelar.setEnabled(false);
   tPencarianJurusan.setEnabled(true);
   cbGelar.setEnabled(true);
}
      
      private void nonaktif()
{
   tKodeJurusan.setEnabled(true);
   tNamaJurusan.setEnabled(true);
   tgelar.setEnabled(false);
   cbGelar.setEnabled(true);
   tPencarianJurusan.setEnabled(true);
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
        String sql="insert into jurusan values('"+tKodeJurusan.getText()+"','"+tNamaJurusan.getText()+"','"+tgelar.getText()+"')";
        kon.st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        BersihField();
        BacaTabelJurusan();
        }
    catch(SQLException e){
        JOptionPane.showMessageDialog(null,e);
    }
}
     
private void EditData()
{
    try
    {
     String sql="Update jurusan set kode_jurusan='" +tKodeJurusan   .getText()
                +"',nama_jurusan='"         +tNamaJurusan   .getText()
                +"',gelar       ='"         +tgelar         .getText()
                +"' where kode_jurusan='"           +tKodeJurusan   .getText()+"'";
     kon.st.executeUpdate(sql);
     JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
     BersihField();
     BacaTabelJurusan();
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
       String sql="Delete from jurusan where kode_jurusan='"+tKodeJurusan.getText()+"'";
       kon.st.executeUpdate(sql);
       JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
       BersihField();
       BacaTabelJurusan();
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
        DataJurusan = new javax.swing.JLabel();
        KodeJurusan = new javax.swing.JLabel();
        tKodeJurusan = new javax.swing.JTextField();
        NamaJurusan = new javax.swing.JLabel();
        tNamaJurusan = new javax.swing.JTextField();
        Gelar = new javax.swing.JLabel();
        cbGelar = new javax.swing.JComboBox<>();
        bTambah = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        tgelar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        TabelData = new javax.swing.JLabel();
        Pencarian = new javax.swing.JLabel();
        tPencarianJurusan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJurusan = new javax.swing.JTable();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(28, 59, 77));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        DataJurusan.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        DataJurusan.setForeground(new java.awt.Color(255, 255, 255));
        DataJurusan.setText("Data Jurusan");

        KodeJurusan.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        KodeJurusan.setForeground(new java.awt.Color(255, 255, 255));
        KodeJurusan.setText("Kode Jurusan");

        NamaJurusan.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        NamaJurusan.setForeground(new java.awt.Color(255, 255, 255));
        NamaJurusan.setText("Nama Jurusan");

        tNamaJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNamaJurusanActionPerformed(evt);
            }
        });

        Gelar.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Gelar.setForeground(new java.awt.Color(255, 255, 255));
        Gelar.setText("Gelar");

        cbGelar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "== Pilih Gelar ==" }));
        cbGelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGelarActionPerformed(evt);
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

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        tgelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tgelarActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(KodeJurusan)
                                .addGap(31, 31, 31)
                                .addComponent(tKodeJurusan))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NamaJurusan)
                                    .addComponent(Gelar))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tNamaJurusan)
                                    .addComponent(cbGelar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(DataJurusan))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tgelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bSimpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bTambah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataJurusan)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KodeJurusan)
                    .addComponent(tKodeJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NamaJurusan)
                    .addComponent(tNamaJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Gelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbGelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tgelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bEdit)
                    .addComponent(bBatal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan)
                    .addComponent(bUpdate)
                    .addComponent(bHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(30, 50, 338, 300);

        jPanel2.setBackground(new java.awt.Color(185, 230, 227));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        TabelData.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        TabelData.setText("Tabel Data Jurusan");

        Pencarian.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Pencarian.setText("Pencarian");

        tPencarianJurusan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tPencarianJurusanKeyTyped(evt);
            }
        });

        tableJurusan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Kode", "Jurusan", "Gelar"
            }
        ));
        tableJurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableJurusanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableJurusan);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TabelData)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Pencarian)
                        .addGap(18, 18, 18)
                        .addComponent(tPencarianJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TabelData)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pencarian)
                    .addComponent(tPencarianJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(380, 50, 480, 283);

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/Bg_jurusan.jpg"))); // NOI18N
        getContentPane().add(BG);
        BG.setBounds(0, 0, 900, 400);

        setSize(new java.awt.Dimension(917, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cbGelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGelarActionPerformed
        // TODO add your handling code here:
         try
        {
            kon.config();
            String sql="Select *From gelar where nama_gelar='"+cbGelar.getSelectedItem()+"'";
            kon.rs=kon.st.executeQuery(sql);
            if (kon.rs.next()){
                tgelar.setText(kon.rs.getString("nama_gelar"));
            }
            int a=1,b=1;
            if(a == 1)
            {
                
            }
            
        }
         
         catch(SQLException e){
            System.out.println("Koneksi Gagal"+ e.toString());
        }                  
    }//GEN-LAST:event_cbGelarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        BersihField();
        nonaktif();
    }//GEN-LAST:event_formWindowActivated

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
        cbGelar.setSelectedItem("=PILIH=");
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
        if (tgelar.getText().isEmpty() || tKodeJurusan.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Lengkapi Data", "Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
            bTambah.setEnabled(true);
        }
             else 
                    {
                        bTambah.setEnabled(true);
                        SimpanData();
                        cbGelar.setSelectedItem("=PILIH=");
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

    private void tPencarianJurusanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPencarianJurusanKeyTyped
        // TODO add your handling code here:
        kon.config();
        BacaTabelJurusan2();
    }//GEN-LAST:event_tPencarianJurusanKeyTyped

    private void tableJurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableJurusanMouseClicked
        // TODO add your handling code here:
        setTable();
        isiKode2();
        isiNamaJurusan2();
        isiGelar2();
        bHapus.setEnabled(true);
        bEdit.setEnabled(true);
        bTambah.setEnabled(false);
        bUpdate.setEnabled(false);
    }//GEN-LAST:event_tableJurusanMouseClicked

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Anda Ingin menghapus ?","konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                HapusData();
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                cbGelar.setSelectedItem("=PILIH=");
                } else {
            JOptionPane.showMessageDialog(this, "Data Batal Dihapus","Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                cbGelar.setSelectedItem("=PILIH=");
                return;
            }
                formWindowActivated(null);
    }//GEN-LAST:event_bHapusActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
        bEdit.setEnabled(false);
        bUpdate.setEnabled(true);
        bBatal.setEnabled(true);
        bHapus.setEnabled(false);
        bTambah.setEnabled(true);
        tKodeJurusan.setEnabled(false);
        bTambah.setEnabled(false);
        bSimpan.setEnabled(true);
    }//GEN-LAST:event_bEditActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
        bUpdate.setEnabled(false);
        bTambah.setEnabled(true);
        EditData();
        cbGelar.setSelectedItem("=PILIH=");
    }//GEN-LAST:event_bUpdateActionPerformed

    private void tgelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tgelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tgelarActionPerformed

    private void tNamaJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNamaJurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNamaJurusanActionPerformed

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
            java.util.logging.Logger.getLogger(Jurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jurusan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jurusan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel DataJurusan;
    private javax.swing.JLabel Gelar;
    private javax.swing.JLabel KodeJurusan;
    private javax.swing.JLabel NamaJurusan;
    private javax.swing.JLabel Pencarian;
    private javax.swing.JLabel TabelData;
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bUpdate;
    private javax.swing.JComboBox<String> cbGelar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tKodeJurusan;
    private javax.swing.JTextField tNamaJurusan;
    private javax.swing.JTextField tPencarianJurusan;
    private javax.swing.JTable tableJurusan;
    private javax.swing.JTextField tgelar;
    // End of variables declaration//GEN-END:variables
}
