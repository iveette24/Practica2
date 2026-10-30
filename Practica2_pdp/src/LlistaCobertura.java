public class LlistaCobertura {

    // private static final int MAX_COBERTURA = 1013;

    private Cobertura[] llistaCoberturas;
    private int mida;
    private int numCoberturas; // Nombre d'elemets disponibles a la taula.

    public LlistaCobertura(int mida){
        this.mida = mida;
        this.llistaCoberturas = new Cobertura[mida];
        this.numCoberturas = 0;

    }

    public void afegirCoberturas(Cobertura cobertura) {
        if (cobertura != null && numCoberturas < mida) {
            this.llistaCoberturas[numCoberturas] = cobertura.copia();
            numCoberturas++;
        }
        
    }

    /** Getter numero de elemetos de la lista 
    *@return numCoberuras - variable con la cantidad e elementos disponibles en la tabla 
    *
    */
    public int getNumElements() {
        return numCoberturas;
    }

    /**
     * Getter per obtenir les dades d'una cobertura segons  la seva posicio
     * @param i per parametre pasem la posició
     * @return dades de la cobertura.
     */
    public Cobertura getCobertura(int i) {
        if (i < 0 || i >= numCoberturas) {
            return null;
        }
        return llistaCoberturas[i];
    }


    public String toString() {
        if (numCoberturas == 0 || llistaCoberturas == null) {
            return null;
        }
       String text = "";

        for (int i = 0; i < llistaCoberturas.length; i++) {
            if (llistaCoberturas[i] != null) {
                text += ("\nPosició " + (i+1) + ": " + llistaCoberturas[i] + "\n");
            }
        }

        return text;
    }

    public int comptadorVelocitat(){

        int comp = 0;
        for(int i = 0; i < numCoberturas; i++){
            if(this.llistaCoberturas[i].getVelocitat() > 100){
                comp++;
            }
        }
        return comp;
    };

    public Cobertura ambMenysPrecisio(){
        if (numCoberturas == 0 || llistaCoberturas == null) {
            return null;
        }
        Cobertura precisió = llistaCoberturas[0];
        for (int i =0 ; i < numCoberturas; i++){
            if(llistaCoberturas[i].getPrecisio() < precisió.getPrecisio()){
                precisió = llistaCoberturas[i];
            }
        }
        return  precisió;
    }

    public LlistaCobertura sublLlistaCobertura(String municipi){
        int comp = 0;

        for (int i=0; i<numCoberturas; i++){
            if (llistaCoberturas[i].getNomMunicipi().equalsIgnoreCase(municipi)){
                comp++;
            }
        }

        LlistaCobertura listaMucinipi = new LlistaCobertura(comp);

        for(int i=0; i<numCoberturas; i++){
            if (llistaCoberturas[i].getNomMunicipi().equalsIgnoreCase(municipi)) {
                listaMucinipi.afegirCoberturas(llistaCoberturas[i]);
            }
        }
        return listaMucinipi;

    }
}
