import MyEJBclient.SpringBean.ProductBean;
import MyEJBclient.connector.RemoteEJBClient;
import MyRMI.RMInterface;
import com.ncproject.webstore.ejb.CartBeanInterface;
import com.ncproject.webstore.ejb.ProductBeanInterface;
import com.ncproject.webstore.ejb.beans.CartBean;
import com.ncproject.webstore.entity.Product;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() throws NamingException, IllegalAccessException, InstantiationException {

        RemoteEJBClient remoteEJBClient = new RemoteEJBClient();


        //вот так получать классы EJB
        CartBeanInterface cbii = new CartBean();
        CartBeanInterface cbi = RemoteEJBClient.getBeanInterface(cbii);

        ProductBeanInterface pbi = new com.ncproject.webstore.ejb.beans.ProductBean();
        ProductBeanInterface pbii = RemoteEJBClient.getBeanInterface(pbi);


        return "Hello World and " + cbi.testRemote() + pbii.getAllProducts();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
