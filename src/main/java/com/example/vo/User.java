package com.example.vo;

import java.util.Collection;
import java.util.Date;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class User implements UserDetails {

  private static final long serialVersionUID = 3147530401709016801L;

  private int no;
  private String name;
  private String password;
  private String nickname;
  private String email;
  private String disabled;
  private Date updatedDate;
  private Date createdDate;
  private Collection<? extends GrantedAuthority> authorities;

  // 사용자 아이디를 반환하는 기능
  @Override
  public String getUsername() {
    return name;
  }

  // 계정만료 여부를 반환하는 기능
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  // 계정잠김 여부를 반환하는 기능
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  // 비밀번호 만료여부를 반환하는 기능
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  // 사용 중인 계정 여부를 반환하는 기능
  @Override
  public boolean isEnabled() {
    return disabled.equals("N");
  }

}
