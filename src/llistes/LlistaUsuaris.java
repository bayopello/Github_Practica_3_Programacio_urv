package urv.benestar.model.llistes;
import urv.benestar.model.*;
public class LlistaUsuaris{
    private static class Node{Usuari v;Node n;Node(Usuari v,Node n){this.v=v;this.n=n;}}
    private Node h; private int size;
    public void add(Usuari u)throws ValidationException{
        if(h==null){h=new Node(u,null);size++;return;}
        if(u.getAlies().compareToIgnoreCase(h.v.getAlies())<0){h=new Node(u,h);size++;return;}
        Node p=h,c=h.n;
        while(c!=null && u.getAlies().compareToIgnoreCase(c.v.getAlies())>0){p=c;c=c.n;}
        if(c!=null && u.getAlies().equalsIgnoreCase(c.v.getAlies())) throw new ValidationException("Duplicat");
        p.n=new Node(u,c); size++;
    }
    public Usuari[] toArray(){
        Usuari[] a=new Usuari[size]; Node c=h; int i=0;
        while(c!=null){a[i++]=c.v;c=c.n;} return a;
    }
}