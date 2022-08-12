package agenda_v3;

import java.util.Scanner;

public class Agenda {
	
	Scanner leitor = new Scanner(System.in);

	private String[] nome = new String[10];
	private int[] idade = new int[10];
	private float[] altura = new float[10];
	private String opcao = "";
	private String resposta;
	private int posicao = 0;
	
	{
	for (int i = 0; i < 10; i++) {
		nome[i] = "";
		idade[i] = 0;
		altura[i] = 0;
	}
	}

	public String[] getNome() {
		return nome;
	}

	public void setNome(String[] nome) {
		this.nome = nome;
	}

	public int[] getIdade() {
		return idade;
	}

	public void setIdade(int[] idade) {
		this.idade = idade;
	}

	public float[] getAltura() {
		return altura;
	}

	public void setAltura(float[] altura) {
		this.altura = altura;
	}

	public void iniciarAgenda() {

		System.out.println("\n\n*************** AGENDA ***************");
		System.out.println("Informe a opção desejada:\nIncluir\nRemover\nBuscar\nImprimir Agenda\nImprimir Pessoa\nSair");
		opcao = leitor.nextLine();
		switch (opcao) {
		case "Incluir":
			armazenarPessoa();
			break;
		case "Remover":
			removerPessoa();
			break;
		case "Buscar":
			buscar();
			break;
		case "Imprimir Agenda":
			imprimirAgenda();
			break;
		case "Imprimir Pessoa":
			imprimirPessoa();
			break;
		case "Sair":
			sair();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!\nInforme uma opção válida!");
			break;
		}

	}

	public void armazenarPessoa() {
		do {
			System.out.print("\nNOME: ");
			nome[posicao] = leitor.nextLine();
			System.out.print("IDADE: ");
			idade[posicao] = leitor.nextInt();
			System.out.print("ALTURA: ");
			altura[posicao] = leitor.nextFloat();
			leitor.nextLine();
			System.out.println("\nCONTATO " + nome[posicao] + " INCLUÍDO COM SUCESSO!");
			System.out.print("\nDeseja incluir um novo contato: ");
			resposta = leitor.nextLine();

			posicao++;

		} while (resposta.equals("Sim"));
		iniciarAgenda();
	}

	public void removerPessoa() {

		//for (int i = 0; i < 10; i++) {
		//	nome[i] = "";
		//	idade[i] = 0;
		//	altura[i] = 0;
		//}

		System.out.print("\nInforme o nome do contato que deseja remover: ");
		resposta = leitor.nextLine();
		for (int i = 0; i < 10; i++) {
			if (nome[i].equals(resposta)) {
				nome[i] = "";
				idade[i] = 0;
				altura[i] = 0;
			}
		}
		System.out.println("\nCONTATO " + resposta + " ELIMINADO COM SUCESSO!");
		iniciarAgenda();
	}

	public void imprimirPessoa() {

		System.out.print("\nInforme o nome do contato que deseja buscar: ");
		resposta = leitor.nextLine();
		for (int i = 0; i < 10; i++) {
			if (resposta.equals(nome[i])) {
				System.out.println("\nNOME: " + nome[i]);
				System.out.println("IDADE: " + idade[i]);
				System.out.println("ALTURA: " + altura[i]);

				i++;
			}
		}
		iniciarAgenda();
	}

	public void imprimirAgenda() {
		System.out.println("\n\n*************** MEUS CONTATOS ***************");
		for (int i = 0; i < 10; i++) {
			if (altura[i] > 0) {
				System.out.println("\nNOME: " + nome[i]);
				System.out.println("IDADE: " + idade[i]);
				System.out.println("ALTURA: " + altura[i]);
			}
		}
		iniciarAgenda();
	}

	public void buscar() {
		System.out.print("Informe o nome do contato: ");
		resposta = leitor.nextLine();

		for (int i = 0; i < 10; i++) {
			if (resposta.equals(nome[i])) {
				System.out.println("Seu contato está na posição: " + i);
				i++;
			}	
		}
		iniciarAgenda();
	}

	public void sair() {
		System.out.println("PROGRAMA FINALIZADO!");
		return;
	}
}
