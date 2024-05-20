import java.util.Objects;

public class Materasso {
    private String tipo;
    private String id;
    private int altezza;
    private int lunghezza;
    private int spessore;
    private boolean molle;

    public Materasso() {
    }

    public Materasso(String tipo, String id, int altezza, int lunghezza, int spessore, boolean molle) {
        this.tipo = tipo;
        this.id = id;
        this.altezza = altezza;
        this.lunghezza = lunghezza;
        this.spessore = spessore;
        this.molle = molle;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAltezza() {
        return altezza;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }

    public int getSpessore() {
        return spessore;
    }

    public void setSpessore(int spessore) {
        this.spessore = spessore;
    }

    public boolean isMolle() {
        return molle;
    }

    public void setMolle(boolean molle) {
        this.molle = molle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materasso materasso = (Materasso) o;
        return altezza == materasso.altezza && lunghezza == materasso.lunghezza && spessore == materasso.spessore && molle == materasso.molle && Objects.equals(tipo, materasso.tipo) && Objects.equals(id, materasso.id);
    }

}
