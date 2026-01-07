package urv.benestar;
import urv.benestar.model.*; import urv.benestar.model.llistes.*;
public class TestUsuaris{
    public static void main(String[]a)throws Exception{
        LlistaUsuaris l=new LlistaUsuaris();
        l.add(new UsuariPDI("anna","anna.soler","DEIM","Sescelades"));
        l.add(new UsuariEstudiant("laia","laia.garcia","GEI",2024));
        for(Usuari u:l.toArray()) System.out.println(u.toFileLine());
    }
}