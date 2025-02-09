package org.example.iocanddependecyinjection;


import org.springframework.beans.factory.annotation.Autowired;

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

    //Field Injection (Alan Üzerinden Enjeksiyon)

    //Test yazarken veya mock'lama yaparken esneklik düşer çünkü bağımlılığa dışarıdan erişim zor olur.
    //Küçük projelerde tercih edilir, ancak büyük projelerde önerilmez.

    /*@Autowired
    private ICustomerDal customerDal;
*/



    public void add(){
        //iş koşulları
        //!! Bir class diğer bir clası kullanmak için onu newlememeli temiz kod için (injection yapılmalı)
        //CustomerDal customerDal = new CustomerDal();
        customerDal.add();
    }
}
