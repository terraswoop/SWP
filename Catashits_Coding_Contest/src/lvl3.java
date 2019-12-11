import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class lvl3 {
	public static void flat(ArrayList<String[]> wrld) {
		ArrayList<String> coordinates = new ArrayList<>();
		ArrayList<Integer> sizes = new ArrayList<>();
		int greatestsize = 1;
		for (int i = 0; i < wrld.size(); i++) {
			for (int j = 0; j < wrld.size(); j++) {
				int actsize = 1;
				int height = Integer.parseInt(wrld.get(i)[j]);
				boolean square = true;
				int nix = 0;
				while (j + 1 + nix <= wrld.get(i).length - 1 && Integer.parseInt(wrld.get(i)[j]) == Integer.parseInt(wrld.get(i)[j + 1 + nix])) {
					actsize++;
					nix++;
				}
				if (greatestsize <= actsize) {
					for (int k = i; k < actsize; k++) {
						for (int h = j; h < actsize; h++) {
							if (k < wrld.size() && h < wrld.size()) {
								if (Integer.parseInt(wrld.get(k)[h]) != height) {
									square = false;
								}
							}
						}
					}
				} else {
					square = false;
				}
				if (square) {
					String s = i + " " + j;
					coordinates.add(s);
					sizes.add(actsize);
					greatestsize = actsize;
				}
			}
		}
		biggest(coordinates, sizes);
	}

	public static void biggest(ArrayList<String> coordinates, ArrayList<Integer> sizes) {
		
		int biggestsize = 0;
		for (int i = 0; i < sizes.size(); i++) {
			if (biggestsize < sizes.get(i)) {
				biggestsize = sizes.get(i);
			}
		}
		for (int i = 0; i < sizes.size(); i++) {
			if (sizes.get(i) < biggestsize) {
				coordinates.remove(i);
				sizes.remove(i);
				i--;
			}
			
		}
		System.out.println(biggestsize);
		for (int i = 0; i < coordinates.size(); i++) {
			System.out.println(coordinates.get(i));
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<String[]> wrld = new ArrayList<>();
		File file = new File("field.txt");
		Scanner s = new Scanner(file);
		String[] fd;
		while (s.hasNextLine()) {
			String z = s.nextLine();
			fd = z.split(" ");
			wrld.add(fd);
		}
		flat(wrld);
		s.close();
	}

}
