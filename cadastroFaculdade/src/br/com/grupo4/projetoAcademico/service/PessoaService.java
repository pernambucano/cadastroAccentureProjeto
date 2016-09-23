package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Pessoa;
import br.com.grupo4.projetoAcademico.model.Telefone;

public interface PessoaService {
	
	public void inserir(Pessoa pessoa);

	public List<Pessoa> listar();

	public List<Endereco> getEnderecos(int id);

	public List<Telefone> getTelefones(int id);

	public void atualizar(Pessoa pessoa);

	public Pessoa getPessoaById(int id);

	public int getPessoaId(String cpf);


}
