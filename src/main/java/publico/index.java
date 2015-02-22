package publico;

import com.myapp.wicket.Conn.Consultass;
import javax.swing.JOptionPane;
import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

/**
 *
 * @author Luis Alfredo
 */
public final class index extends WebPage {
/*
           final TextField tuserP;
    final PasswordTextField tpassP;
         Consultass cons; 
         */
    public index(PageParameters params) {
        
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
              
           
              
       /*
      
                  cons = new Consultass();
                tuserP = new TextField("usernameP", Model.of(""));
                tpassP = new PasswordTextField("passP", Model.of(""));

                                 Form<?> form = new Form<String>("userForm1") {
            protected void onSubmit() {    
             PageParameters pageParameters = new PageParameters();     
 
       
        Object[][] nomrep;
                nomrep = cons.accesousuarioP(tuserP.getValue(),tpassP.getValue());
        
                
                 if (!(nomrep.length == 0)) {
                  pageParameters.add("user", tuserP.getValue());              
                   pageParameters.add("Iooasdihj", nomrep[0][1].toString());
                     System.out.println(nomrep[0][1].toString());
                  setResponsePage(paciente.index.class, pageParameters);
                } else if (!(nomrep.length == 1)) {
   //                  JOptionPane.showMessageDialog(null, "Algo salio mal");
                     setResponsePage(publico.index.class);
                }
                          
                        
            }
        };
        add(form);
        form.add(tuserP);
        form.add(tpassP);
        
        */
                
                 
                                 
    }
}
