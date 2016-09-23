package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.grupo4.projetoAcademico.dao.PessoaDAO;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.Pessoa;
import br.com.grupo4.projetoAcademico.model.Telefone;

@Service
@ManagedBean
@Transactional
public class PessoaServiceImpl implements PessoaService {

	private PessoaDAO pesDAO;

	public void setPesDAO(PessoaDAO pesDAO) {
		this.pesDAO = pesDAO;
	}

	@Override
	public void inserir(Pessoa pessoa) {
		this.pesDAO.inserir(pessoa);

	}

	@Override
	public List<Pessoa> listar() {
		return this.pesDAO.listar();
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		pesDAO.atualizar(pessoa);
	}

	@Override
	public List<Endereco> getEnderecos(int id) {

		return this.pesDAO.getEnderecos(id);
	}

	@Override
	public List<Telefone> getTelefones(int id) {
		return pesDAO.getTelefones(id);
	}

	@Override
	public Pessoa getPessoaById(int id) {
		return pesDAO.getPessoaById(id);
	}

	@Override
	public int getPessoaId(String cpf) {
		return pesDAO.getPessoaId(cpf);

	}

}
