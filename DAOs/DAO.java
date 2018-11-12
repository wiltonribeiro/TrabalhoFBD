package imobiliaria.DAOs;

import java.util.List;

public interface DAO<T> {
    
    public void add(T t);
    public void remove(T t);
    public void update(T t);
    public List<T> list();
    
}
