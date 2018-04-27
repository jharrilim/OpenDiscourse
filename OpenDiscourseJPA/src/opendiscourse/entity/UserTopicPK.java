package opendiscourse.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the user_topics database table.
 * 
 */
@Embeddable
public class UserTopicPK implements Serializable {

	private static final long serialVersionUID = -3299303548713932964L;

	@Column(insertable=false, updatable=false)
	private int iduser;

	@Column(insertable=false, updatable=false)
	private int idtopic;

	public int getIduser() {
		return this.iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public int getIdtopic() {
		return this.idtopic;
	}
	public void setIdtopic(int idtopic) {
		this.idtopic = idtopic;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserTopicPK)) {
			return false;
		}
		UserTopicPK castOther = (UserTopicPK)other;
		return 
			(this.iduser == castOther.iduser)
			&& (this.idtopic == castOther.idtopic);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.iduser;
		hash = hash * prime + this.idtopic;
		
		return hash;
	}
}