import MyEJBclient.SpringBean.ProductBean;
import MyEJBclient.connector.RemoteEJBClient;
import MyRMI.RMInterface;
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
    String home() throws NamingException {

        RemoteEJBClient remoteEJBClient = new RemoteEJBClient();

        String s = remoteEJBClient.invokeStatelessBean();
        List<Product> s2 = remoteEJBClient.getAllProducts();

//        ProductBean pb = ProductBean.class.newInstance();

        return "Hello World and " + s2.toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
