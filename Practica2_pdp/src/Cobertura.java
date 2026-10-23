public class Cobertura {
	private String operador;
	private String tipusXarxa;
	private int velocitat;
	private int satelits;;
	private int precisio;
	private String activitat;
	private int codiPostal;
	private String nomMunicipi;

	public Cobertura(String operador, String netType, int speed, int satellites,
			int precision, String activitat, int codiPostal, String nom) {
		this.operador = operador;
		this.tipusXarxa = netType;
		this.velocitat = speed;
		this.satelits = satellites;
		this.precisio = precision;
		this.activitat = activitat;
		this.codiPostal = codiPostal;
		this.nomMunicipi = nom;
	}

	@Override
	public String toString() {
		String aux = "\n\tOperador:" + operador + "\n\tXarxa:" + tipusXarxa + "\n\tVelocitat:" +
				velocitat + "\n\tSatèl.lits:" + satelits + "\n\tPrecisió:" + precisio + "\n\tActivitat:" +
				activitat + "\n\tCodi Postal:" + codiPostal + "\n\tMunicipi:" + nomMunicipi;
		return aux;
	}


	public Cobertura copia() {
		Cobertura duplicat = new Cobertura(operador, tipusXarxa, velocitat, satelits,
				precisio, activitat, codiPostal, nomMunicipi);
		return duplicat;
	}

	public String getOperador() {
		return operador;
	}

	public String getTipusXarxa() {
		return tipusXarxa;
	}

	public int getVelocitat() {
		return velocitat;
	}

	public int getSatelits() {
		return satelits;
	}

	public int getPrecisio() {
		return precisio;
	}

	public String getActivitat() {
		return activitat;
	}

	public int getCodiPostal() {
		return codiPostal;
	}

	public String getNomMunicipi() {
		return nomMunicipi;
	}
	
}
