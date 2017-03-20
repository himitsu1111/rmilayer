package MyEJBclient.connector;

import javax.naming.*;
import java.util.Hashtable;

public class RemoteEJBClient {

    /**
     *
     * @param tt - ��������� ������ ���������� ����
     * @param <T> - � ����� ���������� ����
     * @return - EJB �� webstore
     * @throws NamingException
     */

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

        return ejbHelloWorld;

    }
}
