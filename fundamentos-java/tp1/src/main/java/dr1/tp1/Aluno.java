package dr1.tp1;

/**
 *
 * @author jeanbreno
 */
import java.util.Scanner;
public class Aluno {

	private static String[] nomes;
	private static float[] av1;
	private static float[] av2;
	private static float[] media;
	
	private static int qtde = 0;

	private static final int QTDE_MAX = 5;
	
	private static void impressao(){
		System.out.println("******** Relatório de Alunos *******");
		for (int j = 0; j < qtde; j++) {
			impressao(j);
		}
		System.out.println("***********************************");
	}
	
	private static float calcularMedia(int idx){
		return (av1[idx] + av2[idx]) / 2;
	}
	
	private static String obterSituacao(float sl){
                if(sl < 4){
                    return "Reprovado";
                }
                if(sl >= 4 && sl < 7){
                    return "Prova final";
                }                
                return "Aprovado";
	}
	
	private static void impressao(int index){
		float media = calcularMedia(index);
		
		String situacao = obterSituacao(media);		

		System.out.println(
				index + " - Nome: " + 
				nomes[index] + " - AV1: " + 
				av1[index] + " - AV2: " + 
				av2[index] + " - Media: " +
                                media + " - Situacao: " +        
				situacao
				);
	}
	
	public static void main(String[] args){

		nomes = new String[QTDE_MAX];
		av1 = new float[QTDE_MAX];
		av2 = new float[QTDE_MAX];
		media = new float[QTDE_MAX];

		int opcao = 0;
		
		Scanner in = new Scanner(System.in);

		do {
                        System.out.println("***** SISTEMA DE CADASTRO DE ALUNOS *****");
			System.out.println("[1] Cadastrar aluno ");
			System.out.println("[2] Consultar dados de aluno");
			System.out.println("[3] Consultar todos");
			System.out.println("[4] Sair");
			System.out.println("Informe a opção desejada: ");
			opcao = in.nextInt();

			switch (opcao) {
			case 1:
				if(qtde < QTDE_MAX) {
					System.out.println("Informe o nome do aluno: ");
					nomes[qtde] = in.next();
					
					System.out.println("Informe a nota da AV1: ");
					av1[qtde] = in.nextInt();
					
					System.out.println("Informe a nota da AV2: ");
					av2[qtde] = in.nextFloat();

					System.out.println("Aluno " + nomes[qtde] + " adicionado com sucesso!");
					
					qtde++;
				} else {
					System.out.println("Nao foi possivel realizar o cadastramento.");
					System.out.println("A base de dados esta com a sua capacidade maxima de registros.");
				}
				break;

			case 2:
				System.out.println("Informe o código do aluno: ");
				int codigo = in.nextInt();

				if(codigo >= 0 && codigo < qtde) {
					impressao(codigo);
				} else {
					System.out.println("O código " + codigo + " de aluno é inválido!");
				}				
				break;

			case 3:
				impressao();			
				break;

			case 4:
				System.out.println("Encerrando a execucao...");
				break;

			default:
				System.out.println("Opção inválida!");
				break;
			}			
		} while (opcao != 4);
		
		in.close();
		
		System.out.println("Processamento finalizado!");
	}
}