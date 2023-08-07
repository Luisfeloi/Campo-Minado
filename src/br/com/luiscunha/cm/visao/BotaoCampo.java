package br.com.luiscunha.cm.visao;

import br.com.luiscunha.cm.modelo.Campo;
import br.com.luiscunha.cm.modelo.CampoEvento;
import br.com.luiscunha.cm.modelo.CampoObservador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class BotaoCampo extends JButton implements CampoObservador, MouseListener {

   private final Color GB_PADRAO = new Color(184,184,184);
   private final Color GB_MARCAR = new Color(8,179,247);
   private final Color GB_EXPLODIR = new Color(189,66,68);
   private final Color TEXTO_VERDE = new Color(0,100,0);
   private Campo campo;
   public BotaoCampo(Campo campo){
      this.campo = campo;
      setBackground(GB_PADRAO);
      setOpaque(true);
      setBorder(BorderFactory.createBevelBorder(0));
      addMouseListener(this);
      campo.registrarObservador(this);
   }
   @Override
   public void eventoOcorreu(Campo campo, CampoEvento evento) {
      switch (evento){
         case ABRIR: aplicarEstiloAbrir();
            break;
         case MARCAR: aplicarEstiloMarcar();
            break;
         case EXPLODIR: aplicarEstiloExplodor();
            break;
         default: aplicarEstiloPadrao();
      }
   }

   private void aplicarEstiloPadrao() {
      setBackground(GB_PADRAO);
      setBorder(BorderFactory.createBevelBorder(0));
      setText("");
   }

   private void aplicarEstiloExplodor() {
      setBackground(GB_EXPLODIR);
      setForeground(Color.WHITE);
      setText("X");
   }

   private void aplicarEstiloMarcar() {
      setBackground(GB_MARCAR);
      setForeground(Color.BLACK);
      setText("X");
   }

   private void aplicarEstiloAbrir() {
      setBorder(BorderFactory.createLineBorder(Color.GRAY));

      if(campo.isMinado()){
         setBackground(GB_EXPLODIR);
         return;
      }

      setBackground(GB_PADRAO);

      switch (campo.minasNaVizinhanca()){
         case 1: setForeground(TEXTO_VERDE);
            break;
         case 2: setForeground(Color.blue);
            break;
         case 3: setForeground(Color.YELLOW);
            break;
         case 4:
         case 5:
         case 6: setForeground(Color.RED);
            break;
         default: setForeground(Color.PINK);
      }

      String valor = !campo.vizinhancaSegura() ? campo.vizinhancaSegura() + "" : "";
      setText(valor);
   }

   @Override
   public void mousePressed(MouseEvent e) {
      if(e.getButton() == 1){
         campo.abrir();
      }else {
         campo.alternarMarcacao();
      }
   }

   public void mouseReleased(MouseEvent e) {}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
   public void mouseClicked(MouseEvent e) {}
}
