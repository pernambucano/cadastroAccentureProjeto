package br.com.grupo4.projetoAcademico.main;

import java.util.Date;
import java.util.List;


import br.com.grupo4.projetoAcademico.dao.AlunoDAOImpl;
import br.com.grupo4.projetoAcademico.dao.EnderecoDAOImpl;
import br.com.grupo4.projetoAcademico.dao.MeioComunicacaoDAOImpl;
import br.com.grupo4.projetoAcademico.dao.PessoaDAOImpl;
import br.com.grupo4.projetoAcademico.dao.ProfessorDAO;
import br.com.grupo4.projetoAcademico.dao.ProfessorDAOImpl;
import br.com.grupo4.projetoAcademico.dao.PublicacaoDAOImpl;
import br.com.grupo4.projetoAcademico.dao.TelefoneDAOImpl;
import br.com.grupo4.projetoAcademico.dao.TitulacaoDAOImpl;
import br.com.grupo4.projetoAcademico.model.Aluno;
import br.com.grupo4.projetoAcademico.model.Cidade;
import br.com.grupo4.projetoAcademico.model.Endereco;
import br.com.grupo4.projetoAcademico.model.MeioComunicacao;
import br.com.grupo4.projetoAcademico.model.Pessoa;
import br.com.grupo4.projetoAcademico.model.Professor;
import br.com.grupo4.projetoAcademico.model.Publicacao;
import br.com.grupo4.projetoAcademico.model.Sexo;
import br.com.grupo4.projetoAcademico.model.Telefone;
import br.com.grupo4.projetoAcademico.model.Titulacao;

public class Teste {

	public static void main(String[] args) {
		// Session session = HibernateUtil.getSessionFactory().openSession();
		// Transaction transaction = session.beginTransaction();
		// transaction.commit();
		//

		Teste t = new Teste();
		//		t.inserirPessoa();
		t.inserirAluno();

	}

	public void inserirProfessor() {

		int upper = 1000;
		int lower = 2;
		int randomNumberForCPF = (int) (Math.random() * (upper - lower)) + lower;
		String cpfTeste = Integer.toString(randomNumberForCPF);
		// Primeiro inserir os dados gerais de pessoa
		Pessoa p = new Professor(); 
		p.setCpf(cpfTeste);
		p.setNome("Pedrinho");
		p.setSexo(Sexo.M);

		Endereco nend = new Endereco();
		nend.setBairro("Bairro Novo");
		nend.setCidade(Cidade.OLINDA);
		nend.setLogradouro("rua 100");
		nend.setNumero(123);
		nend.setUf("PE");
		nend.setPessoa(p);

		Endereco nend2 = new Endereco();
		nend2.setBairro("Bairro Velho");
		nend2.setCidade(Cidade.OLINDA);
		nend2.setLogradouro("rua 20");
		nend2.setNumero(93);
		nend2.setUf("PE");
		nend2.setPessoa(p);

		Telefone telefone = new Telefone();
		telefone.setDdd(81);
		telefone.setNumero(36201482);
		telefone.setPessoa(p);


		// So então colocar os dados específicos de Professor
		Titulacao titulo = new Titulacao();
		titulo.setNomeTitulo("Professor");

		// Casting pra adicionar dados específicos do professor
		((Professor)p).setInstituicao("ufpe");
		((Professor)p).setDataAdmissao(new Date(System.currentTimeMillis()));
		((Professor)p).setTitulacao(titulo);

		// Efetivamente inserindo tudo no banco
		// Titulo vem primeiro porque professor precisa de um valor não nulo quando insere um titulo
		TitulacaoDAOImpl.getInstance().inserir(titulo);
		ProfessorDAOImpl.getInstance().inserir(((Professor)p));
		TelefoneDAOImpl.getInstance().inserir(telefone);
		EnderecoDAOImpl.getInstance().inserir(nend);
		EnderecoDAOImpl.getInstance().inserir(nend2);


		// Agora vamos testar os outros métodos
		System.out.println("----------------------------");
		System.out.println("O professor de cpf:" + cpfTeste);
		int professorId = ProfessorDAOImpl.getInstance().
				getProfessorId(cpfTeste);
		Professor mProfessor = ProfessorDAOImpl.getInstance().
				getProfessorById(professorId);
		System.out.println("Nome: " + mProfessor.getNome());
		System.out.println("Sexo: " + mProfessor.getSexo());
		System.out.println("Titulo: " + mProfessor.getTitulacao().getNomeTitulo());
		System.out.println("Instituição: " + mProfessor.getInstituicao());
		System.out.println("Data de Admissao: " + mProfessor.getDataAdmissao().toString());
		System.out.println("Enderecos: ");

		List<Endereco> listEnd = PessoaDAOImpl.getInstance().getEnderecos(professorId);
	
		for(Endereco endereco : listEnd){
			System.out.println(endereco.toString());
		}
		
		List<Telefone> listTel = PessoaDAOImpl.getInstance().getTelefones(professorId);
//		Set<Telefone> listTel = mProfessor.getTelefone();
		
		System.out.println("Telefones");
		
	
		for(Telefone telefone1 : listTel){
			System.out.println(telefone1.toString());
		}


	}

