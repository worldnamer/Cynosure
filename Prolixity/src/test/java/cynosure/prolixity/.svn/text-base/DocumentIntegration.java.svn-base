package cynosure.prolixity;

import org.hibernate.Transaction;
import org.junit.Test;

public class DocumentIntegration extends DatabaseIntegration
{
	@Test
	public void persistWithNoWords() {
		Document doc = new Document();
		
		Transaction tx = m_session.getTransaction();
		tx.begin();
		m_session.persist(doc);
		tx.commit();
	}

	@Test
	public void persistWithWords() {
		Document doc = new Document();
		WordCount wc = new WordCount();
		wc.setCount(1);
		wc.setWord("test");
		doc.addWord(wc);
		
		Transaction tx = m_session.getTransaction();
		tx.begin();
		m_session.persist(doc);
		tx.commit();
	}
}
