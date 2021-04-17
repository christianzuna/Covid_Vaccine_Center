package project1;

public interface Dao <E>{
    
    // void insert(E e);
    void insert(); 
    void get(E e); 
    void update(E e); 
    void Delete(E e);
    
}
