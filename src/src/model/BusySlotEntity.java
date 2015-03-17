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
	@JoinColumn(name="matt_id")
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

	public SlotInfoEntity getSlotInfo() {
		return slotInfo;
	}

	public void setSlotInfo(SlotInfoEntity slotInfo) {
		this.slotInfo = slotInfo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + slot_number;
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
		BusySlotEntity other = (BusySlotEntity) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (mattInfo == null) {
			if (other.mattInfo != null)
				return false;
		} else if (mattInfo.getMatt_id()!=other.mattInfo.getMatt_id())
			return false;
		if (slotInfo == null) {
			if (other.slotInfo != null)
				return false;
		} else if (slotInfo.getSlotInfoId()!=other.slotInfo.getSlotInfoId())
			return false;
		if (slot_number != other.slot_number)
			return false;
		return true;
	}
	
}
