/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestaocontatos.collection;

import gestaocontatos.model.Contato;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *
 * @author devai
 */
public class ContatoCollection {
    private ArrayList<Contato> contatos;
    
    public ContatoCollection(){
     contatos = new ArrayList<>();   
    }
    
    public void add(Contato contato){
        if (contatos.contains(contato)){
            throw new RuntimeException("Contato já existe");
        }
        
        if( contato != null){
            contatos.add(contato);
        }else{
            throw new RuntimeException("Forneça uma instância válida de um contato");
        }
    }
    
    public List<Contato> getContatos(){
        return Collections.unmodifiableList(contatos);
    }
}
