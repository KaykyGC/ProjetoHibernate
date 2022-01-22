package dao;

import modelo.Musico;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class DaoMusico {
	private SessionFactory fabrica;
	
	public DaoMusico() throws Exception{
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure("hibernate.cfg.xml");
		fabrica = configuration.buildSessionFactory();
	}
	
    public void incluir(Musico e) throws Exception {
    	Session sessao = fabrica.openSession();
    	Transaction transacao = sessao.beginTransaction();
    	sessao.save(e);
    	transacao.commit();
    	sessao.close();    	
    }
    
    public void alterar(Musico e) throws Exception {
    	Session sessao = fabrica.openSession();
    	Transaction transacao = sessao.beginTransaction();
    	sessao.update(e);
    	transacao.commit();
    	sessao.close();
	}
    
    public void excluir(Musico e) throws Exception {
    	Session sessao = fabrica.openSession();
    	Transaction transacao = sessao.beginTransaction();
    	sessao.delete(e);
    	transacao.commit();
    	sessao.close();
    }    
    
    public Musico consultar(int id) throws Exception{
    	Musico ev = null;
    	Session sessao = fabrica.openSession();
    	Transaction transacao = sessao.beginTransaction();
    	Query consulta = sessao.createQuery("from Musico where idMusico= :parametro");
    	consulta.setInteger("parametro", id);
    	ev = (Musico) consulta.uniqueResult();
    	transacao.commit();
    	//sessao.close();
    	return ev;
    }
}