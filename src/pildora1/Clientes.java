/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pildora1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class Clientes extends JFrame implements ActionListener, KeyListener {

//   static void addActionListener(menu_principal aThis) {
    //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //   }
    JLabel lblMensaje, lblUsuario, lblNumerodeidentificacion, lblNombre,
            lblApellido, lblTelefono, lblDireccion, lblEmail, lblGenero;
    JTextField txtNumerodeidentificacion, txtUsuario, txtNombre, txtApellido,
            txtTelefono, txtDireccion, txtEmail;
    JRadioButton JrMasculino, JrFemenino;
    ButtonGroup Genero;
    JButton Nuevo,  Actualizar, Buscar, Salir;
    JTable TablaClientes; //crear tabla
    DefaultTableModel dtm; //Modelo tabla
    JScrollPane tablapanel; //panel para la tabla
    Object[][] datos = new Object[1][20];//estructura interna de la tabal
    Object[] Columnas = {"Usuario ", "Nombre", "N°Identificacion", "Apellido", "Telefono", "Direccion", "Email"}; //Numero de columnas
    String Mat[][];
    int i = 0;
    int numReg = 0;

    public Clientes() {
        super("Motos pildora - Cliente");

        setSize(830, 600);
        setResizable(false);
        setBackground(Color.blue);
        setVisible(true);
        setLocationRelativeTo(null);//PA Q SE PONGA EN LA MITAD
        setLayout(null);



        //CREAMOS,DAMOS TAMAÑO Y UBICAMOS LO QUE DEFINIMOS

        // CREAMOS LOS LABEL
        Mat = new String[100][20];



        lblMensaje = new JLabel("Los campos que contengan * se deben llenar obligatoriamente");
        lblMensaje.setBounds(20, 160, 400, 25);
        getContentPane().add(lblMensaje);

        lblUsuario = new JLabel("Usuario*");
        lblUsuario.setBounds(10, 20, 70, 25);
        getContentPane().add(lblUsuario);

        lblNumerodeidentificacion = new JLabel("*N°Identificación*");
        lblNumerodeidentificacion.setBounds(420, 20, 70, 25);
        getContentPane().add(lblNumerodeidentificacion);

        lblNombre = new JLabel("Nombre(s)*");
        lblNombre.setBounds(10, 50, 70, 25);
        getContentPane().add(lblNombre);

        lblApellido = new JLabel("Apellido*");
        lblApellido.setBounds(420, 50, 70, 25);
        getContentPane().add(lblApellido);

        lblEmail = new JLabel("Email*");
        lblEmail.setBounds(10, 80, 70, 25);
        getContentPane().add(lblEmail);

        lblGenero = new JLabel("Género*");
        lblGenero.setBounds(420, 80, 70, 25);
        getContentPane().add(lblGenero);

        lblTelefono = new JLabel("Telefono");
        lblTelefono.setBounds(10, 110, 70, 25);
        getContentPane().add(lblTelefono);

        lblDireccion = new JLabel("Dirección");
        lblDireccion.setBounds(420, 110, 70, 25);
        getContentPane().add(lblDireccion);



        // CREAMOS LOS CUADROS DE TEXTO

        txtUsuario = new JTextField();
        txtUsuario.setBounds(170, 20, 200, 25);
        getContentPane().add(txtUsuario);

        txtNombre = new JTextField();
        txtNombre.setBounds(170, 50, 200, 25);
        getContentPane().add(txtNombre);

        txtNumerodeidentificacion = new JTextField();
        txtNumerodeidentificacion.setBounds(500, 20, 200, 25);
        getContentPane().add(txtNumerodeidentificacion);

        txtApellido = new JTextField();
        txtApellido.setBounds(500, 50, 200, 25);
        getContentPane().add(txtApellido);

        txtEmail = new JTextField();
        txtEmail.setBounds(170, 80, 200, 25);
        getContentPane().add(txtEmail);

        txtTelefono = new JTextField();
        txtTelefono.setBounds(170, 110, 200, 25);
        getContentPane().add(txtTelefono);

        txtDireccion = new JTextField();
        txtDireccion.setBounds(500, 110, 200, 25);
        getContentPane().add(txtDireccion);



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



        //CREAMOS LOS BOTONES


        Nuevo = new JButton();
        Nuevo.setText("Regristrar");
        Nuevo.setBounds(10,450,120,30);//x,y,ancho,largo
        getContentPane().add(Nuevo);
        Nuevo.addActionListener(this);

        Buscar = new JButton();
        Buscar.setText("Buscar");
        Buscar.setBounds(200, 450, 150, 30);//x,y,ancho,largo
        getContentPane().add(Buscar);
        Buscar.addActionListener(this);
        
        Actualizar = new JButton();
        Actualizar.setText("Actualizar");
        Actualizar.setBounds(420,450, 190, 30);//x,y,ancho,largo
        getContentPane().add(Actualizar);
        Actualizar.addActionListener(this);
        Actualizar.setEnabled(true);
        

        Salir = new JButton();
        Salir.setText("Salir");
        Salir.setBounds(660, 450, 150, 30);//x,y,ancho,largo
        getContentPane().add(Salir);
        Salir.addActionListener(this);


        dtm = new DefaultTableModel(datos, Columnas);// forma de la tabla
        TablaClientes = new JTable(dtm); // indican el modelo de la tabla
        tablapanel = new JScrollPane(TablaClientes);

        TablaClientes.setModel(dtm);
        tablapanel.setBounds(10, 210, 800, 200);
        tablapanel.setVisible(true);
        tablapanel.setEnabled(false);
        getContentPane().add(tablapanel);

        txtNombre.addKeyListener(this);
        txtApellido.addKeyListener(this);
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
                    || txtApellido.getText().equals("") || Sexo.equals("")) {
                JOptionPane.showMessageDialog(this, "No pueden haber campos vacios");
            } else {
                if (Verificar()) {
                    JOptionPane.showMessageDialog(null, "Ya existe el usuario");
                } else {



                    Mat[i][0] = txtUsuario.getText();
                    Mat[i][1] = txtNombre.getText();
                    Mat[i][2] = txtNumerodeidentificacion.getText();
                    Mat[i][3] = txtApellido.getText();    //ASI SE LLENAN LOS CUADROS DE TEXTO
                    Mat[i][4] = txtTelefono.getText();
                    Mat[i][5] = txtDireccion.getText();
                    Mat[i][6] = txtEmail.getText();
                    Mat[i][7] = Sexo;//ASI SE LLENAN  UN COMBOBOX


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
       
        if(event.getSource()==Salir){
             int Respuesta = JOptionPane.showConfirmDialog(null,"¿Esta seguro que se quiere salir?","Pregunta",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
             if(Respuesta==0){
             }
             setVisible(false);
        }
        Nuevo.setEnabled(true);
        
        if (event.getSource() == Nuevo) {

            Nuevo.setEnabled(true);

        }

        if (event.getSource() == Actualizar) //comienza actualizar
        {
            if (Verificar()) {
                int i = VerificarFila();


                TablaClientes.setValueAt(txtUsuario.getText(), i, 0);
                TablaClientes.setValueAt(txtNombre.getText(), i, 1);
                TablaClientes.setValueAt(txtNumerodeidentificacion.getText(), i, 2);
                TablaClientes.setValueAt(txtApellido.getText(), i, 3);
                TablaClientes.setValueAt(txtTelefono.getText(), i, 4);
                TablaClientes.setValueAt(txtDireccion.getText(), i, 5);
                TablaClientes.setValueAt(txtEmail.getText(), i, 6);





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
                TablaClientes.setModel(dtm);
            }
        }

    }

    public void keyTyped(KeyEvent e) {
        //System.out.println("tiped");
        char caracter = e.getKeyChar(); // para leer el caracter correspondiente a la tecla
        int numero = (int) (caracter);
        if (e.getSource() == txtUsuario) {
            if (Character.isDigit(caracter) == true) {
                e.consume();

            }
        }
        if (e.getSource() == txtNombre) {
            if (Character.isDigit(caracter) == true) {
                e.consume();

            }
        }


        if (e.getSource() == txtNumerodeidentificacion) {
            if (((caracter < '0') || (caracter > '9'))) {
                e.consume();

            }
        }



        if (e.getSource() == txtApellido) {
            if (((caracter < '0') || (caracter > '9'))) {
                e.consume();

            }
        }
        if (e.getSource() == txtApellido) {
            if (((caracter < '0') || (caracter > '9'))) {
                e.consume();

            }
        }
        if (e.getSource() == txtDireccion) {
            if (((caracter < '0') || (caracter > '9'))) {
                e.consume();

            }
        }
        if (e.getSource() == txtEmail) {
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
        String usu, Sexo;
        int z = 0;
        usu = JOptionPane.showInputDialog("Ingrese el Nro identificación a buscar");
        while (z < TablaClientes.getRowCount() && !TablaClientes.getValueAt(z, 2).toString().equals(usu)) {
            z++;
        }
        if (z < i) {
            txtUsuario.setText(TablaClientes.getValueAt(z, 0).toString());
            txtNombre.setText(TablaClientes.getValueAt(z, 1).toString());
            txtNumerodeidentificacion.setText(TablaClientes.getValueAt(z, 2).toString());
            txtApellido.setText(TablaClientes.getValueAt(z, 3).toString());
            txtTelefono.setText(TablaClientes.getValueAt(z, 4).toString());
            txtDireccion.setText(TablaClientes.getValueAt(z, 5).toString());//ESTTO ES ESTO
            txtEmail.setText(Mat[z][6]);//TERMINAR DE HACER ESTO

            Sexo = Mat[z][7];
            if (Sexo == "Masculino") {
                JrMasculino.doClick();
            }
            if (Sexo == "Femenino") {
                JrFemenino.doClick();
            }
            //ACUERDESE DE HACE LO ANTERIOR

            Nuevo.setEnabled(false);
            Actualizar.setEnabled(true);
            Salir.setEnabled(true);

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
        for (int w = 0; w < TablaClientes.getRowCount(); w++) {
            if (TablaClientes.getValueAt(w, 2).toString().equals(txtNumerodeidentificacion.getText())) {
                dtm.removeRow(w);
            }
        }


    }

    public void Limpiar() {
        txtUsuario.setText("");
        txtNombre.setText("");
        txtNumerodeidentificacion.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");


        Genero.clearSelection();
    }
}
