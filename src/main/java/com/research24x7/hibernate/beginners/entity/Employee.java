
package com.research24x7.hibernate.beginners.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity (name =  "Employee")
@Table (name = "employee")
public class Employee {


	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="emp_id", nullable=false, unique=true)
	private int id;
	
	@Column(name="emp_name", length=28, nullable=false)
	private String name;
	
	@Column(name="emp_last_name", length=28, nullable=false)
	private String last_name;

	@Column(name="emp_dni", length=28, nullable=false)
	private String dni;

	@Column(name="emp_email", length=28, nullable=false)
	private String email;

	@Column(name="emp_mobile", length=28, nullable=false)
	private String mobile;

    public Employee() {

			super ();
		}

		public Employee(String name, String last_name, String dni, String email, String mobile) {
			this.name = name;
			this.last_name = last_name;
			this.dni = dni;
			this.email = email;
			this.mobile = mobile;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getMobile() {
			return mobile;
		}

		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
}
