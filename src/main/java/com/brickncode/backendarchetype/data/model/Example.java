package com.brickncode.backendarchetype.data.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class Example implements Serializable {

	private static final long serialVersionUID = 8295366924924973565L;

	private Integer id;
	private String mail;
	private String password;
	private String name;
	private String surname;
	private Date birthday;

	public Example() { }

	public Example(Integer id, String mail, String password, String name, String surname, Date birthday) {
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getMail() { return mail; }

	public void setMail(String mail) { this.mail = mail; }

	public String getPassword() { return password; }

	public void setPassword(String password) { this.password = password; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getSurname() { return surname; }

	public void setSurname(String surname) { this.surname = surname; }

	public Date getBirthday() { return birthday; }

	public void setBirthday(Date birthday) { this.birthday = birthday; }

}
