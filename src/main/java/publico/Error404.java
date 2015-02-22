/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package publico;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.Link;

/**
 *
 * @author Luis Alfredo Moctezu
 */
public final class Error404 extends WebPage {

 
    public Error404(PageParameters params) {
                     add(new Link("home") {
            @Override
            public void onClick() {
                setResponsePage(publico.index.class);
            }
        });      
        /*
        add(new Link("index") {
            @Override
            public void onClick() {
                setResponsePage(publico.index.class);
            }
        });
            add(new Link("registro") {
            @Override
            public void onClick() {
                setResponsePage(publico.registro.class);
            }
        });  */  
    }
}
