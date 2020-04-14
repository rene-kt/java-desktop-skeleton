
package model.dao;

import model.bean.Pessoa;
import connection.ConnectionFactory;
import javax.persistence.EntityManager;
 

/**
 *
 * @author Informática
 */
public abstract class DaoGenerico<T extends Pessoa> {

    EntityManager em = new ConnectionFactory().getConnection();

    public T getById(Integer id, Class<T> clazz) {
        return em.find(clazz, id);
    }

    public void saveOrUpdate(T obj) {
        try {
            em.getTransaction().begin();
            if (obj.getId() == null) {
                em.persist(obj);
            } else {
                em.merge(obj);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e);
        } finally {
            em.close();
        }
    }

    public void remove(Class<T> clazz, Integer id) {
        T t = getById(id, clazz);
        try {
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.out.println(e);
        }finally{
            em.close();
        }
    }

}
