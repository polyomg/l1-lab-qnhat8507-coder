package poly.edu.tv00059_lab6.entity;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double price;
    Integer quantity;

    @ManyToOne
    @JoinColumn(name = "Productid")
    Product product;

    @ManyToOne
    @JoinColumn(name = "Orderid")
    Order order;
}
