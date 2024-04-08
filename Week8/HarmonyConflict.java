package Week8;

import java.io.FileNotFoundException;

public class HarmonyConflict {

    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public HarmonyConflict(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++)
            if (!marked[s])
                dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)){
            int w = e.getTo();
            if (!marked[w]) {
                color[w] = e.isConflict() == true ? !color[v] : color[v];
                dfs(G, w);
            } else if ((color[w] == color[v] && e.isConflict()) || color[w] != color[v] && !e.isConflict())
                isTwoColorable = false;
            }
    }

    public int isTwoColorable() {
        return isTwoColorable == true ? 1 : 0;
    }


    public static void main(String[] args) throws FileNotFoundException {
        Graph g = new Graph();
        HarmonyConflict h = new HarmonyConflict(g);
        System.out.println(h.isTwoColorable());

    }
}
