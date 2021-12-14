import java.util.Scanner;

import org.cep.WebServiceCep;

public class Main {
    
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
	    int opcao = 2;
	    do {
	      System.out.println("\nEscolha uma opcao:\n1) Pesquisar CEP\n0) Sair");
	      opcao = scanner.nextInt();
	      scanner.nextLine();

	      switch (opcao) {
	        case 1:
	          System.out.println("Informe o CEP (00000-000):");
	          String cep = scanner.nextLine();
	          WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);
	          
	          if (webServiceCep.wasSuccessful()) {
	  			System.out.println("Cep: "+webServiceCep.getCep());
	  			System.out.println("Logradouro: "+webServiceCep.getLogradouroFull());
	  			System.out.println("Bairro: "+webServiceCep.getBairro());
	  			System.out.println("Cidade: "+
	  					webServiceCep.getCidade()+"/"+ webServiceCep.getUf());
	  			
	  		} else {
	  			System.out.println("Erro número: " + webServiceCep.getResulCode());
	  			System.out.println("Descrição do erro: " + webServiceCep.getResultText());
	  		}
	          break;
	          
	        case 0:
	          System.out.println("Programa Encerrado!");
	          break;
	        default:
	          System.out.println("Opcão Invalida!");
	          break;
	      }
	    } while (opcao != 0);
	    scanner.close();
			
	}   
}