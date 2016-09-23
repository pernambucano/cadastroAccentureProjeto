package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.grupo4.projetoAcademico.dao.PublicacaoDAO;
import br.com.grupo4.projetoAcademico.model.Publicacao;

@Service
@ManagedBean
@Transactional
public class PublicacaoServiceImpl implements PublicacaoService {

	private PublicacaoDAO publiDAO;

	public void setPublicDAO(PublicacaoDAO publiDAO) {
		this.publiDAO = publiDAO;
	}

	@Override
	public void inserir(Publicacao publicacao) {
		System.out.println("SUCESSO PARA PUBLICAÇÃO");
		publiDAO.inserir(publicacao);

	}

	@Override
	public List<Publicacao> listar() {
		return publiDAO.listar();
	}

	@Override
	public void atualizar(Publicacao publicacao) {
		publiDAO.atualizar(publicacao);

	}

	@Override
	public void remover(int id) {
		publiDAO.remover(id);

	}

	@Override
	public Publicacao getEnderecoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
