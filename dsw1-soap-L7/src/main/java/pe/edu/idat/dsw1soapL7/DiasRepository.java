package pe.edu.idat.dsw1soapL7;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;


import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class DiasRepository {

	private static final Map<String, Dia> dias = new HashMap<>();

	@PostConstruct
	public void initData() {
		Dia lunes = new Dia();
		lunes.setName("lunes");
		lunes.setTraduccion("monday");
		dias.put(lunes.getName(), lunes);

	}

	public Dia findDia(String name){
		Assert.notNull(name,"los dias traducidos");
		return dias.get(name);
	}

}
