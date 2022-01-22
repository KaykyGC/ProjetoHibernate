package visao;

import javax.swing.JOptionPane;

import modelo.Evento;
import modelo.Musico;
import dao.DaoEvento;

public class TelaEvento {
	public static void main(String[] args) throws Exception {
		int idEvento;
		String nome, opcao;
		do{
			try {
				opcao = JOptionPane.showInputDialog("Tela Evento\nInforme a ação desejada:\n 1 - Incluir\n 2 - Alterar\n 3 - Excluir\n 4 - Consultar\n 5 - Sair ");
				DaoEvento dao = new DaoEvento();
				Evento evento = new Evento();
				switch(opcao){
				case "1":
					idEvento = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do Evento a ser criado: "));
					evento.setIdEvento(idEvento);
					nome = JOptionPane.showInputDialog("Informe a descrição do Evento");
					evento.setNome(nome);
					dao.incluir(evento);
					JOptionPane.showMessageDialog(null, "Evento incluido com sucesso!");
					break;
				case "2":
					idEvento = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do Evento a ser alterado: "));
					evento.setIdEvento(idEvento);
					nome = JOptionPane.showInputDialog("Informe a descrição do Evento ");
					evento.setNome(nome);
					dao.alterar(evento);	
					JOptionPane.showMessageDialog(null, "Evento alterado com sucesso!");
					break;
				case "3" :
					idEvento = Integer.parseInt(JOptionPane.showInputDialog("Informe o id do Evento a excluido: "));
					evento.setIdEvento(idEvento);
					dao.excluir(evento);
					JOptionPane.showMessageDialog(null, "Evento excluido com sucesso!");
					break;
				case "4":
					idEvento = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o id do Evento a ser consultado: "));
					Evento ev = dao.consultar(idEvento);
					if (ev != null){
						String musicos = "";
						for(Musico musico : ev.getMusicos()){
							musicos = musicos + musico.getNome() + "\n";
						}
						JOptionPane.showMessageDialog(null, "Dados do evento" +
														"\n Id: " + ev.getIdEvento() + 
														"\n Descrição: " + ev.getNome() +
														"\n Musicos: " + musicos);
					}else{
						JOptionPane.showMessageDialog(null, "Evento não cadastrado.");
					}
					break;
				case "5":
					System.exit(0);			
				}// fim do swuitch		

			} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Não foi possível, ERRO: " + e.getMessage());
			}
		}while(0!=1);
	}
}