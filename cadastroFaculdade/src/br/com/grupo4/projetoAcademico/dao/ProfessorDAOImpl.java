package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

@Repository
public class ProfessorDAOImpl implements ProfessorDAO {

	private SessionFactory sessionFactory;
	private static ProfessorDAOImpl instance;

	public static ProfessorDAOImpl getInstance(){
		if (instance == null){
			instance = new ProfessorDAOImpl();
		}

		return instance;
	}

	public ProfessorDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}


	@Override
	@Transactional
	public void inserir(Professor professor) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			session.save(professor);
			session.getTransaction().commit();

		}
		else{
			//			System.out.println("Nao ta open");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Professor> listar() {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Professor.class);
			List<Professor> lista =  criteria.list();
			session.getTransaction().commit();
			return lista;
		}
		return null;
	}



	// OK
	@Override
	@Transactional
	public Professor getProfessorById(int id) {
		//duvida pessoa ou professor
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			Professor result=  (Professor) sessionFactory.getCurrentSession().get(Professor.class, id);
			session.getTransaction().commit();
			return result;
		}
		return null;
	}

	@Override
	@Transactional
	public void atualizar(Professor professor) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			sessionFactory.getCurrentSession().update(professor);
			session.getTransaction().commit();
		}
		}

		// OK
		@Override
		@Transactional
		public int getProfessorId(String cpf) {
			Session session= sessionFactory.getCurrentSession();
			if (session.isOpen()){
				session.getTransaction().begin();
				Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Professor.class, "prof");
				criteria.add(Restrictions.eq("prof.cpf", cpf));
				criteria.setMaxResults(1);
				Professor result =  (Professor) criteria.uniqueResult();
				session.getTransaction().commit();
				return result.getId();
			}
			return -1;

		}

	}
