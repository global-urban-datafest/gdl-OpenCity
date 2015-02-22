 

package conection;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

/**
 *
 * @author Luis Alfredo
 */
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
    }
}
