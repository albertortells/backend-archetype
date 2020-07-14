package com.brickncode.backendarchetype.data.model.input;

import java.io.Serializable;
import java.util.Date;

public class ExamplePostInput implements Serializable {

	private static final long serialVersionUID = -7211613265925173963L;

	private String name;
	private String surname;
	private String mail;
	private String password;
	private String strBirthday;
	private Date birthday;

	public ExamplePostInput() { }

	public ExamplePostInput(String name, String surname, String mail, String password, String strBirthday) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.strBirthday = strBirthday;
	}

	public ExamplePostInput(String name, String surname, String mail, String password, Date birthday) {
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.password = password;
		this.birthday = birthday;
	}

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getSurname() { return surname; }

	public void setSurname(String surname) { this.surname = surname; }

	public String getMail() { return mail; }

	public void setMail(String mail) { this.mail = mail; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getStrBirthday() { return strBirthday; }

	public void setStrBirthday(String strBirthday) { this.strBirthday = strBirthday; }

	public Date getBirthday() { return birthday; }

	public void setBirthday(Date birthday) { this.birthday = birthday; }

}
