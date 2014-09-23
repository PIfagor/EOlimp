import java.lang.reflect.Array;
import java.util.Arrays;


public class Ball {

	/**
	 * @author Wise
	 *   
	 * The meaning of the problem:
	 *  У продавця повітряних кульок є N кульок.
	 *  Кожна з них має деякий колір.
	 *   Але зовсім недавно Три Товстуни видали наказ, який дозволяє торгувати кульками тільки якогось одного кольору.
	 *    Щоб не порушувати закон, але при цьому і не втратити прибуток, продавець вирішив перефарбувати деякі із своїх кульок.
	 *    Напишіть програму для визначення мінімальної кількості перефарбувань.
	 *    
	 *    Технічні умови:
	 *   	Вхідні дані:
	 *   		 В першому рядку вхідного файлу задано кількість кульок N (1 ≤ N ≤ 100000).
	 *    		 Другий рядок містить N цілих чисел, в межах від 1 до 9,
	 *    		  що визначає колір кульок (1 - синій, 2 - зелений, 3 - голубий, 4 - червоний, 5 - рожевий, 6 - жовтий, 7 - сірий, 8 - чорний, 9 - білий).
	 *      Вихідні дані:
	 *    		  В єдиному рядку вихідного файлу виведіть мінімальну кількість кульок, які необхідно перефарбувати, щоб всі кульки були одного кольору.
	 *    @param 4
	 *    @param 3 1 2 1
	 *    @return 2
	 *    
	 *    @link http://www.e-olimp.com/ua/problems/113
	 */
	
	
	public static int searchMin (int N, int [] colors)
	{
		assert colors.length != N;
		int [] col = new int [9]; 
		for (int i = 0; i < colors.length; i++) {
			col[colors[i]-1]++;
		}
		Arrays.sort(col);
		
		return N-col[col.length-1];
	}
	
	public static void main(String[] args) {
		int [] first =  new int [] {3,1,2,1,3,3};
		int one =searchMin(first.length, first);
		System.out.println(one);

	}

}
