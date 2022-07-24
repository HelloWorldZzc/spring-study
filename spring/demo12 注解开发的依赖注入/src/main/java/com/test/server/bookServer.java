package com.test.server;
import com.test.dao.bookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Repository
@Scope("singleton")
public class bookServer {
    //使用这样的方式注入常量类型 同时也能够自己写入
    @Value("${name}")
    String name;
    //Autowired表示注入  这是自动注入的方式,能省略set方法 原理是利用了反射
    @Autowired
    //当只有一个类的时候呢,可以自动注入,不用我们写
    //当时要是有其他几个类的时候,不知道使用哪里,就可以使用此方法,指定注入的名称
    //但这样的方式也存在着缺点,就比如很高的耦合性
    @Qualifier("bookdao")
    private bookDao bookdao;
    public void save() {
        System.out.println("book service save ..."+"   "+name);
        bookdao.save();
    }
    //表示生命周期init
    @PostConstruct
    public void init(){
        System.out.println("init");
    }
    //表示生命周期destroy
    @PreDestroy
    public void destroy(){
        System.out.println("dead");
    }

}
