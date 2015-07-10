/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pildora1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user1
 */

public abstract class Empleados extends JFrame implements ActionListener, KeyListener {

    static void addActionListener(menu_principal aThis) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    JLabel lblMensaje, lblNombre, lblCargo, lblClave;
    JTextField txtNombre, txtCargo;
    JPasswordField txtClave;
    JButton Nuevo, Buscar, Actualizar, Salir;
    JTable TablaEmpleados;
    JComboBox Cargo; 
    JRadioButton JrElectrico, JrMecanico, JrPintura, JrVendedor;
    DefaultTableModel dtm;
    JScrollPane tablapanel;
    Object[][] datos = new Object[1][20];
    Object[] Columnas = {"Nombre", "Cargo", "Clave"};
    String Mat[][];
    int i = 0;
    int numReg = 0;
    
    public Empleados() {
        super("Motos pildora- Empleados");
        setSize(750, 550);
        setResizable(false);
        setBackground(Color.white);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(null); 
    
         Mat = new String[100][20];

        lblMensaje = new JLabel("Los campos que contengan * se deben llenar obligatoriamente");
        lblMensaje.setBounds(10, 120, 400, 25);
        getContentPane().add(lblMensaje);


        lblNombre = new JLabel("Nombre*");
        lblNombre.setBounds(10, 5, 70, 25);
        getContentPane().add(lblNombre);

        lblCargo = new JLabel("Cargo*");
        lblCargo.setBounds(10, 50, 70, 25);
        getContentPane().add(lblCargo);
        
        lblClave = new JLabel("Clave*");
        lblClave.setBounds(10, 90, 70, 25);
        getContentPane().add(lblClave);
    
        
        
        txtNombre = new JTextField();
        txtNombre.setBounds(170, 10, 200, 25);
        getContentPane().add(txtNombre);
        
        txtClave = new JPasswordField();
        txtClave.setBounds(170, 90, 200, 25);
        getContentPane().add(txtClave);
        
        Cargo = new JComboBox();
        Cargo.setBounds(170, 50, 120, 25);
        Cargo.addItem("Electronico");
        Cargo.addItem("Mecanico");
        Cargo.addItem("Pintura");
        Cargo.addItem("Vendedor");
        getContentPane().add(Cargo);
        
        //SE CREARON LOS BOTONES
        
        Nuevo = new JButton();
        Nuevo.setText("Guardar");
        Nuevo.setBounds(30,470,150, 30);
        getContentPane().add(Nuevo);
        Nuevo.addActionListener(this);
        
        Buscar = new JButton();
        Buscar.setText("Buscar");
        Buscar.setBounds(220, 470, 150, 30);//400,470,150,30
        getContentPane().add(Buscar);
        Buscar.addActionListener(this);
        
        Actualizar = new JButton();
        Actualizar.setText("Actualizar");
        Actualizar.setBounds(400,470,150,30);
        getContentPane().add(Actualizar);
        Actualizar.addActionListener(this);


        Salir = new JButton();
        Salir.setText("Salir");
        Salir.setBounds(580, 470, 150, 30);
        getContentPane().add(Salir);
        Salir.addActionListener(this);
        
        dtm = new DefaultTableModel(datos, Columnas);// forma de la tabla
        TablaEmpleados = new JTable(dtm); 
        tablapanel = new JScrollPane(TablaEmpleados);

        TablaEmpleados.setModel(dtm);
        tablapanel.setBounds(30, 170, 530, 300);
        tablapanel.setVisible(true);
        tablapanel.setEnabled(false);
        getContentPane().add(tablapanel);

        txtNombre.addKeyListener(this);
        txtCargo.addKeyListener(this);
        txtClave.addKeyListener(this);
        this.repaint();
        
        
    }
 
 public void actionPerformed(ActionEvent event) {
        if (event.getSource() == Nuevo) {  //nuevo
            String Cargo = "", Fecha;

            if (JrElectrico.isSelected()) {
                Cargo = "Electrico";
            }
            if (JrMecanico.isSelected()) {
                Cargo = "Mecanico";
            }
            if (JrPintura.isSelected()) {
                Cargo = "Pintura";
            }
            if (JrVendedor.isSelected()) {
                Cargo = "Vendedor";
            }
if (txtNombre.getText().equals("") || txtClave.getText().equals("") || Cargo.equals("")) {
                JOptionPane.showMessageDialog(this, "No pueden haber campos vacios");
            } else {
                if (Verificar()) {
                    JOptionPane.showMessageDialog(null, "Ya existe el usuario");
                } else {
                    
                     Mat[i][0] = txtNombre.getText();
                     Mat[i][1] = Cargo;

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
        if (event.getSource() == Salir) {
           int Respuesta = JOptionPane.showConfirmDialog(null,"¿Esta seguro que se quiere sali?","Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(Respuesta == 0)
            {
                setVisible(false);
            }
            Nuevo.setEnabled(true);
             
        if (event.getSource() == Nuevo) {

            Nuevo.setEnabled(true);

        }
            }

       if (event.getSource() == Actualizar)
        {
            if (Verificar()) {
                int i = VerificarFila();


                TablaEmpleados.setValueAt(txtNombre.getText(), i, 0);
                TablaEmpleados.setValueAt(Cargo.getSelectedItem(), i, 1);
                TablaEmpleados.setValueAt(txtCargo.getText(), i, 3);
                

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
                TablaEmpleados.setModel(dtm);
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
        if (e.getSource() == txtCargo) {
            if (Character.isDigit(caracter) == true) {
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
        String  Nombre;
        int z = 0;
        Nombre = JOptionPane.showInputDialog("Ingrese el nombre a buscar");
        while (z < TablaEmpleados.getRowCount() && !TablaEmpleados.getValueAt(z, 0).toString().equals(Nombre)) {
            z++;
        }
        if (z < i) {
            txtNombre.setText(TablaEmpleados.getValueAt(z, 0).toString());
            txtClave.setText(TablaEmpleados.getValueAt(z, 1).toString());
            
            Cargo.setSelectedItem(Mat[z][11]);
            
            Nuevo.setEnabled(true);
            Actualizar.setEnabled(false);
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
        Ver = txtNombre.getText();
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
        Ver = txtNombre.getText();
        while (z < i && !Ver.equals(Mat[z][2])) {
            z++;
        }
        return z;

    }

    public void eliminar() { // Este es el deshabilitar
        for (int w = 0; w < TablaEmpleados.getRowCount(); w++) {
            if (TablaEmpleados.getValueAt(w, 2).toString().equals(txtNombre.getText())) {
                dtm.removeRow(w);
            }
        }


    }

    public void Limpiar() {
        txtNombre.setText("");
        txtClave.setText("");

        Cargo.setSelectedIndex(0);

       
    }
}
