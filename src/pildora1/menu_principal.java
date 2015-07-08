/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pildora1;

import javax.swing.*; //Esto es para la parte grafica, interfaz
import java.awt.event.*;// es para los eventos
import java.awt.*;// hace parte tambn de la parte grafica


public class menu_principal extends JFrame implements ActionListener{
	JLabel lblimagen; // se crea un label para colocar la imagen
	Icon Foto; //imagen
	JMenuBar barraMenu= new JMenuBar ();// asi se coloca la barra de menu
	JMenu Interfaces=new JMenu("Menu Principal");// el nombre que tendra la barra de menu
	JMenuItem Usuario, Motos, Clientes , Empleados, Ventas ;
        //Estos son los items que tendra la lista desplegable de la barra de menu
        
        

    public menu_principal() { //la clase


    super("Motos Pildora - Menú Principal");
    setSize(600,450);// tamaño de la ventana
    setResizable(false);
    setBackground(Color.white);//color de la ventana
    setVisible(true);//colocar visibles los objetos
    setLayout(null);//esta es la clase la que decide la posicion de los botones 
    setLocationRelativeTo(null);
    setDefaultCloseOperation(menu_principal.EXIT_ON_CLOSE);


  Icon image = new ImageIcon(getClass().getResource("/imagenes/DSCF0314.jpg"));
  
   lblimagen = new JLabel(image);
   lblimagen.setBounds(1,1,650,500);
   getContentPane().add(lblimagen);
    
    Usuario= new JMenuItem("Usuarios");
    Motos=new JMenuItem("Motos");
    Clientes = new JMenuItem("Clientes");
    Empleados= new JMenuItem("Empleados");
    Ventas= new JMenuItem("Ventas");
    

    Interfaces.add(Usuario);
    Interfaces.add(Motos);
    Interfaces.add(Clientes);
    Interfaces.add(Empleados);
    Interfaces.add(Ventas);
    

    barraMenu.add(Interfaces);
    setJMenuBar(barraMenu);
    Clientes.addActionListener(this);
    Usuario.addActionListener(this);
    Ventas.addActionListener(this);
    }

    public void actionPerformed(ActionEvent event)
   	{

   	if(event.getSource()==Clientes){
   		Clientes cl = new  Clientes();
                
        }
                if(event.getSource()==Usuario){
   		Usuario u = new  Usuario();            
   	}
                if(event.getSource()==Ventas){
   		Ventas v = new  Ventas();            
   	}

                     
   	
}
        }

