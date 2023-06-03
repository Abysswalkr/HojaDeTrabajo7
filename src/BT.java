/**
 * La clase BT representa un árbol binario.
 *
 * @param <E> el tipo de elemento almacenado en el árbol
 */
public class BT<E>
{
    protected E VAR;
    protected BT<E> Parent;
    protected BT<E> Left, Right;

    /**
     * Crea una nueva instancia de BT sin valor inicial y sin hijos.
     */
    public BT()
    {
        VAR = null;
        Parent = null; Left = Right = this;
    }

    /**
     * Crea una nueva instancia de BT con el valor especificado y sin hijos.
     *
     * @param value el valor a asignar al nodo
     */
    public BT(E value)
    {
        VAR = value;
        Right = Left = new BT<E>();
        SetLeft(Left);
        SetRight(Right);
    }

    /**
     * Crea una nueva instancia de BT con el valor, el hijo izquierdo y el hijo derecho especificados.
     *
     * @param value el valor a asignar al nodo
     * @param left el hijo izquierdo del nodo
     * @param right el hijo derecho del nodo
     */
    public BT(E value, BT<E> left, BT<E> right)
    {
        VAR = value;
        if (left == null) { left = new BT<E>(); }
        SetLeft(left);
        if (right == null) { right = new BT<E>(); }
        SetRight(right);
    }

    /**
     * Obtiene el hijo izquierdo del nodo actual.
     *
     * @return el hijo izquierdo
     */
    public BT<E> left()
    {
        return Left;
    }

    /**
     * Obtiene el hijo derecho del nodo actual.
     *
     * @return el hijo derecho
     */
    public BT<E> right()
    {
        return Right;
    }

    /**
     * Obtiene el padre del nodo actual.
     *
     * @return el padre
     */
    public BT<E> parent()
    {
        return Parent;
    }

    /**
     * Asigna un nuevo hijo izquierdo al nodo actual.
     *
     * @param newLeft el nuevo hijo izquierdo
     */
    public void SetLeft(BT<E> newLeft)
    {
        if (isEmpty()) return;
        if (Left != null && Left.parent() == this) Left.SetParent(null);
        Left = newLeft;
        Left.SetParent(this);
    }

    /**
     * Asigna un nuevo hijo derecho al nodo actual.
     *
     * @param newRight el nuevo hijo derecho
     */
    public void SetRight(BT<E> newRight)
    {
        if (isEmpty()) return;
        if (Right != null && Right.parent() == this) Right.SetParent(null);
        Right = newRight;
        Right.SetParent(this);
    }

    /**
     * Asigna un nuevo padre al nodo actual.
     *
     * @param newParent el nuevo padre
     */
    protected void SetParent(BT<E> newParent)
    {
        if (!isEmpty()) {
            Parent = newParent;
        }
    }

    /**
     * Obtiene el tamaño del árbol, es decir, la cantidad de nodos.
     *
     * @return el tamaño del árbol
     */
    public int Size()
    {
        if (isEmpty()) return 0;
        return left().Size() + right().Size() + 1;
    }

    /**
     * Obtiene el nodo raíz del árbol.
     *
     * @return el nodo raíz
     */
    public BT<E> root()
    {
        if (parent() == null) return this;
        else return parent().root();
    }

    /**
     * Verifica si el nodo actual está vacío.
     *
     * @return true si el nodo está vacío, false en caso contrario
     */
    public boolean isEmpty()
    {
        return VAR == null;
    }

    /**
     * Verifica si el nodo actual es un hijo izquierdo.
     *
     * @return true si es un hijo izquierdo, false en caso contrario
     */
    public boolean IsLeft()
    {
        if (parent() == null) return false;
        return this == parent().left();
    }

    /**
     * Verifica si el nodo actual es un hijo derecho.
     *
     * @return true si es un hijo derecho, false en caso contrario
     */
    public boolean IsRight()
    {
        if (parent() == null) return false;
        return this == parent().right();
    }

    /**
     * Obtiene el valor almacenado en el nodo actual.
     *
     * @return el valor almacenado
     */
    public E value()
    {
        return VAR;
    }

    /**
     * Establece un nuevo valor para el nodo actual.
     *
     * @param value el nuevo valor a asignar
     */
    public void setValue(E value)
    {
        VAR = value;
    }

    /**
     * Calcula el código hash del nodo actual.
     *
     * @return el código hash del nodo
     */
    public int HashC()
    {
        if (isEmpty()) return 0;
        int result = left().hashCode() + right().hashCode();
        if (value() != null) result += value().hashCode();
        return result;
    }

    /**
     * Obtiene la profundidad del nodo actual en el árbol.
     *
     * @return la profundidad del nodo
     */
    public int Depth()
    {
        if (parent() == null) return 0;
        return 1 + Parent.Depth();
    }

    /**
     * Retorna una representación en forma de cadena del árbol.
     *
     * @return la representación en cadena del árbol
     */
    public String Tree(){
        String s = "";
        for (int i = 0; i < this.Depth(); i++){
            s += "\t|";
        }

        s += ("<" + VAR + " : " + GetHand() + ">\n");

        if (!Left.isEmpty()) s += Left.Tree();
        if (!Right.isEmpty()) s += Right.Tree();

        return s;
    }

    private String GetHand(){
        if (IsRight()) return "R";
        if (IsLeft()) return "L";
        return "Root";
    }

    /**
     * Retorna una representación en forma de cadena del árbol.
     *
     * @return la representación en cadena del árbol
     */
    public String ToString()
    {
        if (isEmpty()) return "<BinaryTree: empty>";
        StringBuffer a = new StringBuffer();
        a.append("<BinaryTree "+value());
        if (!left().isEmpty()) a.append(" "+left());
        else a.append(" -");
        if (!right().isEmpty()) a.append(" "+right());
        else a.append(" -");
        a.append('>');
        return a.toString();
    }
}
