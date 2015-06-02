package trabalhoPoo;

public class TabelaEmprestimos {
	private String nomeUsuario;
	private String classificacaoUsuario;
	private String livroEmprestado;
	private String tipoLivroEmprestado;
	private String statusLivroEmprestado;
	
	public void setTabUsuario(String nomeU){
		this.nomeUsuario = nomeU;
	}
	
	public void setTabClass(String classificacaoU){
		this.classificacaoUsuario = classificacaoU;
	}
	
	public void setTabLivro(String livroE){
		this.livroEmprestado = livroE;
	}
	
	public void setTabTipoLivro(String tipoLivroE){
		this.tipoLivroEmprestado = tipoLivroE;
	}
	
	public void setTabStatusLivro(String statusLivroE){
		this.statusLivroEmprestado = statusLivroE;
	}
	
	public String getTabelaUsuario(){
		return nomeUsuario;
	}
	
	public String getTabelaClassUsuario(){
		return classificacaoUsuario;
	}
	
	public String getTabelaLivroEmp(){
		return livroEmprestado;
	}
	
	public String getTabelaTipoLivro(){
		return tipoLivroEmprestado;
	}
	
	public String getTabelaStatusLivro(){
		return statusLivroEmprestado;
	}
}
