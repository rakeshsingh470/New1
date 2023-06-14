package com.example.Employee.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;



@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
@Data
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	
	 @Column(name = "age", nullable = false)
	    private String age;

	    @Column(name = "gender", nullable = false)
	    private String gender;
	    
	    @Column(name = "address", nullable = false)
	    private String address;

	    @Column(name = "isActive", nullable = false)
	    private String isActive;
	    
	    
	    

		

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getIsActive() {
			return isActive;
		}

		public void setIsActive(String isActive) {
			this.isActive = isActive;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", address="
					+ address + ", isActive=" + isActive + "]";
		}
	    
	    
	    

}
