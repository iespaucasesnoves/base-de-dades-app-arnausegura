package arnau.cubatasbbdd;

public class Cubata {
    private long id;
    private String nomCubata;
    private String graduacio;
    private String tipus;
    private String data;
    private String comentari;
    private long idBar;
    private double preu;
    private String valOlfativa;
    private String valGustativa;
    private String valVisual;
    private int nota;
    private String foto;

    public Cubata() {
        this.id = -1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getnomCubata() {
        return nomCubata;
    }

    public void setnomCubata(String nomCubata) {
        this.nomCubata = nomCubata;
    }

    public String getGraduacio() {
        return graduacio;
    }

    public void setGraduacio(String graduacio) {
        this.graduacio = graduacio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getComentari() {
        return comentari;
    }

    public void setComentari(String comentari) {
        this.comentari = comentari;
    }

    public long getIdBar() {
        return idBar;
    }

    public void setIdBar(long idBar) {
        this.idBar = idBar;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getValOlfativa() {
        return valOlfativa;
    }

    public void setValOlfativa(String valOlfativa) {
        this.valOlfativa = valOlfativa;
    }

    public String getValGustativa() {
        return valGustativa;
    }

    public void setValGustativa(String valGustativa) {
        this.valGustativa = valGustativa;
    }

    public String getValVisual() {
        return valVisual;
    }

    public void setValVisual(String valVisual) {
        this.valVisual = valVisual;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota= nota;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto
                = foto;
    }

}