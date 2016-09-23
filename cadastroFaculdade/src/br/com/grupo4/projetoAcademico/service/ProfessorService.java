package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.model.Telefone;

public interface ProfessorService {
	public void inserir(Professor professor);

	public List<Professor> listar();

	public Professor getProfessorById(int id);

	public void atualizar(Professor professor);

	public int getProfessorId(String cpf);
}