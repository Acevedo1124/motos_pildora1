/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pildora1;

/**
 *
 * @author User
 */
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;//libreia de tablas

public class Usuario extends JFrame implements ActionListener, KeyListener {

    static void addActionListener(menu_principal aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    JLabel lblMensaje, lblTipodeidentificacion, lblNumerodeidentificacion, lblNombre,
            lblApellido, lblNombredeusuario, lblContraseña, lblTelefono,
            lblDireccion, lblEmail, lblGenero, lblEstado, lblPerfil;
    JTextField txtNumerodeidentificacion, txtNombre, txtApellido, txtNombredeusuario,
            txtTelefono, txtDireccion, txtEmail, txtPerfil;
    JPasswordField txtContraseña;
    JRadioButton JrMasculino, JrFemenino;
    ButtonGroup Genero;
    JButton Nuevo, Guardar, Actualizar, Buscar, Mostrar;
    JTable TablaUsuario; //crear tabla
    DefaultTableModel dtm; //Modelo tabla
    JScrollPane tablapanel; //panel para la tabla
    Object[][] datos = new Object[1][20];//estructura interna de la tabal
    Object[] Columnas = {"Nombre", "Apellido", "NumeroIdentificacion", "TipoIdentificacion",
        "Usuario", "Telefono", "Direccion", "Email", "Genero",
        "Estado", "Perfil"}; //Numero de columnas
    String Mat[][];
    int i = 0;
    int numReg = 0;
    JComboBox CoTipodeidentificacion, CoEstado;

    public Usuario() {
        super("Motos pildora- Usuario");
        setSize(1230, 600);
        setResizable(false);
        setBackground(Color.white);
        setVisible(true);
        setLocationRelativeTo(null);//PA Q SE PONGA EN LA MITAD
        setLayout(null);


        //CREAMOS,DAMOS TAMAÑO Y UBICAMOS LO QUE DEFINIMOS

        // CREAMOS LOS LABEL
        Mat = new String[100][20];

        lblMensaje = new JLabel("Los campos que contengan * se deben llenar obligatoriamente");
        lblMensaje.setBounds(20, 260, 400, 25);
        getContentPane().add(lblMensaje);


        lblNombre = new JLabel("*Nombre");
        lblNombre.setBounds(20, 20, 70, 25);
        getContentPane().add(lblNombre);

        lblApellido = new JLabel("*Apellido");
        lblApellido.setBounds(20, 50, 70, 25);
        getContentPane().add(lblApellido);

        lblTipodeidentificacion = new JLabel("Tipo de identificación");
        lblTipodeidentificacion.setBounds(20, 110, 160, 25);
        getContentPane().add(lblTipodeidentificacion);

        lblNumerodeidentificacion = new JLabel("*Numero de identificación");
        lblNumerodeidentificacion.setBounds(20, 80, 160, 25);
        getContentPane().add(lblNumerodeidentificacion);

        lblNombredeusuario = new JLabel("*Nombre de usuario");
        lblNombredeusuario.setBounds(20, 140, 120, 25);
        getContentPane().add(lblNombredeusuario);


        lblContraseña = new JLabel("Contraseña");
        lblContraseña.setBounds(20, 170, 70, 25);
        getContentPane().add(lblContraseña);

        lblTelefono = new JLabel("Telefono");
        lblTelefono.setBounds(20, 200, 70, 25);
        getContentPane().add(lblTelefono);

        lblDireccion = new JLabel("Dirección");
        lblDireccion.setBounds(420, 20, 70, 25);
        getContentPane().add(lblDireccion);

        lblEmail = new JLabel("Email");
        lblEmail.setBounds(420, 50, 70, 25);
        getContentPane().add(lblEmail);

        lblGenero = new JLabel("*Género");
        lblGenero.setBounds(420, 80, 70, 25);
        getContentPane().add(lblGenero);

        lblEstado = new JLabel("*Estado");
        lblEstado.setBounds(420, 140, 70, 25);
        getContentPane().add(lblEstado);


        lblPerfil = new JLabel("*Perfil");
        lblPerfil.setBounds(420, 200, 70, 25);
        getContentPane().add(lblPerfil);



        // CREAMOS LOS CUADROS DE TEXTO

        txtNumerodeidentificacion = new JTextField();
        txtNumerodeidentificacion.setBounds(170, 80, 200, 25);
        getContentPane().add(txtNumerodeidentificacion);

        txtNombre = new JTextField();
        txtNombre.setBounds(170, 20, 200, 25);
        getContentPane().add(txtNombre);

        txtApellido = new JTextField();
        txtApellido.setBounds(170, 50, 200, 25);
        getContentPane().add(txtApellido);


        txtNombredeusuario = new JTextField();
        txtNombredeusuario.setBounds(170, 140, 200, 25);
        getContentPane().add(txtNombredeusuario);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(170, 170, 200, 25);
        getContentPane().add(txtContraseña);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(170, 200, 200, 25);
        getContentPane().add(txtTelefono);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(500, 20, 200, 25);
        getContentPane().add(txtDireccion);

        txtEmail = new JTextField();
        txtEmail.setBounds(500, 50, 200, 25);
        getContentPane().add(txtEmail);

        txtPerfil = new JTextField();
        txtPerfil.setBounds(500, 200, 200, 25);
        getContentPane().add(txtPerfil);





        // SE CREAN LOS RADIO BUTTON

        JrMasculino = new JRadioButton("Hombre");
        JrMasculino.setBounds(500, 80, 70, 25);
        getContentPane().add(JrMasculino);

        JrFemenino = new JRadioButton("Mujer");
        JrFemenino.setBounds(580, 80, 70, 25);
        getContentPane().add(JrFemenino);


        Genero = new ButtonGroup();
        Genero.add(JrFemenino);
        Genero.add(JrMasculino);


        //SE CREAN LAS LISTAS DESPEGABLES

        CoTipodeidentificacion = new JComboBox();
        CoTipodeidentificacion.setBounds(170, 110, 120, 25);
        CoTipodeidentificacion.addItem("TI");
        CoTipodeidentificacion.addItem("CC");
        getContentPane().add(CoTipodeidentificacion); 


        CoEstado = new JComboBox();
        CoEstado.setBounds(500, 140, 120, 25);
        CoEstado.addItem("Activo");
        CoEstado.addItem("Inactivo");
        getContentPane().add(CoEstado);


        //CREAMOS LOS BOTONES
        Nuevo = new JButton();
        Nuevo.setText("Nuevo");
        Nuevo.setBounds(100, 500, 120, 30);//x,y,ancho,largo
        getContentPane().add(Nuevo);
        Nuevo.addActionListener(this);

        Guardar = new JButton();
        Guardar.setText("Guardar");
        Guardar.setBounds(400, 500, 150, 30);//x,y,ancho,largo
        getContentPane().add(Guardar);
        Guardar.addActionListener(this);


        Buscar = new JButton();
        Buscar.setText("Buscar");
        Buscar.setBounds(400, 500, 150, 30);//x,y,ancho,largo
        getContentPane().add(Buscar);
        Buscar.addActionListener(this);

        Actualizar = new JButton();
        Actualizar.setText("Actualizar");
        Actualizar.setBounds(700, 500, 190, 30);//x,y,ancho,largo
        getContentPane().add(Actualizar);
        Actualizar.addActionListener(this);
        Actualizar.setEnabled(false);


        Mostrar = new JButton();
        Mostrar.setText("Mostrar");
        Mostrar.setBounds(1000, 500, 150, 30);//x,y,ancho,largo
        getContentPane().add(Mostrar);
        Mostrar.addActionListener(this);
        Mostrar.setEnabled(false);

        dtm = new DefaultTableModel(datos, Columnas);// forma de la tabla
        TablaUsuario = new JTable(dtm); // indican el modelo de la tabla
        tablapanel = new JScrollPane(TablaUsuario);

        TablaUsuario.setModel(dtm);
        tablapanel.setBounds(10, 310, 1200, 300);
        tablapanel.setVisible(true);
        tablapanel.setEnabled(false);
        getContentPane().add(tablapanel);

        txtNombre.addKeyListener(this);
        txtApellido.addKeyListener(this);
        txtPerfil.addKeyListener(this);
        txtTelefono.addKeyListener(this);
        txtNumerodeidentificacion.addKeyListener(this);


        this.repaint();

    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == Nuevo) {  //nuevo
            String Sexo = "", Fecha;

            if (JrFemenino.isSelected()) {
                Sexo = "Femenino";
            }
            if (JrMasculino.isSelected()) {
                Sexo = "Masculino";
            }

            if (txtNumerodeidentificacion.getText().equals("") || txtNombre.getText().equals("")
                    || txtApellido.getText().equals("") || txtNombredeusuario.getText().equals("") || Sexo.equals("")) {
                JOptionPane.showMessageDialog(this, "No pueden haber campos vacios");
            } else {
                if (Verificar()) {
                    JOptionPane.showMessageDialog(null, "Ya existe el usuario");
                } else {



                    Mat[i][0] = txtNombre.getText();
                    Mat[i][1] = txtApellido.getText();
                    Mat[i][2] = txtNumerodeidentificacion.getText();		//ASI SE LLENAN LOS CUADROS DE TEXTO
                    Mat[i][3] = (String) CoTipodeidentificacion.getSelectedItem().toString();
                    Mat[i][4] = txtNombredeusuario.getText();
                    Mat[i][5] = txtTelefono.getText();
                    Mat[i][7] = txtDireccion.getText();
                    Mat[i][8] = txtEmail.getText();
                    Mat[i][9] = Sexo;//ASI SE LLENAN  UN COMBOBOX

                    Mat[i][11] = (String) CoEstado.getSelectedItem().toString();
                    Mat[i][15] = txtPerfil.getText();


                    numReg++;
                    i++;


                    Limpiar();
                    JOptionPane.showMessageDialog(this, "Datos Guardados con exito");

                    LlenarTabla(Mat, i);
                    Nuevo.setEnabled(true);
                }
            }
        }

        if (event.getSource() == Buscar) {
            Buscar();

        }
        if (event.getSource() == Mostrar) {
            Nuevo.setEnabled(true);
            Guardar.setEnabled(true);
            Mostrar.setEnabled(false);
            Actualizar.setEnabled(false);
        }

        if (event.getSource() == Actualizar) //comienza actualizar
        {
            if (Verificar()) {
                int i = VerificarFila();


                TablaUsuario.setValueAt(txtNombre.getText(), i, 0);
                TablaUsuario.setValueAt(txtApellido.getText(), i, 1);
                TablaUsuario.setValueAt(txtNumerodeidentificacion.getText(), i, 2);
                TablaUsuario.setValueAt(CoTipodeidentificacion.getSelectedItem(), i, 3);
                TablaUsuario.setValueAt(txtTelefono.getText(), i, 4);
                TablaUsuario.setValueAt(txtDireccion.getText(), i, 6);
                TablaUsuario.setValueAt(txtEmail.getText(), i, 7);
                TablaUsuario.setValueAt(CoEstado.getSelectedItem(), i, 10);
                TablaUsuario.setValueAt(txtPerfil.getText(), i, 14);




                JOptionPane.showMessageDialog(null, "Los datos se han modificado sactisfactoriamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo modificar la clave");
            }


        }

    }

