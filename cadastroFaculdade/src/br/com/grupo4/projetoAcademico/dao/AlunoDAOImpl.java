package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.grupo4.projetoAcademico.model.Aluno;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.model.Titulacao;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class AlunoDAOImpl implements AlunoDAO{

	private SessionFactory sessionFactory;
	private static AlunoDAOImpl instance;
	
	public static AlunoDAOImpl getInstance(){
		if (instance == null){
			instance = new AlunoDAOImpl();
		}
		
		return instance;
	}
	
	public AlunoDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Override
	@Transactional
	public void inserir(Aluno aluno) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			session.save(aluno);
			session.getTransaction().commit();
			
		}
		else{
//			System.out.println("Nao ta open");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Aluno> listar() {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Aluno.class);
			List<Aluno> lista =  criteria.list();
			session.getTransaction().commit();
			return lista;
		}
		return null;
	}

	@Override
	@Transactional
	public void remover(int id) {
		// TODO Auto-generated method stub
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
		sessionFactory.getCurrentSession().delete(this.getAlunoById(id));
		session.getTransaction().commit();
		}
	}

	@Override
	@Transactional
	public void atualizar(Aluno aluno) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			sessionFactory.getCurrentSession().update(aluno);
			session.getTransaction().commit();
		}
	}

	@Override
	@Transactional
	public Aluno getAlunoById(int id) {
		return (Aluno) sessionFactory.getCurrentSession().get(Aluno.class, id); 
	}

	@Override
	@Transactional
	public int getAlunoId(String cpf) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Aluno.class, "aluno");
		criteria.add(Restrictions.eq("aluno.cpf", cpf));
		criteria.setMaxResults(1);
		return (int) criteria.uniqueResult();
	}

}
