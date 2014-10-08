/**
 * 
 * @author Wise
 * https://gist.github.com/PIfagor/d9e64f02f23a6f8b893c
 */


public class CutMergeSort {
	private static void merge(int[] a, int[] aux, int lo, int mid, int hi,
			int[] b, int[] aux2) {

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

	private static void sort(int[] a, int[] aux, int lo, int hi, int[] b,
			int[] aux2) {
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

	public static void sort(int[] a, int b[]) {
		int[] aux = new int[a.length];
		int[] aux2 = new int[b.length];
		sort(a, aux, 0, a.length - 1, b, aux2);
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1,8,2,1,4,7,3,2,3,6 };
		int[] arr2 = new int[] { 8,9,10,11,2,2,11,23,3,7};
		sort(arr, arr2);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			System.out.println("\t" + arr2[i]);
		}
		
	}

}
