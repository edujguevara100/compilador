/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

/**
 *
 * @author edujg
 */
public class Interfaz extends javax.swing.JFrame {

    /**
     * Creates new form Interfaz
     */
    public Interfaz() {
        initComponents();
        panel2.setVisible(false);
    }
    public static FileReader fr = null, fr2 = null;
    public static Node root;
    DefaultMutableTreeNode arbol;
    public static ArrayList<Entry> tabla_simbolos = new ArrayList<Entry>();
    public static ArrayList<String> ids, ids2, param;
    public static ArrayList<String> tipos_matrix;
    public static ArrayList<String> ids_params;
    public static int contador_ambito = 0, offset = 0;
    public static String ambito = "";
    public static boolean flag_ambito = false;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        bt_analizar = new javax.swing.JButton();
        bt_arbol = new javax.swing.JButton();
        panel2 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        jtree = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccionar Archivo:");
        panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, -1));

        jButton1.setText("Buscar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        panel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        bt_analizar.setText("Analizar");
        bt_analizar.setEnabled(false);
        bt_analizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_analizarMouseClicked(evt);
            }
        });
        panel1.add(bt_analizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, -1, -1));

        bt_arbol.setText("Ver Arbol");
        bt_arbol.setEnabled(false);
        bt_arbol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_arbolMouseClicked(evt);
            }
        });
        panel1.add(bt_arbol, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jtree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        scroll.setViewportView(jtree);

        panel2.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 370));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_analizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_analizarMouseClicked
        if (bt_analizar.isEnabled()) {
            int a = analisis();
            if (a == 1) {
                bt_arbol.setEnabled(true);
            }
            bt_analizar.setEnabled(false);
        }
    }//GEN-LAST:event_bt_analizarMouseClicked
    public static String tipo_valoro(Node n) {
        if (n.hijos.isEmpty()) {
            if (n.valor.contains("_")) {
                if (existe(n.valor)) {
                    return get_tipo(n.valor);
                } else {
                    System.out.println("La variable: " + n.valor + " no ha sido declarada");
                    return "int";
                }
            } else if (n.valor.contains("'")) {
                return "char";
            } else if (n.valor.equals("true") || n.valor.equals("false")) {
                return "bool";
            } else {
                return "int";
            }
        } else {
            if (n.valor.contains("_")) {
                //Funcion o Elemento de Matriz/Arreglo
                if (existe(n.valor)) {
                    String t = get_tipo(n.valor);
                    if (t.equals("int") || t.equals("bool") || t.equals("char")) {
                        System.out.println(n.valor + " es del tipo: " + t + ", no es funcion ni arreglo ni matriz");
                        return t;
                    } else if (!t.contains("->")) {
                        if (t.contains("array")) {
                            if (n.hijos.get(0).nombre.equals("LISTA POSICIONES")) {
                                System.out.println("Error, la variable: " + n.valor + " es un array, no una matriz");
                            } else {
                                if (tipo_valoro(n.hijos.get(0)).equals("int")) {
                                    return t.substring(t.indexOf("_") + 1, t.indexOf("{"));
                                } else {
                                    System.out.println("Error, los indices del arreglo deben de ser enteros");
                                }
                            }
                        } else {
                            if (n.hijos.get(0).nombre.equals("LISTA POSICIONES")) {
                                if (tipo_valoro(n.hijos.get(0).hijos.get(0)).equals("int")
                                        && tipo_valoro(n.hijos.get(0).hijos.get(1)).equals("int")) {
                                    return t.substring(t.indexOf("_") + 1, t.indexOf("{"));
                                } else {
                                    System.out.println("Error, los indices del arreglo deben de ser enteros");
                                }
                            } else {
                                if (tipo_valoro(n.hijos.get(0)).equals("int")) {
                                    return "array_" + t.substring(t.indexOf("_") + 1);
                                } else {
                                    System.out.println("Error, los indices del arreglo deben de ser enteros");
                                }
                            }
                        }
                    } else {
                        //revisar parametros con los hijos de n
                        param = new ArrayList<String>();
                        params(n);
                        String tip = t.substring(0, t.indexOf("-"));
                        String tipo[] = tip.split(" x ");
                        tipo[tipo.length - 1] = tipo[tipo.length - 1].replace(" ", "");
                        if (tipo.length != param.size()) {
                            System.out.println("Se esperaban: " + tipo.length + " parametros, y se encontraron: " + param.size());
                        } else {
                            for (int i = 0; i < param.size(); i++) {
                                if (!param.get(i).equals(tipo[i])) {
                                    System.out.println("Se esperaba un: " + tipo[i] + " y se encontro un: " + param.get(i));
                                }
                            }
                        }
                        return t.substring(t.indexOf("-> ") + 3);
                    }
                } else {
                    System.out.println("La variable: " + n.valor + " no ha sido declarada");
                    return "int";
                }
            } else if (n.nombre.equals("MATRIX")) {
                String tipo = "";
                tipos_matrix = new ArrayList<String>();
                matriz(n);
                tipo = tipos_matrix.get(0);
                for (int i = 1; i < tipos_matrix.size(); i++) {
                    if (!tipos_matrix.get(i).equals(tipo)) {
                        System.out.println("Se esperaba un: " + tipo + " y se encontro un: " + tipos_matrix.get(i));
                    }
                }
                return "matrix_" + tipo.substring(tipo.indexOf("_") + 1, tipo.indexOf("{"))
                        + "{" + tipos_matrix.size() + "," + tipo.substring(tipo.indexOf("{") + 1, tipo.indexOf("}")) + "}";
            } else if (n.nombre.equals("ARRAY")) {
                ids2 = new ArrayList<String>();
                array(n);
                String tipo = ids2.get(0);
                for (int i = 1; i < ids2.size(); i++) {
                    if (!ids2.get(i).equals(tipo)) {
                        System.out.println("Se esperaba un: " + tipo + " y se encontro un: " + ids2.get(i));
                    }
                }
                return "array_" + tipo + "{" + ids2.size() + "}";
            } else if (n.valor.equals("+")
                    || n.valor.equals("-")
                    || n.valor.equals("*")
                    || n.valor.equals("/")) {
                comprueba_op(n);
                return "int";
            } else {
                comprueba_op_bool(n);
                return "bool";
            }
        }
        return "int";
    }

    public static void matriz(Node n) {
        for (int i = 0; i < n.hijos.size(); i++) {
            if (n.hijos.get(i).nombre.equals("MATRIX")) {
                matriz(n.hijos.get(i));
            } else {
                ids2 = new ArrayList<String>();
                array(n.hijos.get(i));
                String ti = ids2.get(0);
                for (int j = 1; j < ids2.size(); j++) {
                    if (!ids2.get(j).equals(ti)) {
                        System.out.println("Se esperaba un: " + ti + " y se encontro un: " + ids2.get(j));
                    }
                }
                ti = "array_" + ti + "{" + ids2.size() + "}";
                tipos_matrix.add(ti);
            }
        }
    }

    public static void params(Node n) {
        for (int i = 0; i < n.hijos.size(); i++) {
            if (!n.hijos.get(i).nombre.equals("LISTA PARAMETROS")) {
                param.add(tipo_valoro(n.hijos.get(i)));
            } else {
                params(n.hijos.get(i));
            }
        }
    }

    public static void array(Node n) {
        for (int i = 0; i < n.hijos.size(); i++) {
            if (!n.hijos.get(i).nombre.equals("ARRAY")) {
                ids2.add(tipo_valoro(n.hijos.get(i)));
            } else {
                array(n.hijos.get(i));
            }
        }
    }

    public static void comprueba_op(Node act) {
        for (int i = 0; i < act.hijos.size(); i++) {
            if (act.hijos.get(i).valor.equals("+")
                    || act.hijos.get(i).valor.equals("-")
                    || act.hijos.get(i).valor.equals("*")
                    || act.hijos.get(i).valor.equals("/")) {
                comprueba_op(act.hijos.get(i));
            } else {
                String t = tipo_valoro(act.hijos.get(i));
                if (!t.equals("int")) {
                    System.out.println("Error, se esperaba un int y se encontro un:" + t);
                }
            }
        }
    }

    public static void comprueba_op_bool(Node act) {
        if (act.valor.equals("|")
                || act.valor.equals("&")) {
            String t = tipo_valoro(act.hijos.get(0));
            String t1 = tipo_valoro(act.hijos.get(1));
            if (!t.equals("bool") || !t1.equals("bool")) {
                System.out.println("Comparacion Booleana utilizando: " + t + " y " + t1 + ", en vez de bools");
            }
        } else if (act.valor.equals("<")
                || act.valor.equals(">")
                || act.valor.equals("<=")
                || act.valor.equals(">=")
                || act.valor.equals("!=")
                || act.valor.equals("==")) {
            String t = tipo_valoro(act.hijos.get(0));
            String t1 = tipo_valoro(act.hijos.get(1));
            if (!t.equals("int") || !t1.equals("int")) {
                System.out.println("Comparacion Relacional utilizando: " + t + " y " + t1 + ", en vez de ints");
            }
        } else if (act.nombre.equals("VALOR OP BOOL")) {
            if (act.hijos.size() == 3) {
                String x = tipo_valoro(act.hijos.get(1));
                if (!x.equals("bool")) {
                    System.out.println("ERRORRRR");
                }
            } else {
                String x = tipo_valoro(act.hijos.get(2));
                if (!x.equals("bool")) {
                    System.out.println("ERRORRRR");
                }
            }
        }
    }

    public static void llenar_tabla(Node actual) {
        if (actual.nombre.equals("DECLARACION")) {
            //FALTA CAMBIAR READ read_int?
            //FALTA MANEJAR RETURNS (imposible parece)
            //OPERACIONES EN CONDICIONES (imposible)
            //OFFSET
            //AMBITO
            String tipo = "";
            ids = new ArrayList<String>();
            tipo = actual.hijos.get(0).valor;
            agregar_ids(actual.hijos.get(1));
            for (int j = 0; j < ids.size(); j++) {
                agregar(new Entry(ids.get(j), tipo, ambito, offset));
            }
            ids = new ArrayList<String>();
            tipos_asig(actual.hijos.get(1), tipo);
        } else if (actual.nombre.equals("FUNCION")) {
            String tipo_retorno = "";
            String id_funcion = "";
            String dominio = "void";
            ids = new ArrayList<String>();
            ids_params = new ArrayList<String>();
            tipo_retorno = actual.hijos.get(0).valor;
            id_funcion = actual.hijos.get(1).valor;
            if (actual.hijos.get(2).nombre.equals("LISTA PARAMETROS")) {
                agregar_params(actual.hijos.get(2));
                dominio = "";
                for (int i = 0; i < ids.size(); i++) {
                    agregar(new Entry(ids_params.get(i), ids.get(i), id_funcion, offset));
                    if (i + 1 < ids.size()) {
                        dominio += ids.get(i) + " x ";
                    } else {
                        dominio += ids.get(i);
                    }
                }
            }
            dominio += " -> " + tipo_retorno;
            agregar(new Entry(id_funcion, dominio, id_funcion, 0));
            ids = new ArrayList<String>();
        } else if (actual.nombre.equals("BLOQUE FOR")) {
            if (actual.hijos.get(0).valor.equals("int")) {
                agregar(new Entry(actual.hijos.get(1).valor, actual.hijos.get(0).valor, ambito, offset));
            }
            if (!tipo_valoro(actual.hijos.get(3)).equals("int")) {
                System.out.println("Error en el for, se esperaba un int como limite superior");
            }
            if (!actual.hijos.get(1).valor.equals(actual.hijos.get(4).valor)) {
                System.out.println("Error, la variable declarada en el for debe ser la misma que se utiliza para manejar su flujo");
            }
        } else if (actual.nombre.equals("BLOQUE OPTIONS")) {
            //FALTA VALORO PARA LAS OPT INDIVIDUALES
            if (actual.hijos.get(1).valor.equals("int") || actual.hijos.get(1).valor.equals("char")) {
                if (existe(actual.hijos.get(0).valor)) {
                    String t = get_tipo(actual.hijos.get(0).valor);
                    if (!t.equals(actual.hijos.get(1).valor)) {
                        System.out.println("La variable: " + actual.hijos.get(0).valor + ", no es del tipo: " + actual.hijos.get(1).valor);
                    } else {
                        if (!actual.hijos.get(2).nombre.equals("BLOQUE DEFAULT OPTION")) {
                            ids = new ArrayList<String>();
                            options(actual.hijos.get(2));
                            String toption = ids.get(0);
                            for (int i = 1; i < ids.size(); i++) {
                                if (!toption.equals(ids.get(i))) {
                                    System.out.println("Los tipos de las opciones no son congruentes");
                                }
                            }
                            if (!actual.hijos.get(1).valor.equals(toption)) {
                                System.out.println("El BLOQUE OPTIONS esperaba casos del tipo: " + actual.hijos.get(1) + " y se encontro con casos de tipo: " + toption);
                            }
                            ids = new ArrayList<String>();
                        }
                    }
                } else {
                    System.out.println("La variable: " + actual.hijos.get(0).valor + " no ha sido declarada");
                }
            } else {
                System.out.println("Error en el bloque options, se esperaba un int o un char para los tipos de casos y se econtro: " + actual.hijos.get(1));
            }

        } else if (actual.nombre.equals("READ")) {
            if (!existe(actual.hijos.get(0).valor)) {
                System.out.println("La variable: " + actual.hijos.get(0).valor + ", no ha sido declarada");
            }
        } else if (actual.nombre.equals("LLAMADA FUNCION")) {
            if (existe(actual.hijos.get(0).valor)) {
                //Comprobar tipos
                String t = get_tipo(actual.hijos.get(0).valor);
            } else {
                System.out.println("La funcion: " + actual.hijos.get(0).valor + " no existe");
            }
        } else if (actual.nombre.equals("ASIGNACION")) {
            if (existe(actual.hijos.get(0).valor)) {
                String te = get_tipo(actual.hijos.get(0).valor);
                String to = tipo_valoro(actual.hijos.get(2));
                if (!to.equals(te)) {
                    System.out.println("Error de tipo, se esperaba: " + te + " y se encontro: " + to);
                }
            } else {
                System.out.println("La variable: " + actual.hijos.get(0).valor + ", no ha sido declarada");
            }
        } else if (actual.nombre.equals("BLOQUE IF")) {
            String t = tipo_valoro(actual.hijos.get(0));

            if (!t.equals("bool")) {
                System.out.println("Error de tipo, se esperaba un bool, y se encontro un: " + t);
            }
        } else if (actual.nombre.equals("BLOQUE ELSE IF")) {
            String t = tipo_valoro(actual.hijos.get(0));

            if (!t.equals("bool")) {
                System.out.println("Error de tipo, se esperaba un bool, y se encontro un: " + t);
            }
        } else if (actual.nombre.equals("BLOQUE LOOP")) {
            String t = tipo_valoro(actual.hijos.get(0));

            if (!t.equals("bool")) {
                System.out.println("Error de tipo, se esperaba un bool, y se encontro un: " + t);
            }
        }
        for (int i = 0; i < actual.hijos.size(); i++) {
            if (actual.nombre.equals("FUNCION")) {
                ambito = actual.hijos.get(1).valor;
                offset = 0;
            } else if (actual.nombre.equals("MAIN")) {
                if (actual.hijos.get(i).nombre.equals("CODE")) {
                    ambito = "main";
                    offset = 0;
                }
            } else if (actual.nombre.equals("BLOQUE IF")
                    || actual.nombre.equals("BLOQUE ELSE IF")
                    || actual.nombre.equals("BLOQUE ELSE")
                    || actual.nombre.equals("BLOQUE OPTION")
                    || actual.nombre.equals("BLOQUE DEFAULT OPTION")
                    || actual.nombre.equals("BLOQUE LOOP")
                    || actual.nombre.equals("BLOQUE FOR")) {
                System.out.println(actual.nombre);
                ambito += "," + contador_ambito;
                contador_ambito++;
                flag_ambito = true;
            }
            if (!actual.hijos.get(i).hijos.isEmpty()) {
                llenar_tabla(actual.hijos.get(i));
            }
            if (flag_ambito) {
                ambito = ambito.substring(0, ambito.lastIndexOf(","));
                flag_ambito = false;
            }

        }
    }

    public static void options(Node n) {
        ids.add(tipo_valoro(n.hijos.get(0)));
        for (int i = 1; i < n.hijos.size(); i++) {
            if (n.hijos.get(i).nombre.equals("BLOQUE OPTION")) {
                options(n.hijos.get(i));
            }
        }
    }

    public static String get_tipo(String s) {
        for (int i = 0; i < tabla_simbolos.size(); i++) {
            if (s.equals(tabla_simbolos.get(i).id)) {
                return tabla_simbolos.get(i).tipo;
            }
        }
        return "";
    }

    public static boolean existe(String s) {
        for (int i = 0; i < tabla_simbolos.size(); i++) {
            if (s.equals(tabla_simbolos.get(i).id)) {
                return true;
            }
        }
        return false;
    }

    public static void agregar(Entry e) {
        boolean esta = false;
        for (int i = 0; i < tabla_simbolos.size(); i++) {
            if (e.id.equals(tabla_simbolos.get(i).id)) {
                esta = true;
                break;
            }
        }
        if (esta) {
            System.out.println("La variable: " + e.id + " ya fue declarada");
        } else {
            tabla_simbolos.add(e);
        }
    }

    public static void agregar_params(Node actual) {
        for (int i = 0; i < actual.hijos.size(); i++) {
            if (actual.hijos.get(i).nombre.equals("TYPE")) {
                ids.add(actual.hijos.get(i).valor);
                //agregar(new Entry(actual.hijos.get(i+1).valor, actual.hijos.get(i).valor, ""));
            } else if (actual.hijos.get(i).nombre.equals("ID")) {
                ids_params.add(actual.hijos.get(i).valor);
            } else if (actual.hijos.get(i).nombre.equals("PARAMETROS TIPADOS")) {
                agregar_params(actual.hijos.get(i));
            }
        }
    }

    public static void agregar_ids(Node actual) {
        for (int i = 0; i < actual.hijos.size(); i++) {
            if (!actual.hijos.get(i).valor.equals("<non-terminal>")) {
                boolean esta = false;
                for (int j = 0; j < tabla_simbolos.size(); j++) {
                    if (actual.hijos.get(i).valor.equals(tabla_simbolos.get(j).id)) {
                        esta = true;
                        break;
                    }
                }
                if (esta) {
                    System.out.println("Error, la variable " + actual.hijos.get(i).valor + " ya esta declarada");
                } else {
                    ids.add(actual.hijos.get(i).valor);
                }

            } else if (actual.hijos.get(i).nombre.equals("LISTA DE VARIABLES")) {
                agregar_ids(actual.hijos.get(i));
            }
        }
    }

    public static void tipos_asig(Node actual, String tipo) {
        for (int i = 0; i < actual.hijos.size(); i++) {
            if (!actual.hijos.get(i).valor.equals("<non-terminal>")) {
                boolean esta = false;
                for (int j = 0; j < tabla_simbolos.size(); j++) {
                    if (actual.hijos.get(i).valor.equals(tabla_simbolos.get(j).id)) {
                        esta = true;
                        break;
                    }
                }
                if (esta) {
                    ids.add(actual.hijos.get(i).valor);
                }
            } else if (actual.hijos.get(i).nombre.equals("LISTA DE VARIABLES")) {
                tipos_asig(actual.hijos.get(i), tipo);
            } else {
                //DECLARACION CON ASIGNACION
                String t = tipo_valoro(actual.hijos.get(i).hijos.get(1));
                if (!t.equals(tipo)) {
                    System.out.println("Error, la variable: " + ids.get(ids.size() - 1) + " es del tipo " + tipo + " y se le esta asignando: " + t);
                }
            }
        }
    }

    public static int analisis() {
        try {
            // TODO add your handling code here:
            AnalizadorLexico lexico = new AnalizadorLexico(fr);
            String result = "";
            String erroreslex = "";
            ArrayList<Token> tokens = new ArrayList<Token>();
            while (true) {
                Symbol tok = lexico.next_token();
                if (tok.sym == sym.EOF) {
                    //System.out.println("Analisis Lexico");
                    if (!lexico.error.equals("")) {
                        //System.out.println(lexico.error);
                        erroreslex = lexico.error;
                    } else {
                        //System.out.println("No se encontraron errores lexicos");
                    }
                    break;
                } else {
                    if (tok.sym != sym.error) {
                        tokens.add(new Token(tok.value.toString(), tok.sym));
                    }
                }
            }
            if (!lexico.error.equals("")) {
                File file = new File("C:/Users/edujg/Desktop/Eduardo/Compilador/src/compilador/correcion.txt");
                FileWriter f = new FileWriter("C:/Users/edujg/Desktop/Eduardo/Compilador/src/compilador/correccion.txt");
                for (int i = 0; i < tokens.size(); i++) {
                    result += tokens.get(i).valor + " ";
                }
                f.write(result);
                f.close();
                fr2 = new FileReader("C:/Users/edujg/Desktop/Eduardo/Compilador/src/compilador/correccion.txt");
            }
            lexico = new AnalizadorLexico(fr2);
            //System.out.println("");
            //System.out.println("Analisis Sintactico");
            parser parser = new parser(lexico);
            parser.parse();
            if (parser.errorNR.equals("")) {
                if (!parser.error.equals("") && !erroreslex.equals("")) {
                    String errores = "Análisis Léxico:\n\n" + erroreslex + "\n\nAnálisis Sintáctico:\n\n" + parser.error + "\n";
                    JOptionPane.showMessageDialog(null, errores, "Análisis de Codigo", JOptionPane.ERROR_MESSAGE);
                    //System.out.println(parser.error);
                } else if (!erroreslex.equals("")) {
                    String errores = "Análisis Léxico:\n\n" + erroreslex + "\n\nAnálisis Sintáctico:\n\nNo hay errores sintácticos";
                    JOptionPane.showMessageDialog(null, errores, "Análisis de Codigo", JOptionPane.ERROR_MESSAGE);
                } else if (!parser.error.equals("")) {
                    String errores = "Análisis Léxico:\n\nNo hay errores léxicos" + "\n\nAnálisis Sintáctico:\n\n" + parser.error + "\n";
                    JOptionPane.showMessageDialog(null, errores, "Análisis de Codigo", JOptionPane.ERROR_MESSAGE);
                } else {
                    String errores = "Análisis Léxico:\n\nNo hay errores léxicos" + "\n\nAnálisis Sintáctico:\n\nNo hay errores sintácticos";
                    JOptionPane.showMessageDialog(null, errores, "Análisis de Codigo", JOptionPane.INFORMATION_MESSAGE);
                }
                root = parser.raiz;
                llenar_tabla(root);
                for (int i = 0; i < tabla_simbolos.size(); i++) {
                    System.out.println("ID: " + tabla_simbolos.get(i).id
                            + " TIPO: " + tabla_simbolos.get(i).tipo
                            + " AMBITO: " + tabla_simbolos.get(i).ambito);
                }
                return 1;
            } else {
                if (!parser.error.equals("") && !erroreslex.equals("")) {
                    String errores = "Análisis Léxico:\n\n" + erroreslex + "\n\nAnálisis Sintáctico:\n\n" + parser.error + "\n" + parser.errorNR;
                    JOptionPane.showMessageDialog(null, errores, "Análisis de Codigo", JOptionPane.ERROR_MESSAGE);
                    //System.out.println(parser.error);
                } else if (!lexico.error.equals("")) {
                    String errores = "Análisis Léxico:\n\n" + erroreslex + "\n\nAnálisis Sintáctico:\n\nNo hay errores sintácticos" + parser.errorNR;
                    JOptionPane.showMessageDialog(null, errores, "Análisis de Codigo", JOptionPane.ERROR_MESSAGE);
                } else if (!parser.error.equals("")) {
                    String errores = "Análisis Léxico:\n\nNo hay errores léxicos" + "\n\nAnálisis Sintáctico:\n\n" + parser.error + "\n" + parser.errorNR;
                    JOptionPane.showMessageDialog(null, errores, "Análisis de Codigo", JOptionPane.ERROR_MESSAGE);
                } else {
                    String errores = "Análisis Léxico:\n\nNo hay errores léxicos" + "\n\nAnálisis Sintáctico:\n\n" + parser.errorNR;
                    JOptionPane.showMessageDialog(null, errores, "Análisis de Codigo", JOptionPane.ERROR_MESSAGE);
                }
            }
            return 2;
        } catch (Exception ex) {
            //System.out.println(ex.toString());
        }
        return 2;
    }

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);
            File abre = file.getSelectedFile();
            if (abre != null) {
                fr = new FileReader(abre);
                fr2 = new FileReader(abre);
                bt_analizar.setEnabled(true);
            }
        } catch (Exception ex) {
            System.out.println("ERROR AL ABRIR ARCHIVO");
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void bt_arbolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_arbolMouseClicked
        // TODO add your handling code here:
        if (bt_arbol.isEnabled()) {
            panel1.setVisible(false);
            arbol = new DefaultMutableTreeNode(root);
            DefaultTreeModel modelo = (DefaultTreeModel) jtree.getModel();
            llenar(root, arbol);
            modelo.setRoot(arbol);
            jtree.setModel(modelo);
            panel2.setVisible(true);
        }
    }//GEN-LAST:event_bt_arbolMouseClicked

    public static void llenar(Node root, DefaultMutableTreeNode current) {
        for (int i = 0; i < root.hijos.size(); i++) {
            current.add(new DefaultMutableTreeNode(root.hijos.get(i)));
            if (!root.hijos.get(i).hijos.isEmpty()) {
                llenar(root.hijos.get(i), (DefaultMutableTreeNode) current.getChildAt(i));
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                generateLexer();
                new Interfaz().setVisible(true);
            }
        });
    }

    public static void generateLexer() {
        String[] param = new String[3];
        param[0] = "-d";
        param[1] = "src/compilador";
        param[2] = "src/compilador/Lexer.flex";
        String[] param2 = {"-destdir", "src/compilador/", "-parser", "parser", "src/compilador/Cup.cup"};
        try {
            jflex.Main.generate(param);
            System.out.println("Funciono1");
            java_cup.Main.main(param2);
            System.out.println("Funciono2");
        } catch (Exception e) {
            System.out.println("No funciono");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_analizar;
    private javax.swing.JButton bt_arbol;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTree jtree;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
}
