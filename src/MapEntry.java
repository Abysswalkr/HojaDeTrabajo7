/**
 * La interfaz MapEntry representa una entrada en un mapa que mapea una clave a un valor.
 *
 * @param <K> el tipo de la clave
 * @param <V> el tipo del valor asociado a la clave
 */
public interface MapEntry<K,V>
{
    /**
     * Compara esta entrada con otro objeto para determinar si son iguales.
     *
     * @param o el objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    public boolean equals (Object o);

    /**
     * Obtiene la clave de esta entrada.
     *
     * @return la clave de la entrada
     */
    public K getKey();

    /**
     * Obtiene el valor asociado a la clave en esta entrada.
     *
     * @return el valor asociado a la clave
     */
    public V getValue();

    /**
     * Calcula el código hash de esta entrada.
     *
     * @return el código hash de la entrada
     */
    public int hashCode();

    /**
     * Establece un nuevo valor para la clave en esta entrada y retorna el valor anterior.
     *
     * @param value el nuevo valor a asignar
     * @return el valor anterior asociado a la clave
     */
    public V setValue(V value);
}
