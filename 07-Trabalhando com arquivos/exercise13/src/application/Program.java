package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Product> productList = new ArrayList<>();
		
		System.out.println("Enter the file's path: ");
		String readPath = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(readPath))) {
				String line = br.readLine();
				while (line != null) {
					String [] itens = line.split(",");
					productList.add(new Product(itens[0], Double.parseDouble(itens[1]), Integer.parseInt(itens[2])));
					line = br.readLine();
			}
				
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		File path = new File(readPath);
		path = path.getParentFile();
		
		boolean success = new File(path + "\\out").mkdir();
		String newFile = path + "\\out\\summary.csv";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {
			for (Product product : productList) {
				bw.write(product.getName() + ',' + product.total());
				bw.newLine();
			}
		} catch (IOException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
		sc.close();

	}

}
