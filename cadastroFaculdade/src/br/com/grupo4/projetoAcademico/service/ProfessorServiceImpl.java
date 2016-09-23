
package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.dao.ProfessorDAO;

@Service
@ManagedBean
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

	private ProfessorDAO profDAO;

	public void setProfessorDAO(ProfessorDAO profDAO) {
		this.profDAO = profDAO;
	}

	@Override
	public void inserir(Professor professor) {
		profDAO.inserir(professor);
	}

	@Override
	public void atualizar(Professor professor) {
		profDAO.atualizar(professor);

	}

	@Override
	public List<Professor> listar() {

		return profDAO.listar();
	}

	@Override
	public Professor getProfessorById(int id) {
		return profDAO.getProfessorById(id);
	}

	@Override
	public int getProfessorId(String cpf) {
		return profDAO.getProfessorId(cpf);
	}

}