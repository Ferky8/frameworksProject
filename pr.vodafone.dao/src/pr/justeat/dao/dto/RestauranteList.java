package pr.justeat.dao.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "restauranteList")
public class RestauranteList {

  private ArrayList<Restaurante> restauranteList;

  @XmlElementWrapper(name = "restauranteList")
  @XmlElement(name = "restaurante")
  public ArrayList<Restaurante> getRestauranteList() {
      return restauranteList;
  }

}
