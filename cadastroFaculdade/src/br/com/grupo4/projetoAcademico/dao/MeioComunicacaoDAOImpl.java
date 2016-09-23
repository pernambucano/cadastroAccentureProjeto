package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.grupo4.projetoAcademico.model.MeioComunicacao;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class MeioComunicacaoDAOImpl implements MeioComunucaoDAO {

	private SessionFactory sessionFactory;
	private static MeioComunicacaoDAOImpl instance;
	
	public static MeioComunicacaoDAOImpl getInstance(){
		if (instance == null){
			instance = new MeioComunicacaoDAOImpl();
		}
		
		return instance;
	}
	
	private MeioComunicacaoDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	@Transactional
	public void inserir(MeioComunicacao meioComunicacao) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
//			System.out.println("Ta chegnado em inserir de endereco");
			session.getTransaction().begin();
			session.save(meioComunicacao);
			session.getTransaction().commit();
			
		}
		else{
//			System.out.println("Nao ta open");
		}
	}

	@Override
	public List<MeioComunicacao> listar() {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(MeioComunicacao.class);
			List<MeioComunicacao> lista =  criteria.list();
			session.getTransaction().commit();
			return lista;
		}
		return null;
	}

	@Override
	public void atualizar(MeioComunicacao meioComunicacao) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			sessionFactory.getCurrentSession().update(meioComunicacao);
			session.getTransaction().commit();
		}	
		
	}

	@Override
	public void remover(int id) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
		sessionFactory.getCurrentSession().delete(this.getMeioComunicacaoById(id));
		session.getTransaction().commit();
		}
		
	}

	@Override
	public MeioComunicacao getMeioComunicacaoById(int id) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			MeioComunicacao result=  (MeioComunicacao) sessionFactory.getCurrentSession().get(MeioComunicacao.class, id);
			session.getTransaction().commit();
			return result;
		}
		return null;
	}

}
