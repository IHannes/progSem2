package blatt4.products;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Monitor extends AbstractProduct implements Shippable{
	private double weight;
	private double height;
	private double width;
	private double length;
	
	public Monitor(double weight, double height, double width, double length) {
		this.height = height;
		this.length = length;
		this.weight = weight;
		this.width = width;
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
		if(!(o instanceof Computer)) {
			return 1;
		}
		Computer b = (Computer) o;
		if(b.getPrice().getGrossPrice() == this.getPrice().getGrossPrice()) {
			return 0;
		}
		else return (int) ((int) b.getPrice().getGrossPrice() - this.getPrice().getGrossPrice());
	}


	public void unitSold(){
		try {
		Path path = Files.createTempFile("monitor", ".txt");
		if(Files.exists(path)) {
			try {
			    Files.write(Paths.get("monitor.txt"), "|".getBytes(), StandardOpenOption.APPEND);
			}catch (IOException e) {
			    System.out.println(e);
			}
		}else {
			PrintWriter writer = new PrintWriter("monitor.txt", "UTF-8");
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
			Path path = Files.createTempFile("monitor", ".txt");
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
