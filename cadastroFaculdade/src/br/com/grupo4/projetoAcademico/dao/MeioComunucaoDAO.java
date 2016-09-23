package br.com.grupo4.projetoAcademico.dao;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.MeioComunicacao;
import br.com.grupo4.projetoAcademico.model.Titulacao;

public interface MeioComunucaoDAO {

	public void inserir(MeioComunicacao meioComunicacao);
	public List<MeioComunicacao> listar();
	public void atualizar(MeioComunicacao titulacao);
	public void remover(int id);
	public MeioComunicacao getMeioComunicacaoById(int id);
}
