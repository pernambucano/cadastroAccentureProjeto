package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.grupo4.projetoAcademico.dao.EnderecoDAO;
import br.com.grupo4.projetoAcademico.model.Endereco;

@Service
@ManagedBean
@Transactional
public class EnderecoServiceImpl implements EnderecoService {

	private EnderecoDAO endDAO;

	public void setEndDAO(EnderecoDAO endDAO) {
		this.endDAO = endDAO;
	}

	@Override
	public void inserir(Endereco end) {
		endDAO.inserir(end);

	}

	@Override
	public List<Endereco> listar() {
		return endDAO.listar();
	}

	@Override
	public void atualizar(Endereco endereco) {
		endDAO.atualizar(endereco);

	}

	@Override
	public void remover(int id) {
		endDAO.remover(id);
	}

	@Override
	public Endereco getEnderecoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
