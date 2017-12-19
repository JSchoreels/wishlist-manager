# wishlist-manager
A simple project to handle wishlists

USAGE :

Firstly, build the following project by using mvn :
mvn clean install

If you don't have any MYSQL running or want to test this app with an emmbedded H2 database, just run :
java -jar -Dspring.profiles.active=embeddeddb wishlist-manager-springboot/target/wishlist-manager-springboot-1.0.0-SNAPSHOT.jar
