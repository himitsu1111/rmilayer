package MyEJBclient.SpringBean;

import MyEJBclient.connector.RemoteEJBClient;
import com.ncproject.webstore.ejb.CartBeanInterface;

import javax.naming.NamingException;

/**
 * Created by secret on 17.03.2017.
 */
public final class ProductBean {

    private CartBeanInterface cartBeanInterface;

    public CartBeanInterface getCartBeanInterface() {
        return cartBeanInterface;
    }
}