	public void inserirPessoa() {

		Pessoa a = new Pessoa();
		a.setCpf("1015382470");
		a.setNome("paulo");
		a.setSexo(Sexo.M);

		Endereco nend = new Endereco();
		nend.setBairro("Bairro Novo");
		nend.setCidade(Cidade.OLINDA);
		nend.setLogradouro("rua 2");
		nend.setNumero(123);
		nend.setUf("PE");
		nend.setPessoa(a);

		Telefone telefone = new Telefone();
		telefone.setDdd(81);
		telefone.setNumero(36211482);
		telefone.setPessoa(a);

		PessoaDAOImpl.getInstance().inserir(a);
		EnderecoDAOImpl.getInstance().inserir(nend);
		TelefoneDAOImpl.getInstance().inserir(telefone);

	}
	
	public void inserirAluno() {
		int upper = 1000;
		int lower = 2;
		int randomNumberForCPF = (int) (Math.random() * (upper - lower)) + lower;
		String cpfTeste = Integer.toString(randomNumberForCPF);
		
		
		int upper1 = 1000;
		int lower1 = 2;
		int randomNumberForCPF1 = (int) (Math.random() * (upper1 - lower1)) + lower1;
		int matric = randomNumberForCPF1;
		
		// Primeiro inserir os dados gerais de pessoa
		Pessoa a = new Aluno(); 
		a.setCpf(cpfTeste);
		a.setNome("Bruninha");
		a.setSexo(Sexo.F);
		
		ProfessorDAO profdao = new ProfessorDAOImpl();
		Professor professor = profdao.getProfessorById(1);
		System.out.println(professor.getNome());
		
		((Aluno)a).setMatricula(matric);
		((Aluno)a).setProfessor(professor);
		
		Endereco nend = new Endereco();
		nend.setBairro("Bairro Novo");
		nend.setCidade(Cidade.OLINDA);
		nend.setLogradouro("rua 100");
		nend.setNumero(123);
		nend.setUf("PE");
		nend.setPessoa(a);

		Endereco nend2 = new Endereco();
		nend2.setBairro("Bairro Velho");
		nend2.setCidade(Cidade.OLINDA);
		nend2.setLogradouro("rua 20");
		nend2.setNumero(93);
		nend2.setUf("PE");
		nend2.setPessoa(a);

		Telefone telefone = new Telefone();
		telefone.setDdd(81);
		telefone.setNumero(36201482);
		telefone.setPessoa(a);
		
		MeioComunicacao meio = new MeioComunicacao();
		meio.setDescricao("descricao do meio");
		
		Publicacao pub = new Publicacao();
		pub.setTitulo("Algum titulo");
		pub.setDescricao("descricao aqui");
		pub.setAluno((Aluno)a);
		pub.setMeioComunicacao(meio);
		pub.setProfessor(professor);
		
		
		MeioComunicacaoDAOImpl.getInstance().inserir(meio);
		AlunoDAOImpl.getInstance().inserir((Aluno)a);
		PublicacaoDAOImpl.getInstance().inserir(pub);
		
		// Agora vamos testar os outros métodos
				System.out.println("----------------------------");
				System.out.println("O aluno de cpf:" + cpfTeste);
				int alunoId = AlunoDAOImpl.getInstance().getAlunoId(cpfTeste);
				Aluno mAluno = AlunoDAOImpl.getInstance().getAlunoById(alunoId);
				System.out.println("Nome: " + mAluno.getNome());
				System.out.println("Sexo: " + mAluno.getSexo());
				System.out.println("Matricula: " + mAluno.getMatricula());
				System.out.println("Professor: " + mAluno.getProfessor().getNome());
				System.out.println("cpf: " + mAluno.getCpf());
//				System.out.println("Enderecos: ");
		
				/*List<Publicacao> listPub = PublicacaoDAOImpl.getInstance().getPublicacaoById(alunoId);
				Hibernate.initialize(listPub);
				for(Publicacao publicacao : listPub){
					System.out.println(publicacao.toString());
				}*/
				
	}

}