package com.myapp.wicket.Conn;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Consultass {
conexion con;

public Consultass (){
con = new conexion();
}


//////////////////////////
public void nuevaCita(String desc,int idD, int idP){
try {
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("insert into " +
"cita(description,doctor_idd,padiente_idp) values(?,?,?)");
pstm.setString(1,desc);
pstm.setInt(2,idD);
pstm.setInt(3,idP);
pstm.execute();
pstm.close();
}catch(SQLException e){
System.out.println(e);
}
}
///////////////////////////////

public Object [][] accesousuarioP(String correoe,String contra){
int registros = 0;

//obtenemos la cantidad de registros existentes en la tabla
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) as total FROM paciente WHERE username=\'"+correoe+"\' AND pass=\'"+contra+"\'");
ResultSet res = pstm.executeQuery();
res.next();
registros = res.getInt("total");
res.close();
}catch(SQLException e){
System.out.println(e);
}
Object[][] data = new Object[registros][2];

//realizamos la consulta sql y llenamos los datos en "Object"
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT username,state_idstate FROM paciente WHERE username=\'"+correoe+"\' AND pass=\'"+contra+"\'");
ResultSet res = pstm.executeQuery();
int i = 0;
while(res.next()){
   
    String estNombre = res.getString("username");
        String state = res.getString("state_idstate");
    data[i][0] = estNombre;  
    data[i][1] = state;  
    i++;
}
res.close();
}catch(SQLException e){ System.out.println(e);}
return data;
}

///////////////////////////////////////


///
public void nuevopaciente(String name,String username,String email,String password,int state,String city){
try {
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("insert into " +
"paciente(name,username,email,pass,state_idstate,city) values(?,?,?,?,?,?)");
pstm.setString(1,name);
pstm.setString(2,username);
pstm.setString(3,email);
pstm.setString(4,password);
pstm.setInt(5,state);
pstm.setString(6,city);
pstm.execute();
pstm.close();
}catch(SQLException e){
System.out.println(e);
}
}


///
public void nuevoMedico(String name,String email,String password, String cedula,int state,String city,int espe,String direccion){
try {
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("insert into " +
"doctor(name,email,pass,cedula,state_idstate,city,especialidad_id,direccion) values(?,?,?,?,?,?,?,?)");
pstm.setString(1,name);
pstm.setString(2,email);
pstm.setString(3,cedula);
pstm.setString(4,password);
pstm.setInt(5,state);
pstm.setString(6,city);
pstm.setInt(7,espe);
pstm.setString(8,direccion);
pstm.execute();
pstm.close();
}catch(SQLException e){
System.out.println(e);
}
}

//////////////////////////////////////////////////////////////////////////////



public Object [][] getState(){
int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) as total FROM state");
ResultSet res = pstm.executeQuery();
res.next();
registros = res.getInt("total");
res.close();
}catch(SQLException e){
System.out.println(e);
}
Object[][] data = new Object[registros][2];
//realizamos la consulta sql y llenamos los datos en "Object"
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT idstate,description FROM state");
ResultSet res = pstm.executeQuery();
int i = 0;
while(res.next()){
   
    String id = res.getString("idstate");
    String des = res.getString("description");
    data[i][0] = id;
    data[i][1] = des;   
    i++;
}
res.close();
}catch(SQLException e){ System.out.println(e);}
return data;
}

//////////////////////////
public Object [][] getEspe(){
int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) as total FROM especialidad");
ResultSet res = pstm.executeQuery();
res.next();
registros = res.getInt("total");
res.close();
}catch(SQLException e){
System.out.println(e);
}
Object[][] data = new Object[registros][2];
//realizamos la consulta sql y llenamos los datos en "Object"
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT id,description FROM especialidad");           
ResultSet res = pstm.executeQuery();
int i = 0;
while(res.next()){
   
    String id = res.getString("id");
    String des = res.getString("description");
    data[i][0] = id;
    data[i][1] = des;   
    i++;
}
res.close();
}catch(SQLException e){ System.out.println(e);}
return data;
}

//////////////////////////

