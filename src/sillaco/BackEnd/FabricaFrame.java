/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sillaco.BackEnd;

import java.util.concurrent.Semaphore;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Juan Arturo Blanco
 */
public class FabricaFrame extends javax.swing.JFrame {
    //Almacenes
    private int AlmacenS []= new int[100];
    private int AlmacenP []= new int[50];    
    private int AlmacenA []= new int[40]; 
    //Constantes
    private int Contador=50;
    private int K=1;
    //Semaforos del Almacen de Patas y sus apuntadores 
    private Semaphore SEP= new Semaphore(1);
    private Semaphore SPP= new Semaphore(AlmacenP.length);
    private Semaphore SCP= new Semaphore(0);
    private int InP=0;
    private int OutP=0;
    //Semaforos del Almacen de Asientos y sus apuntadores 
    private Semaphore SEA= new Semaphore(1);
    private Semaphore SPA= new Semaphore(AlmacenA.length);
    private Semaphore SCA= new Semaphore(0);
    private int InA=0;
    private int OutA=0;
    //Semaforos del Almacen de Sillas y sus apuntadores 
    private Semaphore SES= new Semaphore(1);
    private Semaphore SPS= new Semaphore(AlmacenS.length);
    private int InS=0;
    private int OutS=0;
    //Semaforo del contador
    private Semaphore SEC= new Semaphore(1);
    //Arreglos de Productores y Ensambladores
    private PAsientos PA []= new PAsientos[10];
    private PPatas PP []= new PPatas[10];
    private Ensamblador Ensam []= new Ensamblador[5];
    // Otros trabajadores
    private Cronometrador Crono = new Cronometrador(Contador,SEC,this);
    private Gerente Geren = new Gerente(this,Contador, AlmacenS, K, SES,SPS,SEC,OutS,InS);
    
    //Setters y getters
    public JLabel getLblAAsientos() {
        return LblAAsientos;    
    }

    public void setLblAAsientos(JLabel LblAAsientos) {
        this.LblAAsientos = LblAAsientos;
    }

    public JLabel getLblASillas() {
        return LblASillas;
    }

    public void setLblASillas(JLabel LblASillas) {
        this.LblASillas = LblASillas;
    }

    public JButton getBtnEContratar() {
        return BtnEContratar;
    }

    public void setBtnEContratar(JButton BtnEContratar) {
        this.BtnEContratar = BtnEContratar;
    }

    public JButton getBtnEDespedir() {
        return BtnEDespedir;
    }

    public void setBtnEDespedir(JButton BtnEDespedir) {
        this.BtnEDespedir = BtnEDespedir;
    }

    public JButton getBtnPAContratar() {
        return BtnPAContratar;
    }

    public void setBtnPAContratar(JButton BtnPAContratar) {
        this.BtnPAContratar = BtnPAContratar;
    }

    public JButton getBtnPADespedir() {
        return BtnPADespedir;
    }

    public void setBtnPADespedir(JButton BtnPADespedir) {
        this.BtnPADespedir = BtnPADespedir;
    }

    public JButton getBtnPPContratar() {
        return BtnPPContratar;
    }

    public void setBtnPPContratar(JButton BtnPPContratar) {
        this.BtnPPContratar = BtnPPContratar;
    }

    public JButton getBtnPPDespedir1() {
        return BtnPPDespedir1;
    }

    public void setBtnPPDespedir1(JButton BtnPPDespedir1) {
        this.BtnPPDespedir1 = BtnPPDespedir1;
    }

    public JButton getBtnPausa() {
        return BtnPausa;
    }

    public void setBtnPausa(JButton BtnPausa) {
        this.BtnPausa = BtnPausa;
    }

    public JLabel getLblAPatas() {
        return LblAPatas;
    }

    public void setLblAPatas(JLabel LblAPatas) {
        this.LblAPatas = LblAPatas;
    }

    public JLabel getLblContador() {
        return LblContador;
    }

