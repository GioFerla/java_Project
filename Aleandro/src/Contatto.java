public class Contatto {
    private String tipo;
    private String dato;

    public Contatto(String tipo, String dato) {
        this.tipo = tipo;
        this.dato = dato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + "|| Dato: " + dato + '\n';
    }
}