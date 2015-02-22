
package city;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

 
public final class acceso extends WebPage {

   
    
    public acceso(PageParameters params) {
                 add(new Link("home") {
            @Override
            public void onClick() {
                setResponsePage(publico.index.class);
            }
        });
    add(new Link("mobi1") {
            @Override
            public void onClick() {
                setResponsePage(conection.mobility.class);
            }
        });

    
        add(new Link("infra1") {
            @Override
            public void onClick() {
                setResponsePage(conection.infraestructure.class);
            }
        });
        
              add(new Link("acceso1") {
            @Override
            public void onClick() {
                setResponsePage(conection.acceso.class);
            }
        });
    
           add(new Link("mobi2") {
            @Override
            public void onClick() {
                setResponsePage(city.mobility.class);
            }
        });

                      add(new Link("infra2") {
            @Override
            public void onClick() {
                setResponsePage(city.infraestructure.class);
            }
        });
              add(new Link("acceso2") {
            @Override
            public void onClick() {
                setResponsePage(city.acceso
                        .class);
            }
        });
                      add(new Link("map") {
            @Override
            public void onClick() {
                setResponsePage(publico.estadisticas.class);
            }
        });
          add(new Link("map2") {
            @Override
            public void onClick() {
                setResponsePage(publico.estadisticas.class);
            }
        });
    }
}