    public void setLblContador(JLabel LblContador) {
        this.LblContador = LblContador;
    }

    public JLabel getLblCronometrador() {
        return LblCronometrador;
    }

    public void setLblCronometrador(JLabel LblCronometrador) {
        this.LblCronometrador = LblCronometrador;
    }

    public JLabel getLblEnsambladores() {
        return LblEnsambladores;
    }

    public void setLblEnsambladores(JLabel LblEnsambladores) {
        this.LblEnsambladores = LblEnsambladores;
    }

    public JLabel getLblPAsientos() {
        return LblPAsientos;
    }

    public void setLblPAsientos(JLabel LblPAsientos) {
        this.LblPAsientos = LblPAsientos;
    }

    public JLabel getLblPPatas() {
        return LblPPatas;
    }

    public void setLblPPatas(JLabel LblPPatas) {
        this.LblPPatas = LblPPatas;
    }

    public JTextField getTfEContratar() {
        return TfEContratar;
    }

    public void setTfEContratar(JTextField TfEContratar) {
        this.TfEContratar = TfEContratar;
    }

    public JTextField getTfEDespedir() {
        return TfEDespedir;
    }

    public void setTfEDespedir(JTextField TfEDespedir) {
        this.TfEDespedir = TfEDespedir;
    }

    public JTextField getTfPAContratar() {
        return TfPAContratar;
    }

    public void setTfPAContratar(JTextField TfPAContratar) {
        this.TfPAContratar = TfPAContratar;
    }

    public JTextField getTfPADespedir() {
        return TfPADespedir;
    }

    public void setTfPADespedir(JTextField TfPADespedir) {
        this.TfPADespedir = TfPADespedir;
    }

    public JTextField getTfPPContratar() {
        return TfPPContratar;
    }

    public void setTfPPContratar(JTextField TfPPContratar) {
        this.TfPPContratar = TfPPContratar;
    }

    public JTextField getTfPPDespedir1() {
        return TfPPDespedir1;
    }

    public void setTfPPDespedir1(JTextField TfPPDespedir1) {
        this.TfPPDespedir1 = TfPPDespedir1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel10() {
        return jLabel10;
    }

    public void setjLabel10(JLabel jLabel10) {
        this.jLabel10 = jLabel10;
    }

    public JLabel getjLabel11() {
        return jLabel11;
    }

    public void setjLabel11(JLabel jLabel11) {
        this.jLabel11 = jLabel11;
    }

    public JLabel getjLabel12() {
        return jLabel12;
    }

    public void setjLabel12(JLabel jLabel12) {
        this.jLabel12 = jLabel12;
    }

    public JLabel getjLabel13() {
        return jLabel13;
    }

    public void setjLabel13(JLabel jLabel13) {
        this.jLabel13 = jLabel13;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }

    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
    }

    public JLabel getjLabel7() {
        return LblAAsientos;
    }

    public void setjLabel7(JLabel jLabel7) {
        this.LblAAsientos = jLabel7;
    }

    public JLabel getjLabel8() {
        return jLabel8;
    }

    public void setjLabel8(JLabel jLabel8) {
        this.jLabel8 = jLabel8;
    }

    public JLabel getjLabel9() {
        return LblASillas;
    }

