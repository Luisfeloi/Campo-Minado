package br.com.luiscunha.cm.visao;

import br.com.luiscunha.cm.modelo.Tabuleiro;

import javax.swing.JFrame;
@SuppressWarnings("serial")
public class TelaPrincipal extends JFrame {

    public TelaPrincipal(){

        setTitle("Campo Minado");
        setSize(690,438);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaPrincipal();

    }
}
