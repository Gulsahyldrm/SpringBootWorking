package org.example.iocanddependecyinjection;

public class CustomerDal implements ICustomerDal{
    public void add(){
        System.out.println("Oracle veri tabanına eklendi");
    }
}
