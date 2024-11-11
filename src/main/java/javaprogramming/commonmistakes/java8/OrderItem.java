package javaprogramming.commonmistakes.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private Long productId;
    private String productName;
    private Double productPrice;
    // 商品数量
    private Integer productQuantity;
}
