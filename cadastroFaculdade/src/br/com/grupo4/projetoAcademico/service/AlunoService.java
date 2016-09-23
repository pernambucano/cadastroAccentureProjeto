package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Aluno;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Telefone;

public interface AlunoService {

	public void inserir(Aluno aluno);

	public List<Aluno> listar();

	public void atualizar(Aluno aluno);

	public Aluno getAlunoById(int id);

	public int getAlunoId(String cpf);

	public void remover(int id);
}
