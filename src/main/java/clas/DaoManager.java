package src.main.java.clas;

import java.lang.reflect.ParameterizedType;

public class DaoManager<T extends Entity> {

	/*
    private SessionFactory sessionFactory;

    
    private final Class<T> type = getType();

   
    protected Class<T> getType() {
        return (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    
    public void saveOrUpdate(T entity) {
        
    	getSession().saveOrUpdate(entity);
    }

    
    public void delete(T entity) {
        getSession().delete(entity);
    }

    
    public T getById(String id) {
       
    	return (T)getSession().get(type, id);
    }

    
    @Override
    public boolean isExist(String id) {
        
    	return getById(id) != null;
    }
    */
}
