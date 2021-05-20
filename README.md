# ldap-token-provider
Creates a jwt token from credentials that will be authenticated by an ldap server. Currently using [this](https://www.forumsys.com/tutorials/integration-how-to/ldap/online-ldap-test-server/) ldap demo server to authenticate requests.

## demo logins
All user names are password. You may also bind to individual Users (uid) or the two Groups (ou) that include:
* ou=mathematicians,dc=example,dc=com
   * riemann
   * gauss
   * euler
   * euclid
   * ou=scientists,dc=example,dc=com

* ou=scientists,dc=example,dc=com
   * einstein
   * newton
   * galieleo
   * tesla

* General Info
   * Server: ldap.forumsys.com  
   * Port: 389
   * Bind DN: cn=read-only-admin,dc=example,dc=com
   * Bind Password: password
