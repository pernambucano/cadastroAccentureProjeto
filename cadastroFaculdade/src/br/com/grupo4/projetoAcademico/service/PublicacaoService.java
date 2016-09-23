package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Publicacao;

public interface PublicacaoService {

	public void inserir(Publicacao publicacao);

	public List<Publicacao> listar();

	public void atualizar(Publicacao publicacao);

	public void remover(int id);

	public Publicacao getEnderecoById(int id);

}
