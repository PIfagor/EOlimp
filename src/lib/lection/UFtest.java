 package lib.lection; 

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import lib.princeton.StdIn;
import lib.princeton.StdOut;

public class UFtest {
	private static final String testFile = "tinyUF.txt"; // 10 �'������ �� 11 �������
	private static final String testFile2 = "mediumUF.txt"; // 900 �'������ �� 625 �������
	private static final String testFile3 = "largeUF.txt"; //2 ����� �'������ �� 1 �. �����
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//	BufferedInputStream in = new BufferedInputStream(new FileInputStream(testFile3));
		//	System.setIn(in);
		
		int n = StdIn.readInt();
		//QuickFindUF uf = new QuickFindUF(n);
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(n);
		//QuickUnionUF uf = new QuickUnionUF(n);
		while (!StdIn.isEmpty()){
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!uf.connected(p,q)){
				uf.union(p,q);
				StdOut.println(p+" "+q);
			}else{
				StdOut.println(p+" "+q +" already connected");
			}
		}
		StdOut.println(uf);
	}

}
