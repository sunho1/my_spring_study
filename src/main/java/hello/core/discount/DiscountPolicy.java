package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /*가격 할인 */
    int discount(Member member, int price);
}
