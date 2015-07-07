/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pildora1;

import javax.swing.*; //Esto es para la parte grafica, interfaz
import java.awt.event.*;// es para los eventos
import java.awt.*;// hace parte tambn de la parte grafica





public class menu_principal extends JFrame implements ActionListener{
	JLabel imagen; // se crea un label para colocar la imagen
	Icon Foto; //imagen
	JMenuBar barraMenu= new JMenuBar ();// asi se coloca la barra de menu
	JMenu Interfaces=new JMenu("Menu Principal");// el nombre que tendra la barra de menu
	JMenuItem Usuarios, Motos, Clientes , Empleados, Servicios ;
	//Estos son los items que tendra la lista desplegable de la barra de menu

        

    public menu_principal() { //la clase


    super("Motos Pildora - Menú Principal");
    setSize(600,450);
    setResizable(false);
    setBackground(Color.white);
    setVisible(true);
    setLayout(null);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(menu_principal.EXIT_ON_CLOSE);



    Usuarios= new JMenuItem("Usuarios");
    Motos=new JMenuItem("Motos");
    Clientes = new JMenuItem("Clientes");
    Empleados= new JMenuItem("Empleados");
    Servicios= new JMenuItem("Compras");
    

    Interfaces.add(Usuarios);
    Interfaces.add(Motos);
    Interfaces.add(Clientes);
    Interfaces.add(Empleados);
    Interfaces.add(Servicios);
    

    barraMenu.add(Interfaces);
    setJMenuBar(barraMenu);
    Clientes.addActionListener(this);
    Foto= new ImageIcon(".jpg");
    imagen = new JLabel(Foto);
	imagen.setBounds(0,0,600,450);
	getContentPane().add(imagen);
ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagenes/" + imagen)); 

    }

    public void actionPerformed(ActionEvent event)
   	{

   	if(event.getSource()==Clientes){
   		Clientes cl = new  Clientes();

                     
   	}


   	}
}