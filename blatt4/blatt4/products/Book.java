package blatt4.products;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Book extends AbstractProduct implements Shippable, Downloadable{
private double DownloadSize;
private double weight;
private double height;
private double width;
private double length;

	public Book(double DownloadSize, double weight, double height, double width, double length) {
		this.DownloadSize = DownloadSize;
		this.height = height;
		this.length = length;
		this.weight = weight;
		this.width = width;
	}
	@Override
	public double getDownloadSize() {
		return DownloadSize;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return height;
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return length;
	}

	@Override
	public int compareTo(Object o) {
		if(!(o instanceof Book)) {
			return 1;
		}
		Book b = (Book) o;
		if(b.getPrice().getGrossPrice() == this.getPrice().getGrossPrice()) {
			return 0;
		}
		else return (int) ((int) b.getPrice().getGrossPrice() - this.getPrice().getGrossPrice());
	}

	public void unitSold(){
		try {
		Path path = Files.createTempFile("book", ".txt");
		if(Files.exists(path)) {
			try {
			    Files.write(Paths.get("book.txt"), "|".getBytes(), StandardOpenOption.APPEND);
			}catch (IOException e) {
			    System.out.println(e);
			}
		}else {
			PrintWriter writer = new PrintWriter("book.txt", "UTF-8");
			writer.print("|");
			writer.close();
		}
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public double getUnitsSold() {
		try {
			Path path = Files.createTempFile("book", ".txt");
			if(Files.exists(path)) {
				File f = path.toFile();
				Scanner sc = new Scanner(f);
				StringBuilder strb = new StringBuilder("");
				while(sc.hasNextLine()) {
					strb.append(sc.nextLine());
				}
				return strb.length();
			}
			else {
				return 0;
			}
	}catch(Exception e) {
		System.out.println(e);
		return 0;
	}
}
	
}
