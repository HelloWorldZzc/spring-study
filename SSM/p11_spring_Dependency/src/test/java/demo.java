import com.study.pojo.clazz;
import com.study.pojo.student;
import com.study.pojo.teacher;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo {
    static ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test_1(){
        //依赖注入 之setter注入测试
        student student1 = ac.getBean("student1", student.class);
        System.out.println(student1);
    }

    @Test
    public void test_2(){
        //依赖注入之 构造器注入
        student student2 = ac.getBean("student2", student.class);
        System.out.println(student2);
    }
    @Test
    public void test_3(){
        student student3 = ac.getBean("student3", student.class);
        System.out.println(student3);
    }

    //数组形式
    @Test
    public void test_4(){
        student student4 = ac.getBean("student4", student.class);
        System.out.println(student4);
    }

    //为类类型属性赋值--->外部类
    @Test
    public void test_5(){
        student student5 = ac.getBean("student5", student.class);
        System.out.println(student5);
    }

    //为类类型属性赋值--->内部类
    @Test
    public void test_6(){
        student student6 = ac.getBean("student6", student.class);
        System.out.println(student6);
    }

    //为集合赋值--->list集合
    @Test
    public void test_7(){
        clazz class2 = ac.getBean("class2", clazz.class);
        System.out.println(class2);
    }

    //为集合赋值--->map--->传统方式
    @Test
    public void test_8(){
        clazz class3 = ac.getBean("class3", clazz.class);
        System.out.println(class3);
    }
    //为集合赋值--->使用until规则
    @Test
    public void test_9(){
        clazz class4 = ac.getBean("class4", clazz.class);
        System.out.println(class4);
    }
    //p标签的使用--->了解
    @Test
    public void test_10(){
        teacher s = ac.getBean("s", teacher.class);
        System.out.println(s);
    }


}