    public void LlenarTabla(String mat[][], int i) {
        int k;
        int j;
        Object[][] datos = new Object[i][20];//estructura interna de la tabal
        for (j = 0; j < i; j++) {

            for (k = 0; k < 19; k++) {
                datos[j][k] = mat[j][k];
                dtm = new DefaultTableModel(datos, Columnas);
                TablaUsuario.setModel(dtm);
            }
        }

    }

    public void keyTyped(KeyEvent e) {
        //System.out.println("tiped");
        char caracter = e.getKeyChar(); // para leer el caracter correspondiente a la tecla
        int numero = (int) (caracter);
        if (e.getSource() == txtNombre) {
            if (Character.isDigit(caracter) == true) {
                e.consume();

            }
        }
        if (e.getSource() == txtApellido) {
            if (Character.isDigit(caracter) == true) {
                e.consume();

            }
        }
        if (e.getSource() == txtPerfil) {
            if (Character.isDigit(caracter) == true) {
                e.consume();

            }
        }

        if (e.getSource() == txtTelefono) {
            if (((caracter < '0') || (caracter > '9'))) {
                e.consume();

            }
        }



        if (e.getSource() == txtNumerodeidentificacion) {
            if (((caracter < '0') || (caracter > '9'))) {
                e.consume();

            }
        }



    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        Pildora1 p = new Pildora1();
    }

