/*
 * Created on 18 de octubre de 2013, 01:22 PM
 */
 
package com.mycompany.webpageluis;           

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.target.coding.QueryStringUrlCodingStrategy;

 
public class Application extends WebApplication {

    @Override
	protected void init() {
		super.init();	
           
           mount(new QueryStringUrlCodingStrategy("index",publico.index.class));
            mount(new QueryStringUrlCodingStrategy("map",publico.estadisticas.class));
           mount(new QueryStringUrlCodingStrategy("city/1",city.acceso.class));
           mount(new QueryStringUrlCodingStrategy("city/2",city.infraestructure.class));
           mount(new QueryStringUrlCodingStrategy("city/3",city.mobility.class));
           
                      mount(new QueryStringUrlCodingStrategy("connection/1",conection.acceso.class));
           mount(new QueryStringUrlCodingStrategy("connection/2",conection.infraestructure.class));
           mount(new QueryStringUrlCodingStrategy("connection/3",conection.mobility.class));
           
           mount(new QueryStringUrlCodingStrategy("Error404",publico.Error404.class));
        }
        
    public Application() {
    
    }
    public Class getHomePage() {
  return publico.index.class;
        
    }

}
