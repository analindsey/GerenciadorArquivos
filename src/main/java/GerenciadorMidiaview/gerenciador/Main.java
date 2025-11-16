package GerenciadorMidiaview.gerenciador;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import GerenciadorMidiaController.GerenciadorController;

public class GerenciadorGUI extends JFrame{
	private GerenciadorController controller = new GerenciadorController();
	private JTable tabela;
	private JTextArea areaListagem;
	
	public GerenciadorGUI() {
		setTitle("Gerenciador de Mídia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//painel para ações:
		JPanel painelSuperior = new JPanel();
		JButton btnIncluir = new JButton("Incluir mídia");
		JButton btnEditar = new JButton("Editar mídia selecionada");
		JButton btnRemover = new JButton("Remover mídia selecionada");
		JButton btnMover = new JButton("Mover mídia selecionada");
		painelSuperior.add(btnIncluir);
		painelSuperior.add(btnEditar);
		painelSuperior.add(btnRemover);
		painelSuperior.add(btnMover);
		
		//área de listagem:
		areaListagem = new JTextArea();
		add(new JScrollPane(areaListagem), BorderLayout.CENTER);
		
		//listeners
		btnIncluir.addActionListener(e -> incluirMidia());
		btnEditar.addActionListener(e -> editarMidia());
		btnRemover.addActionListener(e -> removeAll());
		btnMover.addActionListener(e -> incluirMidia());
	}
	
	private void incluirMidia() {
		String tipo = JOptionPane.showInputDialog("Tipo (Filme/Musica/Livro):");
		String local = JOptionPane.showInputDialog("Local:");
		long tamanho = long.parseLong(JOptionPane.showInputDialog("Tamanho:"));
		String titulo = JOptionPane.showInputDialog("Título:");
		int duracao = Integer.parseInt(JOptionPane.showInputDialog("Duração:"));
		String categoria = JOptionPane.showInputDialog("Categoria:");
		String atributo = JOptionPane.showInputDialog("Idioma/Artista/Autores:");
		if(controller.incluirMidia(tipo, local, tamanho, titulo, duracao, categoria, atributo, atributo, atributo)) {
			JOptionPane.showMessageDialog(this, "Incluida com sucesso!");
		}else {
			JOptionPane.showMessageDialog(this, "Erro ao incluir mídia");
		}
	}
	private void editarMidia() {
		int index = Integer.parseInt(JOptionPane.showInputDialog("Indice da mídia: "));
		String titulo = JOptionPane.showInputDialog("Novo Título: ");
		int duracao = Integer.parseInt(JOptionPane.showInputDialog("Nova Duração:"));
		String categoria = JOptionPane.showInputDialog("Nova Categoria: ");
		String atributo = JOptionPane.showInputDialog("Novo Atributo:");
		controller.editarMidia(index, titulo, duracao, categoria, atributo, atributo, atributo);
	}
	private void removerMidia() {
		int index = Integer.parseInt(JOptionPane.showInputDialog("Indice da mídia:"));
		controller.removerMidia(index);
	}
	private void moverMidia() {
		int index = Integer.parseInt(JOptionPane.showInputDialog("índice da mídia:"));
		String novoLocal = JOptionPane.showInputDialog("Novo Local:");
		controller.moverMidia(index, novoLocal);
	}
	
}

public class Main 
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(() -> {
        	new GerenciadorGUI().setVisible(true);
        });
    }
}
