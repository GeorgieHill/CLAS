package src.main.java.clas;

import javafx.beans.property.SimpleStringProperty;

/**
 * The class represents abstract entity of domain model
 */
public abstract class Entity {
    
    private SimpleStringProperty id;

    /**
     * Returns unique id of persistent object
     * @return unique id
     */
    public String getID() {
		return id.get();	
    }

    /**
     * Sets unique id of persistent object
     * @param id unique id
     */
    public void setID(String id) {
		this.id.set(id);	
    }

    /**
     * Compares this entity to the given object. The result is {@code true} if
     * and only if argument is not {@code null}, the class of this entity equals
     * to the class of argument and unique id of this entity equals to unique id
     * of argument.
     * @param other the object to compare this {@code Entity} against
     * @return a result of comparison of this entity to the given object
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Entity that = (Entity) other;
        return id != null ? id.equals(that.id) : that.id == null;
    }
}
