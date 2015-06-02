package trabalhoPoo;

public class Livro implements InterfaceLivro{
	private String nomeLivro;
	private String tipoLivro;
	private boolean emprestado = false;		//variavel que define se o livro esta emprestado ou não 
	
	public void setNomeLivro(String nomeL){
		this.nomeLivro = nomeL;
	}
	
	public String getNomeLivro(){
		return nomeLivro;
	}
	
	public void setTipoLivro(String tipoL){
		this.tipoLivro = tipoL;
	}
	
	public String getTipoLivro(){
		return tipoLivro;
	}
	
	public void imprimeNomeLivro(){
		System.out.println(nomeLivro);
	}
	
	public void setEmprestado(boolean b){
		this.emprestado = b;
	}
	
	public boolean getEmprestado(){
		return emprestado;
	}
}

