public class LlistaCobertura {

    private Cobertura[] llistaCoberturas;

    public LlistaCobertura(){
        llistaCoberturas = new Cobertura[1013];
    }

    public LlistaCobertura(Cobertura[] coberturas) {
        llistaCoberturas = new Cobertura[coberturas.length];

        for (int i = 0; i < coberturas.length; i++) {
            llistaCoberturas[i] = coberturas[i].copia();
        }
    }

    public int getNumElements() {
        return llistaCoberturas.length;
    }

    public Cobertura getCobertura(int i) {
        return llistaCoberturas[i];
    }

    public Cobertura[] getCoberturaPos(int pos) {
       for (int i = 0; i < llistaCoberturas.length; i++) {
            if (i == pos) {
                return new Cobertura[]{llistaCoberturas[i]};
            }
        }
        return null;
    }

    public String toString() {
       

        for (int i = 0; i < llistaCoberturas.length; i++) {
            if (llistaCoberturas[i] != null) {
                return  "\t" + i + ": " + llistaCoberturas[i] + "\n";
            }
        }

      
    }


}
