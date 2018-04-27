package opendiscourse.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_topics database table.
 * 
 */
@Entity
@Table(name="user_topics")
@NamedQuery(name="UserTopic.findAll", query="SELECT u FROM UserTopic u")
public class UserTopic implements Serializable {
	
	private static final long serialVersionUID = -663655029288811897L;

	@EmbeddedId
	private UserTopicPK id;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="iduser", insertable=false, updatable=false)
	private User user;
	
	public UserTopicPK getId() {
		return this.id;
	}

	public void setId(UserTopicPK id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}