public Object [][] getDoctor(String state){
int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) AS total FROM doctor WHERE state_idstate =\'"+state+"\'");        
ResultSet res = pstm.executeQuery();
res.next();
registros = res.getInt("total");
res.close();
}catch(SQLException e){
System.out.println(e);
}
Object[][] data = new Object[registros][4];
//realizamos la consulta sql y llenamos los datos en "Object"
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT name,email,e.description especialidad,city FROM doctor d inner join especialidad e on e.id=d.especialidad_id WHERE state_idstate =\'"+state+"\'");
ResultSet res = pstm.executeQuery();
int i = 0;
while(res.next()){
   
    String nombre = res.getString("name");
    String email = res.getString("email");
    String espe = res.getString("especialidad");
    String city = res.getString("city");
    
    data[i][0] = nombre;
    data[i][1] = email;
    data[i][2] = espe; 
    data[i][3] = city; 
    
    i++;
}
res.close();
}catch(SQLException e){ System.out.println(e);}
return data;
}


//////////////////////////

public Object [][] getCitaDoctor(String ci){
int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) AS total FROM doctor WHERE email =\'"+ci+"\'");        
ResultSet res = pstm.executeQuery();
res.next();
registros = res.getInt("total");
res.close();
}catch(SQLException e){
System.out.println(e);
}
Object[][] data = new Object[registros][4];
//realizamos la consulta sql y llenamos los datos en "Object"
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT name,email,e.description especialidad,city FROM doctor d inner join especialidad e on e.id=d.especialidad_id WHERE email =\'"+ci+"\'");
ResultSet res = pstm.executeQuery();
int i = 0;
while(res.next()){
   
    String nombre = res.getString("name");
    String email = res.getString("email");
    String espe = res.getString("especialidad");
    String city = res.getString("city");
    
    data[i][0] = nombre;
    data[i][1] = email;
    data[i][2] = espe; 
    data[i][3] = city; 
    
    i++;
}
res.close();
}catch(SQLException e){ System.out.println(e);}
return data;
}

/////////////////


public Object [][] getDoctorE(String especialidad, String estado){
int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) AS total FROM doctor WHERE especialidad_id=\'"+especialidad+"\' and state_idstate=\'"+estado+"\'");        
ResultSet res = pstm.executeQuery();
res.next();
registros = res.getInt("total");
res.close();
}catch(SQLException e){
System.out.println(e);
}
Object[][] data = new Object[registros][4];
//realizamos la consulta sql y llenamos los datos en "Object"
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT name,email,e.description especialidad,city FROM doctor d inner join especialidad e on e.id=d.especialidad_id WHERE especialidad_id=\'"+especialidad+"\' and state_idstate=\'"+estado+"\'");
ResultSet res = pstm.executeQuery();
int i = 0;
while(res.next()){
   
    String nombre = res.getString("name");
    String email = res.getString("email");
    String espe = res.getString("especialidad");
    String city = res.getString("city");
    
    data[i][0] = nombre;
    data[i][1] = email;
    data[i][2] = espe; 
    data[i][3] = city; 
    
    i++;
}
res.close();
}catch(SQLException e){ System.out.println(e);}
return data;
}

public Object [][] getDoctorEdo(String estado){
int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) AS total FROM doctor WHERE state_idstate=\'"+estado+"\'");        
ResultSet res = pstm.executeQuery();
res.next();
registros = res.getInt("total");
res.close();
}catch(SQLException e){
System.out.println(e);
}
Object[][] data = new Object[registros][5];
//realizamos la consulta sql y llenamos los datos en "Object"
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT name,email,e.description especialidad,city,s.description estado FROM doctor d inner join especialidad e on e.id=d.especialidad_id inner join state s on s.idstate=state_idstate WHERE state_idstate=\'"+estado+"\'");
ResultSet res = pstm.executeQuery();
int i = 0;
while(res.next()){
   
    String nombre = res.getString("name");
    String email = res.getString("email");
    String espe = res.getString("especialidad");
    String city = res.getString("city");
    String edo = res.getString("estado");
    
    data[i][0] = nombre;
    data[i][1] = email;
    data[i][2] = espe; 
    data[i][3] = city; 
    data[i][4] = edo; 
    i++;
}
res.close();
}catch(SQLException e){ System.out.println(e);}
return data;
}



///////////////////////



