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
public class Token {
    public String valor;
    public int token;
    Token(String val, int tok){
        valor = val;
        token = tok;
    }
}
