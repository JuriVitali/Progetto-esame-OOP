package filters;

import java.util.Iterator;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Data;
import model.Record;
import util.DateOperations;

public class RecordFilterManagement {
	private static FiltersApplication app = new FiltersApplicationImpl();
	
	//ParseException viene lanciata se il body non è convertibie in JsonObject
	public static Vector<Record> parseBody(String filtro, Vector<Record> notFilteredArray, int rotta) throws ParseException {
		Vector<Record> filteredArray = new Vector<Record>();
		JSONParser parser = new JSONParser();
		JSONObject body = (JSONObject) parser.parse(filtro);
		if(body.containsKey("and")) {
			JSONArray elencoFiltri = (JSONArray) body.get("and"); 
			filteredArray = andMultipleFilterApplicator(elencoFiltri, notFilteredArray, rotta);
		}
		else if(body.containsKey("or")) {
			JSONArray elencoFiltri = (JSONArray) body.get("or"); 
			filteredArray = orMultipleFilterApplicator(elencoFiltri, notFilteredArray, rotta);
		}
			else 
				switch(rotta) { 
					case 4:filteredArray= singleFilterApplicatorRotta4(body,notFilteredArray);break;
					case 5:filteredArray= singleFilterApplicatorRotta5(body,notFilteredArray);break;
					case 6:filteredArray= singleFilterApplicatorRotta6(body,notFilteredArray);break;
				}
		if (rotta==5 || rotta==6) filteredArray = DeleteDuplicatesCities(filteredArray);
		return filteredArray;
	}
	

	

	/*Vector<Record> orMultipleFilterApplication (Object filtri(array di filtri), vector da filtrare , elemento che indica la rotta)
	 * crea un record filtrato.
	 * Per ogni filtro chiama l'applicatore di filtri singoli (passando il vector da filtrare )che ritorna un Vector di record filtrato 
	 *  Il vector filtrato prende gli elementi del vector che ritorna il filtro se non li conteneva già.
	 * Ritorna il Vector filtrato
	 */
	private static Vector<Record> orMultipleFilterApplicator (JSONArray filtri, Vector<Record> notFilteredArray,int rotta){
		Vector<Record> finalArray = new Vector<Record>();
		Vector<Record> filteredArray = new Vector<Record>();
		JSONObject filtro = new JSONObject();
		for (Object o : filtri) {
			filtro = (JSONObject) o;
			switch(rotta) {
			case 4:filteredArray= singleFilterApplicatorRotta4(filtro,notFilteredArray);break;
			case 5:filteredArray= singleFilterApplicatorRotta5(filtro,notFilteredArray);break;
			case 6:filteredArray= singleFilterApplicatorRotta6(filtro,notFilteredArray);break;
			}
			finalArray.removeAll(filteredArray);
			finalArray.addAll(filteredArray);
		}
		return finalArray;
	}
	
	/*Vector<Record> andMultipleFilterApplication (Object filtri(array di filtri), record da parsare , elemento che indica la rotta)
	 * crea un vector di record filtrato.
	 * Il vector filtrato inizialmente prende il record da parsare
	 * Per ogni filtro chiama l'applicatore di filtri singoli(passandogli il vector filtrato, il filtro e la rotta) che ritorna un Vector di record filtrato
	 *  Il vector filtrato prende gli elementi del vector che ritorna il filtro.
	 * Ritorna il Vector filtrato
	 */
	private static Vector<Record> andMultipleFilterApplicator (JSONArray filtri, Vector<Record> notFilteredArray,int rotta){
		Vector<Record> filteredArray = notFilteredArray;
		JSONObject filtro = new JSONObject();
		for (Object o : filtri) {
			filtro = (JSONObject) o;
			switch(rotta) {
			case 4:filteredArray= singleFilterApplicatorRotta4(filtro,filteredArray);break;
			case 5:filteredArray= singleFilterApplicatorRotta5(filtro,filteredArray);break;
			case 6:filteredArray= singleFilterApplicatorRotta6(filtro,filteredArray);break;
			}
		}
		return filteredArray;
	}

	
	
