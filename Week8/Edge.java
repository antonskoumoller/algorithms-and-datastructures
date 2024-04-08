package Week8;

class Edge {
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