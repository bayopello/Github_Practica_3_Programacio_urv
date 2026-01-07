package urv.benestar.model;
public class UsuariEstudiant extends Usuari{
    private final String ens; private final int any;
    public UsuariEstudiant(String a,String e,String en,int an)throws ValidationException{
        super(a,e);
        ens=Validador.requireNonBlank(en,"ens");
        any=Validador.validaAnyInici(an);
    }
    protected String getDominiEmail(){return "@estudiants.urv.cat";}
    public Collectiu getCollectiu(){return Collectiu.ESTUDIANT;}
    public String toFileLine(){return "ESTUDIANT;"+getAlies()+";"+getEmailLocalPart()+";"+ens+";"+any;}
}