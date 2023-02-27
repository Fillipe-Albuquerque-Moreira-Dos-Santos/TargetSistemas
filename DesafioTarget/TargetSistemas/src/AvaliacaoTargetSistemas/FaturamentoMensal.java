package AvaliacaoTargetSistemas;

public class FaturamentoMensal {

	public static void main(String[] args) {

		// Definição dos valores de faturamento por estado
		double faturamentoSP = 67836.43;
		double faturamentoRJ = 36678.66;
		double faturamentoMG = 29229.88;
		double faturamentoES = 27165.48;
		double faturamentoOutros = 19849.53;

		// Cálculo do valor total mensal da distribuidora
		double faturamentoTotal = faturamentoSP + faturamentoRJ + faturamentoMG + 
								  faturamentoES + faturamentoOutros;

		// Cálculo do percentual de cada estado
		double percentualSP = (faturamentoSP / faturamentoTotal) * 100;
		double percentualRJ = (faturamentoRJ / faturamentoTotal) * 100;
		double percentualMG = (faturamentoMG / faturamentoTotal) * 100;
		double percentualES = (faturamentoES / faturamentoTotal) * 100;
		double percentualOutros = (faturamentoOutros / faturamentoTotal) * 100;

		// print dos resultados 
		System.out.println("Percentual de representação por estado:");
		System.out.printf("SP: %.2f%%\n", percentualSP);
		System.out.printf("RJ: %.2f%%\n", percentualRJ);
		System.out.printf("MG: %.2f%%\n", percentualMG);
		System.out.printf("ES: %.2f%%\n", percentualES);
		System.out.printf("Outros: %.2f%%\n", percentualOutros);
	}

}
