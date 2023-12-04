/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author SteevenE
 */
public class Connection {
    private static Connection instance = new Connection();
    private EntityManagerFactory emf;
    
    private Connection(){
        emf = Persistence.createEntityManagerFactory("shoes_store.odb");
    }

    public static Connection getInstance() {
        return instance;
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }
    
}
