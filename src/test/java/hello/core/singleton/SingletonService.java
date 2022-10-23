package hello.core.singleton;

public class SingletonService {

    private static final  SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //밖에서 임의로 생성할 수 없도록 생성자를 private로
    private SingletonService(){

    }


    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
