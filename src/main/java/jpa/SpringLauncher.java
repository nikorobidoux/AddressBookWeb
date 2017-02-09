package jpa; /**
 * Created by craigshorrocks on 1/26/2017.
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class SpringLauncher {

    public static void main(String[] args) {
        String[] contextPaths = new String[]{"app.xml"};
        new ClassPathXmlApplicationContext(contextPaths);
    }

}
