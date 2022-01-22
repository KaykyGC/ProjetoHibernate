package visao;

import javax.swing.JOptionPane;

import modelo.Evento;
import modelo.Musico;
import dao.DaoMusico;

public class TelaMusico {
	public static void main(String[] args) throws Exception {
		int idMusico;
		String nome, opcao;
		do{
			try {
				opcao = JOptionPane.showInputDialog("Informe a a��o desejada:\n 1 - Incluir\n 2 - Alterar\n 3 - Excluir\n 4 - Consultar\n 5 - Sair ");
				DaoMusico dao = new DaoMusico();
				Musico musico = new Musico();
				switch(opcao){
				case "1":
					nome = JOptionPane.showInputDialog("Informe a nome do Musico");
					musico.setNome(nome);
					Evento e = new Evento();
					idMusico = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do Evento do Musico: "));
					e.setIdEvento(idMusico);
					musico.setEvento(e);
					dao.incluir(musico);
					JOptionPane.showMessageDialog(null, "M�sico incluido com sucesso!");
					break;
				case "2":
					idMusico = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do Musico a ser alterado: "));
					nome = JOptionPane.showInputDialog("Informe o nome do Musico ");
					musico = dao.consultar(idMusico);
					musico.setNome(nome);
					// o eveno est� sendo respeitado
					dao.alterar(musico);	
					JOptionPane.showMessageDialog(null, "M�sico alterado com sucesso!");
					break;
				case "3" :
					idMusico = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do Musico a excluido: "));
					musico.setIdMusico(idMusico);
					dao.excluir(musico);
					JOptionPane.showMessageDialog(null, "M�sico excluido com sucesso!");
					break;
				case "4":
					idMusico = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o i do Musico a ser consultado: "));
					Musico m = dao.consultar(idMusico);
					if (m != null){
						JOptionPane.showMessageDialog(null, "Dados do M�sico \n Id: " + m.getIdMusico() + 
							"\n Nome do M�sico: " + m.getNome() +
							"\n Id do M�sico: " + m.getIdMusico() + 
							"\n Nome do Evento do M�sico: " + m.getEvento().getNome() + 
							"\n Id do Evento do M�sico: " + m.getEvento().getIdEvento());
					}else{
						JOptionPane.showMessageDialog(null, "M�sico n�o cadastrado.");
					}
					break;
				case "5":
					System.exit(0);			
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "N�o foi poss�vel, ERRO: " + e.getMessage());
			}
		}while(0!=1);	
	}
}