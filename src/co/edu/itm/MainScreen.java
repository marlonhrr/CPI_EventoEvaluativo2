package co.edu.itm;

import java.awt.Color;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

public class MainScreen extends javax.swing.JFrame {

    //public String lArchivo = "c:/hola.txt";
    JFileChooser ReadFile;
    File file;
    String line;
    String find;
    String b;
    String rn;
    //char alamacen;
    //int contadorPalabras;
    //int numTokens;
    FileReader fr;
    BufferedReader input;
    File read;
    public static String[] base;
    //public static String[] reconoce;
    //public String Almacena;
    public int ConERROR;
    //String letter;
    public int roww = 0;
    public int colum = 0;
    //int No = 0;
    public int aux = 0;
    public int cRow = 0;
    public int cColumn = 0;

    char[] caracter = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    String identifiers = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,ñ,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z";
    String operationals = "+,-,*,/,^,**,//,++,--,^^,||";
    String[] group = {"(,),[,],{,}"};
    String[] relationals = {"<,>,>=,<=,==,=,!="};

    public MainScreen() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(581, 450);
        setTitle("ITM - Lexico Analyzer");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        T_text = new javax.swing.JTextArea();
        jbAnalizer = new javax.swing.JButton();
        jl_ITM = new javax.swing.JLabel();
        jbOutputFile = new javax.swing.JButton();
        jbClear = new javax.swing.JButton();
        jbErrorFile = new javax.swing.JButton();
        jlScreen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        M_File = new javax.swing.JMenu();
        MI_Open = new javax.swing.JMenuItem();
        MI_Save = new javax.swing.JMenuItem();
        MI_Exit = new javax.swing.JMenuItem();
        M_Help = new javax.swing.JMenu();
        MI_UserManual = new javax.swing.JMenuItem();
        MI_About = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ITM.png")).getImage());
        getContentPane().setLayout(null);

