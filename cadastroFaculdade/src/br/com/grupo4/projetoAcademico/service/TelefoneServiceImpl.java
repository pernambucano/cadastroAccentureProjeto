
package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.grupo4.projetoAcademico.dao.TelefoneDAO;
import br.com.grupo4.projetoAcademico.model.Telefone;

@Service
@ManagedBean
@Transactional
public class TelefoneServiceImpl implements TelefoneService {

	private TelefoneDAO telDAO;

	public void setTelDAO(TelefoneDAO telDAO) {
		this.telDAO = telDAO;
	}

	@Override
	public void inserir(Telefone telefone) {
		telDAO.inserir(telefone);
	}

	@Override
	public List<Telefone> listar() {
		return this.telDAO.listar();
	}

	@Override
	public void atualizar(Telefone telefone) {
		this.telDAO.atualizar(telefone);

	}

	@Override
	public void remover(int id) {
		this.telDAO.remover(id);

	}

	@Override
	public Telefone getTelefoneById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
