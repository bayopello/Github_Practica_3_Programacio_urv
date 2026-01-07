package urv.benestar.model;
public class UsuariPTGAS extends Usuari{
    private final String campus;
    public UsuariPTGAS(String a,String e,String c)throws ValidationException{
        super(a,e);
        campus=Validador.requireNonBlank(c,"campus");
    }
    protected String getDominiEmail(){return "@urv.cat";}
    public Collectiu getCollectiu(){return Collectiu.PTGAS;}
    public String toFileLine(){return "PTGAS;"+getAlies()+";"+getEmailLocalPart()+";"+campus;}
}