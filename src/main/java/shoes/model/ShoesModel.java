package shoes.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import shoes.connection.Connection;
import shoes.entities.Shoes;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SteevenE
 */
public class ShoesModel {
    private EntityManager entityManager(){
        
        
        return Connection.getInstance().getEmf().createEntityManager();
    }
    
    public List<Shoes> list(){
        
        Query q = entityManager().
              createQuery("SELECT s FROM Shoes AS s", shoes.entities.Shoes.class);
        
      return q.getResultList();
    }
    
    
    public void create (Shoes shoes){
        EntityManager entity  = entityManager();
        
        try{
            entity.getTransaction().begin();
            entity.persist(shoes);
            entity.getTransaction().commit();
        }catch(Exception e){
            entity.getTransaction().rollback();
        }
    }
    
    public void mod (Shoes shoes){
        EntityManager entity  = entityManager();
        
        try{
            entity.getTransaction().begin();
            entity.merge(shoes);
            entity.getTransaction().commit();
        }catch(Exception e){
            entity.getTransaction().rollback();
        }
    }
    
    public void delete (Shoes shoes){
        EntityManager entity  = entityManager();
        
        try{
            entity.getTransaction().begin();
            entity.remove(entity.merge(shoes));
            entity.getTransaction().commit();
        }catch(Exception e){
            entity.getTransaction().rollback();
        }
    }
}
