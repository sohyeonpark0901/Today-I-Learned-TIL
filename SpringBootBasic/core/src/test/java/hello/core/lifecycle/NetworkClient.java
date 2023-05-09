package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자호출, url = "+url);
    }

    public void setUrl(String url) {
        this.url = url;
    }
    //서비스 시작 시 호출
    public void connect(){
        System.out.println("connect: "+url);
    }

    public void call(String message){
        System.out.println("call = "+url+" message = "+message);
    }

    //서비스 종료 시 호출
    public void disconnect(){
        System.out.println("cles " + url);
    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("Network.init()");
        connect();
        call("초기화 연결 메세지");
    }

    @PreDestroy
    public void close() throws Exception {
        System.out.println("Network.close()");
        disconnect();
    }
}
