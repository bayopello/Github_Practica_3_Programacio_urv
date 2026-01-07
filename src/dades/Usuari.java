package urv.benestar.model;
import java.io.Serializable;
public abstract class Usuari implements Serializable{
    private final String alies,email;
    protected Usuari(String a,String e)throws ValidationException{
        this.alies=Validador.validaAlias(a);
        this.email=Validador.validaEmailLocalPart(e);
    }
    public String getAlies(){return alies;}
    public String getEmailLocalPart(){return email;}
    public String getEmailComplet(){return email+getDominiEmail();}
    protected abstract String getDominiEmail();
    public abstract Collectiu getCollectiu();
    public abstract String toFileLine();
}