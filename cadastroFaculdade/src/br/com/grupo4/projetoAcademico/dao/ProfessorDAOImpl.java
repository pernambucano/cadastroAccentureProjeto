package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
//			System.out.println("Ta chegnado em inserir de professordaoimpl");
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
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Professor.class);
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Endereco> getEnderecos(int id) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Professor.class, "prof");
		criteria.createCriteria("endereco", "e");
		criteria.add(Restrictions.eq("e.pessoa_id", id));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Telefone> getTelefones(int id) { //possivel modificacao
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Professor.class, "prof");
		criteria.createCriteria("telefone", "t");
		criteria.add(Restrictions.eq("t.pessoa_id", id));
		return criteria.list();
	}

	@Override
	@Transactional
	public Professor getProfessorById(int id) {
		//duvida pessoa ou professor
		return (Professor) sessionFactory.getCurrentSession().get(Professor.class, id); 
	}

	@Override
	@Transactional
	public void atualizar(Professor professor) {
		sessionFactory.getCurrentSession().update(professor);
	}

	@Override
	@Transactional
	public int getProfessorId(String cpf) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Professor.class, "prof");
		criteria.add(Restrictions.eq("prof.cpf", cpf));
		criteria.setMaxResults(1);
		return (int) criteria.uniqueResult();
	}

}
