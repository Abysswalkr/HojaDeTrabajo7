public class Node {
    Association<Integer, String[]> Traductions;
    int key;
    Node left, right;

    public Node(int item, Association<Integer, String[]> Data)
    {
        key = item;
        left = right = null;
        Traductions = Data;
    }

    public String[] getTraduccion() {
        return Traductions.getValue();
    }

    public Association<Integer, String[]> getTraductions() {
        return Traductions;
    }

}

