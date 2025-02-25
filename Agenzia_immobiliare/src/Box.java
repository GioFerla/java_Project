public class Box extends Immobile{
    private int numeroPostiAuto;

    public Box(String codiceAgenzia, String indirizzo, String cap, String citta, String provincia, int superficie, int prezzo, int numeroPostiAuto) {
        super(codiceAgenzia, indirizzo, cap, citta, provincia, superficie, prezzo);
        this.numeroPostiAuto = numeroPostiAuto;
    }

    public int getNumeroPostiAuto() {
        return numeroPostiAuto;
    }

    public void setNumeroPostiAuto(int numeroPostiAuto) {
        this.numeroPostiAuto = numeroPostiAuto;
    }

    @Override
    public String toString() {
        return "Box{" +
                "numeroPostiAuto=" + numeroPostiAuto +
                "} " + super.toString();
    }
}
