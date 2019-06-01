package com.netcracker;

import com.netcracker.autowire.byName.Application;
import com.netcracker.autowire.byType.Employee;
import com.netcracker.autowire.constructor.Performer;
import com.netcracker.autowire.no.Driver;
import com.netcracker.factory.Printable;
import com.netcracker.firstAndSecondTasks.MusicPlayer;
import com.netcracker.inheritanceOfBeans.HelloIndia;
import com.netcracker.inheritanceOfBeans.HelloWorld;
import com.netcracker.lookupInjection.Car;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.applet.Applet;

public class Main {
    public static void main(String[] args) {
        //FirstTask////////////////////////////
        System.out.println("Objects and Primitives---------->");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
          "applicationContext.xml"
        );

        //SI
        //object
        System.out.println("SI:");
        MusicPlayer musicPlayerSI = context.getBean("musicPlayerSI", MusicPlayer.class);
        musicPlayerSI.playMusic();
        //primitive
        System.out.println(musicPlayerSI.getVolume());

        //CI
        //object
        System.out.println("CI:");
        MusicPlayer musicPlayerCI = context.getBean("musicPlayerCI", MusicPlayer.class);
        musicPlayerCI.playMusic();
        //primitive
        System.out.println(musicPlayerCI.getVolume());
        context.close();

        System.out.println();
        //collections(Second Task)
        System.out.println("Collections---------->");
        ClassPathXmlApplicationContext contextForCollections = new ClassPathXmlApplicationContext(
                "collections.xml"
        );

        //SI
        System.out.println("SI:");
        MusicPlayer musicPlayerColelctionSI = contextForCollections.getBean("musicPlayerSI", MusicPlayer.class);
        //list
        System.out.println("LIST");
        musicPlayerColelctionSI.playMusicList();
        //set
        System.out.println("SET");
        musicPlayerColelctionSI.playMusicSet();
        //map
        System.out.println("MAP");
        musicPlayerColelctionSI.playMusicMap();

        //CI
        System.out.println("CI:");
        MusicPlayer musicPlayerColelctionCI = contextForCollections.getBean("musicPlayerCI", MusicPlayer.class);
        //list
        System.out.println("LIST");
        musicPlayerColelctionCI.playMusicList();
        //set
        System.out.println("SET");
        musicPlayerColelctionCI.playMusicSet();
        //map
        System.out.println("MAP");
        musicPlayerColelctionCI.playMusicMap();

        contextForCollections.close();

        System.out.println();
        /////////INHERITANCE OF BEANS
        System.out.println("INHERITANCE OF BEANS------------>");
        ClassPathXmlApplicationContext contextForInheritance = new ClassPathXmlApplicationContext(
                "inheritance.xml"
        );
        HelloWorld beanFromParentClass = (HelloWorld) contextForInheritance.getBean("helloWorld", HelloWorld.class);
        beanFromParentClass.getMessage1();
        beanFromParentClass.getMessage2();

        HelloIndia beanFromInheritedClass = (HelloIndia) contextForInheritance.getBean("helloIndia");
        beanFromInheritedClass.getMessage1();
        beanFromInheritedClass.getMessage2();
        beanFromInheritedClass.getMessage3();

        contextForInheritance.close();

        System.out.println();
        ////////////SPEL
        System.out.println("SPEL----------->");
        ClassPathXmlApplicationContext contextForSpel = new ClassPathXmlApplicationContext(
                "spelConfig.xml"
        );
        System.out.println(contextForSpel.getBean("finalBean").toString());

        contextForSpel.close();

        System.out.println();
        ///////////FACTORY
        System.out.println("FACTORY----------->");
        ClassPathXmlApplicationContext contextForFactory = new ClassPathXmlApplicationContext(
                "factory.xml"
        );
        System.out.println("factory method:");
        Printable carObject = (Printable) contextForFactory.getBean("factory-method");
        carObject.print();

        System.out.println("bean method:");
        Printable trainObject = (Printable) contextForFactory.getBean("bean-method");
        trainObject.print();

        contextForFactory.close();

        System.out.println();
        ///////////AUTOWIRE
        System.out.println("AUTOWIRE----------->");
        ClassPathXmlApplicationContext contextForAutowire = new ClassPathXmlApplicationContext(
                "autowire.xml"
        );

        Application application = (Application) contextForAutowire.getBean("application");
        System.out.println("byName: " + application);

        Employee employee = (Employee)contextForAutowire.getBean("employee");
        System.out.println("byType : " + employee);

        Performer performer = (Performer)contextForAutowire.getBean("performer");
        System.out.println("constructor: " + performer);

        Driver driver = (Driver)contextForAutowire.getBean("driver");
        System.out.println("no: " + driver);

        contextForAutowire.close();

        System.out.println();
        /////////LOOKUP METHOD OF INJECTION
        System.out.println("Look up method of injection ------------>");
        ClassPathXmlApplicationContext contextForLookupInj = new ClassPathXmlApplicationContext(
                "lookupInj.xml"
        );

        Car car = contextForLookupInj.getBean(Car.class);
        System.out.println(car.drive("Alex"));
        System.out.println(car.drive("John"));
    }
}
