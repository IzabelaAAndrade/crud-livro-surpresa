package br.com.livrosurpresa.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author bela
 */

@Entity(name = "Recebe")
public class Recebe {
    @Id
    @Column
    private String cpf_cliente;

    public static final String PROP_CPF_CLIENTE = "cpf_cliente";

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        String oldCpf_cliente = this.cpf_cliente;
        this.cpf_cliente = cpf_cliente;
        propertyChangeSupport.firePropertyChange(PROP_CPF_CLIENTE, oldCpf_cliente, cpf_cliente);
    }
    
    @Id
    @Column
    private int id_livro;

    public static final String PROP_ID_LIVRO = "id_livro";

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        int oldId_livro = this.id_livro;
        this.id_livro = id_livro;
        propertyChangeSupport.firePropertyChange(PROP_ID_LIVRO, oldId_livro, id_livro);
    }




    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    
}
