package org.example.iocanddependecyinjection;


//!!implement veya extend siz clas olmasın bussines katmanının da controller tarafında kullanılması amacıyla Interface oluştur!
public class CustomerManager implements ICustomerService {

   private ICustomerDal customerDal;

   //Constructor injection (en çok tercih edilen injection türü)
    public CustomerManager(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }


    //Setter Injection
    public void setCustomerDal(ICustomerDal customerDal) {
        this.customerDal = customerDal;
    }


    public void add(){
        //iş koşulları
        //!! Bir class diğer bir clası kullanmak için onu newlememeli temiz kod için (injection yapılmalı)
        //CustomerDal customerDal = new CustomerDal();
        customerDal.add();
    }
}
