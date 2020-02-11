import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		ATM atm = new ATM();

		Path path = Paths.get("racuni.txt");
		if (!Files.exists(path)) {
			Files.createFile(path);
		}

		BufferedWriter writer = Files.newBufferedWriter(path);

		System.out.println("**********ATM IZBORNIK***********");

		while (true) {
			System.out
					.println("\n1- KREIRANJE RACUNA\n2- STANJE NA RACUNU \n3- TRANSFER NOVCA\n4-EXIT");
			int izbor = sc.nextInt();
			if (izbor == 1) {
				System.out.println("Unesite broj racuna:");
				int unosBroj = sc.nextInt();
				while (unosBroj < 0) {
					System.out
							.println("Broj racuna ne smije biti negativan, pokusajte ponovo:");
					unosBroj = sc.nextInt();
				}
				while (atm.provjeraBrojaRacuna(unosBroj) == 1) {
					System.out
							.println("Broj racuna vec postoji u sistemu!\nUnesite broj racuna:");
					unosBroj = sc.nextInt();
				}

				System.out.println("Unesite ime korisnika:");
				String unosIme = sc.next();

				System.out.println("Unesite iznos novca za uplatu:");
				double unosIznos = sc.nextDouble();
				while (unosIznos < 0) {
					System.out
							.println("Iznos ne smije biti negativan, pokusajte ponovo:");
					unosIznos = sc.nextDouble();
				}

				atm.racuni.add(new Racun(unosBroj, unosIme, unosIznos));

				for(Racun e: atm.racuni){
					if(e.getBrojRacuna()!=unosBroj){
						writer.write(atm.racuni.toString());
						writer.newLine();
					}
				}
				

			} else if (izbor == 2) {
				System.out.println("Unesite broj racuna:");
				int unosBroja = sc.nextInt();
				if (atm.provjeraBrojaRacuna(unosBroja) == 1) {
					System.out.print("Stanje na racunu " + unosBroja + " je: ");
					for (Racun e : atm.racuni) {
						if (e.getBrojRacuna() == unosBroja) {
							System.out.println(e.getIznos() + " KM.");
						}
					}
				}
			} else if (izbor == 3) {
				System.out.println("Unesite broj izvornog racuna:");
				int unosIzvornog = sc.nextInt();
				if (atm.provjeraBrojaRacuna(unosIzvornog) == 1) {
					System.out.println("Unesite broj ciljanog racuna:");
					int unosCiljanog = sc.nextInt();
					if (atm.provjeraBrojaRacuna(unosCiljanog) == 1) {
						System.out.println("Unesite iznos koji prebacujete:");
						double unosTransfera = sc.nextDouble();
						for (Racun e : atm.racuni) {
							if (e.getBrojRacuna() == unosIzvornog) {
								if (e.getIznos() >= unosTransfera) {
									atm.prebaciNovac(unosIzvornog,
											unosCiljanog, unosTransfera);
									System.out
											.println("Uspjesno izvrsen transfer sa racuna "
													+ unosIzvornog
													+ " na racun "
													+ unosCiljanog
													+ " u iznosu "
													+ unosTransfera + " KM.");
								} else {
									System.out
											.println("Nedovoljno sredstava na racunu za navedeni transfer!");
								}
							}
						}
					} else {
						System.out
								.println("Ne postoji navedeni broj ciljanog racuna!");
					}
				} else {
					System.out
							.println("Ne postoji navedeni broj izvornog racuna!");
				}
			} else {
				break;
			}

		}

		sc.close();
		writer.close();

	}
}