	public static Vector<Record> singleFilterApplicatorRotta4 (JSONObject filtro, Vector<Record> notFilteredArray){
		if (!filtro.containsKey("period")) /*Campo non valido*/;
		String campo = "period",operatore="";
		JSONObject interno = (JSONObject)filtro.get(campo);
		//for (Iterator<String> iterator = interno.keySet().iterator(); iterator.hasNext(); ) 
		Iterator<String> iterator = interno.keySet().iterator();
        operatore = (String) iterator.next();
		Vector<Record> filteredArray = new Vector<Record>();
		switch (operatore) {
			case "$gt":
				{String time = (String) interno.get(operatore);
				Data inizio = new Data(DateOperations.getGiorno(time), DateOperations.getMese(time), DateOperations.getAnno(time));
				filteredArray = app.DateFilter_gt(notFilteredArray, inizio);}
				break;
			case "$gte":
				{String time = (String) interno.get(operatore);
				Data inizio = new Data(DateOperations.getGiorno(time), DateOperations.getMese(time), DateOperations.getAnno(time));
				filteredArray = app.DateFilter_gte(notFilteredArray, inizio);}
				break;
			case "$bt":
				Data param[] = getBtDataValues(interno);
				filteredArray = app.DateFilter_bt(notFilteredArray, param[0], param[1]);
				break;
			case "$eq":
				String time = (String) interno.get(operatore);
				Data data = new Data(DateOperations.getGiorno(time), DateOperations.getMese(time), DateOperations.getAnno(time));
				filteredArray = app.DateFilter_eq(notFilteredArray, data);
				break;
			default:/*filtro non valido*/;
		}
		return filteredArray;
	}
	
	
	public static Vector<Record> singleFilterApplicatorRotta5 (JSONObject filtro, Vector<Record> notFilteredArray){
		if (!filtro.containsKey("id")) /*lancia un'eccezione Campononvalido*/;
		String campo = "id";
		JSONObject interno = (JSONObject)filtro.get(campo);
		Vector<Record> filteredArray = new Vector<Record>();
		if(interno.containsKey("$eq")) filteredArray = app.idFilter_eq(notFilteredArray, (long) interno.get("$eq"));
		else /*filtro non valido*/;
		return filteredArray;
	}
	
	
	public static Vector<Record> singleFilterApplicatorRotta6 (JSONObject filtro, Vector<Record> notFilteredArray){
		String campo="";
		//for (Iterator iterator = filtro.keySet().iterator(); iterator.hasNext(); ) 
		Iterator<String> iterator = filtro.keySet().iterator();
        campo = (String) iterator.next();
		String operatore="";
		JSONObject interno = (JSONObject)filtro.get(campo);
		//for (Iterator iterator = interno.keySet().iterator(); iterator.hasNext(); ) 
		Iterator<String> iterator2 = interno.keySet().iterator();
        operatore = (String) iterator2.next();
		Vector<Record> filteredArray = new Vector<Record>();
		switch (operatore) {
			case "$gt": 
				switch (campo) {
				case "temperature":filteredArray = app.TempFilter_gt(notFilteredArray, (double) interno.get(operatore));break;
				case "tempPerc":filteredArray = app.TempPerFilter_gt(notFilteredArray, (double) interno.get(operatore));break;
				case "period":
					String time = (String) interno.get(operatore);
					Data inizio = new Data(DateOperations.getGiorno(time), DateOperations.getMese(time), DateOperations.getAnno(time));
					filteredArray = app.DateFilter_gt(notFilteredArray, inizio);
					break;
				default:  //campo non valido o operatore non valido per quel campo 
				}
				break;
			case "$lt":
				switch (campo) {
				case "temperature":filteredArray = app.TempFilter_less(notFilteredArray, (double) interno.get(operatore));break;
				case "tempPerc":filteredArray = app.TempPerFilter_less(notFilteredArray, (double) interno.get(operatore));break;
				default:  //campo non valido o operatore non valido per quel campo 
				};break;
			case "$bt":
				switch (campo) {
				case "temperature":
					{double param[] = getBtDoubleValues(interno);
					filteredArray = app.TempFilter_bt(notFilteredArray, param[0], param[1]);}
					break;
				case "tempPerc":
				    {double param[] = getBtDoubleValues(interno);
					filteredArray = app.TempPerFilter_bt(notFilteredArray, param[0], param[1]);}
					break;
				case "period":
					Data param[] = getBtDataValues(interno);
					filteredArray = app.DateFilter_bt(notFilteredArray, param[0], param[1]);
					break;
				default: //campo non valido o operatore non valido per quel campo 
				};break;
			case "$eq":
				if(campo=="period")  {
					String time = (String) interno.get(operatore);
					Data data = new Data(DateOperations.getGiorno(time), DateOperations.getMese(time), DateOperations.getAnno(time));
					filteredArray = app.DateFilter_eq(notFilteredArray, data);}
				else /*campo non valido*/;
				break;
			case "$gte":
				if(campo=="period") {
					String time = (String) interno.get(operatore);
					Data inizio = new Data(DateOperations.getGiorno(time), DateOperations.getMese(time), DateOperations.getAnno(time));
					filteredArray = app.DateFilter_gte(notFilteredArray, inizio);}
				else /*campo non valido*/;
				break;
			default: //operatore non valido per la rotta
		}
		return filteredArray;
	}
	
	
	static double[] getBtDoubleValues (JSONObject interno) {
		double parametri[] = new double[2];
		JSONArray dati = (JSONArray) interno.get("$bt");
		for(int i=0; i<2; i++) 	parametri[i]=(double) dati.get(i);
		if(parametri[0]>parametri[1])/*valori non validi per filtro bt*/;
		return parametri;
	}
	
	static Data[] getBtDataValues (JSONObject interno) {
		Data parametri[] = new Data[2];
		JSONArray dati = (JSONArray) interno.get("$bt");
		for(int i=0; i<2; i++) 	{
			String time = (String) dati.get(i);
			parametri[i]=new Data(DateOperations.getGiorno(time),DateOperations.getMese(time),DateOperations.getAnno(time));
		}
		if(DateOperations.confrontaDate(parametri[0],parametri[1])==-1)/*valori non validi per filtro bt*/;
		return parametri;
	}
	
	private static Vector<Record> DeleteDuplicatesCities(Vector<Record> v) {
		Vector<Record> risposta = new Vector<Record>();
		boolean stessaCitta = false;
		for (Record r: v) {
			stessaCitta = false;
			for (Record R : risposta) if(r.getId()==R.getId()) {stessaCitta = true; break;}
			if (stessaCitta==false) risposta.add(new Record(r));}
		return risposta;
	}
	
}