    public void setjLabel9(JLabel jLabel9) {
        this.LblASillas = jLabel9;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public JPanel getjPanel2() {
        return jPanel2;
    }

    public void setjPanel2(JPanel jPanel2) {
        this.jPanel2 = jPanel2;
    }

    public JPanel getjPanel4() {
        return jPanel4;
    }

    public void setjPanel4(JPanel jPanel4) {
        this.jPanel4 = jPanel4;
    }

    public JPanel getjPanel5() {
        return jPanel5;
    }

    public void setjPanel5(JPanel jPanel5) {
        this.jPanel5 = jPanel5;
    }

    public JPanel getjPanel6() {
        return jPanel6;
    }

    public void setjPanel6(JPanel jPanel6) {
        this.jPanel6 = jPanel6;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public void setLabel1(JLabel label1) {
        this.label1 = label1;
    }

    public int getK() {
        return K;
    }

    public void setK(int K) {
        this.K = K;
    }

    public PAsientos[] getPA() {
        return PA;
    }

    public void setPA(PAsientos[] PA) {
        this.PA = PA;
    }

    public PPatas[] getPP() {
        return PP;
    }

    public void setPP(PPatas[] PP) {
        this.PP = PP;
    }

    public Ensamblador[] getEnsam() {
        return Ensam;
    }

    public void setEnsam(Ensamblador[] Ensam) {
        this.Ensam = Ensam;
    }
    
    public FabricaFrame() {
        initComponents();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LblPAsientos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        LblPPatas = new javax.swing.JLabel();
        BtnPAContratar = new javax.swing.JButton();
        BtnPADespedir = new javax.swing.JButton();
        TfPAContratar = new javax.swing.JTextField();
        TfPADespedir = new javax.swing.JTextField();
        BtnPPContratar = new javax.swing.JButton();
        BtnPPDespedir1 = new javax.swing.JButton();
        TfPPContratar = new javax.swing.JTextField();
        TfPPDespedir1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        LblEnsambladores = new javax.swing.JLabel();
        BtnEContratar = new javax.swing.JButton();
        BtnEDespedir = new javax.swing.JButton();
        TfEDespedir = new javax.swing.JTextField();
        TfEContratar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        LblAPatas = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        LblAAsientos = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        LblASillas = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        LblContador = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        LblCronometrador = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        BtnPausa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        setResizable(false);

        label1.setText("Productores");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asientos");

        LblPAsientos.setText("0");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Patas");

        LblPPatas.setText("0");

        BtnPAContratar.setBackground(new java.awt.Color(0, 0, 0));
        BtnPAContratar.setForeground(new java.awt.Color(255, 255, 255));
        BtnPAContratar.setText("Contratar");
        BtnPAContratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPAContratarActionPerformed(evt);
            }
        });

