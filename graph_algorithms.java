import java.util.*;

class Graph {
    private Map<Integer, List<Edge>> adjacencyList;
    private int vertexCount;
    
    public Graph(int vertices) {
        this.vertexCount = vertices;
        adjacencyList = new HashMap<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.put(i, new ArrayList<>());
        }
    }
    
    public void addEdge(int source, int destination, int weight) {
        if (source >= vertexCount || destination >= vertexCount) {
            throw new IllegalArgumentException("Vertex out of bounds");
        }
        adjacencyList.get(source).add(new Edge(destination, weight));
    }
    
    public void addBidirectionalEdge(int source, int destination, int weight) {
        addEdge(source, destination, weight);
        addEdge(destination, source, weight);
    }
    
    public List<Integer> bfs(int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertexCount];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);
            
            List<Edge> neighbors = adjacencyList.get(current);
            for (Edge edge : neighbors) {
                if (!visited[edge.destination]) {
                    visited[edge.destination] = true;
                    queue.offer(edge.destination);
                }
            }
        }
        
        return result;
    }
    
    public List<Integer> dfs(int start) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[vertexCount];
        dfsHelper(start, visited, result);
        return result;
    }
    
    private void dfsHelper(int vertex, boolean[] visited, List<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);
        
        List<Edge> neighbors = adjacencyList.get(vertex);
        for (Edge edge : neighbors) {
            if (!visited[edge.destination]) {
                dfsHelper(edge.destination, visited, result);
            }
        }
    }
    
    public Map<Integer, Integer> dijkstra(int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();
        
        for (int i = 0; i < vertexCount; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (visited.contains(current.vertex)) {
                continue;
            }
            visited.add(current.vertex);
            
            List<Edge> neighbors = adjacencyList.get(current.vertex);
            for (Edge edge : neighbors) {
                int newDist = distances.get(current.vertex) + edge.weight;
                
                if (newDist < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDist);
                    pq.offer(new Node(edge.destination, newDist));
                }
            }
        }
        
        return distances;
    }
    
    public List<Integer> getShortestPath(int start, int end) {
        Map<Integer, Integer> previous = new HashMap<>();
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for (int i = 0; i < vertexCount; i++) {
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            
            if (current.vertex == end) {
                break;
            }
            
            List<Edge> neighbors = adjacencyList.get(current.vertex);
            for (Edge edge : neighbors) {
                int newDist = distances.get(current.vertex) + edge.weight;
                
                if (newDist < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDist);
                    previous.put(edge.destination, current.vertex);
                    pq.offer(new Node(edge.destination, newDist));
                }
            }
        }
        
        List<Integer> path = new ArrayList<>();
        Integer current = end;
        
        while (current != null) {
            path.add(current);
            current = previous.get(current);
        }
        
        Collections.reverse(path);
        return path;
    }
    
    public boolean hasCycle() {
        boolean[] visited = new boolean[vertexCount];
        boolean[] recStack = new boolean[vertexCount];
        
        for (int i = 0; i < vertexCount; i++) {
            if (hasCycleUtil(i, visited, recStack)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean hasCycleUtil(int vertex, boolean[] visited, boolean[] recStack) {
        visited[vertex] = true;
        recStack[vertex] = true;
        
        List<Edge> neighbors = adjacencyList.get(vertex);
        for (Edge edge : neighbors) {
            if (!visited[edge.destination]) {
                if (hasCycleUtil(edge.destination, visited, recStack)) {
                    return true;
                }
            } else if (recStack[edge.destination]) {
                return true;
            }
        }
        
        recStack[vertex] = false;
        return false;
    }
    
    public int getVertexCount() {
        return vertexCount;
    }
    
    public Map<Integer, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }
}

class Edge {
    int destination;
    int weight;
    
    public Edge(int destination, int weight) {
        this.destination = destination;
        this.weight = weight;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return destination == edge.destination;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(destination, weight);
    }
}

class Node implements Comparable<Node> {
    int vertex;
    int distance;
    
    public Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}

class GraphAnalyzer {
    private Graph graph;
    
    public GraphAnalyzer(Graph graph) {
        this.graph = graph;
    }
    
    public double calculateDensity() {
        int V = graph.getVertexCount();
        int E = 0;
        
        Map<Integer, List<Edge>> adjList = graph.getAdjacencyList();
        for (List<Edge> edges : adjList.values()) {
            if (edges != null) {
                E += edges.size();
            }
        }
        
        return (2.0 * E) / (V * (V - 1));
    }
    
    public List<List<Integer>> findConnectedComponents() {
        List<List<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[graph.getVertexCount()];
        
        for (int i = 0; i < graph.getVertexCount(); i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfsComponent(i, visited, component);
                components.add(component);
            }
        }
        
        return components;
    }
    
    private void dfsComponent(int vertex, boolean[] visited, List<Integer> component) {
        visited[vertex] = true;
        component.add(vertex);
        
        List<Edge> neighbors = graph.getAdjacencyList().get(vertex);
        for (Edge edge : neighbors) {
            if (!visited[edge.destination]) {
                dfsComponent(edge.destination, visited, component);
            }
        }
    }
    
    public int findLongestPath(int start) {
        Map<Integer, Integer> distances = new HashMap<>();
        boolean[] visited = new boolean[graph.getVertexCount()];
        
        for (int i = 0; i < graph.getVertexCount(); i++) {
            distances.put(i, 0);
        }
        
        dfsLongestPath(start, visited, distances, 0);
        
        int maxDist = 0;
        for (int dist : distances.values()) {
            if (dist > maxDist) {
                maxDist = dist;
            }
        }
        
        return maxDist;
    }
    
    private void dfsLongestPath(int vertex, boolean[] visited, Map<Integer, Integer> distances, int currentDist) {
        visited[vertex] = true;
        distances.put(vertex, Math.max(distances.get(vertex), currentDist));
        
        List<Edge> neighbors = graph.getAdjacencyList().get(vertex);
        if (neighbors != null) {
            for (Edge edge : neighbors) {
                if (!visited[edge.destination]) {
                    dfsLongestPath(edge.destination, visited, distances, currentDist + edge.weight);
                }
            }
        }
    }
}

