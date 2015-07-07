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
import javax.swing.table.DefaultTableModel;

public class Ventas extends JFrame implements ActionListener,KeyListener {
    
    static void addActionListener(menu_principal aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    JLabel lblNroFactura,lblEstado , lblFecha, lblUsuario,lblmaster,
	lblIdCliente, lblEmail,lblNombre, lblApellido,lblTelefono , lblDireccion,lblProducto, lblCantidad;
    
    JTextField txtNroFactura, txtUsuario,txtIdCliente ,txtEmail , txtNombre, txtApellido,
	txtTelefono, txtDireccion, txtCantidad;
    
    
    
    
    JButton Nuevo, Guardar, Actualizar, Buscar, Mostrar;
    
    JMenuItem Aceite, Tornillos, Caja_Filtro, Llantas, Liquido_Frenos;
    
    JTable TablaVentas; //crear tabla
	DefaultTableModel dtm; //Modelo tabla
	JScrollPane tablapanel; //panel para la tabla
	Object [][] datos = new Object [1][20];//estructura interna de la tabal
	Object [] Columnas = {"N°Factura","Usuario","ID Cliente", "Producto", "Cantidad"}; //Numero de columnas
        
        String Mat[][];
	int i=0;
	int numReg=0;
        JComboBox coEstado;
        
        
        public Ventas() {
	    super("Motos pildora - Ventas");
         
	    setSize(830,600);
	    setResizable(false);
	    setBackground(Color.blue);
	    setVisible(true);
	    setLocationRelativeTo(null);//PARA QUE ESTE CENTRADO
	    setLayout(null);
            

		//CREAMOS,DAMOS TAMAÑO Y UBICAMOS LO QUE DEFINIMOS

	   // CREAMOS LOS LABEL
	    Mat= new String	[100] [20];

             //Manuela estuvo aqui
            
            lblNroFactura= new JLabel("Numero de Factura*");
	    lblNroFactura.setBounds(10,20,70,25);
	    getContentPane().add(lblNroFactura);
            
            lblEstado = new JLabel("Estado*");
	    lblEstado.setBounds(420,20,70,25);
	    getContentPane().add(lblEstado);
            
	    lblFecha = new JLabel("Fecha Pedido*");
	    lblFecha.setBounds(10,50,70,25);
	    getContentPane().add(lblFecha);

	    lblUsuario = new JLabel("Usuario*");
	    lblUsuario.setBounds(420,50,70,25);
	    getContentPane().add(lblUsuario);

            lblIdCliente = new JLabel("Cliente*");
	    lblIdCliente.setBounds(10,80,70,25);
	    getContentPane().add(lblIdCliente);
	    
            lblEmail = new JLabel("Email*");
	    lblEmail.setBounds(420,80,70,25);
	    getContentPane().add(lblEmail);
            
	    lblNombre = new JLabel("Nombre");
	    lblNombre.setBounds(10,110,70,25);
	    getContentPane().add(lblNombre);

	    lblApellido = new JLabel("Apellido");
	    lblApellido.setBounds(420,110,70,25);
	    getContentPane().add(lblApellido);
            
            lblTelefono = new JLabel("Telefono");
	    lblTelefono.setBounds(10,140,70,25);
	    getContentPane().add(lblNombre);

	    lblDireccion = new JLabel("Direccion");
	    lblDireccion.setBounds(420,140,70,25);
	    getContentPane().add(lblDireccion);

	    lblProducto = new JLabel("Producto*");
	    lblProducto.setBounds(10,170,70,25);
	    getContentPane().add(lblProducto);

	    lblCantidad = new JLabel("Cantidad*");
	    lblCantidad.setBounds(420,170,70,25);
	    getContentPane().add(lblCantidad);

	   


	 // CREAMOS LOS CUADROS DE TEXTO

	    txtNroFactura= new JTextField();
	    txtNroFactura.setBounds(170,20,200,25);
	    getContentPane().add(txtNroFactura);

            txtUsuario= new JTextField();
	    txtUsuario.setBounds(170,50,200,25);
	    getContentPane().add(txtUsuario);
            
            txtIdCliente= new JTextField();
            txtIdCliente.setBounds(500,20,200,25);
            getContentPane().add(txtIdCliente);
            
            txtEmail=new JTextField();
            txtEmail.setBounds(500,50,200,25);
            getContentPane().add(txtEmail);
            
            txtNombre= new JTextField();
            txtNombre.setBounds(170,80,200,25);
            getContentPane().add(txtNombre);
            
            txtApellido= new JTextField();
            txtApellido.setBounds(170,110,200,25);
            getContentPane().add(txtApellido);
            
            txtTelefono= new JTextField();
            txtTelefono.setBounds(500,110,200,25);
            getContentPane().add(txtTelefono);
        
            txtDireccion= new JTextField();
            txtDireccion.setBounds(500,110,200,25);
            getContentPane().add(txtDireccion);
            
            txtCantidad= new JTextField();
            txtCantidad.setBounds(500,110,200,25);
            getContentPane().add(txtCantidad);

        
		// SE CREAN LOS RADIO BUTTON

            Aceite= new JMenuItem("Aceite");
            Tornillos=new JMenuItem("Tornillos");
            Caja_Filtro = new JMenuItem("Caja Filtro");
            Llantas= new JMenuItem("Llantas");
            Liquido_Frenos= new JMenuItem("Liquido de frenos");
            
            
    
            //CREAMOS LOS BOTONES
		
                
                Nuevo= new JButton();
		Nuevo.setText("Guardar");
		Nuevo.setBounds(100,500,150,30);//x,y,ancho,largo
		getContentPane().add(Nuevo);
		Nuevo.addActionListener(this);


		Buscar= new JButton();
		Buscar.setText("Buscar");
		Buscar.setBounds(300,500,150,30);//x,y,ancho,largo
		getContentPane().add(Buscar);
		Buscar.addActionListener(this);


		dtm = new DefaultTableModel(datos,Columnas);// forma de la tabla
		TablaVentas= new JTable(dtm); // indican el modelo de la tabla
		tablapanel = new JScrollPane(TablaVentas);

		TablaVentas. setModel(dtm);
		tablapanel.setBounds(10,210,800,200);
		tablapanel.setVisible(true);
		tablapanel.setEnabled(false);
		getContentPane().add(tablapanel);

		txtNroFactura.addKeyListener(this);
		txtUsuario.addKeyListener(this);
		txtIdCliente.addKeyListener(this);
		txtNombre.addKeyListener(this);
                txtApellido.addKeyListener(this);
                txtDireccion.addKeyListener(this);


		this.repaint();
}
        

    

    

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    public void actionPerformed(ActionEvent event, String Producto){
		if(event.getSource()==Nuevo){  //nuevo
			String Estado="",Fecha;

			

			if(txtNroFactura.getText().equals("")||txtUsuario.getText().equals("")
				||txtIdCliente.getText().equals("")||txtDireccion.getText().equals("")
                                ||txtCantidad.getText().equals("")||Estado.equals(""))
			{
					JOptionPane.showMessageDialog(this,"No pueden haber campos vacios");
			}else{
				if(Verificar()){
					JOptionPane.showMessageDialog(null,"Ya existe el usuario");
				}else{



			Mat[i][0]=txtNroFactura.getText();
                        Mat[i][1]=Estado;//ASI SE LLENAN  UN COMBOBOX
			Mat[i][2]=txtUsuario.getText();
			Mat[i][3]=txtIdCliente.getText();		//ASI SE LLENAN LOS CUADROS DE TEXTO
			Mat[i][4]=txtEmail.getText();
			Mat[i][5]=txtDireccion.getText();
			Mat[i][6]=Producto;
                        Mat[i][7]=txtCantidad.getText();
			Mat[i][8]=Estado;//ASI SE LLENAN  UN COMBOBOX


			numReg++;
			i++;


			Limpiar();
			JOptionPane.showMessageDialog(this,"Datos Guardados con exito");

			LlenarTabla(Mat,i);
			Nuevo.setEnabled(true);
			}	}
		}

		if(event.getSource()==Buscar){ 
			Buscar();

		}
			if(event.getSource()==Nuevo){

                                Guardar.setEnabled(true);
			
			}

		    if(event.getSource()==Actualizar) //comienza actualizar
	{
	if(Verificar())
	{
			int i=VerificarFila();


            TablaVentas.setValueAt(txtNroFactura.getText(),i,0);
            TablaVentas.setValueAt(txtUsuario.getText(),i,2);
            TablaVentas.setValueAt(txtIdCliente.getText(),i,3);
            TablaVentas.setValueAt(txtEmail.getText(),i,4);
            TablaVentas.setValueAt(txtDireccion.getText(),i,5);
            TablaVentas.setValueAt(txtCantidad.getText(),i,7);
	    




	JOptionPane.showMessageDialog(null,"Los datos se han modificado sactisfactoriamente");
	}
else
	{
	JOptionPane.showMessageDialog(null,"No se pudo modificar la clave");
    }


  }

   	}


   	public void LlenarTabla(String mat[][],int i){
   		int k;
   		int j;
   		Object [][] datos = new Object [i][20];//estructura interna de la tabal
   		for(j=0;j<i;j++){

   		for (k = 0; k<19; k++) {
   			datos[j][k]= mat[j][k];
   			dtm = new DefaultTableModel(datos,Columnas);
   			TablaVentas.setModel(dtm);
   		}
   		}

   	}

    
   	public void keyTyped(KeyEvent e) {
        //System.out.println("tiped");
        char caracter = e.getKeyChar(); // para leer el caracter correspondiente a la tecla
        int numero = (int) (caracter);
     if (e.getSource() == txtNroFactura) {
			if (((caracter < '0') || (caracter > '9')) )
                        {
                 	e.consume();

                 }
    }
    if (e.getSource() == txtUsuario) {
			if (Character.isDigit(caracter) == true)
                        {
                 	e.consume();

                 }
    }


    if (e.getSource() == txtIdCliente) {
			if (((caracter < '0') || (caracter > '9')) )
                        {
					e.consume();

                 }
    }



    if (e.getSource() == txtEmail) {
			if (Character.isDigit(caracter) == true)
                        {
					e.consume();

                 }
    }
    
    if (e.getSource() == txtNombre) {
			if (Character.isDigit(caracter) == true)
                        {
					e.consume();

                 }
    }
    
    if (e.getSource() == txtApellido) {
			if (Character.isDigit(caracter) == true)
                        {
					e.consume();

                 }
    }
    
    if (e.getSource() == txtDireccion) {
			if (Character.isDigit(caracter) == true)
                        {
					e.consume();

                 }
    }
    
    



   	}

    
   	public static void main (String[] args) {
   		Pildora1 p = new Pildora1();
	}

	public void Buscar(){ // Aqui empieza el buscar
		String Doc,Sexo;
		int z=0;
		Doc= JOptionPane.showInputDialog("Ingrese el Nro de Factura");
		while(z<TablaVentas.getRowCount() && !TablaVentas.getValueAt(z,2).toString().equals(Doc)){
			z++;
		}
		if(z<i){
			txtNombre.setText(TablaVentas.getValueAt(z,0).toString());
			txtApellido.setText(TablaVentas.getValueAt(z,1).toString());
			txtNroFactura.setText(TablaVentas.getValueAt(z,2).toString());
			txtTelefono.setText(TablaVentas.getValueAt(z,5).toString());

			txtDireccion.setText(TablaVentas.getValueAt(z,7).toString());//ESTTO ES ESTO
			txtEmail.setText(Mat[z][8]);//TERMINAR DE HACER ESTO

                    
                        
			//ACUERDESE DE HACE LO ANTERIOR

			Nuevo.setEnabled(false);
			Actualizar.setEnabled(true);
			Mostrar.setEnabled(true);

		}else{
			JOptionPane.showMessageDialog(null,"No se encontro");
			Nuevo.setEnabled(true);
                        
		}
	}

	public boolean Verificar(){
		String Ver;
		int z=0;
		boolean res;
		Ver=txtNroFactura.getText();    
		while(z<i  && !Ver.equals(Mat[z][2])){
			z++;
		}
		if(z<i){
			res=true;
		}else{
			res=false;
		}
		return res;

	}

	public int VerificarFila(){
		String Ver;
		int z=0;
		boolean res;
		Ver=txtNroFactura.getText();
		while(z<i  && !Ver.equals(Mat[z][2])){
			z++;
		}
		return z;

	}

	public void eliminar(){ // Este es el deshabilitar
		for(int w=0;w<TablaVentas.getRowCount();w++)
  				{
  					if(TablaVentas.getValueAt(w,2).toString().equals(txtNroFactura.getText()))
  					{
  						dtm.removeRow(w);
  					}
  				}


	}

	public void Limpiar(){
                        txtUsuario.setText("");
		txtNroFactura.setText("");
			txtNombre.setText("");
			txtApellido.setText("");
			txtTelefono.setText("");
			txtDireccion.setText("");
			txtEmail.setText("");
		
			
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

