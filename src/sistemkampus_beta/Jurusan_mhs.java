/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemkampus_beta;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fuad Hanif S
 */
public class Jurusan_mhs extends javax.swing.JFrame {
koneksi kon=new koneksi();
private Object [][] datajurusan=null;
private String[]label={"Kode_Jurusan","Jurusan","Gelar"};

    /**
     * Creates new form Jurusan_mhs
     */
    public Jurusan_mhs() {
        initComponents();
        kon.config();
        BacaTabelJurusan();
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        TabelData = new javax.swing.JLabel();
        Pencarian = new javax.swing.JLabel();
        tPencarianJurusan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableJurusan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(28, 61, 78));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        TabelData.setFont(new java.awt.Font("Comic Sans MS", 1, 36)); // NOI18N
        TabelData.setForeground(new java.awt.Color(255, 255, 255));
        TabelData.setText("Tabel Data Jurusan");

        Pencarian.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        Pencarian.setForeground(new java.awt.Color(255, 255, 255));
        Pencarian.setText("Pencarian");

        tPencarianJurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tPencarianJurusanActionPerformed(evt);
            }
        });
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
                {null, null, null}
            },
            new String [] {
                "Kode", "Jurusan", "Gelar"
            }
        ));
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(30, 30, 464, 245);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sistemkampus_beta/Images/Bg_jurusan.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 560, 310);

        setSize(new java.awt.Dimension(572, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tPencarianJurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tPencarianJurusanActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tPencarianJurusanActionPerformed

    private void tPencarianJurusanKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tPencarianJurusanKeyTyped
        // TODO add your handling code here:
        BacaTabelJurusan2();
    }//GEN-LAST:event_tPencarianJurusanKeyTyped

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
            java.util.logging.Logger.getLogger(Jurusan_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jurusan_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jurusan_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jurusan_mhs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jurusan_mhs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Pencarian;
    private javax.swing.JLabel TabelData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tPencarianJurusan;
    private javax.swing.JTable tableJurusan;
    // End of variables declaration//GEN-END:variables
}