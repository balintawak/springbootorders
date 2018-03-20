package work.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrdersNameAndQuantity
{
    @Id
    private String name;
    private int quantity;

    public OrdersNameAndQuantity() {}

    public OrdersNameAndQuantity (String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getName ()
    {
        return name;
    }

    public void setQuantity (int quantity)
    {
        this.quantity = quantity;
    }

    public int getQuantity ()
    {
        return quantity;
    }
}