package hello.core.member;


import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig=new AppConfig();
        this.memberService= appConfig.memberService();
    }
    
    @Test
    void join(){
        //given : 조건
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when : 상황
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then : 결과
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
