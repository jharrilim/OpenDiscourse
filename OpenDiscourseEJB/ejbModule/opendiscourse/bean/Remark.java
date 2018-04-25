package opendiscourse.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Remark
 */
@Stateless
@LocalBean
public class Remark implements RemarkRemote, RemarkLocal {

	private int id;
	private int topicId;
	private String remarkValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getRemarkValue() {
		return remarkValue;
	}

	public void setRemarkValue(String remarkValue) {
		this.remarkValue = remarkValue;
	}

}
