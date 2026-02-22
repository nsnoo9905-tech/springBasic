package com.example.springBasic;

import com.example.springBasic.discount.DiscountPolicy;
import com.example.springBasic.discount.FixDiscountPolicy;
import com.example.springBasic.discount.RateDiscountPolicy;
import com.example.springBasic.member.MemberService;
import com.example.springBasic.member.MemberServiceImpl;
import com.example.springBasic.member.MemoryMemberRepository;
import com.example.springBasic.order.OrderService;
import com.example.springBasic.order.OrderServiceImpl;
import org.jspecify.annotations.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig { // 전체 역할이 다 드러나게 작성하는 것이 좋음.

    @Bean
    public MemberService memberService(){
       return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
       return new OrderServiceImpl(memberRepository(), discountPolicy());

    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
