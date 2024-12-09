package Entity;

public class Immobile {
    private int id;
    private int idProprietario;
    private String tipo;
    private int vani;
    private int costo;
    private int supp;
    private int anno;
    private Proprietario proprietario;

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }

    public int getIdProprietario()
    {
        return idProprietario;
    }
    public void setIdProprietario(int idProprietario)
    {
        this.idProprietario = idProprietario;
    }

    public String getTipo ()
    {
        return tipo;
    }
    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public int getVani()
    {
        return vani;
    }
    public int setVani(int vani) {
        return this.vani = vani;
    }

    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo)
    {
        this.costo = costo;
    }

    public int getSupp()
    {
        return supp;
    }
    public void setSupp (int supp)
    {
        this.supp = supp;
    }

    public int getAnno()
    {
        return anno;
    }
    public void setAnno(int anno)
    {
        this.anno = anno;
    }

    public Proprietario getProprietario()
    {
        return proprietario;
    }
    public void setProprietario(Proprietario proprietario)
    {
        this.proprietario = proprietario;
    }
}

