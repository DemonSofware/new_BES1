package model;

import java.util.List;

import javax.persistence.*;


import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="groups")
public class GroupEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="group_id")
	int id;
	
	@Column(name="group_name")
	String groupName;
	
	@OneToMany(targetEntity=ContactEntity.class, mappedBy = "groupEntity", cascade = CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	List<ContactEntity> contacts;
	
	@ManyToOne
	@JoinColumn(name = "email_id")
	@ForeignKey(name = "fk_groups_person_id")
	PersonEntity personEntity;

	public GroupEntity() {	}

	public GroupEntity(String groupName, List<ContactEntity> contacts, PersonEntity personEntity) {
		this.groupName = groupName;
		this.contacts = contacts;
		this.personEntity = personEntity;
	}

	public GroupEntity(mat.Group group, PersonEntity personEntity) {
		this.groupName = group.getGroupName();
		this.personEntity = personEntity;
		if(group.getGroupContacts()!=null)
			for(mat.Contact contact: group.getGroupContacts().values())
				this.contacts.add(new ContactEntity(contact.getContactName(), contact.getEmail(), this));
	}

	public int getId() {
		return id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<ContactEntity> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactEntity> contacts) {
		this.contacts = contacts;
	}

	public PersonEntity getPersonEntity() {
		return personEntity;
	}

	public void setPersonEntity(PersonEntity personEntity) {
		this.personEntity = personEntity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + id;
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
		GroupEntity other = (GroupEntity) obj;
		if (contacts == null) {
			if (other.contacts != null)
				return false;
		} else if (!contacts.equals(other.contacts))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (id != other.id)
			return false;
		if (personEntity == null) {
			if (other.personEntity != null)
				return false;
		} else if (!personEntity.getEmail().equals(other.personEntity.getEmail()))
			return false;
		return true;
	}
	
	
	

}
