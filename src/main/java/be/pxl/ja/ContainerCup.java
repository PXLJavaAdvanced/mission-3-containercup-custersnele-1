package be.pxl.ja;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

public class ContainerCup {

	public static void main(String[] args) {
		// TODO lees bestand containercup
		List<Deelnemer> deelnemerList = DeelnemerReader.readFile(Path.of("src/main/resources/containercup.csv"));
		System.out.println("Aantal deelnemers in klassement BV");
		// TODO gebruik een stream om aantal deelnemers in klassement BV te tellen
		long count = deelnemerList.stream().filter(d -> d.getKlassement() == Klassement.BV).count();
		System.out.println(count);
		System.out.println("Klassement sportman (top 5)");
		// TODO gebruik een stream om top-5 voor klassement SPORTMAN (M) te maken
		deelnemerList.stream()
				.filter(d -> d.getKlassement() == Klassement.M)
				.sorted()
				.limit(5)
				.forEach(System.out::println);


		System.out.println();
		System.out.println("Maximum monkey bars");
		// TODO gebruik een stream om het hoogste aantal monkey bars, door een deelnemer uitgevoerd, af te drukken
		int maxMonkeyBars = deelnemerList.stream()
				.max(Comparator.comparingInt(Deelnemer::getMonkeyBars))
				.map(Deelnemer::getMonkeyBars)
				.orElse(-1);
		System.out.println(maxMonkeyBars);
		deelnemerList.stream().mapToInt(Deelnemer::getMonkeyBars).max().ifPresent(System.out::println);

	}

}
