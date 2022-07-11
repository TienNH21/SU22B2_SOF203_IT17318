package lesson3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class DemoCaro extends javax.swing.JFrame {
    private boolean isFirst = true;
    private JButton[] listBtn;
    
    public DemoCaro() {
        initComponents();
        
        this.listBtn = new JButton[100];
        initLayout();
    }
    
    private void initLayout()
    {
        GridLayout gl = new GridLayout(10, 10);
        this.setLayout(gl);
        
        for (int i = 0; i < 100; i++) {
            JButton btn = new JButton("");
            
            int viTri = i;
            
            DemoCaro that = this;
            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (that.isFirst == true) {
                        btn.setText("X");
                        that.isFirst = false;
                        that.check(viTri, 'X');
                    } else {
                        that.isFirst = true;
                        btn.setText("O");
                        that.check(viTri, 'O');
                    }
                    
                    btn.setEnabled(false);
                }
            };
            
            btn.addActionListener(listener);
            
            this.add(btn);
            this.listBtn[i] = btn;
        }
    }
    
    public boolean check(int viTri, char c)
    {
        int count = 1;
        // Check hàng ngang:        +- 1
        System.out.println("----" + c);
        for (int i = -5; i < 5; i++) {
            int viTriCheck = viTri + i;
            System.out.println(i + "+" + viTri + "=" + viTriCheck);
            if (viTriCheck < 0 || viTriCheck >= 10) {
                continue ;
            }
            
            System.out.println(this.listBtn[viTriCheck].getText());
            System.out.println(c + "," + this.listBtn[viTriCheck].getText().equalsIgnoreCase(c+""));
            if (this.listBtn[viTriCheck].getText().equalsIgnoreCase(c+"")) {
                count++;
            } else {
                continue;
            }
            
            if (count >= 5) {
                JOptionPane.showMessageDialog(this, "Win");
            }
        }
        
        
        // Check hàng dọc           +- 10
        // Check hàng chéo trái     +- 11
        // Check hàng chéo phải     +- 9
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(DemoCaro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DemoCaro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DemoCaro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DemoCaro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DemoCaro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
