package batalhanaval.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import batalhanaval.*;
 
/**
 * Diálogo de créditos do jogo.
 *
 * @author Icaro Heitor de Souza Ferreira  
 * @author Ana Clara Nobre
 */
 
@SuppressWarnings("serial")
public class JanelaSobre extends JDialog implements ActionListener {
    public JanelaSobre(JFrame p) {
        super(p, "Sobre", true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(p); // Centraliza a janela
 
        JPanel painel = new JPanel(new BorderLayout());
        painel.setPreferredSize(new Dimension(300, 250));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
 
        JTextArea creditos = new JTextArea("Batalha Naval " + Principal.VERSAO
                + "\n\nProjeto final da disciplina:\n"
                + "\nLaboratorio de Programacao II"
                + "\n\nProfessor: Joao Carlos Xavier"
                + "\n\nAlunos:\nIcaro Heitor de Souza Ferreira\n"
                + "Ana Clara Nobre Mendes");
        creditos.setOpaque(false);
        creditos.setEditable(false);
 
        painel.add(creditos);
        add(painel, BorderLayout.NORTH);
       
        JButton ok = new JButton("OK");
        ok.addActionListener(this);
        getRootPane().setDefaultButton(ok);
       
        JPanel painelOk = new JPanel();
        painelOk.add(ok);
        add(painelOk);
    }
 
    // Tratamento de ação do botão OK
    public void actionPerformed(ActionEvent e) {
        JanelaSobre.this.dispose();
    }
}