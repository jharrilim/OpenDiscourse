package opendiscourse.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int iduser;

	private String email;

	private String password;

	private String username;

	//bi-directional many-to-many association to Topic
	@ManyToMany
	@JoinTable(
		name="user_topics"
		, joinColumns={
			@JoinColumn(name="iduser")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idtopic")
			}
		)
	private List<Topic> topics;

	//bi-directional many-to-one association to UserTopic
	@OneToMany(mappedBy="user")
	private List<UserTopic> userTopics;

	public User() {
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
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

	public List<Topic> getTopics() {
		return this.topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<UserTopic> getUserTopics() {
		return this.userTopics;
	}

	public void setUserTopics(List<UserTopic> userTopics) {
		this.userTopics = userTopics;
	}

	public UserTopic addUserTopic(UserTopic userTopic) {
		getUserTopics().add(userTopic);
		userTopic.setUser(this);

		return userTopic;
	}

	public UserTopic removeUserTopic(UserTopic userTopic) {
		getUserTopics().remove(userTopic);
		userTopic.setUser(null);

		return userTopic;
	}

}