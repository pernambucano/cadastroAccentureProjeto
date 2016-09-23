package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.grupo4.projetoAcademico.dao.TitulacaoDAO;
import br.com.grupo4.projetoAcademico.model.Titulacao;

@Service
@ManagedBean
@Transactional
public class TitulacaoServiceImpl implements TitulacaoService {

	private TitulacaoDAO tituDAO;

	public void setTituDAO(TitulacaoDAO tituDAO) {
		this.tituDAO = tituDAO;
	}

	@Override
	public void inserir(Titulacao titulacao) {
		System.out.println("SUCESSO PARA TITULAÇÃO");
		tituDAO.inserir(titulacao);
	}

	@Override
	public List<Titulacao> listar() {
		return tituDAO.listar();
	}

	@Override
	public void atualizar(Titulacao titulacao) {
		this.tituDAO.atualizar(titulacao);

	}

	@Override
	public void remover(int id) {
		this.tituDAO.remover(id);

	}

	@Override
	public Titulacao getTitulacaoById(int id) {

		return tituDAO.getTitulacaoById(id);
	}

}
