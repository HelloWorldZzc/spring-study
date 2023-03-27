import com.study.Calculator;
import com.study.CalculatorPureImpl;
import com.study.server.ProxyFactory;
import org.junit.Test;


public class proxy_demo {
    @Test
    public void proxy_test() throws Exception {
        //创建对象 --->使用多态的方式
        Calculator c = new CalculatorPureImpl();
        //创建动态代理对象
        ProxyFactory proxyFactory = new ProxyFactory(c);
        //获取动态代理--->不能获取object 把他给强转，因为我们实现了相关的接口
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        proxy.add(1,2);


        //或者利用反射调取里面的方法执行(了解，反射内容的巩固)
        /*Object proxy = proxyFactory.getProxy();
        Class<?> aClass = proxy.getClass();
        //可以查看到里面的方法，就不进行展示了
        Method[] methods = aClass.getMethods();
        //我们执行减法
        Method sub = aClass.getMethod("sub", int.class, int.class);
        sub.invoke(proxy, 4, 1);*/
    }
}