public Object [][] getTorneosUser(){
int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) AS total FROM tournament WHERE usuario_id=1");
ResultSet res = pstm.executeQuery();
res.next();
registros = res.getInt("total");
res.close();
}catch(SQLException e){
System.out.println(e);
}
Object[][] data = new Object[registros][6];
//realizamos la consulta sql y llenamos los datos en "Object"
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT t.name,t.start,t.end,c.description,p.description priv,t.id FROM tournament t INNER JOIN category c ON c.id=t.category_id INNER JOIN privacy p ON p.id=t.privacy WHERE t.usuario_id=1 ORDER BY end desc");
ResultSet res = pstm.executeQuery();
int i = 0;
while(res.next()){
   
    String nombre = res.getString("name");
    String inicio = res.getString("start");
    String fin = res.getString("end");
    String desc = res.getString("description");
    String priv = res.getString("priv");
    int id= res.getInt("id");

    
    data[i][0] = nombre;
    data[i][1] = inicio;
    data[i][2] = fin; 
    data[i][3] = desc; 
    data[i][4] = priv;
    data[i][5] = id;
    i++;
}
res.close();
}catch(SQLException e){ System.out.println(e);}
return data;
}

///usado en trimat
public void newusuario(String name,String username,String email,String password,int id_role){
try {
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("insert into " +
"user(name,username,email,password,user_role_id) values(?,?,?,?,?)");
pstm.setString(1,name);
pstm.setString(2,username);
pstm.setString(3,email);
pstm.setString(4,password);
pstm.setInt(5,id_role);
pstm.execute();
pstm.close();
}catch(SQLException e){
System.out.println(e);
}
}

/// inicio agregar usuario activado
public String Alta(String codigo){
String mensaje=""; 
int registros = 0;  
    try {                                 
        con = new conexion();
        PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) as total FROM usertmp WHERE code=\'"+codigo+"\'");
        ResultSet res = pstm.executeQuery();
        res.next();
        registros = res.getInt("total");
        res.close();
                    
                    
        } catch (SQLException ex) {
            Logger.getLogger(Consultass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    if((registros==1)){
            try {
                try {             
                    PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT " +
                    " name,username,email,password,user_role_id" +
                    " FROM usertmp WHERE code =\'"+codigo+"\'");
                    ResultSet res = pstm.executeQuery(); 
                    String name = "";
                    String username = "";
                    String mail = "";
                    String pass= "";
                    int user_role = 0;                    
                    
                    while(res.next()){
                    name = res.getString("name");
                    username = res.getString("username");
                    mail = res.getString("email");
                    pass = res.getString("password");
                    user_role = res.getInt("user_role_id");
                    mensaje=user_role+"";                    
                    }
                    res.close();
                    con = new conexion();
                    newusuario(name, username,mail, pass,user_role);
                    
                    
                  //  con = new conexion();
                } catch (SQLException ex) {
                    System.out.println("error"+ex);
                }
            
                  String sql2= "delete from usertmp where code ="+codigo;
                  conexion con = new conexion();  
                  PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(sql2);
                  pstm.execute();
            } catch (SQLException ex) {
                Logger.getLogger(Consultass.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
         System.out.println("error");
        }
    
    
return mensaje;
}
/// fin agregar usuario activado




public void newusuarioTmp(String name,String username,String email,String password,String id_role, int code){
try {
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("insert into " +
"usertmp(name,username,email,password,user_role_id,code) values(?,?,?,?,?,?)");
pstm.setString(1,name);
pstm.setString(2,username);
pstm.setString(3,email);
pstm.setString(4,password);
pstm.setString(5,id_role);
pstm.setInt(6,code);
pstm.execute();
pstm.close();
}catch(SQLException e){
System.out.println(e);
}
}


///usado en trimat
public void newtorneo(String name,String ini,String fin,String pri,String cate,String userid){
try {
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("insert into " +
"tournament(name,start,end,privacy,category_id,usuario_id) values(?,?,?,?,?,?)");
pstm.setString(1,name);
pstm.setString(2,ini);
pstm.setString(3,fin);
pstm.setString(4,pri);
pstm.setString(5,cate);
pstm.setString(6,userid);
pstm.execute();
pstm.close();
}catch(SQLException e){
System.out.println(e);
}
}




///////////// usado en trimat
public Object [][] getDatosCategoria(){
int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) as total FROM category");
ResultSet res = pstm.executeQuery();
res.next();
registros = res.getInt("total");
res.close();
}catch(SQLException e){
System.out.println(e);
}
Object[][] data = new Object[registros][2];
//realizamos la consulta sql y llenamos los datos en "Object"
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT id,description FROM category");
ResultSet res = pstm.executeQuery();
int i = 0;
while(res.next()){
   
    String id = res.getString("id");
    String des = res.getString("description");
    data[i][0] = id;
    data[i][1] = des;   
    i++;
}
res.close();
}catch(SQLException e){ System.out.println(e);}
return data;
}



