package opendiscourse.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import opendiscourse.entity.Topic;

public class TopicService {

	private static final Logger LOGGER = Logger.getLogger(TopicService.class.getName());
	private static final EntityManager em;

	private TopicService() { }
	
	static {
		em = Persistence.createEntityManagerFactory("OpenDiscourseJPA").createEntityManager();
	}
	
	public static List<Topic> all() {
		return em.createNamedQuery("Topic.findAll", Topic.class).getResultList();
	}
	
	public static void addTopic(Topic topic) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(topic);
			et.commit();			
		}
		catch (RollbackException e) {
			LOGGER.log(Level.SEVERE, "Failed to add Topic.", e);
		}
	}
	
}
