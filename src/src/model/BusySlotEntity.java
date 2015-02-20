package model;

import java.util.*;

import javax.persistence.*;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="matt_busy_slots")
public class BusySlotEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "slot_id")
	int id;	
	
	@ManyToOne
	@JoinColumn (name="matt_id")
	@ForeignKey(name="fk_mattsinfo_mattbusyslots")
	MattInfoEntity mattInfo;

	@OneToOne(targetEntity=SlotInfoEntity.class, mappedBy = "mattSlots", cascade = CascadeType.ALL)
	@OnDelete(action=OnDeleteAction.CASCADE)
	SlotInfoEntity slotInfo;

	@Column(name = "event_date", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	Date date;
	
	int slot_number;

	public BusySlotEntity() {}

	public BusySlotEntity(Date date, int slot_number, MattInfoEntity mattInfo) {
		this.date = date;
		this.slot_number = slot_number;
		this.mattInfo = mattInfo;
	}

	public MattInfoEntity getMattInfo() {
		return mattInfo;
	}

	public void setMattInfo(MattInfoEntity mattInfo) {
		this.mattInfo = mattInfo;
	}

	public int getSlot_number() {
		return slot_number;
	}
	
}
