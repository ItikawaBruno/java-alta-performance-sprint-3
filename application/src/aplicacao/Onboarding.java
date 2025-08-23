package aplicacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import domain.Colaborador;
import listas.ListaCrescenteColaborador;

public class Onboarding {

	public static void main(String[] args) {

		Scanner le =new Scanner(System.in);
		ListaCrescenteColaborador lista =  new ListaCrescenteColaborador();
		geraLista(lista);

		

		int opcao;
		do {
			System.out.println("0 - Encerrar atendimento");
			System.out.println("1 - Obter colaboradores com piores notas presentes na lista");
			System.out.println("2 - Atualizar nota de um colaborador");
			System.out.println("3 - Inserir novo colaborador");
			System.out.println("Opcao: ");
			opcao = le.nextInt();
			le.nextLine();
			switch (opcao) {
				case 1:
					lista.show();
					break;
				case 2:
					System.out.println("Digite o ID do colaborador que deseja atualizar a nota: ");
					int id = le.nextInt();
					le.nextLine();
					System.out.println("Digite a nota atualizada: ");
					int nota = le.nextInt();
					le.nextLine();
					lista.atualiza(id, nota);
					break;
				case 3:
					System.out.println("Digite o ID do colaborador: ");
					int idColab = le.nextInt();
					System.out.println("Digite o nome do colaborador: ");
					String nome = le.next();
					System.out.println("Digite o setor do colaborador: ");
					String setor = le.next();
					System.out.println("Digite o nome do buddy: ");
					String buddy = le.next();
					le.next();
					System.out.println("Digite a nota do colaborador: ");
					int notaColab = le.nextInt();
					lista.add(new Colaborador(idColab,nome, buddy, setor, notaColab));
					break;
				case 0:
					System.out.println("Saindo...");
				default: System.out.println("Opcao Invalida");
			}

		} while (opcao != 0);

		le.close();

	}

	public static void geraLista(ListaCrescenteColaborador lista) {
		/*Altere esse metodo para inserir um objeto da classe Colaborador na lista*/
		try (Scanner leArq = new Scanner(Onboarding.class.getResourceAsStream("/arquivos/Colaboradores.txt"))) {

			// Loop para ler linha por linha at� o final do arquivo
			while (leArq.hasNextLine()) {
				// Ler a pr�xima linha
				String linha = leArq.nextLine();
				System.out.println(linha);
				String[] partes = linha.split(";");
				int id = Integer.parseInt(partes[0]);
				String nome = partes[1];
				String setor = partes[2];
				String buddy = partes[3];
				int nota = Integer.parseInt(partes[4]);
				lista.add(new Colaborador(id, nome, buddy, setor, nota));
			}
			// Fechar o objeto da classe Scanner le
			leArq.close();
		} catch (Exception e) {
			// Caso o arquivo n�o seja encontrado
			System.out.println("Arquivo n�o encontrado: " + e.getMessage());
		}
	}





}
