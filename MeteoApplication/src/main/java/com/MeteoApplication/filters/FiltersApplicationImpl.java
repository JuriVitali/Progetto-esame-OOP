package com.MeteoApplication.filters;

import java.util.Vector;

import com.MeteoApplication.util.DateOperations;

import com.MeteoApplication.model.Record;
import com.MeteoApplication.model.Data;
import com.MeteoApplication.model.Statistics;

//Classe che implementa l'interfaccia FiltersApplication
class FiltersApplicationImpl implements FiltersApplication{
	
	//Filtri sulle statistiche : filtrano un vettore di tipo Statistics
	
	//Filtro per temperatura reale media con operatore $bt
	public Vector<Statistics> reTempAvgIncl (Vector<Statistics> v, double min, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempAvg()<=max && s.getRealTempAvg()>=min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura reale minima con operatore $bt
	public Vector<Statistics> reTempMinIncl (Vector<Statistics> v, double min, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempMin()<=max && s.getRealTempMin()>=min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura reale massima con operatore $bt
	public Vector<Statistics> reTempMaxIncl (Vector<Statistics> v, double min, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempMax()<=max && s.getRealTempMax()>=min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per la varianza della temperatura reale con operatore $bt
	public Vector<Statistics> reTempVarIncl (Vector<Statistics> v, double min, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempVariance()<=max && s.getRealTempVariance()>=min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura percepita media con operatore $bt
	public Vector<Statistics> percTempAvgIncl (Vector<Statistics> v, double min, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempAvg()<=max && s.getPercTempAvg()>=min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura percepita minima con operatore $bt
	public Vector<Statistics> percTempMinIncl (Vector<Statistics> v, double min, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempMin()<=max && s.getPercTempMin()>=min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura percepita massima con operatore $bt
	public Vector<Statistics> percTempMaxIncl (Vector<Statistics> v, double min, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempMax()<=max && s.getPercTempMax()>=min) risposta.add(new Statistics(s)); 
		return risposta;
	}
    
	//Filtro per la varianza della temperatura percepita con operatore $bt
	public Vector<Statistics> percTempVarIncl (Vector<Statistics> v, double min, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempVar()<=max && s.getPercTempVar()>=min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	
	//Filtro per temperatura reale media con operatore $lt
	public Vector<Statistics> reTempAvgLess (Vector<Statistics> v, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempAvg()<max) risposta.add(new Statistics(s)); 
		return risposta;
	}

	//Filtro per temperatura reale minima con operatore $lt
	public Vector<Statistics> reTempMinLess (Vector<Statistics> v, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempMin()<max) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura reale massima con operatore $lt
	public Vector<Statistics> reTempMaxLess (Vector<Statistics> v, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempMax()<max) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per la varianza della temperatura reale con operatore $lt
	public Vector<Statistics> reTempVarLess (Vector<Statistics> v, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempVariance()<max) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura percepita media con operatore $lt
	public Vector<Statistics> percTempAvgLess (Vector<Statistics> v, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempAvg()<max) risposta.add(new Statistics(s)); 
		return risposta;
	}

	//Filtro per temperatura percepita minima con operatore $lt
	public Vector<Statistics> percTempMinLess (Vector<Statistics> v, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempMin()<max) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura percepita massima con operatore $lt
	public Vector<Statistics> percTempMaxLess (Vector<Statistics> v, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempMax()<max) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per la varianza della temperatura percepita con operatore $lt
	public Vector<Statistics> percTempVarLess (Vector<Statistics> v, double max) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempVar()<max) risposta.add(new Statistics(s)); 
		return risposta;
	}

	
	//Filtro per temperatura reale media con operatore $gt
	public Vector<Statistics> reTempAvgGreat (Vector<Statistics> v, double min) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempAvg()>min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura reale minima con operatore $gt
	public Vector<Statistics> reTempMinGreat (Vector<Statistics> v, double min) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempMin()>min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura reale massima con operatore $gt
	public Vector<Statistics> reTempMaxGreat (Vector<Statistics> v, double min) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempMax()>min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per la varianza della temperatura reale con operatore $gt
	public Vector<Statistics> reTempVarGreat (Vector<Statistics> v, double min) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getRealTempVariance()>min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura percepita media con operatore $gt
	public Vector<Statistics> percTempAvgGreat (Vector<Statistics> v, double min) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempAvg()>min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura percepita minima con operatore $gt
	public Vector<Statistics> percTempMinGreat (Vector<Statistics> v, double min) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempMin()>min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per temperatura percepita massima con operatore $gt
	public Vector<Statistics> percTempMaxGreat (Vector<Statistics> v, double min) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempMax()>min) risposta.add(new Statistics(s)); 
		return risposta;
	}
	
