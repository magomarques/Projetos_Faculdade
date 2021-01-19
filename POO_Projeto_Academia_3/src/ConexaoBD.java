import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class ConexaoBD {
	
	static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	static SimpleDateFormat sdhora = new SimpleDateFormat("HH:mm:ss");

	static Connection conexao = null;
	static Statement declaracao = null;
	static ResultSet resultado = null;

	public void conectar() {
		String url = "jdbc:sqlserver://LINDA-PC:777;databaseName=POO_PROJETO_ACADEMIA";
		
		try {
			conexao = DriverManager.getConnection(url, "sa", "021105");			
			declaracao = conexao.createStatement();
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
	}
		
	public boolean isConected() {
		if (conexao != null) {
			return true;
		} else {
			return false;
		}
	}

	public void desconectar() {
		try {
			if (isConected()) {
				conexao.close();				
			}
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}		
	}
	
	public void cadastrarAluno(Aluno aluno) {
		conectar();
		try {
			String dia = formato.format(aluno.getDataMatricula()).substring(0, 2);
			String mes = formato.format(aluno.getDataMatricula()).substring(3, 5);
			String ano = formato.format(aluno.getDataMatricula()).substring(6, 10);
			String dataMatriculaFormatada = ano + "-" + mes + "-" + dia;
			
			dia = formato.format(aluno.getDataNascimento()).substring(0, 2);
			mes = formato.format(aluno.getDataNascimento()).substring(3, 5);
			ano = formato.format(aluno.getDataNascimento()).substring(6, 10);
			String dataNascimentoFormatada = ano + "-" + mes + "-" + dia;
			
    		String query = "INSERT INTO ALUNO (DATA_DA_MATRICULA,NOME,ENDERECO,TELEFONE,DATA_DE_NASCIMENTO,ALTURA,PESO)"
    				+ "VALUES ('" + dataMatriculaFormatada + "','" + aluno.getNome() + "','" + aluno.getEndereco() + "',"
    				+ "'" + aluno.getTelefone() + "','" + dataNascimentoFormatada + "','" + aluno.getAltura() + "','" + aluno.getPeso() + "')";
    		
    		PreparedStatement inserir = conexao.prepareStatement(query);
		    inserir.executeUpdate();
		    
		    System.out.println("--------------------------------------------------");
			System.out.println("Aluno cadastrado com sucesso.");
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}		
		finally {
			desconectar();
		}							
	}

	public void informarMatricula(String nome) {
		conectar();
		try {
		    String query = "SELECT MATRICULA_DO_ALUNO FROM ALUNO WHERE NOME = '" + nome + "'";
			
			PreparedStatement pesquisa = conexao.prepareStatement(query);
			ResultSet resultado = pesquisa.executeQuery();
			
			while (resultado.next()) {	
		    System.out.println("--------------------------------------------------");
		    int matricula = resultado.getInt("MATRICULA_DO_ALUNO");
		    System.out.println("Matrícula.........: " + matricula);
			}
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}		
		finally {
			desconectar();
		}							
	}
	
	public void listarAlunos() {
		conectar();
		try {
		    String query = "SELECT MATRICULA_DO_ALUNO, NOME FROM ALUNO";
			
			PreparedStatement pesquisa = conexao.prepareStatement(query);
			ResultSet resultado = pesquisa.executeQuery();
			
			System.out.println("--------------- Listagem de Alunos ---------------");
		    System.out.println("--------------------------------------------------");
		    System.out.println("Mat. - Nome");
			while (resultado.next()) {
		    int matricula = resultado.getInt("MATRICULA_DO_ALUNO");
		    String nome = resultado.getString("NOME");
		    System.out.printf("%3d  - %-20s\n", matricula, nome);
			}
			System.out.println("--------------------------------------------------");
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}		
		finally {
			desconectar();
		}							
	}
	
	public void cadastrarInstrutor(Instrutor instrutor) {
		conectar();
		try {
			String dia = formato.format(instrutor.getDataNascimento()).substring(0, 2);
			String mes = formato.format(instrutor.getDataNascimento()).substring(3, 5);
			String ano = formato.format(instrutor.getDataNascimento()).substring(6, 10);
			String dataNascimentoFormatada = ano + "-" + mes + "-" + dia;
			
    		String query = "INSERT INTO INSTRUTOR (NOME,DATA_DE_NASCIMENTO,RG,TITULACAO)"
    				+ "VALUES ('" + instrutor.getNome() + "','" + dataNascimentoFormatada + "','" + instrutor.getRg() + "','" + instrutor.getTitulacao() + "')";
    		
    		PreparedStatement inserir = conexao.prepareStatement(query);
		    inserir.executeUpdate();
		    
		    System.out.println("--------------------------------------------------");
			System.out.println("Instrutor cadastrado com sucesso.");
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}		
		finally {
			desconectar();
		}							
	}
	
	public void cadastrarAtividade(Atividade atividade) {
		conectar();
		try {
    		String query = "INSERT INTO ATIVIDADE (NOME_DA_ATIVIDADE) VALUES ('" + atividade.getNomeAtividade() + "')";
    		
    		PreparedStatement inserir = conexao.prepareStatement(query);
		    inserir.executeUpdate();
		    
		    System.out.println("--------------------------------------------------");
			System.out.println("Atividade cadastrada com sucesso.");
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}		
		finally {
			desconectar();
		}							
	}	
	
	public void consultarAtividade() {

		conectar();
		try {
			String query = "SELECT * FROM ATIVIDADE";
			PreparedStatement pesquisa = conexao.prepareStatement(query);
			ResultSet resultado = pesquisa.executeQuery();
			
			boolean valido = false;
			
			while (resultado.next()) {
				int codAtividade = resultado.getInt("COD_ATIVIDADE");
				String nomeAtividade = resultado.getString("NOME_DA_ATIVIDADE");
				System.out.println("Código da atividade: " + codAtividade);
				System.out.println("Nome da atividade..: " + nomeAtividade);
				System.out.println("--------------------------------------------------");
				valido = true;
			}
			
			if (valido == false) {
				System.out.println("Atividade não encontrada.");
			}
			
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
		finally {
			desconectar();
		}							
	}
	
	public void alterarAtividade(int codigo, String nomeAtividade) {
		conectar();
		try {
    		String query = "UPDATE ATIVIDADE SET NOME_DA_ATIVIDADE = '" + nomeAtividade + "' WHERE COD_ATIVIDADE = '" + codigo + "'";
		    PreparedStatement alterar = conexao.prepareStatement(query);
		    alterar.executeUpdate();
		    System.out.println("--------------------------------------------------");
			System.out.println("Atividade alterada com sucesso.");
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}		
		finally {
			desconectar();
		}							
	}	
	
	public void excluirAtividade(int codigo) {
		conectar();
		try {
			String query = "DELETE FROM ATIVIDADE WHERE COD_ATIVIDADE = " + codigo + ";";
		    PreparedStatement inserir = conexao.prepareStatement(query);
		    inserir.executeUpdate();
		    System.out.println("--------------------------------------------------");
			System.out.println("Atividade excluída com sucesso.");
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}		
		finally {
			desconectar();
		}							
	}
	
	public void cadastrarAgendamento(int matricula, Agendamento agendamento) {
		conectar();
		try {
			String dia = formato.format(agendamento.getDataAgendamento()).substring(0, 2);
			String mes = formato.format(agendamento.getDataAgendamento()).substring(3, 5);
			String ano = formato.format(agendamento.getDataAgendamento()).substring(6, 10);
			String dataAgendamentoFormatada = ano + "-" + mes + "-" + dia;
			
			String hora = sdhora.format(agendamento.getHoraAgendamento()).substring(0, 2);
			String min  = sdhora.format(agendamento.getHoraAgendamento()).substring(3, 5);
			String seg  = sdhora.format(agendamento.getHoraAgendamento()).substring(6, 8);
			String horaFormatada = hora + ":" + min + ":" + seg;
			
    		String query = "INSERT INTO AGENDAMENTO (DATA,HORARIO,FK_ALUNO)"
    				+ "VALUES ('" + dataAgendamentoFormatada + "','" + horaFormatada + "','" + matricula + "')";
    		
    		PreparedStatement inserir = conexao.prepareStatement(query);
		    inserir.executeUpdate();
		    
		    System.out.println("--------------------------------------------------");
			System.out.println("Agendamento cadastrado com sucesso.");
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}		
		finally {
			desconectar();
		}							
	}
	
	public void registrarMatricula(int matricula, Contrato contrato) {
		conectar();
		try {
			String dia = formato.format(contrato.getDataInicio()).substring(0, 2);
			String mes = formato.format(contrato.getDataInicio()).substring(3, 5);
			String ano = formato.format(contrato.getDataInicio()).substring(6, 10);
			String dataInicioFormatada = ano + "-" + mes + "-" + dia;
			
			dia = formato.format(contrato.getDataTermino()).substring(0, 2);
			mes = formato.format(contrato.getDataTermino()).substring(3, 5);
			ano = formato.format(contrato.getDataTermino()).substring(6, 10);
			String dataTerminoFormatada = ano + "-" + mes + "-" + dia;
			
    		String query = "INSERT INTO CONTRATO (PLANO,DATA_DE_INICIO,DATA_DE_TERMINO,FK_ALUNO,FINANCEIRO)"
    				+ "VALUES ('" + contrato.getPlano() + "','" + dataInicioFormatada + "','" + dataTerminoFormatada + "',"
    				+ "'" + matricula + "','" + matricula + "')";
    		
    		PreparedStatement inserir = conexao.prepareStatement(query);
		    inserir.executeUpdate();
		    
		    System.out.println("--------------------------------------------------");
			System.out.println("Matricula registrada com sucesso.");
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}		
		finally {
			desconectar();
		}							
	}
	
	public void consultarMatricula(int matricula) {

		conectar();
		try {
			String query = "SELECT * FROM ALUNO WHERE MATRICULA_DO_ALUNO = '" + matricula + "'";
			PreparedStatement pesquisa = conexao.prepareStatement(query);
			ResultSet resultado = pesquisa.executeQuery();
			
			boolean valido = false;
			
			while (resultado.next()) {
				String nomeAluno = resultado.getString("NOME");
				
				String dia = resultado.getString("DATA_DA_MATRICULA").substring(8, 10);
				String mes = resultado.getString("DATA_DA_MATRICULA").substring(5, 7);
				String ano = resultado.getString("DATA_DA_MATRICULA").substring(0, 4);
				String dataMatriculaFormatada = dia + "/" + mes + "/" + ano;
				
				String endereco = resultado.getString("ENDERECO");
				String telefone = resultado.getString("TELEFONE");
				
				dia = resultado.getString("DATA_DE_NASCIMENTO").substring(8, 10);
				mes = resultado.getString("DATA_DE_NASCIMENTO").substring(5, 7);
				ano = resultado.getString("DATA_DE_NASCIMENTO").substring(0, 4);
				String dataNascimentoFormatada = dia + "/" + mes + "/" + ano;
				
				System.out.println("Nome...............: " + nomeAluno);
				System.out.println("Data da matrícula..: " + dataMatriculaFormatada);
				System.out.println("Endereço...........: " + endereco);
				System.out.println("Telefone...........: " + telefone);
				System.out.println("Data de nascimento.: " + dataNascimentoFormatada);
				System.out.println("");
				valido = true;
			}
			
			if (valido == false) {
				System.out.println("--------------------------------------------------");
				System.out.println("Matrícula não encontrada.");
			}
			
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
		finally {
			desconectar();
		}							
	}
	
	public void consultarContrato(int matricula) {

		conectar();
		try {
			String query = "SELECT * FROM CONTRATO WHERE FK_ALUNO = '" + matricula + "'";
			PreparedStatement pesquisa = conexao.prepareStatement(query);
			ResultSet resultado = pesquisa.executeQuery();
			
			boolean valido = false;
			
			while (resultado.next()) {
				int codContrato = resultado.getInt("COD_CONTRATO");
				String plano = resultado.getString("PLANO");
				
				String dia = resultado.getString("DATA_DE_INICIO").substring(8, 10);
				String mes = resultado.getString("DATA_DE_INICIO").substring(5, 7);
				String ano = resultado.getString("DATA_DE_INICIO").substring(0, 4);
				String dataInicioFormatada = dia + "/" + mes + "/" + ano;
				
				dia = resultado.getString("DATA_DE_TERMINO").substring(8, 10);
				mes = resultado.getString("DATA_DE_TERMINO").substring(5, 7);
				ano = resultado.getString("DATA_DE_TERMINO").substring(0, 4);
				String dataTerminoFormatada = dia + "/" + mes + "/" + ano;
				
				System.out.println("Código do contrato.: " + codContrato);
				System.out.println("Plano..............: " + plano);
				System.out.println("Data de início.....: " + dataInicioFormatada);
				System.out.println("Data de término....: " + dataTerminoFormatada);
				System.out.println("--------------------------------------------------");
				valido = true;
			}
			
			if (valido == false) {
				System.out.println("--------------------------------------------------");
				System.out.println("Matrícula não registrada.");
			}
			
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
		finally {
			desconectar();
		}							
	}
	
	public void consultarAgendamento(int matricula) {

		conectar();
		try {
			String query = "SELECT * FROM AGENDAMENTO WHERE FK_ALUNO = '" + matricula + "'";
			PreparedStatement pesquisa = conexao.prepareStatement(query);
			ResultSet resultado = pesquisa.executeQuery();
			
			boolean valido = false;
			
			while (resultado.next()) {
				int codAgendamento = resultado.getInt("COD_AGENDAMENTO");
				
				String dia = resultado.getString("DATA").substring(8, 10);
				String mes = resultado.getString("DATA").substring(5, 7);
				String ano = resultado.getString("DATA").substring(0, 4);
				String dataAgendamentoFormatada = dia + "/" + mes + "/" + ano;
				
				String horario = resultado.getString("HORARIO").substring(0, 8);
						
				System.out.println("Código do agendamento: " + codAgendamento);
				System.out.println("Data.................: " + dataAgendamentoFormatada);
				System.out.println("Horário..............: " + horario);
				System.out.println("--------------------------------------------------");
				valido = true;
			}
			
			if (valido == false) {
				System.out.println("Não há agendamento registrado.");
			}
			
		}
		catch(Exception erro) {
			System.out.println("Erro: " + erro.getMessage());
		}
		finally {
			desconectar();
		}							
	}		
}