        BtnPADespedir.setBackground(new java.awt.Color(0, 0, 0));
        BtnPADespedir.setForeground(new java.awt.Color(255, 255, 255));
        BtnPADespedir.setText("Despedir");
        BtnPADespedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPADespedirActionPerformed(evt);
            }
        });

        TfPAContratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfPAContratarActionPerformed(evt);
            }
        });

        BtnPPContratar.setBackground(new java.awt.Color(0, 0, 0));
        BtnPPContratar.setForeground(new java.awt.Color(255, 255, 255));
        BtnPPContratar.setText("Contratar");
        BtnPPContratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPPContratarActionPerformed(evt);
            }
        });

        BtnPPDespedir1.setBackground(new java.awt.Color(0, 0, 0));
        BtnPPDespedir1.setForeground(new java.awt.Color(255, 255, 255));
        BtnPPDespedir1.setText("Despedir");
        BtnPPDespedir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPPDespedir1ActionPerformed(evt);
            }
        });

        TfPPContratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfPPContratarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LblPAsientos)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LblPPatas)
                        .addGap(136, 136, 136))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnPAContratar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BtnPADespedir, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addComponent(TfPAContratar)
                                .addComponent(TfPADespedir)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BtnPPContratar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(TfPPContratar, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnPPDespedir1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TfPPDespedir1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(LblPAsientos)
                    .addComponent(jLabel2)
                    .addComponent(LblPPatas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnPAContratar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfPAContratar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnPADespedir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfPADespedir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnPPContratar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfPPContratar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnPPDespedir1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfPPDespedir1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        LblEnsambladores.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LblEnsambladores.setForeground(new java.awt.Color(255, 255, 255));
        LblEnsambladores.setText("0");

        BtnEContratar.setBackground(new java.awt.Color(0, 0, 0));
        BtnEContratar.setForeground(new java.awt.Color(255, 255, 255));
        BtnEContratar.setText("Contratar");
        BtnEContratar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEContratarActionPerformed(evt);
            }
        });

        BtnEDespedir.setBackground(new java.awt.Color(0, 0, 0));
        BtnEDespedir.setForeground(new java.awt.Color(255, 255, 255));
        BtnEDespedir.setText("Despedir");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnEDespedir, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BtnEContratar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(LblEnsambladores)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TfEDespedir))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TfEContratar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LblEnsambladores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEContratar)
                .addGap(3, 3, 3)
                .addComponent(TfEContratar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEDespedir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TfEDespedir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel3.setText("Ensambladores");

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Patas");

        LblAPatas.setForeground(new java.awt.Color(255, 255, 255));
        LblAPatas.setText("0");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Asientos");

        LblAAsientos.setForeground(new java.awt.Color(255, 255, 255));
        LblAAsientos.setText("0");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Sillas");

        LblASillas.setForeground(new java.awt.Color(255, 255, 255));
        LblASillas.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblASillas)
                    .addComponent(LblAPatas)
                    .addComponent(LblAAsientos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(LblAPatas, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(LblAAsientos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LblASillas)))
        );

        jLabel4.setText("Almacenes");

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        LblContador.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LblContador.setForeground(new java.awt.Color(255, 255, 255));
        LblContador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LblContador.setText("0");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LblContador)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LblContador)
                .addContainerGap())
        );

        jLabel10.setText("Entrega en");

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        LblCronometrador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LblCronometrador.setForeground(new java.awt.Color(255, 255, 255));
        LblCronometrador.setText("Despierto");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(LblCronometrador)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(LblCronometrador)
                .addGap(25, 25, 25))
        );

        jLabel11.setText("Estado del Cronometrador");

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Despierto");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel13)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel12.setText("Estado del Gerente");

        BtnPausa.setBackground(new java.awt.Color(255, 255, 255));
        BtnPausa.setText("Pausa");
        BtnPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPausaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(BtnPausa))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label1)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel12)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(35, 35, 35)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))))
                        .addContainerGap(37, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtnPausa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPAContratarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPAContratarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPAContratarActionPerformed

    private void BtnEContratarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEContratarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEContratarActionPerformed

    private void BtnPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPausaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPausaActionPerformed

    private void BtnPADespedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPADespedirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPADespedirActionPerformed

    private void TfPAContratarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfPAContratarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfPAContratarActionPerformed

    private void BtnPPContratarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPPContratarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPPContratarActionPerformed

    private void BtnPPDespedir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPPDespedir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnPPDespedir1ActionPerformed

    private void TfPPContratarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfPPContratarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TfPPContratarActionPerformed

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
            java.util.logging.Logger.getLogger(FabricaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FabricaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FabricaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FabricaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FabricaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEContratar;
    private javax.swing.JButton BtnEDespedir;
    private javax.swing.JButton BtnPAContratar;
    private javax.swing.JButton BtnPADespedir;
    private javax.swing.JButton BtnPPContratar;
    private javax.swing.JButton BtnPPDespedir1;
    private javax.swing.JButton BtnPausa;
    private javax.swing.JLabel LblAAsientos;
    private javax.swing.JLabel LblAPatas;
    private javax.swing.JLabel LblASillas;
    private javax.swing.JLabel LblContador;
    private javax.swing.JLabel LblCronometrador;
    private javax.swing.JLabel LblEnsambladores;
    private javax.swing.JLabel LblPAsientos;
    private javax.swing.JLabel LblPPatas;
    private javax.swing.JTextField TfEContratar;
    private javax.swing.JTextField TfEDespedir;
    private javax.swing.JTextField TfPAContratar;
    private javax.swing.JTextField TfPADespedir;
    private javax.swing.JTextField TfPPContratar;
    private javax.swing.JTextField TfPPDespedir1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel label1;
    // End of variables declaration//GEN-END:variables


}