	//Filtro per la varianza della temperatura percepita con operatore $gt
	public Vector<Statistics> percTempVarGreat (Vector<Statistics> v, double min) {
		Vector<Statistics> risposta = new Vector<Statistics>();
		for (Statistics s: v) if (s.getPercTempVar()>min) risposta.add(new Statistics(s)); 
		return risposta;
	}

	
	
	//Filtro per la data con operatore $gte
	public Vector<Record> DateFilter_gte(Vector<Record> v, Data param) {    
		Vector<Record> risposta = new Vector<Record>();
		for(Record recordIndex : v) 
			if (DateOperations.confrontaDate(recordIndex.getData(),param)==0 || 
				DateOperations.confrontaDate(recordIndex.getData(),param)==-1) risposta.add(new Record(recordIndex));
		return risposta;	
	}
		
	//Filtro per la data con operatore $gt
	public Vector<Record> DateFilter_gt(Vector<Record> v, Data param) {    
		Vector<Record> risposta = new Vector<Record>();
		for(Record recordIndex : v) 
			if (DateOperations.confrontaDate(recordIndex.getData(),param)==-1) risposta.add(new Record(recordIndex));
		return risposta;	
	}

	//Filtro per la data con operatore $bt
	public Vector<Record> DateFilter_bt(Vector<Record> v, Data inizio, Data fine) {    
		Vector<Record> risposta = new Vector<Record>();
		for(Record recordIndex : v) 
			if ( (DateOperations.confrontaDate(recordIndex.getData(),inizio)==0 || DateOperations.confrontaDate(recordIndex.getData(),inizio)==-1) 
					&& (DateOperations.confrontaDate(recordIndex.getData(),fine)==0 || DateOperations.confrontaDate(recordIndex.getData(),fine)==1) )risposta.add(new Record(recordIndex));
		return risposta;	
	}

	//Filtro per la data con operatore $eq
	public Vector<Record> DateFilter_eq(Vector<Record> v, Data param) {    
		Vector<Record> risposta = new Vector<Record>();
		for(Record recordIndex : v) 
			if (DateOperations.DateUguali(param, recordIndex.getData())) risposta.add(new Record(recordIndex));
		return risposta;	
	}

	
	//Filtro per id con operatore $eq
	public Vector<Record> idFilter_eq(Vector<Record> v,long param) {
		Vector<Record> risposta = new Vector<Record>();
		for(Record recordIndex : v) 
			if (recordIndex.getId()==param) risposta.add(new Record(recordIndex));
		return risposta;
	}
	
	
	
	//Filtri per temperatura
	
	/*
	 * Filtra le città con temperatura reale maggiore di un determinato valore
	 * 
	 * Prende in ingresso un vettore di elementi di tipo Record e il parametro con cui verranno confrontate le temperature
	 */
	public Vector<Record> TempFilter_gt(Vector<Record> record, double TempPar) { 
		Vector<Record> risposta = new Vector<Record>(); //Viene creato un vettore di elementi di tipo City che conterrà le città filtrate
		for(Record recordIndex : record) if(recordIndex.getTempMax() > TempPar) risposta.add(new Record(recordIndex));
		/*
		 * Viene imposta la condizione riguardante la temperatura. Se questa è rispettata viene aggiunto un oggetto identico al record 
		 * nel vettore che verrà restituito
		 */
		return risposta;
	}

