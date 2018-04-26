package opendiscourse.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * The persistent class for the topic database table.
 * 
 */
@Entity
@NamedQuery(name = "Topic.findAll", query = "SELECT t FROM Topic t")
public class Topic implements Serializable {

	private static final long serialVersionUID = 1490476297228543367L;

	@Id
	private int idTopic;

	private String topicValue;

	// bi-directional many-to-one association to Remark
	@OneToMany(mappedBy = "topic")
	private List<Remark> remarks;

	public List<Remark> getPros() {
		List<Remark> pros = new ArrayList<>();
		for (Remark remark : remarks) {
			if (!remark.isAgainst())
				pros.add(remark);
		}
		return pros;
	}

	public List<Remark> getCons() {
		List<Remark> cons = new ArrayList<>();
		for (Remark remark : remarks) {
			if (remark.isAgainst())
				cons.add(remark);
		}
		return cons;
	}	
	
	public int getIdTopic() {
		return this.idTopic;
	}

	public void setIdTopic(int idTopic) {
		this.idTopic = idTopic;
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

}