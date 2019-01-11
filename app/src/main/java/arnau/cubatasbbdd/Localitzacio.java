package arnau.cubatasbbdd;

public class Localitzacio {
    private long id;
    private String lloc;

    public Localitzacio() {
        this.id = -1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLloc() {
        return lloc;
    }

    public void setLloc(String lloc) {
        this.lloc = lloc;
    }
}
