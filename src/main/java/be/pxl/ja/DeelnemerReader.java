package be.pxl.ja;

import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class DeelnemerReader {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("mm:ss");

	// TODO implement static method for reading file

	public static Deelnemer mapLineToDeelnemer(String line) {
		String[] split = line.split(";");
		Deelnemer deelnemer = new Deelnemer(split[0], Klassement.valueOf(split[9]));
		deelnemer.setLopen(parseDuration(split[2]));
		deelnemer.setMonkeyBars(Integer.parseInt(split[3]));
		deelnemer.setGolf(Integer.parseInt(split[4]));
		deelnemer.setRoeien(parseDuration(split[5]));
		deelnemer.setSchieten(Integer.parseInt(split[6]));
		deelnemer.setBenchpress(Integer.parseInt(split[7]));
		deelnemer.setFietsen(parseDuration(split[8]));
		return deelnemer;
	}

	private static Duration parseDuration(String duration) {
		duration = "PT" + duration.replace(":", "M") + "0S";
		return Duration.parse(duration);
	}

}
