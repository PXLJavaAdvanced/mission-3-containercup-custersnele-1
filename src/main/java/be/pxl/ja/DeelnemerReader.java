package be.pxl.ja;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DeelnemerReader {
	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("mm:ss");

	// TODO implement static method for reading file
	public static List<Deelnemer> readFile(Path path) {
		List<Deelnemer> result = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			reader.readLine();// ignore first line
			String line = null;
			while ((line = reader.readLine()) != null) {
				result.add(mapLineToDeelnemer(line));
			}
		} catch (IOException e) {
			System.out.println("Er is een fout opgetreden: " + e.getMessage());
		}
		return result;
	}

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
