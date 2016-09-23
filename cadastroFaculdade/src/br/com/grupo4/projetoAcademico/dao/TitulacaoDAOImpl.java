package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.model.Titulacao;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class TitulacaoDAOImpl implements TitulacaoDAO {

	private SessionFactory sessionFactory;
	private static TitulacaoDAOImpl instance;
	
	public static TitulacaoDAOImpl getInstance(){
		if (instance == null){
			instance = new TitulacaoDAOImpl();
		}
		
		return instance;
	}
	
	private TitulacaoDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void inserir(Titulacao titulacao) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
//			System.out.println("Ta chegnado em inserir de titulacao");
			session.getTransaction().begin();
			session.save(titulacao);
			session.getTransaction().commit();
			
		}
		else{
//			System.out.println("Nao ta open");
		}
	}

	@Override
	@Transactional
	public List<Titulacao> listar() {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Titulacao.class);
			List<Titulacao> lista =  criteria.list();
			session.getTransaction().commit();
			return lista;
		}
		return null;
	}

	@Override
	@Transactional
	public void atualizar(Titulacao titulacao) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			sessionFactory.getCurrentSession().update(titulacao);
			session.getTransaction().commit();
		}	
	}

	@Override
	public void remover(int id) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
		sessionFactory.getCurrentSession().delete(this.getTitulacaoById(id));
		session.getTransaction().commit();
		}
		
	}

	@Override
	public Titulacao getTitulacaoById(int id) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			Titulacao result=  (Titulacao) sessionFactory.getCurrentSession().get(Titulacao.class, id);
			session.getTransaction().commit();
			return result;
		}
		return null;

	}
}
