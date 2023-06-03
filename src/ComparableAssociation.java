/**
 * La clase ComparableAssociation representa una asociación que implementa la interfaz Comparable.
 *
 * @param <K> el tipo de clave que implementa Comparable
 * @param <V> el tipo de valor asociado
 */
public class ComparableAssociation<K extends Comparable<K>,V>
        extends Association<K,V>
        implements Comparable<ComparableAssociation<K,V>>
        , MapEntry<K,V>
{
    /**
     * Crea una nueva instancia de ComparableAssociation con la clave especificada y sin valor.
     *
     * @param key la clave de la asociación
     */
    public ComparableAssociation(K key)
    {
        this(key,null);
    }

    /**
     * Crea una nueva instancia de ComparableAssociation con la clave y el valor especificados.
     *
     * @param key   la clave de la asociación
     * @param value el valor asociado
     */
    public ComparableAssociation(K key, V value)
    {
        super(key,value);
    }

    /**
     * Compara esta instancia de ComparableAssociation con otra instancia.
     *
     * @param that la instancia de ComparableAssociation a comparar
     * @return un valor negativo si esta instancia es menor, un valor positivo si es mayor,
     *         o cero si son iguales
     */
    public int compareTo(ComparableAssociation<K,V> that)
    {
        return this.getKey().compareTo(that.getKey());
    }

    /**
     * Retorna una representación en forma de cadena de la instancia de ComparableAssociation.
     *
     * @return la representación en cadena de la instancia
     */
    public String toString()
    {
        StringBuffer s = new StringBuffer();
        s.append("<ComparableAssociation: "+getKey()+"="+getValue()+">");
        return s.toString();
    }
}

