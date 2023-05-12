/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Project2.pkg;

import Connection.pkg.Connect;
import Connection.pkg.Sessions;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heyitstasyaa
 */
public class Dashboard extends javax.swing.JPanel {

    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        Table();
        View();
        lblNama.setText("Welcome, " + Sessions.getName() );
    }
    private void Table(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("No");
        model.addColumn("Id Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jenis Barang");
        model.addColumn("Jumlah Stok");
        model.addColumn("Satuan");

        
        try { 
            int no = 1;
            String sql = """
                        SELECT * FROM databarang 
                        WHERE (JenisBarang = \"Kertas\" AND JumlahStok <= 20) 
                        OR (JenisBarang = \"Lem\" AND JumlahStok <= 10)
                        OR (JenisBarang = \"Tinta\" AND JumlahStok <= 5)
                        OR (JenisBarang = \"Plat\" AND JumlahStok <= 20)
                        OR (JenisBarang = \"Fountain\" AND JumlahStok <= 6)
                        OR (JenisBarang = \"Plastik\" AND JumlahStok <= 15)
                        OR (JenisBarang = \"Karton\" AND JumlahStok <= 5);""";
            java.sql.Connection conn = (Connection) Connect.configDB();
            java.sql.Statement stat = conn.createStatement();
            java.sql.ResultSet res = stat.executeQuery(sql);
            while (res.next()){
                model.addRow (new Object[]{no++, res.getString(1),
                res.getString(2), res.getString(3), 
                res.getString(4), res.getString(5)});
            }
            Table.setModel(model);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil" + e);
        } 
    }
    private void View() {
        Table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD,14));
        Table.getTableHeader().setOpaque(false);
        Table.setRowHeight(20);
        Table.setForeground(Color.black);
        Table.setSelectionBackground(Color.gray);
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
        Table = new javax.swing.JTable();
        lblNama = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(Table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 950, 450));

        lblNama.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 290, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pkg/Dashboard.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNama;
    // End of variables declaration//GEN-END:variables
}
