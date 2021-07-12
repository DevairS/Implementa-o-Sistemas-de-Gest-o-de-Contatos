/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaocontatos.presenter;

import gestaocontatos.collection.ContatoCollection;
import gestaocontatos.view.IncluirContatoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import gestaocontatos.model.Contato;



/**
 *
 * @author devai
 */
public class IncluirContatoPresenter {
    private IncluirContatoView view;
    private ContatoCollection contatos;
    
    public IncluirContatoPresenter(ContatoCollection contatos){
        this.contatos = contatos;
        view = new IncluirContatoView();
        
        view.getBtnFechar().addActionListener(new ActionListener (){           
            @Override
            public void actionPerformed(ActionEvent e){
                fechar();
            }
        });
        
        view.getBtnSalvar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvar();
            }
        });
              
        view.setVisible(true);
    }
    
    private void fechar(){
        view.dispose();
    }
    
    private void salvar(){
        String nome = view.getTxtNome().getText();
        String telefone = view.getTxtTelefone().getText();
        
        Contato contato = new Contato(nome, telefone);
       
        contatos.add(contato);
        
        JOptionPane.showMessageDialog(view, "Contato"+ contato.getNome()+" Salvo com sucesso",
                "Salvo com sucesso", 
                JOptionPane.INFORMATION_MESSAGE);       
    }
}
