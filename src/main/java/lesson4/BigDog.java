package lesson4;

public class BigDog extends Dog{

    public BigDog(String name) {
        super(name);
    }

    public void greets(){
        System.out.println("GAF");
    }

    public void greets(Dog dog){
        System.out.println("GAFGAF");
    }

    public void greets(BigDog bigDog){
        System.out.println("GAFGAFGAFFFFFF");
    }


}
