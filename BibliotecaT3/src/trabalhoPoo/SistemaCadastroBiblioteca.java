package trabalhoPoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaCadastroBiblioteca {
	private Scanner teclado;					//teclado armazena as informações digitadas pelo usuário
	private boolean executando;					//variavel utilizada para informar e verificar se o programa esta sendo executado
	private List<Usuario> pessoas;				//lista que guarda os usuarios 
	private List<Livro> livroDaBiblioteca;		//lista que guarda as informações dos livros da biblioteca
	private File arqCSV;						//variavel do arquivo CSV a ser escrito
	private List<TabelaEmprestimos> tabela = new ArrayList<>();
	
	public static void main(String[] args) {
		new SistemaCadastroBiblioteca();		//chama o construtor da classe
	}
	
	public SistemaCadastroBiblioteca(){
		//inicializando as variaveis da classe
		teclado = new Scanner(System.in);
		executando = true;
		pessoas = new ArrayList<Usuario>();
		livroDaBiblioteca = new ArrayList<Livro>();
		
		//criando uma arquivo csv para guardar as informações dos emprestimos
		arqCSV = new File("TabelaEmprestimos.csv");
			try{
				arqCSV.createNewFile();	//cria o arquivo na pasta do programa
			}catch(IOException e){
				System.out.println("A tabela do sistema não foi criada.");
			}
		
		
		//iniciando a execução do sistema
		System.out.println("Sistema de Cadastro selecione uma opcao:");
		
		while(executando){
			String opcaoEscolhida = menuInicial();		//opcaoEscolhida recebe a letra digitada pelo usuario do sistema
			
			if(opcaoEscolhida.equalsIgnoreCase("u")){
				cadastrarUsuario();
				//colocaNoCSV(arqCSV);
			}else if(opcaoEscolhida.equalsIgnoreCase("l")){
				cadastrarLivro();
			}else if(opcaoEscolhida.equalsIgnoreCase("i")){
				imprimeUsuarios();
			}else if(opcaoEscolhida.equalsIgnoreCase("p")){
				imprimeLivros();
			}else if(opcaoEscolhida.equalsIgnoreCase("e")){
				emprestimo();
			}else if(opcaoEscolhida.equalsIgnoreCase("x")){
				executando = false;
			}else{
				System.out.println("Letra invalida");
			}
		}
	}
	
	//imprimindo o menu na tela
	 private String menuInicial(){  
	        //System.out.println("Selecione a opção da biblioteca BCC:");  
	        System.out.println("U - Novo cadastro de usuarios");  
	        System.out.println("L - Novo cadastro de livros");
	        System.out.println("I - Imprimir usuarios");
	        System.out.println("P - Imprimir livros");
	        System.out.println("E - Emprestimos");
	        System.out.println("X - Sair");  
	        return teclado.nextLine();   
	 }
	 
	 private void cadastrarUsuario(){
		 boolean cadastrandoUsuario = true;		//enquando verdadeiro fica no ciclo de cadastros
		
		 while(cadastrandoUsuario){
			 System.out.println("Cadastrando usuario:");
			 Usuario usu = new Usuario();
			 usu.setNome(entradaTexto("Nome do usuario:"));
			 usu.setCategoriaUsuario(entradaTexto("Categoria do usuario:"));
			 
			 String finalizarCadastro = entradaTexto("Adionar o cadastro a lista? <s/n>:");
			 
			 if(finalizarCadastro.equalsIgnoreCase("s")){
				 pessoas.add(usu);
				 System.out.println("Novo usuario adicionado.");
			 }else if(finalizarCadastro.equalsIgnoreCase("n")){
				 System.out.println("Cadastro cancelado.");
			 }
			
	         //verifica se mais usuarios irão se cadastrados
	         String continuaCadastrando = entradaTexto("Deseja cadastrar mais usuarios? <s/n>");		 
			 if(continuaCadastrando.equalsIgnoreCase("n")){
				 cadastrandoUsuario = false;
			 }
		 }
	 }
	 
	private void cadastrarLivro(){
		 boolean cadastrandoLivro = true;		//enquanto verdadeiro continua o ciclo para cadastrar livros
		
		 while(cadastrandoLivro){
			 System.out.println("Cadastrando livro:");
			 Livro livro = new Livro();
			 livro.setNomeLivro(entradaTexto("Nome do Livro:"));
			 livro.setTipoLivro(entradaTexto("Tipo do livro (texto/geral):"));
			 
			 String finalizarCadastroLivro = entradaTexto("Adionar livro a lista? <s/n>:");
			 
			 if(finalizarCadastroLivro.equalsIgnoreCase("s")){
				 livroDaBiblioteca.add(livro);
				 System.out.println("Novo livro adicionado.");
			 }else if(finalizarCadastroLivro.equalsIgnoreCase("n")){
				 System.out.println("Cadastro cancelado.");
			 }
			
	         //verifica se mais livros irão ser cadastrados
	         String continuaCadastrandoLivro = entradaTexto("Deseja cadastrar mais livros? <s/n>");		 
			 if(continuaCadastrandoLivro.equalsIgnoreCase("n")){
				 cadastrandoLivro = false;
			 }
		 }
	 }

	//metodo que recebe a string digitada pelo usuario do programa
	private String entradaTexto(String texto){
		 System.out.println(texto);
		 return teclado.nextLine();
	 }
	 
	
	/*private void colocaNoCSV(File arquivo){
		 
		 if(pessoas.size()!=0){
			 try{
				 FileWriter escreveCSV = new FileWriter(arquivo);
				 BufferedWriter escCSV = new BufferedWriter(escreveCSV);
				 escCSV.newLine();
				 
				 for(int i = 0; i<pessoas.size(); i++){
					 Usuario u = pessoas.get(i);
				 
					 escCSV.write(u.getNome());
					 escCSV.append(',');
					 escCSV.write(u.getCategoriaUsuario());
					 escCSV.append(',');
					 escCSV.newLine();       //escrever em uma nova linha
				 }
				 escCSV.close();
				 escreveCSV.close();
			 }catch(IOException e){
					 System.out.println("Não foi possivel escrever no arquivo CSV");	 
			 }
		 } 	 
	 }*/
	 
	//imprime apenas os usuarios
	private void imprimeUsuarios(){
		if(pessoas.size()!=0){
			for(int i=0; i<pessoas.size(); i++){
				Usuario u = pessoas.get(i);
				u.imprimeNomeUsuario();
			}
		}else{
			System.out.println("Não há usuarios cadastrados no sistema.");
		}	
	}
	
	//imprime apenas os livros da biblioteca
	private void imprimeLivros(){
		if(livroDaBiblioteca.size()!=0){
			for(int i=0; i<livroDaBiblioteca.size(); i++){
				Livro l = livroDaBiblioteca.get(i);
				l.imprimeNomeLivro();
			}
		}else{
			System.out.println("Não há livros cadastrados no sistema.");
		}
	}
	
	private void emprestimo(){
		boolean cadastradoAutorizado = false;		//verifica se quem quer um livro é cadastrado
		boolean livroEmprestado = false;			//verifica se o livro já foi emprestado
		String querEmprestado = entradaTexto("Escreva o nome de quem quer o emprestimo:");
		String livroAEmprestar;						//guarda o nome do livro que se quer emprestar 
		
		//variaveis locais
		String nome = null;
		String categoria = null;
		String lnome = null;
		String ltipo = null;
		String emprestado = null;
		
		//verifica se quem que levar um livro esta no cadastro
		for(int i=0; i<pessoas.size(); i++){
			Usuario u = pessoas.get(i);
			if(querEmprestado.equals(u.getNome())){
				cadastradoAutorizado = true;
				nome = u.getNome();
				categoria = u.getCategoriaUsuario();
				break;
			}
		}
		
		if(cadastradoAutorizado == false){
			System.out.println("Usuario não esta na lista de cadastro\n");
		}
		
		//se a pessoa for cadastrada, escolhe um livro
		if(cadastradoAutorizado == true){
			livroAEmprestar = entradaTexto("Qual livro quer emprestado?");
			for(int i=0; i<livroDaBiblioteca.size(); i++){
				Livro l = livroDaBiblioteca.get(i);
				if(livroAEmprestar.equalsIgnoreCase(l.getNomeLivro())){
					System.out.println("Emprestimo concluido.");
					livroEmprestado = true;
					
					l.setEmprestado(livroEmprestado);
					lnome = l.getNomeLivro();
					ltipo = l.getTipoLivro();
					emprestado = "Emprestado";
					break;
				}
			}
			
			//guarda as informações na tabela de cadastro
			TabelaEmprestimos tabEmp = new TabelaEmprestimos();
			tabEmp.setTabUsuario(nome);
			tabEmp.setTabClass(categoria);
			tabEmp.setTabLivro(lnome);
			tabEmp.setTabTipoLivro(ltipo);
			tabEmp.setTabStatusLivro(emprestado);
			tabela.add(tabEmp);

			//bloco que escreve todos os emprestimos no arquivo CSV
			 try{
					 FileWriter escreveCSV = new FileWriter(arqCSV);
					 PrintWriter escCSV = new PrintWriter(escreveCSV);
					 escCSV.println("Usuario, Classificação, Livro, Tipo Livro, Status");
					 
					 if(tabela.size()!=0){
						 for(int i=0; i<tabela.size(); i++){
							TabelaEmprestimos t = tabela.get(i);
							escCSV.println(t.getTabelaUsuario() + "," + t.getTabelaClassUsuario() + "," + t.getTabelaLivroEmp() + "," + t.getTabelaTipoLivro() + "," + t.getTabelaStatusLivro());
						 }
					 }
					 escCSV.close();
				 
			 }catch(IOException e){
					 System.out.println("Não foi possivel escrever no arquivo CSV");	 
			 }
		}
		
	}
	 
}