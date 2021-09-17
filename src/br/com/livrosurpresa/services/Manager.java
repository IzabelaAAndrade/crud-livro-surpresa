// Vai criar um entity manager no hibernate 
package br.com.livrosurpresa.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bela
 */
public class Manager {
    
    private EntityManager em;
    
    private static Manager instance = null; 
    
    public static Manager getInstance(){
        if(instance  == null){
            instance = new Manager();
        }
        return instance; //Quando o instance já tiver sido criado, recebemos a referência para o mesmo, não sendo criada outra instância
    }
    
    //Evitar que a nossa classe seja criada fora dela
    private Manager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("livro_surpresa_crudPU");
        em = emf.createEntityManager();
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
    
    
}
