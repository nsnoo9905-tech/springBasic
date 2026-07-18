package com.example.springBasic.order;

import com.example.springBasic.annotation.MainDiscountPolicy;
import com.example.springBasic.discount.DiscountPolicy;
import com.example.springBasic.discount.FixDiscountPolicy;
import com.example.springBasic.discount.RateDiscountPolicy;
import com.example.springBasic.member.Member;
import com.example.springBasic.member.MemberRepository;
import com.example.springBasic.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    private DiscountPolicy rateDiscountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
