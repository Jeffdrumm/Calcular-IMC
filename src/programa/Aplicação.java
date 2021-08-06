package programa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;
import entidade.Imc;

public class Aplicação {

	public static void main(String[] args) throws IOException {

		Imc imc = new Imc();
		String dir = "C:\\Users\\jefes\\eclipse-workspace\\prova-consiste\\source\\dataset.CSV";

		File file = new File(dir);
		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		String path = "C:\\Users\\jefes\\eclipse-workspace\\prova-consiste\\output\\dadosIMC.txt";
		File fileOutput = new File(path);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput));
		while (scanner.hasNextLine()) {
			String text = scanner.nextLine();
			String[] data = text.split(";");

			if (data.length == 4) {

				String nome = data[0].trim();
				String sobrenome = data[1].trim().replaceAll("\\s{2,}", " ");

				float peso = Float.parseFloat(data[2].replace(",", "."));
				float altura = Float.parseFloat(data[3].replace(",", "."));

				float indiceMC = imc.calculoIMC(altura, peso);
				DecimalFormat df = new DecimalFormat("0.##");

				String valor;
				valor = df.format(indiceMC);

				String nomeCompleto = nome + " " + sobrenome;
				nomeCompleto = nomeCompleto.toUpperCase();
				String dadoFinal = nomeCompleto + " " + valor;
				System.out.println(dadoFinal);

				writer.write(dadoFinal);
				writer.newLine();

			} else {
				String nome = data[0].trim();
				String sobrenome = data[1].trim().replaceAll("\\s{2,}", " ");
				String nomeCompleto = nome + " " + sobrenome;
				System.out.println(nomeCompleto.toUpperCase() + " SEM DADOS DE IMC");
				String dadoFinal = nomeCompleto.toUpperCase() + " SEM DADOS DE IMC";
				writer.write(dadoFinal);
				writer.newLine();
			}
		}
		writer.flush();
		writer.close();
		scanner.close();
	}

}
