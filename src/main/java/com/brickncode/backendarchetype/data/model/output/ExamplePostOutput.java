package com.brickncode.backendarchetype.data.model.output;

import java.io.Serializable;

public class ExamplePostOutput implements Serializable {

	private static final long serialVersionUID = -4713541648031361609L;

	private Integer id;
	private String name;
	private String mail;

	public ExamplePostOutput() { }

	public ExamplePostOutput(Integer id, String name, String mail) {
		this.id = id;
		this.name = name;
		this.mail = mail;
	}

	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public String getMail() { return mail; }

	public void setMail(String mail) { this.mail = mail; }
}
