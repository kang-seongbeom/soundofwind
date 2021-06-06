package ac.kr.soundofwind.config.auth;

import ac.kr.soundofwind.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class PrincipalDetail implements UserDetails {

    private final User user;

    public PrincipalDetail(User user){
        this.user=user;
    }

    //권한
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors=new ArrayList<GrantedAuthority>();
        collectors.add(()->{
            //GrantedAuthority의 getAuthority함수를 사용한 것.
            return "ROLE_"+user.getRole(); //spring에서 역할에 대해 리턴을 받을 때 'ROLE_'를 꼭 넣어야함(규칙)
        });
        return collectors;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    //계정이 만료되지 않았는지 리턴(true:만료되지 않음)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //계정이 잠겨 있는지 리턴(true:만료되지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //비밀번호가 만료 되었는지 리턴(true:만료되지 않음)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //계정 활성화가 되었는지 확인(true:만료되지 않음)
    @Override
    public boolean isEnabled() {
        return true;
    }
}