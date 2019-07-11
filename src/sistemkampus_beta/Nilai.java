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
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 *
 * @author Fuad Hanif S
 */ 
    public class Nilai extends javax.swing.JFrame {
    koneksi kon=new koneksi();
    private Object [][] datanilai=null;
    private String[]label={"No_Laporan","NIM","Nama","Mata_Kuliah","Tugas","UTS","UAS","Hitung","Keterangan"};

    /**
     * Creates new form Nilai
     */
    public Nilai() {
        initComponents();
        kon.config();
        nonaktif();
        BacaTabelNilai();
        isiNolap();
        isiNIM();
        isiMatkul();
        isiTugas();
        isiUTS();
        isiUAS();
        isiTugas();
        isiHitung();
        isiKet();
        tid_nim.setVisible(false);
        tid_matkul.setVisible(false);
    }
    
    
    void isiNIM()
    {
        try
        {
            String sql="Select *From mahasiswa";
            kon.rs=kon.st.executeQuery(sql);
                while (kon.rs.next())
                {
                    cbNIM.addItem(kon.rs.getString("NIM"));
                }
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
    
    void isiMatkul()
    {
        try
        {
            String sql="Select *From mata_kuliah";
            kon.rs=kon.st.executeQuery(sql);
                while (kon.rs.next())
                {
                    cbMatkul.addItem(kon.rs.getString("nama"));
                }
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
    
    void isiNolap(){
    try
    {
        String sql="select *from nilai";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
  
    void isiTugas(){
    try
    {
        String sql="select *from nilai";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiUTS(){
    try
    {
        String sql="select *from nilai";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
        
    void isiUAS(){
    try
    {
        String sql="select *from nilai";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiHitung(){
    try
    {
        String sql="select *from nilai";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiKet(){
    try
    {
        String sql="select *from nilai";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}

    private void BacaTabelNilai(){
    try
    {
        String sql="Select *From nilai order by no_laporan";
        kon.rs=kon.st.executeQuery(sql);
        ResultSetMetaData m=kon.rs.getMetaData();
        int kolom=m.getColumnCount();
        int baris=0;
        while(kon.rs.next())
            {
                baris=kon.rs.getRow();
            }
    datanilai=new Object[baris][kolom];
    int x=0;
    kon.rs.beforeFirst();
    while(kon.rs.next())
        {
            datanilai[x][0]=kon.rs.getString("No_Laporan");
            datanilai[x][1]=kon.rs.getString("NIM");
            datanilai[x][2]=kon.rs.getString("Nama");
            datanilai[x][3]=kon.rs.getString("Mata_Kuliah");
            datanilai[x][4]=kon.rs.getString("Tugas");
            datanilai[x][5]=kon.rs.getString("UTS");
            datanilai[x][6]=kon.rs.getString("UAS");
            datanilai[x][7]=kon.rs.getString("Hitung");
            datanilai[x][8]=kon.rs.getString("Keterangan");
            x++;
        }
    tableNilai.setModel(new DefaultTableModel(datanilai,label));
    }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null, e);
    }
    }
    
    private void BacaTabelNilai2(){
    try
    {
        String sql="select *from nilai where no_laporan like '%" +tCari.getText()+ "%' "
                    +" or nim like '%"+tCari.getText()+"%'"
                    +" or nama like '%"+tCari.getText()+"%'"
                    +" or mata_kuliah like '%"+tCari.getText()+"%'";
        kon.rs=kon.st.executeQuery(sql);
        ResultSetMetaData m=kon.rs.getMetaData();
        int kolom=m.getColumnCount();
        int baris=0;
        while(kon.rs.next())
            {
                baris=kon.rs.getRow();
            }
    datanilai=new Object[baris][kolom];
    int x=0;
    kon.rs.beforeFirst();
    while(kon.rs.next())
        {
            datanilai[x][0]=kon.rs.getString("No_Laporan");
            datanilai[x][1]=kon.rs.getString("NIM");
            datanilai[x][2]=kon.rs.getString("Nama");
            datanilai[x][3]=kon.rs.getString("Mata_Kuliah");
            datanilai[x][4]=kon.rs.getString("Tugas");
            datanilai[x][5]=kon.rs.getString("UTS");
            datanilai[x][6]=kon.rs.getString("UAS");
            datanilai[x][7]=kon.rs.getString("Hitung");
            datanilai[x][8]=kon.rs.getString("Keterangan");
            x++;
        }
    tableNilai.setModel(new DefaultTableModel(datanilai,label));
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
            String sql="Select *From mahasiswa where NIM='"+tid_nim.getText()+"'";
            kon.rs=kon.st.executeQuery(sql);
              if (kon.rs.next())
            {
                cbNIM.setSelectedItem(kon.rs.getString("NIM"));
            }
    }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
    
    void isiMatkul2()
    {
        try
        {
            String sql="Select *From mata_kuliah where nama='"+tid_matkul.getText()+"'";
            kon.rs=kon.st.executeQuery(sql);
                if (kon.rs.next())
                {
                    cbMatkul.setSelectedItem(kon.rs.getString("nama"));
                }
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }
    
    void isiNolap2(){
    try
    {
        String sql="select *from nilai where no_laporan='"+tLaporan.getText()+"'";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
   
    
    void isiTugas2(){
    try
    {
        String sql="select *from nilai where Tugas='"+tTugas.getText()+"'";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiUTS2(){
    try
    {
        String sql="select *from nilai where UTS='"+tUTS.getText()+'"';
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
        
    void isiUAS2(){
    try
    {
        String sql="select *from nilai where UAS='"+tUAS.getText()+"'";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiHitung2(){
    try
    {
        String sql="select *from nilai where Hitung='"+tHitung.getText()+"'";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    void isiKet2(){
    try
    {
        String sql="select *from nilai where keterangan='"+tKeterangan.getText()+"'";
        kon.rs=kon.st.executeQuery(sql);
    }   
    catch(SQLException e)
    {
        System.out.println("Koneksi Gagal"+ e.toString());
    }
}
    
    private void setTable(){
    int row=tableNilai.getSelectedRow();
    tLaporan.setText((String)tableNilai.getValueAt(row,0));
    tid_nim.setText((String)tableNilai.getValueAt(row,1));
    tNama.setText((String)tableNilai.getValueAt(row,2));
    tid_matkul.setText((String)tableNilai.getValueAt(row,3));
    tTugas.setText((String)tableNilai.getValueAt(row,4));
    tUTS.setText((String)tableNilai.getValueAt(row,5));
    tUAS.setText((String)tableNilai.getValueAt(row,6));
    tHitung.setText((String)tableNilai.getValueAt(row,7));
    tKeterangan.setText((String)tableNilai.getValueAt(row,8));
}
    
    private void BersihField(){
    tLaporan.setText("");
    tid_nim.setText("");
    tNama.setText("");
    tid_matkul.setText("");
    tTugas.setText("");
    tUTS.setText("");
    tUAS.setText("");
    tHitung.setText("");
    tHuruf.setText("");
    tKeterangan.setText("");
}
    
   private void aktif(){
    tLaporan.setEnabled(true);
    cbNIM.setEnabled(true);
    tNama.setEnabled(true);
    cbMatkul.setEnabled(true);
    tTugas.setEnabled(true);
    tUTS.setEnabled(true);
    tUAS.setEnabled(true);
    tHitung.setEnabled(true);
    tHuruf.setEnabled(true);
    tKeterangan.setEnabled(true);
    tCari.setEnabled(true);
    bHitung.setEnabled(true);
   }
   
   private void nonaktif(){
    tLaporan.setEnabled(false);
    tid_nim.setEnabled(false);
    tNama.setEnabled(false);
    tid_matkul.setEnabled(false);
    tTugas.setEnabled(false);
    tUTS.setEnabled(false);
    tUAS.setEnabled(false);
    tHitung.setEnabled(false);
    tHuruf.setEnabled(false);
    tKeterangan.setEnabled(false);
    bUpdate.setEnabled(false);
    bSimpan.setEnabled(false);
    bEdit.setEnabled(false);
    bHapus.setEnabled(false);
    bHitung.setEnabled(false);
    cbNIM.setEnabled(false);
    cbMatkul.setEnabled(false);
}
   
   private void SimpanData(){
    try
    {
        String sql="insert into nilai values('"+tLaporan.getText()
                +"','"+tid_nim.getText()
                +"','"+tNama.getText()
                +"','"+tid_matkul.getText()
                +"','"+tTugas.getText()
                +"','"+tUTS.getText()
                +"','"+tUAS.getText()
                +"','"+tHitung.getText()
                +"','"+tKeterangan.getText()
                +"')";
        kon.st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data berhasil disimpan");
        BersihField();
        BacaTabelNilai();
        }
    catch(SQLException e)
    {
        JOptionPane.showMessageDialog(null,e);
    }
}
   
   private void EditData(){
    try
    {
        String sql="Update nilai set no_laporan='"+tLaporan.getText()+"',NIM='"
                +tid_nim.getText()+"',Nama='"+tNama.getText()
                +"',Mata_Kuliah='"+tid_matkul.getText()
                +"',Tugas='"+tTugas.getText()+"',UTS='"
                +tUTS.getText()+"',UAS='"+tUAS.getText()
                +"',Hitung='"+tHitung.getText()
                +"',Keterangan='"+tKeterangan.getText()
                +"' where no_laporan='"+tLaporan.getText()
                +"'"; 
        kon.st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
        BersihField();
        BacaTabelNilai();
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
       String sql="Delete from nilai where no_laporan='"+tLaporan.getText()+"'";
       kon.st.executeUpdate(sql);
       JOptionPane.showMessageDialog(null,"Data berhasil dihapus");
       BersihField();
       BacaTabelNilai();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        DataNilai = new javax.swing.JLabel();
        NoLaporan = new javax.swing.JLabel();
        tLaporan = new javax.swing.JTextField();
        NIM = new javax.swing.JLabel();
        cbNIM = new javax.swing.JComboBox<>();
        Nama = new javax.swing.JLabel();
        tNama = new javax.swing.JTextField();
        MataKuliah = new javax.swing.JLabel();
        tid_nim = new javax.swing.JTextField();
        cbMatkul = new javax.swing.JComboBox<>();
        tid_matkul = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Tugas = new javax.swing.JLabel();
        tTugas = new javax.swing.JTextField();
        UTS = new javax.swing.JLabel();
        tUTS = new javax.swing.JTextField();
        UAS = new javax.swing.JLabel();
        tUAS = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        tHitung = new javax.swing.JTextField();
        Keterangan = new javax.swing.JLabel();
        tKeterangan = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        bTambah = new javax.swing.JButton();
        bSimpan = new javax.swing.JButton();
        bEdit = new javax.swing.JButton();
        bUpdate = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bHitung = new javax.swing.JButton();
        tHuruf = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableNilai = new javax.swing.JTable();
        TabelDataNilai = new javax.swing.JLabel();
        Pencarian = new javax.swing.JLabel();
        tCari = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 171, 191));
        jPanel1.setPreferredSize(new java.awt.Dimension(438, 270));

        DataNilai.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        DataNilai.setForeground(new java.awt.Color(255, 255, 255));
        DataNilai.setText("Data Nilai");

        NoLaporan.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        NoLaporan.setForeground(new java.awt.Color(255, 255, 255));
        NoLaporan.setText("No. Laporan");

        NIM.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        NIM.setForeground(new java.awt.Color(255, 255, 255));
        NIM.setText("NIM");

        cbNIM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "== Pilih NIM ==" }));
        cbNIM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNIMActionPerformed(evt);
            }
        });

        Nama.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Nama.setForeground(new java.awt.Color(255, 255, 255));
        Nama.setText("Nama ");

        MataKuliah.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        MataKuliah.setForeground(new java.awt.Color(255, 255, 255));
        MataKuliah.setText("Mata Kuliah");

        tid_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tid_nimActionPerformed(evt);
            }
        });

        cbMatkul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "==  Pilih MatKul ==" }));
        cbMatkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMatkulActionPerformed(evt);
            }
        });

        tid_matkul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tid_matkulActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DataNilai)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoLaporan)
                            .addComponent(NIM)
                            .addComponent(Nama)
                            .addComponent(MataKuliah))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tid_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tid_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataNilai)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoLaporan)
                    .addComponent(tLaporan, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NIM, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tid_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbNIM)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nama)
                    .addComponent(tNama, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MataKuliah)
                    .addComponent(cbMatkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tid_matkul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 438, -1));

        jPanel2.setBackground(new java.awt.Color(200, 237, 230));

        Tugas.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Tugas.setForeground(new java.awt.Color(102, 102, 102));
        Tugas.setText("Tugas");

        UTS.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        UTS.setForeground(new java.awt.Color(102, 102, 102));
        UTS.setText("UTS");

        UAS.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        UAS.setForeground(new java.awt.Color(102, 102, 102));
        UAS.setText("UAS");

        tHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tHitungActionPerformed(evt);
            }
        });

        Keterangan.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Keterangan.setForeground(new java.awt.Color(102, 102, 102));
        Keterangan.setText("Keterangan");

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

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

        bHitung.setText("Hitung");
        bHitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHitungActionPerformed(evt);
            }
        });

        tHuruf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tHurufActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Tugas)
                                .addComponent(UTS)
                                .addComponent(UAS))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tUAS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tUTS, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tTugas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Keterangan)
                            .addComponent(bHitung))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tHitung)
                                .addGap(5, 5, 5)
                                .addComponent(tHuruf)))))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tugas)
                            .addComponent(tTugas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UTS)
                            .addComponent(tUTS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UAS)
                            .addComponent(tUAS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tHitung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bHitung)
                            .addComponent(tHuruf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Keterangan)
                            .addComponent(tKeterangan))
                        .addGap(19, 19, 19)))
                .addGap(33, 33, 33))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bSimpan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bEdit)
                    .addComponent(bUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bBatal)
                    .addComponent(bHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, 440, 270));

        jPanel4.setBackground(new java.awt.Color(233, 235, 4));

        tableNilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Laporan", "NIM", "Nama", "Mata Kuliah", "Tugas", "UTS", "UAS", "Hitung", "Keterangan"
            }
        ));
        tableNilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNilaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableNilai);

        TabelDataNilai.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        TabelDataNilai.setForeground(new java.awt.Color(51, 51, 51));
        TabelDataNilai.setText("Tabel Data Nilai");

        Pencarian.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Pencarian.setForeground(new java.awt.Color(51, 51, 51));
        Pencarian.setText("Pencarian");

        tCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tCariKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(Pencarian)
                        .addGap(18, 18, 18)
                        .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TabelDataNilai)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(TabelDataNilai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pencarian)
                    .addComponent(tCari, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 880, 270));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/Lollipop-Android-Wallpaper-by-Puscifer911.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, -1));

        setSize(new java.awt.Dimension(986, 645));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHitungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tHitungActionPerformed

    private void tid_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tid_nimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tid_nimActionPerformed

    private void cbMatkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMatkulActionPerformed
      try
        {
            kon.config();
            String sql="Select *From mata_kuliah where nama='"+cbMatkul.getSelectedItem()+"'";
            kon.rs=kon.st.executeQuery(sql);
                if (kon.rs.next())
                {
                    tid_matkul.setText(kon.rs.getString("nama"));
                }
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    }//GEN-LAST:event_cbMatkulActionPerformed

    private void bSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSimpanActionPerformed
       if (tLaporan.getText().isEmpty() || tid_nim.getText().isEmpty() || tNama.getText().isEmpty() || tid_matkul.getText().isEmpty()|| tTugas.getText().isEmpty() || tUTS.getText().isEmpty() || tUAS.getText().isEmpty()|| tHitung.getText().isEmpty()|| tKeterangan.getText().isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Lengkapi Data", "Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
            bTambah.setEnabled(true);
        }
             else 
                    {
                        bTambah.setEnabled(true);
                        SimpanData();
                        cbNIM.setSelectedItem("== Pilih NIM==");
                        cbMatkul.setSelectedItem("== Pilih MatKul==");
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

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        // TODO add your handling code here:
       nonaktif();
        BersihField();
        bTambah.setEnabled(true);
        cbNIM.setSelectedItem("== Pilih NIM ==");
        cbMatkul.setSelectedItem("== Pilih MatKul ==");
        try     
            {
                kon.st.close();
            }   
        catch (SQLException ex) 
            {
                Logger.getLogger(DataDosen.class.getName()).log(Level.SEVERE, null, ex);
             }
    }//GEN-LAST:event_bBatalActionPerformed

    private void cbNIMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNIMActionPerformed
       try
        {
            kon.config();
            String sql="Select *From mahasiswa where NIM='"+cbNIM.getSelectedItem()+"'";
            kon.rs=kon.st.executeQuery(sql);
              if (kon.rs.next())
            {
                tid_nim.setText(kon.rs.getString("NIM"));
                tNama.setText(kon.rs.getString("Nama"));
            }
        }
        catch(SQLException e)
        {
            System.out.println("Koneksi Gagal"+ e.toString());
        }
    
         
    }//GEN-LAST:event_cbNIMActionPerformed

    private void bHitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHitungActionPerformed
        double tugas,uts,uas,nilai;
        String hasil;
        tugas=Integer.parseInt(tTugas.getText());
        uts=Integer.parseInt(tUTS.getText());
        uas=Integer.parseInt(tUAS.getText());
        nilai= (tugas*30/100)+(uts*30/100)+(uas*40/100);
        hasil=String.valueOf(nilai);
        tHitung.setText(hasil);

        if(nilai>=85){
            tHuruf.setText("A");
            tKeterangan.setText("Lulus");
        }
        else if((nilai<85) && (nilai>=70)){
            tHuruf.setText("B");
            tKeterangan.setText("Lulus");
        }
        else if((nilai<70) && (nilai>=55)){
            tHuruf.setText("C");
            tKeterangan.setText("Lulus");
        }
        else if((nilai<55) && (nilai>=40)){
            tHuruf.setText("D");
            tKeterangan.setText("Mengulang");
        }
        else if((nilai<40) && (nilai>=0)){
            tHuruf.setText("E");
            tKeterangan.setText("Tidak Lulus");
        }
        
    }//GEN-LAST:event_bHitungActionPerformed

    private void tid_matkulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tid_matkulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tid_matkulActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
    aktif();
    bBatal.setEnabled(true);
    bTambah.setEnabled(false);
    bSimpan.setEnabled(true);
    }//GEN-LAST:event_bTambahActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        BersihField();
        nonaktif();
    }//GEN-LAST:event_formWindowActivated

    private void tCariKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tCariKeyTyped
       kon.config();
       BacaTabelNilai2();
    }//GEN-LAST:event_tCariKeyTyped

    private void tableNilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNilaiMouseClicked
        setTable(); 
        bHapus.setEnabled(true);
        bEdit.setEnabled(true);
        bTambah.setEnabled(false);
    }//GEN-LAST:event_tableNilaiMouseClicked

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Anda Ingin menghapus ?","konfirmasi", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
            {
                HapusData();
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                cbNIM.setSelectedItem("== Pilih NIM ==");
                cbMatkul.setSelectedItem("== Pilih MatKul ==");
                } else {
            JOptionPane.showMessageDialog(this, "Data Batal Dihapus","Konfirmasi", JOptionPane.INFORMATION_MESSAGE);
                bTambah.setEnabled(true);
                nonaktif();
                BersihField();
                cbNIM.setSelectedItem("== Pilih NIM ==");
                cbMatkul.setSelectedItem("== Pilih MatKul ==");
                return;
            }
                formWindowActivated(null);
    }//GEN-LAST:event_bHapusActionPerformed

    private void tHurufActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tHurufActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tHurufActionPerformed

    private void bEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEditActionPerformed
        aktif();       
        bEdit.setEnabled(false);
        bUpdate.setEnabled(true);
        bBatal.setEnabled(true);
        bHapus.setEnabled(false);
        bTambah.setEnabled(true);
    }//GEN-LAST:event_bEditActionPerformed

    private void bUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUpdateActionPerformed
        bUpdate.setEnabled(false);
        bTambah.setEnabled(true);
        EditData();
        cbNIM.setSelectedItem("== Pilih NIM ==");
        cbMatkul.setSelectedItem("== Pilih MatKul ==");
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
            java.util.logging.Logger.getLogger(Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DataNilai;
    private javax.swing.JLabel Keterangan;
    private javax.swing.JLabel MataKuliah;
    private javax.swing.JLabel NIM;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel NoLaporan;
    private javax.swing.JLabel Pencarian;
    private javax.swing.JLabel TabelDataNilai;
    private javax.swing.JLabel Tugas;
    private javax.swing.JLabel UAS;
    private javax.swing.JLabel UTS;
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bEdit;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bHitung;
    private javax.swing.JButton bSimpan;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bUpdate;
    private javax.swing.JComboBox<String> cbMatkul;
    private javax.swing.JComboBox<String> cbNIM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField tCari;
    private javax.swing.JTextField tHitung;
    private javax.swing.JTextField tHuruf;
    private javax.swing.JTextField tKeterangan;
    private javax.swing.JTextField tLaporan;
    private javax.swing.JTextField tNama;
    private javax.swing.JTextField tTugas;
    private javax.swing.JTextField tUAS;
    private javax.swing.JTextField tUTS;
    private javax.swing.JTable tableNilai;
    private javax.swing.JTextField tid_matkul;
    private javax.swing.JTextField tid_nim;
    // End of variables declaration//GEN-END:variables
}
