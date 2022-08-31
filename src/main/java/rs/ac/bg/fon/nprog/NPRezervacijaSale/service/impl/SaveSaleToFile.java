package rs.ac.bg.fon.nprog.NPRezervacijaSale.service.impl;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import rs.ac.bg.fon.nprog.NPRezervacijaSale.dto.SalaDto;

@Component
public class SaveSaleToFile {

	void saveSaleToFile(List<SalaDto> salaDtos) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray jsonArr = new JsonArray();
		salaDtos.forEach(rezervacija->{
			String jsonObject=gson.toJson(rezervacija);
			jsonArr.add(jsonObject);
			});
		
		try(PrintWriter pw = new PrintWriter(new FileWriter("sale.json"))) {
			pw.write(gson.toJson(jsonArr));
		} catch (Exception e) {
			System.out.println(e);
		}
	
}
	
}
