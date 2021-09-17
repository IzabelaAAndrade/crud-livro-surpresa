package br.com.livrosurpresa.dao;

import br.com.livrosurpresa.models.Livro;
import br.com.livrosurpresa.services.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author bela
 */
public class LivroDao {
    
    private  EntityManager em;

    public LivroDao(EntityManager em) {
        em = Manager.getInstance().getEm();
    }
    
    public void salvar(Livro l){
        em.getTransaction().begin();
        if (l.getId()>0){
            l = em.merge(l);
        }
        em.persist(l);
        em.getTransaction().commit();
    }
    
    public List<Livro> getAll(){
        Query query = em.createQuery("SELECT l from br.com.livrosurpresa.model.Livro l"); // HQL ->
        List livros = query.getResultList() ;
        return (List<Livro>) livros;
    }
    
    public void remover(Livro l){
        em.getTransaction().begin();
        em.remove(l);
        em.getTransaction().commit();
    }
}
