package com.mysearch.work.member;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mysearch.work.entity.Member;

import lombok.Data;

@Data
public class MemberDetail implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private Member member;

	public MemberDetail(Member member) {
		this.member = member;
	}
	
	public Long getMbrId() {
		return member.getMbrId();
	};
		
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(member.getRole()));
		return authorities;
	}
	
	@Override
	public String getPassword() {
		return member.getPassword();
	}

	@Override
	public String getUsername() {
		return member.getUsername();
	}
	

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override public boolean isAccountNonLocked() { 
		return true; 
	}
	@Override public boolean isCredentialsNonExpired() {
		return true; 
	} 
	@Override 
	public boolean isEnabled() {
		return true; 
	}	

}