        T_text.setBackground(new java.awt.Color(153, 153, 153));
        T_text.setColumns(20);
        T_text.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        T_text.setForeground(new java.awt.Color(255, 255, 255));
        T_text.setRows(5);
        T_text.setCaretColor(new java.awt.Color(255, 255, 255));
        T_text.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                T_textCaretUpdate(evt);
            }
        });
        jScrollPane1.setViewportView(T_text);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 10, 394, 345);

        jbAnalizer.setBackground(new java.awt.Color(255, 255, 255));
        jbAnalizer.setText("Analizer");
        jbAnalizer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnalizerActionPerformed(evt);
            }
        });
        getContentPane().add(jbAnalizer);
        jbAnalizer.setBounds(420, 20, 120, 40);

        jl_ITM.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jl_ITM.setForeground(new java.awt.Color(255, 255, 255));
        jl_ITM.setText("ITM - 2020");
        getContentPane().add(jl_ITM);
        jl_ITM.setBounds(180, 360, 90, 20);

        jbOutputFile.setBackground(new java.awt.Color(255, 255, 255));
        jbOutputFile.setText("Output file");
        jbOutputFile.setToolTipText("");
        jbOutputFile.setMaximumSize(new java.awt.Dimension(76, 32));
        jbOutputFile.setMinimumSize(new java.awt.Dimension(76, 32));
        jbOutputFile.setPreferredSize(new java.awt.Dimension(76, 32));
        jbOutputFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOutputFileActionPerformed(evt);
            }
        });
        getContentPane().add(jbOutputFile);
        jbOutputFile.setBounds(420, 260, 120, 40);

        jbClear.setBackground(new java.awt.Color(255, 255, 255));
        jbClear.setText("Clear");
        jbClear.setMaximumSize(new java.awt.Dimension(76, 32));
        jbClear.setMinimumSize(new java.awt.Dimension(76, 32));
        jbClear.setPreferredSize(new java.awt.Dimension(76, 32));
        jbClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClearActionPerformed(evt);
            }
        });
        getContentPane().add(jbClear);
        jbClear.setBounds(420, 70, 120, 40);

        jbErrorFile.setBackground(new java.awt.Color(255, 255, 255));
        jbErrorFile.setText("Error file");
        jbErrorFile.setMaximumSize(new java.awt.Dimension(76, 32));
        jbErrorFile.setMinimumSize(new java.awt.Dimension(76, 32));
        jbErrorFile.setPreferredSize(new java.awt.Dimension(76, 32));
        jbErrorFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbErrorFileActionPerformed(evt);
            }
        });
        getContentPane().add(jbErrorFile);
        jbErrorFile.setBounds(420, 310, 120, 40);

        jlScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/defScreen.jpg"))); // NOI18N
        getContentPane().add(jlScreen);
        jlScreen.setBounds(-120, 0, 790, 390);

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setToolTipText("");
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        M_File.setBackground(new java.awt.Color(255, 255, 255));
        M_File.setForeground(new java.awt.Color(51, 51, 51));
        M_File.setText("File");

        MI_Open.setBackground(new java.awt.Color(153, 153, 153));
        MI_Open.setForeground(new java.awt.Color(51, 51, 51));
        MI_Open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Defopenx16.png"))); // NOI18N
        MI_Open.setText("Open");
        MI_Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_OpenActionPerformed(evt);
            }
        });
        M_File.add(MI_Open);

        MI_Save.setBackground(new java.awt.Color(153, 153, 153));
        MI_Save.setForeground(new java.awt.Color(51, 51, 51));
        MI_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Defsavex16.png"))); // NOI18N
        MI_Save.setText("Save");
        MI_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_SaveActionPerformed(evt);
            }
        });
        M_File.add(MI_Save);

        MI_Exit.setBackground(new java.awt.Color(153, 153, 153));
        MI_Exit.setForeground(new java.awt.Color(51, 51, 51));
        MI_Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Deflogoutx16.png"))); // NOI18N
        MI_Exit.setText("Exit");
        MI_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_ExitActionPerformed(evt);
            }
        });
        M_File.add(MI_Exit);

        jMenuBar1.add(M_File);

        M_Help.setBackground(new java.awt.Color(255, 255, 255));
        M_Help.setForeground(new java.awt.Color(51, 51, 51));
        M_Help.setText("Help");

        MI_UserManual.setBackground(new java.awt.Color(153, 153, 153));
        MI_UserManual.setForeground(new java.awt.Color(51, 51, 51));
        MI_UserManual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Defmanualx16.png"))); // NOI18N
        MI_UserManual.setText("User Manual");
        MI_UserManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_UserManualActionPerformed(evt);
            }
        });
        M_Help.add(MI_UserManual);

        MI_About.setBackground(new java.awt.Color(153, 153, 153));
        MI_About.setForeground(new java.awt.Color(51, 51, 51));
        MI_About.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Defaboutx16.png"))); // NOI18N
        MI_About.setText("About");
        MI_About.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MI_AboutActionPerformed(evt);
            }
        });
        M_Help.add(MI_About);

        jMenuBar1.add(M_Help);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MI_OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_OpenActionPerformed

        /**
         * llamamos el metodo que permite cargar la ventana
         */
        ReadFile = new JFileChooser();
        //Hace la verificación si pertenece al rango.
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Documentos de texto (*.txt)", "txt");
        ReadFile.setFileFilter(filter);

        //Verifica si es o no
        int selection = ReadFile.showOpenDialog(null);
        //si es aprobado, sigue con el paso de abrir el archivo
        if (selection == JFileChooser.APPROVE_OPTION) { //lanza la ventana

            this.file = ReadFile.getSelectedFile(); //seleccione el archivo de arriba
            this.read = ReadFile.getSelectedFile();

            try {
                fr = new FileReader(file); //abre el archivo seleccionado
                input = new BufferedReader(fr); // lee la linea

                while ((this.line = input.readLine()) != null) {
                    MainScreen.T_text.setText(T_text.getText() + "\n" + line);
                    find = T_text.getText();
                    aux++;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_MI_OpenActionPerformed

    private void MI_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_ExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_MI_ExitActionPerformed

    private void T_textCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_T_textCaretUpdate

    }//GEN-LAST:event_T_textCaretUpdate

    private void jbAnalizerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnalizerActionPerformed
        String almacenA = T_text.getText();
        String L = "";
        int ConOperational = 0;
        int ConGroup = 0;
        int ConRelational = 0;
        int ConLetter = 0;
        int ConNumber = 0;

        ConERROR = 0;

        for (int j = 0; j <= almacenA.length() - 1; j++) {
            L = "" + almacenA.charAt(j);
            if (L.equals("+") | L.equals("-") | L.equals("*") | L.equals("/") | L.equals("^") | L.equals("**") | L.equals("//") | L.equals("++") | L.equals("--") | L.equals("^^") | L.equals("||")) {
                ConOperational++;
                System.out.println("Operational" + " * " + ConOperational);
            } else if (L.equals("(") | L.equals(")") | L.equals("[") | L.equals("]") | L.equals(":") | L.equals(";") | L.equals(",") | L.equals(";") | L.equals(":") | L.equals(".")) {
                ConGroup++;
                System.out.println("Group " + " * " + ConGroup);
            } else if (L.equals("<") | L.equals(">") | L.equals(">=") | L.equals("<=") | L.equals("==") | L.equals("=") | L.equals("!=")) {
                ConRelational++;
                System.out.println("Relational" + " * " + ConRelational);
            } else if (L.equals("@")) {
                rn = "@";
                ConERROR++;
                System.out.println("ERROR" + " * " + ConERROR);
            } else if ((L.equals("#"))) {
                rn = "#";
                ConERROR++;
                System.out.println("ERROR" + " * " + ConERROR);
            } else if (L.equals("0") | L.equals("1") | L.equals("2") | L.equals("3") | L.equals("4") | L.equals("5") | L.equals("6") | L.equals("7") | L.equals("8") | L.equals("9")) {
                ConNumber++;
                System.out.println("Number " + " * " + ConNumber);
            } else if (L.equals(identifiers)) {
                ConLetter++;
                System.out.println("Letter" + " * " + ConLetter);
            } else if (L.equals("\n")) {
                cRow++;
                cColumn = 0;
                System.out.println("ROW: " + "" + cRow + " " + "COLUMN: " + cColumn);
            } else if (L.equals(" ")) {
                cColumn++;
                System.out.println("COLUMN: " + cColumn);
            } else {
                System.out.println("ID");
            }
        }
        System.out.println("Operationals: " + ConOperational + " Relationals: " + ConRelational + " Groups: " + ConGroup + " Errors:" + ConERROR);
    }//GEN-LAST:event_jbAnalizerActionPerformed

    public void countLetters(String texto) {
        String[] letters = T_text.getText().split(" ");
        int quantity = letters.length;
        System.out.println(quantity);
    }

    private void jbOutputFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOutputFileActionPerformed
        int number = 0;
        if (ConERROR < 1) {

            String b = T_text.getText();
            base = T_text.getText().split("\\s");

            String L = "";

            try {
                FileWriter fw = new FileWriter("Report/Tokens.html");
                fw.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />" + "\n" + "\n");
                fw.write("<HTML><HEAD><TITLE>ITM - Lexico Analyzer</TITLE></HEAD>" + "\n" + "\n");
                fw.write("<H1><CENTER><B><FONT SIZE=\"9\" COLOR=\"BLACK\">TOKEN'S</FONT></B><BR></H1>" + "\n" + "\n");
                fw.write("<HR>" + "\n" + "\n");
                fw.write("<BR><CENTER><TABLE BORDER=1>\n");
                fw.write("	<TR>\n");
                fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>N.</B></FONT></TD>\n");
                fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>LEXEMA</B></FONT></TD>\n");
                fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>TOKEN</B></FONT></TD>\n");
                //fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>TOKEN N.</B></FONT></TD>\n");
                fw.write("	</TR>\n");

                for (int i = 0; i < base.length; i++) {
                    number++;
                    fw.write("	<TR>\n");
                    fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + number + "</FONT></TD>\n");
                    fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + base[i] + "</FONT></TD>\n");
                    //String operationals = "+,-,*,/,^,**,//,++,--,^^,||";
                    if (base[i].equals("+") | base[i].equals("-") | base[i].equals("*") | base[i].equals("/") | base[i].equals("^") | base[i].equals("**") | base[i].equals("//") | base[i].equals("++") | base[i].equals("--") | base[i].equals("^^") | base[i].equals("||") ) {
                        fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + "Operationals" + "</FONT></TD>\n");
                    } else if (base[i].equals("(") | base[i].equals(")") | base[i].equals("[") | base[i].equals("]") | base[i].equals("{") | base[i].equals("}")) {
                        fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + "Group" + "</FONT></TD>\n");
                    } else if (base[i].equals("<") | base[i].equals(">") | base[i].equals(">=") | base[i].equals("<=") | base[i].equals("==") | base[i].equals("=") | base[i].equals("!=")) {
                        fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + "Relationals" + "</FONT></TD>\n");
                    } else if (base[i].equals("")) {
                        colum++;
                        fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + "Space" + "</FONT></TD>\n");
                    } else if (base[i].equals(",") | base[i].equals(":") | base[i].equals(";") | base[i].equals(".")) {
                        fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + "Sign" + "</FONT></TD>\n");
                    } else if (base[i].contains("0") | base[i].contains("1") | base[i].contains("2") | base[i].contains("3") | base[i].contains("4") | base[i].contains("5") | base[i].contains("6") | base[i].contains("7") | base[i].contains("8") | base[i].contains("9")) {
                        fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + "Number" + "</FONT></TD>\n");
                    } else if (base[i].equals(identifiers)) {
                        fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + "Letter" + "</FONT></TD>\n");
                    }
                    else {
                        fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + "ID" + "</FONT></TD>\n");
                    }
                }
                fw.write("</TABLE>" + "\n");
                fw.flush();
                fw.close();
                JOptionPane.showMessageDialog(null, "Output file correctly created.");
            } catch (IOException er) {
                System.out.println(er);
            }
        } 
        else {
            JOptionPane.showMessageDialog(null,"The analysis has been end. The system found an error. Couln't create the token file, please press the 'Error File' button.","ERROR",JOptionPane.ERROR_MESSAGE);
        }          
    }//GEN-LAST:event_jbOutputFileActionPerformed

    private void MI_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_SaveActionPerformed
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Documentos de texto (*.txt)", "txt");
        try {
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(filter);
            fc.showSaveDialog(this); //Muestra el diálogo
            File Save = fc.getSelectedFile();

            try {
                if (Save.exists()) {

                    try {

                        FileWriter w = new FileWriter(Save);
                        BufferedWriter bw = new BufferedWriter(w);
                        PrintWriter wr = new PrintWriter(bw);
                        String[] als = T_text.getText().split("\n");

                        for (int a = 0; a < als.length; a++) {
                            wr.write(als[a]);
                            wr.println();
                        }

                        wr.close();
                        bw.close();

                    } catch (IOException ex) {

                    }

                } else {

                    if (Save.mkdir()) {
                        String newRuta = Save.getPath() + "\\";
                        FileWriter w = new FileWriter(newRuta + Save.getName() + ".txt");
                        BufferedWriter bw = new BufferedWriter(w);
                        PrintWriter wr = new PrintWriter(bw);
                        String[] als = T_text.getText().split("\n");

                        for (int a = 0; a < als.length; a++) {
                            wr.write(als[a]);
                            wr.println();
                        }
                        wr.close();
                        bw.close();
                    } else {

                    }
                }

            } catch (IOException ioe) {
                System.out.println(ioe);
            }

        } catch (NullPointerException e) {

        }
    }//GEN-LAST:event_MI_SaveActionPerformed

    private void jbClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClearActionPerformed
        T_text.setText("");
    }//GEN-LAST:event_jbClearActionPerformed

    private void MI_AboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_AboutActionPerformed
        JOptionPane.showMessageDialog(null, "Authors: \nMarlon Stiven Herrera Osorio."
                + "\nSantiago Murillo Vergara.\nSebastian Guisao Gallego.\nJuan Camilo Alvarez Torres."
                + "\nNafer Yosimar Mosquera Mosquera." + "\n\nVersión: 1.0");
    }//GEN-LAST:event_MI_AboutActionPerformed

    private void MI_UserManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MI_UserManualActionPerformed
        try {
            File path;
            path = new File("Manuals/UserManual.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {

        }
    }//GEN-LAST:event_MI_UserManualActionPerformed

    private void jbErrorFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbErrorFileActionPerformed
        String TokenError = T_text.getText();
        int countToken = 0;
        String root = "";
        int number = 0;
        String[] Error1 = new String[1000000];
        String[] empty = new String[1000000];
        int exists = 0;
        do {
            root = "" + TokenError.charAt(countToken);
            if (root.equals("@")) {
                Error1[exists] = "@";
                exists++;
            } else if (root.equals("#")) {
                Error1[exists] = "#";
                exists++;
            } else {
                empty[countToken] = "";
            }
            countToken++;
        } while (countToken < TokenError.length());

        try {
            FileWriter fw = new FileWriter("Report/Errors.html");
            fw.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />" + "\n" + "\n");
            fw.write("<HTML><HEAD><TITLE>ITM - Lexico Analyzer</TITLE></HEAD>" + "\n" + "\n");
            fw.write("<H1><CENTER><B><FONT SIZE=\"9\" COLOR=\"BLACK\">ERRORES" + "</FONT></B></H1>" + "\n" + "\n");
            fw.write("<HR>" + "\n" + "\n");
            fw.write("<BR><CENTER><TABLE BORDER=1>\n");
            fw.write("	<TR>\n");
            fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>N.</B></FONT></TD>\n");
            fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>LEXEMA</B></FONT></TD>\n");
            fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\"><B>DETAILS</B></FONT></TD>\n");

            fw.write("	</TR>\n");
            String[] result = T_text.getText().split("\\s");

            for (int so = 0; so < exists; so++) {
                number++;
                fw.write("	<TR>\n");
                fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + number + "</FONT></TD>\n");
                fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + Error1[so] + "</FONT></TD>\n");
                fw.write("	<TD ALIGN=\"CENTER\"><FONT COLOR=\"BLACK\">" + "Error Lexico" + "</FONT></TD>\n");
                fw.write("	</TR>\n");
            }
            fw.write("</TABLE>" + "\n");
            fw.flush();
            fw.close();
            JOptionPane.showMessageDialog(null, "The error file has been created correctly.");
        } catch (IOException er) {
            System.out.println(er);
        }
    }//GEN-LAST:event_jbErrorFileActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MI_About;
    private javax.swing.JMenuItem MI_Exit;
    private javax.swing.JMenuItem MI_Open;
    private javax.swing.JMenuItem MI_Save;
    private javax.swing.JMenuItem MI_UserManual;
    private javax.swing.JMenu M_File;
    private javax.swing.JMenu M_Help;
    public static javax.swing.JTextArea T_text;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAnalizer;
    private javax.swing.JButton jbClear;
    private javax.swing.JButton jbErrorFile;
    private javax.swing.JButton jbOutputFile;
    private javax.swing.JLabel jlScreen;
    private javax.swing.JLabel jl_ITM;
    // End of variables declaration//GEN-END:variables
}
