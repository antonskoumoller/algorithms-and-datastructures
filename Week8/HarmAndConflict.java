import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Queue;
import java.io.File;
import java.util.LinkedList;


public class HarmAndConflict {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;
    private int nVertex;
    
    private static LinkedList<Edge>[] adj;

    public HarmAndConflict(int v, int e) {
        marked = new boolean[v];
        color = new boolean[v];
        nVertex = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }

        
    }

    // private void dfs(LinkedList<Edge>[] G, int v) {
    //     marked[v] = true;
    //     for (Edge e : G[v]){
    //         int w = e.getTo();
    //         if (!marked[w]) {
    //             color[w] = e.isConflict() == true ? !color[v] : color[v];
    //             dfs(G, w);
    //         } else if ((color[w] == color[v] && e.isConflict()) || color[w] != color[v] && !e.isConflict())
    //             isTwoColorable = false;
    //         }
    // }

    private void bfs(LinkedList<Edge>[] G, int start) {
    Queue<Integer> queue = new LinkedList<>();
    marked[start] = true;
    queue.add(start);

    while (!queue.isEmpty()) {
        int v = queue.poll();

        for (Edge e : G[v]) {
            int w = e.getTo();
            if (!marked[w]) {
                marked[w] = true;
                color[w] = e.isConflict() ? !color[v] : color[v];
                queue.add(w);
            } else if ((color[w] == color[v] && e.isConflict()) || (color[w] != color[v] && !e.isConflict())) {
                isTwoColorable = false;
            }
        }
    }
}


    public static void addEdge(int v, int w, int isConflict) {
        adj[v].add(new Edge(w, isConflict));
        adj[w].add(new Edge(v, isConflict));

    }

    public int isTwoColorable() {
        for (int s = 0; s < nVertex; s++)
            if (!marked[s])
                bfs(adj, s);
        return isTwoColorable == true ? 1 : 0;
    }

    static class Edge {
        private int to;
        private int isConflict;
    
        public Edge(int to, int isConflict) {
            this.to = to;
            this.isConflict = isConflict;
        }
    
        public int getTo() {
            return to;
        }
    
        public boolean isConflict() {
            return isConflict == 1;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        // File file = new File("Week8\\file.txt");
        // Scanner sc = new Scanner(file);
        int v = sc.nextInt();
        int e = sc.nextInt();

        HarmAndConflict h = new HarmAndConflict(v,e);
        for(int i = 0; i < e; i++) {
            addEdge(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }

        System.out.println(h.isTwoColorable());

    }
}
