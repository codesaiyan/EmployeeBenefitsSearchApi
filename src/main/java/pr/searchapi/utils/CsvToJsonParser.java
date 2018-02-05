package pr.searchapi.utils;

import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class CsvToJsonParser {

	private static final String INPUT_CSV_FILE = "/home/pranavrao/Documents/PersonalCapitalWorkspace/EmployeeBenefitsSearchApi";

	private static final String OUTPUT_JSON_FILE = "/home/pranavrao/Documents/PersonalCapitalWorkspace/EmployeeBenefitsSearchApi/jsonData.json";

	public static void main(String[] args) throws Exception {

		File outputJsonFilePath = new File(OUTPUT_JSON_FILE);

		FileWriter writer = new FileWriter(outputJsonFilePath, true);

		Class.forName("org.relique.jdbc.csv.CsvDriver");

		Connection conn = DriverManager.getConnection("jdbc:relique:csv:" + INPUT_CSV_FILE);
		Statement stmt = conn.createStatement();
		String query = "SELECT * FROM csvdata";

		ResultSet results = stmt.executeQuery(query);
		ResultSetMetaData metadata = results.getMetaData();
		int numColumns = metadata.getColumnCount();
		int count = 1;
		while (results.next()) {
			JSONObject obj = new JSONObject();
			for (int i = 1; i <= numColumns; ++i) {
				String column_name = metadata.getColumnName(i);
				obj.put(column_name, results.getObject(column_name));
			}
			// Write the index metadata for the amazon es bulk upload json format
			writer.write(
					"{ \"index\" : { \"_index\": \"employeebenefits\", \"_type\" : \"employeebenefitplan\", \"_id\" : \""
							+ count + "\" } }\n");
			writer.write(obj.toString());
			writer.write("\n");
			count++;
		}
		writer.close();
		conn.close();
	}
}
