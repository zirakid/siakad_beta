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
public class DataDosen extends javax.swing.JFrame {
koneksi kon=new koneksi();
private Object [][] datadosen=null;
private String[]label={"NIP","Nama","Jenis_Kelamin","Alamat"};


    /**
     * Creates new form DataDosen
     */
    public DataDosen() {
        initComponents();
        kon.config();
        nonaktif();
        BacaTabeldosen();
        isiNIP();
        isiNama();
        isiGender();
        isiAlamat();
        tid_kelamin.setVisible(false);
    }
    
    void isiNIP(){
    try
    {
        String sql="select *from dosen";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}

    void isiNama(){
    try
    {
        String sql="select *from dosen";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}


    void isiGender(){
    try
    {
        String sql="Select *From jenis_kelamin";
        kon.rs=kon.st.executeQuery(sql);
        while (kon.rs.next())
            {
                cbGender.addItem(kon.rs.getString("nama_gender"));
            }
    }
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}


    void isiAlamat(){
    try
    {
        String sql="select *from dosen";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    private void BacaTabeldosen(){
    try
    {
        String sql="Select *From dosen order by nip";
        kon.rs=kon.st.executeQuery(sql);
        ResultSetMetaData m=kon.rs.getMetaData();
        int kolom=m.getColumnCount();
        int baris=0;
        while(kon.rs.next())
            {
                baris=kon.rs.getRow();
            }
    datadosen=new Object[baris][kolom];
    int x=0;
    kon.rs.beforeFirst();
    while(kon.rs.next())
        {
            datadosen[x][0]=kon.rs.getString("nip");
            datadosen[x][1]=kon.rs.getString("nama");
            datadosen[x][2]=kon.rs.getString("jenis_kelamin");
            datadosen[x][3]=kon.rs.getString("alamat");
            x++;
        }
    tableDosen.setModel(new DefaultTableModel(datadosen,label));
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
}

    private void BacaTabeldosen2(){
    try
    {
        String sql="select *from dosen where nama like '%"+tCari.getText()+"%'" 
                    +" or nip like '%"+tCari.getText()+"%'" 
                    +" or jenis_kelamin like '%"+tCari.getText()+"%'"
                    +" or alamat like '%"+tCari.getText()+"%'";
        kon.rs=kon.st.executeQuery(sql);
        ResultSetMetaData m=kon.rs.getMetaData();
        int kolom=m.getColumnCount();
        int baris=0;
        while(kon.rs.next())
            {
                baris=kon.rs.getRow();
            }
        datadosen=new Object[baris][kolom];
        int x=0;
        kon.rs.beforeFirst();
        while(kon.rs.next())
            {
                datadosen[x][0]=kon.rs.getString("nip");
                datadosen[x][1]=kon.rs.getString("nama");
                datadosen[x][2]=kon.rs.getString("jenis_kelamin");
                datadosen[x][3]=kon.rs.getString("alamat");
                x++;
         }
        tableDosen.setModel(new DefaultTableModel(datadosen,label));
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
}
        
    void isiNIP2(){
    try
    {
        kon.config();
        String sql="Select *From dosen where nip='"+tNip.getText()+"'";
       kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}

    void isiNama2(){
    try
   {
       String sql="Select *From dosen where nama='"+tNama.getText()+"'"; 
       kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}

    void isiGender2(){
    try
    {
        String sql="Select *From jenis_kelamin where nama_gender='"+tid_kelamin.getText()+"'"; 
        kon.rs=kon.st.executeQuery(sql);
        if (kon.rs.next())
            {
                cbGender.setSelectedItem(kon.rs.getString("nama_gender"));
            }
    }
    catch(SQLException e)
    {
            System.out.println("Koneksi Gagal"+ e.toString());
    }
}

    void isiAlamat2(){
     try
    {
       String sql="Select *From dosen where alamat='"+tAlamat.getText()+"'"; 
       kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}

    private void setTable(){
    int row=tableDosen.getSelectedRow();
    tNip.setText((String)tableDosen.getValueAt(row,0));
    tNama.setText((String)tableDosen.getValueAt(row,1));
    tid_kelamin.setText((String)tableDosen.getValueAt(row,2));
    tAlamat.setText((String)tableDosen.getValueAt(row,3));
}

    private void BersihField(){
   tNip.setText(""); 
   tNama.setText("");
   tid_kelamin.setText("");
   tAlamat.setText("");
   tCari.setText("");
}

private void aktif(){
   tNip.setEnabled(true);
   tNama.setEnabled(true);
   tid_kelamin.setEnabled(true);
   cbGender.setEnabled(true);
   tAlamat.setEnabled(true);
   tCari.setEnabled(true);
}

private void nonaktif(){
   tNip.setEnabled(false);
   tNama.setEnabled(false);
   cbGender.setEnabled(false);
   tid_kelamin.setEnabled(false);
   tAlamat.setEnabled(false);   
   bUpdate.setEnabled(false);
   bSimpan.setEnabled(false);
   bEdit.setEnabled(false);
   bHapus.setEnabled(false);
}

    private void SimpanData(){
    try
    {
        String sql="insert into dosen values('"+tNip.getText()+"','"+tNama.getText()+"','"+tid_kelamin.getText()+"','"+tAlamat.getText()+"')";
        kon.st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        BersihField();
        BacaTabeldosen();
        }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null,e);
    }
}

    private void EditData(){
    try
    {
        String sql="Update dosen set nip='"+tNip.getText()+"',nama='"+tNama.getText()+"',jenis_kelamin='"+tid_kelamin.getText()+"',alamat='"+tAlamat.getText()+"' where nip='"+tNip.getText()+"'"; 
        kon.st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
        BersihField();
        BacaTabeldosen();
        kon.st.close();
    }
    catch(SQLException e)
    {
             JOptionPane.showMessageDialog(null,e);
    }
}

    private void HapusData(){
    try
    {
       String sql="Delete from dosen where nip='"+tNip.getText()+"'";
       kon.st.executeUpdate(sql);
       JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
       BersihField();
       BacaTabeldosen();
       kon.st.close();
    }
    catch(SQLException e)
    {
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
        tNip = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        bTambah = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        tAlamat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDosen = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        tCari = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        tid_kelamin = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(8, 126, 139));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NIP");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jenis Kelamin");

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

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

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NAMA");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Alamat");

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Data Dosen");

        jPanel2.setBackground(new java.awt.Color(131, 193, 166));

        tableDosen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIP", "Nama", "Gender", "Alamat"
            }
        ));
        tableDosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDosenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDosen);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Table Dosen");

        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCariKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Pencarian");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=PILIH=" }));
        cbGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGenderActionPerformed(evt);
            }
        });

        tid_kelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tid_kelaminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(136, 136, 136)
                        .addComponent(tNip, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(114, 114, 114)
                        .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(54, 54, 54)
                        .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(tid_kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(111, 111, 111)
                        .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(bTambah)
                        .addGap(28, 28, 28)
                        .addComponent(bSimpan)
                        .addGap(28, 28, 28)
                        .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(bUpdate)
                        .addGap(29, 29, 29)
                        .addComponent(bBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel5)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tNip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tid_kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bTambah)
                    .addComponent(bSimpan)
                    .addComponent(bEdit))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bUpdate)
                    .addComponent(bBatal)
                    .addComponent(bHapus))
                .addContainerGap(12, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1000, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/minimalist-background-uhd-8k-wallpaper3.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 440));

        setSize(new java.awt.Dimension(1014, 476));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        // TODO add your handling code here:
