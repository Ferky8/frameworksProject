
/**
 * JusteatSWCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.4  Built on : Dec 28, 2015 (10:03:39 GMT)
 */

    package pr.justeat.dao;

    /**
     *  JusteatSWCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class JusteatSWCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public JusteatSWCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public JusteatSWCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for borrarRestaurante method
            * override this method for handling normal response from borrarRestaurante operation
            */
           public void receiveResultborrarRestaurante(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from borrarRestaurante operation
           */
            public void receiveErrorborrarRestaurante(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerElementos method
            * override this method for handling normal response from obtenerElementos operation
            */
           public void receiveResultobtenerElementos(
                    pr.justeat.dao.ObtenerElementosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerElementos operation
           */
            public void receiveErrorobtenerElementos(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for actualizarPedido method
            * override this method for handling normal response from actualizarPedido operation
            */
           public void receiveResultactualizarPedido(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from actualizarPedido operation
           */
            public void receiveErroractualizarPedido(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerElemento method
            * override this method for handling normal response from obtenerElemento operation
            */
           public void receiveResultobtenerElemento(
                    pr.justeat.dao.ObtenerElementoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerElemento operation
           */
            public void receiveErrorobtenerElemento(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerRestaurantes method
            * override this method for handling normal response from obtenerRestaurantes operation
            */
           public void receiveResultobtenerRestaurantes(
                    pr.justeat.dao.ObtenerRestaurantesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerRestaurantes operation
           */
            public void receiveErrorobtenerRestaurantes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for desconectar method
            * override this method for handling normal response from desconectar operation
            */
           public void receiveResultdesconectar(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from desconectar operation
           */
            public void receiveErrordesconectar(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerPedidosEntregadosCliente method
            * override this method for handling normal response from obtenerPedidosEntregadosCliente operation
            */
           public void receiveResultobtenerPedidosEntregadosCliente(
                    pr.justeat.dao.ObtenerPedidosEntregadosClienteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerPedidosEntregadosCliente operation
           */
            public void receiveErrorobtenerPedidosEntregadosCliente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for borrarClientes method
            * override this method for handling normal response from borrarClientes operation
            */
           public void receiveResultborrarClientes(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from borrarClientes operation
           */
            public void receiveErrorborrarClientes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for contarRestaurantes method
            * override this method for handling normal response from contarRestaurantes operation
            */
           public void receiveResultcontarRestaurantes(
                    pr.justeat.dao.ContarRestaurantesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from contarRestaurantes operation
           */
            public void receiveErrorcontarRestaurantes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertarCliente method
            * override this method for handling normal response from insertarCliente operation
            */
           public void receiveResultinsertarCliente(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertarCliente operation
           */
            public void receiveErrorinsertarCliente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for actualizarRestaurante method
            * override this method for handling normal response from actualizarRestaurante operation
            */
           public void receiveResultactualizarRestaurante(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from actualizarRestaurante operation
           */
            public void receiveErroractualizarRestaurante(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerClientesPorNombre method
            * override this method for handling normal response from obtenerClientesPorNombre operation
            */
           public void receiveResultobtenerClientesPorNombre(
                    pr.justeat.dao.ObtenerClientesPorNombreResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerClientesPorNombre operation
           */
            public void receiveErrorobtenerClientesPorNombre(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for actualizarElemento method
            * override this method for handling normal response from actualizarElemento operation
            */
           public void receiveResultactualizarElemento(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from actualizarElemento operation
           */
            public void receiveErroractualizarElemento(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerPedidos method
            * override this method for handling normal response from obtenerPedidos operation
            */
           public void receiveResultobtenerPedidos(
                    pr.justeat.dao.ObtenerPedidosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerPedidos operation
           */
            public void receiveErrorobtenerPedidos(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerRestaurantesPorPrecioMedio method
            * override this method for handling normal response from obtenerRestaurantesPorPrecioMedio operation
            */
           public void receiveResultobtenerRestaurantesPorPrecioMedio(
                    pr.justeat.dao.ObtenerRestaurantesPorPrecioMedioResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerRestaurantesPorPrecioMedio operation
           */
            public void receiveErrorobtenerRestaurantesPorPrecioMedio(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for contarClientes method
            * override this method for handling normal response from contarClientes operation
            */
           public void receiveResultcontarClientes(
                    pr.justeat.dao.ContarClientesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from contarClientes operation
           */
            public void receiveErrorcontarClientes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerRestaurantesPorTipoComida method
            * override this method for handling normal response from obtenerRestaurantesPorTipoComida operation
            */
           public void receiveResultobtenerRestaurantesPorTipoComida(
                    pr.justeat.dao.ObtenerRestaurantesPorTipoComidaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerRestaurantesPorTipoComida operation
           */
            public void receiveErrorobtenerRestaurantesPorTipoComida(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for borrarCliente method
            * override this method for handling normal response from borrarCliente operation
            */
           public void receiveResultborrarCliente(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from borrarCliente operation
           */
            public void receiveErrorborrarCliente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertarElemento method
            * override this method for handling normal response from insertarElemento operation
            */
           public void receiveResultinsertarElemento(
                    pr.justeat.dao.InsertarElementoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertarElemento operation
           */
            public void receiveErrorinsertarElemento(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerPedidosEntregados method
            * override this method for handling normal response from obtenerPedidosEntregados operation
            */
           public void receiveResultobtenerPedidosEntregados(
                    pr.justeat.dao.ObtenerPedidosEntregadosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerPedidosEntregados operation
           */
            public void receiveErrorobtenerPedidosEntregados(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for borrarPedido method
            * override this method for handling normal response from borrarPedido operation
            */
           public void receiveResultborrarPedido(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from borrarPedido operation
           */
            public void receiveErrorborrarPedido(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertarPedido method
            * override this method for handling normal response from insertarPedido operation
            */
           public void receiveResultinsertarPedido(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertarPedido operation
           */
            public void receiveErrorinsertarPedido(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerRestaurante method
            * override this method for handling normal response from obtenerRestaurante operation
            */
           public void receiveResultobtenerRestaurante(
                    pr.justeat.dao.ObtenerRestauranteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerRestaurante operation
           */
            public void receiveErrorobtenerRestaurante(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for contarPedidos method
            * override this method for handling normal response from contarPedidos operation
            */
           public void receiveResultcontarPedidos(
                    pr.justeat.dao.ContarPedidosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from contarPedidos operation
           */
            public void receiveErrorcontarPedidos(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerElementosCliente method
            * override this method for handling normal response from obtenerElementosCliente operation
            */
           public void receiveResultobtenerElementosCliente(
                    pr.justeat.dao.ObtenerElementosClienteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerElementosCliente operation
           */
            public void receiveErrorobtenerElementosCliente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for borrarPedidos method
            * override this method for handling normal response from borrarPedidos operation
            */
           public void receiveResultborrarPedidos(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from borrarPedidos operation
           */
            public void receiveErrorborrarPedidos(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for entregarPedido method
            * override this method for handling normal response from entregarPedido operation
            */
           public void receiveResultentregarPedido(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from entregarPedido operation
           */
            public void receiveErrorentregarPedido(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for conectar method
            * override this method for handling normal response from conectar operation
            */
           public void receiveResultconectar(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from conectar operation
           */
            public void receiveErrorconectar(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for borrarElementos method
            * override this method for handling normal response from borrarElementos operation
            */
           public void receiveResultborrarElementos(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from borrarElementos operation
           */
            public void receiveErrorborrarElementos(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerPedidosCliente method
            * override this method for handling normal response from obtenerPedidosCliente operation
            */
           public void receiveResultobtenerPedidosCliente(
                    pr.justeat.dao.ObtenerPedidosClienteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerPedidosCliente operation
           */
            public void receiveErrorobtenerPedidosCliente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for actualizarCliente method
            * override this method for handling normal response from actualizarCliente operation
            */
           public void receiveResultactualizarCliente(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from actualizarCliente operation
           */
            public void receiveErroractualizarCliente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for borrarElemento method
            * override this method for handling normal response from borrarElemento operation
            */
           public void receiveResultborrarElemento(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from borrarElemento operation
           */
            public void receiveErrorborrarElemento(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerRestaurantesPorNombre method
            * override this method for handling normal response from obtenerRestaurantesPorNombre operation
            */
           public void receiveResultobtenerRestaurantesPorNombre(
                    pr.justeat.dao.ObtenerRestaurantesPorNombreResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerRestaurantesPorNombre operation
           */
            public void receiveErrorobtenerRestaurantesPorNombre(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for insertarRestaurante method
            * override this method for handling normal response from insertarRestaurante operation
            */
           public void receiveResultinsertarRestaurante(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from insertarRestaurante operation
           */
            public void receiveErrorinsertarRestaurante(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for borrarRestaurantes method
            * override this method for handling normal response from borrarRestaurantes operation
            */
           public void receiveResultborrarRestaurantes(
                    ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from borrarRestaurantes operation
           */
            public void receiveErrorborrarRestaurantes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerCliente method
            * override this method for handling normal response from obtenerCliente operation
            */
           public void receiveResultobtenerCliente(
                    pr.justeat.dao.ObtenerClienteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerCliente operation
           */
            public void receiveErrorobtenerCliente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerClientes method
            * override this method for handling normal response from obtenerClientes operation
            */
           public void receiveResultobtenerClientes(
                    pr.justeat.dao.ObtenerClientesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerClientes operation
           */
            public void receiveErrorobtenerClientes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for contarElementos method
            * override this method for handling normal response from contarElementos operation
            */
           public void receiveResultcontarElementos(
                    pr.justeat.dao.ContarElementosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from contarElementos operation
           */
            public void receiveErrorcontarElementos(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerElementosPedido method
            * override this method for handling normal response from obtenerElementosPedido operation
            */
           public void receiveResultobtenerElementosPedido(
                    pr.justeat.dao.ObtenerElementosPedidoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerElementosPedido operation
           */
            public void receiveErrorobtenerElementosPedido(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for obtenerPedido method
            * override this method for handling normal response from obtenerPedido operation
            */
           public void receiveResultobtenerPedido(
                    pr.justeat.dao.ObtenerPedidoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from obtenerPedido operation
           */
            public void receiveErrorobtenerPedido(java.lang.Exception e) {
            }
                


    }
    