package GerenciadorMidiaview.gerenciador;

import GerenciadorMidiaController.GerenciadorController;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;



public class GerenciadorGUI extends JFrame{
	private GerenciadorController controller = new GerenciadorController();
	private JTable tabela;
	private JTextArea areaListagem;
	
	public GerenciadorGUI() {
		setTitle("Gerenciador de Mídia");
		setSize(800,800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		//painel para ações:
		JPanel painelSuperior = new JPanel();
		JButton btnIncluir = new JButton("Incluir mídia selecionada");
		JButton btnEditar = new JButton("editar mídia selecionada");
		JButton btnRemover = new JButton("Remover mídia selecionada");
		JButton btnMover = new JButton("Mover mídia selecionada");
		
		add(painelSuperior, BorderLayout.NORTH);
		
		//estilizando os botões:
		Dimension tamanhoBotao = new Dimension(180,35);
		Font fonteBotao = new Font("Tahoma", Font.BOLD,12);
		Color corFundo = new Color(220,220,220);
		Color corTexto = Color.DARK_GRAY;
		
		btnIncluir.setPreferredSize(tamanhoBotao);
		btnIncluir.setFont(fonteBotao);
		btnIncluir.setBackground(corFundo);
		btnIncluir.setFocusPainted(false);
		btnIncluir.setBorder(BorderFactory.createRaisedBevelBorder());
		
		btnEditar.setPreferredSize(tamanhoBotao);
		btnEditar.setFont(fonteBotao);
		btnEditar.setBackground(corFundo);
		btnEditar.setFocusPainted(false);
		btnEditar.setBorder(BorderFactory.createRaisedBevelBorder());
		
		btnRemover.setPreferredSize(tamanhoBotao);
		btnRemover.setFont(fonteBotao);
		btnRemover.setBackground(corFundo);
		btnRemover.setFocusPainted(false);
		btnRemover.setBorder(BorderFactory.createRaisedBevelBorder());
		
		btnMover.setPreferredSize(tamanhoBotao);
		btnMover.setFont(fonteBotao);
		btnMover.setBackground(corFundo);
		btnMover.setFocusPainted(false);
		btnMover.setBorder(BorderFactory.createRaisedBevelBorder());
		
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
		long tamanho = Long.parseLong(JOptionPane.showInputDialog("Tamanho:"));
		String titulo = JOptionPane.showInputDialog("Título:");
		int duracao = Integer.parseInt(JOptionPane.showInputDialog("Duração:"));
		String categoria = JOptionPane.showInputDialog("Categoria:");
		String atributo = JOptionPane.showInputDialog("Idioma/Artista/Autores:");
		if(controller.incluirMidia(tipo, atributo, tamanho, titulo, duracao, categoria, atributo, atributo, atributo)) {
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
	

  public static void main( String[] args )
    {
        SwingUtilities.invokeLater(() -> {
        	GerenciadorGUI gui = new GerenciadorGUI();
        	gui.setVisible(true);
        });
    }
}
