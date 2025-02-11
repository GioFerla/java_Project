public class Insegnante extends Persona {
    private String materia;
    private String classe;
    private String cf;

    public Insegnante(String nome, String cognome, String materia, String classe, String cf) {
        super(nome, cognome);
        this.materia = materia;
        this.classe = classe;
        this.cf = cf;
    }
    
    public String getMateria() {
        return materia;
    }

    public String getClasse() {
        return classe;
    }

    public String getCf() {
        return cf;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }


    public void setCf(String cf) {
        this.cf = cf;
    }

    @Override
    public String toString() {
        return "Insegnante{" + "materia=" + materia + ", classe=" + classe + ", cf=" + cf + '}';
    }
}
