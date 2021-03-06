import java.util.Stack;


public class StackMin {

	/**
	 * @author Wise
	 *   
	 * The meaning of the problem:
	 *На вхід програми подається набір операцій зі стеком.
	 *Кожна операція полягає у додаванні або видаленні елемента зі стеку.
	 *Після виконання кожної операції обчисліть найменше з усіх чисел, що знаходяться у стеці.
	 *Складіть усі отримані числа та отримайте відповідь.
	 *Якщо після деякої операції стек виявився пустим, то нічого не додавайте до відповіді.
	 *Якщо виконати видалення неможливо, оскільки стек порожній, то не виконуйте його.
	 *    
	 *    Технічні умови:
	 *   	Вхідні дані:
	 *   		Вхідні дані генеруються у самій програмі. На вхід подаються параметри для генерації вхідної послідовності.
	 *   	Перше число містить кількість операцій n (1 ≤ n ≤ 10^6) зі стеком.
	 *    Далі йдуть чотири невід'ємних цілих числа a, b, c, x0, що не перевищують 10000.
	 *    Для отримання вхідних даних згенеруємо послідовність x.
	 *    Перше число у генерованій послідовності x1.
	 *     Кожне наступне число обчислюється з попереднього за формулою:
	 *     xi = (a·x2i-1 + b·xi-1 + c) / 100 mod 106, де '/' - операція цілочисельного ділення, а 'mod' - залишок при діленні.
	 *     Якщо xi mod 5 < 2, то необхідно видалити число зі стеку. Інакше потрібно додати до стеку число xi.
	 *      Вихідні дані:
	 *    		 Виведіть результуючу суму.
	 *    
	 *    @param 2 0 0 1 81
	 *    @return 0
	 *    
	 *    @param 3 1 1 1 13
	 *    @return 0
	 *    
	 *    @link http://www.e-olimp.com/ua/problems/693
	 */
	
	
	public static int searchSum (int n ,int a, int b, int c, int x0)
	{
		Integer sum = 0;
		int xi = 0;
		int min = 0;
		
		Stack st = new Stack<Integer>();
		for (int i = 0; i < n; i++) {
			xi = ((a*x0*x0+b*x0+c)/100)%1000000;
			//System.out.println(xi);
			if (xi%5<2) {
				if(!st.empty())
					st.pop();
			}else 
			{
				st.push(xi);
			}
			if(!st.empty())
			{
				for (int j = 0; j < st.size(); j++) {
					if (min<(Integer)st.get(i)) {
						min=(Integer)st.get(i);
						sum+=min;
					}
				}
				
			}
			x0=xi;
		}
	   
		return sum;
	}
	
	
	public static void main(String[] args) {
		int one = searchSum(2,0,0,1,81);
		System.out.println(one);
		
		int two = searchSum(3,1,1,1,13);
		System.out.println(two);
	}

}
