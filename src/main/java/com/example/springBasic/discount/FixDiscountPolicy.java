package com.example.springBasic.discount;

import com.example.springBasic.member.Grade;
import com.example.springBasic.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
