package org.mrTender.users.service;

import java.util.List;
import java.util.Set;

import org.mrTender.users.dao.UserDao;
import org.mrTender.users.model.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class TenderUserDetailsService implements UserDetailsService {
	
	UserDao userDao;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		org.mrTender.users.model.User user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());
		return buildUserForAuthentication(user, authorities);
	}
	
	// Converts com.mkyong.users.model.User user to
		// org.springframework.security.core.userdetails.User
		private User buildUserForAuthentication(org.mrTender.users.model.User user, 
			List<GrantedAuthority> authorities) {
				return new User(user.getUsername(), 
								user.getPassword(), 
								user.isEnabled(), 
								true, 
								true, 
								true, 
								authorities);
			
		}
		
		private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {
			return null;
			
		}

		public UserDao getUserDao() {
			return userDao;
		}

		public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
		}

}
