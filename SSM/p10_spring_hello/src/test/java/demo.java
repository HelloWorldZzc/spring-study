import com.study.helloworld;
import com.study.student;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class demo {
    static ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test_spring(){
        //这里我们已经获取到相关的对象了，使用反射验证一下
        Object hello = ac.getBean("hello");
        Class<?> aClass = hello.getClass();
        Method[] declaredMethods = aClass.getDeclaredMethods();
        try {
            declaredMethods[1].invoke(hello,null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //其实使用强转，也能实现相关的效果
        ((helloworld)hello).bye();
    }

    @Test
    public void ioc(){
        //他是如何帮我们创建对象的呢？--->反射+工厂模式，但是帮我们创建的对象都是空参的
        student bean = ac.getBean(student.class);
        System.out.println(bean);
        //所以他是利用反射的原理，在底层调用空参构造--->如何验证?--->在javabean中去除空参构造的方法，他会出错
        //java.lang.NoSuchMethodException: com.study.student.<init>()
    }

    @Test
    public void get_beans(){
        /**
         * 获取bean的几种方式
         * 1、根据id获取（id具有唯一性）
         *      优点：准确获取
         *      缺点：返回的类型为object，需要手动强转
         * 2、根据类型获取
         *      常用&帮我们转型好了
         *      缺点：如果有多个符合类型或者没有符合类型的程序会报错
         *
         * 3、根据类型与id获取
         *      能准确获取，但是比较麻烦
         *
         *  4、扩展
         *      如果组件类实现了接口，根据接口类型可以获取 bean 吗？--->可以，前提是bean唯一
         *      如果一个接口有多个实现类，这些实现类都配置了 bean，根据接口类型可以获取 bean 吗?--->不行，因为bean不唯一
         *   5、结论
         *      在满足bean唯一性的前提下，其实只是看：对象 instanceof 指定的类型的返回结果，只要返回的是true就可以认定为和类型匹配，能够获取到。
         */
        //根据类型获取
        student bean = ac.getBean(student.class);
        //根据id与类型
        student student = ac.getBean("student", student.class);
        System.out.println(bean==student);


    }
}
