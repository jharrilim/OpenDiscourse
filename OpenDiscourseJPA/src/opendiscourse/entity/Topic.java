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
@NamedQuery(name="Topic.findAll", query="SELECT t FROM Topic t")
public class Topic implements Serializable {

	private static final long serialVersionUID = 2142213725500793981L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idTopic;

	private String topicValue;

	//bi-directional many-to-one association to Remark
	@OneToMany(mappedBy="topic")
	private List<Remark> remarks;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="topics")
	private List<User> users;
	
	public List<Remark> getPros() {
		ArrayList<Remark> pros = new ArrayList<>();
		for (Remark remark : remarks) {
			if (!remark.isAgainst())
				pros.add(remark);
		}
		return pros;
	}

	public List<Remark> getCons() {
		ArrayList<Remark> cons = new ArrayList<>();
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

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}