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
public class DataMahasiswa extends javax.swing.JFrame {
koneksi kon=new koneksi();
private Object [][] datamahasiswa=null;
private String[]label={"NIM","Nama","Jenis_Kelamin","Alamat","No Telp","Jurusan","Lokasi"};
    /**
     * Creates new form DataMahasiswa
     */
    public DataMahasiswa() {
        initComponents();
        kon.config();
        BacaTabelMahasiswa();
        isiNIM();
        isiNama();
        isiAlamat();
        isiGender();
        isiNope();
        isiJurusan();
        isiLokasi();
        tid_kelamin.setVisible(false);
        tid_jurusan.setVisible(false);
        tid_lokasi.setVisible(false);
    }
    
    void isiNIM()
{
    try
{
        String sql="select *from mahasiswa";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiNama()
{
     try
{
        String sql="select *from mahasiswa";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiAlamat()
{
     try
{
        String sql="select *from mahasiswa";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
        
    void isiGender()
{
    try
    {
        String sql="Select *From jenis_kelamin";
        kon.rs=kon.st.executeQuery(sql);
        while (kon.rs.next()){
            cbKelamin.addItem(kon.rs.getString("nama_gender"));
            }
        }catch(SQLException e){
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
    
    void isiNope()
{
     try
{
        String sql="select *from mahasiswa";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiJurusan()
{
     try
{
        String sql="Select *From jurusan";
        kon.rs=kon.st.executeQuery(sql);
        while (kon.rs.next()){
            cbJurusan.addItem(kon.rs.getString("nama_jurusan"));
            }
        }catch(SQLException e){
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }

    
    void isiLokasi()
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
    
    private void BacaTabelMahasiswa(){
    try
    {
        String sql="Select *From mahasiswa order by nim ";
        kon.rs=kon.st.executeQuery(sql);
        ResultSetMetaData m=kon.rs.getMetaData();
        int kolom=m.getColumnCount();
        int baris=0;
        while(kon.rs.next())
            {
                baris=kon.rs.getRow();
            }
        datamahasiswa=new Object[baris][kolom];
        int x=0;
        kon.rs.beforeFirst();
        while(kon.rs.next())
        {
            datamahasiswa[x][0]=kon.rs.getString("nim");
            datamahasiswa[x][1]=kon.rs.getString("nama");
            datamahasiswa[x][2]=kon.rs.getString("jenis_kelamin");
            datamahasiswa[x][3]=kon.rs.getString("alamat");
            datamahasiswa[x][4]=kon.rs.getString("nomor_telpon");
            datamahasiswa[x][5]=kon.rs.getString("jurusan");
            datamahasiswa[x][6]=kon.rs.getString("lokasi");
            x++;
        }
        tableMahasiswa.setModel(new DefaultTableModel(datamahasiswa,label));
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
}
    private void BacaTabelMahasiswa2(){
    try
    {
        String sql="select *from mahasiswa where nama like '%" 
        +tCari.getText()+ "%' ";
        kon.rs=kon.st.executeQuery(sql);
        ResultSetMetaData m=kon.rs.getMetaData();
        int kolom=m.getColumnCount();
        int baris=0;
        while(kon.rs.next())
            {
                baris=kon.rs.getRow();
            }
        datamahasiswa=new Object[baris][kolom];
        int x=0;
        kon.rs.beforeFirst();
        while(kon.rs.next())
        {
            datamahasiswa[x][0]=kon.rs.getString("nim");
            datamahasiswa[x][1]=kon.rs.getString("nama");
            datamahasiswa[x][2]=kon.rs.getString("jenis_kelamin");
            datamahasiswa[x][3]=kon.rs.getString("alamat");
            datamahasiswa[x][4]=kon.rs.getString("nomor_telpon");
            datamahasiswa[x][5]=kon.rs.getString("jurusan");
            datamahasiswa[x][6]=kon.rs.getString("lokasi");
            x++;
        }
        tableMahasiswa.setModel(new DefaultTableModel(datamahasiswa,label));
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
}
    
    void isiNIM2()
{
    try
{
        kon.config();
        String sql="select *from mahasiswa where nim='"+tNim.getText()+"'";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiNama2()
{
     try
{
        kon.config();
        String sql="select *from mahasiswa where nama='"+tNama.getText()+"'";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
     
    void isiAlamat2()
{
     try
{
        kon.config();
        String sql="select *from mahasiswa where alamat='"+tAlamat.getText()+"'";
        kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
        
  void isiGender2()
{
    try
    {
        String sql="Select *from jenis_kelamin where nama_gender='"+tid_kelamin.getText()+"'"; 
        kon.rs=kon.st.executeQuery(sql);
        if (kon.rs.next()){
            cbKelamin.setSelectedItem(kon.rs.getString("nama_gender"));
            }
        }catch(SQLException e){
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
    
    void isiNope2()
{
     try
   {
       String sql="Select *from mahasiswa where nomor_telpon='"+tTelp.getText()+"'"; 
       kon.rs=kon.st.executeQuery(sql);
}   catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiJurusan2()
{
    try
    {
        String sql="Select *from jurusan where nama_jurusan='"+tid_jurusan.getText()+"'"; 
        kon.rs=kon.st.executeQuery(sql);
        if (kon.rs.next()){
            cbJurusan.setSelectedItem(kon.rs.getString("nama_jurusan"));
            }
        }catch(SQLException e){
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
    
    void isiLokasi2()
{
    try
    {
        String sql="Select *from lokasi where tempat_lokasi='"+tid_lokasi.getText()+"'"; 
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
    int row=tableMahasiswa.getSelectedRow();
    tNim.setText((String)tableMahasiswa.getValueAt(row,0));
    tNama.setText((String)tableMahasiswa.getValueAt(row,1));
    tid_kelamin.setText((String)tableMahasiswa.getValueAt(row,2));
    tAlamat.setText((String)tableMahasiswa.getValueAt(row,3));
    tTelp.setText((String)tableMahasiswa.getValueAt(row,4));
    tid_jurusan.setText((String)tableMahasiswa.getValueAt(row,5));
    tid_lokasi.setText((String)tableMahasiswa.getValueAt(row,6));
    
}
    
    private void BersihField(){
    tNim.setText("");
    tNama.setText("");
    tid_kelamin.setText("");
    tAlamat.setText("");
    tTelp.setText("");
    tid_jurusan.setText("");
    tid_lokasi.setText("");
}
     private void aktif(){
    tNim.setEnabled(true);
    tNama.setEnabled(true);
    tAlamat.setEnabled(true);
    cbKelamin.setEnabled(true);
    tTelp.setEnabled(true);
    cbJurusan.setEnabled(true);
    cbLokasi.setEnabled(true);
   }
     
      private void nonaktif(){
    tNim.setEnabled(false);
    tNama.setEnabled(false);
    cbKelamin.setEnabled(false);
    cbLokasi.setEnabled(false);
    cbJurusan.setEnabled(false);
    tAlamat.setEnabled(false);
    tid_kelamin.setEnabled(false);
    tTelp.setEnabled(false);
    tid_jurusan.setEnabled(false);
    tid_lokasi.setEnabled(false);
    bBatal.setEnabled(true);
    bEdit.setEnabled(false);
    bHapus.setEnabled(false);
    bSimpan.setEnabled(false);
    bUpdate.setEnabled(false);
   }
      
    private void SimpanData(){
    try
    {
        String sql="insert into mahasiswa values('"+tNim.getText()
                +"','"+tNama.getText()
                +"','"+tid_kelamin.getText()
                +"','"+tAlamat.getText()
                +"','"+tTelp.getText()
                +"','"+tid_jurusan.getText()
                +"','"+tid_lokasi.getText()
                +"')";
        kon.st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        BersihField();
        BacaTabelMahasiswa();
        }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null,e);
    }
}
      
    private void EditData(){
    try
    {
        String sql="Update mahasiswa set nim='"+tNim.getText()
                +"',nama='"+tNama.getText()
                +"',jenis_kelamin='"+tid_kelamin.getText()
                +"',alamat='"+tAlamat.getText()
                +"',nomor_telpon='"+tTelp.getText()
                +"',jurusan='"+tid_jurusan.getText()
                +"',lokasi='"+tid_lokasi.getText()
                +"' where nim='"+tNim.getText()
                +"'";

                
        kon.st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
        BersihField();
        BacaTabelMahasiswa();
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
       String sql="Delete from mahasiswa where nim='"+tNim.getText()+"'";
       kon.st.executeUpdate(sql);
       JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
       BersihField();
       BacaTabelMahasiswa();
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
        jLabel1 = new javax.swing.JLabel();
        NIM = new javax.swing.JLabel();
        tNim = new javax.swing.JTextField();
        Nama = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        Alamat = new javax.swing.JLabel();
        tAlamat = new javax.swing.JTextField();
        Jurusan = new javax.swing.JLabel();
        cbJurusan = new javax.swing.JComboBox<>();
        JenisKelamin = new javax.swing.JLabel();
        cbKelamin = new javax.swing.JComboBox<>();
        Telp = new javax.swing.JLabel();
        tTelp = new javax.swing.JTextField();
        Lokasi = new javax.swing.JLabel();
        cbLokasi = new javax.swing.JComboBox<>();
        bTambah = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        tid_kelamin = new javax.swing.JTextField();
        tid_jurusan = new javax.swing.JTextField();
        tid_lokasi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMahasiswa = new javax.swing.JTable();
        TabelDataMahasiswa = new javax.swing.JLabel();
        Pencarian = new javax.swing.JLabel();
        tCari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Mahasiswa");

        NIM.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        NIM.setForeground(new java.awt.Color(255, 255, 255));
        NIM.setText("NIM");

        tNim.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        Nama.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Nama.setForeground(new java.awt.Color(255, 255, 255));
        Nama.setText("Nama");

        tNama.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        Alamat.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Alamat.setForeground(new java.awt.Color(255, 255, 255));
        Alamat.setText("Alamat");

        tAlamat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        Jurusan.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Jurusan.setForeground(new java.awt.Color(255, 255, 255));
        Jurusan.setText("Jurusan");

        cbJurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "== Pilih Jurusan ==" }));
        cbJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJurusanActionPerformed(evt);
            }
        });

        JenisKelamin.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        JenisKelamin.setForeground(new java.awt.Color(255, 255, 255));
        JenisKelamin.setText("Jenis Kelamin");

        cbKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "== Jenis Kelamin ==" }));
        cbKelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKelaminActionPerformed(evt);
            }
        });

        Telp.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Telp.setForeground(new java.awt.Color(255, 255, 255));
        Telp.setText("No.Telp");

        tTelp.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        Lokasi.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Lokasi.setForeground(new java.awt.Color(255, 255, 255));
        Lokasi.setText("Lokasi");

        cbLokasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "== Pilih Lokasi ==" }));
        cbLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLokasiActionPerformed(evt);
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

        tid_kelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tid_kelaminActionPerformed(evt);
            }
        });

        tid_jurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tid_jurusanActionPerformed(evt);
            }
        });

        tid_lokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tid_lokasiActionPerformed(evt);
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
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NIM)
                                    .addComponent(Nama, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(86, 86, 86)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tNim, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 51, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Alamat)
                                            .addComponent(JenisKelamin)
                                            .addComponent(Telp))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tTelp)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(tAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                                    .addComponent(cbKelamin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Jurusan)
                                            .addComponent(Lokasi))
                                        .addGap(68, 68, 68)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbLokasi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbJurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tid_kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tid_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tid_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(bSimpan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bTambah, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(bHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(10, 10, 10)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(NIM)
                        .addGap(18, 18, 18)
                        .addComponent(Nama)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tNim, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Alamat)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JenisKelamin)
                            .addComponent(cbKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tid_kelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Telp)
                            .addComponent(tTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(tAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Jurusan))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tid_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lokasi)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbLokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tid_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bEdit)
                    .addComponent(bBatal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSimpan)
                    .addComponent(bUpdate)
                    .addComponent(bHapus))
                .addGap(50, 50, 50))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 510));

        jPanel2.setBackground(new java.awt.Color(249, 106, 76));

        tableMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Jenis Kelamin", "Alamat", "No. Telp", "Jurusan", "Lokasi"
            }
        ));
        tableMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMahasiswa);

        TabelDataMahasiswa.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        TabelDataMahasiswa.setForeground(new java.awt.Color(255, 255, 255));
        TabelDataMahasiswa.setText("Tabel Data Mahasiswa");

        Pencarian.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Pencarian.setForeground(new java.awt.Color(255, 255, 255));
        Pencarian.setText("Pencarian");

        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Pencarian)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TabelDataMahasiswa)
                            .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 116, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(TabelDataMahasiswa)
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Pencarian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(162, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/android_5_lollipop1.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        setSize(new java.awt.Dimension(1136, 617));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        aktif();
        bBatal.setEnabled(true);
        bTambah.setEnabled(false);
        bSimpan.setEnabled(true);
        cbKelamin.setEnabled(true);
        cbJurusan.setEnabled(true);
        cbLokasi.setEnabled(true);
    }//GEN-LAST:event_bTambahActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
         if (tNim.getText().isEmpty() || tNama.getText().isEmpty() || tAlamat.getText().isEmpty()|| tid_kelamin.getText().isEmpty() || tTelp.getText().isEmpty() || tid_jurusan.getText().isEmpty()|| tid_lokasi.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Lengkapi Data", "Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
            bTambah.setEnabled(true);
        }
             else 
                    {
                        bTambah.setEnabled(true);
                        SimpanData();
                        cbKelamin.setSelectedItem("== Jenis Kelamin==");
                        cbJurusan.setSelectedItem("== Pilih Jurusan==");
                        cbLokasi.setSelectedItem("== Pilih Lokasi==");
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

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        aktif();       
        bEdit.setEnabled(false);
        bUpdate.setEnabled(true);
        bBatal.setEnabled(true);
        bHapus.setEnabled(false);
        bTambah.setEnabled(true);
        cbKelamin.setEnabled(true);
        cbJurusan.setEnabled(true);
        cbLokasi.setEnabled(true);
    }//GEN-LAST:event_bEditActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        EditData();
        bUpdate.setEnabled(false);
        bTambah.setEnabled(true);
        cbKelamin.setSelectedItem("== Jenis Kelamin==");
        cbJurusan.setSelectedItem("== Pilih Jurusan==");
        cbLokasi.setSelectedItem("== Pilih Lokasi==");
    }//GEN-LAST:event_bUpdateActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        nonaktif();
        BersihField();
        bTambah.setEnabled(true);
        bHapus.setEnabled(true);
        cbKelamin.setSelectedItem("== Jenis Kelamin==");
        cbJurusan.setSelectedItem("== Pilih Jurusan==");
        cbLokasi.setSelectedItem("== Pilih Lokasi==");
        try     
            {
                kon.st.close();
            }   
        catch (SQLException ex) 
            {
                Logger.getLogger(DataDosen.class.getName()).log(Level.SEVERE, null, ex);
             }
    }//GEN-LAST:event_bBatalActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Anda Ingin menghapus ?","konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                HapusData();
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                cbKelamin.setSelectedItem("== Jenis Kelamin==");
                cbJurusan.setSelectedItem("== Pilih Jurusan==");
                cbLokasi.setSelectedItem("== Pilih Lokasi==");
                } 
        else {
                JOptionPane.showMessageDialog(this, "Data Batal Dihapus","Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                cbKelamin.setSelectedItem("== Jenis Kelamin==");
                cbJurusan.setSelectedItem("== Pilih Jurusan==");
                cbLokasi.setSelectedItem("== Pilih Lokasi==");
                return;
            }
                formWindowActivated(null);
                                         
    }//GEN-LAST:event_bHapusActionPerformed

    private void tid_kelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tid_kelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tid_kelaminActionPerformed

    private void tid_jurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tid_jurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tid_jurusanActionPerformed

    private void tid_lokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tid_lokasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tid_lokasiActionPerformed

    private void cbKelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKelaminActionPerformed
       try
        {
            kon.config();
            String sql="Select *From jenis_kelamin where nama_gender='"+cbKelamin.getSelectedItem()+"'";
            kon.rs=kon.st.executeQuery(sql);
                if (kon.rs.next())
                {
                    tid_kelamin.setText(kon.rs.getString("nama_gender"));
                }
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }//GEN-LAST:event_cbKelaminActionPerformed

    private void cbJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJurusanActionPerformed
       try
        {
            kon.config();
            String sql="Select *From jurusan where nama_jurusan='"+cbJurusan.getSelectedItem()+"'";
            kon.rs=kon.st.executeQuery(sql);
                if (kon.rs.next())
                {
                    tid_jurusan.setText(kon.rs.getString("nama_jurusan"));
                }
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }//GEN-LAST:event_cbJurusanActionPerformed

    private void cbLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLokasiActionPerformed
       try
        {
            kon.config();
            String sql="Select *From lokasi where tempat_lokasi='"+cbLokasi.getSelectedItem()+"'";
            kon.rs=kon.st.executeQuery(sql);
                if (kon.rs.next())
                {
                    tid_lokasi.setText(kon.rs.getString("tempat_lokasi"));
                }
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }//GEN-LAST:event_cbLokasiActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        BersihField();
        nonaktif();
    }//GEN-LAST:event_formWindowActivated

    private void tCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyTyped
        kon.config();
        BacaTabelMahasiswa2();
    }//GEN-LAST:event_tCariKeyTyped

    private void tableMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMahasiswaMouseClicked
        setTable();
        bHapus.setEnabled(true);
        bEdit.setEnabled(true);
        bTambah.setEnabled(false);
        bUpdate.setEnabled(false);
    }//GEN-LAST:event_tableMahasiswaMouseClicked

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
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DataMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JLabel JenisKelamin;
    private javax.swing.JLabel Jurusan;
    private javax.swing.JLabel Lokasi;
    private javax.swing.JLabel NIM;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel Pencarian;
    private javax.swing.JLabel TabelDataMahasiswa;
    private javax.swing.JLabel Telp;
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bUpdate;
    private javax.swing.JComboBox<String> cbJurusan;
    private javax.swing.JComboBox<String> cbKelamin;
    private javax.swing.JComboBox<String> cbLokasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tAlamat;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tNim;
    private javax.swing.JTextField tTelp;
    private javax.swing.JTable tableMahasiswa;
    private javax.swing.JTextField tid_jurusan;
    private javax.swing.JTextField tid_kelamin;
    private javax.swing.JTextField tid_lokasi;
    // End of variables declaration//GEN-END:variables
}
