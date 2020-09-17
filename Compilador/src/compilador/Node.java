/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

/**
 *
 * @author edujg
 */
import java.util.ArrayList;

public class Node {
    public String nombre="";
    public String valor="";    
    public ArrayList<Node> hijos;

    public Node(String nombre) {
        this.nombre = nombre;
        this.valor = "<non-terminal>";
        hijos = new ArrayList();
    }
       
    public Node(String nombre, String valor) {
        this.nombre = nombre;
        this.valor = valor;
        hijos = new ArrayList();
    }

    public void addNode(Object node){
        if (node != null) {
            hijos.add((Node)node);
        }        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<Node> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Node> hijos) {
        this.hijos = hijos;
    }        

    
    
    @Override
    public String toString() {
        if (valor.equals("<non-terminal>")) {
            return nombre;
        }else{
            return nombre+" -- "+valor;
        }
    }
    
    
    
}

