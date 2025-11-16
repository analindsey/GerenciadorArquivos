package GerenciadorMidiaModel;

public class Musica extends Midia {
	protected String artista;
	
	public Musica(String local, long tamanho, String titulo, int duracao, String categoria, String artista) {
		super(local, tamanho, titulo, duracao, categoria);
		this.artista = artista;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
	
	
	

}
