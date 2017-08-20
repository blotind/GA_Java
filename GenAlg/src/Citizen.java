import java.util.Arrays;

import utils.Utils;

public class Citizen {
	int[] dataArr;
	int Strength;

	/**
	 * Blank Constructor
	 */
	public Citizen() {

	}

	/**
	 * This constructor generates a brand new randomised citizen
	 * 
	 * @param dataLength
	 *            - Length of the sentence
	 */
	public Citizen(int dataLength) {
		dataArr = new int[dataLength];
		for (int i = 0; i < dataLength; i++) {
			dataArr[i] = Utils.RandomNumberGen();
		}
	}

	/**
	 * Constructor to combine two Citizens
	 * 
	 * @param a
	 * @param b
	 */
	public Citizen(Citizen a, Citizen b) {
		int arrSize = a.dataArr.length;
		for (int i = 0; i < arrSize; i++) {
			if (i < arrSize / 2) {
				dataArr[i] = a.dataArr[i];
			} else {
				dataArr[i] = b.dataArr[i];
			}
		}
	}

	public void setStrength(int iStrength) {
		Strength = iStrength;
	}

	public int getStrength() {
		return Strength;
	}

	@Override
	public String toString() {
		return "Citizen [dataArr=" + Arrays.toString(dataArr) + ", Strength=" + Strength + "]";
	}

}
