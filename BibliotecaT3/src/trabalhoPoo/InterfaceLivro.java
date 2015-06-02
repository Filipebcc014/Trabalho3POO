package trabalhoPoo;

public interface InterfaceLivro {
	public void setNomeLivro(String nomeL);
	public String getNomeLivro();
	public void setTipoLivro(String tipoL);
	public String getTipoLivro();
	public void imprimeNomeLivro();
	public void setEmprestado(boolean b);
	public boolean getEmprestado();
}