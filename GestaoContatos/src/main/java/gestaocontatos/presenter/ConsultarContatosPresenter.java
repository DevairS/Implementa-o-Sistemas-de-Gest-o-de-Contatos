/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaocontatos.presenter;

import gestaocontatos.model.Contato;
import gestaocontatos.view.ConsultarContatosView;
import gestaocontatos.collection.ContatoCollection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ListIterator;
import java.util.Iterator;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author devai
 */
public class ConsultarContatosPresenter {
    private ConsultarContatosView  view;
    private ContatoCollection contatos;
    private DefaultTableModel tmContatos;
    
    
    public ConsultarContatosPresenter(ContatoCollection contatos){
        this.contatos = contatos;
        
        view =  new ConsultarContatosView();
    
        tmContatos = new DefaultTableModel(
            new Object [][]{},
            new String []{"NOME", "TELEFONE"} 
        );
        
        view.getTblContatos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
        
        tmContatos.setNumRows(0);
        ListIterator<Contato> it = contatos.getContatos().listIterator();
        
        while (it.hasNext()){
            Contato contato = it.next();
            tmContatos.addRow(new Object[]{contato.getNome(), contato.getTelefone()}); 
        }
        view.getTblContatos().setModel(tmContatos);
        
        view.getBtnFechar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fechar();
            }
        });
        
        view.setVisible(true);
        
    }
    
    private void fechar(){
        view.dispose();
    }
}