class PathFinder {
    private Graph graph;
    
    public PathFinder(Graph graph) {
        this.graph = graph;
    }
    
    public boolean pathExists(int start, int end) {
        if (start == end) return true;
        
        boolean[] visited = new boolean[graph.getVertexCount()];
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (current == end) {
                return true;
            }
            
            visited[current] = true;
            
            List<Edge> neighbors = graph.getAdjacencyList().get(current);
            if (neighbors != null) {
                for (Edge edge : neighbors) {
                    if (!visited[edge.destination]) {
                        queue.offer(edge.destination);
                    }
                }
            }
        }
        
        return false;
    }
    
    public List<List<Integer>> findAllPaths(int start, int end) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        boolean[] visited = new boolean[graph.getVertexCount()];
        
        currentPath.add(start);
        findAllPathsUtil(start, end, visited, currentPath, allPaths);
        
        return allPaths;
    }
    
    private void findAllPathsUtil(int current, int end, boolean[] visited, 
                                  List<Integer> currentPath, List<List<Integer>> allPaths) {
        if (current == end) {
            allPaths.add(currentPath);
            return;
        }
        
        visited[current] = true;
        
        List<Edge> neighbors = graph.getAdjacencyList().get(current);
        if (neighbors != null) {
            for (Edge edge : neighbors) {
                if (!visited[edge.destination]) {
                    currentPath.add(edge.destination);
                    findAllPathsUtil(edge.destination, end, visited, currentPath, allPaths);
                    currentPath.remove(currentPath.size() - 1);
                }
            }
        }
        
        visited[current] = false;
    }
    
    public int countPathsOfLength(int start, int length) {
        return countPathsUtil(start, length);
    }
    
    private int countPathsUtil(int current, int remaining) {
        if (remaining == 0) {
            return 1;
        }
        
        int count = 0;
        List<Edge> neighbors = graph.getAdjacencyList().get(current);
        
        if (neighbors != null) {
            for (Edge edge : neighbors) {
                count += countPathsUtil(edge.destination, remaining - 1);
            }
        }
        
        return count;
    }
}

