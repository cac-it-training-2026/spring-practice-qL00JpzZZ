package jp.co.sss.practice.p06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruits_area")
public class FruitsArea {
	/**
	 * @return fruitId
	 */
	public Integer getFruitId() {
		return fruitId;
	}

	/**
	 * @param fruitId セットする fruitId
	 */
	public void setFruitId(Integer fruitId) {
		this.fruitId = fruitId;
	}

	/**
	 * @return areaId
	 */

	/**
	 * @return fruitName
	 */
	public String getFruitName() {
		return fruitName;
	}

	/**
	 * @param fruitName セットする fruitName
	 */
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_items_gen")
	@SequenceGenerator(name = "seq_items_gen", sequenceName = "seq_area", allocationSize = 1)
	private Integer fruitId;
	@ManyToOne
	@JoinColumn(name = "area_id", referencedColumnName = "areaId")
	private Area areaId;

	/**
	 * @return areaId
	 */
	public Area getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId セットする areaId
	 */
	public void setAreaId(Area areaId) {
		this.areaId = areaId;
	}

	@Column
	private String fruitName;

}
