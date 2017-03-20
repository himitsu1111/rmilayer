package MyEJBclient.SpringBean;

import javax.ejb.EJB;

/**
 * Created by secret on 17.03.2017.
 */
public final class ProductBean {
    @EJB(mappedName="ejb:/webstore//CartBean!com.ncproject.webstore.ejb.CartBeanInterface?stateful")
    ProductBean exampleEJB;
}
