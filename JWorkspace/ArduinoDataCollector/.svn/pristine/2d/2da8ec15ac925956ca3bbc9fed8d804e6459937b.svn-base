package com.cymmetrik.javaldap;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.eclipse.jetty.server.Authentication.User;

public class RetrieveUserAttributes {
	public static void main(String[] args) {
        RetrieveUserAttributes retrieveUserAttributes = new RetrieveUserAttributes();
        retrieveUserAttributes.getUserBasicAttributes("010571", retrieveUserAttributes.getLdapContext());
        System.out.println(retrieveUserAttributes.getUserTelephone("010571", retrieveUserAttributes.getLdapContext()));
    }
 
    public LdapContext getLdapContext(){
        LdapContext ctx = null;
        try{
            Hashtable<String, String> env = new Hashtable<String, String>();
            env.put(Context.INITIAL_CONTEXT_FACTORY,
                    "com.sun.jndi.ldap.LdapCtxFactory");
            env.put(Context.SECURITY_AUTHENTICATION, "Simple");
            env.put(Context.SECURITY_PRINCIPAL, "cymmetrik\\outlook-ad2");
            env.put(Context.SECURITY_CREDENTIALS, "Chk@27852285");
            env.put(Context.PROVIDER_URL, "ldap://chq-dc-2.cymmetrik.com:389");
            ctx = new InitialLdapContext(env, null);
            //System.out.println("Connection Successful.");
        }catch(NamingException nex){
            System.out.println("LDAP Connection: FAILED");
            nex.printStackTrace();
        }
        return ctx;
    }
 
    private User getUserBasicAttributes(String username, LdapContext ctx) {
        User user=null;
        try {
 
            SearchControls constraints = new SearchControls();
            constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String[] attrIDs = { "distinguishedName",
                    "sn",
                    "givenname",
                    "mail",
                    "telephonenumber"};
            constraints.setReturningAttributes(attrIDs);
            //First input parameter is search bas, it can be "CN=Users,DC=YourDomain,DC=com"
            //Second Attribute can be uid=username
            NamingEnumeration<?> answer = ctx.search("DC=cymmetrik,DC=com", "sAMAccountName="
                    + username, constraints);
            if (answer.hasMore()) {
                Attributes attrs = ((SearchResult) answer.next()).getAttributes();
                System.out.println("distinguishedName "+ attrs.get("distinguishedName"));
                System.out.println("givenname "+ attrs.get("givenname"));
                System.out.println("sn "+ attrs.get("sn"));
                System.out.println("mail "+ attrs.get("mail"));
                System.out.println("telephonenumber "+ attrs.get("telephonenumber"));
            }else{
                throw new Exception("Invalid User");
            }
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    public String getUserTelephone(String username, LdapContext ctx) {
        String strTel="";
        try {
 
            SearchControls constraints = new SearchControls();
            constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
            String[] attrIDs = { "distinguishedName",
                    "sn",
                    "givenname",
                    "mail",
                    "telephonenumber"};
            constraints.setReturningAttributes(attrIDs);
            //First input parameter is search bas, it can be "CN=Users,DC=YourDomain,DC=com"
            //Second Attribute can be uid=username
            NamingEnumeration<?> answer = ctx.search("DC=cymmetrik,DC=com", "sAMAccountName="
                    + username, constraints);
            if (answer.hasMore()) {
                Attributes attrs = ((SearchResult) answer.next()).getAttributes();
                if(attrs.get("telephonenumber")!=null)
                	strTel = attrs.get("telephonenumber").toString().replace("telephoneNumber: ", "");
            }else{
                throw new Exception("Invalid User");
            }
 
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        return strTel;
    }
    
}
