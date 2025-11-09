package vista;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaRegistro extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaRegistro.class.getName());

    public VentanaRegistro() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        panelRellenoIzq = new javax.swing.JPanel();
        panelCentro = new javax.swing.JPanel();
        panelTitulo = new javax.swing.JPanel();
        labelRegistrarse = new javax.swing.JLabel();
        panelNombre = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        panelEmail = new javax.swing.JPanel();
        labelEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        panelPassword = new javax.swing.JPanel();
        labelPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        panelDireccion = new javax.swing.JPanel();
        labelDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        panelTelefono = new javax.swing.JPanel();
        labelTelefono = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        panelBotones = new javax.swing.JPanel();
        btnRegistrarse = new javax.swing.JButton();
        panelBoton = new javax.swing.JPanel();
        btnVolver = new javax.swing.JButton();
        panelRellenoDer = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 700));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(500, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 1000));

        panelPrincipal.setMaximumSize(new java.awt.Dimension(500, 900));
        panelPrincipal.setMinimumSize(new java.awt.Dimension(400, 500));
        panelPrincipal.setPreferredSize(new java.awt.Dimension(500, 600));
        panelPrincipal.setLayout(new javax.swing.BoxLayout(panelPrincipal, javax.swing.BoxLayout.LINE_AXIS));

        panelRellenoIzq.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 1));
        panelRellenoIzq.setMaximumSize(null);
        panelRellenoIzq.setPreferredSize(new java.awt.Dimension(40, 200));

        javax.swing.GroupLayout panelRellenoIzqLayout = new javax.swing.GroupLayout(panelRellenoIzq);
        panelRellenoIzq.setLayout(panelRellenoIzqLayout);
        panelRellenoIzqLayout.setHorizontalGroup(
            panelRellenoIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelRellenoIzqLayout.setVerticalGroup(
            panelRellenoIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );

        panelPrincipal.add(panelRellenoIzq);

        panelCentro.setMaximumSize(null);
        panelCentro.setMinimumSize(new java.awt.Dimension(400, 600));
        panelCentro.setName(""); // NOI18N
        panelCentro.setPreferredSize(new java.awt.Dimension(500, 600));
        panelCentro.setLayout(new java.awt.GridLayout(8, 1, 0, 25));

        labelRegistrarse.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        labelRegistrarse.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelRegistrarse.setText("Registrarse");
        labelRegistrarse.setToolTipText("");
        labelRegistrarse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelTitulo.add(labelRegistrarse);

        panelCentro.add(panelTitulo);

        panelNombre.setLayout(new java.awt.GridLayout(2, 1));

        labelNombre.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelNombre.setText("Nombre o Apellido de la familia");
        labelNombre.setToolTipText("");
        panelNombre.add(labelNombre);
        panelNombre.add(txtNombre);

        panelCentro.add(panelNombre);

        panelEmail.setLayout(new java.awt.GridLayout(2, 1));

        labelEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelEmail.setText("Correo Electrónico");
        labelEmail.setToolTipText("");
        panelEmail.add(labelEmail);
        panelEmail.add(txtEmail);

        panelCentro.add(panelEmail);

        panelPassword.setLayout(new java.awt.GridLayout(2, 1));

        labelPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelPassword.setText("Contraseña");
        labelPassword.setToolTipText("");
        panelPassword.add(labelPassword);
        panelPassword.add(txtPassword);

        panelCentro.add(panelPassword);

        panelDireccion.setLayout(new java.awt.GridLayout(2, 1));

        labelDireccion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelDireccion.setText("Dirección");
        labelDireccion.setToolTipText("");
        panelDireccion.add(labelDireccion);
        panelDireccion.add(txtDireccion);

        panelCentro.add(panelDireccion);

        panelTelefono.setLayout(new java.awt.GridLayout(2, 1));

        labelTelefono.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTelefono.setText("Teléfono / Celular");
        labelTelefono.setToolTipText("");
        panelTelefono.add(labelTelefono);
        panelTelefono.add(txtTelefono);

        panelCentro.add(panelTelefono);

        panelBotones.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 1, 1, 1));

        btnRegistrarse.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRegistrarse.setText("Crear Cuenta");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        panelBotones.add(btnRegistrarse);

        panelCentro.add(panelBotones);

        panelBoton.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        btnVolver.setText("Volver");
        panelBoton.add(btnVolver);

        panelCentro.add(panelBoton);

        panelPrincipal.add(panelCentro);

        panelRellenoDer.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 1));
        panelRellenoDer.setMaximumSize(null);
        panelRellenoDer.setPreferredSize(new java.awt.Dimension(40, 200));
        panelRellenoDer.setRequestFocusEnabled(false);

        javax.swing.GroupLayout panelRellenoDerLayout = new javax.swing.GroupLayout(panelRellenoDer);
        panelRellenoDer.setLayout(panelRellenoDerLayout);
        panelRellenoDerLayout.setHorizontalGroup(
            panelRellenoDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 97, Short.MAX_VALUE)
        );
        panelRellenoDerLayout.setVerticalGroup(
            panelRellenoDerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 958, Short.MAX_VALUE)
        );

        panelPrincipal.add(panelRellenoDer);

        getContentPane().add(panelPrincipal, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed

    }//GEN-LAST:event_btnRegistrarseActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new VentanaRegistro().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JButton btnVolver;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelRegistrarse;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JPanel panelBoton;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelCentro;
    private javax.swing.JPanel panelDireccion;
    private javax.swing.JPanel panelEmail;
    private javax.swing.JPanel panelNombre;
    private javax.swing.JPanel panelPassword;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelRellenoDer;
    private javax.swing.JPanel panelRellenoIzq;
    private javax.swing.JPanel panelTelefono;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

   
    public String getEmail(){
        return txtEmail.getText();
    }
    public String getPassword(){
        return new String(txtPassword.getPassword());
    }

    public static Logger getLogger() {
        return logger;
    }

    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtTelefono() {
        return txtTelefono;
    }
    
    
}
