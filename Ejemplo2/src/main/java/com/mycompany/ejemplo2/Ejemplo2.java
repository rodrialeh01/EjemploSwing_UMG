/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplo2;
import com.mycompany.ejemplo2.models.Login;
import com.mycompany.ejemplo2.models.Vehiculo;
import com.mycompany.ejemplo2.views.VentanaP;
import java.util.LinkedList;
/**
 *
 * @author rodri
 */
public class Ejemplo2 {
    static LinkedList<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
    static int contador = 1;
    public static void main(String[] args) {
        //VentanaP ventana = new VentanaP();
        Login l = new Login();
    }
    
    public static void addVehiculo(Vehiculo nuevo){
        nuevo.setId(contador);
        vehiculos.add(nuevo);
        contador ++;
    }
    
    public static LinkedList<Vehiculo> lista(){
        return vehiculos;
    }
    
}
