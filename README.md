SAML 2.0 Service Provider
====================

#### Spring Security SAML Extension

Spring SAML Extension allows seamless inclusion of SAML 2.0 Service Provider capabilities in Spring applications. All products supporting SAML 2.0 in Identity Provider mode (e.g. ADFS 2.0, Shibboleth, OpenAM/OpenSSO, Ping Federate, Okta) can be used to connect with Spring SAML Extension.

- **Website:** [http://projects.spring.io/spring-security-saml/](http://projects.spring.io/spring-security-saml/)

---------

## Project description

This project represents ASI's implementation of a **SAML 2.0 Service Provider**, completely built on **Spring Framework**. In particular, it shows how to develop a web solution devised for Federated Authentication, by integrating **Spring Boot** and **Spring Security SAML**. The configuration has been completely defined using *Java annotations* (no XML).

**SSOCircle** ([ssocircle.com](http://www.ssocircle.com/en/portfolio/publicidp/)) is used as public Identity Provider for test purpose.


#### Useful notes

1. The certificate on [https://idp.ssocircle.com/](https://idp.ssocircle.com/) seems to change on a fairly regular basis. This results in the following exception. 

	    javax.net.ssl.SSLPeerUnverifiedException: SSL peer failed hostname validation for name: null

    To update the certificates in the keystore run the following commands: 

		cd src/main/resources/saml/  
		./update-certifcate.sh 

2. Sometimes SSO Circle could display you an error during the authenticaton process. In this case, please update your federation metadata directly on [https://idp.ssocircle.com](https://idp.ssocircle.com):

	> Manage Metadata > Service Provider Metadata
	
	Remove the current record and add a new one, using your FQDN and providing a new copy of your metadata: your can retrieve them at [http://localhost:8080/saml/metadata](http://localhost:8080/saml/metadata).


Simple IDP for testing locally... 
https://github.com/mcguinness/saml-idp

Sample SP, the original code of this repo. 
https://github.com/vdenotaris/spring-boot-security-saml-sample

TEST IDP server
https://idp.ssocircle.com