	/*
	 * Filtra le città con temperatura reale minore di un determinato valore
	 * 
	 * Prende in ingresso un vettore di elementi di tipo Record e il parametro con cui verranno confrontate le temperature
	 */
	public Vector<Record> TempFilter_less(Vector<Record> record, double TempPar) { 
		Vector<Record> risposta = new Vector<Record>();
		//Viene creato un vettore di elementi di tipo City che conterrà le città filtrate
		for(Record recordIndex : record) if(recordIndex.getTempMin() < TempPar) risposta.add(new Record(recordIndex));
		return risposta;
		/*
		 * Viene imposta la condizione riguardante la temperatura. Se questa è rispettata viene aggiunto un oggetto identico al record 
		 * nel vettore che verrà restituito
		 */
	}
	
	
	/*
	 * Filtra le città con temperatura reale compresa tra due valori passati come parametri
	 * 
	 * Prende in ingresso un vettore di elementi di tipo Record e i parametri con cui verranno confrontate le temperature
	 */
	public Vector<Record> TempFilter_bt(Vector<Record> record, double TempPar1, double TempPar2) { 
		Vector<Record> risposta = new Vector<Record>();
		//Viene creato un vettore di elementi di tipo City che conterrà le città filtrate
		
		for(Record recordIndex : record) if((recordIndex.getTempMax() >= TempPar1) && (recordIndex.getTempMin() <= TempPar2)) risposta.add(new Record(recordIndex));
		/*
		 * Viene imposta la condizione riguardante la temperatura. Se questa è rispettata viene aggiunto un oggetto identico al record 
		 * nel vettore che verrà restituito
		 */
		return risposta;
	}
	

	
	//Filtri per temperatura percepita	
	
	/*
	 * Filtra le città con temperatura percepita maggiore di un determinato valore
	 * 
	 * Prende in ingresso un vettore di elementi di tipo Record e il parametro con cui verranno confrontate le temperature
	 */
	public Vector<Record> TempPerFilter_gt(Vector<Record> record, double TempPar) { 
		Vector<Record> risposta = new Vector<Record>();
		//Viene creato un vettore di elementi di tipo City che conterrà le città filtrate
		for(Record recordIndex : record) if(recordIndex.getTempPer() > TempPar) risposta.add(new Record(recordIndex));
		/*
		 * Viene imposta la condizione riguardante la temperatura. Se questa è rispettata viene aggiunto un oggetto identico al record 
		 * nel vettore che verrà restituito
		 */
		return risposta;
	}
	
	
	/*
	 * Filtra le città con temperatura percepita minore di un determinato valore
	 * 
	 * Prende in ingresso un vettore di elementi di tipo Record e il parametro con cui verranno confrontate le temperature
	 */
	public Vector<Record> TempPerFilter_less(Vector<Record> record, double TempPar) { 
		Vector<Record> risposta = new Vector<Record>();
		//Viene creato un vettore di elementi di tipo City che conterrà le città filtrate
		for(Record recordIndex : record) if(recordIndex.getTempPer() < TempPar) risposta.add(new Record(recordIndex));
		/*
		 * Viene imposta la condizione riguardante la temperatura percepita. Se questa è rispettata viene aggiunto un oggetto identico al record 
		 * nel vettore che verrà restituito
		 */
		return risposta;
	}
	
	
	/*
	 * Filtra le città con temperatura percepita compresa tra due valori passati come parametri
	 * 
	 * Prende in ingresso un vettore di elementi di tipo Record e i parametri con cui verranno confrontate le temperature
	 */
	public Vector<Record> TempPerFilter_bt(Vector<Record> record, double TempPar1, double TempPar2) { 
		Vector<Record> risposta = new Vector<Record>();
		//Viene creato un vettore di elementi di tipo City che conterrà le città filtrate
		
		for(Record recordIndex : record) if((recordIndex.getTempPer() >= TempPar1) && (recordIndex.getTempPer() <= TempPar2)) risposta.add(new Record(recordIndex));
		/*
		 * Viene imposta la condizione riguardante la temperatura percepita. Se questa è rispettata viene aggiunto un oggetto identico al record 
		 * nel vettore che verrà restituito
		 */
		return risposta;
	}
}
