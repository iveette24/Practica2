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
                text += "\nPosició " + (i+1) + ": " + llistaCoberturas[i] + "\n";
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
    }

    public Cobertura ambMenysPrecisio(){
        if (numCoberturas == 0 || llistaCoberturas == null) {
            return null;
        }
        Cobertura precisioMinima = llistaCoberturas[0];
        for (int i = 0; i < numCoberturas; i++){
            if (llistaCoberturas[i].getPrecisio() < precisioMinima.getPrecisio()){
                precisioMinima = llistaCoberturas[i];
            }
        }
        return precisioMinima;
    }

    public int eliminarPerCodiPostal(int codiPostal) {
        int eliminades = 0;
        Cobertura[] novaLlista = new Cobertura[numCoberturas];
        int posicio = 0;

        for (int i = 0; i < numCoberturas; i++) {
            if (llistaCoberturas[i].getCodiPostal() != codiPostal) {
                novaLlista[posicio] = llistaCoberturas[i];
                posicio++;
            } else {
                eliminades++;
            }
        }

        llistaCoberturas = novaLlista;
        mida = posicio;
        numCoberturas = posicio;
        return eliminades;
    }

    public double factorEficiencia(Cobertura cobertura) {
        if (cobertura == null) {
            return 0;
        }
        return /*(double)*/ cobertura.getVelocitat() * cobertura.getSatelits() / cobertura.getPrecisio();
    }

    public Cobertura coberturaAmbFactorEficiencia(String activitat, String xarxa) {
        if (activitat == null || xarxa == null) {
            return null;
        }

        for (int i = 0; i < numCoberturas; i++) {
            Cobertura c = llistaCoberturas[i];
            if (c.getActivitat().equalsIgnoreCase(activitat)
                    && c.getTipusXarxa().equalsIgnoreCase(xarxa)
                    && c.getSatelits() > 13) {
                return c;
            }
        }
        return null;
    }

    public int comptarFactorEficienciaSuperior(double x, String municipi) {
        int comp = 0;
        for (int i = 0; i < numCoberturas; i++) {
            Cobertura c = llistaCoberturas[i];
            if (c.getNomMunicipi().equalsIgnoreCase(municipi)
                    && factorEficiencia(c) > x) {
                comp++;
            }
        }
        return comp;
    }

    public LlistaCobertura perOperador(String operador) {
        int comp = 0;
        for (int i = 0; i < numCoberturas; i++) {
            if (llistaCoberturas[i].getOperador().equalsIgnoreCase(operador)) {
                comp++;
            }
        }

        LlistaCobertura resultat = new LlistaCobertura(comp);
        for (int i = 0; i < numCoberturas; i++) {
            if (llistaCoberturas[i].getOperador().equalsIgnoreCase(operador)) {
                resultat.afegirCoberturas(llistaCoberturas[i]);
            }
        }
        return resultat;
    }

    public LlistaCobertura sublLlistaCobertura(String municipi){
        int comp = 0;

        for (int i = 0; i < numCoberturas; i++){
            if (llistaCoberturas[i].getNomMunicipi().equalsIgnoreCase(municipi)){
                comp++;
            }
        }

        LlistaCobertura llistaMunicipi = new LlistaCobertura(comp);

        for(int i = 0; i < numCoberturas; i++){
            if (llistaCoberturas[i].getNomMunicipi().equalsIgnoreCase(municipi)) {
                llistaMunicipi.afegirCoberturas(llistaCoberturas[i]);
            }
        }
        return llistaMunicipi;
    }
}
