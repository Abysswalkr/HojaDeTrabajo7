/**
 * La clase Node representa un nodo en un árbol binario.
 */
public class Node {
    Association<Integer, String[]> Traductions;
    int key;
    Node left, right;

    /**
     * Crea un nuevo nodo con el elemento y los datos de asociación especificados.
     *
     * @param item el elemento del nodo
     * @param data los datos de asociación del nodo
     */
    public Node(int item, Association<Integer, String[]> Data)
    {
        key = item;
        left = right = null;
        Traductions = Data;
    }

    /**
     * Obtiene las traducciones asociadas a este nodo.
     *
     * @return las traducciones asociadas al nodo como un arreglo de cadenas
     */
    public String[] getTraduccion() {
        return Traductions.getValue();
    }

    /**
     * Obtiene los datos de asociación de este nodo.
     *
     * @return los datos de asociación del nodo como una instancia de Association
     */
    public Association<Integer, String[]> getTraductions() {
        return Traductions;
    }

}

