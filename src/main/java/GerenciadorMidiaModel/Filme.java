package GerenciadorMidiaModel;

public class Filme extends Midia{
	protected String idioma;
	
	public Filme(String local, long tamanho, String titulo, int duracao, String categoria, String idioma) {
		super(local, tamanho, titulo, duracao, categoria);
		this.idioma = idioma;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	@Override
	public String exibirAtributos() {
		return "Filme: " + getTitulo() + "| Idioma: " + idioma + "| Duração : " + getDuracao() + "min | Categoria: " + getCategoria();
	}

}
