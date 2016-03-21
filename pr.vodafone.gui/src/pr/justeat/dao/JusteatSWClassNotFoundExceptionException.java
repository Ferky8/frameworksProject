
/**
 * JusteatSWClassNotFoundExceptionException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */

package pr.justeat.dao;

public class JusteatSWClassNotFoundExceptionException extends java.lang.Exception{

    private static final long serialVersionUID = 1458596560119L;
    
    private pr.justeat.dao.JusteatSWClassNotFoundException faultMessage;

    
        public JusteatSWClassNotFoundExceptionException() {
            super("JusteatSWClassNotFoundExceptionException");
        }

        public JusteatSWClassNotFoundExceptionException(java.lang.String s) {
           super(s);
        }

        public JusteatSWClassNotFoundExceptionException(java.lang.String s, java.lang.Throwable ex) {
          super(s, ex);
        }

        public JusteatSWClassNotFoundExceptionException(java.lang.Throwable cause) {
            super(cause);
        }
    

    public void setFaultMessage(pr.justeat.dao.JusteatSWClassNotFoundException msg){
       faultMessage = msg;
    }
    
    public pr.justeat.dao.JusteatSWClassNotFoundException getFaultMessage(){
       return faultMessage;
    }
}
    