//Codigo Obtenido de la Pagina Geeks for Geeks
class BST {
    Node root;

    public BST()
    {
        root = null;
    }

    public void insert(int Key, Association<Integer, String[]> Values)
    {
        root = insertRec(root, Key, Values);
    }

    public Node insertRec(Node Root, int Key, Association<Integer, String[]> Values)
    {

        if (Root == null)
        {
            Root = new Node(Key, Values);
            return Root;
        }

        if (Key < Root.key)
            Root.left = insertRec(Root.left, Key, Values);
        else if (Key > Root.key)
            Root.right = insertRec(Root.right, Key, Values);

        return Root;
    }

    public void inorder()
    {
        inorderRec(root);
    }

    void inorderRec(Node Root)
    {
        if (Root != null) {
            inorderRec(Root.left);
            System.out.println(Root.key);
            inorderRec(Root.right);
        }
    }

    public Node Search(Node Root, int Key)
    {
        if (Root ==null || Root.key== Key)
            return Root;

        if (Root.key < Key)
            return Search(Root.right, Key);

        return Search(Root.left, Key);
    }

    public Node getRoot() {
        return root;
    }
}



