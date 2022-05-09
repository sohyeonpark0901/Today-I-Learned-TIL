package hello.core.singleton;

public class StatefulService {
    // 공유되는 필드인데, 특정 클라이언트가 값을 변경 가능할 수 있다.
    // 진짜 공유필드는 조심해야 한다.
//    private int price; // 상태를 유지하는 필드
//
//    public void order(String name, int price){
//        System.out.println("name = " + name + "price = " + price);
//        this.price = price; // 여기가 문제
//    }
    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        return price;
    }

//    public int getPrice(){
//        return price;
//    }
}
