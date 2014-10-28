public class PhoneList {

	/**
	 * 
	 * @author Wise Список телефонних номерів За заданим списком телефонних
	 *         номерів визначіть, чи є він сумісним у тому сенсі, що жоден номер
	 *         не є префіксом іншого. Нехай, наприклад, телефонний каталог
	 *         містить наступні номери: Екстрена служба 911 Аліса 97 625 999 Боб
	 *         91 12 54 26 У цьому випадку не представляється можливим
	 *         зателефонувати Бобу, тому що після набору трьох цифр телефону
	 *         Боба Ви відразу ж потрапите в Екстрену службу. Наведений список є
	 *         несумісним.
	 * 
	 *         Технічні умови: Вхідні дані Перший рядок містить кілбкість тестів
	 *         t (1 ≤ t ≤ 40). Кожний тест починається рядком, що містить
	 *         кілбкість телефонних номерів n (1 ≤ n ≤ 1000000). Кожний з
	 *         наступних n рядків містить один телефонний номер. Телефонний
	 *         номер містить не більше десяти цифр. Вихідні дані Для кожного
	 *         тесту вивести "YES", якщо список телефонних номерів є сумісним,
	 *         та "NO" інакше.
	 */

	private  class Node {
		char value;
		Node[] arr = new Node[10];

		public Node(char c) {
			value = c;
		};
	}

	private  Node root;
	private  boolean result;

	public PhoneList() 
	{
		root = new Node(' ');
		result = true;
	}
	
	public  void put(Node s, String num) {
		
		

		
		if (num.equals("")) {
			if (s.arr[0]==null)
				s.arr[0] = new  Node('!');
			else 
				result = false;
			return;
		}
		
		int t = 0;
		while (s.arr[t] != null) {
			if (s.arr[t].value == num.charAt(0))
				break;
			t++;
		}
		if (s.arr[t] == null)
			s.arr[t] = new Node(num.charAt(0));
		
		if (s.arr[0].value == '!') {
			result = false;
			return;
		}
		
		put(s.arr[t], num.substring(1, num.length()));

		return;
	}

	public  boolean addNumber(int num) {
		result = true;
		String sNum = Integer.toString(num);
		put(root, sNum);
		return result;
	}

	public static void main(String[] args) {
		
		
		PhoneList pl = new PhoneList();
		System.out.println(pl.addNumber(113));
		System.out.println(pl.addNumber(12340));
		System.out.println(pl.addNumber(123440));
		System.out.println(pl.addNumber(12345));
		System.out.println(pl.addNumber(98346));
		System.out.println(pl.addNumber(1131));
		System.out.println(pl.addNumber(12345));
		
		
		//System.out.println(addNumber(2225));
	

	}

}
