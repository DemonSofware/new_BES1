package model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name="persons")
public class PersonEntity {
	@Id
	@Column(name="email_id")
	String email;//the same as userName

	String name;
	String family;
	String password;
	boolean isActive;
	String hashCode;
	int timeZone;
	
	@OneToMany (mappedBy="personEntity")
	List<MattInfoEntity> mattInfo;

	@OneToMany (mappedBy="personEntity")
	List<GroupEntity> groups;

	public PersonEntity(mat.Person person){
		this.name = person.getName();
		this.family = person.getFamilyName();
		this.email = person.getEmail();
		this.password = person.getPassword();
		this.timeZone=person.getTimeZone();
		this.isActive = false;
/*		if(person.getGroups()!=null)
			for(mat.Group group: person.getGroups().values())
				groups.add(new GroupEntity(group, this));*/
	}
	
	public PersonEntity(){}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getHashCode() {
		return hashCode;
	}
	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
		
	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonEntity other = (PersonEntity) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	public int getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(int timeZone) {
		this.timeZone = timeZone;
	}

	public List<MattInfoEntity> getMattInfo() {
		return mattInfo;
	}

	public void setMattInfo(List<MattInfoEntity> mattInfo) {
		this.mattInfo = mattInfo;
	}

	public List<GroupEntity> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupEntity> groups) {
		this.groups = groups;
	}

}
