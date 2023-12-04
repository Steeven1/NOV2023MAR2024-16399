/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shoes.entities;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.Query;


/**
 *
 * @author SteevenE
 */
public class TestDB {
    
    
    
    
    public static void main(String[] args){
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("shoes_store.odb");
      EntityManager em = emf.createEntityManager();
      
      //Crear un par de zapatos
      /*em.getTransaction().begin();
      em.persist(new Shoes("Air Jordan", "Nike", "38"));
      em.getTransaction().commit();
      */
      //consulta;
      Query q1 = em.
              createQuery("SELECT s FROM Shoes AS s");
      System.out.print(q1.getResultList());
      
    try{
        em.getTransaction().begin();
         Query query = em.createQuery(
      "DELETE FROM Shoes AS s WHERE s.id = :id");
        query.setParameter("id",Long.valueOf("1")).executeUpdate();
        em.getTransaction().commit();
    }catch(Exception ex){
        ex.printStackTrace();
    }
   
        
       Query q2 = em.
              createQuery("SELECT s FROM Shoes AS s");
      System.out.print(q1.getResultList());
    }
    
}










