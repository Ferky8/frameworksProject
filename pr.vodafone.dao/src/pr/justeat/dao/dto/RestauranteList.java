package pr.justeat.dao.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restauranteList")
@XmlAccessorType (XmlAccessType.FIELD)
public class RestauranteList {

	@XmlElement(name = "restaurante")
	private List<Restaurante> restauranteList;
	
	public List<Restaurante> getRestauranteList() {
		return restauranteList;
	}
}
