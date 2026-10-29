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
		for (int i = 0; i < dataset.length; i++) {
			System.out.println("Linia " + (i + 1) + " conté " + dataset[i]);
		}

		// Completar el codi a partir d'aquí
		Scanner sc = new Scanner(System.in);
		int opcio;
		do{
			System.out.println("\n ------ Menú ------");
			System.out.println("\n 1. Mostrar el conjunt de dades de la llista.");
			System.out.println("\n 2. Eliminar el conjunt de dades que són d’un cert codi postal.");
			System.out.println("\n 3. Comptar quants punts de cobertura tenen una velocitat superior a 100.");
			System.out.println("\n 4. Mostrar les dades de la instància que té menys precisió. ");
			System.out.println("\n 5. Calcular el factor d’eficiència de la instància amb el tipus d’activitat indicat per paràmetre\n" + //
								"(TILTING o STILL), xarxa 4G i amb un nombre de satèl·lits captats superior a 13.");
			System.out.println("\n 6. Mostrar quants punts de cobertura tenen un factor d’eficiència per sobre de x (donat per\n" + //
								"l’usuari) en un municipi en concret (usuari indica el nom).");
			System.out.println("\n 7. Mostrar les dades de tots els punts de cobertura d’un operador indicat per paràmetre. ");
			System.out.println("\n 8. Sortir del programa.");

			System.out.println("\nEscoge una opció: ");
			opcio = sc.nextInt() ;
			switch (opcio) {
				case 1:
					System.out.println("\n Opció 1: Mostrar contingut de la taula. ");
					
					break;
				case 2:
					System.out.println("\n Opcion 2: Eliminar dades segons el codi postal.");
					break;
				case 3:
					System.out.println("\n Opcion 3: Compteig punts de cobetura.");
					break;
				case 4:
					System.out.println("\n Opcion 4: Dades de la instancia amb menys precició.");
					break;	
				case 5:
					System.out.println("\n Opcion 5: Calcular el factor d'eficiencia.");
					break;	
				case 6:
					System.out.println("\n Opcion 6: Punts de cobertura d'un factor d'eficiencia.");
					break;	 
				case 7:
					System.out.println("\n Opcion 7: Dades de tots el punts de cobertura d'un operador especific.");
					break;	
				case 8:
					System.out.println("\n Fin del programa.");
					break;
				default:
					System.out.println("Opció no valida.");;
			}

		}while(opcio != 8);
		sc.close(); 
		

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

}