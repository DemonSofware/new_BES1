package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="slot_info")
public class SlotInfoEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="slot_info_id", unique = true, nullable = false)
	int slotInfoId;
	
	@OneToOne
	@JoinColumn (name="slot_id")
	@ForeignKey(name="fk_mattslots")
	BusySlotEntity mattSlots;
	
	String nameGuest;
	String surnameGuest;
	String emailGuest;
	String phoneGuest;
	String noteGuest;

	public SlotInfoEntity() { }

	public SlotInfoEntity(BusySlotEntity mattSlots, String nameGuest, String surnameGuest,
			String emailGuest, String phoneGuest, String noteGuest) {
		this.mattSlots = mattSlots;
		this.nameGuest = nameGuest;
		this.surnameGuest = surnameGuest;
		this.emailGuest = emailGuest;
		this.phoneGuest = phoneGuest;
		this.noteGuest = noteGuest;
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

}
