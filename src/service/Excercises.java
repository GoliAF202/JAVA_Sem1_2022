package service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
  	Semināra Nr.1 uzdevumi, lai praktizētu JAVA
  	@author Vitaly
 */

public class Excercises {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		
		System.out.println("Sveiki!");
		float cena = 9.9976f;
		System.out.printf("Cena ir %.2f. Apsveicu!\n", cena);
		
		String[] names = { "Elena", "Thomas", "Hamilton", "Suzie", "Phil", "Matt",
				"Alex", "Emma", "John", "James", "Jane", "Emily", "Daniel", "Neda", "Aaron",
				"Kate" };
		
		int[] times = { 341, 273, 278, 329, 445, 402, 388, 275, 243, 334, 412, 393,
				299, 343, 317, 265 };
		
		/*for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		
		for(String temp : names) {
			System.out.println(temp);
		}
		
		System.out.println(Arrays.toString(names));*/
		if (names.length == times.length){
			for(int i = 0; i < names.length; i++) {
				System.out.println("[" + names[i] + ", " + times[i] + "]");
			}
		}
		else {
			System.out.println("Abi masīvi nav vienādi");
		}
		
		//double result = positionCalc(-9.81, 10, 100, 30);
		System.out.println("Bumbiņas pozīcija būs: " + positionCalc(9.81, 10, 100, 30) + "m");
		System.out.println("Faktorials no " + "5 = " + factorialForLoop(5));
		System.out.println("Faktorials no " + "5 = " + factorialRecursive(5));
		System.out.println(Arrays.toString(generateArray(8,1,10)));
		//System.out.println(getMean(generateArray(8,1,10)));
		System.out.println(Arrays.deepToString(generateMatrix(5)));
		System.out.println(Arrays.toString(coinFlip(1000))); 
		System.out.println(Arrays.toString(rollDice(1000)));
		System.out.println(Arrays.toString(roll2Dices()));
	}

	/**
	 * Funkcija, kas apreķina bumbiņas atrašanās vietu
	 * @param gravity
	 * @param initialVelocity
	 * @param initialPosition
	 * @param fallingTime
	 * @return double pozīciju
	 */
	public static double positionCalc(double gravity, double initialVelocity, double initialPosition, double fallingTime){
		// x(t) = 0.5 × a*t^2 + v_0*t + x_0
		//double result = 0.5 * gravity * Math.pow(fallingTime, 2) + initialVelocity * fallingTime + initialPosition;
		return 0.5 * gravity * Math.pow(fallingTime, 2) + initialVelocity * fallingTime + initialPosition;
	}
	
	/**
	 * Aprēķina faktorialu ar for ciklu
	 * @param N
	 * @return int apreķinātais faktoriāls
	 */
	public static int factorialForLoop(int N) {
		if(N > 0) {
			int result = 1;
			for(int i = 1; i < N + 1; i++) {
				result = i * result;
			}
			return result;
		}
		return 0;
	}
	
	/**
	 * Aprēķina faktorialu ar rekursiju
	 * @param N
	 * @return int apreķinātais faktoriāls
	 */
	public static int factorialRecursive(int N) {
		if (N>0) {
			if (N > 1) {
				int result = N * factorialRecursive(N-1);
				return result;
			}
			else {
				return 1;
			}
		}
		else {
			return 0;
		}
	}
	
	/**
	 * Funkcija izveido 1D masīvu ar ģenerētiem skaitļiem
	 * @param N
	 * @param lower​
	 * @param upper​
	 * @return double tipa masīvs ar ģeneretajiem skaitļiem
	 */
	public static double[] generateArray(int N, double lower​, double upper​) {
		//TODO pārbaudīt lower ir mazaks par upper
		if(N > 0) {
			Random rand = new Random();
			double[] result = new double[N];
			for(int i = 0; i < result.length; i++) {
				double genTemp = 0;
				if(lower​ < upper​) {
					// low up 
					genTemp = rand.nextDouble()*(upper​-lower​)+lower​;
				}
				else {
					genTemp = rand.nextDouble()*(lower​-upper​)+upper​;
				}
				result[i] = genTemp;
			}
			return result;
		}
		return null;
	}
	
	/**
	 * Funkcija izrēķina double 1D masīva vidēju vērtīu
	 * @param array
	 * @return double tipa mainigais ar vidēju vērtību
	 */
	public static double getMean(double[] array) {
		if(array != null)
		{
			double result = 0;
			for(int i = 0; i < array.length; i++) {
				result += array[i];
			}
			return (result / array.length);
		}
		return 0;
	}

	/**
	 * Noskaidro minimālo vērtību double 1D masīvā
	 * @param array
	 * @return minimālo double vērtību
	 */
	public static double getMin(double[] array) {
		if(array != null) {
			double min = Double.MAX_VALUE;
			for(int i = 0; i < array.length; i++) {
				if (array[i] < min) {
					min = array[i];
				}
			}
			return min;
		}
		return 0;
	}
	
	/**
	 * Noskaidro maksimālo vērtību double 1D masīvā
	 * @param array
	 * @return maksimālo double vērtību
	 */
	public static double getMax(double[] array) {
		if(array != null) {
			double max = Double.MIN_VALUE;
			for(int i = 0; i < array.length; i++) {
				if (array[i] > max) {
					max = array[i];
				}
			}
			return max;
		}
		return 0;
	}
	
	/**
	 * Sakarto double masīvu (Buble sort)
	 * @param array
	 * @return double masīvu
	 */
	public static double[] arraySort(double[] array) {
		if(array != null) {
			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array.length; j++) {
					if(array[i] > array[j]) {
						double temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
			return array;
		}
		return null;
	}

	/**
	 * Funkcija izveido 2D masīvu ar ģenerētiem skaitļiem
	 * @param N
	 * @return double tipa masīvs ar ģeneretajiem skaitļiem
	 */
	public static double[][] generateMatrix(int N){
		if(N > 0) {
			Random rand = new Random();
			double[][] result = new double[N][N];
			for(int i = 0; i < result.length; i++) {
				for (int j = 0; j < result.length; j++) { 
					result[i][j] = rand.nextDouble()*99 + 1;
				}
			}
			return result;
		}
		return (new double[0][0]);
	}
	
	/**
	 * MAtricas reizinājums
	 * @param matrix
	 * @param i
	 * @param j
	 * @return reizinājums double
	 */
	public static double getProduct(double[][] matrix, int i, int j) {
		if(matrix != null && i >= 0 && j >= 0) {
			if(i < matrix.length && j < matrix[0].length) {
				double result = 0;
				for (int j2 = 0; j2 < matrix.length; j2++) {
					for (int k = 0; k < matrix.length; k++) {
						result += matrix[i][j2]*matrix[k][j];
					}
				}
				return result;
			}
		}
		return 0;
	}
	
	/**
	 * ģēnere monetas mešanu
	 * @param N
	 * @return masīvs ar 3 šunam: 1 - cik reizes gerbonis, 2 - cik reizes skaitlis, 3 - atticība gerbonis/skaitlis
	 */
	public static double[] coinFlip(int N) {
		if (N > 0) {
			Random rand = new Random();
			double[] result = new double[3];
			for (int i = 0; i < N; i++) {
				int genTemp = rand.nextInt(2);
				result[genTemp]++;
			}
			result[2] = result[0]/result[1];
			return result;
		}
		return new double[0];
	}
	
	/**
	 * 
	 * @param N
	 * @return
	 */
	public static int[] rollDice(int N) {
		if (N > 0) {
			Random rand = new Random();
			int[] result = new int[6];
			for (int i = 0; i < N; i++) {
				int genTemp = rand.nextInt(1,7);
				result[genTemp-1]++;
			}
			return result;
		}
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	public static int[] roll2Dices() {
	
		Random rand = new Random();
		int genTemp1;
		int genTemp2;
		int[] temp = new int[1];;
		do {
			genTemp1 = rand.nextInt(1,7);
			genTemp2 = rand.nextInt(1,7);
			temp[0]++;
		}
		while (genTemp1 == 6 && genTemp2 == 6);
		
		return temp;

	}
}


