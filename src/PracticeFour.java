import java.util.Arrays;


public class PracticeFour {

	/**
	 * @param args
	 * 
	 * @author Wise
	 * 
	 */
	
	/**
	 * https://gist.github.com/9fe805b06ade833d2984.git
	 */
	public static int permutation(int []arr)
	{
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=i+1)
				return arr[i]-1;
		}
		return 0;
	}

	/**
	 * https://gist.github.com/3beb5c49e1df52b8471c.git
	 */
	public static int lostCard(int []arr)
	{
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=i+1)
				return i+1;
		}
		return arr.length+1;
	}
	
	public static int sortByGrowth(int []arr,int a,int b)
	{
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>a&&arr[i]<b)
				ans++;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		
		int [] a = new int [] {4,2,1};
		System.out.println(permutation(a));

		int [] b = new int [] {1,2,3,4,5,8,7};
		System.out.println(lostCard(b));
		
		int [] c = new int [] {189,191,169,190,192,191};
		System.out.println(sortByGrowth(c,165,170));
		
		
		
		
		
		
	}

}
