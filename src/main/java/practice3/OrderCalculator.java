package practice3;

import java.math.BigDecimal;
import java.util.List;

public class OrderCalculator {
    private BigDecimal subTotal ;
    private List<OrderLineItem> orderLineItemList;
    private List<BigDecimal> discounts;
    private BigDecimal tax;

    public OrderCalculator(Order order){
        this.orderLineItemList = order.orderLineItemList;
        this.discounts = order.discounts;
        this.tax = order.tax;
    }
    public BigDecimal Calculate(){
        subTotal = new BigDecimal(0);
        getSubtotal();
        subtractDiscounts();
        getTotalAfterTax();
        return subTotal;
    }
    public void getSubtotal() {
        for (OrderLineItem lineItem : orderLineItemList) {
            subTotal = subTotal.add(lineItem.getPrice());
        }
    }
    public void subtractDiscounts() {
        for (BigDecimal discount : discounts) {
            subTotal = subTotal.subtract(discount);
        }
    }
    public void  getTotalAfterTax(){
        BigDecimal tax = subTotal.multiply(this.tax);
        subTotal = subTotal.add(tax);
    }
}
