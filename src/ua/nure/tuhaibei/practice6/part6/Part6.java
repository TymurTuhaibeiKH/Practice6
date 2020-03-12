package ua.nure.tuhaibei.practice6.part6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;


public class Part6 {

	private static List<String> commands;

	public static void main(String[] args) throws FileNotFoundException {
		init();
		if (commands.contains(args[0])) {
			String txtFromFile = readFromFile(args[1]);
			txtFromFile = txtFromFile.replaceAll("(\\r|\\n)", " ");
			switch (args[3]) {
			case "frequency":
				Part61.frequency(txtFromFile);
				break;
			case "length":
				Part62.length(txtFromFile);
				break;
			case "duplicates":
				Part63.duplicates(txtFromFile);
				break;
			default:
				break;
			}
		}
	}

	private static void init() {
		commands = new ArrayList<>();
		commands.add("-i");
		commands.add("--input");
		commands.add("-t");
		commands.add("--task");
	}

	public static String readFromFile(String fileName) { 
		StringJoiner sb = new StringJoiner(System.lineSeparator());
		try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(new File(fileName)),
				"Cp1251")) {
			BufferedReader br = new BufferedReader(inputStreamReader);
			String line;
			while ((line = br.readLine()) != null) {
				sb.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return sb.toString().replaceAll("(?m)^\\s", "");
	}

}
