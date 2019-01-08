package arnau.cubatasbbdd;

public class Bar {
    private long id;
    private String nomBar;

    public Bar() {
        this.id = -1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getnomBar() {
        return nomBar;
    }
    
    public void setnomBar(String nomBar) {
        this.nomBar = nomBar;
    }
}
