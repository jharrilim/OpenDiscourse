package opendiscourse.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the remark database table.
 * 
 */
@Entity
@NamedQuery(name="Remark.findAll", query="SELECT r FROM Remark r")
public class Remark implements Serializable {

	private static final long serialVersionUID = 5732430699501331800L;

	@Id
	private int idremark;

	private String remarkValue;

	private boolean against;
	
	private int thumbsDown;

	private int thumbsUp;

	//bi-directional many-to-one association to Topic
	@ManyToOne
	@JoinColumn(name="idTopic")
	private Topic topic;

	public int getIdremark() {
		return this.idremark;
	}

	public void setIdremark(int idremark) {
		this.idremark = idremark;
	}

	public String getRemarkValue() {
		return this.remarkValue;
	}

	public void setRemarkValue(String remarkValue) {
		this.remarkValue = remarkValue;
	}

	public int getThumbsDown() {
		return this.thumbsDown;
	}

	public void setThumbsDown(int thumbsDown) {
		this.thumbsDown = thumbsDown;
	}

	public int getThumbsUp() {
		return this.thumbsUp;
	}

	public void setThumbsUp(int thumbsUp) {
		this.thumbsUp = thumbsUp;
	}

	public Topic getTopic() {
		return this.topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public boolean isAgainst() {
		return against;
	}

	public void setAgainst(boolean against) {
		this.against = against;
	}

}