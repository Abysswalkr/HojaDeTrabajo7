//Codigo Obtenido de la Pagina Geeks for Geeks

/**
 * La clase BST representa un árbol binario de búsqueda.
 */
class BST {
    Node root;

    /**
     * Crea una nueva instancia de BST con el nodo raíz inicializado como nulo.
     */
    public BST()
    {
        root = null;
    }

    /**
     * Inserta una nueva clave y sus valores asociados en el árbol.
     *
     * @param key la clave a insertar
     * @param values los valores asociados a la clave
     */
    public void insert(int Key, Association<Integer, String[]> Values)
    {
        root = insertRec(root, Key, Values);
    }

    /**
     * Inserta recursivamente una nueva clave y sus valores asociados en el árbol.
     *
     * @param root el nodo raíz del árbol
     * @param key la clave a insertar
     * @param values los valores asociados a la clave
     * @return el nodo raíz del árbol actualizado
     */
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

    /**
     * Realiza un recorrido inorden del árbol e imprime las claves en orden ascendente.
     */
    public void inorder()
    {
        inorderRec(root);
    }

    /**
     * Realiza un recorrido inorden del árbol de manera recursiva.
     *
     * @param root el nodo raíz del subárbol actual
     */
    void inorderRec(Node Root)
    {
        if (Root != null) {
            inorderRec(Root.left);
            System.out.println(Root.key);
            inorderRec(Root.right);
        }
    }

    /**
     * Busca un nodo con la clave especificada en el árbol.
     *
     * @param root el nodo raíz del árbol
     * @param key la clave a buscar
     * @return el nodo encontrado o nulo si la clave no está presente
     */
    public Node Search(Node Root, int Key)
    {
        if (Root ==null || Root.key== Key)
            return Root;

        if (Root.key < Key)
            return Search(Root.right, Key);

        return Search(Root.left, Key);
    }

    /**
     * Obtiene el nodo raíz del árbol.
     *
     * @return el nodo raíz
     */
    public Node getRoot() {
        return root;
    }
}



