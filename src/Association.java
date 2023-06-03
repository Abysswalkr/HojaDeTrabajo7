/**
 * La clase Association representa una asociación clave-valor en un mapa.
 * Implementa la interfaz MapEntry.
 *
 * @param <K> el tipo de la clave
 * @param <V> el tipo del valor
 */
public class Association<K,V> implements MapEntry<K,V>{
    protected K theKey;
    protected V theValue;

    /**
     * Crea una nueva instancia de Association con la clave y el valor especificados.
     *
     * @param key la clave de la asociación
     * @param value el valor de la asociación
     */
    public Association(K key, V value)
    {
        theKey = key;
        theValue = value;
    }

    /**
     * Crea una nueva instancia de Association con la clave especificada y sin valor.
     *
     * @param key la clave de la asociación
     */
    public Association(K key)
    {
        this(key,null);
    }

    /**
     * Compara si esta instancia de Association es igual a otro objeto.
     *
     * @param other el objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    public boolean equals(Object other)
    {
        Association OtherAssoc = (Association)other;
        return getKey().equals(OtherAssoc.getKey());
    }

    /**
     * Calcula el código hash de esta instancia de Association.
     *
     * @return el código hash
     */
    public int hashCode()
    {
        return getKey().hashCode();
    }

    /**
     * Obtiene el valor asociado a esta instancia de Association.
     *
     * @return el valor asociado
     */
    public V getValue()
    {
        return theValue;
    }

    /**
     * Obtiene la clave de esta instancia de Association.
     *
     * @return la clave
     */
    public K getKey()
    {
        return theKey;
    }

    /**
     * Asigna un nuevo valor a esta instancia de Association y retorna el valor anterior.
     *
     * @param value el nuevo valor a asignar
     * @return el valor anterior
     */
    public V setValue(V value)
    {
        V oldValue = theValue;
        theValue = value;
        return oldValue;
    }

    /**
     * Retorna una representación en formato de cadena de esta instancia de Association.
     *
     * @return la representación en formato de cadena
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<Association: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
}
