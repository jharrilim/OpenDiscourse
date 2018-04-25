package opendiscourse.bean;

import java.io.Serializable;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Topic
 */
@Stateless
@LocalBean
public class Topic implements TopicRemote, TopicLocal, Serializable {

	private static final long serialVersionUID = -6030937953013123657L;

	private int id;
	private String topicValue;

	public Topic() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopicValue() {
		return topicValue;
	}

	public void setTopicValue(String topicValue) {
		this.topicValue = topicValue;
	}

}
