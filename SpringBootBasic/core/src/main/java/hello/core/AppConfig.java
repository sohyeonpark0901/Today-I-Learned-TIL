package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
 * MemberServiceImpl
 * MemoryMemberRepository
 * OrderServiceImpl
 * FixDiscountPolicy
 * */

/**
 * AppConfig는 생성한 객체 인스턴스의 참조(레퍼런스)를 생성자를 통해서 주입(연결)해준다.
 * MemberServiceImpl -> MemoryMemberRepository
 * OrderServiceImpl -> MemoryMemberRepository,FixDiscountPolicy
 * */

/**
 * AppConfig 객체는 memoryMemberRepository 객체를 생성하고 그 참조값을 memberServiceImpl을 생성하면서 생성자로 전달한다.
 * 클라이언트인 memberServiceImpl 입장에서 보면 의존 관계를 마치 외부에서 주입해주는 것 같다고 해서 DI(Dependency Injection)
 * 우리말로 의존관계 주입 또는 의존성 주입이라고 한다.
 * */

@Configuration
public class AppConfig { // DI 컨테이

    /**
     * <AppConfig 리팩터링>
     * 구성정보에서 역할과 구현을 명확하게 분리
     * 역할이 잘 늘어남
     * 중복 제거
     * 할인 정책을 변경해도 AppConfig가 있는 구성 영역에만 변경하면 됨, 사용 영역은 변경할 필요가 없음. 물론 클라이언트 코드인 주문
     * 서비스 코드도 변경하지 않
     * */
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    // MemoryMemberRepository를 다른 구현체로 변경할 때 이 부분만 변경하면 된다.
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}

/**
 * MemberServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지(주입될지) 알 수 없다.
 * MemberServiceImpl 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부('AppConfig')에서 결정한다.
 * MemberServiceImpl 은 이제부터 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다.
 * */