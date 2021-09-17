/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.livrosurpresa.dao;

import br.com.livrosurpresa.models.Recebe;
import br.com.livrosurpresa.services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author bela
 */
public class RecebeDao {
    
    private EntityManager em;

    public RecebeDao() {
        em = Manager.getInstance().getEm();
    }
    
    public void salvar (Recebe r){
        em.getTransaction().begin();
        if (r.getCpf_cliente().equals("")){
            r = em.merge(r);
        }
        if (r.getId_livro() > 0){
            r = em.merge(r);
        }
        em.persist(r);
        em.getTransaction().commit();
    }
    
    public  List<Recebe> getAll(){
        Query query = em.createQuery("SELECT c from br.com.livrosurpresa.model.Cliente c"); // HQL ->
        List recebidos = query.getResultList() ;
        return (List<Recebe>) recebidos;
    }
    
    public void remover (Recebe r){
         em.getTransaction().begin();
         em.remove(r);
         em.getTransaction().commit();
    }
}
