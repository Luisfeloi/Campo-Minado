package br.com.luiscunha.cm.visao;
import br.com.luiscunha.cm.modelo.Tabuleiro;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {
    public PainelTabuleiro (Tabuleiro tabuleiro){
        setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));

        tabuleiro.paraCadaCampo(c -> add(new BotaoCampo(c)));
        tabuleiro.registarObservador(e -> {

        });
    }
}
