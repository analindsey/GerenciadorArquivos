package GerenciadorMidiaModel;

public class Livro extends Midia {
	protected String autores;
	
	public Livro(String local, long tamanho, String titulo, int duracao, String categoria, String autores) {
		super(local, tamanho, titulo, duracao, categoria);
		this.autores = autores;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}
	
	@Override
	public String exibirAtributos() {
		return "Livro: " + getTitulo() + "| Autores: " + autores + " | Páginas: " + getDuracao() + "| Categoria: " + getCategoria();
	}

}
