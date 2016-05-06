
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:04:10 GMT)
 */

        
            package resource.sql.xsd;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "http://dto.dao.justeat.pr/xsd".equals(namespaceURI) &&
                  "Pedido".equals(typeName)){
                   
                            return  pr.justeat.dao.dto.xsd.Pedido.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.dao.justeat.pr/xsd".equals(namespaceURI) &&
                  "Restaurante".equals(typeName)){
                   
                            return  pr.justeat.dao.dto.xsd.Restaurante.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://sql.java/xsd".equals(namespaceURI) &&
                  "SQLException".equals(typeName)){
                   
                            return  resource.sql.xsd.SQLException.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.dao.justeat.pr/xsd".equals(namespaceURI) &&
                  "Cliente".equals(typeName)){
                   
                            return  pr.justeat.dao.dto.xsd.Cliente.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dto.dao.justeat.pr/xsd".equals(namespaceURI) &&
                  "Elemento".equals(typeName)){
                   
                            return  pr.justeat.dao.dto.xsd.Elemento.Factory.parse(reader);
                        

                  }

              
                  if (
                  "http://dao.justeat.pr/xsd".equals(namespaceURI) &&
                  "GestorBD".equals(typeName)){
                   
                            return  pr.justeat.dao.xsd.GestorBD.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    