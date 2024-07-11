package com.example.spring_test.security;

import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final MyUserRepository myUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> user = myUserRepository.findByUserId(username);
        System.out.println("===== ===== ===== world1 ===== ===== =====");
        System.out.println(username);

        // Optional 타입이라면 user.isEmpty()
        if (user.isEmpty()) {
            System.out.println("그런 아이디 없어요.");
            throw new UsernameNotFoundException("그런 아이디 없어요.");
        }

        System.out.println("===== ===== ===== world2 ===== ===== =====");
        System.out.println(user.get());
        
        // 주고 싶은 권한 주기
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        //authorities.add(new SimpleGrantedAuthority("일반 사용자"));
        
        System.out.println("===== ===== ===== world3 ===== ===== =====");
        // 사용자 아이디, 비밀번호, 권한 리스트
        
        return new User(user.get().getUserId(), user.get().getPassword(), authorities);
        // 여기서 반환된 UserDetails 객체를 SecurityConfig에서 주입한
        // PasswordEncoder 객체를 통해 비밀번호 검사
    }
}

