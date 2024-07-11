package com.example.shop.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // DB에서 username을 가진 유저를 찾아와서
        // return new User(유저아이디, 비번, 권한) 해주세요

        var result = memberRepository.findByUsername(username);
        if (result.isEmpty()) {
            throw new UsernameNotFoundException("그런 아이디 없음");
        }
        var user = result.get();

        // [권한1, 권한2 ..]
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("일반유저")); // 값이 특별한 게 아니고 그냥 메모일 뿐임

        // 유저아이디, 비번, 권한
        var a = new CustomerUser(user.getUsername(), user.getPassword(), authorities);
        a.displayName = user.getDisplayName();
        return a;

        // 여기서 반환된 UserDetails 객체를 SecurityConfig에서 주입한
        // PasswordEncoder 객체를 통해 비밀번호 검사

        // 그러고 MemberContoller의 myPage 메서드의 Authentication 타입 파라미터에서 auth.getPrincipal()로 들어감(확인 필요)
        // 그래서 파라미너 auth에는 아이디, 비밀번호, 권한 같은 정보밖에 없는데 User 비슷한 CustomerUser 클래스를 하나 만들어허 해결
    }
}

class CustomerUser extends User {
    public String displayName;

    public CustomerUser(
            String username, String password, Collection<? extends GrantedAuthority> authorities
    ) {
        super(username, password, authorities);
    }
}