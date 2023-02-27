package FaturamentoJson;

import java.io.FileReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Faturamento_Mensal_Distribuidora {

	public static void main(String[] args) throws Exception {
		
		// Ler o vetor de faturamento diário a partir do arquivo JSON externo
		JSONArray faturamentoJson = (JSONArray) new JSONParser().parse(new FileReader("faturamento_mensal.json"));
		int[] faturamento = new int[faturamentoJson.size()];
		int numDiasUteis = 0;
		int totalFaturamentoUteis = 0;
		for (int i = 0; i < faturamentoJson.size(); i++) {
			JSONObject obj = (JSONObject) faturamentoJson.get(i);
			String dataStr = (String) obj.get("data");
			int valor = ((Long) obj.get("valor")).intValue();
			LocalDate data = LocalDate.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			if (data.getDayOfWeek() != DayOfWeek.SATURDAY && data.getDayOfWeek() != DayOfWeek.SUNDAY
					&& !isFeriado(data)) {
				faturamento[numDiasUteis] = valor;
				numDiasUteis++;
				totalFaturamentoUteis += valor;
			}
		}

		// Calcular o menor e o maior valor de faturamento diário do mês
		int menor = faturamento[0];
		int maior = faturamento[0];
		for (int i = 1; i < numDiasUteis; i++) {
			if (faturamento[i] < menor) {
				menor = faturamento[i];
			}
			if (faturamento[i] > maior) {
				maior = faturamento[i];
			}
		}
		System.out.println("Menor valor de faturamento diário do mês: " + menor);
		System.out.println("Maior valor de faturamento diário do mês: " + maior);

		// Calcular a média mensal de faturamento diário (considerando apenas dias
		// úteis)
		double media = (double) totalFaturamentoUteis / numDiasUteis;

		// Contar quantos dias tiveram um valor de faturamento diário superior à média
		// mensal
		int acimaMedia = 0;
		for (int i = 0; i < numDiasUteis; i++) {
			if (faturamento[i] > media) {
				acimaMedia++;
			}
		}
		System.out.println("Número de dias no mês em que o valor de faturamento diário foi superior à média mensal levando em consideração os finais de semana e os feriados é de: "
				+ acimaMedia);
	}
}