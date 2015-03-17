package model;
import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="notifications")
public class NotificationEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="note_id")
	int id;
	
	@ManyToOne
	@JoinColumn(name="matt_id")
	@ForeignKey(name="fk_mattsinfo_notifications")
	MattInfoEntity mattInfo;
	
	String guest_email;
	
	@Column(name="guest_matt_id")
	int guestMattId = 0;
	
	public NotificationEntity(){}

	public NotificationEntity(MattInfoEntity mattinfo, String guest_email){
		this.guest_email = guest_email;
		this.mattInfo = mattinfo;
	}
	
	public long getNote_id() {
		return id;
	}
	public void setNote_id(int note_id) {
		this.id = note_id;
	}
	public MattInfoEntity getMattInfo() {
		return mattInfo;
	}
	public void setMattInfo(MattInfoEntity mattInfo) {
		this.mattInfo = mattInfo;
	}
	public String getGuest_email() {
		return guest_email;
	}
	public void setGuest_email(String guest_email) {
		this.guest_email = guest_email;
	}
	public Integer getGuestMattId() {
		return guestMattId;
	}
	public void setGuestMattId(Integer guestMattId) {
		this.guestMattId = guestMattId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + guestMattId;
		result = prime * result
				+ ((guest_email == null) ? 0 : guest_email.hashCode());
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
		NotificationEntity other = (NotificationEntity) obj;
		if (guestMattId != other.guestMattId)
			return false;
		if (guest_email == null) {
			if (other.guest_email != null)
				return false;
		} else if (!guest_email.equals(other.guest_email))
			return false;
		if (id != other.id)
			return false;
		if (mattInfo == null) {
			if (other.mattInfo != null)
				return false;
		} else if (mattInfo.getMatt_id()!=other.mattInfo.getMatt_id())
			return false;
		return true;
	}

	
}
