/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemkampus_beta;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Fuad Hanif S
 */
public class Menu_Utama extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Utama
     */
    public Menu_Utama() {
        initComponents();
        Connection con;
        Statement stat;
        ResultSet rs;
        belumLogin();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mSistem = new javax.swing.JMenu();
        miDosen1 = new javax.swing.JMenuItem();
        miUser = new javax.swing.JMenuItem();
        miKeluar = new javax.swing.JMenuItem();
        mData = new javax.swing.JMenu();
        miDosen = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miDataMahasiswa = new javax.swing.JMenuItem();
        miMataKuliah = new javax.swing.JMenuItem();
        miJurusan = new javax.swing.JMenuItem();
        miNilai = new javax.swing.JMenuItem();
        miLokasi = new javax.swing.JMenuItem();
        mLaporan = new javax.swing.JMenu();
        miLaporanDosen = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miLaporanMahasiswa = new javax.swing.JMenuItem();
        miLaporanMataKuliah = new javax.swing.JMenuItem();
        miLaporanJurusan = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Selamat Datang Di Sistem Akademik Kampus ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 50, 423, 90);

        jLabel1.setBackground(new java.awt.Color(204, 255, 0));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STMIK NUSA MANDIRI");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(130, 130, 450, 77);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/Bg_menu.jpeg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 700, 300);

        mSistem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/user_shield_40px.png"))); // NOI18N
        mSistem.setText("Sistem");

        miDosen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/about.png"))); // NOI18N
        miDosen1.setText("Dosen");
        miDosen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDosen1ActionPerformed(evt);
            }
        });
        mSistem.add(miDosen1);

        miUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/user_50px.png"))); // NOI18N
        miUser.setText("Mahasiswa");
        miUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUserActionPerformed(evt);
            }
        });
        mSistem.add(miUser);

        miKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/exit_100px.png"))); // NOI18N
        miKeluar.setText("Keluar");
        miKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miKeluarActionPerformed(evt);
            }
        });
        mSistem.add(miKeluar);

        jMenuBar1.add(mSistem);

        mData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/Database Administrator_50px.png"))); // NOI18N
        mData.setText("Data");

        miDosen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/about.png"))); // NOI18N
        miDosen.setText("Data Dosen");
        miDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDosenActionPerformed(evt);
            }
        });
        mData.add(miDosen);
        mData.add(jSeparator1);

        miDataMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/siswa-small.png"))); // NOI18N
        miDataMahasiswa.setText("Data Mahasiswa");
        miDataMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDataMahasiswaActionPerformed(evt);
            }
        });
        mData.add(miDataMahasiswa);

        miMataKuliah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/Tugas-Jabatan-small.png"))); // NOI18N
        miMataKuliah.setText("Data Mata Kuliah");
        miMataKuliah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMataKuliahActionPerformed(evt);
            }
        });
        mData.add(miMataKuliah);

        miJurusan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/Isi-Kelas-small.png"))); // NOI18N
        miJurusan.setText("Data Jurusan");
        miJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miJurusanActionPerformed(evt);
            }
        });
        mData.add(miJurusan);

        miNilai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/report-small1.png"))); // NOI18N
        miNilai.setText("Data Nilai");
        miNilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNilaiActionPerformed(evt);
            }
        });
        mData.add(miNilai);

        miLokasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/worldwide_location_40px.png"))); // NOI18N
        miLokasi.setText("Data Lokasi");
        miLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLokasiActionPerformed(evt);
            }
        });
        mData.add(miLokasi);

        jMenuBar1.add(mData);

        mLaporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/3 - mahasiswa small.png"))); // NOI18N
        mLaporan.setText("Laporan");

        miLaporanDosen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/task_64px.png"))); // NOI18N
        miLaporanDosen.setText("Laporan Dosen");
        miLaporanDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLaporanDosenActionPerformed(evt);
            }
        });
        mLaporan.add(miLaporanDosen);
        mLaporan.add(jSeparator2);

        miLaporanMahasiswa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/Task_50px.png"))); // NOI18N
        miLaporanMahasiswa.setText("Laporan Mahasiswa");
        miLaporanMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLaporanMahasiswaActionPerformed(evt);
            }
        });
        mLaporan.add(miLaporanMahasiswa);

        miLaporanMataKuliah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/checklist_64px.png"))); // NOI18N
        miLaporanMataKuliah.setText("Laporan Mata Kuliah");
        miLaporanMataKuliah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLaporanMataKuliahActionPerformed(evt);
            }
        });
        mLaporan.add(miLaporanMataKuliah);

        miLaporanJurusan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/contract_job_48px.png"))); // NOI18N
        miLaporanJurusan.setText("Laporan Jurusan");
        miLaporanJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miLaporanJurusanActionPerformed(evt);
            }
        });
        mLaporan.add(miLaporanJurusan);

        jMenuBar1.add(mLaporan);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(717, 365));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void miKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_miKeluarActionPerformed

    private void miUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUserActionPerformed
        // TODO add your handling code here:
        new Form_Login_Mhs().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_miUserActionPerformed

    private void miDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDosenActionPerformed
        // TODO add your handling code here:
        DataDosen Dosen = new DataDosen();
        Dosen.setLocationRelativeTo(null);
        Dosen.setVisible(true);
    }//GEN-LAST:event_miDosenActionPerformed

    private void miDataMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDataMahasiswaActionPerformed
        // TODO add your handling code here:
        DataMahasiswa Mahasiswa = new DataMahasiswa();
        Mahasiswa.setLocationRelativeTo(null);
        Mahasiswa.setVisible(true);
    }//GEN-LAST:event_miDataMahasiswaActionPerformed

    private void miMataKuliahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMataKuliahActionPerformed
        // TODO add your handling code here:
        Matkul MataKuliah = new Matkul();
        MataKuliah.setLocationRelativeTo(null);
        MataKuliah.setVisible(true);
    }//GEN-LAST:event_miMataKuliahActionPerformed

    private void miJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miJurusanActionPerformed
        // TODO add your handling code here:
        Jurusan DataJurusan = new Jurusan();
        DataJurusan.setLocationRelativeTo(null);
        DataJurusan.setVisible(true);
    }//GEN-LAST:event_miJurusanActionPerformed

    private void miNilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNilaiActionPerformed
        // TODO add your handling code here:
        Nilai DataNilai = new Nilai();
        DataNilai.setLocationRelativeTo(null);
        DataNilai.setVisible(true);
    }//GEN-LAST:event_miNilaiActionPerformed

    private void miLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLokasiActionPerformed
        // TODO add your handling code here:
        Lokasi DataLokasi = new Lokasi();
        DataLokasi.setLocationRelativeTo(null);
        DataLokasi.setVisible(true);
       
    }//GEN-LAST:event_miLokasiActionPerformed

    private void miLaporanDosenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLaporanDosenActionPerformed
        // TODO add your handling code here:
        DataDosen_mhs LaporanDosen = new DataDosen_mhs();
        LaporanDosen.setLocationRelativeTo(null);
        LaporanDosen.setVisible(true);
    }//GEN-LAST:event_miLaporanDosenActionPerformed

    private void miLaporanMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLaporanMahasiswaActionPerformed
        // TODO add your handling code here:
        DataMahasiswa_mhs LaporanMahasiswa = new DataMahasiswa_mhs();
        LaporanMahasiswa.setLocationRelativeTo(null);
        LaporanMahasiswa.setVisible(true);
    }//GEN-LAST:event_miLaporanMahasiswaActionPerformed

    private void miLaporanMataKuliahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLaporanMataKuliahActionPerformed
        // TODO add your handling code here:
        Matkul_mhs LaporanMatkul = new Matkul_mhs();
        LaporanMatkul.setLocationRelativeTo(null);
        LaporanMatkul.setVisible(true);
    }//GEN-LAST:event_miLaporanMataKuliahActionPerformed

    private void miLaporanJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miLaporanJurusanActionPerformed
        // TODO add your handling code here:
        Lokasi_mhs DataLokasi = new Lokasi_mhs();
        DataLokasi.setLocationRelativeTo(null);
        DataLokasi.setVisible(true);
    }//GEN-LAST:event_miLaporanJurusanActionPerformed

    private void miDosen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDosen1ActionPerformed
        // TODO add your handling code here:
        new Form_Login_dsn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_miDosen1ActionPerformed

    
    private void belumLogin() {
        miDosen.setEnabled(false);
        miDataMahasiswa.setEnabled(false);
        miMataKuliah.setEnabled(false);
        miJurusan.setVisible(false);
        miNilai.setEnabled(false);
        miLokasi.setEnabled(false);
        miLaporanDosen.setEnabled(false);
        miLaporanMahasiswa.setEnabled(false);
        miLaporanMataKuliah.setEnabled(false);
        miLaporanJurusan.setEnabled(false);
    }
    
     private void loginDosen() {
        miDosen.setEnabled(true);
        miDataMahasiswa.setEnabled(false);
        miMataKuliah.setEnabled(true);
        miJurusan.setVisible(true);
        miNilai.setEnabled(true);
        miLokasi.setEnabled(true);
        miLaporanDosen.setEnabled(true);
        miLaporanMahasiswa.setEnabled(true);
        miLaporanMataKuliah.setEnabled(true);
        miLaporanJurusan.setEnabled(false);
     }
     
     private void loginMahasiswa() {
        mData.setEnabled(true);
        miDataMahasiswa.setEnabled(true);
        miMataKuliah.setEnabled(true);
        miJurusan.setVisible(true);
        miNilai.setEnabled(false);
        miLokasi.setEnabled(true);
        miLaporanDosen.setEnabled(false);
        miLaporanMahasiswa.setEnabled(true);
        miLaporanMataKuliah.setEnabled(true);
        miLaporanJurusan.setEnabled(true);
        }
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
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_Utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_Utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu mData;
    private javax.swing.JMenu mLaporan;
    private javax.swing.JMenu mSistem;
    private javax.swing.JMenuItem miDataMahasiswa;
    private javax.swing.JMenuItem miDosen;
    private javax.swing.JMenuItem miDosen1;
    private javax.swing.JMenuItem miJurusan;
    private javax.swing.JMenuItem miKeluar;
    private javax.swing.JMenuItem miLaporanDosen;
    private javax.swing.JMenuItem miLaporanJurusan;
    private javax.swing.JMenuItem miLaporanMahasiswa;
    private javax.swing.JMenuItem miLaporanMataKuliah;
    private javax.swing.JMenuItem miLokasi;
    private javax.swing.JMenuItem miMataKuliah;
    private javax.swing.JMenuItem miNilai;
    private javax.swing.JMenuItem miUser;
    // End of variables declaration//GEN-END:variables
}
