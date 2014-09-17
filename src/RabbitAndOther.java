
public class RabbitAndOther {

	/**
	 * @param args
	 * @author Wise
	 * @return 
	 */
	
	public int Rabbits (int n, int k)
	{
		int answer = 1;
		for (int i = 0; i < n; i++) {
			if(answer>k)
				answer-=k;
			answer*=2;
		}
		return answer;
	}
	
	public int Gardener (int n)
	{
		int answer = 1;
		for (int i = 1; i <= n; i++) {
				answer+=2*i;
		}
		return answer;
	} 
	
	public static void main(String[] args) {
		RabbitAndOther rao =new RabbitAndOther();
		System.out.println(rao.Rabbits(0, 10));
		System.out.println(rao.Rabbits(1, 10));
		System.out.println(rao.Rabbits(5, 10));
		System.out.println();
		System.out.println(rao.Gardener(3));
		
	}

}
