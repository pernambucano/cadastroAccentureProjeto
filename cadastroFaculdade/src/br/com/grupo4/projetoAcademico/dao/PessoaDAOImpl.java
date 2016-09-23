package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import br.com.grupo4.projetoAcademico.model.Aluno;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Pessoa;
import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.util.HibernateUtil;

public class PessoaDAOImpl implements PessoaDAO {

	private SessionFactory sessionFactory;
	private static PessoaDAOImpl instance;
	
	public static PessoaDAOImpl getInstance(){
		if (instance == null){
			instance = new PessoaDAOImpl();
		}
		
		return instance;
	}
	
	private PessoaDAOImpl() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	
	@Override
	@Transactional
	public void inserir(Pessoa pessoa) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
//			System.out.println("Ta chegnado em inserir de professordaoimpl");
			session.getTransaction().begin();
			session.save(pessoa);
			session.getTransaction().commit();
			
		}
		else{
//			System.out.println("Nao ta open");
		}
		
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Pessoa> listar() {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			//			System.out.println("Ta chegnado em inserir de endereco");
			session.getTransaction().begin();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pessoa.class);
			List<Pessoa> lista =  criteria.list();
			return lista;
		}
		return null;
	}

	// OK
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Endereco> getEnderecos(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		if (session.isOpen()) {
			session.getTransaction().begin();
			List<Endereco> mEnderecoLista  = sessionFactory.getCurrentSession().createCriteria(Endereco.class, "end")
					.add(Restrictions.eq("pessoa.id", id)).list();
			session.getTransaction().commit();
			return mEnderecoLista;
		}
		return null;
	}

	// NOT OK YET
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Telefone> getTelefones(int id) { //possivel modificacao
		Session session = sessionFactory.getCurrentSession();
		if (session.isOpen()) {
			session.getTransaction().begin();
			List<Telefone> mTelefoneLista= sessionFactory.getCurrentSession().createCriteria(Telefone.class, "tel")
					.add(Restrictions.eq("pessoa.id", id)).list();
			session.getTransaction().commit();
			return mTelefoneLista;
		}

		return null;
	}

	@Override
	@Transactional
	public void atualizar(Pessoa pessoa) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			//			System.out.println("Ta chegnado em inserir de endereco");
			session.getTransaction().begin();
			sessionFactory.getCurrentSession().update(pessoa);
			session.getTransaction().commit();
		}
	}

	@Override
	@Transactional
	public Pessoa getPessoaById(int id) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			//			System.out.println("Ta chegnado em inserir de endereco");
			session.getTransaction().begin();
			Pessoa p = (Pessoa) sessionFactory.getCurrentSession().get(Pessoa.class, id);
			session.getTransaction().commit();
			return p;
		}
		return null;
	}

	@Override
	@Transactional
	public int getPessoaId(String cpf) {
		Session session= sessionFactory.getCurrentSession();
		if (session.isOpen()){
			session.getTransaction().begin();
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Pessoa.class, "p");
			criteria.add(Restrictions.eq("p.cpf", cpf));
			criteria.setMaxResults(1);
			Professor result =  (Professor) criteria.uniqueResult();
			session.getTransaction().commit();
			return result.getId();
		}
		return -1;

	}

}
