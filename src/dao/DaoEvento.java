package dao;

import modelo.Evento;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class DaoEvento {
	private SessionFactory fabrica;
	
	public DaoEvento() throws Exception{
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure("hibernate.cfg.xml");
		fabrica = configuration.buildSessionFactory();
	}
	
    public void incluir(Evento e) throws Exception {
    	Session sessao = fabrica.openSession();
    	Transaction transacao = sessao.beginTransaction();
    	sessao.save(e);
    	transacao.commit();
    	sessao.close();    	
    }
    
    public void alterar(Evento e) throws Exception {
    	Session sessao = fabrica.openSession();
    	Transaction transacao = sessao.beginTransaction();
    	sessao.update(e);
    	transacao.commit();
    	sessao.close();
	}
    
    public void excluir(Evento e) throws Exception {
    	Session sessao = fabrica.openSession();
    	Transaction transacao = sessao.beginTransaction();
    	sessao.delete(e);
    	transacao.commit();
    	sessao.close();
    }    
    
    public Evento consultar(int id) throws Exception{
   //public Evento consultar(Evento e) throws Exception{	
    	Evento ev = null;
    	Session sessao = fabrica.openSession();
    	Transaction transacao = sessao.beginTransaction();
    	Query consulta = sessao.createQuery("from Evento where idEvento= :parametro");
    	//consulta.setInteger("parametro", e.getIdEvento());
    	consulta.setInteger("parametro", id);
    	ev = (Evento) consulta.uniqueResult();
    	transacao.commit();
    	sessao.close();
    	return ev;
    }
}