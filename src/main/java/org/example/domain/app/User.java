package org.example.domain.app;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="users")
public class User implements Serializable {

	/**
	 * Autogenerated serialVersionUID
	 */
	private static final long serialVersionUID = -1584285683481393526L;

	@Id
    @GeneratedValue
	private long id;
    
    @Column(nullable = false)
	private String username;
    
    @Column(nullable = false)
	private String password;

	public User(){
	}
	
	public User(String username){
		this.username=username;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

}
