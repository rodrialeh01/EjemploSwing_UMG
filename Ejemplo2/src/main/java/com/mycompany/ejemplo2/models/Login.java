/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo2.models;

import com.mycompany.ejemplo2.views.VentanaP;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author rodri
 */
public class Login extends JFrame implements ActionListener{

    JLabel ltitulo, lusuario, lpwd;
    JTextField tfusuario;
    JPasswordField tpwd;
    String user, pwd;
    JButton blogin;
    
    public Login(){
        //TITULO
        ltitulo = new JLabel("LOGIN");
        ltitulo.setFont(new Font("Century Gothic",Font.BOLD,50));
        ltitulo.setBounds(200,10,400,90);
        ltitulo.setVisible(true);
        this.add(ltitulo);
        
        //label de codigo
        lusuario = new JLabel("Usuario: ");
        lusuario.setFont(new Font("Century Gothic",Font.BOLD,15));
        lusuario.setBounds(50,130,100,30);
        lusuario.setVisible(true);
        this.add(lusuario);
        
        //TEXTFIELD DE CODIGO
        tfusuario = new JTextField();
        tfusuario.setBounds(160,130,350,25);
        tfusuario.setFont(new Font("Century Gothic",Font.PLAIN,15));
        tfusuario.setVisible(true);
        this.add(tfusuario);
        
        //label de PASSWORD
        lpwd = new JLabel("Contrasenia: ");
        lpwd.setFont(new Font("Century Gothic",Font.BOLD,15));
        lpwd.setBounds(50,200,100,30);
        lpwd.setVisible(true);
        this.add(lpwd);
        
        //TEXTFIELD DE PASSWORD
        tpwd = new JPasswordField();
        tpwd.setBounds(160,200,350,25);
        tpwd.setFont(new Font("Century Gothic",Font.PLAIN,15));
        tpwd.setVisible(true);
        this.add(tpwd);
        
        //BOTON ELIMINAR CURSO
        blogin = new JButton("Iniciar Sesión");
        blogin.setFont(new Font("Century Gothic",Font.PLAIN,15));
        blogin.setBounds(240,280,150,30);
        blogin.addActionListener(this);
        //BLOQUEAR UN BOTON
        //beliminar.setEnabled(false);
        this.add(blogin);

        //DISEÑO DE LA VENTANA
        this.setTitle("Login");
        this.setBounds(400, 200, 600, 400);
        this.getContentPane().setBackground(Color.YELLOW);
        this.setLayout(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        user = tfusuario.getText();
        pwd = tpwd.getText();
        
        if(e.getSource() == blogin){
            if(user.equals("admin") && pwd.equals("admin")){
                VentanaP vp = new VentanaP();
                this.dispose();
                JOptionPane.showMessageDialog(this, "BIENVENIDO");
            }else{
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }
        }
    }
    
}
