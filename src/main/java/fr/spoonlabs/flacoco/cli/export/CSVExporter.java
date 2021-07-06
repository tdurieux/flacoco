package fr.spoonlabs.flacoco.cli.export;

import org.supercsv.io.CsvListWriter;
import org.supercsv.prefs.CsvPreference;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

public class CSVExporter implements FlacocoExporter {

	private static final CsvPreference csvPreference = new CsvPreference.Builder(CsvPreference.STANDARD_PREFERENCE).build();

	@Override
	public void export(Map<String, Double> results, OutputStreamWriter outputStream) throws IOException {
		// TODO: Using a CsvListWriter because CsvMapWriter had some issues. Ideally, we could use CsvMapWriter and reduce the complexity here
		CsvListWriter writer = new CsvListWriter(outputStream, csvPreference);
		for (Map.Entry<String, Double> entry : results.entrySet()) {
			writer.write(entry.getKey(), entry.getValue());
		}
		writer.close();
	}

	@Override
	public String extension() {
		return "csv";
	}
}
