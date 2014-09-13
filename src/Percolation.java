import lib.lection.QuickUnionUF;

public class Percolation { 

private boolean [] grid;	
private int openedCount;	
private int sizeMarix;
private QuickUnionUF uf;
public Percolation(int N) {
// створюємо матрицю N-на-N, з усіма заблокованими об’єктами 
	openedCount = 0;
	sizeMarix = N;
	grid = new boolean [N*N];
	for (int i = 0; i < grid.length; i++) {
		grid[i] = false;
	}
	uf = new QuickUnionUF(N*N+2);
	for (int i = 0; i < N; i++) {
		uf.union(0,i+1);
		uf.union(N*N-i, N*N+1);
	}
}
public int getOpenedCount(){
	//рахуємо і повертаємо кількість відкритих комірок
	return openedCount;
}
public void open(int i, int j) {
    // відкрити об’єкт (row i, column j) якщо він ще не відкритий 
	if (grid[sizeMarix*i+j]==false) {
	if (sizeMarix*(i-1)+j>0)			{if (grid[sizeMarix*(i-1)+j]==true) 	{uf.union(1+sizeMarix*i+j, 1+sizeMarix*(i-1)+j);};};
	if (sizeMarix*(i+1)+j<grid.length)	{if (grid[sizeMarix*(i+1)+j]==true) 	{uf.union(1+sizeMarix*i+j, 1+sizeMarix*(i+1)+j);};};
	if (sizeMarix*i+j+1<grid.length)	{if (grid[sizeMarix*i+j+1]==true) 		{uf.union(1+sizeMarix*i+j, 1+sizeMarix*i+j+1);};};
	if (sizeMarix*i+j-1>0) 				{if (grid[sizeMarix*i+j-1]==true) 		{uf.union(1+sizeMarix*i+j, 1+sizeMarix*i+j-1);};};
		
	openedCount++;
	grid[sizeMarix*i+j]=true;
	} 
		
	
	
	
}
public boolean isOpened(int i, int j) {
	// чи відкитий об’єкт (row i, column j)? 
	return grid[sizeMarix*i+j];
}
public boolean percolates() {
	// чи протікає система? 
	return uf.connected(0, sizeMarix*sizeMarix+1) ;
}
}
