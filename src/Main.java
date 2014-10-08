import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

/**
	 * @author Wise
	 * @param args
	 */
	
	private static int inversion(String s)
	{
		int an = 0;
		for (int i = 0; i < s.length(); i++) 
			for (int j = i; j < s.length(); j++) 
				if (s.charAt(i)>s.charAt(j)) 
					an++;
		return an;
	}
	private static void merge(int[] a, int[] aux, int lo, int mid, int hi,
			String[] b, String[] aux2) {

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
			aux2[k] = b[k];
		}

		int i = lo, j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j];
				b[k] = aux2[j++];
			} else if (j > hi) {
				a[k] = aux[i];
				b[k] = aux2[i++];
			} else if (aux[j] < aux[i]) {
				a[k] = aux[j];
				b[k] = aux2[j++];
			} else {
				a[k] = aux[i];
				b[k] = aux2[i++];
			}
		}

	}

	private static void sort(int[] a, int[] aux, int lo, int hi, String[] b,
			String[] aux2) {
		if (hi <= lo)
			return;
		else {
			int mid = lo + (hi - lo) / 2;
			sort(a, aux, lo, mid, b, aux2);
			sort(a, aux, mid + 1, hi, b, aux2);
			if (a[mid + 1] > a[mid])
				return;
			merge(a, aux, lo, mid, hi, b, aux2);
		}
	}

	private static void sort(int[] a, String b[]) {
		int[] aux = new int[a.length];
		String[] aux2 = new String[b.length];
		sort(a, aux, 0, a.length - 1, b, aux2);
	}
	
	public static String [] sort(String [] arr)
	{
		int [] num = new int [arr.length];
		for (int i = 0; i < arr.length; i++) {
			num[i]=inversion(arr[i]);
		}
		sort(num,arr);
		return arr;
	}
	
	public static void main(String[] args) {
		
		 Scanner in = new Scanner(System.in);
		 PrintWriter out = new PrintWriter(System.out);

	      int total = in.nextInt();
			for (int i=0;i<total;++i ) {

				int n = in.nextInt();
				int m = in.nextInt();
				String [] data = new String [m];
				in.nextLine();
				for (int j=0;j<m;++j ) {
					if(in.hasNext())
					data[j]=in.nextLine();
				}
				sort(data);
				for (int j=0;j<m;++j ) {
					out.println(data[j]);
				}
				//if(i<total-1)
				out.println();
			}
           out.flush();
	}

}
