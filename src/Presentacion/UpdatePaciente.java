/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Datos.PacienteDAL;
import Entidades.Estado;
import Entidades.Lista;
import Entidades.Paciente;
import Entidades.Sexo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static Presentacion.Principal.doctor;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JUAN CARLOS
 */
public class UpdatePaciente extends javax.swing.JDialog {

    /**
     * Creates new form UpdatePaciente
     */
    Lista<Sexo> lista=new Lista<>();
    Lista<Estado> listaEstado=new Lista<>();
    int Idpaciente=-1;
    public UpdatePaciente(java.awt.Frame parent, boolean modal,int idcodigo) {
        super(parent, modal);
        initComponents();
        habilitarTextos(false);
        habilitarBotones(true);
        cargarSexo();
        cargarEstado();
        Idpaciente=idcodigo;
        llenarDatos(idcodigo);
        setLocationRelativeTo(this);
    }
    private void cargarEstado()
    {
        listaEstado.agregar(new Estado("A", "Activo"));
        listaEstado.agregar(new Estado("I", "Inactivo"));
        for(int i=0;i<listaEstado.size();i++)
        {
            cbestado.addItem(listaEstado.getT(i).getDescripcion());
        }
    }
    private String buscarEstado(String c)
    {
        for(int i=0;i<listaEstado.size();i++)
        {
            if(listaEstado.getT(i).getCodigo().equals(c))
                return listaEstado.getT(i).getDescripcion();
        }
        return null;
    }
    private String buscarCodigoEstado(String descripcion)
    {
        for(int i=0;i<listaEstado.size();i++)
        {
            if(listaEstado.getT(i).getDescripcion().equals(descripcion))
                return listaEstado.getT(i).getCodigo();
        }
        return null;
    }
    private void llenarDatos(int idcodigo)
    {
        ResultSet rs=PacienteDAL.getInstance().buscarPaciente(idcodigo);
        try {
            rs.next();
            fecharegistro.setDate(rs.getDate(10));
            txtapellidos.setText(rs.getString(3));
            txtnombres.setText(rs.getString(2));
            txtdireccion.setText(rs.getString(7));
            txtemail.setText(rs.getString(9));
            cbocupacion.setSelectedItem(rs.getString(4));
            cbsexo.setSelectedItem(rs.getString(6));
            cbraza.setSelectedItem(rs.getString(11));
            cbestado.setSelectedItem(buscarEstado(rs.getString(12)));
            txttelefono.setText(rs.getString(8));
            fechanac.setDate(rs.getDate(5));
        } catch (SQLException ex) {
            
        }
    }
    private void habilitarTextos(boolean sw)
    {
        txtapellidos.setEditable(sw);
        txtnombres.setEditable(sw);
        txtdireccion.setEditable(sw);
        txtemail.setEditable(sw);
        cbocupacion.setEnabled(sw);
        cbsexo.setEnabled(sw);
        cbraza.setEnabled(sw);
        txttelefono.setEditable(sw);
        fechanac.setEnabled(sw);
        cbestado.setEnabled(sw);
    }
    private void habilitarBotones(boolean sw)
    {
        btnagregar.setEnabled(!sw);
        btncancelar.setEnabled(!sw);
        btnnuevo.setEnabled(sw);
        btnsalir.setEnabled(sw);
        
    }
    private String buscarSexo(String c)
    {
        for(int i=0;i<lista.size();i++)
        {
            if(lista.getT(i).getCodigo().equals(c))
                return lista.getT(i).getDescripcion();
        }
        return null;
    }
     private String buscarIdSexo(String descripcion)
    {
        for(int i=0;i<lista.size();i++)
        {
            if(lista.getT(i).getDescripcion().equals(descripcion))
                return lista.getT(i).getCodigo();
        }
        return null;
    }
    private void cargarSexo()
    {
        lista.agregar(new Sexo("M", "Masculino"));
        lista.agregar(new Sexo("F", "Femenino"));
        for(int i=0;i<lista.size();i++)
        {
            cbsexo.addItem(lista.getT(i).getDescripcion());
        }
    }
    private boolean validar(String telefono,String email)
    {
        Pattern patronEmail=Pattern.compile("^[a-z0-9-]+(\\.[a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,3})$");
        Matcher matEmail = patronEmail.matcher(email);
        Pattern patronTelefono=Pattern.compile("^\\+?\\d{1,3}?[- .]?\\(?(?:\\d{2,3})\\)?[- .]?\\d\\d\\d[- .]?\\d\\d\\d\\d$");
        Matcher matTelefono = patronTelefono.matcher(telefono);
        
        if(!matEmail.find())
        {
            JOptionPane.showMessageDialog(null,"No es un Correo Electronico","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if(!matTelefono.find())
        {
            JOptionPane.showMessageDialog(null,"No es un numero Telefonico","Error",JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
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
        txtnombres = new javax.swing.JTextField();
        txtapellidos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbocupacion = new javax.swing.JComboBox();
        txttelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fechanac = new com.toedter.calendar.JDateChooser();
        cbraza = new javax.swing.JComboBox();
        txtemail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbsexo = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtdireccion = new javax.swing.JTextArea();
        cbestado = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnagregar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        fecharegistro = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS PERSONLES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 18))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        txtnombres.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));

        txtapellidos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("APELLIDOS:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("NOMBRES:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("OCUPACION:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("FECHA NACIMIENTO:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("TELEFONO:");

        cbocupacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Albañil", "Constructor", "Costurero", "Taxista" }));
        cbocupacion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        cbocupacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        txttelefono.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("EMAIL:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("RAZA:");

        fechanac.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));

        cbraza.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Blanco", "Negro", "Trigeño" }));
        cbraza.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        cbraza.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbraza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbrazaActionPerformed(evt);
            }
        });

        txtemail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("SEXO:");

        cbsexo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        cbsexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbsexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbsexoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("DIRECCION:");

        txtdireccion.setColumns(20);
        txtdireccion.setRows(5);
        txtdireccion.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        jScrollPane1.setViewportView(txtdireccion);

        cbestado.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        cbestado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbestado.setEnabled(false);
        cbestado.setName("");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("ESTADO:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbsexo, 0, 176, Short.MAX_VALUE)
                                    .addComponent(txtapellidos)
                                    .addComponent(txtnombres)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbraza, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(37, 37, 37)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnombres, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtapellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbsexo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(fechanac, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbraza, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cbocupacion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addGap(33, 33, 33))
        );

        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/edit.png"))); // NOI18N
        btnnuevo.setText("Modificar");
        btnnuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/entrar.png"))); // NOI18N
        btnagregar.setText("Grabar");
        btnagregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/close.png"))); // NOI18N
        btnsalir.setText("SALIR");
        btnsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        fecharegistro.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 1, true));
        fecharegistro.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("FECHA REGISTRO:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(fecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnagregar)
                        .addGap(28, 28, 28)
                        .addComponent(btncancelar)
                        .addGap(53, 53, 53)
                        .addComponent(btnnuevo)
                        .addGap(42, 42, 42)
                        .addComponent(btnsalir)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(fecharegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbrazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbrazaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbrazaActionPerformed

    private void cbsexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbsexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbsexoActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        // TODO add your handling code here:
        habilitarBotones(false);
        habilitarTextos(true);
        txtnombres.requestFocus();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:

        if (!txtnombres.getText().equals("") && !txtapellidos.getText().equals("") && !txtdireccion.getText().equals("")
                && !txtemail.getText().equals("") && !fechanac.getDateFormatString().equals("")
                && !txttelefono.getText().equals("")) {
            String nombres = txtnombres.getText().trim();
            String apellidos = txtapellidos.getText().trim();
            String direccion = txtdireccion.getText().trim();
            String email = txtemail.getText().trim();
            java.util.Date fechaNacUtil = fechanac.getDate();
            java.sql.Date fechaNacSql = new java.sql.Date(fechaNacUtil.getTime());
            java.util.Date fechaRegistroUtil = fecharegistro.getDate();
            java.sql.Date fechaRegistroSql = new java.sql.Date(fechaRegistroUtil.getTime());
            //JOptionPane.showMessageDialog(null,fechaNacSql+":"+fechaRegistroSql);
            String sexo = buscarIdSexo(cbsexo.getSelectedItem().toString()).trim();
            String raza = cbraza.getSelectedItem().toString().trim();
            String ocupacion = cbocupacion.getSelectedItem().toString().trim();
            String telefono = txttelefono.getText().trim();
            int iddoctor = 0;
            String estado = buscarCodigoEstado(cbestado.getSelectedItem().toString());
            Paciente paciente = new Paciente(Idpaciente, iddoctor, nombres, apellidos, ocupacion, fechaNacSql, sexo, direccion, telefono, email, fechaRegistroSql, raza, estado, null);
            if (PacienteDAL.getInstance().modificarPaciente(paciente) > 0) {
                JOptionPane.showMessageDialog(null, "Paciente Actualizado");
                habilitarTextos(false);
                habilitarBotones(true);
//                RegistroPaciente rp = new RegistroPaciente(paciente);
//                rp.setVisible(true);
//                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error de Registro", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese Datos", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnagregarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        habilitarBotones(true);
        habilitarTextos(false);
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UpdatePaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdatePaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdatePaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdatePaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the dialog
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                UpdatePaciente dialog = new UpdatePaciente(new javax.swing.JFrame(), true,-1);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox cbestado;
    private javax.swing.JComboBox cbocupacion;
    private javax.swing.JComboBox cbraza;
    private javax.swing.JComboBox cbsexo;
    private com.toedter.calendar.JDateChooser fechanac;
    private com.toedter.calendar.JDateChooser fecharegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtapellidos;
    private javax.swing.JTextArea txtdireccion;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtnombres;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
