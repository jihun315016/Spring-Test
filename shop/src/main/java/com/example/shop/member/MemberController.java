package com.example.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    String register() {
        return "register.html";
    }

    @PostMapping("/member")
    String member(String username, String password, String displayName) {
        Member member = new Member();
        member.setUsername(username);

        // 남이 만등 클래스의 오브젝트를 di로 쓰고 싶으면 Bean으로 등록해서 쓰면 된다.
        var hash = passwordEncoder.encode(password);
        member.setPassword(hash);
        member.setDisplayName(displayName);
        this.memberRepository.save(member);
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login() {
        var result = memberRepository.findByUsername("user01");
        System.out.println(result);
        return "login.html";
    }

    // 함수 위에 이런거 쓰면 로그인 여부 검사하는 로직 간편하게 넣기 가능
//    @PreAuthorize("isAuthenticated()")
//    @PreAuthorize("isAnonymous()")
//    @PreAuthorize("hasAuthority('어쩌구')")
    @GetMapping("/my-page")
    public String myPage(Authentication auth) {
        // auth : 현재 로그인된 유저의 정보가 들어있음, 이걸로 회원 기능 이것저것 만들 수 있음
        System.out.println(auth);
        System.out.println(auth.getName()); // kim
        System.out.println(auth.isAuthenticated()); // true -> 이게 true면 페이지 보여주는 식으로 할 수 있음
        return "mypage.html";
    }
}
