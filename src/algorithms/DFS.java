package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {
    
    public static void main(String[] args) {
        
        Node root = new Node("s");
        
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        
        root.addChild(nodeA);
        root.addChild(nodeB);
        root.addChild(nodeC);
        
        nodeA.addChild(nodeD);
        nodeB.addChild(nodeE);
        nodeC.addChild(nodeF);
        
        nodeD.addChild(nodeG);
        nodeE.addChild(nodeG);
        nodeF.addChild(nodeG);
        
        nodeG.addChild(nodeA);
        nodeG.addChild(nodeE);
        nodeG.addChild(nodeF);
        
        nodeE.addChild(nodeB);
        nodeF.addChild(nodeC);
        
        nodeA.addChild(root);
        nodeB.addChild(root);
        nodeC.addChild(root);
        
        List<Node> order = DFS.traverse(root);
        System.out.println(order.toString());
    }
    
    public static List<Node> traverse(Node root) {
        
        List<Node> order = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        
        stack.push(root);
        root.visited = true;
        
        order.add(root);
        
        while(!stack.isEmpty()) {
            Node node = stack.peek();
            Node child = node.getUnvisitedChild();
            
            if(child != null) {
                child.visited = true;
                order.add(child);
                stack.push(child);
            } else {
                stack.pop();
            }
        }
        
        return order;
    }
    
    
    
    static class Node {
        String data;
        boolean visited = false;
        LinkedList<Node> children = new LinkedList<>();
        
        Node(String data) {
            this.data = data;
        }
        
        void addChild(Node child) {
            children.add(child);
        }
        
        Node getUnvisitedChild() {
            
            Node child = null;
            
            for (Node node : children) {
                if(!node.visited) {
                    child = node;
                    break;
                }
            }
            
            return child;
        }

        @Override
        public String toString() {
            return data;
        }
    }
}
