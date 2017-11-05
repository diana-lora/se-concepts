package algorithms;

public class TreeTraversal {

    public static void main(String[] args) {
        
        Node root = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Node G = new Node("G");
        
        root.leftChild = B;
        root.rightChild = C;
        
        B.leftChild = D;
        B.rightChild = E;
        
        C.leftChild = F;
        C.rightChild = G;

        System.out.print("In-Order: ");
        inOrder(root); // D -> B -> E -> A -> F -> C -> G
        System.out.println();
        
        System.out.print("Pre-Order: ");
        preOrder(root); // A -> B -> D -> E -> C -> F -> G
        System.out.println();
        
        System.out.print("Post-Order: ");
        postOrder(root); // D -> E -> B -> F -> G -> C -> A
        System.out.println();
    }
    
    public static void inOrder(Node node) {
        
        if(node.leftChild != null) {
            inOrder(node.leftChild);
        }
        System.out.print(node + " ");
        
        if(node.rightChild != null) {
            inOrder(node.rightChild);
        }
    }
    
    public static void preOrder(Node node) {
        
        System.out.print(node + " ");
        
        if(node.leftChild != null) {
            preOrder(node.leftChild);
        }
        
        if(node.rightChild != null) {
            preOrder(node.rightChild);
        }
    }
    
    public static void postOrder(Node node) {
        
        if(node.leftChild != null) {
            postOrder(node.leftChild);
        }
        
        if(node.rightChild != null) {
            postOrder(node.rightChild);
        }
        
        System.out.print(node + " ");
    }
    
    static class Node {
        String data;
        Node leftChild;
        Node rightChild;
        
        Node(String data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data;
        }
    }

}
