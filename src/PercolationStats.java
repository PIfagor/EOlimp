import java.util.Random;

import lib.princeton.Stopwatch;

public class PercolationStats { 
	
	private double [] experements;
	private Percolation perc;
	private int countExpr;
	private Random rand;
	
public PercolationStats(int N, int T) {
	// проведемо T окремих експериментів в N на N матриці
	countExpr=T;	
	experements = new double [countExpr];
	rand = new Random();
	
	for (int i = 0; i < countExpr; i++) {
		perc = new Percolation(N);
		while (!perc.percolates()){
			perc.open(rand.nextInt(N),rand.nextInt(N));
			}
		experements[i] = (double)perc.getOpenedCount()/(N*N);
		}
}
public double mean() {
	// рахує середнє
	double total = 0;
	for (int i = 0; i < experements.length; i++) {
		total += experements[i];
	}
	return (double)total/(double)countExpr;
}
public double stddev() {
	
	double total = 0;
	double mu = mean();
	for (int i = 0; i < experements.length; i++) {
		total += Math.pow(experements[i]-mu,2);
	}
	return Math.sqrt((double)total/(countExpr-1));
	
}
public int getCountExpr() {
	return countExpr;
}
public static void main(String[] args) {
	// запускаємо експерименти і рахуємо відповідні значення середнє, відхилення, інтервал довіри, та виводимо на екран
	Stopwatch stopwatch = new Stopwatch();
	PercolationStats ps1 = new PercolationStats(200, 9999);
	System.out.println("mean ="+ps1.mean());
	System.out.println("stddev  ="+ps1.stddev ());
	double first = ps1.mean();
	double second = 1.96*ps1.stddev()/Math.sqrt(ps1.getCountExpr());
	System.out.println("95% confidence interval  ["+(first-second)+":"+(first+second)+"]");
	
	double time = stopwatch.elapsedTime();
	System.out.println("Продений час "+time);
}
}