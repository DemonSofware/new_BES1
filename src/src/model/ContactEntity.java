package model;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="contact")
public class ContactEntity{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="contact_id")
	int id;
	
	@Column(name="contact_name")
	String contactName;

	@Column(name="contact_email")
	String contactEmail;
	
	@ManyToOne
	@JoinColumn(name="group_id")
	@ForeignKey(name="fk_group_contact")
	GroupEntity groupEntity;

	public ContactEntity() {}

	public ContactEntity(String contactName, String contactEmail, GroupEntity groupEntity) {
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.groupEntity = groupEntity;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public GroupEntity getGroupEntity() {
		return groupEntity;
	}

	public void setGroupEntity(GroupEntity groupEntity) {
		this.groupEntity = groupEntity;
	}

	public int getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contactEmail == null) ? 0 : contactEmail.hashCode());
		result = prime * result
				+ ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result
				+ ((groupEntity == null) ? 0 : groupEntity.hashCode());
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
		ContactEntity other = (ContactEntity) obj;
		if (contactEmail == null) {
			if (other.contactEmail != null)
				return false;
		} else if (!contactEmail.equals(other.contactEmail))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (groupEntity == null) {
			if (other.groupEntity != null)
				return false;
		} else if (groupEntity.getId()!=other.groupEntity.getId())
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
