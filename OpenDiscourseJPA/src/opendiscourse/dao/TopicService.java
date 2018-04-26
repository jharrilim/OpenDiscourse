package opendiscourse.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import opendiscourse.entity.Topic;

public class TopicService {

	private static final EntityManager em;
	
	static {
		em = Persistence.createEntityManagerFactory("OpenDiscourseJPA").createEntityManager();
	}
	
	public static List<Topic> all() {
		return em.createNamedQuery("Topic.findAll", Topic.class).getResultList();
	}
	
}
