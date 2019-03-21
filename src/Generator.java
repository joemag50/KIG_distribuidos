import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Generator
{
	public int Vmax, Vmin;
	public double Wmax, Wmin;
	public int Items;
	public String[] categories = {"Liquid", "Flamable", "Poison", "Electrical"};
	ArrayList<Integer> Values;
	ArrayList<Integer> Weights;
	ArrayList<String> Categories;
	
	double W, alfa;

	public Generator(int items, int vmax, int vmin, double wmax, double wmin, double alfa)
	{
		Items = items;
		Vmax = vmax;
		Vmin = vmin;
		Wmax = wmax;
		Wmin = wmin;
		this.alfa = alfa;
		GenerateFiles();
	}
	
	public void GenerateFiles()
	{
		Random r = new Random();
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
		
		this.W = ((Wmax + Wmin) / (double) 2) * (double) this.Items * this.alfa;
	}
	
	public String GetRandomCategory()
	{
		int i = ThreadLocalRandom.current().nextInt(0, categories.length);
		return this.categories[i];
	}
}
