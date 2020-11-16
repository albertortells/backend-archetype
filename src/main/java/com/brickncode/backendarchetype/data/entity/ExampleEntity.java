package com.brickncode.backendarchetype.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Entity
//If you want yo can put the schema variable to the Table Annotation like this:
@Table(name = "example", schema = "test")
//@Table(name = "example")
public class ExampleEntity extends AuditableEntity implements Serializable {

	private static final long serialVersionUID = -524244669132619550L;

	@Id
	@Column(name = "co_id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "co_mail", unique = true, nullable = false, length = 40)
	private String mail;

	@Column(name = "co_password", nullable = false, length = 60)
	private String password;

	@Column(name = "co_name", nullable = false, length = 50)
	private String name;

	@Column(name = "co_surname", nullable = false, length = 50)
	private String surname;

	@Column(name = "co_birthday", nullable = false)
	private Date birthday;

	public ExampleEntity() { }

	public ExampleEntity(Date createdDate, Date lastModifiedDate, String createdBy, String lastModifiedBy) {
		super(createdDate, lastModifiedDate, createdBy, lastModifiedBy);
	}

	public ExampleEntity(String mail, String password, String name, String surname, Date birthday) {
		this.mail = mail;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.birthday = birthday;
	}

	public ExampleEntity(Date createdDate, Date lastModifiedDate, String createdBy, String lastModifiedBy, String mail, String password, String name, String surname, Date birthday) {
		super(createdDate, lastModifiedDate, createdBy, lastModifiedBy);
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
