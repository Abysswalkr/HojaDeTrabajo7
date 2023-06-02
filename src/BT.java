public class BT<E>
{
    protected E VAR;
    protected BT<E> Parent;
    protected BT<E> Left, Right;

    public BT()
    {
        VAR = null;
        Parent = null; Left = Right = this;
    }

    public BT(E value)
    {
        VAR = value;
        Right = Left = new BT<E>();
        SetLeft(Left);
        SetRight(Right);
    }

    public BT(E value, BT<E> left, BT<E> right)
    {
        VAR = value;
        if (left == null) { left = new BT<E>(); }
        SetLeft(left);
        if (right == null) { right = new BT<E>(); }
        SetRight(right);
    }

    public BT<E> left()
    {
        return Left;
    }
    public BT<E> right()
    {
        return Right;
    }
    public BT<E> parent()
    {
        return Parent;
    }

    public void SetLeft(BT<E> newLeft)
    {
        if (isEmpty()) return;
        if (Left != null && Left.parent() == this) Left.SetParent(null);
        Left = newLeft;
        Left.SetParent(this);
    }

    public void SetRight(BT<E> newRight)
    {
        if (isEmpty()) return;
        if (Right != null && Right.parent() == this) Right.SetParent(null);
        Right = newRight;
        Right.SetParent(this);
    }

    protected void SetParent(BT<E> newParent)
    {
        if (!isEmpty()) {
            Parent = newParent;
        }
    }

    public int Size()
    {
        if (isEmpty()) return 0;
        return left().Size() + right().Size() + 1;
    }

    public BT<E> root()
    {
        if (parent() == null) return this;
        else return parent().root();
    }

    public boolean isEmpty()
    {
        return VAR == null;
    }

    public boolean IsLeft()
    {
        if (parent() == null) return false;
        return this == parent().left();
    }

    public boolean IsRight()
    {
        if (parent() == null) return false;
        return this == parent().right();
    }

    public E value()
    {
        return VAR;
    }
    public void setValue(E value)
    {
        VAR = value;
    }

    public int HashC()
    {
        if (isEmpty()) return 0;
        int result = left().hashCode() + right().hashCode();
        if (value() != null) result += value().hashCode();
        return result;
    }

    public int Depth()
    {
        if (parent() == null) return 0;
        return 1 + Parent.Depth();
    }

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
