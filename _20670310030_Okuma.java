package otomata_odevi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class _20670310030_Okuma {
	String initialState;

	void fun() {
	

			String[] State;
			String[] ins;
			String[] outs;
			_20670310030_FTS_Makinasi FST = new _20670310030_FTS_Makinasi();

			String fileName = "FST.txt";

			try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
				String line;
				while ((line = br.readLine()) != null) {
					if (line.startsWith("Q")) {
						State = line.split("\\{")[1].split("}")[0].split(",");
						for (String in : State) {
							FST.durumler.add(in.trim());
						}
					} else if (line.startsWith("Î£")) {
						String input[] = line.split("\\{")[1].split("}")[0].split(",");
						for (String in : input) {
							FST.giris.add(in.trim());
						}

					} else if (line.startsWith("Î“")) {
						outs = line.split("\\{")[1].split("}")[0].split(",");

					} else if (line.startsWith("q0")) {
						initialState = line.split("=")[1].trim();
					} else if (line.contains("(")) {
						FST.islem(line);

					}

				}
				System.out.println("FST.txt dosyası okundu.");

			}

			catch (IOException e) {
				e.printStackTrace();
			}



		}
		public  void okumak(String str) {

			String initial = initialState;
			StringBuilder cikis = new StringBuilder();
			StringBuilder siraState = new StringBuilder();

			for (int i = 0; i < str.length(); i++) {
			    char symbol = str.charAt(i);
			    String inputStr = String.valueOf(symbol);
			

				if (_20670310030_FTS_Makinasi.FST.containsKey(initial)
						&& _20670310030_FTS_Makinasi.FST.get(initial).containsKey(inputStr)) {
					String[][] transition = _20670310030_FTS_Makinasi.FST.get(initial).get(inputStr);

					initial = transition[0][0];
					cikis.append(transition[0][1]);
					siraState.append(initial).append(", ");
				}
			}

			if (siraState.length() > 0) {
				siraState.setLength(siraState.length() - 2);
			}

			System.out.println("Durumların sırası:" + initialState + "," + siraState.toString().replaceAll("\\s+", ""));
			System.out.println("Çıktı:" + cikis.toString());		
		}


	}