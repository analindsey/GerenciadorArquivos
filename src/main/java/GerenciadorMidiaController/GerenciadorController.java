package GerenciadorMidiaController;

import GerenciadorMidiaModel.Filme;
import GerenciadorMidiaModel.Livro;
import GerenciadorMidiaModel.Midia;
import GerenciadorMidiaModel.Musica;

import java.io.*;
import java.util.*;



public class GerenciadorController {
	private List<Midia> midias = new ArrayList<> ();
	private static final String arquivo = "midias.tpoo";
	
	public GerenciadorController() {
		carregarMidias();
	}
   //aqui é onde iremos incluir a mídia de acordo com seus formatos
	public boolean incluirMidia(String tipo, String local, long tamanho, String titulo, int duracao, String categoria, String idioma, String artista, String autores) {
		Midia midia = null;
		if(tipo.equals("Filme") && (local.endsWith(".mp4") || local.endsWith(".mkv"))) {
			midia = new Filme(local, tamanho, titulo, duracao, categoria, idioma);
		} else if(tipo.equals("Musica") && local.endsWith(".mp3")) {
			midia = new Musica(local, tamanho, titulo, duracao, categoria, artista);
		} else if(tipo.equals("Livro") && (local.endsWith(".pdf") || local.endsWith(".epub"))) {
			midia = new Livro(local, tamanho, titulo, duracao, categoria, autores);
		}
		if (midia != null) {
			midias.add(midia);
			salvarMidias();
			return true;
		}
		return false;
	}
	
	// aqui iremos editar a mídia
	
	public boolean editarMidia(int index, String titulo, int duracao, String categoria,String idioma, String artista, String autores) {
		
		if(index>= 0 && index < midias.size()) {
			Midia m = midias.get(index);
			m.setTitulo(titulo);
			m.setDuracao(duracao);
			m.setCategoria(categoria);
			if(m instanceof Filme) ((Filme) m).setIdioma(idioma);
			else if(m instanceof Musica) ((Musica) m).setArtista(artista);
			else if(m instanceof Livro) ((Livro) m).setAutores(autores);
			salvarMidias();
			return true;
			
		}
		return false;
	}
	// remover midia
	public boolean removerMidia(int index) {
		if(index >= 0 && index < midias.size()) {
			midias.remove(index);
			salvarMidias();
			return true;
		}
		return false;
	}
	//mover midia
	public boolean moverMidia(int index, String novoLocal) {
		if(index >= 0 && index < midias.size()) {
			Midia m = midias.get(index);
			File arquivo = new File(m.getLocal());
			File novoArquivo = new File(novoLocal);
			if(arquivo.renameTo(novoArquivo)) {
				m.setLocal(novoLocal);
				salvarMidias();
				return true;
			}
		}
		return false;
	}
	
	
//persistência
 private void salvarMidias() {
	 try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))){
	 oos.writeObject(midias);
	} catch (IOException e) {
		e.printStackTrace();
	}
	 
 }
 @SuppressWarnings("unchecked")
	private void carregarMidias() {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))){
			midias = (List<Midia>) ois.readObject();
		}catch (IOException | ClassNotFoundException e) {
			//ou dá erro ou o arquivo não existe
		}
		
		
	}
	
 public List<Midia> getMidias() {return midias;}
 
}
