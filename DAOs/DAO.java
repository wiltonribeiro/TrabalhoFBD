package imobiliaria.DAOs;

import java.util.List;

public interface DAO<T> {
    
    public void add(T t) throws Exception;
    public void remove(T t) throws Exception;
    public void update(T t) throws Exception;
    public List<T> list() throws Exception;
    
}
