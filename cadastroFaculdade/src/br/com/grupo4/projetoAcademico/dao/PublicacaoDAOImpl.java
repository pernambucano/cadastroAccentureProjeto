package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.model.Publicacao;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class PublicacaoDAOImpl implements PublicacaoDAO {

	private SessionFactory sessionFactory;
	private static PublicacaoDAOImpl instance;
	
	public static PublicacaoDAOImpl getInstance(){
		if (instance == null){
			instance = new PublicacaoDAOImpl();
		}
		
		return instance;
	}
	
	private PublicacaoDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	@Transactional
	public void inserir(Publicacao publicacao) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			session.save(publicacao);
			session.getTransaction().commit();
			
		}
		else{
//			System.out.println("Nao ta open");
		}

	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Publicacao> listar() {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Publicacao.class);
			List<Publicacao> lista =  criteria.list();
			session.getTransaction().commit();
			return lista;
		}
		return null;
	
	}

	@Override
	@Transactional
	public void atualizar(Publicacao publicacao) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			sessionFactory.getCurrentSession().update(publicacao);
			session.getTransaction().commit();
		}
	}

	@Override
	@Transactional
	public void remover(int id) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
		sessionFactory.getCurrentSession().delete(this.getEnderecoById(id));
		session.getTransaction().commit();
		}
	}

	@Override
	@Transactional
	public Publicacao getEnderecoById(int id) {
		//duvida pessoa ou professor
				Session session= sessionFactory.getCurrentSession();
				if (session.isOpen()){
					session.getTransaction().begin();
					Publicacao result=  (Publicacao) sessionFactory.getCurrentSession().get(Publicacao.class, id);
					session.getTransaction().commit();
					return result;
				}
				return null;
	}

}
