package eu.frezilla.numbers.systems;

/**
 * Cette interface impose des opérations sur les objets des classes qui 
 * l'implémentent.
 * 
 * @param <T> ensemble numérique
 */
public interface NumberSystems<T> {
    
    /**
     * Retourne le résultat de l'addition d'un objet à l'objet courant 
     * (this + val).
     * 
     * 
     * <p>Si l'objet résultat n'est pas valide dans le système défini, 
     * {@code null} est retourné.</p>
     * 
     * @param val valeur à ajouter à l'objet courant 
     * @return Résultat de l'addition.
     */
    T add(T val);
    
    /**
     * Retourne le signe du nombre.
     * 
     * @return {@code Sign} du nombre
     * @see Sign
     */
    Sign getSign();
    
    /**
     * Retourne le résultat de la soustraction d'un objet à l'objet courant 
     * (this - val).
     * 
     * <p>Si l'objet résultat n'est pas valide dans le système défini, 
     * {@code null} est retourné.</p>
     * 
     * @param val valeur à soustraire à l'objet courant
     * @return Résultat de la soustraction.
     */
    T sub(T val);
    
    /**
     * Retourne le résultat de la multiplication d'un objet avec l'objet 
     * courant (this * val).
     * 
     * <p>Si l'objet résultat n'est pas valide dans le système défini, 
     * {@code null} est retourné.</p>
     * 
     * @param val valeur à multiplier à l'objet courant
     * @return Résultat de la multiplication.
     */
    T multiply(T val);
    
    /**
     * Retourne le résultat de la division de l'objet courant par un objet 
     * ( this / val).
     * 
     * <p>Si l'objet résultat n'est pas valide dans le système défini, 
     * {@code null} est retourné.</p>
     * 
     * @param val valeur à diviser 
     * @return Résult de la division.
     */
    T divide(T val);
    
}
