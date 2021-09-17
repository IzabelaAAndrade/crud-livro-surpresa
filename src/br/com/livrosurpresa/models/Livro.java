package br.com.livrosurpresa.models;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author bela
 */
@Entity(name = "Livro") // Quando este código for executado, uma tabela com esse nome será criada
public class Livro {
    @Id // Indica que esse atributo é o atributo chave da tabela Livro
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //Se não colocar, inserir com o nome padrão
    private int id;

    public static final String PROP_ID = "id";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange(PROP_ID, oldId, id);
    }
    
    @Column
    private String nome;

    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }
    
    @Column
    private int ano;

    public static final String PROP_ANO = "ano";

    public int getAno() {
        return ano;
    }
    
    public void setAno(int ano) {
        int oldAno = this.ano;
        this.ano = ano;
        propertyChangeSupport.firePropertyChange(PROP_ANO, oldAno, ano);
    }
    
    @Column
    private String editora;

    public static final String PROP_EDITORA = "editora";

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        String oldEditora = this.editora;
        this.editora = editora;
        propertyChangeSupport.firePropertyChange(PROP_EDITORA, oldEditora, editora);
    }
    
    @Column
    private String autor;

    public static final String PROP_AUTOR = "autor";

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        String oldAutor = this.autor;
        this.autor = autor;
        propertyChangeSupport.firePropertyChange(PROP_AUTOR, oldAutor, autor);
    }
    
    @Column
    private int num_paginas;

    public static final String PROP_NUM_PAGINAS = "num_paginas";

    public int getNum_paginas() {
        return num_paginas;
    }

    public void setNum_paginas(int num_paginas) {
        int oldNum_paginas = this.num_paginas;
        this.num_paginas = num_paginas;
        propertyChangeSupport.firePropertyChange(PROP_NUM_PAGINAS, oldNum_paginas, num_paginas);
    }
    
    @Column
     private String genero;

    public static final String PROP_GENERO = "genero";

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        String oldGenero = this.genero;
        this.genero = genero;
        propertyChangeSupport.firePropertyChange(PROP_GENERO, oldGenero, genero);
    }


    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }


}