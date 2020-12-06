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
public class Entry {
    String id, ambito, tipo;
    int offset;
    Entry(String i, String t, String a, int o){
        id = i;
        tipo = t;
        ambito = a;
        offset = o;
    }
}
