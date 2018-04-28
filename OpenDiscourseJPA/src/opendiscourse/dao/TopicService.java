package opendiscourse.dao;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;

import opendiscourse.entity.Remark;
import opendiscourse.entity.Topic;
import opendiscourse.entity.User;

public class TopicService {

	private static final Logger LOGGER;
	private static final EntityManager em;

	private TopicService() { }
	
	static {
		LOGGER = Logger.getLogger(TopicService.class.getName());
		em = Persistence.createEntityManagerFactory("OpenDiscourseJPA").createEntityManager();
		em.setFlushMode(FlushModeType.COMMIT);
	}
	
	public static List<Topic> all() {
		return em.createNamedQuery("Topic.findAll", Topic.class).getResultList();
	}
	
	public static Topic getTopicById(int topicId) {
		return em.getReference(Topic.class, topicId);
	}
	
	
	public static void addTopic(Topic topic) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(topic);
			em.flush();
			et.commit();
		}
		catch (RollbackException e) {
			LOGGER.log(Level.SEVERE, "Failed to add Topic.", e);
		}
	}
	
	public static void addRemark(Remark remark) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(remark);
			em.flush();
			et.commit();
		}
		catch (RollbackException e) {
			LOGGER.log(Level.SEVERE, "Failed to add Remark.", e);
		}
	}
	
	public static void registerUser(User user) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(user);
			em.flush();
			et.commit();
			LOGGER.info(()-> "Committed...");
		}
		catch (EntityExistsException e) {
			LOGGER.log(Level.WARNING, "User already exists. Rethrowing.", e);
			throw e;
		}
		catch (RollbackException e) {
			LOGGER.log(Level.SEVERE, "Failed to register User.", e);			
		}
	}
}
