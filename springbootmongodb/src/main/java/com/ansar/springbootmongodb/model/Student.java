package com.ansar.springbootmongodb.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "student")
public class Student {
	@Id
	private String id;
	@NotNull(message = "Name can not be null")
	private String	name;
	@NotNull(message = "city can not be null")
	private String city;
	@NotNull(message = "state can not be null")
	private String state;
	@NotNull(message = "collegeName can not be null")
	private String collegeName;
	@NotNull(message = "gender can not be null")
	private String geder;
	private Date created;
	private Date updated;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getGeder() {
		return geder;
	}
	public void setGeder(String geder) {
		this.geder = geder;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", state=" + state + ", collegeName="
				+ collegeName + ", geder=" + geder + ", created=" + created + ", updated=" + updated + "]";
	}
	
	
	

}
