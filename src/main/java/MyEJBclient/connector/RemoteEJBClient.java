package MyEJBclient.connector;



import ch.qos.logback.classic.pattern.ClassicConverter;
import com.ncproject.webstore.ejb.CartBeanInterface;
import com.ncproject.webstore.ejb.ProductBeanInterface;
import com.ncproject.webstore.ejb.beans.CartBean;
import com.ncproject.webstore.ejb.beans.ProductBean;
import com.ncproject.webstore.entity.Product;

import javax.naming.*;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;


public class RemoteEJBClient {

//    public static void main(String[] args) throws Exception {
//        invokeStatelessBean();
//    }

    public static <T> T getBeanInterface(T tt) throws NamingException {

        final Hashtable jndiProperties = new Hashtable();
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        final Context context = new InitialContext(jndiProperties);

        final String appName = "";
        final String moduleName = "webstore";
        final String distinctName = "";
        final String beanName = tt.getClass().getSimpleName();

        final String viewClassName = tt.getClass().getInterfaces()[0].getName() + "?stateful";
        System.out.println("Looking EJB via JNDI ");
        System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
        String s = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
         T ejbHelloWorld = (T) context.lookup(s);
//        System.out.println(ejbHelloWorld.testRemote());

        return ejbHelloWorld;

    }



//    public List<Product> getAllProducts() throws NamingException {
//
//        final Hashtable jndiProperties = new Hashtable();
//        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//        final Context context = new InitialContext(jndiProperties);
//
//        final String appName = "";
//        final String moduleName = "webstore";
//        final String distinctName = "";
//        final String beanName = ProductBean.class.getSimpleName();
//
//        final String viewClassName = ProductBeanInterface.class.getName() + "?stateful";
//        System.out.println("Looking EJB via JNDI ");
//        System.out.println("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
//        String s = "ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName;
//        final ProductBeanInterface ejbHelloWorld = (ProductBeanInterface) context.lookup(s);
//        List<Product> str = ejbHelloWorld.getAllProducts();
//        System.out.println(str.toString());
//        return str;
//    }


}
