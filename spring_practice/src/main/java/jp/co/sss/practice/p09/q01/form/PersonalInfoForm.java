package jp.co.sss.practice.p09.q01.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PersonalInfoForm {
	@NotBlank
	@Pattern(regexp = "^[0-9]{3}-[0-9]{4}$")
	String postalCode;
	@NotBlank
	@Size(min = 3, max = 4)
	String prefName;
	@Min(18)
	@Max(120)
	Integer age;

	/**
	 * @return postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode セットする postalCode
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return prefName
	 */
	public String getPrefName() {
		return prefName;
	}

	/**
	 * @param prefName セットする prefName
	 */
	public void setPrefName(String prefName) {
		this.prefName = prefName;
	}

	/**
	 * @return age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age セットする age
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

}