class GraphUtils {
    
    public static int[] calculateOutDegrees(Graph graph) {
        int[] degrees = new int[graph.getVertexCount()];
        
        Map<Integer, List<Edge>> adjList = graph.getAdjacencyList();
        for (int vertex : adjList.keySet()) {
            List<Edge> edges = adjList.get(vertex);
            degrees[vertex] = edges.size();
        }
        
        return degrees;
    }
    
    public static boolean isConnected(Graph graph) {
        if (graph.getVertexCount() == 0) return true;
        
        List<Integer> reachable = graph.bfs(0);
        return reachable.size() == graph.getVertexCount();
    }
    
    public static Graph transpose(Graph graph) {
        Graph transposed = new Graph(graph.getVertexCount());
        
        Map<Integer, List<Edge>> adjList = graph.getAdjacencyList();
        for (int source : adjList.keySet()) {
            List<Edge> edges = adjList.get(source);
            for (Edge edge : edges) {
                transposed.addEdge(edge.destination, source, edge.weight);
            }
        }
        
        return transposed;
    }
    
    public static int getTotalWeight(Graph graph) {
        int total = 0;
        
        Map<Integer, List<Edge>> adjList = graph.getAdjacencyList();
        for (List<Edge> edges : adjList.values()) {
            if (edges != null) {
                for (Edge edge : edges) {
                    total += edge.weight;
                }
            }
        }
        
        return total;
    }
    
    public static boolean hasNegativeWeights(Graph graph) {
        Map<Integer, List<Edge>> adjList = graph.getAdjacencyList();
        
        for (List<Edge> edges : adjList.values()) {
            for (Edge edge : edges) {
                if (edge.weight < 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

public class GraphAlgorithms {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 2);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 3);
        
        System.out.println("BFS from 0: " + graph.bfs(0));
        System.out.println("DFS from 0: " + graph.dfs(0));
        
        System.out.println("\nDijkstra from 0:");
        Map<Integer, Integer> distances = graph.dijkstra(0);
        for (int v : distances.keySet()) {
            System.out.println("  " + v + ": " + distances.get(v));
        }
        
        System.out.println("\nShortest path 0->5: " + graph.getShortestPath(0, 5));
        
        GraphAnalyzer analyzer = new GraphAnalyzer(graph);
        System.out.println("\nDensity: " + analyzer.calculateDensity());
        System.out.println("Components: " + analyzer.findConnectedComponents());
        
        PathFinder pf = new PathFinder(graph);
        System.out.println("\nPath exists 0->5: " + pf.pathExists(0, 5));
        System.out.println("All paths 0->4:");
        for (List<Integer> path : pf.findAllPaths(0, 4)) {
            System.out.println("  " + path);
        }
        
        Graph dag = new Graph(4);
        dag.addEdge(0, 1, 1);
        dag.addEdge(0, 2, 1);
        dag.addEdge(1, 3, 1);
        dag.addEdge(2, 3, 1);
        
        System.out.println("\nDAG has cycle: " + dag.hasCycle());
        
        System.out.println("\nOut-degrees: " + Arrays.toString(GraphUtils.calculateOutDegrees(graph)));
        System.out.println("Is connected: " + GraphUtils.isConnected(graph));
        System.out.println("Total weight: " + GraphUtils.getTotalWeight(graph));
    }
}
