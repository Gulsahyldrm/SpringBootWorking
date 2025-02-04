package org.example.iocanddependecyinjection;

public class MySqlCustomerDal implements ICustomerDal{
    @Override
    public void add(){
        System.out.println("MySql veri tabanına eklendi");
    }
}
