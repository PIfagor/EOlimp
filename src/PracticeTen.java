
public class PracticeTen {

	public static int max (int o, int t) {return o>t?o:t;};
	public static int min (int o, int t) {return o<t?o:t;};
	
	public static int searchFather(int one, int two)
	{
		while(true)
		{
			if (one == 1 ) return 1;
			if (two == 1 ) return 1;
			if (one==two) return one;
			if (one/2==two/2) return one/2;
			if (one>two)
				one/=2;
			else two/=2;
			
		}
	}
	
	public static void main(String[] args) {
		System.out.println(searchFather(12, 15));
		System.out.println(searchFather(233016, 233008));
	}

}
