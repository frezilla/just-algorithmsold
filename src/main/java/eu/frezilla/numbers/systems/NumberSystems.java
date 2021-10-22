package eu.frezilla.numbers.systems;

public interface NumberSystems<T> {
    
    /**
     * Retourne un objet résultat de l'addition d'un objet à l'objet courant.
     * 
     * <p>Si l'objet résultat n'est pas valide
     * 
     * @param val
     * @return 
     */
    T add(T val);
    
    Sign getSign();
    
    T sub(T val);
    
    T multiply(T val);
    
    T divide(T val);
    
}
