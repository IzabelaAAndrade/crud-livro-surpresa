package br.com.livrosurpresa.dao;

import br.com.livrosurpresa.models.Cliente;
import br.com.livrosurpresa.services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author bela
 */
public class ClienteDao {
    
    private EntityManager em;

    public ClienteDao(EntityManager em) {
          em = Manager.getInstance().getEm();
    }
    
    public void salvar (Cliente c){
        em.getTransaction().begin();
        if (c.getCpf().equals("")){
            c = em.merge(c);
        }
        em.persist(c);
        em.getTransaction().commit();
    }
    
    public List<Cliente> getAll(){
        Query query = em.createQuery("SELECT c from br.com.livrosurpresa.model.Cliente c"); // HQL ->
        List clientes = query.getResultList() ;
        return (List<Cliente>) clientes;
    } 
    
    public void remover (Cliente c){
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
    }
}
