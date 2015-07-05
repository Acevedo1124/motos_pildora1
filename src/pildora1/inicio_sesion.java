/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pildora1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class inicio_sesion extends JFrame implements ActionListener,KeyListener{

	Icon Ent = new ImageIcon("aceptar.png"); //Asi se colocan las imagenes 
	Icon Sal = new ImageIcon("salir.png");


	JLabel lblUsuario=new JLabel ("Usuario");
	JLabel lblClave=new JLabel ("Clave");

	JTextField txtUsuario=new JTextField();
	JPasswordField txtClave=new JPasswordField();

	JButton btnSalir=new JButton(Sal);
	JButton btnAceptar=new JButton(Ent);

 public inicio_sesion() {

     super("Motos pildora - Inicio de sesión ");//Nombre que se la a la ventana
     getContentPane().setLayout(null);//para obtener todo lo que hay en la ventana
     setSize(300,250);//tamaño de la ventana
     setResizable(false);// para que no se pueda modificar la ventana
     setBackground(Color.white);//Coloco fondo ala ventana
     setVisible(true); //Con esta opcion hago visible la ventana
     setLocationRelativeTo(null); // preguntar a sebas, quede en el centro

     lblUsuario.setForeground(java.awt.Color.black);
     lblClave.setForeground(java.awt.Color.black);

	 lblUsuario.setBounds(30,30,100,20);
     txtUsuario.setBounds(100,30,100,30);
     txtUsuario.addKeyListener(this);



     lblClave.setBounds(30,90,100,30);
     txtClave.setBounds(100,90,100,30);
     txtClave.addKeyListener(this);

     btnAceptar.setBounds(30,150,120,30);
     btnSalir.setBounds(160,150,120,30);

	 btnSalir.setText("Salir");
	 btnAceptar.setText("Aceptar");

     this.getContentPane().add(lblUsuario);
     this.getContentPane().add(lblClave);
     this.getContentPane().add(txtUsuario);
     this.getContentPane().add(txtClave);
     this.getContentPane().add(btnSalir);
     this.getContentPane().add(btnAceptar);

     lblUsuario.setVisible(true);
     lblClave.setVisible(true);
     txtUsuario.setVisible(true);
     txtClave.setVisible(true);
     btnSalir.setVisible(true);
     btnAceptar.setVisible(true);

	 btnAceptar.addActionListener(this);
	 btnSalir.addActionListener(this);



   	this.repaint();

 		}

	 public void keyPressed(KeyEvent Even){

	 }
	 public void keyTyped(KeyEvent Even){
		char val=Even.getKeyChar();
	 	int tecla = (int)val;
	 	if(Even.getSource()==txtUsuario){
	 		if(tecla==10){
	 			Ingreso();
	 		}
	 	}
	 	if(Even.getSource()==txtClave){
	 		if(tecla==10){
	 			Ingreso();
	 		}
	 	}
	 }
 public void keyReleased(KeyEvent Even){

 }


   public void actionPerformed(ActionEvent event)
   {

	   	String nombre[]={"sofia "};
	   	String clave[]={"2014"};

	   	if(event.getSource()==btnSalir)
	   		{
	   		System.exit(0);
	   		}

	   		if(event.getSource()==btnAceptar){

   				Ingreso();
  			}
   }

  		public void Ingreso(){

	   		if(txtUsuario.getText().equals("")&&txtClave.getText().equals(""))
	   			{
	   			JOptionPane.showMessageDialog(null,"Los Campos estan vacios");
	   			}
	   		  	else
				{
				if(txtUsuario.getText().equals("sofia")&&txtClave.getText().equals("2014"))
				{
				menu_principal Menu =new menu_principal();
				this.dispose();
				}
				else
				{
				JOptionPane.showMessageDialog(null,"Usuario y/o contraseña invalidos");
				}



			}

			}
}