///////////// usado en trimat
public Object [][] getDatosPrivacidad(){
int registros = 0;
//obtenemos la cantidad de registros existentes en la tabla
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) as total FROM privacy");
ResultSet res = pstm.executeQuery();
res.next();
registros = res.getInt("total");
res.close();
}catch(SQLException e){
System.out.println(e);
}
Object[][] data = new Object[registros][2];
//realizamos la consulta sql y llenamos los datos en "Object"
try{
PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT id,description FROM privacy");
ResultSet res = pstm.executeQuery();
int i = 0;
while(res.next()){
   
    String id = res.getString("id");
    String des = res.getString("description");
    data[i][0] = id;
    data[i][1] = des;   
    i++;
}
res.close();
}catch(SQLException e){ System.out.println(e);}
return data;
}
//trimat actualizar torneos
public void ActTorneo(int  id,String nombre,String ini,String fin,int priv,int cat){
    String sql= "UPDATE tournament SET "
            +" name= "+"\'"+nombre+"\'"
            +", start= "+"\'"+ini+"\'"    
            +", end= "+"\'"+fin+"\'" 
            +", privacy="+"\'"+priv+"\'" 
            +",category_id="+cat
            +"  WHERE id="+id;   
    //+" nombre= "+"\'"+username.toUpperCase()+"\'"
        try {
            PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(sql);
            pstm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(""+ex);
        }
}

////
public int idCategory(String desc){
    int valor=0;
    ///////////////////////////////
    int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{
        PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) as total FROM category WHERE description=\'"+desc+"\'");
        ResultSet res = pstm.executeQuery();
        res.next();
        registros = res.getInt("total");
        res.close();
        }catch(SQLException e){
        System.out.println(e);
        }
        Object[][] data = new Object[registros][1];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try{
        PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT " +
        "id" +
        " FROM category WHERE description=\'"+desc+"\'");
        ResultSet res = pstm.executeQuery();
        int i = 0;
        while(res.next()){
            valor = res.getInt("id");  
        }
        res.close();
        }catch(SQLException e){ System.out.println(e);}
    ///////////////////////////////
    return valor;
}

//
public int idPrivacy(String desc){
  //  javax.swing.JOptionPane.showMessageDialog(null, ""+desc);
    int valor=0;
    ///////////////////////////////
    
    
    ///////////////////////////////
    int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{
        PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) as total FROM privacy WHERE description=\'"+desc+"\'");
        ResultSet res = pstm.executeQuery();
        res.next();
        registros = res.getInt("total");
        res.close();
        }catch(SQLException e){
        System.out.println(e);
        }
        Object[][] data = new Object[registros][1];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try{
        PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT " +
        "id" +
        " FROM privacy WHERE description=\'"+desc+"\'");
        ResultSet res = pstm.executeQuery();
        int i = 0;
        while(res.next()){
            valor = res.getInt("id");  
        }
        res.close();
        }catch(SQLException e){ System.out.println(e);}
    ///////////////////////////////
    return valor;
}

public int idUser(String user){
  //  javax.swing.JOptionPane.showMessageDialog(null, ""+desc);
    int valor=0;
    ///////////////////////////////
    
    
    ///////////////////////////////
    int registros = 0;
        //obtenemos la cantidad de registros existentes en la tabla
        try{
        PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT count(1) as total FROM `user` WHERE username=\'"+user+"\'");
        ResultSet res = pstm.executeQuery();
        res.next();
        registros = res.getInt("total");
        res.close();
        }catch(SQLException e){
        System.out.println(e);
        }
        Object[][] data = new Object[registros][1];
        //realizamos la consulta sql y llenamos los datos en "Object"
        try{
        PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement("SELECT " +
        "user_role_id" +
        " FROM `user` WHERE username=\'"+user+"\'");
        ResultSet res = pstm.executeQuery();
        int i = 0;
        while(res.next()){
            valor = res.getInt("user_role_id");  
        }
        res.close();
        }catch(SQLException e){ System.out.println(e);}
    ///////////////////////////////
    return valor;
}


public void TElim(String nombre){
      String sql= "DELETE from tournament WHERE name=\'"+nombre+"\'";                  
        try {
            PreparedStatement pstm = (PreparedStatement) con.getConnection().prepareStatement(sql);
            pstm.execute();
        } catch (SQLException ex) {
            System.out.println(""+ex);
        //    JOptionPane.showMessageDialog(null, ex);
        }
}

}