aktif();
bBatal.setEnabled(true);
bTambah.setEnabled(false);
bSimpan.setEnabled(true);
    }//GEN-LAST:event_bTambahActionPerformed

    private void tid_kelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tid_kelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tid_kelaminActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        BersihField();
        nonaktif();
    }//GEN-LAST:event_formWindowActivated

    private void cbGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGenderActionPerformed
        // TODO add your handling code here:
        try
        {
            kon.config();
            String sql="Select *From jenis_kelamin where nama_gender='"+cbGender.getSelectedItem()+"'";
            kon.rs=kon.st.executeQuery(sql);
            if (kon.rs.next()){
                tid_kelamin.setText(kon.rs.getString("nama_gender"));
                }
            }catch(SQLException e){
                System.out.println("Koneksi Gagal"+ e.toString());
            }
    }//GEN-LAST:event_cbGenderActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        // TODO add your handling code here:
        nonaktif();
        BersihField();
        bTambah.setEnabled(true);
        cbGender.setSelectedItem("=PILIH=");
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
        if (tid_kelamin.getText().isEmpty() || tNip.getText().isEmpty() || tAlamat.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Lengkapi Data", "Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
            bTambah.setEnabled(true);
        }
             else 
                    {
                        bTambah.setEnabled(true);
                        SimpanData();
                        cbGender.setSelectedItem("=PILIH=");
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

        kon.config();
        BacaTabeldosen2();
    }//GEN-LAST:event_tCariKeyTyped

    private void tableDosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDosenMouseClicked
        // TODO add your handling code here:
        setTable();
        bHapus.setEnabled(true);
        bEdit.setEnabled(true);
        bTambah.setEnabled(false);
        bUpdate.setEnabled(false);
    }//GEN-LAST:event_tableDosenMouseClicked

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(this, "Anda Ingin menghapus ?","konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                HapusData();
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                cbGender.setSelectedItem("=PILIH=");
                } else {
            JOptionPane.showMessageDialog(this, "Data Batal Dihapus","Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                cbGender.setSelectedItem("=PILIH=");
                return;
            }
                formWindowActivated(null);
    }//GEN-LAST:event_bHapusActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        // TODO add your handling code here:
        aktif();
        tNip.setEnabled(false);
        bEdit.setEnabled(false);
        bUpdate.setEnabled(true);
        bBatal.setEnabled(true);
        bHapus.setEnabled(false);
        bTambah.setEnabled(true);
    }//GEN-LAST:event_bEditActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        // TODO add your handling code here:
        bUpdate.setEnabled(false);
        bTambah.setEnabled(true);
        EditData();
        cbGender.setSelectedItem("=PILIH=");
    }//GEN-LAST:event_bUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(DataDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataDosen().setVisible(true);
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
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tAlamat;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNip;
    private javax.swing.JTable tableDosen;
    private javax.swing.JTextField tid_kelamin;
    // End of variables declaration//GEN-END:variables
}
