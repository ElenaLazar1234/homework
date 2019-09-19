package week15;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class Product implements Serializable {
    /*
productCode varchar(15) PK
productName varchar(70)
productLine varchar(50)
productScale varchar(10)
productVendor varchar(50)
productDescription text
quantityInStock smallint(6)
buyPrice decimal(10,2)
MSRP decimal


     */
    private String productCode;
    private String productName;
    private String productLine;
    private String productScale;
    private String productVendor;
    private String productDescription;
    private int quantityInStock;
    private BigDecimal buyPrice;
    private Double MSRP;
}
