package br.com.grupo4.projetoAcademico.service;

import java.util.List;

import br.com.grupo4.projetoAcademico.model.Telefone;

public interface TelefoneService {

	public void inserir(Telefone telefone);

	public List<Telefone> listar();

	public void atualizar(Telefone telefone);

	public void remover(int id);

	public Telefone getTelefoneById(int id);
}
