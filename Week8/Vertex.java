package Week8;

public class Vertex {
    private boolean marked;
    private boolean coloured;

    public Vertex() {
        marked = false;
        coloured = false;
    }

    public void mark() {
        marked = true;
    }

    public boolean isMarked() {
        return marked;
    }

    public void colour() {
        coloured = true;
    }
    public boolean isColoured() {
        return coloured;
    }


    
    }
