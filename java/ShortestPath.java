/*
 * Title: Shortest Path
 * Author: Sam Gavis-Hughson
 * Date: 11/3/2016
 * 
 * Given a directed graph, find the shortest path between two nodes if one 
 * exists.
 * 
 * Execution: javac ShortestPath.java && java ShortestPath
 * 
 * For more details, check out http://www.byte-by-byte.com/shortestpath/
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {
    
    // Graph node class
    public static class Node {
        int value;
        List<Node> children;
        
        // Basic constructor
        public Node(int value) {
            this.value = value;
        }
        
        // Lazily instantiate children list
        public void addChild(Node n) {
            if (this.children == null) this.children = new LinkedList<Node>();
            this.children.add(n);
        }
    }
    
    // Find the shortest path between two nodes using BFS
    public static List<Node> shortestPath(Node a, Node b) {
        // Return null if either node is null or if they're the same node
        if (a == null || b == null) return null;
        if (a == b) return null;
        
        // Using a queue for our BFS
        Queue<Node> toVisit = new LinkedList<Node>();
        
        // Track the parents so that we can reconstruct our path
        HashMap<Node, Node> parents = new HashMap<Node, Node>();
        
        // Initialize the BFS
        toVisit.add(a);
        parents.put(a, null);
        
        // Keep going until we run out of nodes or reach our destination
        while (!toVisit.isEmpty()) {
            Node curr = toVisit.remove();
            
            // If we find the node we're looking for then we're done
            if (curr == b) break;
            
            // If the current node doesn't have children, skip it
            if (curr.children == null) continue;
            
            // Add all the children to the queue
            for (Node n : curr.children) {
                if (!parents.containsKey(n)) {
                    toVisit.add(n);
                    parents.put(n, curr);
                }
            }
        }
        
        // If we couldn't find a path, the destination node won't have been
        // added to our parents set
        if (parents.get(b) == null) return null;
        
        // Create the output list and add the path to the list
        List<Node> out = new LinkedList<Node>();
        Node n = b;
        while (n != null) {
            out.add(0, n);
            n = parents.get(n);
        }
        
        return out;
    }
    
    // Sample test cases
    public static void main(String[] args) {
        /* Construct sample graph
         * 0 ---> 1
         * ^ \    |
         * |  v   |
         * |   2  |  
         * |  ^   |
         * | /    v
         * 3 <--- 4
         */ 
        Node[] graph = new Node[5];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Node(i);
        }
        graph[0].addChild(graph[1]);
        graph[0].addChild(graph[2]);
        graph[1].addChild(graph[4]);
        graph[3].addChild(graph[0]);
        graph[3].addChild(graph[2]);
        graph[4].addChild(graph[3]);
        
        assert shortestPath(null, null) == null:
            "Null checks";
        assert shortestPath(graph[0], graph[1])
            .equals(Arrays.asList(new Node[]{graph[0], graph[1]})):
            "Path length 1";
        assert shortestPath(graph[0], graph[0]) == null:
            "Link to itself";
        assert shortestPath(graph[0], graph[3])
            .equals(Arrays.asList(new Node[]{graph[0], graph[1], graph[4], graph[3]})):
            "Multiple node path";
            
        System.out.println("Passed all test cases");
    }
}