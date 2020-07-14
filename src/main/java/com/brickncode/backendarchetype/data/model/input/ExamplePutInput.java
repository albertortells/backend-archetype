package com.brickncode.backendarchetype.data.model.input;

import java.io.Serializable;
import java.util.Date;

public class ExamplePutInput implements Serializable {

	private static final long serialVersionUID = -2577455697702911598L;

	private Integer id;
	private String name;
	private String surname;
	private String password;
	private String strBirthday;
	private Date birthday;

	public ExamplePutInput() { }

	public ExamplePutInput(Integer id, String name, String surname, String password, String strBirthday) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.strBirthday = strBirthday;
	}

	public ExamplePutInput(Integer id, String name, String surname, String password, Date birthday) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.birthday = birthday;
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getSurname() { return surname; }

	public void setSurname(String surname) { this.surname = surname; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getStrBirthday() { return strBirthday; }

	public void setStrBirthday(String strBirthday) { this.strBirthday = strBirthday; }

	public Date getBirthday() { return birthday; }

	public void setBirthday(Date birthday) { this.birthday = birthday; }
}
