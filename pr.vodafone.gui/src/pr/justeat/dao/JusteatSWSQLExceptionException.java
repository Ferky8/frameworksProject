
/**
 * JusteatSWSQLExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */

package pr.justeat.dao;

public class JusteatSWSQLExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1458583649442L;
    
    private pr.justeat.dao.JusteatSWSQLException faultMessage;

    
        public JusteatSWSQLExceptionException() {
            super("JusteatSWSQLExceptionException");
        }

        public JusteatSWSQLExceptionException(java.lang.String s) {
           super(s);
        }

        public JusteatSWSQLExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public JusteatSWSQLExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(pr.justeat.dao.JusteatSWSQLException msg){
       faultMessage = msg;
    }
    
    public pr.justeat.dao.JusteatSWSQLException getFaultMessage(){
       return faultMessage;
    }
}
    