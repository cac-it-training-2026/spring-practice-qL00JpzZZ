package jp.co.sss.practice.p04.q01.form;

public class BmiForm {
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return height
	 */
	public Double getHeight() {
		return height;
	}

	/**
	 * @param height セットする height
	 */
	public void setHeight(Double height) {
		this.height = height;
	}

	/**
	 * @return weight
	 */
	public Double getWeight() {
		return weight;
	}

	/**
	 * @param weight セットする weight
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}

	/**
	 * @return bmi
	 */
	public Double getBmi() {
		return bmi;
	}

	/**
	 * @param bmi セットする bmi
	 */
	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	/**
	 * @return nameString
	 */

	String name;
	Double height;
	Double weight;
	Double bmi;

}
