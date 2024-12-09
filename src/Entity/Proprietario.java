package Entity;

import java.util.ArrayList;
import java.util.List;

public class Proprietario {
    private int id;
    private String nome;
    private String cognome;
    private List<Immobile> listaImmobili = new ArrayList<Immobile>();

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public String getNome()
    {
        return nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public String getCognome()
    {
        return cognome;
    }
    public void setCognome(String cognome)
    {
        this.cognome = cognome;
    }

    public List<Immobile> getListaImmobili ()
    {
        return listaImmobili;
    }
    public void addImmobile(Immobile immobile)
    {
        listaImmobili.add(immobile);
    }
}
