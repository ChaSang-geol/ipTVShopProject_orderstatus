package ipTVShopProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderStatusController {
    @Autowired
    OrderStatusRepository orderStatusRepo;

    // orderID로 orderStatuses 조회하는 API 제공
    @RequestMapping(method= RequestMethod.GET, path="/orderStatuses/orderID")
    public String getStatusByOrderID (@RequestParam("id") Long orderID){
        System.out.println("##### getStatusByOrderID Start orderID: " + orderID);

        List<OrderStatus> searchOrderStatus = orderStatusRepo.findByOrderId(orderID);

        return searchOrderStatus.get(0).toString();
    }
}
