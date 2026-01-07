package urv.benestar.model;
public class UsuariPDI extends Usuari{
    private final String dept,campus;
    public UsuariPDI(String a,String e,String d,String c)throws ValidationException{
        super(a,e);
        dept=Validador.requireNonBlank(d,"dept");
        campus=Validador.requireNonBlank(c,"campus");
    }
    protected String getDominiEmail(){return "@urv.cat";}
    public Collectiu getCollectiu(){return Collectiu.PDI;}
    public String toFileLine(){return "PDI;"+getAlies()+";"+getEmailLocalPart()+";"+dept+";"+campus;}
}