import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator
{
	public String Sufix;
	public int N;
	public int Vmax, Vmin;
	public double Wmax, Wmin;
	public int Items;
	public String[] categories = {"Liquid", "Flamable", "Poison", "Electrical"};
	ArrayList<Integer> Values;
	ArrayList<Integer> Weights;
	ArrayList<String> Categories;
	
	double W, alfa;

	public Generator(String sufix, int n, int items, int vmax, int vmin, double wmax, double wmin, double alfa)
	{
		Sufix = sufix;
		N = n;
		Items = items;
		Vmax = vmax;
		Vmin = vmin;
		Wmax = wmax;
		Wmin = wmin;
		this.alfa = alfa;
	}
	
	public void GenerateFiles()
	{
		Random r = new Random();
		for (int i = 0; i < N; i++)
		{
			Values  = new ArrayList<Integer>();
			Weights = new ArrayList<Integer>();
			Categories = new ArrayList<String>();
			
			for (int j = 0; j < Items; j++)
			{
				int RandV = ThreadLocalRandom.current().nextInt(Vmin, Vmax + 1);
				int RandW = ThreadLocalRandom.current().nextInt((int) Wmin, (int) Wmax + 1);
				
				Values.add(RandV);
				Weights.add(RandW);
				Categories.add(GetRandomCategory());
			}
			
			File file = new File(String.format("/tmp/%s-%s.dat", this.Sufix, i)); 
			try {
				if (file.createNewFile())
				{
					System.out.println(String.format("File is created %s!", file.getName()));
				} else {
					System.out.println("File already exists.");
				}
				
				FileWriter writer = new FileWriter(file);
				this.W = ((Wmax + Wmin) / (double) 2) * (double) this.Items * this.alfa; 
				writer.write(String.format("%s %s\n", this.Items, (int) Math.floor(this.W)));
				for (int k = 0; k < Items; k++)
				{
					writer.write(String.format("%s %s %s %s\n", k, Values.get(k), Weights.get(k), Categories.get(k)));
				}
				writer.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public String GetRandomCategory()
	{
		int i = ThreadLocalRandom.current().nextInt(0, 4);
		return this.categories[i];
	}
}
