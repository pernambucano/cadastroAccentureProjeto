package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Endereco;

public interface EnderecoService {

	public void inserir(Endereco end);

	public List<Endereco> listar();

	public void atualizar(Endereco endereco);

	public void remover(int id);

	public Endereco getEnderecoById(int id);
}
