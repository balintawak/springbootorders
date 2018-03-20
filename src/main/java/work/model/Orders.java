package work.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Orders
{
    @Id
    private String order_id;
    private String name;
    private int quantity;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Orders () {}

    public Orders (String name, int total_quantity_sold)
    {
        this.name = name;
        this.quantity = total_quantity_sold;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public void setQuantity (int quantity)
    {
        this.quantity = quantity;
    }

    public Orders (String order_id, String name, int quantity, LocalDateTime
            created_at, LocalDateTime updated_at)
    {
        this.order_id = order_id;
        this.name = name;
        this.quantity = quantity;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getOrder_id ()
    {
        return order_id;
    }

    public String getName ()
    {
        return name;
    }

    public int getQuantity ()
    {
        return quantity;
    }

    public LocalDateTime getCreated_at ()
    {
        return created_at;
    }

    public LocalDateTime getUpdated_at ()
    {
        return updated_at;
    }

    public void setUpdated_at (LocalDateTime localDateTime)
    {
        updated_at = localDateTime;
    }

    public String toString ()
    {
        final StringBuilder sb = new StringBuilder();

        sb.append("{ order_id: " + order_id);
        sb.append(", name: " + name);
        sb.append(", quantity: " + quantity);
        sb.append(", created_at: " + created_at);
        sb.append(", updated_at: " + updated_at).append(" }");

        return sb.toString();
    }
}
