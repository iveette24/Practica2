public class LlistaCobertura {

    private static final int MAX_COBERTURA = 1013;

    private Cobertura[] llistaCoberturas;
    private int numCoberturas; // Nombre d'elemets disponibles a la taula.

    public LlistaCobertura(){
        llistaCoberturas = new Cobertura[MAX_COBERTURA];
    }

    public void afegirCoberturas(Cobertura[] coberturas) {
        for (int i = 0; i < coberturas.length; i++) {
            if (coberturas[i] != null && numCoberturas < MAX_COBERTURA) {
                this.llistaCoberturas[numCoberturas] = coberturas[i].copia();
                numCoberturas++;
            }
        }
    }

    /** Getter numero de elemetos de la lista 
    *@return numCoberuras - variable con la cantidad e elementos disponibles en la tabla 
    *
    */

    public int getNumElements() {
        return numCoberturas;
    }

    public Cobertura getCobertura(int i) {
        if (i < 0 || i >= numCoberturas) {
            return null;
        }
        return llistaCoberturas[i];
    }


    public String toString() {
       String text = "";

        for (int i = 0; i < llistaCoberturas.length; i++) {
            if (llistaCoberturas[i] != null) {
                text += ("\t" + i + ": " + llistaCoberturas[i] + "\n");
            }
        }

        return text;
    }


}
