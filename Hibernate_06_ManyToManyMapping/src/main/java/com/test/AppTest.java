package com.test;

import org.hibernate.Session;
import com.entity.ReaderEntity;
import com.entity.SubscriptionEntity;
import com.utils.HibernateUtil;
import java.util.HashSet;
import java.util.Set;

public class AppTest {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		// Add subscription
		SubscriptionEntity subOne = new SubscriptionEntity();
		subOne.setSubscriptionName("Amazon");
		SubscriptionEntity subTwo = new SubscriptionEntity();
		subTwo.setSubscriptionName("Netflix");
		SubscriptionEntity subThree = new SubscriptionEntity();
		subThree.setSubscriptionName("Hotstar");
		Set<SubscriptionEntity> subs = new HashSet<SubscriptionEntity>();
		subs.add(subOne);
		subs.add(subTwo);
		subs.add(subThree);

		// Add readers
		ReaderEntity readerOne = new ReaderEntity();
		readerOne.setEmail("Darshit@gmail.com");
		readerOne.setFirstName("Darshit");
		readerOne.setLastName("Rabadiya");

		ReaderEntity readerTwo = new ReaderEntity();
		readerTwo.setEmail("abc@gmail.com");
		readerTwo.setFirstName("abc");
		readerTwo.setLastName("abc");

		Set<ReaderEntity> readers = new HashSet<ReaderEntity>();
		readers.add(readerOne);
		readers.add(readerTwo);

		readerOne.setSubscriptions(subs);
		readerTwo.setSubscriptions(subs);

		session.save(readerOne);
		session.save(readerTwo);

		session.getTransaction().commit();
					
	}
}