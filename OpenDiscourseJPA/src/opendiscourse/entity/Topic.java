package opendiscourse.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the topic database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t"),
	@NamedQuery(name="Topic.findIn", query="Select t from Topic t where t.topicValue like :arg1")
})

public class Topic implements Serializable {

	private static final long serialVersionUID = 8727247010444968906L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTopic;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datePosted;

	private int thumbsDown;

	private int thumbsUp;

	private String topicValue;

	//bi-directional many-to-one association to Remark
	@OneToMany(mappedBy="topic")
	private List<Remark> remarks;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;

	public Topic() {
	}

	public List<Remark> getPros() {
		ArrayList<Remark> pros = new ArrayList<>();
		if (remarks != null) {
			for (Remark r : remarks) {
				if (!r.isAgainst()) {
					pros.add(r);
				}
			}
			
		}
		return pros;
	}
	
	public List<Remark> getCons() {
		ArrayList<Remark> cons = new ArrayList<>();
		if (remarks != null) {
			for (Remark r : remarks) {
				if (r.isAgainst()) {
					cons.add(r);
				}
			}
			
		}
		return cons;
	}
	
	public int getIdTopic() {
		return this.idTopic;
	}

	public void setIdTopic(int idTopic) {
		this.idTopic = idTopic;
	}

	public Date getDatePosted() {
		return this.datePosted;
	}

	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
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

	public String getTopicValue() {
		return this.topicValue;
	}

	public void setTopicValue(String topicValue) {
		this.topicValue = topicValue;
	}

	public List<Remark> getRemarks() {
		return this.remarks;
	}

	public void setRemarks(List<Remark> remarks) {
		this.remarks = remarks;
	}

	public Remark addRemark(Remark remark) {
		getRemarks().add(remark);
		remark.setTopic(this);

		return remark;
	}

	public Remark removeRemark(Remark remark) {
		getRemarks().remove(remark);
		remark.setTopic(null);

		return remark;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}