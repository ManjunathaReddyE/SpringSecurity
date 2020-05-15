/*class Name:CustomAuthenticationProvider 
 *Description:- This class is implementing AuthenticationProvider interface to provide securities based on the roles*/
package com.jcg.authentication;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.jcg.controller.DBUtil;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider
{
		@Override
		public Authentication authenticate(Authentication authentication) throws AuthenticationException
		{
			System.out.println("authenticate  in 1 method in custom authenticatioprovider--");
				String userName = authentication.getName();
				String password = authentication.getCredentials().toString();
				String roleuser=authorizedUser(userName, password);
				if (roleuser.equals("admin"))
				{
						List<GrantedAuthority> grantedAuths = new ArrayList<>();
						grantedAuths.add(()-> {return "admin";});
						Authentication auth = new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);
						System.out.println("authorities admin"+  auth.getAuthorities());
						return auth;
				}
				else if(roleuser.equals("customer"))
				{
					List<GrantedAuthority> grantedAuths = new ArrayList<>();
					grantedAuths.add(()-> {return "customer";});
					Authentication auth = new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);
					System.out.println("authorities customer"+  auth.getAuthorities());
					return auth;
					
			}else if(roleuser.equals("manager"))
			{
				List<GrantedAuthority> grantedAuths = new ArrayList<>();
				grantedAuths.add(()-> {return "manager";});
				Authentication auth = new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);
				System.out.println("authorities in manager "+  auth.getAuthorities());
				return auth;
			}
			else if(roleuser.equals("agent"))
			{
				List<GrantedAuthority> grantedAuths = new ArrayList<>();
				grantedAuths.add(()-> {return "agent";});
				Authentication auth = new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);
				System.out.println("authorities in agent "+  auth.getAuthorities());
				return auth;
			}
				else
				{
						throw new AuthenticationCredentialsNotFoundException("Invalid Credentials!");
				}
			}

		public String authorizedUser(String userName, String password)
		{
			DBUtil util=new DBUtil();
			
			String role=util.getUserRole(userName);
			
			if(role.equals("admin"))
			{
				return "admin";
			}
			else if(role.equals("customer"))
			{
				return "customer";
			}
			else if(role.equals("manager"))
			{
				return "manager";
			}
			else if(role.equals("agent"))
			{
				return "agent";
			}
			else {
				return "default";
			}
		}

		@Override
		public boolean supports(Class<?> authentication)
		{
			System.out.println("support in customauthentication  "+  authentication+"  "+UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
				return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
		}
}