/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplo2.views;
import com.mycompany.ejemplo2.Ejemplo2;
import com.mycompany.ejemplo2.models.Vehiculo;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author rodri
 */
public class VentanaP extends JFrame implements ActionListener{
    private JLabel lbltipo, lblduenio;
    private JTextField txtDuenio;
    private JComboBox cbTipo;
    private JButton btnGuardar;
    private JTable tabla;
    private DefaultTableModel modeloTabla;
    private Color color1 = new Color(47, 153, 84);
    private Color color2 = new Color(153,40,98);
    
    private String tipo;
    private String duenio;
    public VentanaP(){
        // AGREGAMOS LOS COMPONENTES A LA VENTANA
        lbltipo = new JLabel("Tipo de vehiculo:");
        lbltipo.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lbltipo.setBounds(30,15,250,15);
        lbltipo.setForeground(color2);
        lbltipo.setVisible(true);
        this.add(lbltipo);
        
        //COMBOBOX
        cbTipo = new JComboBox<>(new String[]{"Carro","Motocicleta","Barco"});
        cbTipo.setBounds(300,15,250,20);
        this.add(cbTipo);
        
        //LABEL DUEÑO
        lblduenio = new JLabel("Dueño:");
        lblduenio.setFont(new Font("Century Gothic", Font.BOLD, 15));
        lblduenio.setBounds(30,45,250,15);
        lblduenio.setForeground(color2);
        lblduenio.setVisible(true);
        this.add(lblduenio);
        
        //JTEXTFIELD DUEÑO
        txtDuenio = new JTextField("");
        txtDuenio.setFont(new Font("Century Gothic", Font.BOLD, 15));
        txtDuenio.setBounds(300,45,250,20);
        txtDuenio.setVisible(true);
        //txtDuenio.setEditable(false);
        //txtDuenio.setEnabled(false);
        this.add(txtDuenio);
        
        //BOTON GUARDAR
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(300,100,250,25);
        btnGuardar.setVisible(true);
        btnGuardar.addActionListener(this);
        this.add(btnGuardar);
        
        //JTABLE
        String[] encabezado = {"ID","Tipo","Dueño"};
        modeloTabla = new DefaultTableModel(encabezado, 0);
        tabla = new JTable(modeloTabla);
        
        JScrollPane sp = new JScrollPane(tabla);
        sp.setBounds(20,150,500,300);
        this.add(sp);
        
        //SIEMPRE PERO SIEMPREEEEE EL DISEÑO DE LA VENTANA VA HASTA DE ULTIMO EN EL CONSTRUCTOR
        // DISEÑO DE LA VENTANA
        // TITULO DE LA VENTANA
        this.setTitle("Ejemplo clase hoy");
        //COORDENADAS PARA TAMAÑO DE LA VENTANA
        /*
        THIS.SETBOUNDS(X1,Y1,X2,Y2);
        X1 = ESPACIO ENTRE LA PANTALLA Y LA VENTANA EN HORIZONTAL
        Y1 = ESPACIO ENTRE LA PANTALLA Y LA VENTANA EN VERTICAL
        X2 = TAMAÑO EN HORIZONTAL DE LA VENTANA
        Y2 = TAMAÑO EN VERTICAL DE LA VENTANA
        */
        this.setBounds(150,150,750,550);
        //AGREGAR UN LAYOUT DE JAVA
        this.setLayout(new BorderLayout(10,10));
        //QUITAR OPCION QUE EL USUARIO CAMBIE EL TAMAÑO DE LA VENTANA
        this.setResizable(false);
        //VER LA VENTANA
        this.setVisible(true);
        //COLOR DE FONDO DE LA VENTANA
        this.getContentPane().setBackground(color1);
        //CERRAR LA VENTANA Y EL PROCESO EN EJECUCION
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        actualizarTabla();
    }
    
    public void actualizarTabla(){
        modeloTabla.setRowCount(0);
        
        for(Vehiculo fila: Ejemplo2.lista()){
            String[] fvehiculo = {String.valueOf(fila.getId()),fila.getTipo(), fila.getDuenio()};
            modeloTabla.addRow(fvehiculo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        tipo = (String) cbTipo.getSelectedItem();
        duenio = txtDuenio.getText();
        if(e.getSource() == btnGuardar){
            Vehiculo nuevo = new Vehiculo(tipo, duenio);
            Ejemplo2.addVehiculo(nuevo);
            actualizarTabla();
        }
    }

}
