package org.hxn.app.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "area")
public class Area {
	/**
	 * 主键ID
	 */
	@Id
	private int id;

	/**
	 * 行政区划代码
	 */
	@Column(name = "code", length = 40, nullable = false)
	private String code;

	/**
	 * 省份
	 */
	@Column(name = "province", length = 40)
	private String province;

	/**
	 * 城市
	 */
	@Column(name = "city", length = 40)
	private String city;

	/**
	 * 区划
	 */
	@Column(name = "district", length = 40)
	private String district;

	@ManyToOne
	@JoinColumn(name = "parent")
	private Area area;

	@OneToMany(mappedBy = "area", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	private Set<Area> areas;

	/**
	 * 每个区域有多少居民,不映射到数据库，由统计计算得出，默认值是零
	 */
	@Transient
	private Integer cityzenCount = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public Set<Area> getAreas() {
		return areas;
	}

	public void setAreas(Set<Area> areas) {
		this.areas = areas;
	}

	public Integer getCityzenCount() {
		return cityzenCount;
	}

	public void setCityzenCount(Integer cityzenCount) {
		this.cityzenCount = cityzenCount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Area [id=").append(id).append(", code=").append(code).append(", province=").append(province)
				.append(", city=").append(city).append(", district=").append(district).append(", area=").append("")
				.append(", areas=").append("").append("]");
		return builder.toString();
	}

}
