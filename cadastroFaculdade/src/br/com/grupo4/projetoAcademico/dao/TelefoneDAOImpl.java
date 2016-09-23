package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.grupo4.projetoAcademico.model.Publicacao;
import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class TelefoneDAOImpl implements TelefoneDAO {

	private SessionFactory sessionFactory;
	private static TelefoneDAOImpl instance;
	
	public static TelefoneDAOImpl getInstance(){
		if (instance == null){
			instance = new TelefoneDAOImpl();
		}
		
		return instance;
	}
	
	private TelefoneDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	public void inserir(Telefone telefone) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
//			System.out.println("Ta chegnado em inserir de telefone");
			session.getTransaction().begin();
			session.save(telefone);
			session.getTransaction().commit();
		}
		else{
//			System.out.println("Nao ta open");
		}
	}

	@Override
	@Transactional
	public List<Telefone> listar() {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Telefone.class);
			List<Telefone> lista =  criteria.list();
			session.getTransaction().commit();
			return lista;
		}
		return null;
	}

	@Override
	@Transactional
	public void atualizar(Telefone telefone) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			sessionFactory.getCurrentSession().update(telefone);
			session.getTransaction().commit();
		}
	}

	@Override
	public void remover(int id) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
		sessionFactory.getCurrentSession().delete(this.getTelefoneById(id));
		session.getTransaction().commit();
		}
		
	}

	@Override
	public Telefone getTelefoneById(int id) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			Telefone result=  (Telefone) sessionFactory.getCurrentSession().get(Telefone.class, id);
			session.getTransaction().commit();
			return result;
		}
		return null;
	}

	
}
