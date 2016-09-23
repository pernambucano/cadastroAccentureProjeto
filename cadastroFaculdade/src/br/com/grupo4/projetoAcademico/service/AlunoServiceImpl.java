package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.grupo4.projetoAcademico.dao.AlunoDAO;
import br.com.grupo4.projetoAcademico.dao.AlunoDAOImpl;
import br.com.grupo4.projetoAcademico.model.Aluno;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Telefone;

@Service
@ManagedBean
@Transactional
public class AlunoServiceImpl implements AlunoService {

	private AlunoDAO alunDAO = AlunoDAOImpl.getInstance();

	public void setAlunDAO(AlunoDAO alunDAO) {
		this.alunDAO = alunDAO;
	}

	@Override
	public void inserir(Aluno aluno) {
		alunDAO.inserir(aluno);

	}

	@Override
	public List<Aluno> getAlunos() {
		return alunDAO.listar();
	}

	@Override
	public void atualizar(Aluno aluno) {
		alunDAO.atualizar(aluno);

	}

	@Override
	public void remover(int id) {
		alunDAO.remover(id);

	}

	@Override
	public Aluno getAlunoById(int id) {

		return alunDAO.getAlunoById(id);
	}

	@Override
	public int getAlunoId(String cpf) {
		return alunDAO.getAlunoId(cpf);
	}
}
