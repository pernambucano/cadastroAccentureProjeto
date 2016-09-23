package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Publicacao;

public interface PublicacaoDAO {
	public void inserir(Publicacao publicacao);
	public List<Publicacao> listar();
	public void atualizar(Publicacao publicacao);
	public void remover(int id);
	public Publicacao getPublicacaoById(int id);
}
