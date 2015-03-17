package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import mat.SlotInfo;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="slot_info")
public class SlotInfoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="slot_info_id")
	int slotInfoId;
	
	@OneToOne
	@JoinColumn(name="slot_id")
	@ForeignKey(name="fk_mattslots")
	BusySlotEntity mattSlots;
	
	String nameGuest;
	String surnameGuest;
	String emailGuest;
	String phoneGuest;
	String noteGuest;

	public SlotInfoEntity() { }

	public SlotInfoEntity(BusySlotEntity mattSlots, SlotInfo slotInfo) {
		this.mattSlots = mattSlots;
		this.nameGuest = slotInfo.getNameGuest();
		this.surnameGuest = slotInfo.getSurnameGuest();
		this.emailGuest = slotInfo.getEmailGuest();
		this.phoneGuest = slotInfo.getPhoneGuest();
		this.noteGuest = slotInfo.getNoteGuest();
	}

	public int getSlotInfoId() {
		return slotInfoId;
	}

	public void setSlotInfoId(int slotInfoId) {
		this.slotInfoId = slotInfoId;
	}

	public BusySlotEntity getMattSlots() {
		return mattSlots;
	}

	public void setMattSlots(BusySlotEntity mattSlots) {
		this.mattSlots = mattSlots;
	}

	public String getNameGuest() {
		return nameGuest;
	}

	public void setNameGuest(String nameGuest) {
		this.nameGuest = nameGuest;
	}

	public String getSurnameGuest() {
		return surnameGuest;
	}

	public void setSurnameGuest(String surnameGuest) {
		this.surnameGuest = surnameGuest;
	}

	public String getEmailGuest() {
		return emailGuest;
	}

	public void setEmailGuest(String emailGuest) {
		this.emailGuest = emailGuest;
	}

	public String getPhoneGuest() {
		return phoneGuest;
	}

	public void setPhoneGuest(String phoneGuest) {
		this.phoneGuest = phoneGuest;
	}

	public String getNoteGuest() {
		return noteGuest;
	}

	public void setNoteGuest(String noteGuest) {
		this.noteGuest = noteGuest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((emailGuest == null) ? 0 : emailGuest.hashCode());
		result = prime * result
				+ ((nameGuest == null) ? 0 : nameGuest.hashCode());
		result = prime * result
				+ ((noteGuest == null) ? 0 : noteGuest.hashCode());
		result = prime * result
				+ ((phoneGuest == null) ? 0 : phoneGuest.hashCode());
		result = prime * result + slotInfoId;
		result = prime * result
				+ ((surnameGuest == null) ? 0 : surnameGuest.hashCode());
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
		SlotInfoEntity other = (SlotInfoEntity) obj;
		if (emailGuest == null) {
			if (other.emailGuest != null)
				return false;
		} else if (!emailGuest.equals(other.emailGuest))
			return false;
		if (mattSlots == null) {
			if (other.mattSlots != null)
				return false;
		} else if (mattSlots.getSlot_number()!=other.mattSlots.getSlot_number())
			return false;
		if (nameGuest == null) {
			if (other.nameGuest != null)
				return false;
		} else if (!nameGuest.equals(other.nameGuest))
			return false;
		if (noteGuest == null) {
			if (other.noteGuest != null)
				return false;
		} else if (!noteGuest.equals(other.noteGuest))
			return false;
		if (phoneGuest == null) {
			if (other.phoneGuest != null)
				return false;
		} else if (!phoneGuest.equals(other.phoneGuest))
			return false;
		if (slotInfoId != other.slotInfoId)
			return false;
		if (surnameGuest == null) {
			if (other.surnameGuest != null)
				return false;
		} else if (!surnameGuest.equals(other.surnameGuest))
			return false;
		return true;
	}

}
