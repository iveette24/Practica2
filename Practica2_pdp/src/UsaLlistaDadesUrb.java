import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UsaLlistaDadesUrb {
	static Scanner teclat = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		int liniaIni, liniaFi;

		System.out.println("Indica les línies a llegir del fitxer");
		System.out.println("Quina és la primera línia a llegir del fitxer (valor >=1)");
		liniaIni = Integer.parseInt(teclat.nextLine());
		System.out.println("Quina és l'última línia a llegir del fitxer (valor <=12324)");
		liniaFi = Integer.parseInt(teclat.nextLine());

		String[] dataset = llegirLiniesFitxer(liniaIni, liniaFi);

		// mostrem el contingut que hem llegit. Això ho eliminarem en les
		// versions finals del codi
		
		LlistaCobertura  lista = new LlistaCobertura(dataset.length);

		
		for (int i = 0; i < dataset.length; i++) {
			System.out.println("Linia " + (i + 1) + " conté " + dataset[i]);

			String[] columnas = dataset[i].split(";");
			String operador = columnas[0];
			String tipusXarxa = columnas[1];
			int velocitat = Integer.parseInt(columnas[2]);
			int satelits = Integer.parseInt(columnas[3]);
			int precisio = Integer.parseInt(columnas[4]);
			String activitat = columnas[5];
			int codigoPostal = Integer.parseInt(columnas[6]);
			String municipi = columnas[7];

			Cobertura novaCobertura = new Cobertura(operador,tipusXarxa,velocitat,satelits,precisio,activitat,codigoPostal,municipi);
			lista.afegirCoberturas(novaCobertura);

			System.out.println(municipi);
		}

		String muni;
		System.out.println("Introduce un municipio del que quieras hacer una lista: ");
		muni = teclat.nextLine();

		System.out.println(lista.sublLlistaCobertura(muni));
		int opcio;
		do {
			System.out.println("\n ------ Menú ------");
			System.out.println("\n 1. Mostrar el conjunt de dades de la llista.");
			System.out.println("\n 2. Eliminar el conjunt de dades que són d’un cert codi postal.");
			System.out.println("\n 3. Comptar quants punts de cobertura tenen una velocitat superior a 100.");
			System.out.println("\n 4. Mostrar les dades de la instància que té menys precisió.");
			System.out.println("\n 5. Calcular el factor d’eficiència de la instància amb el tipus d’activitat indicat per paràmetre\n"
					+ "(TILTING o STILL), xarxa 4G i amb un nombre de satèl·lits captats superior a 13.");
			System.out.println("\n 6. Mostrar quants punts de cobertura tenen un factor d’eficiència per sobre de x\n"
					+ "(donat per l’usuari) en un municipi en concret (usuari indica el nom)."
					+ "\n");
			System.out.println("\n 7. Mostrar les dades de tots els punts de cobertura d’un operador indicat per paràmetre.");
			System.out.println("\n 8. Sortir del programa.");

			System.out.println("\nEscoge una opció: ");
			opcio = Integer.parseInt(teclat.nextLine());
			switch (opcio) {
				case 1:
					System.out.println("\n Opció 1: Mostrar contingut de la taula. ");
					mostrarLlista(lista);
					break;
				case 2:
					System.out.println("\n Opcion 2: Eliminar dades segons el codi postal.");
					eliminarPerCodiPostal(lista);
					break;
				case 3:
					System.out.println("\n Opcion 3: Compteig punts de cobetura.");
					comp(lista);
					break;
				case 4:
					System.out.println("\n Opcion 4: Dades de la instancia amb menys precició.");
					menysPrecisio(lista);
					break;
				case 5:
					System.out.println("\n Opcion 5: Calcular el factor d'eficiencia.");
					factorEficiencia(lista);
					break;
				case 6:
					System.out.println("\n Opcion 6: Punts de cobertura d'un factor d'eficiencia.");
					factorEficienciaMunicipi(lista);
					break;
				case 7:
					System.out.println("\n Opcion 7: Dades de tots el punts de cobertura d'un operador especific.");
					operatorLlista(lista);
					break;
				case 8:
					System.out.println("\n Fin del programa.");
					break;
				default:
					System.out.println("Opció no valida.");
			}

		} while (opcio != 8);
	}

	private static String[] llegirLiniesFitxer(int liniaIni, int liniaFi) throws FileNotFoundException {
		String[] result;
		String dada;
		int nLinies;
		if (liniaIni < 1)
			liniaIni = 1;
		if (liniaFi > 1013)
			liniaFi = 1013;
		nLinies = liniaFi - liniaIni + 1;
		result = new String[nLinies];
		Scanner f = new Scanner(new File("Dades_Cobertura_Mobil.csv"));

		String capcalera = f.nextLine();
		System.out.println("El format de les dades en cada línia és el següent:\n" + capcalera);
		// ens saltem les línies fins a la liniaIni
		for (int i = 1; i < liniaIni; i++) {
			dada = f.nextLine();
		}
		// ara anirem guardant les nLinies que sí volem llegir
		for (int i = 0; i < nLinies; i++) {
			result[i] = f.nextLine();
		}
		f.close();
		return result;
	}

	private static void mostrarLlista(LlistaCobertura lista){
		
		System.out.println(lista.toString());
	}

	private static void comp(LlistaCobertura lista){
		
		System.out.println("Punts amb velocitat > 100: " + lista.comptadorVelocitat());
	}

	private static void menysPrecisio(LlistaCobertura lista){
		System.out.println("Instacia amb menys precisió: " + lista.ambMenysPrecisio());
	}

	private static void eliminarPerCodiPostal(LlistaCobertura lista) {
		System.out.println("Introdueix el codi postal que vols eliminar: ");
		int codiPostal = Integer.parseInt(teclat.nextLine());
		int eliminades = lista.eliminarPerCodiPostal(codiPostal);
		System.out.println("S'han eliminat " + eliminades + " cobertures amb aquest codi postal.");
	}

	private static void factorEficiencia(LlistaCobertura lista) {
		System.out.println("Introdueix l'activitat (TILTING o STILL): ");
		String activitat = teclat.nextLine();
		Cobertura cobertura = lista.coberturaAmbFactorEficiencia(activitat, "4G");
		if (cobertura == null) {
			System.out.println("No hi ha cap cobertura amb aquestes condicions.");
			return;
		}
		double factor = lista.factorEficiencia(cobertura);
		System.out.println("Factor d'eficiència de la cobertura trobada: " + factor);
		System.out.println(cobertura);
	}

	private static void factorEficienciaMunicipi(LlistaCobertura lista) {
		System.out.println("Introdueix un municipi: ");
		String municipi = teclat.nextLine();
		System.out.println("Introdueix el llindar x: ");
		double x = Double.parseDouble(teclat.nextLine());
		int total = lista.comptarFactorEficienciaSuperior(x, municipi);
		System.out.println("Hi ha " + total + " punts de cobertura amb factor superior a " + x + " a " + municipi + ".");
	}

	private static void operatorLlista(LlistaCobertura lista) {
		System.out.println("Introdueix l'operador: ");
		String operador = teclat.nextLine();
		LlistaCobertura resultat = lista.perOperador(operador);
		System.out.println(resultat);
	}
}
