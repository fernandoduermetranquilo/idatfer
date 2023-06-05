package pe.edu.idat.dsw1soapL7;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;




@Endpoint
public class DiasEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

	private DiasRepository diasRepository;

	@Autowired
	public DiasEndpoint(DiasRepository diasRepository) {
		this.diasRepository = diasRepository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDiasRequest")
	@ResponsePayload
	public GetDiasResponse getDias(@RequestPayload GetDiasRequest request) {
		GetDiasResponse response = new GetDiasResponse();
		response.setDia(diasRepository.findDia(request.getName()));

		return response;
	}

}
