package fr.utbm.eformation.core.repository;

/**
 * All repository classes have to implement DAOInterface
 * @author java
 */
public interface DAOInterface<T> {
    /**
  * Insert in database an object
  * @param obj
  * @return int  
  */
  public  int insert(T obj);

  /**
  * Delete in database the row corresponding to the object
  * @param obj
  * @return int 
  */
  public  int delete(T obj);

  /**
  * update the row corresponding to the object
  * @param obj
  * @return int
  */
  public  int update(T obj);

  /**
  * get information about object with id in parameter
  * @param id
  * @return T
  */
  public T find(int id);

}
