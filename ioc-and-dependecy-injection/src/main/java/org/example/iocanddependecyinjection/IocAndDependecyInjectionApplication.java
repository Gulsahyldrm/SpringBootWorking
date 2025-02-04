package org.example.iocanddependecyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IocAndDependecyInjectionApplication {

    public static void main(String[] args) {

        CustomerManager manager = new CustomerManager(new MySqlCustomerDal());
        manager.add();

        //SpringApplication.run(IocAndDependecyInjectionApplication.class, args);
    }

    //IoC - Inversion of Control
    //Bu yapıyı ayağa kaldıran tasarım deseni ise Dependency Injection dur

}
