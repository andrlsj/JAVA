package com.cymmetrik.javaldap;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class JavaAuthentication {
	public static void main(String[] args)
	{
		System.out.println(authenticate("chq-dc-2.cymmetrik.com", "010571", "Wen030106").toString());
		System.out.println(authenticate("chk-dc-2.cymmetrik.com", "010571", "Wen030106").toString());
	}
	
	public static Boolean authenticate(String adip,String username,String password){
		
		if("".equals(adip) || "".equals(password) || "".equals(username))
		{
			return false;
		}
		DirContext ctx = null;
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "Ldap://"+ adip +":389");		
		username = "cymmetrik\\"+username;	
		//username = username + "@cymmetrik.com";
		env.put(Context.SECURITY_PRINCIPAL, username);
		env.put(Context.SECURITY_CREDENTIALS, password);
//		env.put(Context.REFERRAL, "throw");
//		env.put(Context.SECURITY_AUTHENTICATION,"simple");
		try {
			ctx = new InitialDirContext(env);
			//System.out.println(ctx.toString());
			return true;	// "驗証通過"
		} catch (AuthenticationException authe) {
			System.out.println(authe.toString());
			return false;	//	"驗証失敗"
		} catch (NamingException e) {
			return false;
		} finally {
			try {
				ctx.close();
			} catch (Exception Ignore) {
			}
		}

	}

}
