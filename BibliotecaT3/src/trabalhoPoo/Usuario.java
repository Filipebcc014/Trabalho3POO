package trabalhoPoo;

public class Usuario implements InterfaceUsuario{
	private String nome;
	private String categoria;		
	
	public void setNome(String n){
		this.nome = n;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setCategoriaUsuario(String c){
		this.categoria = c;
	}
	
	public String getCategoriaUsuario(){
		return categoria;
	}
	
	public void imprimeNomeUsuario(){
		System.out.println(nome);
	}
}