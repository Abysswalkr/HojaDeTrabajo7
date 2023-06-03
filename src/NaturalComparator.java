import java.util.Comparator;

/**
 * La clase NaturalComparator proporciona un comparador basado en el orden natural de los elementos.
 *
 * @param <E> el tipo de elementos que se compararán
 */
public class NaturalComparator<E extends Comparable<E>>
        implements Comparator<E>
{
    /**
     * Compara dos elementos para determinar su orden basado en el orden natural.
     *
     * @param a el primer elemento a comparar
     * @param b el segundo elemento a comparar
     * @return un valor negativo si a es menor que b, un valor positivo si a es mayor que b,
     *         o cero si a y b son iguales
     */
    public int compare(E a, E b)
    {
        return a.compareTo(b);
    }

    /**
     * Compara este objeto con otro objeto para determinar si son iguales.
     *
     * @param b el objeto a comparar
     * @return true si son iguales, false en caso contrario
     */
    public boolean equals(Object b)
    {
        return (b != null) && (b instanceof NaturalComparator);
    }
}

