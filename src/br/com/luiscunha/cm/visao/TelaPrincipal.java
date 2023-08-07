package br.com.luiscunha.cm.visao;

import br.com.luiscunha.cm.modelo.Tabuleiro;

import javax.swing.JFrame;
@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

    public TelaPrincipal(){
        setTitle("Campo Minado");
        setSize(690,438);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Tabuleiro tabuleiro = new Tabuleiro(16,30,50);
        PainelTabuleiro painelTabuleiro = new PainelTabuleiro(tabuleiro);
        add(painelTabuleiro);
    }

    public static void main(String[] args) {
        new TelaPrincipal();
    }
}