    public void Buscar() { // Aqui empieza el buscar
        String Doc, Sexo;
        int z = 0;
        Doc = JOptionPane.showInputDialog("Ingrese el documento a buscar");
        while (z < TablaUsuario.getRowCount() && !TablaUsuario.getValueAt(z, 2).toString().equals(Doc)) {
            z++;
        }
        if (z < i) {
            txtNombre.setText(TablaUsuario.getValueAt(z, 0).toString());
            txtApellido.setText(TablaUsuario.getValueAt(z, 1).toString());
            txtNumerodeidentificacion.setText(TablaUsuario.getValueAt(z, 2).toString());
            CoTipodeidentificacion.setSelectedItem(TablaUsuario.getValueAt(z, 3).toString());
            txtNombredeusuario.setText(TablaUsuario.getValueAt(z, 4).toString());
            txtTelefono.setText(TablaUsuario.getValueAt(z, 5).toString());

            txtDireccion.setText(TablaUsuario.getValueAt(z, 7).toString());//ESTTO ES ESTO
            txtEmail.setText(Mat[z][8]);//TERMINAR DE HACER ESTO


            CoEstado.setSelectedItem(Mat[z][11]);
            txtPerfil.setText(Mat[z][15]);

            Sexo = Mat[z][9];
            if ("Masculino".equals(Sexo)) {
                JrMasculino.doClick();
            }
            if (Sexo == "Femenino") {
                JrFemenino.doClick();
            }
            //ACUERDESE DE HACE LO ANTERIOR

            Nuevo.setEnabled(false);
            Actualizar.setEnabled(true);
            Mostrar.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(null, "No se encontro");
            Nuevo.setEnabled(true);
        }
    }

    public boolean Verificar() {
        String Ver;
        int z = 0;
        boolean res;
        Ver = txtNumerodeidentificacion.getText();
        while (z < i && !Ver.equals(Mat[z][2])) {
            z++;
        }
        if (z < i) {
            res = true;
        } else {
            res = false;
        }
        return res;

    }

    public int VerificarFila() {
        String Ver;
        int z = 0;
        boolean res;
        Ver = txtNumerodeidentificacion.getText();
        while (z < i && !Ver.equals(Mat[z][2])) {
            z++;
        }
        return z;

    }

    public void eliminar() { // Este es el deshabilitar
        for (int w = 0; w < TablaUsuario.getRowCount(); w++) {
            if (TablaUsuario.getValueAt(w, 2).toString().equals(txtNumerodeidentificacion.getText())) {
                dtm.removeRow(w);
            }
        }


    }

    public void Limpiar() {
        txtNumerodeidentificacion.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtNombredeusuario.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
        txtPerfil.setText("");
        txtContraseña.setText("");

        CoTipodeidentificacion.setSelectedIndex(0);
        CoEstado.setSelectedIndex(0);

        Genero.clearSelection();
    }
}
