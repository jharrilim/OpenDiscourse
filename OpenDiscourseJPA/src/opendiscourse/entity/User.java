package opendiscourse.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name = "User.authenticate", query="SELECT u FROM User u WHERE u.username = :arg1 and u.password = :arg2"),
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")})
public class User implements Serializable {

	private static final long serialVersionUID = 8556417425200830114L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduser;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateJoined;

	private String email;

	private String password;

	private String username;

	//bi-directional many-to-one association to Remark
	@OneToMany(mappedBy="user")
	private List<Remark> remarks;

	//bi-directional many-to-one association to Topic
	@OneToMany(mappedBy="user")
	private List<Topic> topics;

	public User() {
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public Date getDateJoined() {
		return this.dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Remark> getRemarks() {
		return this.remarks;
	}

	public void setRemarks(List<Remark> remarks) {
		this.remarks = remarks;
	}

	public Remark addRemark(Remark remark) {
		getRemarks().add(remark);
		remark.setUser(this);

		return remark;
	}

	public Remark removeRemark(Remark remark) {
		getRemarks().remove(remark);
		remark.setUser(null);

		return remark;
	}

	public List<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Topic addTopic(Topic topic) {
		getTopics().add(topic);
		topic.setUser(this);

		return topic;
	}

	public Topic removeTopic(Topic topic) {
		getTopics().remove(topic);
		topic.setUser(null);

		return topic;
	}

}